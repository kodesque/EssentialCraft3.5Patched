package ec3.dummycore.utils;

import DummyCore.Client.GuiButton_ChangeGUI;
import DummyCore.Client.MainMenuRegistry;
import DummyCore.Events.DummyEvent_OnClientGUIButtonPress;
import DummyCore.Events.DummyEvent_OnKeyboardKeyPressed_Server;
import DummyCore.Events.DummyEvent_OnPacketRecieved;
import DummyCore.Utils.DataStorage;
import DummyCore.Utils.DummyConfig;
import DummyCore.Utils.DummyData;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import java.util.Arrays;
import java.util.List;

public class DummyEventHandler {
    public static int syncTime;
    public static boolean[] isKeyPressed;

    public DummyEventHandler() {
    }

    public void onBlockBeeingBroken(PlayerEvent.BreakSpeed event) {
        if (MiscUtils.isBlockUnbreakable(event.entityPlayer.field_70170_p, event.x, event.y, event.z)) {
            event.setCanceled(true);
        }

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onMainMenuGUISetup(GuiScreenEvent.InitGuiEvent.Pre event) {
        if (event.gui.getClass() == GuiMainMenu.class) {
            event.setCanceled(true);
            MainMenuRegistry.newMainMenu(DummyCore.Utils.DummyConfig.getMainMenu());
        }

        if (event.gui instanceof IMainMenu && MainMenuRegistry.menuList.get(DummyCore.Utils.DummyConfig.getMainMenu()) != event.gui.getClass()) {
            event.setCanceled(true);
            MainMenuRegistry.newMainMenu(DummyCore.Utils.DummyConfig.getMainMenu());
        }

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onMainMenuGUISetup(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.gui instanceof IMainMenu) {
            event.buttonList.add(new GuiButton_ChangeGUI(65535, event.gui.field_146294_l / 2 + 104, event.gui.field_146295_m / 4 + 24 + 72, 100, 20, "Change Main Menu"));
        }

    }

    @SubscribeEvent
    public void onPacketRecieved(DummyEvent_OnPacketRecieved event) {
        DummyCore.Utils.DummyData[] packetData = DataStorage.parseData(event.recievedData);
        if (packetData != null && packetData.length > 0) {
            try {
                DummyCore.Utils.DummyData modData = packetData[0];
                if (modData.fieldName.equalsIgnoreCase("mod") && modData.fieldValue.equalsIgnoreCase("dummycore.tilesync")) {
                    int x = Integer.parseInt(packetData[1].fieldValue);
                    int y = Integer.parseInt(packetData[2].fieldValue);
                    int z = Integer.parseInt(packetData[3].fieldValue);
                    TileEntity tile = event.recievedEntity.field_70170_p.func_147438_o(x, y, z);
                    if (tile != null && tile instanceof ITEHasGameData) {
                        DummyCore.Utils.DummyData[] tileShouldRecieve = (DummyCore.Utils.DummyData[]) Arrays.copyOfRange(packetData, 4, packetData.length);
                        ((ITEHasGameData)tile).setData(tileShouldRecieve);
                    }
                }

                if (modData.fieldName.equalsIgnoreCase("mod") && modData.fieldValue.equalsIgnoreCase("dummycore.particle")) {
                    String type = packetData[1].fieldValue;
                    float x = Float.parseFloat(packetData[2].fieldValue);
                    float y = Float.parseFloat(packetData[3].fieldValue);
                    float z = Float.parseFloat(packetData[4].fieldValue);
                    double r = Double.parseDouble(packetData[5].fieldValue);
                    double g = Double.parseDouble(packetData[6].fieldValue);
                    double b = Double.parseDouble(packetData[7].fieldValue);
                    event.recievedEntity.field_70170_p.func_72869_a(type, (double)x, (double)y, (double)z, r, g, b);
                }

                if (modData.fieldName.equalsIgnoreCase("mod") && modData.fieldValue.equalsIgnoreCase("dummycore.infosync")) {
                    String modName = packetData[1].fieldName;
                    String dataName = packetData[1].fieldValue;
                    String dataItself = event.recievedData.substring(event.recievedData.indexOf("||ddata:") + 8);
                    MiscUtils.registeredClientWorldData.put(modName + "|" + dataName, dataItself);
                }

                if (modData.fieldName.equalsIgnoreCase("mod") && modData.fieldValue.equalsIgnoreCase("dummycore.playerinfosync")) {
                    String playerName = packetData[1].fieldValue;
                    String modName = packetData[2].fieldName;
                    String dataName = packetData[2].fieldValue;
                    String dataItself = event.recievedData.substring(event.recievedData.indexOf("||ddata:") + 8);
                    MiscUtils.registeredClientData.put(playerName + "_" + modName + "|" + dataName, dataItself);
                }

                if (modData.fieldName.equalsIgnoreCase("mod") && modData.fieldValue.equalsIgnoreCase("dummycore.biomechange")) {
                    int x = Integer.parseInt(packetData[1].fieldValue);
                    int z = Integer.parseInt(packetData[2].fieldValue);
                    int id = Integer.parseInt(packetData[3].fieldValue);
                    World world = event.recievedEntity.field_70170_p;
                    Chunk chunk = world.func_72938_d(x, z);
                    byte[] biome = chunk.func_76605_m();
                    byte var10000 = biome[(z & 15) << 4 | x & 15];
                    int cbiome = id & 255;
                    biome[(z & 15) << 4 | x & 15] = (byte)cbiome;
                    chunk.func_76616_a(biome);
                    world.func_72975_g(x, z, 16, 16);
                }

                if (modData.fieldName.equalsIgnoreCase("mod") && modData.fieldValue.equalsIgnoreCase("dummyCore.buttonpress")) {
                    int id = Integer.parseInt(packetData[1].fieldValue);
                    String name = packetData[2].fieldValue;
                    String username = packetData[3].fieldValue;
                    boolean pressed = Boolean.parseBoolean(packetData[4].fieldValue);
                    Side side = FMLCommonHandler.instance().getEffectiveSide();
                    if (side == Side.SERVER) {
                        MinecraftServer server = MinecraftServer.func_71276_C();
                        ServerConfigurationManager manager = server.func_71203_ab();
                        EntityPlayer player = manager.func_152612_a(username);
                        MinecraftForge.EVENT_BUS.post(new DummyEvent_OnKeyboardKeyPressed_Server(id, name, player, pressed));
                    }
                }

                if (modData.fieldName.equalsIgnoreCase("mod") && modData.fieldValue.equalsIgnoreCase("dummyCore.guiButton")) {
                    int id = Integer.parseInt(packetData[1].fieldValue);
                    String pClName = packetData[2].fieldValue;
                    String bClName = packetData[3].fieldValue;
                    String username = packetData[4].fieldValue;
                    int x = Integer.parseInt(packetData[5].fieldValue);
                    int y = Integer.parseInt(packetData[6].fieldValue);
                    int z = Integer.parseInt(packetData[7].fieldValue);
                    DummyCore.Utils.DummyData[] data = new DummyData[packetData.length - 8];

                    for(int i = 8; i < packetData.length; ++i) {
                        data[i - 8] = packetData[i];
                    }

                    Side side = FMLCommonHandler.instance().getEffectiveSide();
                    if (side == Side.SERVER) {
                        MinecraftServer server = MinecraftServer.func_71276_C();
                        ServerConfigurationManager manager = server.func_71203_ab();
                        EntityPlayer player = manager.func_152612_a(username);
                        MinecraftForge.EVENT_BUS.post(new DummyEvent_OnClientGUIButtonPress(id, pClName, bClName, player, x, y, z, data));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

    }

    @SubscribeEvent
    public void onDescrAdded(ItemTooltipEvent event) {
        ItemStack stack = event.itemStack;
        String unlocName = stack.func_77977_a();
        if (MiscUtils.descriptionTable.containsKey(unlocName)) {
            event.toolTip.add(MiscUtils.descriptionCTable.get(unlocName) + (String)MiscUtils.descriptionTable.get(unlocName));
        } else {
            stack.func_77973_b();
            List<? extends Object> list = Arrays.asList(Item.field_150901_e.func_148750_c(stack.func_77973_b()), stack.func_77960_j());
            if (MiscUtils.descriptionNTable.containsKey(list)) {
                event.toolTip.add(MiscUtils.descriptionNCTable.get(list) + (String)MiscUtils.descriptionNTable.get(list));
            }
        }

    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ++syncTime;
            if (syncTime >= DummyConfig.dummyCoreSyncTimer) {
                syncTime = 0;
                SyncUtils.makeSync_LotsSmallPackets();
            }
        }

    }
}
