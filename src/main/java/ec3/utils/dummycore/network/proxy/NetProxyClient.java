package ec3.utils.dummycore.network.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

import com.google.common.collect.SetMultimap;
import com.google.common.collect.Table;

import cpw.mods.fml.client.FMLClientHandler;
import ec3.utils.dummycore.config.DummyConfig;
import ec3.utils.dummycore.core.CoreInitializer;
import ec3.utils.dummycore.utils.GuiContainerLibrary;
import ec3.utils.dummycore.utils.TimerHijack;
import ec3.utils.dummycore.utils.system.Notifier;

public class NetProxyClient extends NetProxyServer {

    public static final Hashtable<String, ShaderGroup> shaders = new Hashtable<String, ShaderGroup>();

    @Override
    public EntityPlayer getPlayerOnSide(INetHandler handler) {
        if (handler instanceof NetHandlerPlayClient) {
            return Minecraft.getMinecraft().thePlayer;
        }
        return null;
    }

    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public void registerInfo() {
        TimerHijack.initMCTimer();
    }

    @Override
    public void registerInit() {
        if (((DummyConfig) CoreInitializer.cfg).removeMissingTexturesErrors) {
            try {
                Class<TextureMap> textureMap = TextureMap.class;
                Field logger = textureMap.getDeclaredFields()[0];
                boolean canAccess = logger.isAccessible();
                if (!canAccess) logger.setAccessible(true);
                Logger lg = Logger.class.cast(logger.get(null));
                lg.setLevel(Level.OFF);

                if (!canAccess) logger.setAccessible(false);
            } catch (Exception e) {
                Notifier.notifyError("DummyCore was sadly unable to remove missing texture errors :(");
            }
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        try {
            Class<?> guiClass = Class.forName(GuiContainerLibrary.guis.get(ID));
            Constructor<?> constrctr_gui = guiClass.getConstructor(Container.class, TileEntity.class);
            Class<?> containerClass = Class.forName(GuiContainerLibrary.containers.get(ID));
            Constructor<?> constrctr = containerClass.getConstructor(InventoryPlayer.class, TileEntity.class);
            Object obj = constrctr.newInstance(player.inventory, world.getTileEntity(x, y, z));
            return constrctr_gui.newInstance(obj, world.getTileEntity(x, y, z));
        } catch (Exception e) {
            Notifier.notifySimple("Unable to open GUI for ID " + ID);
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void removeMissingTextureErrors() {
        if (((DummyConfig) CoreInitializer.cfg).removeMissingTexturesErrors) {
            try {
                Class<FMLClientHandler> fmlClientHandler = FMLClientHandler.class;
                Field missingTextures = fmlClientHandler.getDeclaredField("missingTextures");
                Field badTextureDomains = fmlClientHandler.getDeclaredField("badTextureDomains");
                Field brokenTextures = fmlClientHandler.getDeclaredField("brokenTextures");
                boolean canAccess = missingTextures.isAccessible();
                if (!canAccess) missingTextures.setAccessible(true);

                SetMultimap<String, ResourceLocation> smmp = SetMultimap.class
                    .cast(missingTextures.get(FMLClientHandler.instance()));
                smmp.clear();

                if (!canAccess) missingTextures.setAccessible(false);

                canAccess = badTextureDomains.isAccessible();
                if (!canAccess) badTextureDomains.setAccessible(true);

                Set<String> set = Set.class.cast(badTextureDomains.get(FMLClientHandler.instance()));
                set.clear();

                if (!canAccess) badTextureDomains.setAccessible(false);

                canAccess = brokenTextures.isAccessible();
                if (!canAccess) brokenTextures.setAccessible(true);

                Table<String, String, Set<ResourceLocation>> table = Table.class
                    .cast(brokenTextures.get(FMLClientHandler.instance()));
                table.clear();

                if (!canAccess) brokenTextures.setAccessible(false);

                Notifier.notifyWarn(
                    "DummyCore has removed all possible texture errors the FML could output to the console!");
            } catch (Exception e) {
                Notifier.notifyError("DummyCore was sadly unable to remove missing texture errors :(");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initShaders(ResourceLocation rLoc) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityRenderer er = mc.entityRenderer;
        try {
            if (rLoc == null) {
                er.deactivateShader();
            } else {
                er.theShaderGroup = new ShaderGroup(
                    mc.getTextureManager(),
                    mc.getResourceManager(),
                    mc.getFramebuffer(),
                    rLoc);
                er.theShaderGroup.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
            }
        } catch (Exception e) {
            return;
        }
    }

}
