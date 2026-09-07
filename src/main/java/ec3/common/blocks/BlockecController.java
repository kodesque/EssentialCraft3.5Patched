package ec3.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ec3.common.tile.storage.TileChamberController;

public class BlockecController extends BlockContainer {

    public BlockecController(Material p_i45386_1_) {
        super(p_i45386_1_);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileChamberController();
    }

    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_,
        EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        TileChamberController tile = (TileChamberController) p_149727_1_
            .getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);
        if (!p_149727_1_.isRemote) tile.checkStructure();
        return true;
    }
}
