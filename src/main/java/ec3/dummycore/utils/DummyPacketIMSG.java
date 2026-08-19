package ec3.dummycore.utils;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class DummyPacketIMSG implements IMessage {
    public String dataStr;

    public DummyPacketIMSG() {
    }

    public DummyPacketIMSG(String data) {
        this.dataStr = data;
    }

    public void fromBytes(ByteBuf buf) {
        this.dataStr = ByteBufUtils.readUTF8String(buf);
    }

    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, this.dataStr);
    }
}
