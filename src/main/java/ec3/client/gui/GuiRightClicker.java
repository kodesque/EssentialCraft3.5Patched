package ec3.client.gui;

import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

import ec3.api.ITEHasMRU;
import ec3.client.gui.element.GuiMRUState;
import ec3.client.gui.element.GuiMRUStorage;
import ec3.dummycore.client.GuiCommon;

public class GuiRightClicker extends GuiCommon {

    public GuiRightClicker(Container c, TileEntity tile) {
        super(c, tile);
        this.elementList.add(new GuiMRUStorage(7, 4, (ITEHasMRU) tile));
        this.elementList.add(new GuiMRUState(25, 58, (ITEHasMRU) tile, 0));
    }

}
