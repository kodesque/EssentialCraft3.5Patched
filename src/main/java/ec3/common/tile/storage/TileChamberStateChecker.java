package ec3.common.tile.storage;

import java.util.UUID;

import net.minecraft.tileentity.TileEntity;

import ec3.api.mru.ITileRequiresMRU;
import ec3.api.structures.EnumStructureType;
import ec3.api.structures.IStructurePiece;

public class TileChamberStateChecker extends TileEntity implements IStructurePiece, ITileRequiresMRU {

    public TileChamberController controller;
    public UUID uuid = UUID.randomUUID();

    @Override
    public int getMRU() {
        if (controller != null) return controller.getMRU();
        return 0;
    }

    @Override
    public int getMaxMRU() {
        if (controller != null) return controller.getMaxMRU();
        return 0;
    }

    @Override
    public boolean setMRU(int i) {
        return false;
    }

    @Override
    public float getBalance() {
        if (controller != null) {
            return controller.getBalance();
        }
        return 1;
    }

    @Override
    public boolean setBalance(float f) {
        return false;
    }

    @Override
    public UUID getUUID() {
        // TODO Auto-generated method stub
        return uuid;
    }

    @Override
    public EnumStructureType getStructure() {
        // TODO Auto-generated method stub
        return EnumStructureType.MRUCUContaigementChamber;
    }

    @Override
    public TileEntity structureController() {
        // TODO Auto-generated method stub
        return controller;
    }

    @Override
    public void setStructureController(TileEntity tile, EnumStructureType structure) {
        if (tile instanceof TileChamberController && structure == this.getStructure()) {
            controller = (TileChamberController) tile;
        }

    }

    @Override
    public boolean setMaxMRU(float f) {
        // TODO Auto-generated method stub
        return false;
    }

}
