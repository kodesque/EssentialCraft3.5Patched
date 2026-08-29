package ec3.client.gui.consumers;

import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.IFluidTank;

import ec3.api.mru.ITEHasMRU;
import ec3.client.guielement.general.GuiBalanceState;
import ec3.client.guielement.general.GuiBoundGemState;
import ec3.client.guielement.general.GuiFluidTank;
import ec3.client.guielement.general.GuiMRUState;
import ec3.client.guielement.general.GuiMRUStorage;
import ec3.utils.dummycore.client.GuiCommon;

public class GuiMagmaticSmeltery extends GuiCommon {

    public GuiMagmaticSmeltery(Container c, TileEntity tile) {
        super(c, tile);
        this.elementList.add(new GuiMRUStorage(7, 4, (ITEHasMRU) tile));
        this.elementList.add(new GuiBalanceState(43, 40, tile));
        this.elementList.add(new GuiBoundGemState(43, 4, tile, 0));
        this.elementList.add(new GuiMRUState(25, 58, (ITEHasMRU) tile, 0));
        this.elementList.add(new GuiFluidTank(25, 4, (IFluidTank) tile));
    }

}
