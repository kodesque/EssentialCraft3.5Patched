package ec3.client.gui;

import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

import ec3.client.gui.element.GuiEnderPulseStorage;
import ec3.dummycore.client.GuiCommon;

public class GuiMithrilineFurnace extends GuiCommon {

    public GuiMithrilineFurnace(Container c, TileEntity tile) {
        super(c, tile);
        this.elementList.add(new GuiEnderPulseStorage(4, 64, tile));
    }

}
