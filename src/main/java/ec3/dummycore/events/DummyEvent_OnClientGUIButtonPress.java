package ec3.dummycore.events;

import DummyCore.Utils.DummyData;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;

public class DummyEvent_OnClientGUIButtonPress extends Event {
    public int buttonID;
    public String client_ParentClassPath;
    public String client_ButtonClassPath;
    public EntityPlayer presser;
    public int x;
    public int y;
    public int z;
    public DummyData[] additionalData;

    public DummyEvent_OnClientGUIButtonPress(int bID, String s, String s_1, EntityPlayer player, int dx, int dy, int dz, DummyData[] data) {
        this.buttonID = bID;
        this.client_ParentClassPath = s;
        this.client_ButtonClassPath = s_1;
        this.presser = player;
        this.x = dx;
        this.y = dy;
        this.z = dz;
        this.additionalData = data;
    }
}
