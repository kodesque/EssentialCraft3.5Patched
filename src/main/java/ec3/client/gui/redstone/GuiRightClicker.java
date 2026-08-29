package ec3.client.gui.redstone;

import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

import ec3.api.mru.ITEHasMRU;
import ec3.client.guielement.general.GuiMRUState;
import ec3.client.guielement.general.GuiMRUStorage;
import ec3.utils.dummycore.client.GuiCommon;

public class GuiRightClicker extends GuiCommon {

    public GuiRightClicker(Container c, TileEntity tile) {
        super(c, tile);
        this.elementList.add(new GuiMRUStorage(7, 4, (ITEHasMRU) tile));
        this.elementList.add(new GuiMRUState(25, 58, (ITEHasMRU) tile, 0));
    }

}
