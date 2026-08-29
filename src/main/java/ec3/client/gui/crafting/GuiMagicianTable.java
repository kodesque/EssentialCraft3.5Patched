package ec3.client.gui.crafting;

import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

import ec3.api.mru.ITEHasMRU;
import ec3.client.guielement.general.GuiBalanceState;
import ec3.client.guielement.general.GuiBoundGemState;
import ec3.client.guielement.general.GuiMRUState;
import ec3.client.guielement.general.GuiMRUStorage;
import ec3.client.guielement.specific.GuiProgressBarTable;
import ec3.utils.dummycore.client.GuiCommon;

public class GuiMagicianTable extends GuiCommon {

    public GuiMagicianTable(Container c, TileEntity tile) {
        super(c, tile);
        this.elementList.add(new GuiMRUStorage(7, 4, (ITEHasMRU) tile));
        this.elementList.add(new GuiProgressBarTable(25, 4, tile));
        this.elementList.add(new GuiMRUState(25, 58, (ITEHasMRU) tile, 0));
        this.elementList.add(new GuiBalanceState(88, 22, tile));
        this.elementList.add(new GuiBoundGemState(88, 40, tile, 0));
    }

}
