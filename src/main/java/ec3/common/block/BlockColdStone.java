package ec3.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import ec3.api.IColdBlock;

public class BlockColdStone extends Block implements IColdBlock {

    public BlockColdStone(Material p_i45394_1_) {
        super(p_i45394_1_);
    }

    public BlockColdStone() {
        super(Material.ice);
    }

    @Override
    public float getColdModifier(World w, int x, int y, int z, int meta) {
        // TODO Auto-generated method stub
        return 0.5F;
    }

}
