package ec3.utils.dummycore.network.packets;

import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class DummyPacketTile implements IMessage {

    public NBTTagCompound dataTag;

    public DummyPacketTile() {

    }

    public DummyPacketTile(NBTTagCompound data, int id) {
        dataTag = data;
        dataTag.setInteger("packetID", id);
    }

    public DummyPacketTile(NBTTagCompound data) {
        dataTag = data;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        dataTag = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, dataTag);

    }

}
