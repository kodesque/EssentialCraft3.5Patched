package ec3.utils.dummycore.network.handlers;

import ec3.utils.dummycore.network.packets.DummyPacketTile;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import ec3.utils.dummycore.core.CoreInitializer;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
public class DummyTilePacketHandler implements IMessageHandler<DummyPacketTile, IMessage> {

    @Override
    public IMessage onMessage(DummyPacketTile message, MessageContext ctx) {
        Side s = ctx.side;
        int packetID = -10;
        if (message.dataTag.hasKey("packetID")) {
            packetID = message.dataTag.getInteger("packetID");
            message.dataTag.removeTag("packetID");
        }
        S35PacketUpdateTileEntity genPkt = new S35PacketUpdateTileEntity(
            message.dataTag.getInteger("x"),
            message.dataTag.getInteger("y"),
            message.dataTag.getInteger("z"),
            packetID,
            message.dataTag);
        if (s == Side.CLIENT) {
            ctx.getClientHandler()
                .handleUpdateTileEntity(genPkt);
        }
        return null;
    }

    public static void sendToAll(DummyPacketTile message) {
        CoreInitializer.network.sendToAll(message);
    }

    public static void sendToAllAround(DummyPacketTile message, TargetPoint pnt) {
        CoreInitializer.network.sendToAllAround(message, pnt);
    }

    public static void sendToAllAround(DummyPacketTile message, int dim) {
        CoreInitializer.network.sendToDimension(message, dim);
    }

    public static void sendToPlayer(DummyPacketTile message, EntityPlayerMP player) {
        CoreInitializer.network.sendTo(message, (EntityPlayerMP) player);
    }

    public static void sendToServer(DummyPacketTile message) {
        CoreInitializer.network.sendToServer(message);
    }

}
