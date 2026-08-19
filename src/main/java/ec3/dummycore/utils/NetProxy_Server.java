package ec3.dummycore.utils;

import DummyCore.CreativeTabs.CreativePageBlocks;
import DummyCore.CreativeTabs.CreativePageItems;
import DummyCore.Utils.GuiContainerLibrary;
import DummyCore.Utils.Notifier;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.lang.reflect.Constructor;

public class NetProxy_Server implements IGuiHandler {
    public NetProxy_Server() {
    }

    public EntityPlayer getPlayerOnSide(INetHandler handler) {
        return handler instanceof NetHandlerPlayServer ? ((NetHandlerPlayServer)handler).field_147369_b : null;
    }

    public void registerInfo() {
    }

    public void registerInit() {
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        try {
            Class<?> containerClass = Class.forName((String) GuiContainerLibrary.containers.get(ID));
            Constructor<?> constrctr = containerClass.getConstructor(InventoryPlayer.class, TileEntity.class);
            return constrctr.newInstance(player.field_71071_by, world.func_147438_o(x, y, z));
        } catch (Exception e) {
            Notifier.notifySimple("Unable to open Container for ID " + ID);
            e.printStackTrace();
            return null;
        }
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    public void initShaders(ResourceLocation rLoc) {
    }

    public void choseDisplayStack(CreativePageBlocks blocks) {
    }

    public void choseDisplayStack(CreativePageItems items) {
    }
}
