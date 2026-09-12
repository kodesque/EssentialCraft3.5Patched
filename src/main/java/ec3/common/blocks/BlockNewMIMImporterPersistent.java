package ec3.common.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ec3.common.tile.logistics.TileNewMIMImportNodePersistant;

public class BlockNewMIMImporterPersistent extends BlockNewMIMImporter {

    public BlockNewMIMImporterPersistent() {
        super();
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int metadata) {
        return new TileNewMIMImportNodePersistant();
    }

}
