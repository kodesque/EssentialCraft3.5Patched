package ec3.utils.dummycore.creativetabs;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.common.init.ECItems;

/**
 * @version From DummyCore 1.0
 * @author Modbder
 *         Do not change anything here! Used to work with Items.
 */
public final class CreativePageItems extends CreativeTabs {

    private final String tabLabel;

    public CreativePageItems(String m) {
        super(m + " Items");
        tabLabel = m + " Items";
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ECItems.research_book);
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
