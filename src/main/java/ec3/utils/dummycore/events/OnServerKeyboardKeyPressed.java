package ec3.utils.dummycore.events;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.eventhandler.Event;

public class OnServerKeyboardKeyPressed extends Event {

    public int keyID;
    public String keyName;
    public EntityPlayer presser;
    public boolean pressed;

    public OnServerKeyboardKeyPressed(int keyId, String keyname, EntityPlayer player, boolean bool) {
        keyID = keyId;
        keyName = keyname;
        presser = player;
        pressed = bool;
    }

}
