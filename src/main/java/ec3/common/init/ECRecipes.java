package ec3.common.init;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import ec3.api.recipes.DemonTradeRecipe;
import ec3.api.recipes.MagicianTableRecipes;
import ec3.api.recipes.MithrilineFurnaceRecipes;
import ec3.api.recipes.RadiatingChamberRecipes;
import ec3.api.recipes.WindImbueRecipe;
import ec3.common.entities.EntityWindMage;
import ec3.utils.RecipeArmorDyesHandler;
import ec3.utils.dummycore.utils.MiscUtils;
import ec3.utils.dummycore.utils.UnformedItemStack;

public class ECRecipes {

    public static ECRecipes instance;
    public boolean hasGregTech = false;
    @SuppressWarnings("unused")
    private Class<?> GT_Class;

    @SuppressWarnings("unchecked")
    public void main() {
        registerDictionary();
        registerRecipes();
        registerMagicianTable();
        registerRadiatingChamber();
        registerMithrilineFurnace();
        registerWindRecipes();
        registerDemonTrades();
        CraftingManager.getInstance()
            .getRecipeList()
            .add(new RecipeArmorDyesHandler());
    }

    public void registerDictionary() {
        ECOreDict.register();
    }

    public void registerRecipes() {
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.drops, 4, 4),
                new Object[] { "shardFire", "shardWater", "shardEarth", "shardAir" }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.mruMover1, 1, 0),
                new Object[] { "shardElemental", "stickWood" }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.magicalChisel, 1, 0),
                new Object[] { "shardElemental", "shardElemental", "shardElemental", "shardElemental", "stickWood" }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.bound_gem, 1, 0),
                new Object[] { "shardElemental", "gemQuartz" }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 33),
                new Object[] { "ingotThaumium", "ingotThaumium", "ingotThaumium", "ingotThaumium", "ingotThaumium",
                    "ingotThaumium", "ingotThaumium", "ingotThaumium", new ItemStack(ECItems.genericItem, 1, 23) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.playerList, 1, 0),
                new Object[] { Items.paper, new ItemStack(ECItems.bound_gem, 1, 0) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 50),
                new Object[] { " I ", "ISI", " I ", 'I', "dustMithriline", 'S', "ingotThaumium" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 48),
                new Object[] { " I ", "ISI", " I ", 'S', "dustMithriline", 'I', "ingotMithriline" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.holopad),
                new Object[] { "TVT", "TET", "THT", 'T', ECItems.twinkling_titanite, 'V', gen(36), 'H', gen(59), 'E',
                    new ItemStack(ECItems.storage, 1, 4) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.blockPale, 1, 0),
                new Object[] { "ISI", "SES", "ISI", 'I', getItemByNameEC3("genericItem", 39), 'S', Blocks.lapis_block,
                    'E', getItemByNameEC3("genericItem", 38) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.furnaceMagic, 1, 0),
                new Object[] { "III", "IEI", "III", 'I', new ItemStack(ECItems.genericItem, 1, 7), 'E', "rodHeat" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.furnaceMagic, 1, 4),
                new Object[] { "III", "IEI", "III", 'I', new ItemStack(ECItems.genericItem, 1, 34), 'E',
                    new ItemStack(ECBlocks.furnaceMagic, 1, 0) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.furnaceMagic, 1, 8),
                new Object[] { "III", "IEI", "III", 'I', new ItemStack(ECItems.genericItem, 1, 41), 'E',
                    new ItemStack(ECBlocks.furnaceMagic, 1, 4) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.furnaceMagic, 1, 12),
                new Object[] { "III", "IEI", "III", 'I', new ItemStack(ECItems.genericItem, 1, 35), 'E',
                    new ItemStack(ECBlocks.furnaceMagic, 1, 8) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 1),
                new Object[] { "ISI", "SES", "ISI", 'I', "ingotIron", 'S', "stone", 'E', "shardElemental" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.mruMover_t2, 1, 0),
                new Object[] { " SI", " ES", "E  ", 'I', "gemDiamond", 'S', "plateGlass", 'E', "ingotMagic" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 21),
                new Object[] { "ISI", " E ", "ISI", 'I', "ingotIron", 'S', "gemDiamond", 'E', "shardElemental" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 21),
                new Object[] { "I I", "SES", "I I", 'I', "ingotIron", 'S', "gemDiamond", 'E', "shardElemental" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 22),
                new Object[] { "ISI", " E ", "ISI", 'I', "ingotIron", 'S', "gemEmerald", 'E', "shardElemental" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 22),
                new Object[] { "I I", "SES", "I I", 'I', "ingotIron", 'S', "gemEmerald", 'E', "shardElemental" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 23),
                new Object[] { "ISI", "SES", "ISI", 'I', "ingotIron", 'S', "shardElemental", 'E',
                    "ec3:gemEnderPearl" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 3, 24),
                new Object[] { "ISI", "S S", "ISI", 'I', getItemByNameEC3("fortifiedGlass", 0), 'S',
                    getItemByNameEC3("fortifiedStone", 0) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 25),
                new Object[] { "ISI", "ISI", "ISI", 'I', "shardFire", 'S', Items.iron_ingot }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 4, 26),
                new Object[] { "ISI", "SIS", "ISI", 'I', "ingotIron", 'S', "shardElemental" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 27),
                new Object[] { "I I", " S ", "I I", 'I', "frameMagic", 'S', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 8, 28),
                new Object[] { "SPS", "EGE", "GGG", 'G', "ec3:ingotGold", 'E', "gemEmerald", 'P', "ec3:gemEnderPearl",
                    'S', "shardElemental" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 8, 29),
                new Object[] { "GGG", "EGE", "SPS", 'G', "ec3:ingotGold", 'E', "ec3:gemEnderPearl", 'P',
                    "ec3:gemEnderPearl", 'S', "shardElemental" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 30),
                new Object[] { " I ", " S ", " I ", 'I', "ingotThaumium", 'S', "elementalCore" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 31),
                new Object[] { " O ", "OMO", " O ", 'O', "obsidian", 'M', "frameMagic" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.matrixAbsorber, 1, 0),
                new Object[] { "SAS", "HEH", "SLS", 'S', "frameIron", 'A', "mruCatcher", 'L', "mruLink", 'E',
                    "elementalCore", 'H', "rodHeat" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.radiatingChamber, 1, 0),
                new Object[] { "DAD", "ECE", "DHD", 'D', "plateDiamond", 'A', "mruCatcher", 'H', "rodHeat", 'E',
                    getItemByNameEC3("genericItem", 23), 'C', "elementalCore" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.controlRod, 1, 0),
                new Object[] { "DII", " CI", "I D", 'I', "ingotIron", 'C', "elementalCore", 'D', "waterMagic" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.magicalMirror, 3, 0),
                new Object[] { " P ", "PGP", " P ", 'P', "plateMagic", 'G', "plateGlass" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.filter, 1, 0),
                new Object[] { " P ", "PGP", " P ", 'P', "plateFortified", 'G', Blocks.crafting_table }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.filter, 1, 1),
                new Object[] { " P ", "PGP", " P ", 'P', "plateVoid", 'G', ECItems.filter }));
        addRecipe(
            new ItemStack(ECItems.magicalBuilder, 1, 0),
            new Object[] { new ItemStack(ECBlocks.rightClicker, 1, OreDictionary.WILDCARD_VALUE), "plateVoid",
                "voidCore", new ItemStack(ECItems.filter, 1, 0), new ItemStack(ECItems.magicalDigger, 1, 0),
                "plateVoid", "plateMagic", new ItemStack(ECItems.filter, 1, 0),
                new ItemStack(ECBlocks.rightClicker, 1, OreDictionary.WILDCARD_VALUE) });
        GameRegistry.addShapelessRecipe(
            new ItemStack(ECItems.magicalBuilder, 1, 1),
            new ItemStack(ECItems.magicalBuilder, 1, 0));
        GameRegistry.addShapelessRecipe(
            new ItemStack(ECItems.magicalBuilder, 1, 2),
            new ItemStack(ECItems.magicalBuilder, 1, 1));
        GameRegistry.addShapelessRecipe(
            new ItemStack(ECItems.magicalBuilder, 1, 3),
            new ItemStack(ECItems.magicalBuilder, 1, 2));
        GameRegistry.addShapelessRecipe(
            new ItemStack(ECItems.magicalBuilder, 1, 4),
            new ItemStack(ECItems.magicalBuilder, 1, 3));
        GameRegistry.addShapelessRecipe(
            new ItemStack(ECItems.magicalBuilder, 1, 0),
            new ItemStack(ECItems.magicalBuilder, 1, 4));

        addRecipe(
            new ItemStack(ECBlocks.ecStateChecker, 1, 0),
            new Object[] { "frameMagic", "screenMagic", "frameMagic", "mruCatcher", "elementalCore", "conversionMatrix",
                "plateMagic", "mruLink", "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.assembler, 1, 0),
            new Object[] { "plateMagic", "screenMagic", "plateMagic", "conversionMatrix", "elementalCore",
                "conversionMatrix", "plateMagic", "mruLink", "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.mithrilineCrystal, 1, 0),
            new Object[] { "dustMithriline", "enderEye", "dustMithriline", "dustMithriline", "gemMithriline",
                "dustMithriline", "dustMithriline", "ec3:gemEnderPearl", "dustMithriline", });
        addRecipe(
            new ItemStack(ECBlocks.mithrilineCrystal, 1, 3),
            new Object[] { "dustFading", "gemFading", "dustFading", "dustFading",
                new ItemStack(ECBlocks.mithrilineCrystal, 1, 0), "dustFading", "dustFading", "gemFading",
                "dustFading", });
        addRecipe(
            new ItemStack(ECBlocks.mithrilineCrystal, 1, 6),
            new Object[] { "plateVoid", "voidCore", "plateVoid", "plateVoid",
                new ItemStack(ECBlocks.mithrilineCrystal, 1, 3), "plateVoid", "plateVoid", "voidMRU", "plateVoid", });
        addRecipe(
            new ItemStack(ECBlocks.mithrilineCrystal, 1, 9),
            new Object[] { "ingotDemonic", "demonicCore", "ingotDemonic", "ingotDemonic",
                new ItemStack(ECBlocks.mithrilineCrystal, 1, 6), "ingotDemonic", "ingotDemonic", "demonicCore",
                "ingotDemonic", });
        addRecipe(
            new ItemStack(ECBlocks.ecBalancer, 1, 0),
            new Object[] { "plateMagic", "alloysMagical", "plateMagic", "conversionMatrix", "elementalCore",
                "conversionMatrix", "plateMagic", "mruCatcher", "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.ecRedstoneController, 1, 0),
            new Object[] { "plateMagic", "plateRedstone", "plateMagic", "conversionMatrix", "elementalCore",
                "conversionMatrix", "plateMagic", "plateRedstone", "plateMagic", });
        addRecipe(
            new ItemStack(ECItems.genericItem, 1, 53),
            new Object[] { "plateDemonic", "shardElemental", "plateDemonic", "shardElemental", "resonatingCrystal",
                "shardElemental", "plateDemonic", "shardElemental", "plateDemonic", });
        addRecipe(
            new ItemStack(ECBlocks.ecHoldingChamber, 1, 0),
            new Object[] { "frameMagic", "mruCatcher", "frameMagic", getItemByNameEC3("storage", 2), "plateGlass",
                getItemByNameEC3("storage", 2), "plateMagic", "mruLink", "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.rayTower, 4, 0),
            new Object[] { "magicWater", "conversionMatrix", "magicWater", "plateFortified", "mruCatcher",
                "plateFortified", new ItemStack(ECBlocks.fortifiedStone, 1, 0), "screenMagic",
                new ItemStack(ECBlocks.fortifiedStone, 1, 0), });

        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.magicPlating, 16, 0),
                new Object[] { getItemByNameEC3("genericItem", 34), getItemByNameEC3("genericItem", 34),
                    getItemByNameEC3("genericItem", 34), getItemByNameEC3("genericItem", 34) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.platingPale, 16, 0),
                new Object[] { getItemByNameEC3("genericItem", 41), getItemByNameEC3("genericItem", 41),
                    getItemByNameEC3("genericItem", 41), getItemByNameEC3("genericItem", 41) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.invertedBlock, 16, 0),
                new Object[] { getItemByNameEC3("genericItem", 49), getItemByNameEC3("genericItem", 49),
                    getItemByNameEC3("genericItem", 49), getItemByNameEC3("genericItem", 49) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.demonicPlating, 16, 0),
                new Object[] { getItemByNameEC3("genericItem", 54), getItemByNameEC3("genericItem", 54),
                    getItemByNameEC3("genericItem", 54), getItemByNameEC3("genericItem", 54) }));
        addRecipe(
            new ItemStack(ECBlocks.potionSpreader, 1, 0),
            1000,
            new Object[] { "worldInteractor", "frameMagic", "worldInteractor", "mruCatcher", "elementalCore",
                "screenMagic", "plateMagic", "conversionMatrix", "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.magicalEnchanter, 1, 0),
            5000,
            new Object[] { "screenMagic", new ItemStack(Items.enchanted_book, 1, 0), "mruCatcher", "worldInteractor",
                new ItemStack(Blocks.enchanting_table, 1, 0), "conversionMatrix", "plateMagic", "elementalCore",
                "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.monsterHarvester, 1, 0),
            10000,
            new Object[] { "plateMagic", "screenMagic", "mruCatcher", new ItemStack(ECItems.staffOfLife, 1, 0),
                "elementalCore", "conversionMatrix", "worldInteractor", "frameMagic", "worldInteractor", });
        addRecipe(
            new ItemStack(ECBlocks.magicalRepairer, 1, 0),
            2000,
            new Object[] { "frameMagic", "screenMagic", "mruCatcher", "conversionMatrix", "elementalCore",
                "conversionMatrix", "plateMagic", "mruLink", "worldInteractor", });
        /*
         * addRecipe(new ItemStack(BlocksCore.minEjector,2,0),2000,new Object[]{
         * "frameMagic","screenMagic","frameMagic",
         * "frameMagic","elementalCore","frameMagic",
         * getItemByNameEC3("genericItem",34),"conversionMatrix",getItemByNameEC3("genericItem",34),
         * });
         * addRecipe(new ItemStack(BlocksCore.minEjector,1,6),10000,new Object[]{
         * "frameMagic","screenMagic","frameMagic",
         * "frameMagic","elementalCore","frameMagic",
         * getItemByNameEC3("genericItem",41),"conversionMatrix",getItemByNameEC3("genericItem",41),
         * });
         * addRecipe(new ItemStack(BlocksCore.minInjector,2,0),2000,new Object[]{
         * "screenMagic","screenMagic","screenMagic",
         * "frameMagic","elementalCore","frameMagic",
         * getItemByNameEC3("genericItem",34),"conversionMatrix",getItemByNameEC3("genericItem",34),
         * });
         * addRecipe(new ItemStack(BlocksCore.minInjector,1,6),10000,new Object[]{
         * "screenMagic","screenMagic","screenMagic",
         * "frameMagic","elementalCore","frameMagic",
         * getItemByNameEC3("genericItem",41),"conversionMatrix",getItemByNameEC3("genericItem",41),
         * });
         */
        addRecipe(
            new ItemStack(ECBlocks.ecAcceptor, 1, 0),
            new Object[] { "frameMagic", "mruCatcher", "frameMagic", "screenMagic", "elementalCore", "conversionMatrix",
                "plateMagic", "mruLink", "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.solarPrism, 1, 0),
            1200,
            new Object[] { "alloysMagical", getItemByNameEC3("genericItem", 32), "alloysMagical",
                getItemByNameEC3("genericItem", 32), getItemByNameEC3("genericItem", 32),
                getItemByNameEC3("genericItem", 32), "alloysMagical", getItemByNameEC3("genericItem", 32),
                "alloysMagical", });
        addRecipe(
            new ItemStack(ECBlocks.ecController, 1, 0),
            new Object[] { "frameMagic", "plateMagic", "frameMagic", "conversionMatrix", "elementalCore",
                "worldInteractor", "mruLink", "mruLink", "mruLink", });
        addRecipe(
            new ItemStack(ECBlocks.ecEjector, 1, 0),
            new Object[] { "frameMagic", "mruLink", "frameMagic", "conversionMatrix", "elementalCore",
                "conversionMatrix", "plateMagic", "mruLink", "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.coldStone, 1, 0),
            new Object[] { new ItemStack(Blocks.ice, 1, 0), new ItemStack(Blocks.snow, 1, 0),
                new ItemStack(Blocks.ice, 1, 0), new ItemStack(Blocks.snow, 1, 0),
                new ItemStack(Blocks.glowstone, 1, 0), new ItemStack(Blocks.snow, 1, 0),
                new ItemStack(Blocks.ice, 1, 0), new ItemStack(Blocks.snow, 1, 0), new ItemStack(Blocks.ice, 1, 0), });
        addRecipe(
            new ItemStack(ECBlocks.coldDistillator, 1, 0),
            1000,
            new Object[] { "screenMagic", "mruCatcher", "conversionMatrix", new ItemStack(ECBlocks.coldStone),
                "elementalCore", new ItemStack(ECBlocks.coldStone), "plateMagic",
                new ItemStack(ECItems.matrixProj, 1, 2), "worldInteractor", });
        addRecipe(
            new ItemStack(ECBlocks.magmaticSmeltery, 1, 0),
            8000,
            new Object[] { "mruCatcher", "screenMagic", "alloysMagical", "conversionMatrix", "elementalCore",
                "conversionMatrix", "rodHeat", "worldInteractor", "rodHeat", });
        addRecipe(
            new ItemStack(ECBlocks.magicalJukebox, 1, 0),
            404,
            new Object[] { "plateMagic", "mruCatcher", "worldInteractor", "elementalCore",
                new ItemStack(Blocks.jukebox, 1, 0), "shardElemental", "plateRedstone", "screenMagic",
                "plateRedstone", });
        addRecipe(
            new ItemStack(ECBlocks.crystalFormer, 1, 0),
            1200,
            new Object[] { "screenMagic", "mruCatcher", "plateMagic", "dustCrystal", "elementalCore", "dustCrystal",
                "plateObsidian", "conversionMatrix", "plateObsidian", });
        addRecipe(
            new ItemStack(ECBlocks.crystalController, 1, 0),
            3000,
            new Object[] { "screenMagic", "mruCatcher", "plateMagic", "dustCrystal", "elementalCore", "dustCrystal",
                "plateFortified", "conversionMatrix", "plateFortified", });
        addRecipe(
            new ItemStack(ECBlocks.naturalFurnace, 1, 0),
            new Object[] { "frameMagic", "screenMagic", "mruCatcher", "rodHeat", "elementalCore", "rodHeat",
                "plateMagic", "worldInteractor", "conversionMatrix", });
        addRecipe(
            new ItemStack(ECBlocks.heatGenerator, 1, 0),
            new Object[] { "plateMagic", "screenMagic", "conversionMatrix", "rodHeat", "elementalCore", "rodHeat",
                "frameMagic", "worldInteractor", "mruCatcher", });
        addRecipe(
            new ItemStack(ECBlocks.enderGenerator, 1, 0),
            new Object[] { "frameMagic", "screenMagic", "mruCatcher", "conversionMatrix", "elementalCore",
                "conversionMatrix", "plateMagic", "worldInteractor", "plateEnder", });
        addRecipe(
            new ItemStack(ECBlocks.magicianTable, 1, 0),
            new Object[] { "frameIron", "mruCatcher", "frameIron", "plateEmerald", "elementalCore", "plateEmerald",
                "plateObsidian", "frameIron", "plateObsidian", });
        addRecipe(
            new ItemStack(ECBlocks.magicalQuarry, 1, 0),
            5000,
            new Object[] { "plateFortified", "frameMagic", "plateFortified", "screenMagic",
                new ItemStack(ECItems.magicalDigger, 1, 0), "mruCatcher", "worldInteractor", "elementalCore",
                "worldInteractor", });
        addRecipe(
            new ItemStack(ECBlocks.monsterClinger, 1, 0),
            8000,
            new Object[] { "worldInteractor", "elementalCore", "worldInteractor", "screenMagic", "conversionMatrix",
                "mruCatcher", "frameMagic", "plateFortified", "frameMagic", });
        addRecipe(
            new ItemStack(ECBlocks.crystalExtractor, 1, 0),
            1000,
            new Object[] { "screenMagic", "dustCrystal", "alloysMagical", "conversionMatrix", "elementalCore",
                "conversionMatrix", "plateFortified", "dustCrystal", "plateFortified", });
        addRecipe(
            new ItemStack(ECBlocks.chargingChamber, 1, 0),
            new Object[] { "elementalCore", "mruCatcher", "frameMagic", "screenMagic",
                new ItemStack(ECItems.storage, 1, 3), "conversionMatrix", "plateMagic", "mruLink", "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.voidGlass, 32, 0),
            new Object[] { "titanite", "frameMagic", "titanite", "frameMagic", "ttitanite", "frameMagic", "titanite",
                "frameMagic", "titanite", });
        // TODO Computer Guy's recipes
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 69),
                new Object[] { "#R#", "LQL", "#R#", '#', "plateDemonic", 'R', "dustRedstone", 'L', "gemLapis", 'Q',
                    "gemQuartz" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 68),
                new Object[] { "#@#", "@C@", "#@#", '#', "plateDemonic", '@', gen(47), 'C', gen(55) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 74),
                new Object[] { "#@#", "@C@", "#@#", '#', "plateDemonic", '@', gen(48), 'C', gen(55) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 67),
                new Object[] { "#@#", "@C@", "#@#", '#', "plateDemonic", '@', gen(44), 'C', gen(68) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 66),
                new Object[] { "#@#", "@C@", "#@#", '#', "plateDemonic", '@', gen(47), 'C', gen(74) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 2, 59),
                new Object[] { "#C#", "@#@", "#C#", '#', "plateDemonic", '@', gen(0), 'C', gen(55) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 65),
                new Object[] { "#@#", "@C@", "#@#", '#', gen(41), '@', "demonicCore", 'C', gen(37) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 63),
                new Object[] { "#@#", "ACA", "#@#", '#', gen(59), '@', gen(74), 'C', gen(9), 'A', gen(32) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 64),
                new Object[] { "#@#", "@C@", "#@#", '#', gen(74), '@', gen(59), 'C', gen(75) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 60),
                new Object[] { "#@#", "@@@", "#@#", '#', gen(74), '@', gen(59) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 62),
                new Object[] { "#@#", "$#$", "P#P", '#', gen(68), '@', gen(67), '$', gen(60), 'P', gen(59) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 56),
                new Object[] { "#+#", "/C*", "#-#", '#', gen(59), 'C', gen(69), '+', gen(70), '-', gen(73), '*',
                    gen(72), '/', gen(71) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 61),
                new Object[] { "#@#", "@C@", "#@#", '#', gen(67), '@', gen(68), 'C', gen(59) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 58),
                new Object[] { "#@#", "@C@", "#@#", '#', gen(66), '@', gen(67), 'C', gen(65) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 57),
                new Object[] { "#@#", "@C@", "#@#", '#', gen(68), '@', gen(65), 'C',
                    new ItemStack(ECItems.storage, 1, 4) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.genericItem, 1, 75),
                new Object[] { "#C#", "767", "#C#", '#', "plateDemonic", 'C', "demonicCore", '7', gen(74), '6',
                    gen(60) }));

        // Armor

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.computer_helmet, 1, 0),
                new Object[] { "FCF", "SLS", "EOE", 'F', gen(58), 'C', gen(57), 'S', gen(64), 'L', gen(63), 'E',
                    gen(59), 'O', gen(60) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.computer_chestplate, 1, 0),
                new Object[] { "R*S", "FCF", "ETE", 'R', gen(61), '*', gen(56), 'S', gen(60), 'F', gen(58), 'C',
                    gen(57), 'E', gen(59), 'T', gen(62) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.computer_leggings, 1, 0),
                new Object[] { "FRF", "TCT", "ESE", 'R', gen(61), 'S', gen(60), 'F', gen(58), 'C', gen(57), 'E',
                    gen(59), 'T', gen(62) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.computer_boots, 1, 0),
                new Object[] { "FSF", "ECE", "SFS", 'S', gen(60), 'F', gen(58), 'C', gen(57), 'E', gen(59) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.computerBoard, 1, 0),
                new Object[] { "SCS", "EEE", "RTR", 'R', gen(61), 'S', gen(60), 'C', gen(57), 'E', gen(59), 'T',
                    gen(62) }));
        // TODO 4.5 recipes
        addRecipe(
            new ItemStack(ECBlocks.mithrilineFurnace, 1, 0),
            new Object[] { "dustMithriline", "gemMithriline", "dustMithriline", "plateEmerald", Blocks.furnace,
                "plateEmerald", "ingotMithriline", "rodHeat", "ingotMithriline", });
        addRecipe(
            new ItemStack(ECBlocks.playerPentacle, 1, 0),
            new Object[] { "dustMithriline", ECItems.matrixProj, "dustMithriline", ECItems.matrixProj,
                ECItems.soulStone, ECItems.matrixProj, "dustMithriline", ECItems.matrixProj, "dustMithriline", });
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.redstoneTransmitter, 2, 0),
                new Object[] { "   ", "RTR", "SSS", 'S', ECBlocks.fortifiedStone, 'R', "dustRedstone", 'T',
                    Blocks.redstone_torch }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.magicalHopper, 1, 0),
                new Object[] { "SHS", "SCS", "SDS", 'S', ECBlocks.fortifiedStone, 'H', Blocks.hopper, 'C', Blocks.chest,
                    'D', Blocks.dropper }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.rightClicker, 1, 0),
                new Object[] { "SSS", "DID", "SPS", 'S', ECBlocks.fortifiedStone, 'P', Blocks.piston, 'I',
                    Blocks.dispenser, 'D', Blocks.dropper }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.windRune, 1, 0),
                new Object[] { "MPM", "PEP", "MPM", 'M', ECBlocks.invertedBlock, 'E', "elementalCore", 'P',
                    "plateMithriline" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.metadataManager, 1, 0),
                new Object[] { "SSS", "SBR", "SSS", 'S', ECBlocks.fortifiedStone, 'R', "dustRedstone", 'B',
                    ECItems.bound_gem }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.blockBreaker, 1, 0),
                new Object[] { "SSS", "SRP", "SSS", 'S', ECBlocks.fortifiedStone, 'R', "dustRedstone", 'P',
                    ECItems.weak_elemental_pick }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.rightClicker, 1, 1),
                new Object[] { new ItemStack(ECBlocks.rightClicker, 1, 0), new ItemStack(Items.slime_ball, 1, 0) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.rightClicker, 1, 2),
                new Object[] { new ItemStack(ECBlocks.rightClicker, 1, 0), new ItemStack(Blocks.chest, 1, 0) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.rightClicker, 1, 3),
                new Object[] { new ItemStack(ECBlocks.rightClicker, 1, 2), new ItemStack(Items.slime_ball, 1, 0) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.rightClicker, 1, 4),
                new Object[] { new ItemStack(ECBlocks.rightClicker, 1, 2), new ItemStack(Items.redstone, 1, 0) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.rightClicker, 1, 5),
                new Object[] { new ItemStack(ECBlocks.rightClicker, 1, 4), new ItemStack(Items.slime_ball, 1, 0) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.compressed, 1, 0),
                new Object[] { new ItemStack(ECItems.drops, 1, 0), new ItemStack(ECItems.drops, 1, 0),
                    new ItemStack(ECItems.drops, 1, 0), new ItemStack(ECItems.drops, 1, 0),
                    new ItemStack(ECItems.drops, 1, 0), new ItemStack(ECItems.drops, 1, 0),
                    new ItemStack(ECItems.drops, 1, 0), new ItemStack(ECItems.drops, 1, 0),
                    new ItemStack(ECItems.drops, 1, 0), }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.compressed, 1, 1),
                new Object[] { new ItemStack(ECItems.drops, 1, 1), new ItemStack(ECItems.drops, 1, 1),
                    new ItemStack(ECItems.drops, 1, 1), new ItemStack(ECItems.drops, 1, 1),
                    new ItemStack(ECItems.drops, 1, 1), new ItemStack(ECItems.drops, 1, 1),
                    new ItemStack(ECItems.drops, 1, 1), new ItemStack(ECItems.drops, 1, 1),
                    new ItemStack(ECItems.drops, 1, 1), }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.compressed, 1, 2),
                new Object[] { new ItemStack(ECItems.drops, 1, 2), new ItemStack(ECItems.drops, 1, 2),
                    new ItemStack(ECItems.drops, 1, 2), new ItemStack(ECItems.drops, 1, 2),
                    new ItemStack(ECItems.drops, 1, 2), new ItemStack(ECItems.drops, 1, 2),
                    new ItemStack(ECItems.drops, 1, 2), new ItemStack(ECItems.drops, 1, 2),
                    new ItemStack(ECItems.drops, 1, 2), }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.compressed, 1, 3),
                new Object[] { new ItemStack(ECItems.drops, 1, 3), new ItemStack(ECItems.drops, 1, 3),
                    new ItemStack(ECItems.drops, 1, 3), new ItemStack(ECItems.drops, 1, 3),
                    new ItemStack(ECItems.drops, 1, 3), new ItemStack(ECItems.drops, 1, 3),
                    new ItemStack(ECItems.drops, 1, 3), new ItemStack(ECItems.drops, 1, 3),
                    new ItemStack(ECItems.drops, 1, 3), }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECBlocks.compressed, 1, 4),
                new Object[] { new ItemStack(ECItems.drops, 1, 4), new ItemStack(ECItems.drops, 1, 4),
                    new ItemStack(ECItems.drops, 1, 4), new ItemStack(ECItems.drops, 1, 4),
                    new ItemStack(ECItems.drops, 1, 4), new ItemStack(ECItems.drops, 1, 4),
                    new ItemStack(ECItems.drops, 1, 4), new ItemStack(ECItems.drops, 1, 4),
                    new ItemStack(ECItems.drops, 1, 4), }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.drops, 9, 0),
                new Object[] { new ItemStack(ECBlocks.compressed, 1, 0) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.drops, 9, 1),
                new Object[] { new ItemStack(ECBlocks.compressed, 1, 1) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.drops, 9, 2),
                new Object[] { new ItemStack(ECBlocks.compressed, 1, 2) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.drops, 9, 3),
                new Object[] { new ItemStack(ECBlocks.compressed, 1, 3) }));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.drops, 9, 4),
                new Object[] { new ItemStack(ECBlocks.compressed, 1, 4) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.demonicPentacle, 1, 0),
                new Object[] { "FVF", "VCV", "FVF", 'F', "focusFire", 'V', "plateVoid", 'C', "voidCore" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.weaponMaker, 1, 0),
                new Object[] { "SIS", "SCS", "SSS", 'S', ECBlocks.fortifiedStone, 'I',
                    Blocks.heavy_weighted_pressure_plate, 'C', Blocks.crafting_table }));
        GameRegistry
            .addShapelessRecipe(new ItemStack(ECBlocks.weaponMaker, 1, 1), new ItemStack(ECBlocks.weaponMaker, 1, 0));
        GameRegistry
            .addShapelessRecipe(new ItemStack(ECBlocks.weaponMaker, 1, 2), new ItemStack(ECBlocks.weaponMaker, 1, 1));
        GameRegistry
            .addShapelessRecipe(new ItemStack(ECBlocks.weaponMaker, 1, 3), new ItemStack(ECBlocks.weaponMaker, 1, 2));
        GameRegistry
            .addShapelessRecipe(new ItemStack(ECBlocks.weaponMaker, 1, 0), new ItemStack(ECBlocks.weaponMaker, 1, 3));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_elemental_hoe, 1, 0),
                new Object[] { "DD ", " S ", " S ", 'D', "gemWind", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_elemental_axe, 1, 0),
                new Object[] { "DD ", "DS ", " S ", 'D', "gemWind", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_elemental_pick, 1, 0),
                new Object[] { "DDD", " S ", " S ", 'D', "gemWind", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_elemental_shovel, 1, 0),
                new Object[] { " D ", " S ", " S ", 'D', "gemWind", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_elemental_sword, 1, 0),
                new Object[] { " D ", " D ", " S ", 'D', "gemWind", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.soulScriber, 1, 0),
                new Object[] { "N", "Q", "S", 'N', Items.netherbrick, 'S', "stickWood", 'Q', Items.quartz }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.weak_elemental_hoe, 1, 0),
                new Object[] { "DD ", " S ", " S ", 'D', "blockElemental", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.weak_elemental_axe, 1, 0),
                new Object[] { "DD ", "DS ", " S ", 'D', "blockElemental", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.weak_elemental_pick, 1, 0),
                new Object[] { "DDD", " S ", " S ", 'D', "blockElemental", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.weak_elemental_shovel, 1, 0),
                new Object[] { " D ", " S ", " S ", 'D', "blockElemental", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.weak_elemental_sword, 1, 0),
                new Object[] { " D ", " D ", " S ", 'D', "blockElemental", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_helmet, 1, 0),
                new Object[] { "DDD", "D D", 'D', "gemWind" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_chestplate, 1, 0),
                new Object[] { "D D", "DDD", "DDD", 'D', "gemWind" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_leggings, 1, 0),
                new Object[] { "DDD", "DDD", "D D", 'D', "gemWind" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wind_boots, 1, 0),
                new Object[] { "D D", "D D", 'D', "gemWind" }));

        // TODO 4.6 Recipes
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.chest, 1, 0),
                new Object[] { "###", "# #", "###", '#',
                    new ItemStack(ECBlocks.magicPlating, 1, OreDictionary.WILDCARD_VALUE) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.chest, 1, 1),
                new Object[] { "###", "# #", "###", '#',
                    new ItemStack(ECBlocks.voidStone, 1, OreDictionary.WILDCARD_VALUE) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.device, 1, 0),
                new Object[] { "#@#", "#R#", "###", '#',
                    new ItemStack(ECBlocks.fortifiedStone, 1, OreDictionary.WILDCARD_VALUE), 'R', "dustRedstone", '@',
                    ECItems.weak_elemental_hoe }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.device, 1, 1),
                new Object[] { "#@#", "#R#", "###", '#',
                    new ItemStack(ECBlocks.fortifiedStone, 1, OreDictionary.WILDCARD_VALUE), 'R', "dustRedstone", '@',
                    Items.water_bucket }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.device, 1, 2),
                new Object[] { "#@#", "#R#", "#@#", '#',
                    new ItemStack(ECBlocks.fortifiedStone, 1, OreDictionary.WILDCARD_VALUE), 'R', "dustRedstone", '@',
                    Blocks.crafting_table }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.device, 1, 3),
                new Object[] { "#@#", "#R#", "###", '#',
                    new ItemStack(ECBlocks.fortifiedStone, 1, OreDictionary.WILDCARD_VALUE), 'R', "dustRedstone", '@',
                    Blocks.hay_block }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.device, 1, 5),
                new Object[] { "#@#", "#R#", "###", '#',
                    new ItemStack(ECBlocks.fortifiedStone, 1, OreDictionary.WILDCARD_VALUE), 'R', "dustRedstone", '@',
                    Items.shears }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.device, 1, 6),
                new Object[] { "#@#", "#R#", "###", '#',
                    new ItemStack(ECBlocks.fortifiedStone, 1, OreDictionary.WILDCARD_VALUE), 'R', "dustRedstone", '@',
                    Items.golden_apple }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.device, 1, 7),
                new Object[] { "#@#", "#R#", "###", '#',
                    new ItemStack(ECBlocks.fortifiedStone, 1, OreDictionary.WILDCARD_VALUE), 'R', "dustRedstone", '@',
                    Items.apple }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.advBreaker, 1, 0),
                new Object[] { " R ", "RBR", " C ", 'B', ECBlocks.blockBreaker, 'R', "dustRedstone", 'C',
                    Blocks.chest }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.craftingFrame, 1, 0),
                new Object[] { "#@#", "@#@", "#@#", '#', Blocks.crafting_table, '@', "plateFortified" }));

        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ECItems.inventoryGem, 1, 0),
                new Object[] { "shardElemental", gen(12) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.filter, 1, 2),
                new Object[] { " @ ", "@#@", " @ ", '#', Blocks.crafting_table, '@', "plateObsidian" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.filter, 1, 3),
                new Object[] { " @ ", "@#@", " @ ", '#', new ItemStack(ECItems.filter, 1, 2), '@', "plateVoid" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.mimEjector),
                new Object[] { " @ ", "#C#", "#E#", '#', gen(34), '@', "ec3:gemEnderPearl", 'C', "elementalCore", 'E',
                    "plateEnder" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.mimInjector),
                new Object[] { " @ ", "#C#", "#E#", '#', gen(34), '@', gen(23), 'C', "elementalCore", 'E',
                    "plateEnder" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.mimEjectorP),
                new Object[] { " @ ", "#C#", "#E#", '#', "plateMithriline", '@', "ec3:gemEnderPearl", 'C',
                    "elementalCore", 'E', "plateEnder" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.mimInjectorP),
                new Object[] { " @ ", "#C#", "#E#", '#', "plateMithriline", '@', gen(23), 'C', "elementalCore", 'E',
                    "plateEnder" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.newMim),
                new Object[] { "VPV", "CRC", "PMP", 'P', "plateVoid", 'V', new ItemStack(ECBlocks.chest, 1, 1), 'C',
                    "voidCore", 'R', "voidMRU", 'M', "redSoulMatter" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.mimScreen),
                new Object[] { "DDD", "PCP", "PMP", 'P', "plateMagic", 'D', "screenMagic", 'C', "elementalCore", 'M',
                    "mruCatcher" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.mimInvStorage),
                new Object[] { "PPP", "SCS", "PPP", 'P', "plateMagic", 'C', "elementalCore", 'S', ECBlocks.chest }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.mimCrafter),
                new Object[] { "PPP", "SCS", "PPP", 'P', "plateMagic", 'C', "elementalCore", 'S',
                    Blocks.crafting_table }));

        addRecipe(
            new ItemStack(ECBlocks.voidStone, 16, 0),
            new Object[] { "titanite", "plateObsidian", "titanite", "plateObsidian", "ttitanite", "plateObsidian",
                "titanite", "plateObsidian", "titanite", });
        addRecipe(
            new ItemStack(ECBlocks.sunRayAbsorber, 1, 0),
            10000,
            new Object[] { "screenMagic", new ItemStack(ECItems.genericItem, 1, 32), "mruCatcher", "worldInteractor",
                "elementalCore", "conversionMatrix", "plateMagic", new ItemStack(ECItems.matrixProj, 1, 1),
                "plateMagic", });
        addRecipe(
            new ItemStack(ECBlocks.moonWell, 1, 0),
            10000,
            new Object[] { "screenMagic", new ItemStack(ECBlocks.elementalCrystal, 1, 0), "mruCatcher",
                "worldInteractor", "elementalCore", "conversionMatrix", "plateMagic",
                new ItemStack(ECItems.matrixProj, 1, 3), "plateMagic", });
        // TODO assembler Recipes
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elemental_hoe, 1, 0),
                new Object[] { "DD ", " S ", " S ", 'D', "resonatingCrystal", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elemental_axe, 1, 0),
                new Object[] { "DD ", "DS ", " S ", 'D', "resonatingCrystal", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elemental_pick, 1, 0),
                new Object[] { "DDD", " S ", " S ", 'D', "resonatingCrystal", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elemental_shovel, 1, 0),
                new Object[] { " D ", " S ", " S ", 'D', "resonatingCrystal", 'S', "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elemental_sword, 1, 0),
                new Object[] { " D ", " D ", " S ", 'D', "resonatingCrystal", 'S', "stickWood" }));

        addRecipe(
            new ItemStack(ECItems.biomeWand, 1, 0),
            1200,
            new Object[] { "redSoulMatter", "focusFire", "focusAir", "plateEmerald", "ingotThaumium", "focusWater",
                "focusEarth", "plateEmerald", "redSoulMatter", });

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.magicMonocle, 1, 0),
                new Object[] { " DS", " D ", " D ", 'D', new ItemStack(ECItems.genericItem, 1, 10), 'S',
                    "plateGlass" }));

        addRecipe(
            new ItemStack(ECItems.genericItem, 1, 17),
            new Object[] { "alloysMagical", "plateGlass", "alloysMagical", "plateEnder", Blocks.chest, "plateEnder",
                "alloysMagical", "plateGlass", "alloysMagical", });

        addRecipe(
            new ItemStack(ECItems.genericItem, 3, 18),
            new Object[] { "alloysMagical", "plateRedstone", "alloysMagical", "plateRedstone", Items.cake,
                "plateRedstone", "alloysMagical", "plateRedstone", "alloysMagical", });

        addRecipe(
            new ItemStack(ECItems.genericItem, 1, 80),
            new Object[] { "alloysMagical", "plateDiamond", "alloysMagical", "plateEmerald", Items.golden_apple,
                "plateEmerald", "alloysMagical", "plateDiamond", "alloysMagical", });

        addRecipe(
            new ItemStack(ECItems.genericItem, 1, 81),
            new Object[] { "alloysMagical", "plateObsidian", "alloysMagical", "plateObsidian", Items.ender_eye,
                "plateObsidian", "alloysMagical", "plateObsidian", "alloysMagical", });

        addRecipe(
            new ItemStack(ECItems.genericItem, 3, 78),
            new Object[] { "alloysMagical", "platePale", "alloysMagical", "platePale", "gemPale", "platePale",
                "alloysMagical", "platePale", "alloysMagical", });

        addRecipe(
            new ItemStack(ECItems.genericItem, 1, 77),
            new Object[] { "alloysMagical", gen(79), "alloysMagical", gen(79), Items.lava_bucket, gen(79),
                "alloysMagical", gen(79), "alloysMagical", });

        addRecipe(
            new ItemStack(ECItems.genericItem, 3, 19),
            new Object[] { "alloysMagical", "plateEnder", "alloysMagical", "plateEnder", "dustCrystal", "plateEnder",
                "alloysMagical", "plateEnder", "alloysMagical", });

        addRecipe(
            new ItemStack(ECItems.spawnerCollector, 1, 0),
            10000,
            new Object[] { "dustCrystal", "focusWater", "focusWater", "ingotMagic", "redSoulMatter", "focusWater",
                "plateMagic", "ingotMagic", "dustCrystal", });

        addRecipe(
            new ItemStack(ECItems.magicalDigger, 1, 0),
            10000,
            new Object[] { Blocks.tnt, "focusEarth", "redSoulMatter", "focusFire", ECItems.elemental_pick, "focusEarth",
                "plateMagic", "focusFire", Blocks.tnt, });

        addRecipe(
            new ItemStack(ECItems.staffOfLife, 1, 0),
            1000,
            new Object[] { ECItems.elemental_hoe, "focusEarth", new ItemStack(ECItems.genericItem, 1, 4), "focusEarth",
                "redSoulMatter", "focusEarth", "plateMagic", "focusEarth", ECItems.elemental_hoe, });

        addRecipe(
            new ItemStack(ECItems.emeraldHeart, 1, 0),
            5000,
            new Object[] { "focusEarth", "gemEmerald", "focusEarth", "magicWater", "redSoulMatter", "magicWater",
                "focusWater", Items.apple, "focusWater", });
        addRecipe(
            new ItemStack(ECItems.magicalShield, 1, 0),
            5000,
            new Object[] { "plateObsidian", "alloysMagical", "plateObsidian", "focusEarth", "redSoulMatter",
                "focusEarth", "dustCrystal", "plateObsidian", "dustCrystal", });
        addRecipe(
            new ItemStack(ECItems.spikyShield, 1, 0),
            10000,
            new Object[] { ECItems.elemental_sword, "gemNetherStar", ECItems.elemental_sword, "alloysMagical",
                ECItems.magicalShield, "alloysMagical", "alloysMagical", "matterOfEternity", "alloysMagical", });
        addRecipe(
            new ItemStack(ECItems.magicWaterBottle, 1, 0),
            5000,
            new Object[] { "focusAir", "magicWater", "focusEarth", "plateDiamond", "redSoulMatter", "plateDiamond",
                "focusWater", "magicWater", "focusWater", });
        addRecipe(
            new ItemStack(ECItems.magicalPorkchop, 1, 0),
            5000,
            new Object[] { "focusEarth", Items.porkchop, "focusEarth", "dustCrystal", "redSoulMatter", "dustCrystal",
                "focusWater", "dustCrystal", "focusWater", });
        addRecipe(
            new ItemStack(ECItems.magicalWings, 1, 0),
            5000,
            new Object[] { "plateMagic", "focusAir", "focusAir", "plateMagic", Items.feather, Items.feather,
                "redSoulMatter", Items.feather, Items.feather, });
        addRecipe(
            new ItemStack(ECItems.holyMace, 1, 0),
            1000,
            new Object[] { "redSoulMatter", "focusAir", new ItemStack(ECItems.genericItem, 1, 4), "ingotMagic",
                ECItems.elemental_sword, "focusAir", "focusEarth", "ingotMagic", "redSoulMatter", });
        addRecipe(
            new ItemStack(ECItems.chaosFork, 1, 0),
            10000,
            new Object[] { "ingotMagic", "focusFire", "matterOfEternity", "ingotMagic", ECItems.elemental_sword,
                "focusFire", new ItemStack(ECItems.matrixProj, 1, 1), "ingotMagic", "ingotMagic", });
        addRecipe(
            new ItemStack(ECItems.frozenMace, 1, 0),
            10000,
            new Object[] { "ingotMagic", "focusWater", "matterOfEternity", "ingotMagic", ECItems.elemental_sword,
                "focusWater", new ItemStack(ECItems.matrixProj, 1, 2), "ingotMagic", "ingotMagic", });

        addRecipe(
            new ItemStack(ECItems.windTablet, 1, 0),
            10000,
            new Object[] { "focusAir", "plateFortified", "focusAir", "plateFortified", ECItems.windKeeper,
                "plateFortified", "focusAir", "plateFortified", "focusAir", });

        addRecipe(
            new ItemStack(ECBlocks.magicalTeleporter, 1, 0),
            10000,
            new Object[] { "screenMagic", "voidMRU", "worldInteractor", "plateMagic", "voidCore", "plateMagic",
                "plateVoid", "matterOfEternity", "plateVoid", });
        /*
         * addRecipe(new ItemStack(BlocksCore.mim,1,0),10000,new Object[]{
         * "screenMagic","voidMRU","screenMagic",
         * "plateVoid","voidCore","plateVoid",
         * "plateVoid","plateVoid","plateVoid",
         * });
         * addRecipe(new ItemStack(BlocksCore.darknessObelisk,1,0),1000,new Object[]{
         * "plateVoid","voidMRU","plateVoid",
         * "plateVoid","matterOfEternity","plateVoid",
         * "plateVoid","voidMRU","plateVoid",
         * });
         */
        addRecipe(
            new ItemStack(ECBlocks.ultraHeatGen, 1, 0),
            5000,
            new Object[] { "plateVoid", "voidMRU", "plateVoid", "voidCore", new ItemStack(ECBlocks.heatGenerator),
                "voidCore", "plateVoid", "voidMRU", "plateVoid", });
        addRecipe(
            new ItemStack(ECBlocks.ultraFlowerBurner, 1, 0),
            5000,
            new Object[] { "plateVoid", "voidMRU", "plateVoid", "voidCore", new ItemStack(ECBlocks.naturalFurnace),
                "voidCore", "plateVoid", "voidMRU", "plateVoid", });

        addRecipe(
            new ItemStack(ECBlocks.magicalFurnace, 1, 0),
            10000,
            new Object[] { "screenMagic", "voidMRU", "worldInteractor", "plateFortified", "voidCore", "plateFortified",
                "plateVoid", "matterOfEternity", "plateVoid", });

        addRecipe(
            new ItemStack(ECBlocks.emberForge, 1, 0),
            10000,
            new Object[] { "screenMagic", "voidMRU", "plateEnder", "plateFortified", "voidCore", "plateFortified",
                "plateVoid", "matterOfEternity", "plateVoid", });

        addRecipe(
            new ItemStack(ECItems.magicArmorItems[0], 1, 0),
            2000,
            new Object[] { "alloysMagical", "worldInteractor", "alloysMagical", "plateMagic", "plateGlass",
                "plateMagic", "dustCrystal", "dustCrystal", "dustCrystal", });

        addRecipe(
            new ItemStack(ECItems.magicArmorItems[1], 1, 0),
            5000,
            new Object[] { "worldInteractor", "dustCrystal", "worldInteractor", "plateMagic", "alloysMagical",
                "plateMagic", "plateMagic", "alloysMagical", "plateMagic", });

        addRecipe(
            new ItemStack(ECItems.magicArmorItems[2], 1, 0),
            3500,
            new Object[] { "alloysMagical", "worldInteractor", "alloysMagical", "plateMagic", "dustCrystal",
                "plateMagic", "plateMagic", "dustCrystal", "plateMagic", });

        addRecipe(
            new ItemStack(ECItems.magicArmorItems[3], 1, 0),
            2000,
            new Object[] { "dustCrystal", "worldInteractor", "dustCrystal", "plateMagic", "dustCrystal", "plateMagic",
                "alloysMagical", "dustCrystal", "alloysMagical", });

        addRecipe(
            new ItemStack(ECItems.magicArmorItems[4], 1, 0),
            10000,
            new Object[] { "gemNetherStar", "voidMRU", "gemNetherStar", "voidCore",
                new ItemStack(ECItems.magicArmorItems[0], 1, 0), "voidCore", "plateVoid", "matterOfEternity",
                "plateVoid", });

        addRecipe(
            new ItemStack(ECItems.magicArmorItems[5], 1, 0),
            10000,
            new Object[] { "voidMRU", "gemNetherStar", "voidMRU", "voidCore",
                new ItemStack(ECItems.magicArmorItems[1], 1, 0), "voidCore", "plateVoid", "matterOfEternity",
                "plateVoid", });

        addRecipe(
            new ItemStack(ECItems.magicArmorItems[6], 1, 0),
            10000,
            new Object[] { "gemNetherStar", "voidMRU", "gemNetherStar", "voidCore",
                new ItemStack(ECItems.magicArmorItems[2], 1, 0), "voidCore", "plateVoid", "matterOfEternity",
                "plateVoid", });

        addRecipe(
            new ItemStack(ECItems.magicArmorItems[7], 1, 0),
            10000,
            new Object[] { "gemNetherStar", "voidMRU", "gemNetherStar", "voidCore",
                new ItemStack(ECItems.magicArmorItems[3], 1, 0), "voidCore", "plateVoid", "matterOfEternity",
                "plateVoid", });

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.fence[0], 16, 0),
                new Object[] { "   ", "DDD", "DDD", 'D', ECBlocks.voidStone }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.fence[1], 16, 0),
                new Object[] { "   ", "DDD", "DDD", 'D', ECBlocks.magicPlating }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECBlocks.fence[2], 16, 0),
                new Object[] { "   ", "DDD", "DDD", 'D', ECBlocks.fortifiedStone }));

        addRecipe(
            new ItemStack(ECItems.magmaticStaff, 1, 0),
            1000,
            new Object[] { "focusFire", "focusFire", ECBlocks.magmaticSmeltery, "dustCrystal", "redSoulMatter",
                "focusFire", "plateMagic", "dustCrystal", "focusFire", });

        addRecipe(
            new ItemStack(ECItems.magicalLantern, 1, 0),
            1000,
            new Object[] { "focusAir", "focusFire", "redSoulMatter", ECItems.magicalSlag, "plateMagic", "focusFire",
                "plateMagic", ECItems.magicalSlag, "focusAir", });

        addRecipe(
            new ItemStack(ECItems.magnetizingStaff, 1, 0),
            1000,
            new Object[] { "focusAir", "orbGold", "darkSoulMatter", ECItems.magicalSlag, "plateMagic", "orbGold",
                "plateMagic", ECItems.magicalSlag, "focusAir", });

        addRecipe(
            new ItemStack(ECBlocks.mruCoilHardener, 3, 0),
            1000,
            new Object[] { "plateMagic", "elementalCore", "plateMagic", "plateMagic", "magnet", "plateMagic",
                "plateMagic", "mruLink", "plateMagic", });

        addRecipe(
            new ItemStack(ECBlocks.mruCoil, 1, 0),
            10000,
            new Object[] { "worldInteractor", "resonatingCrystal", "screenMagic", "plateMagic", "magnet", "plateMagic",
                "mruLink", new ItemStack(ECItems.matrixProj, 1, 3), "mruLink", });

        addRecipe(
            new ItemStack(ECBlocks.corruptionCleaner, 1, 0),
            1000,
            new Object[] { "screenMagic", "elementalCore", "plateFortified", "plateRedstone", "resonatingCrystal",
                "plateEnder", "plateFortified", "worldInteractor", "plateFortified", });

        addRecipe(
            new ItemStack(ECBlocks.reactorSupport, 2, 0),
            10000,
            new Object[] { "magnet", "resonatingCrystal", "magnet", "plateMagic", "elementalCore", "plateMagic",
                "plateMagic", "plateEnder", "plateMagic", });

        addRecipe(
            new ItemStack(ECBlocks.reactor, 1, 0),
            10000,
            new Object[] { new ItemStack(ECItems.matrixProj, 1, 3), "gemNetherStar",
                new ItemStack(ECItems.matrixProj, 1, 3), "resonatingCrystal", "magnet", "resonatingCrystal",
                "plateMagic", "plateMagic", "plateMagic", });

        ItemStack book = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book)
            .setInteger("tier", 0);

        addRecipe(
            book,
            new Object[] { "dyeRed", "itemBook", "itemFeather", "dyeGreen", "itemBook", "dyeBlack", "dyeBlue",
                "itemBook", "dyeBlack", });

        ItemStack book_t1 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t1)
            .setInteger("tier", 1);

        addRecipe(
            book_t1,
            new Object[] { "elementalCore", "shardElemental", "elementalCore", "shardElemental", book, "shardElemental",
                "elementalCore", "shardElemental", "elementalCore", });

        ItemStack book_t2 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t2)
            .setInteger("tier", 2);

        ItemStack book_t3 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t3)
            .setInteger("tier", 3);

        addRecipe(
            book_t3,
            new Object[] { "plateVoid", "resonatingCrystal", "plateVoid", "resonatingCrystal", book_t2,
                "resonatingCrystal", "plateVoid", "resonatingCrystal", "plateVoid", });

        registerEFuelCrafts();
        registerCharmsCraft();
    }

    public void addRecipe(ItemStack output, Object... recipe) {
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                output,
                new Object[] { "123", "456", "789", '1', recipe[0], '2', recipe[1], '3', recipe[2], '4', recipe[3], '5',
                    recipe[4], '6', recipe[5], '7', recipe[6], '8', recipe[7], '9', recipe[8], }));
    }

    public void addRecipe(ItemStack output, int mruReq, Object... recipe) {
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                output,
                new Object[] { "123", "456", "789", '1', recipe[0], '2', recipe[1], '3', recipe[2], '4', recipe[3], '5',
                    recipe[4], '6', recipe[5], '7', recipe[6], '8', recipe[7], '9', recipe[8], }));
    }

    public void registerRadiatingChamber() {
        // TODO RadiatingChamberRecipes
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Blocks.stone), new ItemStack(Items.iron_ingot) },
            getItemByNameEC3("fortifiedStone", 0),
            10,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            4);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Blocks.glass), new ItemStack(Items.iron_ingot) },
            getItemByNameEC3("fortifiedGlass", 0),
            10,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            4);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.redstone), new ItemStack(Items.blaze_powder) },
            getItemByNameEC3("genericItem", 3),
            100,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            1);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("soulStone", 0), null },
            getItemByNameEC3("matrixProj", 0),
            1000,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            1);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("matrixProj", 0), null },
            getItemByNameEC3("matrixProj", 1),
            10000,
            new float[] { Float.MAX_VALUE, 1.5F },
            1);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("matrixProj", 0), null },
            getItemByNameEC3("matrixProj", 2),
            10000,
            new float[] { 0.5F, Float.MIN_VALUE },
            1);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("matrixProj", 0), null },
            getItemByNameEC3("matrixProj", 3),
            20000,
            new float[] { 1.49F, 0.69F },
            1);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.dye, 1, 4), new ItemStack(Items.glowstone_dust) },
            getItemByNameEC3("genericItem", 38),
            250,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            20,
            1);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Blocks.lapis_block, 1, 0), new ItemStack(Items.gold_ingot) },
            getItemByNameEC3("genericItem", 39),
            100,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            80,
            4);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(ECBlocks.blockPale, 1, 0), new ItemStack(Items.diamond) },
            getItemByNameEC3("genericItem", 40),
            250,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            120,
            4);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(ECBlocks.blockPale, 1, 0), new ItemStack(Items.emerald) },
            getItemByNameEC3("genericItem", 40),
            300,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            100,
            4);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Blocks.stone), new ItemStack(ECItems.drops, 1, 4) },
            getItemByNameEC3("genericItem", 42),
            100,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            10,
            1);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.iron_ingot), new ItemStack(ECItems.genericItem, 1, 3) },
            getItemByNameEC3("genericItem", 43),
            1000,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            1,
            1);
        RadiatingChamberRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.diamond), new ItemStack(Items.emerald) },
            getItemByNameEC3("genericItem", 44),
            100,
            new float[] { Float.MAX_VALUE, Float.MIN_VALUE },
            50,
            1);
    }

    public void registerMagicianTable() {
        // TODO MagicianTableRecipes
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 7), getItemByNameEC3("genericItem", 79),
                getItemByNameEC3("genericItem", 8), getItemByNameEC3("genericItem", 8),
                getItemByNameEC3("genericItem", 79) },
            getItemByNameEC3("genericItem", 0),
            10000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 7), getItemByNameEC3("genericItem", 8),
                getItemByNameEC3("genericItem", 79), getItemByNameEC3("genericItem", 79),
                getItemByNameEC3("genericItem", 8) },
            getItemByNameEC3("genericItem", 0),
            10000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.ender_pearl), getItemByNameEC3("genericItem", 10),
                getItemByNameEC3("genericItem", 10), getItemByNameEC3("genericItem", 10),
                getItemByNameEC3("genericItem", 10) },
            getItemByNameEC3("genericItem", 4),
            5000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.iron_ingot), null, null, null, null },
            getItemByNameEC3("genericItem", 5),
            50);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.potionitem), null, null, null, null },
            getItemByNameEC3("genericItem", 6),
            250);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("fortifiedStone", OreDictionary.WILDCARD_VALUE), null, null, null,
                null },
            getItemByNameEC3("genericItem", 7),
            10);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 7), new ItemStack(Items.ender_pearl),
                new ItemStack(Items.ender_pearl), new ItemStack(Items.ender_pearl), new ItemStack(Items.ender_pearl) },
            getItemByNameEC3("genericItem", 8),
            1000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 7), new ItemStack(Blocks.glass),
                new ItemStack(Blocks.glass), new ItemStack(Blocks.glass), new ItemStack(Blocks.glass) },
            getItemByNameEC3("genericItem", 9),
            1000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget),
                new ItemStack(Items.gold_nugget), new ItemStack(Items.gold_nugget), new ItemStack(Items.gold_nugget) },
            getItemByNameEC3("genericItem", 10),
            250);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 7), new ItemStack(Items.redstone),
                new ItemStack(Items.redstone), new ItemStack(Items.redstone), new ItemStack(Items.redstone) },
            getItemByNameEC3("genericItem", 11),
            1000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.quartz), null, null, null, null },
            getItemByNameEC3("genericItem", 12),
            10);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 12), null, null, null, null },
            getItemByNameEC3("genericItem", 13),
            100);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 13), null, null, null, null },
            getItemByNameEC3("genericItem", 14),
            200);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 14), null, null, null, null },
            getItemByNameEC3("genericItem", 15),
            500);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 15), null, null, null, null },
            getItemByNameEC3("genericItem", 16),
            1000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 3), null, null, null, null },
            getItemByNameEC3("genericItem", 20),
            3000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 9), getItemByNameEC3("genericItem", 21),
                getItemByNameEC3("genericItem", 22), getItemByNameEC3("genericItem", 22),
                getItemByNameEC3("genericItem", 21) },
            getItemByNameEC3("genericItem", 32),
            10000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 9), getItemByNameEC3("genericItem", 22),
                getItemByNameEC3("genericItem", 21), getItemByNameEC3("genericItem", 21),
                getItemByNameEC3("genericItem", 22) },
            getItemByNameEC3("genericItem", 32),
            10000);
        MagicianTableRecipes.addRecipeIS(
            new UnformedItemStack[] { new UnformedItemStack(getItemByNameEC3("genericItem", 7)),
                new UnformedItemStack("ingotThaumium"), new UnformedItemStack("ingotThaumium"),
                new UnformedItemStack("ingotThaumium"), new UnformedItemStack("ingotThaumium") },
            getItemByNameEC3("genericItem", 34),
            100);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 7), getItemByNameEC3("genericItem", 39),
                getItemByNameEC3("genericItem", 39), getItemByNameEC3("genericItem", 39),
                getItemByNameEC3("genericItem", 39) },
            getItemByNameEC3("genericItem", 41),
            100);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.quartz), getItemByNameEC3("genericItem", 12),
                getItemByNameEC3("genericItem", 12), getItemByNameEC3("genericItem", 12),
                getItemByNameEC3("genericItem", 12) },
            getItemByNameEC3("storage", 0),
            100);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.emerald), getItemByNameEC3("genericItem", 13),
                getItemByNameEC3("genericItem", 13), getItemByNameEC3("genericItem", 13),
                getItemByNameEC3("genericItem", 13) },
            getItemByNameEC3("storage", 1),
            500);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.ender_pearl), getItemByNameEC3("genericItem", 14),
                getItemByNameEC3("genericItem", 14), getItemByNameEC3("genericItem", 14),
                getItemByNameEC3("genericItem", 14) },
            getItemByNameEC3("storage", 2),
            100);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.diamond), getItemByNameEC3("genericItem", 15),
                getItemByNameEC3("genericItem", 15), getItemByNameEC3("genericItem", 15),
                getItemByNameEC3("genericItem", 15) },
            getItemByNameEC3("storage", 3),
            250);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(Items.nether_star), getItemByNameEC3("genericItem", 16),
                getItemByNameEC3("genericItem", 16), getItemByNameEC3("genericItem", 16),
                getItemByNameEC3("genericItem", 16) },
            getItemByNameEC3("storage", 4),
            500);
        MagicianTableRecipes.addRecipeIS(
            new UnformedItemStack[] { new UnformedItemStack(getItemByNameEC3("genericItem", 7)),
                new UnformedItemStack("ingotMithriline"), new UnformedItemStack("ingotMithriline"),
                new UnformedItemStack("ingotMithriline"), new UnformedItemStack("ingotMithriline") },
            getItemByNameEC3("genericItem", 49),
            400);
        MagicianTableRecipes.addRecipeIS(
            new UnformedItemStack[] { new UnformedItemStack(getItemByNameEC3("genericItem", 7)),
                new UnformedItemStack("ingotDemonic"), new UnformedItemStack("ingotDemonic"),
                new UnformedItemStack("ingotDemonic"), new UnformedItemStack("ingotDemonic") },
            new ItemStack(ECItems.genericItem, 4, 54),
            2000);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { getItemByNameEC3("genericItem", 7), new ItemStack(Items.blaze_powder),
                new ItemStack(Items.blaze_powder), new ItemStack(Items.blaze_powder),
                new ItemStack(Items.blaze_powder) },
            getItemByNameEC3("genericItem", 79),
            500);
        ItemStack book_t1 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t1)
            .setInteger("tier", 1);
        ItemStack book_t2 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t2)
            .setInteger("tier", 2);
        MagicianTableRecipes.addRecipeIS(new ItemStack[] { book_t1, null, null, null, null }, book_t2, 100);
        MagicianTableRecipes.addRecipeIS(
            new ItemStack[] { new ItemStack(ECBlocks.voidStone), null, null, null, null },
            getItemByNameEC3("genericItem", 35),
            1000);
    }

    public void registerMithrilineFurnace() {
        // TODO MithrilineFurnaceRecipes
        MithrilineFurnaceRecipes.addRecipe("dustMithriline", getItemByNameEC3("genericItem", 50), 60, 1);
        MithrilineFurnaceRecipes.addRecipe("gemResonant", getItemByNameEC3("genericItem", 48), 120, 1);
        MithrilineFurnaceRecipes.addRecipe("gemMithriline", getItemByNameEC3("genericItem", 47), 240, 1);
        MithrilineFurnaceRecipes
            .addRecipe(getItemByNameEC3("genericItem", 47), new ItemStack(ECItems.genericItem, 8, 46), 480, 1);
        MithrilineFurnaceRecipes.addRecipe("dustGlowstone", getItemByNameEC3("genericItem", 51), 32, 1);
        MithrilineFurnaceRecipes.addRecipe("ingotIron", new ItemStack(Items.gold_ingot), 64, 8);
        MithrilineFurnaceRecipes.addRecipe("ingotGold", new ItemStack(Items.iron_ingot, 8, 0), 64, 1);
        MithrilineFurnaceRecipes.addRecipe("gemDiamond", new ItemStack(Items.emerald), 512, 2);
        MithrilineFurnaceRecipes.addRecipe("gemEmerald", new ItemStack(Items.diamond, 2, 0), 512, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.planks, 1, 0), new ItemStack(Blocks.planks, 1, 1), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.planks, 1, 1), new ItemStack(Blocks.planks, 1, 2), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.planks, 1, 2), new ItemStack(Blocks.planks, 1, 3), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.planks, 1, 3), new ItemStack(Blocks.planks, 1, 4), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.planks, 1, 4), new ItemStack(Blocks.planks, 1, 5), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.planks, 1, 5), new ItemStack(Blocks.planks, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.sapling, 1, 0), new ItemStack(Blocks.sapling, 1, 1), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.sapling, 1, 1), new ItemStack(Blocks.sapling, 1, 2), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.sapling, 1, 2), new ItemStack(Blocks.sapling, 1, 3), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.sapling, 1, 3), new ItemStack(Blocks.sapling, 1, 4), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.sapling, 1, 4), new ItemStack(Blocks.sapling, 1, 5), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.sapling, 1, 5), new ItemStack(Blocks.sapling, 1, 0), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.log, 1, 0), new ItemStack(Blocks.log, 1, 1), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.log, 1, 1), new ItemStack(Blocks.log, 1, 2), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.log, 1, 2), new ItemStack(Blocks.log, 1, 3), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.log, 1, 3), new ItemStack(Blocks.log2, 1, 0), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.log2, 1, 0), new ItemStack(Blocks.log2, 1, 1), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.log2, 1, 1), new ItemStack(Blocks.log, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.leaves, 1, 0), new ItemStack(Blocks.leaves, 1, 1), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.leaves, 1, 1), new ItemStack(Blocks.leaves, 1, 2), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.leaves, 1, 2), new ItemStack(Blocks.leaves, 1, 3), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.leaves, 1, 3), new ItemStack(Blocks.leaves2, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.leaves2, 1, 0), new ItemStack(Blocks.leaves2, 1, 1), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.leaves2, 1, 1), new ItemStack(Blocks.leaves, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.melon_block, 1, 0), new ItemStack(Blocks.pumpkin, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.pumpkin, 1, 0), new ItemStack(Blocks.melon_block, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.yellow_flower, 1, 0), new ItemStack(Blocks.red_flower, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 0), new ItemStack(Blocks.red_flower, 1, 1), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 1), new ItemStack(Blocks.red_flower, 1, 2), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 2), new ItemStack(Blocks.red_flower, 1, 3), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 3), new ItemStack(Blocks.red_flower, 1, 4), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 4), new ItemStack(Blocks.red_flower, 1, 5), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 5), new ItemStack(Blocks.red_flower, 1, 6), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 6), new ItemStack(Blocks.red_flower, 1, 7), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 7), new ItemStack(Blocks.red_flower, 1, 8), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_flower, 1, 8), new ItemStack(Blocks.yellow_flower, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.red_mushroom, 1, 0), new ItemStack(Blocks.brown_mushroom, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.brown_mushroom, 1, 0), new ItemStack(Blocks.red_mushroom, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.blaze_rod, 2, 0), 128, 3);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.blaze_rod, 1, 0), new ItemStack(Items.ender_pearl, 3, 0), 128, 2);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.redstone, 1, 0), new ItemStack(Items.ghast_tear, 1, 0), 1024, 64);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.ghast_tear, 1, 0), new ItemStack(Items.redstone, 64, 0), 1024, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.clay_ball, 1, 0), new ItemStack(Items.gunpowder, 1, 0), 32, 12);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.gunpowder, 1, 0), new ItemStack(Items.clay_ball, 12, 0), 32, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.porkchop, 1, 0), new ItemStack(Items.beef, 1, 0), 16, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.beef, 1, 0), new ItemStack(Items.chicken, 1, 0), 16, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.chicken, 1, 0), new ItemStack(Items.fish, 1, 0), 16, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.fish, 1, 0), new ItemStack(Items.rotten_flesh, 2, 0), 16, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.rotten_flesh, 1, 0), new ItemStack(Items.porkchop, 1, 0), 16, 2);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.cooked_porkchop, 1, 0), new ItemStack(Items.cooked_beef, 1, 0), 16, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.cooked_beef, 1, 0), new ItemStack(Items.cooked_chicken, 1, 0), 16, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.cooked_chicken, 1, 0), new ItemStack(Items.cooked_fished, 1, 0), 16, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.cooked_fished, 1, 0), new ItemStack(Items.cooked_fished, 1, 1), 16, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.cooked_fished, 1, 1), new ItemStack(Items.cooked_porkchop, 1, 0), 16, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_13, 1, 0), new ItemStack(Items.record_cat, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_cat, 1, 0), new ItemStack(Items.record_blocks, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_blocks, 1, 0), new ItemStack(Items.record_chirp, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_chirp, 1, 0), new ItemStack(Items.record_far, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_far, 1, 0), new ItemStack(Items.record_mall, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_mall, 1, 0), new ItemStack(Items.record_mellohi, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_mellohi, 1, 0), new ItemStack(Items.record_stal, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_stal, 1, 0), new ItemStack(Items.record_strad, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_strad, 1, 0), new ItemStack(Items.record_ward, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_ward, 1, 0), new ItemStack(Items.record_11, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_11, 1, 0), new ItemStack(Items.record_wait, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.record_wait, 1, 0), new ItemStack(Items.record_13, 1, 0), 256, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.sugar, 1, 0), new ItemStack(Items.slime_ball, 4, 0), 16, 3);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.slime_ball, 1, 0), new ItemStack(Items.sugar, 3, 0), 16, 4);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.egg, 1, 0), new ItemStack(Items.bone, 2, 0), 48, 9);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.bone, 1, 0), new ItemStack(Items.egg, 9, 0), 48, 2);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.skull, 1, 0), new ItemStack(Items.skull, 1, 1), 64, 3);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.skull, 1, 1), new ItemStack(Items.skull, 3, 2), 64, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.skull, 1, 2), new ItemStack(Items.skull, 1, 3), 64, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.skull, 1, 3), new ItemStack(Items.skull, 1, 4), 64, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.skull, 1, 4), new ItemStack(Items.skull, 1, 0), 64, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.wheat, 1, 0), new ItemStack(Items.leather, 1, 0), 128, 3);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Items.leather, 1, 0), new ItemStack(Items.wheat, 3, 0), 128, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.fish, 1, 1), new ItemStack(Items.fish, 1, 2), 24, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.fish, 1, 2), new ItemStack(Items.fish, 1, 3), 24, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.fish, 1, 3), new ItemStack(Items.fish, 1, 1), 24, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.reeds, 1, 0), new ItemStack(Items.feather, 2, 0), 64, 3);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.feather, 1, 0), new ItemStack(Items.reeds, 3, 0), 64, 2);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.coal, 1, 0), new ItemStack(Items.coal, 1, 1), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 0), 1, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.fire, 1, 0), new ItemStack(Blocks.coal_block, 1, 0), 512, 1);
        MithrilineFurnaceRecipes
            .addRecipe(new ItemStack(Blocks.coal_block, 1, 0), new ItemStack(Blocks.fire, 1, 0), 512, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.ice, 1, 0), new ItemStack(Blocks.grass, 1, 0), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.grass, 1, 0), new ItemStack(Blocks.dirt, 1, 0), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.dirt, 1, 0), new ItemStack(Blocks.dirt, 1, 2), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.dirt, 1, 2), new ItemStack(Blocks.glass, 1, 0), 1, 1);
        MithrilineFurnaceRecipes.addRecipe(new ItemStack(Blocks.glass, 1, 0), new ItemStack(Blocks.ice, 1, 0), 1, 1);
    }

    @SuppressWarnings("unused")
    public static void registerWindRecipes() {
        new WindImbueRecipe(new ItemStack(ECItems.soulStone, 1, 0), new ItemStack(ECItems.soulStone, 1, 0), 10000 * 4);
        new WindImbueRecipe(new ItemStack(Items.diamond, 1, 0), new ItemStack(ECItems.genericItem, 1, 55), 10000);
        new WindImbueRecipe(new ItemStack(Items.potionitem, 1, 0), new ItemStack(ECItems.air_potion, 1, 0), 250);
        // TODO wind recipes
    }

    @SuppressWarnings("unused")
    public static void registerDemonTrades() {
        // TODO demon trades
        new DemonTradeRecipe(EntityVillager.class);
        new DemonTradeRecipe(EntityEnderman.class);
        new DemonTradeRecipe(EntityWindMage.class);
        new DemonTradeRecipe(new ItemStack(Blocks.diamond_block, 2, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.bedrock, 1, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.iron_block, 8, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.tnt, 64, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.enchanting_table, 16, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.bookshelf, 64, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.end_portal_frame, 3, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.dragon_egg, 1, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.beacon, 1, 0));
        new DemonTradeRecipe(new ItemStack(Blocks.command_block, 1, 0));
        new DemonTradeRecipe(new ItemStack(Items.golden_apple, 1, 1));
        new DemonTradeRecipe(new ItemStack(Items.map, 1, OreDictionary.WILDCARD_VALUE));
        new DemonTradeRecipe(new ItemStack(Items.ender_eye, 32, 0));
        new DemonTradeRecipe(new ItemStack(Items.skull, 1, 3));
        new DemonTradeRecipe(new ItemStack(Items.nether_star, 1, 0));
        new DemonTradeRecipe(new ItemStack(Items.record_11, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.magicalEnchanter, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.magicalRepairer, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.heatGenerator, 3, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.magicalTeleporter, 2, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.mruCoil, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.ultraHeatGen, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.darknessObelisk, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.mithrilineCrystal, 12, 0));
        new DemonTradeRecipe(new ItemStack(ECBlocks.mithrilineCrystal, 6, 3));
        new DemonTradeRecipe(new ItemStack(ECBlocks.mithrilineCrystal, 3, 6));
        new DemonTradeRecipe(new ItemStack(ECBlocks.compressed, 32, 4));
        new DemonTradeRecipe(new ItemStack(ECItems.emeraldHeart, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.spikyShield, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.magicalShield, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.magicWaterBottle, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_elemental_pick, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_elemental_axe, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_elemental_hoe, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_elemental_shovel, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_elemental_sword, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_chestplate, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_helmet, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_boots, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.wind_leggings, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.magicalPorkchop, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.chaosFork, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.research_book, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.record_everlastingSummer, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.pistol, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.rifle, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.sniper, 1, 0));
        new DemonTradeRecipe(new ItemStack(ECItems.gatling, 1, 0));
    }

    public static ItemStack getItemByNameEC3(String itemName, int metadata) {
        Class<ECBlocks> blocks = ECBlocks.class;
        try {
            Field block = blocks.getDeclaredField(itemName);
            ItemStack is = new ItemStack((Block) block.get(null), 1, metadata);
            return is;
        } catch (Exception e) {
            try {
                Class<ECItems> items = ECItems.class;
                Field item = items.getDeclaredField(itemName);
                ItemStack is = new ItemStack((Item) item.get(null), 1, metadata);
                return is;
            } catch (Exception e1) {
                e.printStackTrace();
                e1.printStackTrace();
                return null;
            }
        }
    }

    public void registerEFuelCrafts() {
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 1, 0),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 0), 'C', Items.coal }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 4, 0),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 4), 'C', Items.coal }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 8, 0),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 8), 'C', Items.coal }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 16, 0),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 12), 'C', Items.coal }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 1, 1),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 1), 'C', Items.snowball }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 4, 1),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 5), 'C', Items.snowball }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 8, 1),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 9), 'C', Items.snowball }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 16, 1),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 13), 'C', Items.snowball }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 1, 2),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 2), 'C',
                    Items.wheat_seeds }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 4, 2),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 6), 'C',
                    Items.wheat_seeds }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 8, 2),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 10), 'C',
                    Items.wheat_seeds }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 16, 2),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 14), 'C',
                    Items.wheat_seeds }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 1, 3),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 3) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 4, 3),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 7) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 8, 3),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 11) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.elementalFuel, 16, 3),
                new Object[] { " E ", "ECE", " E ", 'E', new ItemStack(ECItems.essence, 1, 15) }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.fFocus, 1, 0),
                new Object[] { "GIG", "IEI", "GIG", 'E', new ItemStack(ECItems.elementalFuel, 1, 0), 'G',
                    Items.gold_ingot, 'I', Items.iron_ingot }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.wFocus, 1, 0),
                new Object[] { "GIG", "IEI", "GIG", 'E', new ItemStack(ECItems.elementalFuel, 1, 1), 'G',
                    Items.gold_ingot, 'I', Items.iron_ingot }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.eFocus, 1, 0),
                new Object[] { "GIG", "IEI", "GIG", 'E', new ItemStack(ECItems.elementalFuel, 1, 2), 'G',
                    Items.gold_ingot, 'I', Items.iron_ingot }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.aFocus, 1, 0),
                new Object[] { "GIG", "IEI", "GIG", 'E', new ItemStack(ECItems.elementalFuel, 1, 3), 'G',
                    Items.gold_ingot, 'I', Items.iron_ingot }));
    }

    public void registerCharmsCraft() {
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 0),
                new Object[] { "SGS", "FRF", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 1),
                new Object[] { "SGS", "WRW", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 2),
                new Object[] { "SGS", "ERE", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 3),
                new Object[] { "SGS", "ARA", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 4),
                new Object[] { "SGS", "FRA", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 4),
                new Object[] { "SGS", "ARF", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 5),
                new Object[] { "SGS", "FRE", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 5),
                new Object[] { "SGS", "ERF", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 6),
                new Object[] { "SGS", "FRW", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 6),
                new Object[] { "SGS", "WRF", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 7),
                new Object[] { "SGS", "ERW", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 7),
                new Object[] { "SGS", "WRE", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 8),
                new Object[] { "SGS", "WRA", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 8),
                new Object[] { "SGS", "ARW", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 9),
                new Object[] { "SGS", "ERA", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ECItems.charm, 1, 9),
                new Object[] { "SGS", "ARE", "@G@", 'F', ECItems.fFocus, 'W', ECItems.wFocus, 'E', ECItems.eFocus, 'A',
                    ECItems.aFocus, 'S', Items.string, 'G', getItemByNameEC3("genericItem", 10), 'R',
                    new ItemStack(ECItems.storage, 1, 3), '@', "magicWater" }));
    }

    public static ItemStack gen(int meta) {
        return new ItemStack(ECItems.genericItem, 1, meta);
    }
}
