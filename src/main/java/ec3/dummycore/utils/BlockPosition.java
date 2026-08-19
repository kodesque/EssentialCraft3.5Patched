package ec3.dummycore.utils;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPosition {
    public int x;
    public int y;
    public int z;
    public Block blk;
    public int metadata;
    public TileEntity blockTile;
    public World wrld;

    public BlockPosition(World w, int posX, int posY, int posZ) {
        this.wrld = w;
        this.x = posX;
        this.y = posY;
        this.z = posZ;
        this.blk = w.getBlock(posX, posY, posZ);
        this.metadata = w.getBlockMetadata(posX, posY, posZ);
        this.blockTile = w.getTileEntity(posX, posY, posZ);
    }
}
