package ec3.dummycore.utils;

import DummyCore.Core.CoreInitialiser;
import DummyCore.Utils.DummyPacketIMSG_Tile;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.channel.ChannelHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

@ChannelHandler.Sharable
public class DummyTilePacketHandler implements IMessageHandler<DummyCore.Utils.DummyPacketIMSG_Tile, IMessage> {
    public DummyTilePacketHandler() {
    }

    public IMessage onMessage(DummyCore.Utils.DummyPacketIMSG_Tile message, MessageContext ctx) {
        Side s = ctx.side;
        int packetID = -10;
        if (message.dataTag.func_74764_b("packetID")) {
            packetID = message.dataTag.func_74762_e("packetID");
            message.dataTag.func_82580_o("packetID");
        }

        S35PacketUpdateTileEntity genPkt = new S35PacketUpdateTileEntity(message.dataTag.func_74762_e("x"), message.dataTag.func_74762_e("y"), message.dataTag.func_74762_e("z"), packetID, message.dataTag);
        if (s == Side.CLIENT) {
            ctx.getClientHandler().func_147273_a(genPkt);
        }

        return null;
    }

    public static void sendToAll(DummyCore.Utils.DummyPacketIMSG_Tile message) {
        CoreInitialiser.network.sendToAll(message);
    }

    public static void sendToAllAround(DummyCore.Utils.DummyPacketIMSG_Tile message, NetworkRegistry.TargetPoint pnt) {
        CoreInitialiser.network.sendToAllAround(message, pnt);
    }

    public static void sendToAllAround(DummyCore.Utils.DummyPacketIMSG_Tile message, int dim) {
        CoreInitialiser.network.sendToDimension(message, dim);
    }

    public static void sendToPlayer(DummyCore.Utils.DummyPacketIMSG_Tile message, EntityPlayerMP player) {
        CoreInitialiser.network.sendTo(message, player);
    }

    public static void sendToServer(DummyPacketIMSG_Tile message) {
        CoreInitialiser.network.sendToServer(message);
    }
}
