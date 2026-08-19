package ec3.dummycore.events;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;

public class DummyEvent_OnKeyboardKeyPressed_Server extends Event {
    public int keyID;
    public String keyName;
    public EntityPlayer presser;
    public boolean pressed;

    public DummyEvent_OnKeyboardKeyPressed_Server(int keyId, String keyname, EntityPlayer player, boolean bool) {
        this.keyID = keyId;
        this.keyName = keyname;
        this.presser = player;
        this.pressed = bool;
    }
}
