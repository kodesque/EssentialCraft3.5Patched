package ec3.dummycore.items;

import DummyCore.Core.Core;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.item.Item;

import java.util.Hashtable;

public class ItemRegistry {
    public static Hashtable<Item, String> itemsList = new Hashtable<>();

    public ItemRegistry() {
    }

    public static void registerItem(Item i, String name, Class<?> modClass) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            i.setCreativeTab(Core.getItemTabForMod(modClass));
            itemsList.put(i, Core.getItemTabForMod(modClass).getTabLabel());
        }

        GameRegistry.registerItem(i, name);
    }

    /** @deprecated */
    @Deprecated
    public static void registerItem(Item i, Class<?> modClass) {
        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            i.setCreativeTab(Core.getItemTabForMod(modClass));
            itemsList.put(i, Core.getItemTabForMod(modClass).getTabLabel());
        }

    }
}
