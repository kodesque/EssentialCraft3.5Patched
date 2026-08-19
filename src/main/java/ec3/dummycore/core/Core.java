package ec3.dummycore.core;

import DummyCore.CreativeTabs.CreativePageBlocks;
import DummyCore.CreativeTabs.CreativePageItems;
import DummyCore.Utils.EnumLightColor;
import DummyCore.Utils.IDummyConfig;
import DummyCore.Utils.Notifier;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Core {
    public static List<Block> lightBlocks = new ArrayList();
    public static List<EnumLightColor> lightColors = new ArrayList();
    private static HashMap<Class<?>, Integer> modList = new HashMap();
    private static HashMap<Integer, Configuration> configurationList = new HashMap();
    private static List<String> modNameList = new ArrayList();
    private static CreativeTabs[] blocksTabs = new CreativeTabs[512];
    private static CreativeTabs[] itemsTabs = new CreativeTabs[512];
    private static Configuration[] config = new Configuration[512];
    private static IDummyConfig[] configurationHandlers = new IDummyConfig[512];
    private static boolean[] isConfigLoaded = new boolean[512];

    public Core() {
    }

    private static void registerMod(Class<?> c, String name) throws RuntimeException {
        if (!modList.containsKey(c)) {
            int modId = getNextModId();
            if (modId >= 0 && modId < 512) {
                modList.put(c, modId);
                modNameList.add(modId, name);
                blocksTabs[modId] = new CreativePageBlocks(name);
                itemsTabs[modId] = new CreativePageItems(name);
                Notifier.notifySimple("Mod with name " + name + " and classpath " + c.getName() + ".class using ID " + modId + " has been succesfully registered!");
            } else {
                throw new RuntimeException("Mod " + name + " is trying to be registered with wrong id " + modId);
            }
        } else {
            throw new RuntimeException("Mod " + name + " is already registered!");
        }
    }

    private static void registerConfigurationFileForMod(Class<?> c, String path) throws IOException {
        File file = new File(path, getModName(getIdForMod(c)) + ".cfg");
        if (!file.exists()) {
            file.createNewFile();
        }

        config[getIdForMod(c)] = new Configuration(file);
        config[getIdForMod(c)].save();
        configurationList.put(getIdForMod(c), config[getIdForMod(c)]);
        Notifier.notifySimple("Configuration File for mod " + getModName(getIdForMod(c)) + " was successfully created with path " + path + getModName(getIdForMod(c)) + ".cfg");
    }

    public static void registerModAbsolute(Class<?> c, String modname, String configPath, IDummyConfig config) throws IOException {
        registerMod(c, modname);
        registerConfigurationFileForMod(c, configPath);
        registerConfigurationHandler(config, c);
        loadConfigForMod(getIdForMod(c));
    }

    private static int getNextModId() {
        int i;
        for(i = 0; i < 512 && modList.containsValue(i); ++i) {
        }

        return i;
    }

    public static int getIdForMod(Class<?> m) {
        return modList.containsKey(m) ? (Integer)modList.get(m) : 0;
    }

    public static String getModName(int i) {
        return (String)modNameList.get(i);
    }

    public static Configuration getConfigFileForMod(Class<?> c) {
        return config[getIdForMod(c)];
    }

    private static void registerConfigurationHandler(IDummyConfig config, Class<?> c) throws RuntimeException {
        int modId = getIdForMod(c);
        if (configurationHandlers[modId] == null) {
            configurationHandlers[modId] = config;
        } else {
            throw new RuntimeException("Configuration handler for mod " + getModName(modId) + " is already registered!");
        }
    }

    private static void loadConfigForMod(int t) throws RuntimeException {
        if (isConfigLoaded[t]) {
            throw new RuntimeException("Configuration handler was already initialised!");
        } else {
            if (configurationHandlers[t] != null && config[t] != null) {
                config[t].load();
                configurationHandlers[t].load(config[t]);
                config[t].save();
            } else if ((configurationHandlers[t] != null || config[t] == null) && configurationHandlers[t] != null && config[t] == null) {
            }

            isConfigLoaded[t] = true;
        }
    }

    public static CreativeTabs getItemTabForMod(Class<?> c) {
        return itemsTabs[getIdForMod(c)];
    }

    public static CreativeTabs getBlockTabForMod(Class<?> c) {
        return blocksTabs[getIdForMod(c)];
    }
}
