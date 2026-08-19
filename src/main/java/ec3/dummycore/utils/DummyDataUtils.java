package ec3.dummycore.utils;

import DummyCore.Utils.MiscUtils;
import DummyCore.Utils.Notifier;
import DummyCore.Utils.SyncUtils;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.world.WorldEvent;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class DummyDataUtils {
    private static Configuration globalConfig;
    private static Hashtable<String, File> playerFiles = new Hashtable();
    private static Hashtable<String, Configuration> playerConfigs = new Hashtable();
    private static String getPath;
    private static boolean isWorking;
    private static File directory;

    public DummyDataUtils() {
    }

    @SubscribeEvent
    public void serverWorldLoad(WorldEvent.Load event) {
        try {
            World w = event.world;
            if (w != null && !w.field_72995_K && w.field_73011_w != null && w.field_73011_w.field_76574_g == 0) {
                File f = event.world.func_72860_G().func_75765_b();
                if (f != null) {
                    String fPath = f.getAbsolutePath();
                    String dDataPath = fPath + "//DummyData//";
                    directory = new File(dDataPath);
                    directory.mkdirs();
                    File globalDataDat = new File(directory + "//GlobalData.ddat");
                    File f1 = new File(directory + "//PlayerData//");
                    f1.mkdirs();
                    getPath = dDataPath;
                    globalConfig = new Configuration(globalDataDat);
                    isWorking = true;
                }
            }

        } catch (Exception e) {
            Notifier.notifyCustomMod("DummyCore", "Error loading DummyData!");
            e.printStackTrace();
        }
    }

    /** @deprecated */
    @Deprecated
    public static void load(FMLServerAboutToStartEvent event) {
        String name = event.getServer().func_71209_f(event.getServer().func_71270_I()).getAbsolutePath();
        int length = 0;
        boolean shouldAddSaves = true;

        for(int i = 0; i < name.length(); ++i) {
            if (name.substring(0, i).contains("\\.\\")) {
                shouldAddSaves = true;
                --length;
                --length;
                break;
            }

            ++length;
        }

        String print = name.substring(0, length);
        if (shouldAddSaves) {
            print = print + "saves\\";
            print = print + event.getServer().func_71270_I();
        }

        print = print + "\\DummyData\\";
        File f = new File(print);
        f.mkdirs();
        File file = new File(print + "GlobalData.ddat");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        File f1 = new File(print + "/PlayerData/");
        f1.mkdirs();
        getPath = print;
        globalConfig = new Configuration(file);
        isWorking = true;
    }

    public static void stop() {
        globalConfig = null;
        playerFiles.clear();
        playerConfigs.clear();
        getPath = "no path";
        isWorking = false;
        directory = null;
        MiscUtils.registeredClientData.clear();
        MiscUtils.registeredClientWorldData.clear();
        MiscUtils.registeredServerData.clear();
        MiscUtils.registeredServerWorldData.clear();
    }

    private static File getDataFileForPlayer(String playerName) {
        if (!playerFiles.containsKey(playerName)) {
            File ret = new File(getPath + "/PlayerData/" + playerName + ".ddat");
            if (!ret.exists()) {
                try {
                    ret.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            playerFiles.put(playerName, ret);
            return ret;
        } else {
            return (File)playerFiles.get(playerName);
        }
    }

    private static Configuration getDataConfigForPlayer(String playerName) {
        if (!canWorkWithData()) {
            return null;
        } else {
            if (!playerConfigs.containsKey(playerName)) {
                playerConfigs.put(playerName, new Configuration(getDataFileForPlayer(playerName)));
            }

            return (Configuration)playerConfigs.get(playerName);
        }
    }

    public static void writeCustomDataForMod(String modid, String dataName, String dataString) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            MiscUtils.registeredClientWorldData.put(modid + "|" + dataName, dataString);
        } else {
            if (!canWorkWithData()) {
                return;
            }

            globalConfig.load();
            globalConfig.get(modid, dataName, dataString).set(dataString);
            MiscUtils.registeredServerWorldData.put(modid + "|" + dataName, dataString);
            globalConfig.save();
            syncGlobalDataToClient(modid, dataName);
        }

    }

    public static void loadCustomDataForMod(String modid, String dataName) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s != Side.CLIENT) {
            if (canWorkWithData()) {
                globalConfig.load();
                MiscUtils.registeredServerWorldData.put(modid + "|" + dataName, globalConfig.get(modid, dataName, "no data").getString());
                globalConfig.save();
                syncGlobalDataToClient(modid, dataName);
            }
        }
    }

    public static void loadGlobalDataForMod(String modid) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s != Side.CLIENT) {
            if (canWorkWithData()) {
                globalConfig.load();
                MiscUtils.registeredServerWorldData.put(modid + "|" + modid, globalConfig.get(modid, modid, "no data").getString());
                globalConfig.save();
                syncGlobalDataToClient(modid, modid);
            }
        }
    }

    public static void writeGlobalDataForMod(String modid, String dataString) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            MiscUtils.registeredClientWorldData.put(modid + "|" + modid, dataString);
        } else {
            if (!canWorkWithData()) {
                return;
            }

            globalConfig.load();
            globalConfig.get(modid, modid, dataString).set(dataString);
            MiscUtils.registeredServerWorldData.put(modid + "|" + modid, dataString);
            globalConfig.save();
            syncGlobalDataToClient(modid);
        }

    }

    public static String getGlobalDataForMod(String modid) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            return (String)MiscUtils.registeredClientWorldData.get(modid + "|" + modid);
        } else {
            if (!MiscUtils.registeredServerWorldData.containsKey(modid + "|" + modid)) {
                loadGlobalDataForMod(modid);
            }

            return (String)MiscUtils.registeredServerWorldData.get(modid + "|" + modid);
        }
    }

    public static String getCustomDataForMod(String modid, String dataName) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            return (String)MiscUtils.registeredClientWorldData.get(modid + "|" + dataName);
        } else {
            if (!MiscUtils.registeredServerWorldData.containsKey(modid + "|" + dataName)) {
                loadCustomDataForMod(modid, dataName);
            }

            return (String)MiscUtils.registeredServerWorldData.get(modid + "|" + dataName);
        }
    }

    public static void setDataForPlayer(String playerName, String modid, String dataName, String dataValue) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            MiscUtils.registeredClientData.put(playerName + "_" + modid + "|" + dataName, dataValue);
        } else {
            if (!canWorkWithData()) {
                return;
            }

            Configuration config = getDataConfigForPlayer(playerName);
            config.load();
            config.get(modid, dataName, dataValue).set(dataValue);
            MiscUtils.registeredServerData.put(playerName + "_" + modid + "|" + dataName, dataValue);
            config.save();
            syncPlayerDataToClient(playerName, modid, dataName);
        }

    }

    public static void loadPlayerDataForMod(String playerName, String modid, String dataName) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s != Side.CLIENT) {
            if (canWorkWithData()) {
                Configuration config = getDataConfigForPlayer(playerName);
                config.load();
                MiscUtils.registeredServerData.put(playerName + "_" + modid + "|" + dataName, config.get(modid, dataName, "no data").getString());
                config.save();
                syncPlayerDataToClient(playerName, modid, dataName);
            }
        }
    }

    public static String getDataForPlayer(String playerName, String modid, String dataName) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            return (String)MiscUtils.registeredClientData.get(playerName + "_" + modid + "|" + dataName);
        } else {
            if (!MiscUtils.registeredServerData.containsKey(playerName + "_" + modid + "|" + dataName)) {
                loadPlayerDataForMod(playerName, modid, dataName);
            }

            return (String)MiscUtils.registeredServerData.get(playerName + "_" + modid + "|" + dataName);
        }
    }

    public static boolean canWorkWithData() {
        return isWorking;
    }

    public static void syncGlobalDataToClient(String modid, String dataName) {
        SyncUtils.addRequiresSync(modid, dataName);
    }

    public static void syncGlobalDataToClient(String modid) {
        SyncUtils.addRequiresSync(modid, modid);
    }

    public static void syncPlayerDataToClient(String playerName, String modid, String dataName) {
        SyncUtils.addRequiresSync(playerName, modid, dataName);
    }
}
