package ec3.dummycore.creativetabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.dummycore.core.CoreInitializer;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public final class CreativePageBlocks extends CreativeTabs {
    public int delayTime = 0;
    public ItemStack displayStack;
    private final String tabLabel;
    public List<ItemStack> blockList;
    public int tries;

    public CreativePageBlocks(String m) {
        super(m + " Blocks");
        this.displayStack = new ItemStack(Blocks.crafting_table, 1, 0);
        this.blockList = new ArrayList<>();
        this.tries = 0;
        this.tabLabel = m + " Blocks";
    }

    public ItemStack func_151244_d() {
        CoreInitializer.proxy.chooseDisplayStack(this);
        return this.displayStack;
    }

    public List<ItemStack> initialiseBlocksList() {
        ++this.tries;
        if (this.blockList.isEmpty() && this.tries <= 1) {
            for(int t = 0; t < Block.blockRegistry.getKeys().size(); ++t) {
                Block b = Block.getBlockFromName((String)Block.blockRegistry.getKeys().toArray()[t]);
                if (b != null && b.getCreativeTabToDisplayOn() == this) {
                    Item itm = Item.getItemFromBlock(b);
                    if (itm != null) {
                        List<ItemStack> lst = new ArrayList<>();
                        itm.getSubItems(itm, this, lst);
                        if (!lst.isEmpty()) {
                            for(ItemStack stk : lst) {
                                if (stk != null) {
                                    this.blockList.add(stk);
                                }
                            }
                        }
                    }
                }
            }

            return this.blockList;
        } else {
            return this.blockList;
        }
    }

    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel() {
        return this.tabLabel;
    }

    public Item getTabIconItem() {
        return this.displayStack.getItem();
    }
}
