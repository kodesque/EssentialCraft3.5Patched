package ec3.common.tile.consumers;

import java.util.UUID;

import net.minecraft.tileentity.TileEntity;

import ec3.api.structures.EnumStructureType;
import ec3.api.structures.IStructurePiece;
import ec3.common.tile.storage.TileChamberController;

public class TileHoldingChamber extends TileEntity implements IStructurePiece {

    public TileChamberController controller;
    public UUID uuid = UUID.randomUUID();

    @Override
    public EnumStructureType getStructure() {
        return EnumStructureType.MRUCUContaigementChamber;
    }

    @Override
    public TileEntity structureController() {
        return controller;
    }

    @Override
    public void setStructureController(TileEntity tile, EnumStructureType structure) {
        if (tile instanceof TileChamberController && structure == this.getStructure()) {
            controller = (TileChamberController) tile;
        }

    }

}
