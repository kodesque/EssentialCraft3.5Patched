package ec3.api.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class DemonTradeRecipe {

    public static List<DemonTradeRecipe> trades = new ArrayList<DemonTradeRecipe>();
    public static List<Class<? extends Entity>> allMobs = new ArrayList<Class<? extends Entity>>();
    public ItemStack desiredItem;
    public Class<? extends Entity> entityType;
    public final int id;

    public DemonTradeRecipe(ItemStack is) {
        id = trades.size();
        desiredItem = is;
        trades.add(this);
    }

    public DemonTradeRecipe(Class<? extends Entity> e) {
        id = trades.size();
        entityType = e;
        allMobs.add(e);
        trades.add(this);
    }

}
