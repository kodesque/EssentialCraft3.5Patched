package ec3.dummycore.utils;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import ec3.dummycore.core.CoreInitializer;
import ec3.dummycore.events.DummyEvent_OnPacketRecieved;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
public class DummyPacketHandler implements IMessageHandler<DummyPacketIMSG, IMessage> {

    @Override
    public IMessage onMessage(DummyPacketIMSG message, MessageContext ctx) {
        Side s = ctx.side;
        if (s == Side.CLIENT) {
            MinecraftForge.EVENT_BUS.post(
                new DummyEvent_OnPacketRecieved(
                    s,
                    message.dataStr,
                    CoreInitializer.proxy.getPlayerOnSide(ctx.getClientHandler())));
        } else {
            MinecraftForge.EVENT_BUS.post(
                new DummyEvent_OnPacketRecieved(
                    s,
                    message.dataStr,
                    CoreInitializer.proxy.getPlayerOnSide(ctx.getServerHandler())));
        }
        return null;
    }

    public static void sendToAll(DummyPacketIMSG message) {
        CoreInitializer.network.sendToAll(message);
    }

    public static void sendToAllAround(DummyPacketIMSG message, TargetPoint pnt) {
        CoreInitializer.network.sendToAllAround(message, pnt);
    }

    public static void sendToAllAround(DummyPacketIMSG message, int dim) {
        CoreInitializer.network.sendToDimension(message, dim);
    }

    public static void sendToPlayer(DummyPacketIMSG message, EntityPlayerMP player) {
        CoreInitializer.network.sendTo(message, (EntityPlayerMP) player);
    }

    public static void sendToServer(DummyPacketIMSG message) {
        CoreInitializer.network.sendToServer(message);
    }

}
