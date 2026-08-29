package ec3.utils.dummycore.network.handlers;

import ec3.utils.dummycore.network.packets.DummyPacket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import ec3.utils.dummycore.core.CoreInitializer;
import ec3.utils.dummycore.events.OnPacketRecieved;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
public class DummyPacketHandler implements IMessageHandler<DummyPacket, IMessage> {

    @Override
    public IMessage onMessage(DummyPacket message, MessageContext ctx) {
        Side s = ctx.side;
        if (s == Side.CLIENT) {
            MinecraftForge.EVENT_BUS.post(
                new OnPacketRecieved(
                    s,
                    message.dataStr,
                    CoreInitializer.proxy.getPlayerOnSide(ctx.getClientHandler())));
        } else {
            MinecraftForge.EVENT_BUS.post(
                new OnPacketRecieved(
                    s,
                    message.dataStr,
                    CoreInitializer.proxy.getPlayerOnSide(ctx.getServerHandler())));
        }
        return null;
    }

    public static void sendToAll(DummyPacket message) {
        if (message == null) return;
        CoreInitializer.network.sendToAll(message);
    }

    public static void sendToAllAround(DummyPacket message, TargetPoint pnt) {
        if (message == null || pnt == null) return;
        CoreInitializer.network.sendToAllAround(message, pnt);
    }

    public static void sendToAllAround(DummyPacket message, int dim) {
        if (message == null) return;
        CoreInitializer.network.sendToDimension(message, dim);
    }

    public static void sendToPlayer(DummyPacket message, EntityPlayerMP player) {
        if (message == null || player == null) return;
        CoreInitializer.network.sendTo(message, (EntityPlayerMP) player);
    }

    public static void sendToServer(DummyPacket message) {
        if (message == null) return;
        CoreInitializer.network.sendToServer(message);
    }

}
