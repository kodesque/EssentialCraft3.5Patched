package ec3.common.init.custom;

import java.util.Hashtable;
import java.util.Random;

import ec3.api.upgrades.MagicianTableUpgrades;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.ShapedOreRecipe;

import ec3.api.ApiCore;
import ec3.api.book.CategoryEntry;
import ec3.api.book.DiscoveryEntry;
import ec3.api.book.PageEntry;
import ec3.api.structures.StructureBlock;
import ec3.api.structures.StructureRecipe;
import ec3.common.init.ECBlocks;
import ec3.common.items.ItemBaublesWearable;
import ec3.common.items.ItemGun;
import ec3.common.init.ECItems;
import ec3.utils.dummycore.utils.MiscUtils;
import ec3.utils.ECUtils;

public class ECResearch {

    public static Hashtable<String, Integer> stringIDS = new Hashtable<String, Integer>();

    public static void registerBasicCategory() {
        ItemStack book = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book)
            .setInteger("tier", 0);
        ItemStack book_t1 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t1)
            .setInteger("tier", 1);
        basic.apendDiscovery(
            new DiscoveryEntry("ec3.disc.book").setReferal(book)
                .setDisplayStack(new ItemStack(ECItems.research_book, 0, 0))
                .apendPage(
                    new PageEntry("ec3.page.book_0").setText(StatCollector.translateToLocal("ec3.page.book_0.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_1").setRecipe(ECUtils.findRecipeByIS(book, 2))
                        .setText(StatCollector.translateToLocal("ec3.page.book_1.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_2").setText(StatCollector.translateToLocal("ec3.page.book_2.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_3").setText(StatCollector.translateToLocal("ec3.page.book_3.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_4").setText(StatCollector.translateToLocal("ec3.page.book_4.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_5").setText(StatCollector.translateToLocal("ec3.page.book_5.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_6").setText(StatCollector.translateToLocal("ec3.page.book_6.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_7").setText(StatCollector.translateToLocal("ec3.page.book_7.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_8").setText(StatCollector.translateToLocal("ec3.page.book_8.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_9").setText(StatCollector.translateToLocal("ec3.page.book_9.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_10").setText(StatCollector.translateToLocal("ec3.page.book_10.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_11").setText(StatCollector.translateToLocal("ec3.page.book_11.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_12").setText(StatCollector.translateToLocal("ec3.page.book_12.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_13").setText(StatCollector.translateToLocal("ec3.page.book_13.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_14").setText(StatCollector.translateToLocal("ec3.page.book_14.txt")))
                .apendPage(
                    new PageEntry("ec3.page.book_15").setText(StatCollector.translateToLocal("ec3.page.book_15.txt"))
                        .setRecipe(
                            new ShapedOreRecipe(
                                book_t1,
                                new Object[] { "EGE", "GBG", "EGE", 'E', "elementalCore", 'G', "shardElemental", 'B',
                                    book }))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.wind")
                    .setReferal(
                        new ItemStack(ECItems.bottledWind, 0, 0),
                        new ItemStack(ECItems.imprisonedWind, 0, 0),
                        new ItemStack(ECItems.windKeeper, 0, 0),
                        new ItemStack(ECItems.magicArmorItems[12], 0, 0),
                        new ItemStack(ECItems.magicArmorItems[13], 0, 0),
                        new ItemStack(ECItems.magicArmorItems[14], 0, 0),
                        new ItemStack(ECItems.magicArmorItems[15], 0, 0),
                        new ItemStack(ECItems.air_potion, 0, 0))
                    .setDisplayStack(new ResourceLocation("essentialcraft", "textures/special/wind_icon.png"))
                    .apendPage(
                        new PageEntry("ec3.page.wind_0").setText(StatCollector.translateToLocal("ec3.page.wind_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.wind_1")
                            .setImg(new ResourceLocation("essentialcraft", "textures/special/bookIcons/windTouch.png"))
                            .setText(StatCollector.translateToLocal("ec3.page.wind_1.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.wind_2")
                            .setImg(new ResourceLocation("essentialcraft", "textures/special/bookIcons/windMages.png"))
                            .setText(StatCollector.translateToLocal("ec3.page.wind_2.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.wind_3")
                            .setDisplayStacks(
                                new ItemStack(ECItems.bottledWind, 1, 0),
                                new ItemStack(ECItems.imprisonedWind, 1, 0),
                                new ItemStack(ECItems.windKeeper, 1, 0))
                            .setText(StatCollector.translateToLocal("ec3.page.wind_3.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.wind_4")
                            .setDisplayStacks(
                                new ItemStack(ECItems.magicArmorItems[12], 1, 0),
                                new ItemStack(ECItems.magicArmorItems[13], 1, 0),
                                new ItemStack(ECItems.magicArmorItems[14], 1, 0),
                                new ItemStack(ECItems.magicArmorItems[15], 1, 0))
                            .setText(StatCollector.translateToLocal("ec3.page.wind_4.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.wind_5")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.air_potion, 1, 0), 3))
                            .setText(StatCollector.translateToLocal("ec3.page.wind_5.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.drops")
                    .setReferal(
                        new ItemStack(ECItems.drops, 1, 0),
                        new ItemStack(ECItems.drops, 1, 1),
                        new ItemStack(ECItems.drops, 1, 2),
                        new ItemStack(ECItems.drops, 1, 3),
                        new ItemStack(ECItems.drops, 1, 4),
                        new ItemStack(ECBlocks.compressed, 1, 0),
                        new ItemStack(ECBlocks.compressed, 1, 1),
                        new ItemStack(ECBlocks.compressed, 1, 2),
                        new ItemStack(ECBlocks.compressed, 1, 3),
                        new ItemStack(ECBlocks.compressed, 1, 4),
                        new ItemStack(ECItems.weak_elemental_axe),
                        new ItemStack(ECItems.weak_elemental_hoe),
                        new ItemStack(ECItems.weak_elemental_pick),
                        new ItemStack(ECItems.weak_elemental_shovel),
                        new ItemStack(ECItems.weak_elemental_sword))
                    .setDisplayStack(new ItemStack(ECItems.drops, 1, 4))

                    .apendPage(
                        new PageEntry("ec3.page.drops_0")
                            .setText(StatCollector.translateToLocal("ec3.page.drops_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.drops_1")
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECItems.drops, 1, 0),
                                    new StructureBlock(Blocks.netherrack, 0, 0, 0, 0),
                                    new StructureBlock(Blocks.lava, 0, 1, 0, 0),
                                    new StructureBlock(Blocks.lava, 0, -1, 0, 0),
                                    new StructureBlock(Blocks.lava, 0, 0, 0, 1),
                                    new StructureBlock(Blocks.lava, 0, 0, 0, -1)))
                            .setText(StatCollector.translateToLocal("ec3.page.drops_1.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.drops_2")
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECItems.drops, 1, 1),
                                    new StructureBlock(Blocks.ice, 0, 0, 0, 0),
                                    new StructureBlock(Blocks.water, 0, 1, 0, 0),
                                    new StructureBlock(Blocks.water, 0, -1, 0, 0),
                                    new StructureBlock(Blocks.water, 0, 0, 0, 1),
                                    new StructureBlock(Blocks.water, 0, 0, 0, -1)))
                            .setText(StatCollector.translateToLocal("ec3.page.drops_2.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.drops_3")
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECItems.drops, 1, 2),
                                    new StructureBlock(Blocks.grass, 0, 0, 0, 0),
                                    new StructureBlock(Blocks.mossy_cobblestone, 0, 1, 0, 0),
                                    new StructureBlock(Blocks.mossy_cobblestone, 0, -1, 0, 0),
                                    new StructureBlock(Blocks.mossy_cobblestone, 0, 0, 0, 1),
                                    new StructureBlock(Blocks.mossy_cobblestone, 0, 0, 0, -1)))
                            .setText(StatCollector.translateToLocal("ec3.page.drops_3.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.drops_4")
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECItems.drops, 1, 3),
                                    new StructureBlock(Blocks.quartz_block, 0, 0, 0, 0),
                                    new StructureBlock(Blocks.sand, 0, 1, 0, 0),
                                    new StructureBlock(Blocks.sand, 0, -1, 0, 0),
                                    new StructureBlock(Blocks.sand, 0, 0, 0, 1),
                                    new StructureBlock(Blocks.sand, 0, 0, 0, -1)))
                            .setText(StatCollector.translateToLocal("ec3.page.drops_4.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.drops_11")
                            .setText(StatCollector.translateToLocal("ec3.page.drops_11.txt"))
                            .setDisplayStacks(
                                new ItemStack(ECBlocks.oreDrops, 1, 0),
                                new ItemStack(ECBlocks.oreDrops, 1, 1),
                                new ItemStack(ECBlocks.oreDrops, 1, 2),
                                new ItemStack(ECBlocks.oreDrops, 1, 3),
                                new ItemStack(ECBlocks.oreDrops, 1, 4)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_12")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.compressed, 1, 0), 3)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_13")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.compressed, 1, 1), 3)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_14")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.compressed, 1, 2), 3)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_15")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.compressed, 1, 3), 3)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_16")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.compressed, 1, 4), 3)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_5")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.drops, 1, 4), 3))
                            .setText(StatCollector.translateToLocal("ec3.page.drops_5.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.drops_6")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.weak_elemental_axe, 1, 0), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_7")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.weak_elemental_hoe, 1, 0), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_8")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.weak_elemental_pick, 1, 0), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_9")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.weak_elemental_shovel, 1, 0), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_10")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.weak_elemental_sword, 1, 0), 3)))

            )
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.miscCrafts")
                    .setReferal(
                        new ItemStack(ECItems.genericItem, 0, 1),
                        new ItemStack(ECItems.genericItem, 0, 21),
                        new ItemStack(ECItems.genericItem, 1, 22),
                        new ItemStack(ECItems.genericItem, 1, 23),
                        new ItemStack(ECItems.genericItem, 1, 25),
                        new ItemStack(ECItems.genericItem, 1, 26),
                        new ItemStack(ECItems.genericItem, 1, 28),
                        new ItemStack(ECItems.genericItem, 1, 29))
                    .setDisplayStack(new ItemStack(ECItems.genericItem, 0, 1))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_0")
                            .setText(StatCollector.translateToLocal("ec3.page.miscCrafts_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_1")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 0, 1), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_2")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 0, 21), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_3")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 0, 22), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_4")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 0, 23), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_5")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 0, 25), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_6")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 0, 26), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_7")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 0, 28), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.miscCrafts_8")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 0, 29), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mru").setReferal(new ItemStack(ECItems.mruMover1))
                    .setDisplayStack(
                        new ResourceLocation("essentialcraft", "textures/special/basical_knowledge_icon.png"))
                    .apendPage(
                        new PageEntry("ec3.page.mru_0").setText(StatCollector.translateToLocal("ec3.page.mru_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_1").setText(StatCollector.translateToLocal("ec3.page.mru_1.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_2").setText(StatCollector.translateToLocal("ec3.page.mru_2.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_3")
                            .setImg(new ResourceLocation("essentialcraft", "textures/special/bookIcons/mru_lowest.png"))
                            .setText(StatCollector.translateToLocal("ec3.page.mru_3.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_4").setText(StatCollector.translateToLocal("ec3.page.mru_4.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_5").setText(StatCollector.translateToLocal("ec3.page.mru_5.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_6").setText(StatCollector.translateToLocal("ec3.page.mru_6.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_7").setText(StatCollector.translateToLocal("ec3.page.mru_7.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_8").setText(StatCollector.translateToLocal("ec3.page.mru_8.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_9").setText(StatCollector.translateToLocal("ec3.page.mru_9.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_10").setText(StatCollector.translateToLocal("ec3.page.mru_10.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_11").setText(StatCollector.translateToLocal("ec3.page.mru_11.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_12")
                            .setImg(
                                new ResourceLocation("essentialcraft", "textures/special/bookIcons/mru_pressence.png"))
                            .setText(StatCollector.translateToLocal("ec3.page.mru_12.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_13").setText(StatCollector.translateToLocal("ec3.page.mru_13.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_14").setText(StatCollector.translateToLocal("ec3.page.mru_14.txt"))
                            .setDisplayStacks(
                                new ItemStack(ECBlocks.lightCorruption[0], 1, 7),
                                new ItemStack(ECBlocks.lightCorruption[1], 1, 7),
                                new ItemStack(ECBlocks.lightCorruption[3], 1, 7)))
                    .apendPage(
                        new PageEntry("ec3.page.mru_15").setText(StatCollector.translateToLocal("ec3.page.mru_15.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.mru_16")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.mruMover1), 3))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.soulStone").setReferal(new ItemStack(ECItems.soulStone))
                    .setDisplayStack(new ItemStack(ECItems.soulStone, 0, 1))
                    .apendPage(
                        new PageEntry("ec3.page.soulStone_0")
                            .setText(StatCollector.translateToLocal("ec3.page.soulStone_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.soulStone_1")
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECItems.soulStone, 1, 0),
                                    new StructureBlock(Blocks.emerald_block, 0, 0, 0, 0)))
                            .setText(StatCollector.translateToLocal("ec3.page.soulStone_1.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.soulStone_2")
                            .setImg(new ResourceLocation("essentialcraft", "textures/special/bookIcons/soulStone.png"))
                            .setText(StatCollector.translateToLocal("ec3.page.soulStone_2.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.soulStone_3")
                            .setText(StatCollector.translateToLocal("ec3.page.soulStone_3.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.soulStone_43")
                            .setText(StatCollector.translateToLocal("ec3.page.soulStone_4.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.soulStone_5")
                            .setText(StatCollector.translateToLocal("ec3.page.soulStone_5.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.soulStone_6")
                            .setText(StatCollector.translateToLocal("ec3.page.soulStone_6.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.decorations").setReferal(new ItemStack(ECItems.magicalChisel))
                    .setDisplayStack(new ItemStack(ECItems.magicalChisel))
                    .apendPage(
                        next("decorations").setText(StatCollector.translateToLocal("ec3.page.decorations_0.txt")))
                    .apendPage(
                        next("decorations").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicalChisel), 2))
                            .setDisplayStacks(
                                new ItemStack(ECItems.magicalSlag),
                                new ItemStack(ECBlocks.concrete),
                                new ItemStack(ECBlocks.fortifiedStone),
                                new ItemStack(ECBlocks.magicPlating),
                                new ItemStack(ECBlocks.platingPale),
                                new ItemStack(ECBlocks.voidStone),
                                new ItemStack(ECBlocks.coldStone)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 1), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 0), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 2), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 3), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 4), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 5), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 6), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 7), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 8), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 9), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 10), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 11), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 12), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 13), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 14), 2)))
                    .apendPage(
                        next("decorations")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fancyBlocks.get(0), 1, 15), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.overworld")
                    .setReferal(
                        new ItemStack(ECItems.baublesCore, 1, 0),
                        new ItemStack(ECItems.baublesCore, 1, 1),
                        new ItemStack(ECItems.baublesCore, 1, 2),
                        new ItemStack(ECItems.baublesCore, 1, 3),
                        new ItemStack(ECItems.baublesCore, 1, 4),
                        new ItemStack(ECItems.baublesCore, 1, 5),
                        new ItemStack(ECItems.baublesCore, 1, 6),
                        new ItemStack(ECItems.baublesCore, 1, 7),
                        new ItemStack(ECItems.baublesCore, 1, 8),
                        new ItemStack(ECItems.baublesCore, 1, 9),
                        new ItemStack(ECItems.baublesCore, 1, 10),
                        new ItemStack(ECItems.baublesCore, 1, 11),
                        new ItemStack(ECItems.baublesCore, 1, 12),
                        new ItemStack(ECItems.baublesCore, 1, 13),
                        new ItemStack(ECItems.baublesCore, 1, 14),
                        new ItemStack(ECItems.baublesCore, 1, 15),
                        new ItemStack(ECItems.baublesCore, 1, 16),
                        new ItemStack(ECItems.baublesCore, 1, 17),
                        new ItemStack(ECItems.baublesCore, 1, 18),
                        new ItemStack(ECItems.baublesCore, 1, 19),
                        new ItemStack(ECItems.baublesCore, 1, 20),
                        new ItemStack(ECItems.baublesCore, 1, 21),
                        new ItemStack(ECItems.baublesCore, 1, 22),
                        new ItemStack(ECItems.baublesCore, 1, 23),
                        new ItemStack(ECItems.baublesCore, 1, 24),
                        new ItemStack(ECItems.baublesCore, 1, 25),
                        new ItemStack(ECItems.baublesCore, 1, 26),
                        new ItemStack(ECItems.baublesCore, 1, 27),
                        new ItemStack(ECItems.baublesCore, 1, 28),
                        new ItemStack(ECItems.baublesCore, 1, 29),
                        new ItemStack(ECItems.baublesCore, 1, 30),
                        new ItemStack(ECItems.baublesCore, 1, 31))
                    .setDisplayStack(new ItemStack(ECItems.baublesCore, 1, 14))

                    .apendPage(next("overworld").setText(StatCollector.translateToLocal("ec3.page.overworld_0.txt")))
                    .apendPage(next("overworld").setText(StatCollector.translateToLocal("ec3.page.overworld_1.txt")))
                    .apendPage(
                        next("overworld").setDisplayStacks(
                            new ItemStack(ECItems.baublesCore, 1, 0),
                            new ItemStack(ECItems.baublesCore, 1, 1),
                            new ItemStack(ECItems.baublesCore, 1, 2),
                            new ItemStack(ECItems.baublesCore, 1, 3),
                            new ItemStack(ECItems.baublesCore, 1, 4),
                            new ItemStack(ECItems.baublesCore, 1, 5),
                            new ItemStack(ECItems.baublesCore, 1, 6),
                            new ItemStack(ECItems.baublesCore, 1, 7),
                            new ItemStack(ECItems.baublesCore, 1, 8),
                            new ItemStack(ECItems.baublesCore, 1, 9),
                            new ItemStack(ECItems.baublesCore, 1, 10),
                            new ItemStack(ECItems.baublesCore, 1, 11),
                            new ItemStack(ECItems.baublesCore, 1, 12),
                            new ItemStack(ECItems.baublesCore, 1, 13),
                            new ItemStack(ECItems.baublesCore, 1, 14),
                            new ItemStack(ECItems.baublesCore, 1, 15),
                            new ItemStack(ECItems.baublesCore, 1, 16),
                            new ItemStack(ECItems.baublesCore, 1, 17),
                            new ItemStack(ECItems.baublesCore, 1, 18),
                            new ItemStack(ECItems.baublesCore, 1, 19),
                            new ItemStack(ECItems.baublesCore, 1, 20),
                            new ItemStack(ECItems.baublesCore, 1, 21),
                            new ItemStack(ECItems.baublesCore, 1, 22),
                            new ItemStack(ECItems.baublesCore, 1, 23),
                            new ItemStack(ECItems.baublesCore, 1, 24),
                            new ItemStack(ECItems.baublesCore, 1, 25),
                            new ItemStack(ECItems.baublesCore, 1, 26),
                            new ItemStack(ECItems.baublesCore, 1, 27),
                            new ItemStack(ECItems.baublesCore, 1, 28),
                            new ItemStack(ECItems.baublesCore, 1, 29),
                            new ItemStack(ECItems.baublesCore, 1, 30),
                            new ItemStack(ECItems.baublesCore, 1, 31))));
    }

    public static void registerMruCategory() {
        ItemStack book_t1 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t1)
            .setInteger("tier", 1);
        ItemStack book_t2 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t2)
            .setInteger("tier", 2);
        ItemStack pistol = new ItemStack(ECItems.pistol, 1, 0);
        ItemGun.createRandomGun(pistol);
        ItemStack rifle = new ItemStack(ECItems.rifle, 1, 0);
        ItemGun.createRandomGun(rifle);
        ItemStack sniper = new ItemStack(ECItems.sniper, 1, 0);
        ItemGun.createRandomGun(sniper);
        ItemStack gatling = new ItemStack(ECItems.gatling, 1, 0);
        ItemGun.createRandomGun(gatling);
        mru.apendDiscovery(
            new DiscoveryEntry("ec3.disc.boundGem").setReferal(new ItemStack(ECItems.bound_gem, 0, 0))
                .setDisplayStack(new ItemStack(ECItems.bound_gem))
                .apendPage(
                    new PageEntry("ec3.page.boundGem_0")
                        .setText(StatCollector.translateToLocal("ec3.page.boundGem_0.txt")))
                .apendPage(
                    new PageEntry("ec3.page.boundGem_1")
                        .setText(StatCollector.translateToLocal("ec3.page.boundGem_1.txt")))
                .apendPage(
                    new PageEntry("ec3.page.boundGem_2")
                        .setText(StatCollector.translateToLocal("ec3.page.boundGem_2.txt")))
                .apendPage(
                    new PageEntry("ec3.page.boundGem_3")
                        .setText(StatCollector.translateToLocal("ec3.page.boundGem_3.txt")))
                .apendPage(
                    new PageEntry("ec3.page.boundGem_4")
                        .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.bound_gem), 2))
                        .setText(StatCollector.translateToLocal("ec3.page.boundGem_4.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.matrixDestructor")
                    .setReferal(new ItemStack(ECBlocks.matrixAbsorber, 0, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.matrixAbsorber))
                    .apendPage(
                        new PageEntry("ec3.page.matrixDestructor_0")
                            .setText(StatCollector.translateToLocal("ec3.page.matrixDestructor_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.matrixDestructor_1")
                            .setText(StatCollector.translateToLocal("ec3.page.matrixDestructor_1.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.matrixDestructor_2")
                            .setText(StatCollector.translateToLocal("ec3.page.matrixDestructor_2.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.matrixDestructor_3")
                            .setText(StatCollector.translateToLocal("ec3.page.matrixDestructor_3.txt"))
                            .setDisplayStacks(new ItemStack(ECItems.soulStone, 1, 0)))
                    .apendPage(
                        new PageEntry("ec3.page.matrixDestructor_4")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.matrixAbsorber), 2)))

            )
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.radiatingChamber")
                    .setReferal(new ItemStack(ECBlocks.radiatingChamber, 0, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.radiatingChamber))
                    .apendPage(
                        new PageEntry("ec3.page.radiatingChamber_0")
                            .setText(StatCollector.translateToLocal("ec3.page.radiatingChamber_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.radiatingChamber_1")
                            .setText(StatCollector.translateToLocal("ec3.page.radiatingChamber_1.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.radiatingChamber_2")
                            .setText(StatCollector.translateToLocal("ec3.page.radiatingChamber_2.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.radiatingChamber_3")
                            .setText(StatCollector.translateToLocal("ec3.page.radiatingChamber_3.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.radiatingChamber_4")
                            .setText(StatCollector.translateToLocal("ec3.page.radiatingChamber_4.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.radiatingChamber_5")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.radiatingChamber), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.miscRadiation")

                    .setReferal(
                        new ItemStack(ECItems.genericItem, 0, 3),
                        new ItemStack(ECItems.genericItem, 0, 43),
                        new ItemStack(ECItems.genericItem, 0, 44),
                        new ItemStack(ECBlocks.fortifiedStone, 0, 0),
                        new ItemStack(ECBlocks.fortifiedGlass, 0, 0),
                        new ItemStack(ECItems.genericItem, 0, 24),
                        new ItemStack(ECItems.genericItem, 0, 31),
                        new ItemStack(ECItems.elemental_pick, 1, 0),
                        new ItemStack(ECItems.elemental_axe, 1, 0),
                        new ItemStack(ECItems.elemental_sword, 1, 0),
                        new ItemStack(ECItems.elemental_hoe, 1, 0),
                        new ItemStack(ECItems.elemental_shovel, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.genericItem, 1, 44))
                    .apendPage(
                        new PageEntry("ec3.page.miscRadiation_0")
                            .setText(StatCollector.translateToLocal("ec3.page.miscRadiation_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.miscRadiation_1")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 3), 5)))
                    .apendPage(
                        new PageEntry("ec3.page.miscRadiation_2")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 43), 5)))
                    .apendPage(
                        new PageEntry("ec3.page.miscRadiation_3")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 44), 5)))
                    .apendPage(
                        new PageEntry("ec3.page.miscRadiation_4")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fortifiedStone, 1, 0), 5)))
                    .apendPage(
                        new PageEntry("ec3.page.miscRadiation_5")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.fortifiedGlass, 1, 0), 5)))
                    .apendPage(
                        new PageEntry("ec3.page.miscRadiation_6")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 24), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.miscRadiation_7")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 31), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_6")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elemental_axe, 1, 0), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_7")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elemental_hoe, 1, 0), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_8")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elemental_pick, 1, 0), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_9")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elemental_shovel, 1, 0), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.drops_10")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elemental_sword, 1, 0), 3))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicianTable").setReferal(new ItemStack(ECBlocks.magicianTable, 0, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.magicianTable, 1, 0))
                    .apendPage(
                        new PageEntry("ec3.page.magicianTable_0")
                            .setText(StatCollector.translateToLocal("ec3.page.magicianTable_0.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.magicianTable_1")
                            .setText(StatCollector.translateToLocal("ec3.page.magicianTable_1.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.magicianTable_2")
                            .setText(StatCollector.translateToLocal("ec3.page.magicianTable_2.txt")))
                    .apendPage(
                        new PageEntry("ec3.page.magicianTable_3")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicianTable), 2)))
                    .apendPage(
                        new PageEntry("ec3.page.magicianTable_4")
                            .setDisplayStacks(
                                (ItemStack[]) MagicianTableUpgrades.upgradeStacks
                                    .toArray(new ItemStack[MagicianTableUpgrades.upgradeStacks.size()]))
                            .setText(StatCollector.translateToLocal("ec3.page.magicianTable_4.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicianCrafts")
                    .setReferal(
                        new ItemStack(ECItems.genericItem, 0, 0),
                        new ItemStack(ECItems.genericItem, 0, 5),
                        new ItemStack(ECItems.genericItem, 0, 6),
                        new ItemStack(ECItems.genericItem, 0, 4),
                        new ItemStack(ECItems.genericItem, 0, 7),
                        new ItemStack(ECItems.genericItem, 0, 8),
                        new ItemStack(ECItems.genericItem, 0, 9),
                        new ItemStack(ECItems.genericItem, 0, 10),
                        new ItemStack(ECItems.genericItem, 0, 11),
                        new ItemStack(ECItems.genericItem, 0, 12),
                        new ItemStack(ECItems.genericItem, 0, 13),
                        new ItemStack(ECItems.genericItem, 0, 14),
                        new ItemStack(ECItems.genericItem, 0, 15),
                        new ItemStack(ECItems.genericItem, 0, 16),
                        new ItemStack(ECItems.genericItem, 0, 20),
                        new ItemStack(ECItems.genericItem, 0, 34),
                        new ItemStack(ECItems.genericItem, 0, 32),
                        new ItemStack(ECItems.genericItem, 0, 27),
                        new ItemStack(ECItems.genericItem, 0, 30),
                        new ItemStack(ECItems.genericItem, 0, 33),
                        new ItemStack(ECItems.genericItem, 0, 79))
                    .setDisplayStack(new ItemStack(ECItems.genericItem, 1, 14))
                    .apendPage(
                        next("magicianCrafts").setText(StatCollector.translateToLocal("ec3.page.magicianCrafts_0.txt")))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(5), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(6), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(10), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(20), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(4), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(7), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(11), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(9), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(8), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(0), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(32), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(34), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(12), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(13), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(14), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(15), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(16), 6)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(27), 2)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(30), 2)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(33), 2)))
                    .apendPage(next("magicianCrafts").setRecipe(ECUtils.findRecipeByIS(generic(79), 6))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.paleItems")
                    .setReferal(
                        generic(38),
                        generic(39),
                        generic(40),
                        generic(41),
                        generic(42),
                        new ItemStack(ECBlocks.platingPale),
                        new ItemStack(ECBlocks.blockPale))
                    .setDisplayStack(new ItemStack(ECBlocks.platingPale))
                    .apendPage(next("paleItems").setText(StatCollector.translateToLocal("ec3.page.paleItems_0.txt")))
                    .apendPage(next("paleItems").setRecipe(ECUtils.findRecipeByIS(generic(39), 5)))
                    .apendPage(next("paleItems").setRecipe(ECUtils.findRecipeByIS(generic(38), 5)))
                    .apendPage(next("paleItems").setRecipe(ECUtils.findRecipeByIS(generic(40), 5)))
                    .apendPage(next("paleItems").setRecipe(ECUtils.findRecipeByIS(generic(41), 6)))
                    .apendPage(next("paleItems").setRecipe(ECUtils.findRecipeByIS(generic(42), 5)))
                    .apendPage(
                        next("paleItems").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.platingPale), 2)))
                    .apendPage(
                        next("paleItems").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.blockPale), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicMonocle").setReferal(new ItemStack(ECItems.magicMonocle, 0, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicMonocle, 0, 0))
                    .apendPage(
                        next("magicMonocle").setText(StatCollector.translateToLocal("ec3.page.magicMonocle_0.txt")))
                    .apendPage(
                        next("magicMonocle")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicMonocle), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mrucumover2").setReferal(new ItemStack(ECItems.mruMover_t2, 0, 0))
                    .setDisplayStack(new ItemStack(ECItems.mruMover_t2, 0, 0))
                    .apendPage(
                        next("mrucumover2").setText(StatCollector.translateToLocal("ec3.page.mrucumover2_0.txt")))
                    .apendPage(
                        next("mrucumover2").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.mruMover_t2), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mrucuec")
                    .setReferal(
                        new ItemStack(ECBlocks.magicPlating, 0, 0),
                        new ItemStack(ECBlocks.ecController, 0, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.ecController, 0, 0))
                    .apendPage(next("mrucuec").setText(StatCollector.translateToLocal("ec3.page.mrucuec_0.txt")))
                    .apendPage(
                        next("mrucuec")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicPlating, 1, 0), 2)))
                    .apendPage(
                        next("mrucuec")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ecController, 1, 0), 2)))
                    .apendPage(next("mrucuec").setText(StatCollector.translateToLocal("ec3.page.mrucuec_3.txt")))
                    .apendPage(
                        next("mrucuec")
                            .setDisplayStacks(
                                new ItemStack(ECBlocks.fortifiedStone),
                                new ItemStack(ECBlocks.fortifiedGlass),
                                new ItemStack(ECBlocks.magicPlating),
                                new ItemStack(ECBlocks.platingPale),
                                new ItemStack(ECBlocks.voidStone),
                                new ItemStack(ECBlocks.voidGlass),
                                new ItemStack(ECBlocks.invertedBlock, 1, 0))
                            .setText(StatCollector.translateToLocal("ec3.page.mrucuec_4.txt")))
                    .apendPage(
                        next("mrucuec")
                            .setImg(new ResourceLocation("essentialcraft", "textures/special/bookIcons/mrucuec.png")))
                    .apendPage(next("mrucuec").setText(StatCollector.translateToLocal("ec3.page.mrucuec_6.txt")))
                    .apendPage(
                        next("mrucuec").setImg(
                            new ResourceLocation("essentialcraft", "textures/special/bookIcons/mrucuec_mru.png"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mrucuec.state").setReferal(new ItemStack(ECBlocks.ecStateChecker))
                    .setDisplayStack(new ItemStack(ECBlocks.ecStateChecker, 0, 0))
                    .apendPage(
                        next("mrucuec.state").setText(StatCollector.translateToLocal("ec3.page.mrucuec.state_0.txt")))
                    .apendPage(
                        next("mrucuec.state")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ecStateChecker), 2)))
                    .apendPage(
                        next("mrucuec.state").setText(StatCollector.translateToLocal("ec3.page.mrucuec.state_2.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mrucuec.in").setReferal(new ItemStack(ECBlocks.ecAcceptor))
                    .setDisplayStack(new ItemStack(ECBlocks.ecAcceptor, 0, 0))
                    .apendPage(next("mrucuec.in").setText(StatCollector.translateToLocal("ec3.page.mrucuec.in_0.txt")))
                    .apendPage(
                        next("mrucuec.in").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ecAcceptor), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mrucuec.out").setReferal(new ItemStack(ECBlocks.ecEjector))
                    .setDisplayStack(new ItemStack(ECBlocks.ecEjector, 0, 0))
                    .apendPage(
                        next("mrucuec.out").setText(StatCollector.translateToLocal("ec3.page.mrucuec.out_0.txt")))
                    .apendPage(
                        next("mrucuec.out").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ecEjector), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mrucuec.storage").setReferal(new ItemStack(ECBlocks.ecHoldingChamber))
                    .setDisplayStack(new ItemStack(ECBlocks.ecHoldingChamber, 0, 0))
                    .apendPage(
                        next("mrucuec.storage")
                            .setText(StatCollector.translateToLocal("ec3.page.mrucuec.storage_0.txt")))
                    .apendPage(
                        next("mrucuec.storage")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ecHoldingChamber), 2)))
                    .apendPage(
                        next("mrucuec.storage")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.storage, 1, 2), 6))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mrucuec.balancer").setReferal(new ItemStack(ECBlocks.ecBalancer))
                    .setDisplayStack(new ItemStack(ECBlocks.ecBalancer, 0, 0))
                    .apendPage(
                        next("mrucuec.balancer")
                            .setText(StatCollector.translateToLocal("ec3.page.mrucuec.balancer_0.txt")))
                    .apendPage(
                        next("mrucuec.balancer")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ecBalancer), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mrucuec.redstone")
                    .setReferal(new ItemStack(ECBlocks.ecRedstoneController))
                    .setDisplayStack(new ItemStack(ECBlocks.ecRedstoneController, 0, 0))
                    .apendPage(
                        next("mrucuec.redstone")
                            .setText(StatCollector.translateToLocal("ec3.page.mrucuec.redstone_0.txt")))
                    .apendPage(
                        next("mrucuec.redstone")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ecRedstoneController), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.naturalFurnace").setReferal(new ItemStack(ECBlocks.naturalFurnace))
                    .setDisplayStack(new ItemStack(ECBlocks.naturalFurnace, 0, 0))
                    .apendPage(
                        next("naturalFurnace").setText(StatCollector.translateToLocal("ec3.page.naturalFurnace_0.txt")))
                    .apendPage(
                        next("naturalFurnace").setText(StatCollector.translateToLocal("ec3.page.naturalFurnace_1.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.naturalFurnace), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.heatGenerator").setReferal(new ItemStack(ECBlocks.heatGenerator))
                    .setDisplayStack(new ItemStack(ECBlocks.heatGenerator, 0, 0))
                    .apendPage(
                        next("heatGenerator").setText(StatCollector.translateToLocal("ec3.page.heatGenerator_0.txt")))
                    .apendPage(
                        next("heatGenerator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.heatGenerator), 2)))
                    .apendPage(
                        next("heatGenerator")
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.heatGenerator),
                                    new StructureBlock(ECBlocks.heatGenerator, 0, 0, 0, 0),
                                    new StructureBlock(Blocks.netherrack, 0, 2, 0, 0),
                                    new StructureBlock(Blocks.netherrack, 0, -2, 0, 0),
                                    new StructureBlock(Blocks.netherrack, 0, 0, 0, 2),
                                    new StructureBlock(Blocks.netherrack, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.air, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.air, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.air, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.air, 0, 1, 0, 0)))
                            .setText("5MRU/tick"))
                    .apendPage(
                        next("mrucuec.heatGenerator")
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.heatGenerator),
                                    new StructureBlock(ECBlocks.heatGenerator, 0, 0, 0, 0),
                                    new StructureBlock(Blocks.fire, 0, 2, 0, 0),
                                    new StructureBlock(Blocks.fire, 0, -2, 0, 0),
                                    new StructureBlock(Blocks.fire, 0, 0, 0, 2),
                                    new StructureBlock(Blocks.fire, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.air, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.air, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.air, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.air, 0, 1, 0, 0)))
                            .setText("8MRU/tick"))
                    .apendPage(
                        next("mrucuec.heatGenerator")
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.heatGenerator),
                                    new StructureBlock(ECBlocks.heatGenerator, 0, 0, 0, 0),
                                    new StructureBlock(Blocks.lava, 0, 2, 0, 0),
                                    new StructureBlock(Blocks.lava, 0, -2, 0, 0),
                                    new StructureBlock(Blocks.lava, 0, 0, 0, 2),
                                    new StructureBlock(Blocks.lava, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.air, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.air, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.air, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.air, 0, 1, 0, 0)))
                            .setText("16MRU/tick")))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalMirrors")
                    .setReferal(new ItemStack(ECBlocks.magicalMirror), new ItemStack(ECItems.controlRod))
                    .setDisplayStack(new ItemStack(ECBlocks.magicalMirror, 0, 0))

                    .apendPage(
                        next("magicalMirrors").setText(StatCollector.translateToLocal("ec3.page.magicalMirrors_0.txt")))
                    .apendPage(
                        next("magicalMirrors").setText(StatCollector.translateToLocal("ec3.page.magicalMirrors_1.txt")))
                    .apendPage(
                        next("magicalMirrors")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicalMirror), 2)))
                    .apendPage(
                        next("magicalMirrors")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.controlRod), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalAssembler").setReferal(new ItemStack(ECBlocks.assembler))
                    .setDisplayStack(new ItemStack(ECBlocks.assembler, 0, 0))

                    .apendPage(
                        next("magicalAssembler")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalAssembler_0.txt")))
                    .apendPage(
                        next("magicalAssembler")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalAssembler_1.txt")))
                    .apendPage(
                        next("magicalAssembler")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalAssembler_2.txt")))
                    .apendPage(
                        next("magicalAssembler")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalAssembler_3.txt")))
                    .apendPage(
                        next("magicalAssembler")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalAssembler_4.txt")))
                    .apendPage(
                        next("magicalAssembler")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.assembler), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.corruptionCleaner")

                    .setReferal(new ItemStack(ECBlocks.corruptionCleaner))
                    .setDisplayStack(new ItemStack(ECBlocks.corruptionCleaner, 0, 0))
                    .apendPage(
                        next("corruptionCleaner")
                            .setText(StatCollector.translateToLocal("ec3.page.corruptionCleaner_0.txt")))
                    .apendPage(
                        next("corruptionCleaner")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.corruptionCleaner), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.rayTower").setReferal(new ItemStack(ECBlocks.rayTower))
                    .setDisplayStack(new ItemStack(ECBlocks.rayTower, 0, 0))
                    .apendPage(next("rayTower").setText(StatCollector.translateToLocal("ec3.page.rayTower_0.txt")))
                    .apendPage(
                        next("rayTower").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.rayTower), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.book_t2").setDisplayStack(book_t2)
                    .apendPage(next("book_t2").setText(StatCollector.translateToLocal("ec3.page.book_t2_0.txt")))
                    .apendPage(next("book_t2").setRecipe(ECUtils.findRecipeByIS(book_t2, 6))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalActivator")

                    .setDisplayStack(new ItemStack(ECBlocks.rightClicker))
                    .setReferal(new ItemStack(ECBlocks.rightClicker))
                    .apendPage(
                        next("magicalActivator")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalActivator_0.txt")))
                    .apendPage(
                        next("magicalActivator")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalActivator_1.txt")))
                    .apendPage(
                        next("magicalActivator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.rightClicker, 1, 0), 2)))
                    .apendPage(
                        next("magicalActivator")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalActivator_2.txt")))
                    .apendPage(
                        next("magicalActivator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.rightClicker, 1, 1), 3)))
                    .apendPage(
                        next("magicalActivator")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalActivator_3.txt")))
                    .apendPage(
                        next("magicalActivator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.rightClicker, 1, 2), 3)))
                    .apendPage(
                        next("magicalActivator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.rightClicker, 1, 3), 3)))
                    .apendPage(
                        next("magicalActivator")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalActivator_4.txt")))
                    .apendPage(
                        next("magicalActivator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.rightClicker, 1, 4), 3)))
                    .apendPage(
                        next("magicalActivator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.rightClicker, 1, 5), 3))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.redstoneTransmitter")
                    .setDisplayStack(new ItemStack(ECBlocks.redstoneTransmitter))
                    .setReferal(new ItemStack(ECBlocks.redstoneTransmitter))

                    .apendPage(
                        next("redstoneTransmitter")
                            .setText(StatCollector.translateToLocal("ec3.page.redstoneTransmitter_0.txt")))
                    .apendPage(
                        next("redstoneTransmitter")
                            .setText(StatCollector.translateToLocal("ec3.page.redstoneTransmitter_1.txt")))
                    .apendPage(
                        next("redstoneTransmitter")
                            .setText(StatCollector.translateToLocal("ec3.page.redstoneTransmitter_2.txt")))
                    .apendPage(
                        next("redstoneTransmitter")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.redstoneTransmitter), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalHopper").setDisplayStack(new ItemStack(ECBlocks.magicalHopper))
                    .setReferal(new ItemStack(ECBlocks.magicalHopper))

                    .apendPage(
                        next("magicalHopper").setText(StatCollector.translateToLocal("ec3.page.magicalHopper_0.txt")))
                    .apendPage(
                        next("magicalHopper")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicalHopper), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.metadataManager")
                    .setDisplayStack(new ItemStack(ECBlocks.metadataManager))
                    .setReferal(new ItemStack(ECBlocks.metadataManager))

                    .apendPage(
                        next("metadataManager")
                            .setText(StatCollector.translateToLocal("ec3.page.metadataManager_0.txt")))
                    .apendPage(
                        next("metadataManager")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.metadataManager), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.blockBreaker").setDisplayStack(new ItemStack(ECBlocks.blockBreaker))
                    .setReferal(new ItemStack(ECBlocks.blockBreaker))

                    .apendPage(
                        next("blockBreaker").setText(StatCollector.translateToLocal("ec3.page.blockBreaker_0.txt")))
                    .apendPage(
                        next("blockBreaker")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.blockBreaker), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.weaponMaker").setDisplayStack(new ItemStack(ECBlocks.weaponMaker))
                    .setReferal(new ItemStack(ECBlocks.weaponMaker))

                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_0.txt")))
                    .apendPage(
                        next("weaponMaker").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.weaponMaker), 2)))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_1.txt")))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_2.txt"))
                            .setDisplayStacks(pistol))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_3.txt"))
                            .setDisplayStacks(rifle))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_4.txt"))
                            .setDisplayStacks(sniper))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_5.txt"))
                            .setDisplayStacks(gatling))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_6.txt")))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_7.txt"))
                            .setDisplayStacks(
                                new ItemStack(ECItems.genericItem, 1, 5),
                                new ItemStack(ECItems.genericItem, 1, 39),
                                new ItemStack(ECItems.genericItem, 1, 50),
                                new ItemStack(ECItems.genericItem, 1, 35),
                                new ItemStack(ECItems.genericItem, 1, 52)))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_8.txt")))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_9.txt")))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_10.txt")))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_11.txt")))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_12.txt")))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_13.txt")))
                    .apendPage(
                        next("weaponMaker").setText(StatCollector.translateToLocal("ec3.page.weaponMaker_14.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magmaticFurnace").setDisplayStack(new ItemStack(ECBlocks.furnaceMagic))
                    .setReferal(new ItemStack(ECBlocks.furnaceMagic))

                    .apendPage(
                        next("magmaticFurnace")
                            .setText(StatCollector.translateToLocal("ec3.page.magmaticFurnace_0.txt")))
                    .apendPage(
                        next("magmaticFurnace")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.furnaceMagic, 1, 0), 2)))
                    .apendPage(
                        next("magmaticFurnace")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.furnaceMagic, 1, 4), 2)))
                    .apendPage(
                        next("magmaticFurnace")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.furnaceMagic, 1, 8), 2)))
                    .apendPage(
                        next("magmaticFurnace")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.furnaceMagic, 1, 12), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalChest").setDisplayStack(new ItemStack(ECBlocks.chest))
                    .setReferal(new ItemStack(ECBlocks.chest, 1, 0), new ItemStack(ECBlocks.chest, 1, 1))
                    .setNew()
                    .apendPage(
                        next("magicalChest").setText(StatCollector.translateToLocal("ec3.page.magicalChest_0.txt")))
                    .apendPage(
                        next("magicalChest")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.chest, 1, 0), 2)))
                    .apendPage(
                        next("magicalChest")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.chest, 1, 1), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.replanter").setDisplayStack(new ItemStack(ECBlocks.device, 1, 0))
                    .setReferal(new ItemStack(ECBlocks.device, 1, 0))
                    .setNew()
                    .apendPage(next("replanter").setText(StatCollector.translateToLocal("ec3.page.replanter_0.txt")))
                    .apendPage(
                        next("replanter").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.device, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.itemShuffler").setDisplayStack(new ItemStack(ECBlocks.device, 1, 1))
                    .setReferal(new ItemStack(ECBlocks.device, 1, 1))
                    .setNew()
                    .apendPage(
                        next("itemShuffler").setText(StatCollector.translateToLocal("ec3.page.itemShuffler_0.txt")))
                    .apendPage(
                        next("itemShuffler")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.device, 1, 1), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.crafter").setDisplayStack(new ItemStack(ECBlocks.device, 1, 2))
                    .setReferal(new ItemStack(ECBlocks.device, 1, 2), new ItemStack(ECItems.craftingFrame, 1, 0))
                    .setNew()
                    .apendPage(next("crafter").setText(StatCollector.translateToLocal("ec3.page.crafter_0.txt")))
                    .apendPage(next("crafter").setText(StatCollector.translateToLocal("ec3.page.crafter_1.txt")))
                    .apendPage(
                        next("crafter").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.device, 1, 2), 2)))
                    .apendPage(
                        next("crafter")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.craftingFrame, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.breeder").setDisplayStack(new ItemStack(ECBlocks.device, 1, 3))
                    .setReferal(new ItemStack(ECBlocks.device, 1, 3))
                    .setNew()
                    .apendPage(next("breeder").setText(StatCollector.translateToLocal("ec3.page.breeder_0.txt")))
                    .apendPage(
                        next("breeder").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.device, 1, 3), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.shearingStation").setDisplayStack(new ItemStack(ECBlocks.device, 1, 5))
                    .setReferal(new ItemStack(ECBlocks.device, 1, 5))
                    .setNew()
                    .apendPage(
                        next("shearingStation")
                            .setText(StatCollector.translateToLocal("ec3.page.shearingStation_0.txt")))
                    .apendPage(
                        next("shearingStation")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.device, 1, 5), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.separator").setDisplayStack(new ItemStack(ECBlocks.device, 1, 6))
                    .setReferal(new ItemStack(ECBlocks.device, 1, 6), new ItemStack(ECBlocks.device, 1, 6))
                    .setNew()
                    .apendPage(next("separator").setText(StatCollector.translateToLocal("ec3.page.separator_0.txt")))
                    .apendPage(next("separator").setText(StatCollector.translateToLocal("ec3.page.separator_1.txt")))
                    .apendPage(
                        next("separator").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.device, 1, 6), 2)))
                    .apendPage(
                        next("separator").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.device, 1, 7), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.advBreaker").setDisplayStack(new ItemStack(ECBlocks.advBreaker, 1, 0))
                    .setReferal(new ItemStack(ECBlocks.advBreaker, 1, 0), new ItemStack(ECItems.filter, 1, 0))
                    .setNew()
                    .apendPage(next("advBreaker").setText(StatCollector.translateToLocal("ec3.page.advBreaker_0.txt")))
                    .apendPage(
                        next("advBreaker")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.advBreaker, 1, 0), 2)))
                    .apendPage(next("advBreaker").setText(StatCollector.translateToLocal("ec3.page.advBreaker_1.txt")))
                    .apendPage(next("advBreaker").setText(StatCollector.translateToLocal("ec3.page.advBreaker_2.txt")))
                    .apendPage(
                        next("advBreaker").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.filter, 1, 0), 2)))
                    .apendPage(next("advBreaker").setText(StatCollector.translateToLocal("ec3.page.advBreaker_3.txt")))
                    .apendPage(
                        next("advBreaker").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.filter, 1, 2), 2)))
                    .apendPage(next("advBreaker").setText(StatCollector.translateToLocal("ec3.page.advBreaker_4.txt")))
                    .apendPage(
                        next("advBreaker").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.filter, 1, 1), 2)))
                    .apendPage(
                        next("advBreaker")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.filter, 1, 3), 2))));
    }

    public static void registerEngineersCategory() {
        ItemStack book_t2 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t2)
            .setInteger("tier", 2);
        ItemStack book_t3 = new ItemStack(ECItems.research_book);
        MiscUtils.getStackTag(book_t3)
            .setInteger("tier", 3);
        ItemStack crystal = new ItemStack(ECBlocks.elementalCrystal);
        MiscUtils.getStackTag(crystal)
            .setFloat("size", 100);
        MiscUtils.getStackTag(crystal)
            .setFloat("fire", 100);
        eng.apendDiscovery(
            new DiscoveryEntry("ec3.disc.crystals")
                .setReferal(
                    crystal,
                    new ItemStack(ECBlocks.crystalFormer),
                    new ItemStack(ECBlocks.crystalController),
                    new ItemStack(ECBlocks.crystalExtractor),
                    new ItemStack(ECItems.elementalFuel, 0, 0),
                    new ItemStack(ECItems.elementalFuel, 0, 1),
                    new ItemStack(ECItems.elementalFuel, 0, 2),
                    new ItemStack(ECItems.elementalFuel, 0, 3),
                    new ItemStack(ECItems.fFocus),
                    new ItemStack(ECItems.wFocus),
                    new ItemStack(ECItems.eFocus),
                    new ItemStack(ECItems.aFocus))
                .setDisplayStack(crystal)
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_0.txt")))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_1.txt")))
                .apendPage(
                    next("crystals").setDisplayStacks(crystal)
                        .setText(StatCollector.translateToLocal("ec3.page.crystals_2.txt")))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_3.txt")))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_4.txt")))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_5.txt")))
                .apendPage(
                    next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.crystalFormer), 2)))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_7.txt")))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_8.txt")))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_9.txt")))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_10.txt")))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_11.txt")))
                .apendPage(
                    next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.crystalController), 2)))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_13.txt")))
                .apendPage(
                    next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.crystalExtractor), 2)))
                .apendPage(next("crystals").setText(StatCollector.translateToLocal("ec3.page.crystals_15.txt")))
                .apendPage(
                    next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elementalFuel, 1, 0), 2)))
                .apendPage(
                    next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elementalFuel, 1, 1), 2)))
                .apendPage(
                    next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elementalFuel, 1, 2), 2)))
                .apendPage(
                    next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.elementalFuel, 1, 3), 2)))
                .apendPage(next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.fFocus, 1, 0), 2)))
                .apendPage(next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.wFocus, 1, 0), 2)))
                .apendPage(next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.eFocus, 1, 0), 2)))
                .apendPage(
                    next("crystals").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.aFocus, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.matrixSwitch")
                    .setReferal(
                        new ItemStack(ECItems.matrixProj, 1, 0),
                        new ItemStack(ECItems.matrixProj, 1, 1),
                        new ItemStack(ECItems.matrixProj, 1, 2),
                        new ItemStack(ECItems.matrixProj, 1, 3),
                        new ItemStack(ECItems.matrixProj, 1, 4))
                    .setDisplayStack(new ItemStack(ECItems.matrixProj, 1, 3))
                    .apendPage(
                        next("matrixSwitch").setText(StatCollector.translateToLocal("ec3.page.matrixSwitch_0.txt")))
                    .apendPage(
                        next("matrixSwitch").setText(StatCollector.translateToLocal("ec3.page.matrixSwitch_1.txt")))
                    .apendPage(
                        next("matrixSwitch")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.matrixProj, 1, 0), 5)))
                    .apendPage(
                        next("matrixSwitch")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.matrixProj, 1, 1), 5)))
                    .apendPage(
                        next("matrixSwitch")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.matrixProj, 1, 2), 5)))
                    .apendPage(
                        next("matrixSwitch")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.matrixProj, 1, 3), 5))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.enderGen").setReferal(new ItemStack(ECBlocks.enderGenerator, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.enderGenerator, 1, 0))
                    .apendPage(next("enderGen").setText(StatCollector.translateToLocal("ec3.page.enderGen_0.txt")))
                    .apendPage(
                        next("enderGen")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.enderGenerator, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.coldDistillator")

                    .setReferal(
                        new ItemStack(ECBlocks.coldStone, 1, 0),
                        new ItemStack(ECBlocks.coldDistillator, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.coldDistillator, 1, 0))
                    .apendPage(
                        next("coldDistillator")
                            .setText(StatCollector.translateToLocal("ec3.page.coldDistillator_0.txt")))
                    .apendPage(
                        next("coldDistillator")
                            .setText(StatCollector.translateToLocal("ec3.page.coldDistillator_1.txt")))
                    .apendPage(
                        next("coldDistillator")
                            .setText(StatCollector.translateToLocal("ec3.page.coldDistillator_2.txt")))
                    .apendPage(
                        next("coldDistillator")
                            .setText(StatCollector.translateToLocal("ec3.page.coldDistillator_3.txt"))
                            .setDisplayStacks(new ItemStack(Blocks.snow_layer)))
                    .apendPage(
                        next("coldDistillator")
                            .setText(StatCollector.translateToLocal("ec3.page.coldDistillator_4.txt"))
                            .setDisplayStacks(new ItemStack(Blocks.snow)))
                    .apendPage(
                        next("coldDistillator")
                            .setText(StatCollector.translateToLocal("ec3.page.coldDistillator_5.txt"))
                            .setDisplayStacks(new ItemStack(Blocks.ice)))
                    .apendPage(
                        next("coldDistillator")
                            .setText(StatCollector.translateToLocal("ec3.page.coldDistillator_6.txt"))
                            .setDisplayStacks(new ItemStack(Blocks.packed_ice)))
                    .apendPage(
                        next("coldDistillator")
                            .setText(StatCollector.translateToLocal("ec3.page.coldDistillator_7.txt"))
                            .setDisplayStacks(new ItemStack(ECBlocks.coldStone)))
                    .apendPage(
                        next("coldDistillator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.coldStone, 1, 0), 2)))
                    .apendPage(
                        next("coldDistillator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.coldDistillator, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.solarAbsorber")
                    .setReferal(
                        new ItemStack(ECBlocks.solarPrism, 1, 0),
                        new ItemStack(ECBlocks.sunRayAbsorber, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.solarPrism, 1, 0))

                    .apendPage(
                        next("solarAbsorber").setText(StatCollector.translateToLocal("ec3.page.solarAbsorber_0.txt")))
                    .apendPage(
                        next("solarAbsorber").setText(StatCollector.translateToLocal("ec3.page.solarAbsorber_1.txt")))
                    .apendPage(
                        next("solarAbsorber").setText(StatCollector.translateToLocal("ec3.page.solarAbsorber_2.txt")))
                    .apendPage(
                        next("solarAbsorber")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.solarPrism, 1, 0), 2)))
                    .apendPage(
                        next("solarAbsorber").setRecipe(
                            new StructureRecipe(
                                new ItemStack(ECBlocks.solarPrism, 1, 0),
                                new StructureBlock(ECBlocks.solarPrism, 0, 0, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, 1, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, -1, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, 0, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, 0, 0, -1),
                                new StructureBlock(ECBlocks.air, 0, 1, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, 1, 0, -1),
                                new StructureBlock(ECBlocks.air, 0, -1, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, -1, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 2),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, -2))))
                    .apendPage(
                        next("solarAbsorber").setText(StatCollector.translateToLocal("ec3.page.solarAbsorber_5.txt")))
                    .apendPage(
                        next("solarAbsorber")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.sunRayAbsorber, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.moonWell")

                    .setReferal(new ItemStack(ECBlocks.moonWell, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.moonWell, 1, 0))
                    .apendPage(next("moonWell").setText(StatCollector.translateToLocal("ec3.page.moonWell_0.txt")))
                    .apendPage(next("moonWell").setText(StatCollector.translateToLocal("ec3.page.moonWell_1.txt")))
                    .apendPage(next("moonWell").setText(StatCollector.translateToLocal("ec3.page.moonWell_2.txt")))
                    .apendPage(
                        next("moonWell")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.moonWell, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.reactor")

                    .setReferal(new ItemStack(ECBlocks.reactor, 1, 0), new ItemStack(ECBlocks.reactorSupport, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.reactor, 1, 0))
                    .apendPage(next("reactor").setText(StatCollector.translateToLocal("ec3.page.reactor_0.txt")))
                    .apendPage(
                        next("reactor")
                            .setImg(new ResourceLocation("essentialcraft", "textures/special/bookIcons/reactor.png")))
                    .apendPage(next("reactor").setText(StatCollector.translateToLocal("ec3.page.reactor_2.txt")))
                    .apendPage(
                        next("reactor").setRecipe(
                            new StructureRecipe(
                                new ItemStack(ECBlocks.reactor, 1, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 1, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 1, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 1, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, -1, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, -1, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, -1, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, -1))))
                    .apendPage(
                        next("reactor").setRecipe(
                            new StructureRecipe(
                                new ItemStack(ECBlocks.reactor, 1, 0),
                                new StructureBlock(ECBlocks.reactor, 0, 0, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, 0, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, 0, 0, -1),
                                new StructureBlock(ECBlocks.reactorSupport, 0, 1, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, 1, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, 1, 0, -1),
                                new StructureBlock(ECBlocks.air, 0, 2, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, 2, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, 2, 0, -1),
                                new StructureBlock(ECBlocks.reactorSupport, 0, -1, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, -1, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, -1, 0, -1),
                                new StructureBlock(ECBlocks.air, 0, -2, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, -2, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, -2, 0, -1))))
                    .apendPage(
                        next("reactor").setRecipe(
                            new StructureRecipe(
                                new ItemStack(ECBlocks.reactor, 1, 0),
                                new StructureBlock(ECBlocks.air, 0, 0, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, 0, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, 0, 0, -1),
                                new StructureBlock(ECBlocks.reactorSupport, 0, 1, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, 1, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, 1, 0, -1),
                                new StructureBlock(ECBlocks.air, 0, 2, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, 2, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, 2, 0, -1),
                                new StructureBlock(ECBlocks.reactorSupport, 0, -1, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, -1, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, -1, 0, -1),
                                new StructureBlock(ECBlocks.air, 0, -2, 0, 0),
                                new StructureBlock(ECBlocks.air, 0, -2, 0, 1),
                                new StructureBlock(ECBlocks.air, 0, -2, 0, -1))))
                    .apendPage(
                        next("reactor")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.reactorSupport, 1, 0), 2)))
                    .apendPage(
                        next("reactor").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.reactor, 1, 0), 2)))
                    .apendPage(next("reactor").setText(StatCollector.translateToLocal("ec3.page.reactor_8.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.soulStorage")
                    .setReferal(
                        new ItemStack(ECBlocks.chargingChamber, 1, 0),
                        new ItemStack(ECItems.storage, 1, 0),
                        new ItemStack(ECItems.storage, 1, 1),
                        new ItemStack(ECItems.storage, 1, 2),
                        new ItemStack(ECItems.storage, 1, 3),
                        new ItemStack(ECItems.storage, 1, 4))
                    .setDisplayStack(new ItemStack(ECItems.storage, 1, 4))
                    .apendPage(
                        next("soulStorage").setText(StatCollector.translateToLocal("ec3.page.soulStorage_0.txt")))
                    .apendPage(
                        next("soulStorage").setText(StatCollector.translateToLocal("ec3.page.soulStorage_1.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.storage, 1, 0), 6)))
                    .apendPage(
                        next("soulStorage").setText(StatCollector.translateToLocal("ec3.page.soulStorage_2.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.storage, 1, 1), 6)))
                    .apendPage(
                        next("soulStorage").setText(StatCollector.translateToLocal("ec3.page.soulStorage_3.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.storage, 1, 2), 6)))
                    .apendPage(
                        next("soulStorage").setText(StatCollector.translateToLocal("ec3.page.soulStorage_4.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.storage, 1, 3), 6)))
                    .apendPage(
                        next("soulStorage").setText(StatCollector.translateToLocal("ec3.page.soulStorage_5.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.storage, 1, 4), 6)))
                    .apendPage(
                        next("soulStorage").setText(StatCollector.translateToLocal("ec3.page.soulStorage_6.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.chargingChamber, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalDigger")

                    .setReferal(new ItemStack(ECItems.magicalDigger, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicalDigger, 1, 0))
                    .apendPage(
                        next("magicalDigger").setText(StatCollector.translateToLocal("ec3.page.magicalDigger_0.txt")))
                    .apendPage(
                        next("magicalDigger")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicalDigger, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalLantern")

                    .setReferal(new ItemStack(ECItems.magicalLantern, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicalLantern, 1, 0))
                    .apendPage(
                        next("magicalLantern").setText(StatCollector.translateToLocal("ec3.page.magicalLantern_0.txt")))
                    .apendPage(
                        next("magicalLantern")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicalLantern, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magnetizingStaff")

                    .setReferal(new ItemStack(ECItems.magnetizingStaff, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magnetizingStaff, 1, 0))
                    .apendPage(
                        next("magnetizingStaff")
                            .setText(StatCollector.translateToLocal("ec3.page.magnetizingStaff_0.txt")))
                    .apendPage(
                        next("magnetizingStaff")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magnetizingStaff, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.spawnerCollector")

                    .setReferal(new ItemStack(ECItems.spawnerCollector, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.spawnerCollector, 1, 0))
                    .apendPage(
                        next("spawnerCollector")
                            .setText(StatCollector.translateToLocal("ec3.page.spawnerCollector_0.txt")))
                    .apendPage(
                        next("spawnerCollector")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.spawnerCollector, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.lifeStaff")

                    .setReferal(new ItemStack(ECItems.staffOfLife, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.staffOfLife, 1, 0))
                    .apendPage(next("lifeStaff").setText(StatCollector.translateToLocal("ec3.page.lifeStaff_0.txt")))
                    .apendPage(
                        next("lifeStaff")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.staffOfLife, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.holyMace")

                    .setReferal(new ItemStack(ECItems.holyMace, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.holyMace, 1, 0))
                    .apendPage(next("holyMace").setText(StatCollector.translateToLocal("ec3.page.holyMace_0.txt")))
                    .apendPage(
                        next("holyMace").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.holyMace, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.emeraldHeart")

                    .setReferal(new ItemStack(ECItems.emeraldHeart, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.emeraldHeart, 1, 0))
                    .apendPage(
                        next("emeraldHeart").setText(StatCollector.translateToLocal("ec3.page.emeraldHeart_0.txt")))
                    .apendPage(
                        next("emeraldHeart")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.emeraldHeart, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalWings")

                    .setReferal(new ItemStack(ECItems.magicalWings, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicalWings, 1, 0))
                    .apendPage(
                        next("magicalWings").setText(StatCollector.translateToLocal("ec3.page.magicalWings_0.txt")))
                    .apendPage(
                        next("magicalWings")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicalWings, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalPorkchop")

                    .setReferal(new ItemStack(ECItems.magicalPorkchop, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicalPorkchop, 1, 0))
                    .apendPage(
                        next("magicalPorkchop")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalPorkchop_0.txt")))
                    .apendPage(
                        next("magicalPorkchop")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicalPorkchop, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalWater")

                    .setReferal(new ItemStack(ECItems.magicWaterBottle, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicWaterBottle, 1, 0))
                    .apendPage(
                        next("magicalWater").setText(StatCollector.translateToLocal("ec3.page.magicalWater_0.txt")))
                    .apendPage(
                        next("magicalWater")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicWaterBottle, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalShield")

                    .setReferal(
                        new ItemStack(ECItems.magicalShield, 1, 0),
                        new ItemStack(ECItems.spikyShield, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicalShield, 1, 0))
                    .apendPage(
                        next("magicalShield").setText(StatCollector.translateToLocal("ec3.page.magicalShield_0.txt")))
                    .apendPage(
                        next("magicalShield")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicalShield, 1, 0), 2)))
                    .apendPage(
                        next("magicalShield")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.spikyShield, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.biomeWand")

                    .setReferal(new ItemStack(ECItems.biomeWand, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.biomeWand, 1, 0))
                    .apendPage(next("biomeWand").setText(StatCollector.translateToLocal("ec3.page.biomeWand_0.txt")))
                    .apendPage(
                        next("biomeWand")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.biomeWand, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.chaosFork")

                    .setReferal(new ItemStack(ECItems.chaosFork, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.chaosFork, 1, 0))
                    .apendPage(next("chaosFork").setText(StatCollector.translateToLocal("ec3.page.chaosFork_0.txt")))
                    .apendPage(
                        next("chaosFork")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.chaosFork, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.frozenMace").setReferal(new ItemStack(ECItems.frozenMace, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.frozenMace, 1, 0))
                    .apendPage(next("frozenMace").setText(StatCollector.translateToLocal("ec3.page.frozenMace_0.txt")))
                    .apendPage(
                        next("frozenMace")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.frozenMace, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magmaticStaff").setReferal(new ItemStack(ECItems.magmaticStaff, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magmaticStaff, 1, 0))
                    .apendPage(
                        next("magmaticStaff").setText(StatCollector.translateToLocal("ec3.page.magmaticStaff_0.txt")))
                    .apendPage(
                        next("magmaticStaff")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magmaticStaff, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mhs")
                    .setReferal(
                        new ItemStack(ECItems.magicArmorItems[0], 1, 0),
                        new ItemStack(ECItems.magicArmorItems[1], 1, 0),
                        new ItemStack(ECItems.magicArmorItems[2], 1, 0),
                        new ItemStack(ECItems.magicArmorItems[3], 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicArmorItems[0], 1, 0))
                    .apendPage(next("mhs").setText(StatCollector.translateToLocal("ec3.page.mhs_0.txt")))
                    .apendPage(
                        next("mhs")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicArmorItems[0], 1, 0), 2)))
                    .apendPage(
                        next("mhs")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicArmorItems[1], 1, 0), 2)))
                    .apendPage(
                        next("mhs")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicArmorItems[2], 1, 0), 2)))
                    .apendPage(
                        next("mhs")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicArmorItems[3], 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.elementalCharms")
                    .setReferal(
                        new ItemStack(ECItems.charm, 1, 0),
                        new ItemStack(ECItems.charm, 1, 1),
                        new ItemStack(ECItems.charm, 1, 2),
                        new ItemStack(ECItems.charm, 1, 3),
                        new ItemStack(ECItems.charm, 1, 4),
                        new ItemStack(ECItems.charm, 1, 5),
                        new ItemStack(ECItems.charm, 1, 6),
                        new ItemStack(ECItems.charm, 1, 7),
                        new ItemStack(ECItems.charm, 1, 8),
                        new ItemStack(ECItems.charm, 1, 9))
                    .setDisplayStack(new ItemStack(ECItems.charm, 1, 7))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_0.txt")))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_1.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 0), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_2.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 1), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_3.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 2), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_4.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 3), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_5.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 4), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_6.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 5), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_7.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 6), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_8.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 7), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_9.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 8), 2)))
                    .apendPage(
                        next("elementalCharms")
                            .setText(StatCollector.translateToLocal("ec3.page.elementalCharms_10.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.charm, 1, 9), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.mruCoil")
                    .setReferal(
                        new ItemStack(ECItems.playerList, 1, 0),
                        new ItemStack(ECBlocks.mruCoil, 1, 0),
                        new ItemStack(ECBlocks.mruCoilHardener, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.mruCoil, 1, 0))
                    .apendPage(next("mruCoil").setText(StatCollector.translateToLocal("ec3.page.mruCoil_0.txt")))
                    .apendPage(
                        next("mruCoil").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mruCoil, 1, 0), 2)))
                    .apendPage(
                        next("mruCoil")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mruCoilHardener, 1, 0), 2)))
                    .apendPage(
                        next("mruCoil").setRecipe(
                            new StructureRecipe(
                                new ItemStack(ECBlocks.mruCoil, 1, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 1, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 1, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 1, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, -1, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, -1, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, -1, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 2),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, -2),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 3),
                                new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, -3),
                                new StructureBlock(ECBlocks.magicPlating, 0, -3, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, 3, 0, 0),
                                new StructureBlock(ECBlocks.magicPlating, 0, -3, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 3, 0, 1),
                                new StructureBlock(ECBlocks.magicPlating, 0, -3, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 3, 0, -1),
                                new StructureBlock(ECBlocks.magicPlating, 0, 1, 0, 3),
                                new StructureBlock(ECBlocks.magicPlating, 0, 1, 0, -3),
                                new StructureBlock(ECBlocks.magicPlating, 0, -1, 0, 3),
                                new StructureBlock(ECBlocks.magicPlating, 0, -1, 0, -3))))
                    .apendPage(next("mruCoil").setText(StatCollector.translateToLocal("ec3.page.mruCoil_4.txt")))
                    .apendPage(next("mruCoil").setText(StatCollector.translateToLocal("ec3.page.mruCoil_5.txt")))
                    .apendPage(
                        next("mruCoil").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.playerList, 1, 0), 2)))
                    .apendPage(next("mruCoil").setText(StatCollector.translateToLocal("ec3.page.mruCoil_7.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.potionSpreader").setReferal(new ItemStack(ECBlocks.potionSpreader, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.potionSpreader, 1, 0))
                    .apendPage(
                        next("potionSpreader").setText(StatCollector.translateToLocal("ec3.page.potionSpreader_0.txt")))
                    .apendPage(
                        next("potionSpreader")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.potionSpreader, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalEnchanter")
                    .setReferal(new ItemStack(ECBlocks.magicalEnchanter, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.magicalEnchanter, 1, 0))
                    .apendPage(
                        next("magicalEnchanter")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalEnchanter_0.txt")))
                    .apendPage(
                        next("magicalEnchanter")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicalEnchanter, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.monsterHolder").setReferal(new ItemStack(ECBlocks.monsterClinger, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.monsterClinger, 1, 0))
                    .apendPage(
                        next("monsterHolder").setText(StatCollector.translateToLocal("ec3.page.monsterHolder_0.txt")))
                    .apendPage(
                        next("monsterHolder")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.monsterClinger, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalJukebox").setReferal(new ItemStack(ECBlocks.magicalJukebox, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.magicalJukebox, 1, 0))
                    .apendPage(
                        next("magicalJukebox").setText(StatCollector.translateToLocal("ec3.page.magicalJukebox_0.txt")))
                    .apendPage(
                        next("magicalJukebox")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicalJukebox, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalRepairer")
                    .setReferal(new ItemStack(ECBlocks.magicalRepairer, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.magicalRepairer, 1, 0))
                    .apendPage(
                        next("magicalRepairer")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalRepairer_0.txt")))
                    .apendPage(
                        next("magicalRepairer")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicalRepairer, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.monsterDuplicator")
                    .setReferal(new ItemStack(ECBlocks.monsterHarvester, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.monsterHarvester, 1, 0))
                    .apendPage(
                        next("monsterDuplicator")
                            .setText(StatCollector.translateToLocal("ec3.page.monsterDuplicator_0.txt")))
                    .apendPage(
                        next("monsterDuplicator")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.monsterHarvester, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magmaticSmeltery")
                    .setReferal(new ItemStack(ECBlocks.magmaticSmeltery, 1, 0))
                    .setDisplayStack(new ItemStack(ECBlocks.magmaticSmeltery, 1, 0))
                    .apendPage(
                        next("magmaticSmeltery")
                            .setText(StatCollector.translateToLocal("ec3.page.magmaticSmeltery_0.txt")))
                    .apendPage(
                        next("magmaticSmeltery")
                            .setImg(new ResourceLocation("essentialcraft", "textures/special/bookIcons/smeltery.png")))
                    .apendPage(
                        next("magmaticSmeltery")
                            .setText(StatCollector.translateToLocal("ec3.page.magmaticSmeltery_2.txt")))
                    .apendPage(
                        next("magmaticSmeltery")
                            .setText(StatCollector.translateToLocal("ec3.page.magmaticSmeltery_3.txt")))
                    .apendPage(
                        next("magmaticSmeltery")
                            .setText(StatCollector.translateToLocal("ec3.page.magmaticSmeltery_4.txt")))
                    .apendPage(
                        next("magmaticSmeltery")
                            .setText(StatCollector.translateToLocal("ec3.page.magmaticSmeltery_5.txt")))
                    .apendPage(
                        next("magmaticSmeltery")
                            .setText(StatCollector.translateToLocal("ec3.page.magmaticSmeltery_6.txt")))
                    .apendPage(
                        next("magmaticSmeltery")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magmaticSmeltery, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalQuarry")
                    .setReferal(
                        new ItemStack(ECBlocks.magicalQuarry, 1, 0),
                        generic(18),
                        generic(19),
                        generic(17),
                        generic(80),
                        generic(81),
                        generic(78),
                        generic(77))
                    .setDisplayStack(new ItemStack(ECBlocks.magicalQuarry, 1, 0))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_0.txt")))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_1.txt")))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_2.txt")))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_3.txt")))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_4.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(generic(18), 2)))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_5.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(generic(19), 2)))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_6.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(generic(17), 2)))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_7.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(generic(80), 2)))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_8.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(generic(81), 2)))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_9.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(generic(78), 2)))
                    .apendPage(
                        next("magicalQuarry").setText(StatCollector.translateToLocal("ec3.page.magicalQuarry_10.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(generic(77), 2)))
                    .apendPage(
                        next("magicalQuarry")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicalQuarry, 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.hoanna").setReferal(new ItemStack(ECItems.windTablet, 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.windTablet, 1, 0))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_0.txt")))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_1.txt")))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_2.txt")))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_3.txt")))
                    .apendPage(
                        next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_4.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.windTablet, 1, 0), 2)))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_5.txt")))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_6.txt")))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_7.txt")))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_8.txt")))
                    .apendPage(next("hoanna").setText(StatCollector.translateToLocal("ec3.page.hoanna_9.txt")))
                    .apendPage(next("hoanna").setRecipe(ECUtils.findRecipeByIS(book_t3, 2))));
    }

    public static void registerHoannaCategory() {
        ItemStack lootable = new ItemStack(ECItems.bauble, 1, 0);
        ItemBaublesWearable.initRandomTag(lootable, new Random());
        hoanna
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.radiation")
                    .setDisplayStack(new ResourceLocation("essentialcraft", "textures/special/radiation_icon.png"))
                    .apendPage(next("radiation").setText(StatCollector.translateToLocal("ec3.page.radiation_0.txt")))
                    .apendPage(next("radiation").setText(StatCollector.translateToLocal("ec3.page.radiation_1.txt")))
                    .apendPage(next("radiation").setText(StatCollector.translateToLocal("ec3.page.radiation_2.txt")))
                    .apendPage(next("radiation").setText(StatCollector.translateToLocal("ec3.page.radiation_3.txt")))
                    .apendPage(next("radiation").setText(StatCollector.translateToLocal("ec3.page.radiation_4.txt")))
                    .apendPage(next("radiation").setText(StatCollector.translateToLocal("ec3.page.radiation_5.txt")))
                    .apendPage(next("radiation").setText(StatCollector.translateToLocal("ec3.page.radiation_6.txt")))
                    .apendPage(next("radiation").setText(StatCollector.translateToLocal("ec3.page.radiation_7.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.loot").setDisplayStack(generic(37))
                    .setReferal(
                        generic(35),
                        generic(36),
                        generic(37),
                        new ItemStack(ECItems.titanite, 1, 0),
                        new ItemStack(ECItems.twinkling_titanite, 1, 0),
                        new ItemStack(ECItems.ember, 1, 0),
                        new ItemStack(ECItems.ember, 1, 1),
                        new ItemStack(ECItems.ember, 1, 2),
                        new ItemStack(ECItems.ember, 1, 3),
                        new ItemStack(ECItems.ember, 1, 4),
                        new ItemStack(ECItems.ember, 1, 5),
                        new ItemStack(ECItems.ember, 1, 6),
                        new ItemStack(ECItems.ember, 1, 7))
                    .apendPage(next("loot").setText(StatCollector.translateToLocal("ec3.page.loot_0.txt")))
                    .apendPage(
                        next("loot").setDisplayStacks(
                            generic(35),
                            generic(36),
                            generic(37),
                            new ItemStack(ECItems.titanite, 1, 0),
                            new ItemStack(ECItems.twinkling_titanite, 1, 0),
                            new ItemStack(ECItems.ember, 1, 0),
                            new ItemStack(ECItems.ember, 1, 1),
                            new ItemStack(ECItems.ember, 1, 2),
                            new ItemStack(ECItems.ember, 1, 3),
                            new ItemStack(ECItems.ember, 1, 4),
                            new ItemStack(ECItems.ember, 1, 5),
                            new ItemStack(ECItems.ember, 1, 6),
                            new ItemStack(ECItems.ember, 1, 7),
                            lootable)))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.voidStone").setDisplayStack(new ItemStack(ECBlocks.voidStone, 1, 0))
                    .setReferal(new ItemStack(ECBlocks.voidStone, 1, 0), new ItemStack(ECBlocks.voidGlass, 1, 0))
                    .apendPage(next("voidStone").setText(StatCollector.translateToLocal("ec3.page.voidStone_0.txt")))
                    .apendPage(
                        next("voidStone").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.voidStone), 2)))
                    .apendPage(
                        next("voidStone").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.voidGlass), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.voidArmor")
                    .setReferal(
                        new ItemStack(ECItems.magicArmorItems[4], 1, 0),
                        new ItemStack(ECItems.magicArmorItems[5], 1, 0),
                        new ItemStack(ECItems.magicArmorItems[6], 1, 0),
                        new ItemStack(ECItems.magicArmorItems[7], 1, 0))
                    .setDisplayStack(new ItemStack(ECItems.magicArmorItems[5], 1, 0))
                    .apendPage(next("voidArmor").setText(StatCollector.translateToLocal("ec3.page.voidArmor_0.txt")))
                    .apendPage(
                        next("voidArmor")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicArmorItems[4], 1, 0), 2)))
                    .apendPage(
                        next("voidArmor")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicArmorItems[5], 1, 0), 2)))
                    .apendPage(
                        next("voidArmor")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicArmorItems[6], 1, 0), 2)))
                    .apendPage(
                        next("voidArmor")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicArmorItems[7], 1, 0), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalTeleporter").setReferal(new ItemStack(ECBlocks.magicalTeleporter))
                    .setDisplayStack(new ItemStack(ECBlocks.magicalTeleporter))
                    .apendPage(
                        next("magicalTeleporter")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalTeleporter_0.txt")))
                    .apendPage(
                        next("magicalTeleporter")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicalTeleporter), 2)))
                    .apendPage(
                        next("magicalTeleporter")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalTeleporter_2.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.magicalTeleporter),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.magicalTeleporter, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -2),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2))))
                    .apendPage(
                        next("magicalTeleporter")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalTeleporter_3.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.magicalTeleporter),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -2))))
                    .apendPage(
                        next("magicalTeleporter")
                            .setText(StatCollector.translateToLocal("ec3.page.magicalTeleporter_4.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.magicalTeleporter),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -2)))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalFurnace").setReferal(new ItemStack(ECBlocks.magicalFurnace))
                    .setDisplayStack(new ItemStack(ECBlocks.magicalFurnace))
                    .apendPage(
                        next("magicalFurnace").setText(StatCollector.translateToLocal("ec3.page.magicalFurnace_0.txt")))
                    .apendPage(
                        next("magicalFurnace")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.magicalFurnace), 2)))
                    .apendPage(
                        next("magicalFurnace").setText(StatCollector.translateToLocal("ec3.page.magicalFurnace_2.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.magicalFurnace),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2))))
                    .apendPage(
                        next("magicalFurnace").setText(StatCollector.translateToLocal("ec3.page.magicalFurnace_3.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.magicalFurnace),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.magicalFurnace, 0, 0, 0, 0))))
                    .apendPage(
                        next("magicalFurnace").setText(StatCollector.translateToLocal("ec3.page.magicalFurnace_4.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.magicalFurnace),
                                    new StructureBlock(ECBlocks.heatGenerator, 0, -2, 0, -2),
                                    new StructureBlock(ECBlocks.heatGenerator, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.heatGenerator, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.heatGenerator, 0, 2, 0, 2)))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.emberForge").setReferal(new ItemStack(ECBlocks.emberForge))
                    .setDisplayStack(new ItemStack(ECBlocks.emberForge))
                    .apendPage(next("emberForge").setText(StatCollector.translateToLocal("ec3.page.emberForge_0.txt")))
                    .apendPage(
                        next("emberForge").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.emberForge), 2)))
                    .apendPage(
                        next("emberForge").setText(StatCollector.translateToLocal("ec3.page.emberForge_2.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.emberForge),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2))))
                    .apendPage(
                        next("emberForge").setText(StatCollector.translateToLocal("ec3.page.emberForge_3.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.emberForge),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.platingPale, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.platingPale, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.platingPale, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.platingPale, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.emberForge, 0, 0, 0, 0))))
                    .apendPage(
                        next("emberForge").setText(StatCollector.translateToLocal("ec3.page.emberForge_4.txt"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.emberForge),
                                    new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, -2),
                                    new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, 2)))))

            /*
             * .apendDiscovery(
             * new DiscoveryEntry("ec3.disc.mim")
             * .setDisplayStack(new ItemStack(BlocksCore.mim,1,0))
             * .setReferal(new ItemStack(BlocksCore.mim,1,0),new ItemStack(BlocksCore.minEjector,1,0),new
             * ItemStack(BlocksCore.minInjector,1,0),new ItemStack(ItemsCore.filter,1,0))
             * .apendPage(next("mim").setText(StatCollector.translateToLocal("ec3.page.mim_0.txt")))
             * .apendPage(next("mim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ItemsCore.filter,1,0), 2)))
             * .apendPage(next("mim").setText(StatCollector.translateToLocal("ec3.page.mim_2.txt")))
             * .apendPage(next("mim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ItemsCore.filter,1,1), 2)))
             * .apendPage(next("mim").setText(StatCollector.translateToLocal("ec3.page.mim_4.txt")))
             * .apendPage(next("mim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(BlocksCore.minEjector,1,0), 2)))
             * .apendPage(next("mim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(BlocksCore.minEjector,1,6), 2)))
             * .apendPage(next("mim").setText(StatCollector.translateToLocal("ec3.page.mim_7.txt")))
             * .apendPage(next("mim").setText(StatCollector.translateToLocal("ec3.page.mim_8.txt")))
             * .apendPage(next("mim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(BlocksCore.minInjector,1,0), 2)))
             * .apendPage(next("mim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(BlocksCore.minInjector,1,6), 2)))
             * .apendPage(next("mim").setText(StatCollector.translateToLocal("ec3.page.mim_11.txt")))
             * .apendPage(next("mim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(BlocksCore.mim,1,0), 2)))
             * .apendPage(next("mim").setText(StatCollector.translateToLocal("ec3.page.mim_13.txt")))
             * )
             */
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.o8elisk").setDisplayStack(new ItemStack(ECBlocks.darknessObelisk, 1, 0))
                    .setReferal(new ItemStack(ECBlocks.darknessObelisk, 1, 0))

                    .apendPage(next("o8elisk").setText(StatCollector.translateToLocal("ec3.page.o8elisk_0.txt")))
                    .apendPage(
                        next("o8elisk")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.darknessObelisk), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.ultraHeat").setDisplayStack(new ItemStack(ECBlocks.ultraHeatGen, 1, 0))
                    .setReferal(new ItemStack(ECBlocks.ultraHeatGen, 1, 0))

                    .apendPage(next("ultraHeat").setText(StatCollector.translateToLocal("ec3.page.ultraHeat_0.txt")))
                    .apendPage(
                        next("ultraHeat").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ultraHeatGen), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.ultraFlower")
                    .setDisplayStack(new ItemStack(ECBlocks.ultraFlowerBurner, 1, 0))
                    .setReferal(new ItemStack(ECBlocks.ultraFlowerBurner, 1, 0))

                    .apendPage(
                        next("ultraFlower").setText(StatCollector.translateToLocal("ec3.page.ultraFlower_0.txt")))
                    .apendPage(
                        next("ultraFlower")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.ultraFlowerBurner), 2))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.magicalBuilder")
                    .setDisplayStack(new ItemStack(ECItems.magicalBuilder, 1, 0))
                    .setReferal(new ItemStack(ECItems.magicalBuilder, 1, 0))

                    .apendPage(
                        next("magicalBuilder").setText(StatCollector.translateToLocal("ec3.page.magicalBuilder_0.txt")))
                    .apendPage(
                        next("magicalBuilder").setText(StatCollector.translateToLocal("ec3.page.magicalBuilder_1.txt")))
                    .apendPage(
                        next("magicalBuilder").setText(StatCollector.translateToLocal("ec3.page.magicalBuilder_2.txt")))
                    .apendPage(
                        next("magicalBuilder").setText(StatCollector.translateToLocal("ec3.page.magicalBuilder_3.txt")))
                    .apendPage(
                        next("magicalBuilder").setText(StatCollector.translateToLocal("ec3.page.magicalBuilder_4.txt")))
                    .apendPage(
                        next("magicalBuilder").setText(StatCollector.translateToLocal("ec3.page.magicalBuilder_5.txt")))
                    .apendPage(
                        next("magicalBuilder")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.magicalBuilder), 2))))
            .apendDiscovery(
                new DiscoveryEntry("hologram")

                    .setDisplayStack(new ItemStack(ECItems.genericItem, 1, 76))
                    .setReferal(
                        new ItemStack(ECItems.genericItem, 1, 70),
                        new ItemStack(ECItems.genericItem, 1, 71),
                        new ItemStack(ECItems.genericItem, 1, 72),
                        new ItemStack(ECItems.genericItem, 1, 73),
                        new ItemStack(ECBlocks.holopad, 1, 0))
                    .apendPage(next("hologram").setText(StatCollector.translateToLocal("ec3.page.hologram_0.txt")))
                    .apendPage(
                        next("hologram").setText(StatCollector.translateToLocal("ec3.page.hologram_1.txt"))
                            .setDisplayStacks(
                                new ItemStack(ECItems.genericItem, 1, 70),
                                new ItemStack(ECItems.genericItem, 1, 71),
                                new ItemStack(ECItems.genericItem, 1, 72),
                                new ItemStack(ECItems.genericItem, 1, 73)))
                    .apendPage(next("hologram").setText(StatCollector.translateToLocal("ec3.page.hologram_2.txt")))
                    .apendPage(
                        next("hologram").setText(StatCollector.translateToLocal("ec3.page.hologram_3.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.holopad), 2))))
            .apendDiscovery(
                new DiscoveryEntry("redSuit")

                    .setDisplayStack(new ItemStack(ECItems.computer_helmet, 1, 0))
                    .setReferal(
                        new ItemStack(ECItems.computer_helmet, 1, 0),
                        new ItemStack(ECItems.computer_chestplate, 1, 0),
                        new ItemStack(ECItems.computer_leggings, 1, 0),
                        new ItemStack(ECItems.computer_boots, 1, 0),
                        new ItemStack(ECItems.computerBoard, 1, 0),
                        gen(56),
                        gen(57),
                        gen(58),
                        gen(59),
                        gen(60),
                        gen(61),
                        gen(62),
                        gen(63),
                        gen(64),
                        gen(65),
                        gen(66),
                        gen(67),
                        gen(68),
                        gen(69),
                        gen(74),
                        gen(75))
                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_0.txt")))
                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_1.txt")))
                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_2.txt")))
                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_3.txt")))
                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_4.txt")))
                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_5.txt")))
                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_6.txt")))
                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_7.txt")))

                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(54), 6)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(53), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(59), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(74), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(68), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(69), 2)))

                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(56), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(60), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(63), 2)))

                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(65), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(67), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(66), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(58), 2)))

                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(75), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(57), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(64), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(61), 2)))
                    .apendPage(next("redSuit").setRecipe(ECUtils.findRecipeByIS(gen(62), 2)))

                    .apendPage(
                        next("redSuit").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.computer_helmet), 2)))
                    .apendPage(
                        next("redSuit")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.computer_chestplate), 2)))
                    .apendPage(
                        next("redSuit")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.computer_leggings), 2)))
                    .apendPage(
                        next("redSuit").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.computer_boots), 2)))
                    .apendPage(
                        next("redSuit").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.computerBoard), 2)))

                    .apendPage(next("redSuit").setText(StatCollector.translateToLocal("ec3.page.redSuit_?.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("ec3.disc.newMim").setNew()
                    .setDisplayStack(new ItemStack(ECBlocks.newMim, 1, 0))
                    .setReferal(
                        new ItemStack(ECBlocks.newMim, 1, 0),
                        new ItemStack(ECBlocks.mimEjector, 1, 0),
                        new ItemStack(ECBlocks.mimInjector, 1, 0),
                        new ItemStack(ECBlocks.mimEjectorP, 1, 0),
                        new ItemStack(ECBlocks.mimInjectorP, 1, 0))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_0.txt")))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_1.txt")))
                    .apendPage(next("newMim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.newMim), 2)))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_2.txt")))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_3.txt")))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_4.txt")))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_5.txt")))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_6.txt")))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_7.txt")))
                    .apendPage(
                        next("newMim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mimEjector), 2)))
                    .apendPage(
                        next("newMim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mimInjector), 2)))
                    .apendPage(next("newMim").setText(StatCollector.translateToLocal("ec3.page.newMim_8.txt")))
                    .apendPage(
                        next("newMim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mimEjectorP), 2)))
                    .apendPage(
                        next("newMim").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mimInjectorP), 2))))
            .apendDiscovery(
                new DiscoveryEntry("newMimInv").setNew()
                    .setDisplayStack(new ItemStack(ECBlocks.mimInvStorage))
                    .setReferal(new ItemStack(ECBlocks.mimInvStorage), new ItemStack(ECItems.inventoryGem))
                    .apendPage(next("newMimInv").setText(StatCollector.translateToLocal("ec3.page.newMimInv_0.txt")))
                    .apendPage(next("newMimInv").setText(StatCollector.translateToLocal("ec3.page.newMimInv_1.txt")))
                    .apendPage(next("newMimInv").setText(StatCollector.translateToLocal("ec3.page.newMimInv_2.txt")))
                    .apendPage(
                        next("newMimInv").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mimInvStorage), 2)))
                    .apendPage(
                        next("newMimInv").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.inventoryGem), 2))))
            .apendDiscovery(
                new DiscoveryEntry("newMimCraft").setNew()
                    .setDisplayStack(new ItemStack(ECBlocks.mimCrafter))
                    .setReferal(new ItemStack(ECBlocks.mimCrafter))
                    .apendPage(
                        next("newMimCraft").setText(StatCollector.translateToLocal("ec3.page.newMimCraft_0.txt")))
                    .apendPage(
                        next("newMimCraft").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mimCrafter), 2))))
            .apendDiscovery(
                new DiscoveryEntry("newMimScreen").setNew()
                    .setDisplayStack(new ItemStack(ECBlocks.mimScreen))
                    .setReferal(new ItemStack(ECBlocks.mimScreen))
                    .apendPage(
                        next("newMimScreen").setText(StatCollector.translateToLocal("ec3.page.newMimScreen_0.txt")))
                    .apendPage(
                        next("newMimScreen").setText(StatCollector.translateToLocal("ec3.page.newMimScreen_1.txt")))
                    .apendPage(
                        next("newMimScreen").setText(StatCollector.translateToLocal("ec3.page.newMimScreen_2.txt")))
                    .apendPage(
                        next("newMimScreen")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mimScreen), 2))));
    }

    public static ItemStack generic(int meta) {
        return new ItemStack(ECItems.genericItem, 0, meta);
    }

    public static ItemStack gen(int meta) {
        return new ItemStack(ECItems.genericItem, 0, meta);
    }

    public static void registerEnderCategory() {
        ender.apendDiscovery(
            new DiscoveryEntry("enderstar")

                .setDisplayStack(new ItemStack(ECItems.genericItem, 1, 48))
                .apendPage(next("enderstar").setText(StatCollector.translateToLocal("ec3.page.enderstar_0.txt")))
                .apendPage(next("enderstar").setText(StatCollector.translateToLocal("ec3.page.enderstar_1.txt")))
                .apendPage(next("enderstar").setText(StatCollector.translateToLocal("ec3.page.enderstar_2.txt"))))
            .apendDiscovery(
                new DiscoveryEntry("mithriline")

                    .setDisplayStack(new ItemStack(ECItems.genericItem, 1, 51))
                    .setReferal(
                        new ItemStack(ECItems.genericItem, 1, 51),
                        new ItemStack(ECItems.genericItem, 1, 50),
                        new ItemStack(ECItems.genericItem, 1, 49),
                        new ItemStack(ECItems.genericItem, 1, 48),
                        new ItemStack(ECBlocks.invertedBlock, 1, 0))
                    .apendPage(next("mithriline").setText(StatCollector.translateToLocal("ec3.page.mithriline_0.txt")))
                    .apendPage(
                        next("mithriline").setText(StatCollector.translateToLocal("ec3.page.mithriline_1.txt"))
                            .setDisplayStacks(new ItemStack(ECItems.genericItem, 1, 51)))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 50), 2)))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 49), 6)))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 48), 2)))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.genericItem, 1, 50), 2)))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.invertedBlock, 1, 0), 2))
                            .setText(StatCollector.translateToLocal("ec3.page.mithriline_2.txt")))
                    .apendPage(next("mithriline").setText(StatCollector.translateToLocal("ec3.page.mithriline_3.txt")))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mithrilineCrystal, 1, 0), 2)))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mithrilineCrystal, 1, 3), 2)))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mithrilineCrystal, 1, 6), 2)))
                    .apendPage(
                        next("mithriline")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mithrilineCrystal, 1, 9), 2))))
            .apendDiscovery(
                new DiscoveryEntry("mithrilineFurnace")

                    .setDisplayStack(new ItemStack(ECBlocks.mithrilineFurnace))
                    .setReferal(new ItemStack(ECBlocks.mithrilineFurnace))
                    .apendPage(
                        next("mithrilineFurnace")
                            .setText(StatCollector.translateToLocal("ec3.page.mithrilineFurnace_0.txt")))
                    .apendPage(
                        next("mithrilineFurnace")
                            .setText(StatCollector.translateToLocal("ec3.page.mithrilineFurnace_1.txt")))
                    .apendPage(
                        next("mithrilineFurnace")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.mithrilineFurnace, 1, 0), 2)))
                    .apendPage(
                        next("mithrilineFurnace").setText(StatCollector.translateToLocal("ec3.txt.layer_-1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.mithrilineFurnace),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, -2))))
                    .apendPage(
                        next("mithrilineFurnace").setText(StatCollector.translateToLocal("ec3.txt.layer_0"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.mithrilineFurnace),
                                    new StructureBlock(ECBlocks.mithrilineFurnace, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, -2))))
                    .apendPage(
                        next("mithrilineFurnace").setText(StatCollector.translateToLocal("ec3.txt.layer_1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.mithrilineFurnace),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, -2))))
                    .apendPage(
                        next("mithrilineFurnace").setText(StatCollector.translateToLocal("ec3.txt.layer_2"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.mithrilineFurnace),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, -2)))))
            .apendDiscovery(
                new DiscoveryEntry("windRune")

                    .setDisplayStack(new ItemStack(ECBlocks.windRune))
                    .setReferal(new ItemStack(ECBlocks.windRune))
                    .apendPage(next("windRune").setText(StatCollector.translateToLocal("ec3.page.windRune_0.txt")))
                    .apendPage(
                        next("windRune").setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.windRune, 1, 0), 2)))
                    .apendPage(
                        next("windRune").setText(StatCollector.translateToLocal("ec3.txt.layer_-1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.windRune),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.platingPale, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.platingPale, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.platingPale, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.platingPale, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.platingPale, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.platingPale, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.platingPale, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.platingPale, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.platingPale, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.platingPale, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.platingPale, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.platingPale, 0, -1, 0, -2),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, -2))))
                    .apendPage(
                        next("windRune").setText(StatCollector.translateToLocal("ec3.txt.layer_0"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.windRune),
                                    new StructureBlock(ECBlocks.windRune, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.magicPlating, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.magicPlating, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, -2))))
                    .apendPage(
                        next("windRune").setText(StatCollector.translateToLocal("ec3.txt.layer_1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.windRune),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -1))))
                    .apendPage(
                        next("windRune").setText(StatCollector.translateToLocal("ec3.txt.layer_2"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.windRune),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, -1))))
                    .apendPage(next("windRune").setText(StatCollector.translateToLocal("ec3.page.windRune_1.txt")))
                    .apendPage(next("windRune").setText(StatCollector.translateToLocal("ec3.page.windRune_2.txt")))
                    .apendPage(next("windRune").setText(StatCollector.translateToLocal("ec3.page.windRune_3.txt")))
                    .apendPage(next("windRune").setText(StatCollector.translateToLocal("ec3.page.windRune_4.txt")))
                    .apendPage(
                        next("windRune")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.wind_elemental_axe), 2)))
                    .apendPage(
                        next("windRune")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.wind_elemental_pick), 2)))
                    .apendPage(
                        next("windRune")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.wind_elemental_hoe), 2)))
                    .apendPage(
                        next("windRune")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.wind_elemental_shovel), 2)))
                    .apendPage(
                        next("windRune")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.wind_elemental_sword), 2))))
            .apendDiscovery(
                new DiscoveryEntry("playerPentacle")

                    .setDisplayStack(new ItemStack(ECBlocks.playerPentacle))
                    .setReferal(new ItemStack(ECBlocks.playerPentacle))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.page.playerPentacle_0.txt")))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.page.playerPentacle_1.txt")))
                    .apendPage(
                        next("playerPentacle")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.playerPentacle), 2)))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_-1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -2))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_0"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.playerPentacle, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, -2))))

                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.page.playerPentacle_2.txt")))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_-1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -2))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_0"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.playerPentacle, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, -2),
                                    new StructureBlock(ECBlocks.blockPale, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.blockPale, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.blockPale, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.blockPale, 0, -1, 0, -1))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 1, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -1, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 1, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -1, 0, -1))))

                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.page.playerPentacle_3.txt")))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_-1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -2))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_0"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.playerPentacle, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, -2),
                                    new StructureBlock(ECBlocks.blockPale, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.blockPale, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.blockPale, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.blockPale, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 1, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -1, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 1, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_2"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, 2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, -2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, 2, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, -2, 0, -2))))

                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.page.playerPentacle_4.txt")))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_-1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -1, 0, -2),
                                    new StructureBlock(ECBlocks.demonicPlating, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.demonicPlating, 0, 0, 0, -2),
                                    new StructureBlock(ECBlocks.demonicPlating, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.demonicPlating, 0, -2, 0, 0))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_0"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.playerPentacle, 0, 0, 0, 0),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -1, 0, -2),
                                    new StructureBlock(ECBlocks.blockPale, 0, 1, 0, 1),
                                    new StructureBlock(ECBlocks.blockPale, 0, -1, 0, 1),
                                    new StructureBlock(ECBlocks.blockPale, 0, 1, 0, -1),
                                    new StructureBlock(ECBlocks.blockPale, 0, -1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 1, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -1, 0, 1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 1, 0, -1),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -1, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, -2))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_2"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, 2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, -2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, 2, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, -2, 0, -2))))
                    .apendPage(
                        next("playerPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_3"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.playerPentacle),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 9, 2, 0, 0),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 9, -2, 0, 0),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 9, 0, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 9, 0, 0, -2)))))
            .apendDiscovery(
                new DiscoveryEntry("demonicPentacle")

                    .setDisplayStack(new ItemStack(ECBlocks.demonicPentacle))
                    .apendPage(
                        next("demonicPentacle")
                            .setText(StatCollector.translateToLocal("ec3.page.demonicPentacle_0.txt")))
                    .apendPage(
                        next("demonicPentacle")
                            .setText(StatCollector.translateToLocal("ec3.page.demonicPentacle_1.txt")))
                    .apendPage(
                        next("demonicPentacle")
                            .setText(StatCollector.translateToLocal("ec3.page.demonicPentacle_2.txt")))
                    .apendPage(
                        next("demonicPentacle")
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECBlocks.demonicPentacle), 2)))
                    .apendPage(
                        next("demonicPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_-1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.demonicPentacle),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 0),

                                    new StructureBlock(ECBlocks.voidStone, 0, 2, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, -2, 0, 0),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, 2),
                                    new StructureBlock(ECBlocks.voidStone, 0, 0, 0, -2),

                                    new StructureBlock(ECBlocks.voidStone, 0, 3, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 3, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -3, 0, 1),
                                    new StructureBlock(ECBlocks.voidStone, 0, -3, 0, -1),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, 3),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, 3),
                                    new StructureBlock(ECBlocks.voidStone, 0, 1, 0, -3),
                                    new StructureBlock(ECBlocks.voidStone, 0, -1, 0, -3),

                                    new StructureBlock(ECBlocks.platingPale, 0, 1, 0, 0),
                                    new StructureBlock(ECBlocks.platingPale, 0, -1, 0, 0),
                                    new StructureBlock(ECBlocks.platingPale, 0, 0, 0, 1),
                                    new StructureBlock(ECBlocks.platingPale, 0, 0, 0, -1),

                                    new StructureBlock(ECBlocks.platingPale, 0, 2, 0, 1),
                                    new StructureBlock(ECBlocks.platingPale, 0, 2, 0, -1),
                                    new StructureBlock(ECBlocks.platingPale, 0, -2, 0, 1),
                                    new StructureBlock(ECBlocks.platingPale, 0, -2, 0, -1),
                                    new StructureBlock(ECBlocks.platingPale, 0, 1, 0, 2),
                                    new StructureBlock(ECBlocks.platingPale, 0, -1, 0, 2),
                                    new StructureBlock(ECBlocks.platingPale, 0, 1, 0, -2),
                                    new StructureBlock(ECBlocks.platingPale, 0, -1, 0, -2),

                                    new StructureBlock(ECBlocks.platingPale, 0, 3, 0, 2),
                                    new StructureBlock(ECBlocks.platingPale, 0, 3, 0, -2),
                                    new StructureBlock(ECBlocks.platingPale, 0, -3, 0, 2),
                                    new StructureBlock(ECBlocks.platingPale, 0, -3, 0, -2),
                                    new StructureBlock(ECBlocks.platingPale, 0, 2, 0, 3),
                                    new StructureBlock(ECBlocks.platingPale, 0, -2, 0, 3),
                                    new StructureBlock(ECBlocks.platingPale, 0, 2, 0, -3),
                                    new StructureBlock(ECBlocks.platingPale, 0, -2, 0, -3))))
                    .apendPage(
                        next("demonicPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_0"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.demonicPentacle),
                                    new StructureBlock(ECBlocks.demonicPentacle, 0, 0, 0, 0),

                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.invertedBlock, 0, -2, 0, -2),

                                    new StructureBlock(Blocks.glowstone, 0, 3, 0, 0),
                                    new StructureBlock(Blocks.glowstone, 0, -3, 0, 0),
                                    new StructureBlock(Blocks.glowstone, 0, 0, 0, 3),
                                    new StructureBlock(Blocks.glowstone, 0, 0, 0, -3),

                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 3, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 3, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -3, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -3, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 2, 0, 3),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -2, 0, 3),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, 2, 0, -3),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 3, -2, 0, -3))))
                    .apendPage(
                        next("demonicPentacle").setText(StatCollector.translateToLocal("ec3.txt.layer_1"))
                            .setRecipe(
                                new StructureRecipe(
                                    new ItemStack(ECBlocks.demonicPentacle),

                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, 2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, 2, 0, -2),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 0, -2, 0, -2),

                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, 3, 0, 0),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, -3, 0, 0),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, 0, 0, 3),
                                    new StructureBlock(ECBlocks.mithrilineCrystal, 6, 0, 0, -3))))
                    .apendPage(
                        next("demonicPentacle")
                            .setText(StatCollector.translateToLocal("ec3.page.demonicPentacle_3.txt"))
                            .setRecipe(ECUtils.findRecipeByIS(new ItemStack(ECItems.soulScriber), 2)))

            );
    }

    public static PageEntry next(String genID) {
        if (!stringIDS.containsKey(genID)) stringIDS.put(genID, 0);
        int ptt = stringIDS.get(genID);
        stringIDS.put(genID, ptt + 1);
        return new PageEntry("ec3.page." + genID + "_" + ptt);
    }

    public static void init() {
        stringIDS.clear();
        ApiCore.categories.clear();
        basic.discoveries.clear();
        mru.discoveries.clear();
        eng.discoveries.clear();
        hoanna.discoveries.clear();
        shade.discoveries.clear();
        ender.discoveries.clear();

        registerBasicCategory();
        registerMruCategory();

        registerEngineersCategory();

        registerHoannaCategory();

        registerEnderCategory();

        mru.setDisplayStack(new ItemStack(ECItems.drops, 1, 4));
        eng.setDisplayStack(new ItemStack(ECItems.wFocus, 1, 0));
        hoanna.setDisplayStack(new ItemStack(ECItems.genericItem, 1, 37));
        shade.setDisplayStack(new ItemStack(ECBlocks.lightCorruption[2], 1, 6));
        ender.setDisplayStack(new ItemStack(ECBlocks.mithrilineCrystal, 1, 0));

        ApiCore.categories.add(basic);
        ApiCore.categories.add(mru);
        ApiCore.categories.add(eng);
        ApiCore.categories.add(hoanna);
        ApiCore.categories.add(shade);
        ApiCore.categories.add(ender);
    }

    public static final CategoryEntry basic = new CategoryEntry("ec3.basic")
        .setDisplayStack(new ResourceLocation("essentialcraft", "textures/special/basical_knowledge_icon.png"));
    public static final CategoryEntry mru = new CategoryEntry("ec3.mru").setTier(1);
    public static final CategoryEntry eng = new CategoryEntry("ec3.eng").setTier(2);
    public static final CategoryEntry ender = new CategoryEntry("ec3.ender").setTier(2);
    public static final CategoryEntry hoanna = new CategoryEntry("ec3.hoanna").setTier(3)
        .setSpecificTexture(new ResourceLocation("essentialcraft", "textures/gui/research_book_hoanna.png"))
        .setTextColor(0xcccccc);
    public static final CategoryEntry shade = new CategoryEntry("ec3.shade").setTier(4);

}
