package ec3.dummycore.blocks;

import DummyCore.Core.Core;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import java.util.Hashtable;

public class BlocksRegistry {
    public static Hashtable<Block, String> blocksList = new Hashtable();

    public BlocksRegistry() {
    }

    public static void registerBlock(Block b, String name, Class<?> modClass, Class<? extends ItemBlock> blockClass) {
        if (blockClass == null) {
            GameRegistry.registerBlock(b, name);
        } else {
            GameRegistry.registerBlock(b, blockClass, name);
        }

        Side s = FMLCommonHandler.instance().getEffectiveSide();
        if (s == Side.CLIENT) {
            b.setCreativeTab(Core.getBlockTabForMod(modClass));
            blocksList.put(b, Core.getBlockTabForMod(modClass).getTabLabel());
        }

    }
}
