package ec3.common.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ec3.common.tile.logistics.TileNewMIMExportNodePersistant;

public class BlockNewMIMExporterPersistent extends BlockNewMIMExporter {

    public BlockNewMIMExporterPersistent() {
        super();
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int metadata) {
        return new TileNewMIMExportNodePersistant();
    }

}
