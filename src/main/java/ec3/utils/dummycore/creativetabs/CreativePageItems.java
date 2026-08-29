package ec3.utils.dummycore.creativetabs;

import java.util.ArrayList;
import java.util.List;

import ec3.common.init.ECItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.utils.dummycore.core.CoreInitializer;

/**
 * @version From DummyCore 1.0
 * @author Modbder
 *         Do not change anything here! Used to work with Items.
 */
public final class CreativePageItems extends CreativeTabs {

    public int delayTime = 0;
    public ItemStack displayStack = new ItemStack((Item) Items.iron_axe, 1, 0);
    private final String tabLabel;
    public List<ItemStack> itemList = new ArrayList<ItemStack>();
    public int tries = 0;
    public ItemStack overrideDisplayStack;

    public CreativePageItems(String m) {
        super(m + " Items");
        tabLabel = m + " Items";
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ECItems.research_book);
    }

    public List<ItemStack> initialiseItemsList() {
        ++tries;
        if (this.itemList.isEmpty() && tries <= 1) {
            for (int t = 0; t < Item.itemRegistry.getKeys()
                .size(); ++t) {
                Item itm = (Item) Item.itemRegistry.getObject(
                    Item.itemRegistry.getKeys()
                        .toArray()[t]);
                if (itm != null && itm.getCreativeTab() == this) {
                    List<ItemStack> lst = new ArrayList<ItemStack>();
                    itm.getSubItems(itm, this, lst);
                    if (!lst.isEmpty()) {
                        for (ItemStack stk : lst) {
                            if (stk != null) {
                                this.itemList.add(stk);
                            }
                        }
                    }
                }
            }
            return this.itemList;
        } else {
            return this.itemList;
        }

    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getTranslatedTabLabel() {
        return this.tabLabel;
    }

    @Override
    public Item getTabIconItem() {
        return Items.iron_axe;
    }
}
