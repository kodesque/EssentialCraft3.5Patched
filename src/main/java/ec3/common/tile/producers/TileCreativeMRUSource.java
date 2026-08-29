package ec3.common.tile.producers;

import ec3.common.tile.consumers.TileMRUGeneric;

public class TileCreativeMRUSource extends TileMRUGeneric {

    public TileCreativeMRUSource() {
        this.setSlotsNum(0);
        this.setMaxMRU(100000);
    }

    @Override
    public int[] getOutputSlots() {
        return new int[0];
    }

    public void updateEntity() {
        this.setMRU(this.getMaxMRU());
        super.updateEntity();
    }
}
