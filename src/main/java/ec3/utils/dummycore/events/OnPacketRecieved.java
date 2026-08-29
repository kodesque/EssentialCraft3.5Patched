package ec3.utils.dummycore.events;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;

/**
 *
 * @author Modbder
 * @version From DummyCore 1.7
 * @Description Now all packets work on Events.
 */
public class OnPacketRecieved extends Event {

    public final Side effectiveSide;

    public final String recievedData;

    public final EntityPlayer recievedEntity;

    public OnPacketRecieved(Side s, String str, EntityPlayer pl) {
        effectiveSide = s;
        recievedData = str;
        recievedEntity = pl;
    }
}
