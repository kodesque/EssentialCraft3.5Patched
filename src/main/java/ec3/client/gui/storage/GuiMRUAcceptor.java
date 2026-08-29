package ec3.client.gui.storage;

import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

import ec3.client.guielement.general.GuiBoundGemState;
import ec3.utils.dummycore.client.GuiCommon;

public class GuiMRUAcceptor extends GuiCommon {

    public GuiMRUAcceptor(Container c, TileEntity tile) {
        super(c, tile);
        this.elementList.add(new GuiBoundGemState(48, 50, tile, 0));
    }

}
