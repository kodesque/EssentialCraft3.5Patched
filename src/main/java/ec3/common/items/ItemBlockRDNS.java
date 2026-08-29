package ec3.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import ec3.common.blocks.BlockRedstoneDeviceNotSided;

public class ItemBlockRDNS extends ItemBlock {

    public ItemBlockRDNS(Block p_i45328_1_) {
        super(p_i45328_1_);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    public int getMetadata(int par1) {
        return par1;
    }

    public String getUnlocalizedName(ItemStack p_77667_1_) {
        return super.getUnlocalizedName(p_77667_1_) + "."
            + BlockRedstoneDeviceNotSided.names[p_77667_1_.getItemDamage()];
    }

}
