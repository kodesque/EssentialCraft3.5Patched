package ec3.dummycore.utils;

import DummyCore.Client.GuiMainMenuOld;
import DummyCore.Client.GuiMainMenuVanilla;
import DummyCore.Client.MainMenuRegistry;
import DummyCore.Core.CoreInitialiser;
import DummyCore.CreativeTabs.CreativePageBlocks;
import DummyCore.CreativeTabs.CreativePageItems;
import DummyCore.Utils.DummyConfig;
import DummyCore.Utils.GuiContainerLibrary;
import DummyCore.Utils.NetProxy_Server;
import DummyCore.Utils.Notifier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.util.Hashtable;
import java.util.Random;

public class NetProxy_Client extends NetProxy_Server {
    public static final Hashtable<String, ShaderGroup> shaders = new Hashtable();

    public NetProxy_Client() {
    }

    public EntityPlayer getPlayerOnSide(INetHandler handler) {
        return handler instanceof NetHandlerPlayClient ? Minecraft.func_71410_x().field_71439_g : null;
    }

    public void registerInfo() {
        MainMenuRegistry.registerNewGui(GuiMainMenuVanilla.class, "[DC] Vanilla", "Just a simple vanilla MC gui.");
        MainMenuRegistry.registerNewGui(GuiMainMenuOld.class, "[DC] Old Vanilla", "An old MC gui.");
    }

    public void registerInit() {
        if (CoreInitialiser.cfg.removeMissingTexturesErrors) {
            Logger logger = LogManager.getLogger(TextureMap.class);
            org.apache.logging.log4j.core.Logger log = (org.apache.logging.log4j.core.Logger)logger;
            log.setLevel(Level.OFF);
        }

    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        try {
            Class<?> guiClass = Class.forName((String) DummyCore.Utils.GuiContainerLibrary.guis.get(ID));
            Constructor<?> constrctr_gui = guiClass.getConstructor(Container.class, TileEntity.class);
            Class<?> containerClass = Class.forName((String) GuiContainerLibrary.containers.get(ID));
            Constructor<?> constrctr = containerClass.getConstructor(InventoryPlayer.class, TileEntity.class);
            Object obj = constrctr.newInstance(player.field_71071_by, world.func_147438_o(x, y, z));
            return constrctr_gui.newInstance(obj, world.func_147438_o(x, y, z));
        } catch (Exception e) {
            Notifier.notifySimple("Unable to open GUI for ID " + ID);
            e.printStackTrace();
            return null;
        }
    }

    public void initShaders(ResourceLocation rLoc) {
        Minecraft mc = Minecraft.func_71410_x();
        EntityRenderer er = mc.field_71460_t;

        try {
            if (rLoc == null) {
                er.func_147703_b();
            } else {
                er.field_147707_d = new ShaderGroup(mc.func_110434_K(), mc.func_110442_L(), mc.func_147110_a(), rLoc);
                er.field_147707_d.func_148026_a(mc.field_71443_c, mc.field_71440_d);
            }

        } catch (Exception var5) {
        }
    }

    public void choseDisplayStack(CreativePageBlocks blocks) {
        World w = Minecraft.func_71410_x().field_71441_e;
        if (w.field_72995_K && w.func_72820_D() % 60L == 0L) {
            blocks.delayTime = 0;
            blocks.blockList = blocks.initialiseBlocksList();
            if (blocks.blockList != null && !blocks.blockList.isEmpty()) {
                Random rand;
                if (DummyCore.Utils.DummyConfig.shouldChangeImage) {
                    rand = new Random(w.func_72820_D());
                } else {
                    rand = new Random(0L);
                }

                int random = rand.nextInt(blocks.blockList.size());
                ItemStack itm = (ItemStack)blocks.blockList.get(random);
                if (itm != null && itm.func_77973_b() != null) {
                    blocks.displayStack = itm;
                }
            }
        }

    }

    public void choseDisplayStack(CreativePageItems items) {
        World w = Minecraft.func_71410_x().field_71441_e;
        if (w.field_72995_K && w.func_72820_D() % 60L == 0L) {
            items.delayTime = 0;
            items.itemList = items.initialiseItemsList();
            if (items.itemList != null && !items.itemList.isEmpty()) {
                Random rand;
                if (DummyConfig.shouldChangeImage) {
                    rand = new Random(w.func_72820_D());
                } else {
                    rand = new Random(0L);
                }

                int random = rand.nextInt(items.itemList.size());
                ItemStack itm = (ItemStack)items.itemList.get(random);
                if (itm != null && itm.func_77973_b() != null) {
                    items.displayStack = itm;
                }
            }
        }

    }
}
