package ec3.dummycore.events;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class DummyEvent_OnPacketReceived extends Event {
    public final Side effectiveSide;
    public final String recievedData;
    public final EntityPlayer recievedEntity;

    public DummyEvent_OnPacketReceived(Side s, String str, EntityPlayer pl) {
        this.effectiveSide = s;
        this.recievedData = str;
        this.recievedEntity = pl;
    }
}
