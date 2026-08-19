package ec3.dummycore.utils;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;

public class DummyPacketIMSG_Tile implements IMessage {
    public NBTTagCompound dataTag;

    public DummyPacketIMSG_Tile() {
    }

    public DummyPacketIMSG_Tile(NBTTagCompound data, int id) {
        this.dataTag = data;
        this.dataTag.func_74768_a("packetID", id);
    }

    public DummyPacketIMSG_Tile(NBTTagCompound data) {
        this.dataTag = data;
    }

    public void fromBytes(ByteBuf buf) {
        this.dataTag = ByteBufUtils.readTag(buf);
    }

    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, this.dataTag);
    }
}
