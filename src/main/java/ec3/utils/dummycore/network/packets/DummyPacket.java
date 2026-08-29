package ec3.utils.dummycore.network.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class DummyPacket implements IMessage {

    public String dataStr;

    public DummyPacket() {

    }

    public DummyPacket(String data) {
        dataStr = data;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        dataStr = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, dataStr);

    }

}
