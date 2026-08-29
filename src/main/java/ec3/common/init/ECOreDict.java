package ec3.common.init;

import static ec3.api.config.Config.allowPaleItemsInOtherRecipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ECOreDict {

    public static void register() {
        OreDictionary.registerOre("blockDropsFire", new ItemStack(ECBlocks.drops, 1, 0));
        OreDictionary.registerOre("blockDropsWater", new ItemStack(ECBlocks.drops, 1, 1));
        OreDictionary.registerOre("blockDropsEarth", new ItemStack(ECBlocks.drops, 1, 2));
        OreDictionary.registerOre("blockDropsAir", new ItemStack(ECBlocks.drops, 1, 3));
        OreDictionary.registerOre(
            "blockMagicalPlating",
            new ItemStack(ECBlocks.magicPlating, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("glass", new ItemStack(ECBlocks.fortifiedGlass, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stone", new ItemStack(ECBlocks.fortifiedStone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary
            .registerOre("iceCompressed", new ItemStack(ECBlocks.coldStone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blockVoid", new ItemStack(ECBlocks.voidStone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary
            .registerOre("blockVoidStone", new ItemStack(ECBlocks.voidStone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("voidStone", new ItemStack(ECBlocks.voidStone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("glassVoid", new ItemStack(ECBlocks.voidGlass, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary
            .registerOre("blockGlassVoid", new ItemStack(ECBlocks.voidGlass, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("voidGlass", new ItemStack(ECBlocks.voidGlass, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary
            .registerOre("blockVoidGlass", new ItemStack(ECBlocks.voidGlass, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blockConcrete", new ItemStack(ECBlocks.concrete, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("concrete", new ItemStack(ECBlocks.concrete, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cacti", new ItemStack(ECBlocks.cacti, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("cactus", new ItemStack(ECBlocks.cacti, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blockCacti", new ItemStack(ECBlocks.cacti, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blockCactus", new ItemStack(ECBlocks.cacti, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dirt", new ItemStack(ECBlocks.dreadDirt, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blockDirt", new ItemStack(ECBlocks.dreadDirt, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("log", new ItemStack(ECBlocks.root, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blockLog", new ItemStack(ECBlocks.root, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("fence", new ItemStack(ECBlocks.fence[0], 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("fence", new ItemStack(ECBlocks.fence[1], 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("fence", new ItemStack(ECBlocks.fence[2], 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary
            .registerOre("blockPalePlating", new ItemStack(ECBlocks.platingPale, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre(
            "blockMitrilinePlating",
            new ItemStack(ECBlocks.invertedBlock, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("chest", new ItemStack(ECBlocks.chest, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blockChest", new ItemStack(ECBlocks.chest, 1, OreDictionary.WILDCARD_VALUE));

        OreDictionary.registerOre("blockElemental", new ItemStack(ECBlocks.compressed, 1, 4));
        OreDictionary.registerOre("compressedShardFire", new ItemStack(ECBlocks.compressed, 1, 0));
        OreDictionary.registerOre("compressedShardWater", new ItemStack(ECBlocks.compressed, 1, 1));
        OreDictionary.registerOre("compressedShardEarth", new ItemStack(ECBlocks.compressed, 1, 2));
        OreDictionary.registerOre("compressedShardWater", new ItemStack(ECBlocks.compressed, 1, 3));

        OreDictionary.registerOre("oreShardFire", new ItemStack(ECBlocks.oreDrops, 1, 1));
        OreDictionary.registerOre("oreShardWater", new ItemStack(ECBlocks.oreDrops, 1, 2));
        OreDictionary.registerOre("oreShardEarth", new ItemStack(ECBlocks.oreDrops, 1, 3));
        OreDictionary.registerOre("oreShardAir", new ItemStack(ECBlocks.oreDrops, 1, 4));
        OreDictionary.registerOre("oreShardElemental", new ItemStack(ECBlocks.oreDrops, 1, 0));
        OreDictionary.registerOre("oreShardFire", new ItemStack(ECBlocks.oreDrops, 1, 6));
        OreDictionary.registerOre("oreShardWater", new ItemStack(ECBlocks.oreDrops, 1, 7));
        OreDictionary.registerOre("oreShardEarth", new ItemStack(ECBlocks.oreDrops, 1, 8));
        OreDictionary.registerOre("oreShardAir", new ItemStack(ECBlocks.oreDrops, 1, 9));
        OreDictionary.registerOre("oreShardElemental", new ItemStack(ECBlocks.oreDrops, 1, 5));
        OreDictionary.registerOre("oreShardFire", new ItemStack(ECBlocks.oreDrops, 1, 11));
        OreDictionary.registerOre("oreShardWater", new ItemStack(ECBlocks.oreDrops, 1, 12));
        OreDictionary.registerOre("oreShardEarth", new ItemStack(ECBlocks.oreDrops, 1, 13));
        OreDictionary.registerOre("oreShardAir", new ItemStack(ECBlocks.oreDrops, 1, 14));
        OreDictionary.registerOre("oreShardElemental", new ItemStack(ECBlocks.oreDrops, 1, 10));

        // TODO OreDict
        OreDictionary.registerOre("shardFire", new ItemStack(ECItems.drops, 1, 0));
        OreDictionary.registerOre("shardWater", new ItemStack(ECItems.drops, 1, 1));
        OreDictionary.registerOre("shardEarth", new ItemStack(ECItems.drops, 1, 2));
        OreDictionary.registerOre("shardAir", new ItemStack(ECItems.drops, 1, 3));
        OreDictionary.registerOre("shardElemental", new ItemStack(ECItems.drops, 1, 4));
        OreDictionary.registerOre("gemCoal", new ItemStack(Items.coal, 1, 0));
        OreDictionary.registerOre("gemNetherStar", new ItemStack(Items.nether_star, 1, 0));
        OreDictionary.registerOre("obsidian", new ItemStack(Blocks.obsidian, 1, 0));
        OreDictionary.registerOre("gemEnderPearl", new ItemStack(Items.ender_pearl, 1, 0));
        OreDictionary.registerOre("itemFeather", new ItemStack(Items.feather, 1, 0));
        OreDictionary.registerOre("itemBook", new ItemStack(Items.book, 1, 0));

        if (allowPaleItemsInOtherRecipes) {
            OreDictionary.registerOre("gemEnderPearl", new ItemStack(ECItems.genericItem, 1, 38));
            OreDictionary.registerOre("enderPearl", new ItemStack(ECItems.genericItem, 1, 38));
            OreDictionary.registerOre("itemEnderPearl", new ItemStack(ECItems.genericItem, 1, 38));
            OreDictionary.registerOre("pearlEnder", new ItemStack(ECItems.genericItem, 1, 38));
        }

        OreDictionary.registerOre("ec3:gemEnderPearl", new ItemStack(Items.ender_pearl, 1, 0));
        OreDictionary.registerOre("ec3:gemEnderPearl", new ItemStack(ECItems.genericItem, 1, 38));

        if (allowPaleItemsInOtherRecipes)
            OreDictionary.registerOre("ingotGold", new ItemStack(ECItems.genericItem, 1, 39));

        OreDictionary.registerOre("ec3:ingotGold", new ItemStack(ECItems.genericItem, 1, 39));
        OreDictionary.registerOre("ec3:ingotGold", new ItemStack(Items.gold_ingot));

        OreDictionary.registerOre("enderEye", new ItemStack(Items.ender_eye, 1, 0));
        OreDictionary.registerOre("elementalCore", new ItemStack(ECItems.genericItem, 1, 1));
        OreDictionary.registerOre("elementalCore", new ItemStack(ECItems.genericItem, 1, 42));
        OreDictionary.registerOre("elementalCore", new ItemStack(ECItems.genericItem, 1, 53));
        OreDictionary.registerOre("demonicCore", new ItemStack(ECItems.genericItem, 1, 53));

        OreDictionary.registerOre("plateDiamond", new ItemStack(ECItems.genericItem, 1, 21));
        OreDictionary.registerOre("plateEmerald", new ItemStack(ECItems.genericItem, 1, 22));
        OreDictionary.registerOre("frameMagic", new ItemStack(ECItems.genericItem, 1, 24));
        OreDictionary.registerOre("frameIron", new ItemStack(ECItems.genericItem, 1, 26));
        OreDictionary.registerOre("magicWater", new ItemStack(ECItems.genericItem, 1, 6));
        OreDictionary.registerOre("waterMagic", new ItemStack(ECItems.genericItem, 1, 6));
        OreDictionary.registerOre("ingotThaumium", new ItemStack(ECItems.genericItem, 1, 5));
        OreDictionary.registerOre("ingotMagic", new ItemStack(ECItems.genericItem, 1, 5));
        OreDictionary.registerOre("plateMagic", new ItemStack(ECItems.genericItem, 1, 34));
        OreDictionary.registerOre("plateMagic", new ItemStack(ECItems.genericItem, 1, 41));
        OreDictionary.registerOre("platePale", new ItemStack(ECItems.genericItem, 1, 41));
        OreDictionary.registerOre("plateMagic", new ItemStack(ECItems.genericItem, 1, 49));
        OreDictionary.registerOre("plateMagic", new ItemStack(ECItems.genericItem, 1, 54));
        OreDictionary.registerOre("plateDemonic", new ItemStack(ECItems.genericItem, 1, 54));
        OreDictionary.registerOre("ingotDemonic", new ItemStack(ECItems.genericItem, 1, 52));

        OreDictionary.registerOre("alloysMagical", new ItemStack(ECItems.genericItem, 1, 0));
        OreDictionary.registerOre("orbGold", new ItemStack(ECItems.genericItem, 1, 4));
        OreDictionary.registerOre("plateFortified", new ItemStack(ECItems.genericItem, 1, 7));
        OreDictionary.registerOre("plateEnder", new ItemStack(ECItems.genericItem, 1, 8));
        OreDictionary.registerOre("plateGlass", new ItemStack(ECItems.genericItem, 1, 9));
        OreDictionary.registerOre("ingotGoldMagical", new ItemStack(ECItems.genericItem, 1, 10));
        OreDictionary.registerOre("plateRedstone", new ItemStack(ECItems.genericItem, 1, 11));
        OreDictionary.registerOre("dustCrystal", new ItemStack(ECItems.genericItem, 1, 20));
        OreDictionary.registerOre("dustMagic", new ItemStack(ECItems.genericItem, 1, 3));
        OreDictionary.registerOre("rodHeat", new ItemStack(ECItems.genericItem, 1, 25));
        OreDictionary.registerOre("screenMagic", new ItemStack(ECItems.genericItem, 1, 27));
        OreDictionary.registerOre("mruLink", new ItemStack(ECItems.genericItem, 1, 28));
        OreDictionary.registerOre("mruCatcher", new ItemStack(ECItems.genericItem, 1, 29));
        OreDictionary.registerOre("conversionMatrix", new ItemStack(ECItems.genericItem, 1, 30));
        OreDictionary.registerOre("plateObsidian", new ItemStack(ECItems.genericItem, 1, 31));
        OreDictionary.registerOre("worldInteractor", new ItemStack(ECItems.genericItem, 1, 33));
        OreDictionary.registerOre("titanite", new ItemStack(ECItems.titanite, 1, 0));
        OreDictionary.registerOre("ttitanite", new ItemStack(ECItems.twinkling_titanite, 1, 0));
        OreDictionary.registerOre("titaniteTwinkling", new ItemStack(ECItems.twinkling_titanite, 1, 0));

        OreDictionary.registerOre("gemPale", new ItemStack(ECItems.genericItem, 1, 40));

        if (allowPaleItemsInOtherRecipes) {
            OreDictionary.registerOre("gemDiamond", new ItemStack(ECItems.genericItem, 1, 40));
            OreDictionary.registerOre("gemEmerald", new ItemStack(ECItems.genericItem, 1, 40));
            OreDictionary.registerOre("gemRuby", new ItemStack(ECItems.genericItem, 1, 40));
            OreDictionary.registerOre("gemSapphire", new ItemStack(ECItems.genericItem, 1, 40));
            OreDictionary.registerOre("gemPeridot", new ItemStack(ECItems.genericItem, 1, 40));
        }

        OreDictionary.registerOre("plateVoid", new ItemStack(ECItems.genericItem, 1, 35));
        OreDictionary.registerOre("voidCore", new ItemStack(ECItems.genericItem, 1, 36));
        OreDictionary.registerOre("voidMRU", new ItemStack(ECItems.genericItem, 1, 37));

        OreDictionary.registerOre("focusFire", new ItemStack(ECItems.fFocus, 1, 0));
        OreDictionary.registerOre("focusWater", new ItemStack(ECItems.wFocus, 1, 0));
        OreDictionary.registerOre("focusEarth", new ItemStack(ECItems.eFocus, 1, 0));
        OreDictionary.registerOre("focusAir", new ItemStack(ECItems.aFocus, 1, 0));

        OreDictionary.registerOre("soulShard", new ItemStack(ECItems.storage, 1, 0));
        OreDictionary.registerOre("soulStone", new ItemStack(ECItems.storage, 1, 1));
        OreDictionary.registerOre("darkSoulMatter", new ItemStack(ECItems.storage, 1, 2));
        OreDictionary.registerOre("redSoulMatter", new ItemStack(ECItems.storage, 1, 3));
        OreDictionary.registerOre("matterOfEternity", new ItemStack(ECItems.storage, 1, 4));

        OreDictionary.registerOre("magnet", new ItemStack(ECItems.genericItem, 1, 43));
        OreDictionary.registerOre("resonatingCrystal", new ItemStack(ECItems.genericItem, 1, 44));
        OreDictionary.registerOre("gemResonant", new ItemStack(ECItems.genericItem, 1, 44));
        OreDictionary.registerOre("crystalResonant", new ItemStack(ECItems.genericItem, 1, 44));

        OreDictionary.registerOre("coreLapis", new ItemStack(ECItems.genericItem, 1, 45));
        OreDictionary.registerOre("dustFading", new ItemStack(ECItems.genericItem, 1, 46));
        OreDictionary.registerOre("gemFading", new ItemStack(ECItems.genericItem, 1, 47));
        OreDictionary.registerOre("gemMithriline", new ItemStack(ECItems.genericItem, 1, 48));
        OreDictionary.registerOre("plateMithriline", new ItemStack(ECItems.genericItem, 1, 49));
        OreDictionary.registerOre("ingotMithriline", new ItemStack(ECItems.genericItem, 1, 50));
        OreDictionary.registerOre("dustMithriline", new ItemStack(ECItems.genericItem, 1, 51));
        OreDictionary.registerOre("gemWind", new ItemStack(ECItems.genericItem, 1, 55));

        OreDictionary.registerOre("record", new ItemStack(ECItems.record_everlastingSummer, 1, 0));
        OreDictionary.registerOre("record", new ItemStack(ECItems.record_papersPlease, 1, 0));
        OreDictionary.registerOre("record", new ItemStack(ECItems.record_robocalypse, 1, 0));
        OreDictionary.registerOre("record", new ItemStack(ECItems.record_secret, 1, 0));
    }
}
