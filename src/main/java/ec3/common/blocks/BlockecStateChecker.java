package ec3.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ec3.api.config.Config;
import ec3.common.tile.storage.TileChamberStateChecker;
import ec3.root.EssentialCraftCore;

public class BlockecStateChecker extends BlockContainer {

    public BlockecStateChecker(Material p_i45386_1_) {
        super(p_i45386_1_);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileChamberStateChecker();
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer,
        int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (par1World.isRemote) {
            return true;
        } else {
            if (!par5EntityPlayer.isSneaking()) {
                par5EntityPlayer.openGui(EssentialCraftCore.core, Config.guiID[0], par1World, par2, par3, par4);
                return true;
            } else {
                return false;
            }
        }
    }
}
