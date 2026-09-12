package ec3.utils.dummycore.creativetabs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.common.init.ECBlocks;

/**
 * @version From DummyCore 1.0
 * @author Modbder
 *         Do not change anything here! Used to work with Blocks.
 */
public final class CreativePageBlocks extends CreativeTabs {

    private final String tabLabel;

    public CreativePageBlocks(String m) {
        super(m + " Blocks");
        tabLabel = m + " Blocks";
    }

    public ItemStack getIconItemStack() {
        return new ItemStack(ECBlocks.magicianTable);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getTranslatedTabLabel() {
        return this.tabLabel;
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ECBlocks.magicianTable);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void displayAllReleventItems(List list)
    {
        list.clear();

        List<ItemStack> manual = new ArrayList<ItemStack>();

        manual.add(new ItemStack(ECBlocks.magicianTable));
        manual.add(new ItemStack(ECBlocks.matrixAbsorber));
        manual.add(new ItemStack(ECBlocks.radiatingChamber));

        manual.add(new ItemStack(ECBlocks.heatGenerator));
        manual.add(new ItemStack(ECBlocks.naturalFurnace));
        manual.add(new ItemStack(ECBlocks.coldDistillator));
        manual.add(new ItemStack(ECBlocks.enderGenerator));
        manual.add(new ItemStack(ECBlocks.sunRayAbsorber));
        manual.add(new ItemStack(ECBlocks.solarPrism));
        manual.add(new ItemStack(ECBlocks.moonWell));
        manual.add(new ItemStack(ECBlocks.reactor));
        manual.add(new ItemStack(ECBlocks.reactorSupport));
        manual.add(new ItemStack(ECBlocks.ultraHeatGen));
        manual.add(new ItemStack(ECBlocks.ultraFlowerBurner));
        manual.add(new ItemStack(ECBlocks.darknessObelisk));

        manual.add(new ItemStack(ECBlocks.mithrilineFurnace));

        manual.add(new ItemStack(ECBlocks.windRune));
        manual.add(new ItemStack(ECBlocks.playerPentacle));
        manual.add(new ItemStack(ECBlocks.demonicPentacle));

        manual.add(new ItemStack(ECBlocks.crystalFormer));
        manual.add(new ItemStack(ECBlocks.crystalController));
        manual.add(new ItemStack(ECBlocks.crystalExtractor));

        manual.add(new ItemStack(ECBlocks.potionSpreader));
        manual.add(new ItemStack(ECBlocks.magicalEnchanter));
        manual.add(new ItemStack(ECBlocks.magicalTeleporter));
        manual.add(new ItemStack(ECBlocks.monsterHarvester));
        manual.add(new ItemStack(ECBlocks.magicalRepairer));
        manual.add(new ItemStack(ECBlocks.chargingChamber));
        manual.add(new ItemStack(ECBlocks.mruCoil));
        manual.add(new ItemStack(ECBlocks.mruCoilHardener));
        manual.add(new ItemStack(ECBlocks.magmaticSmeltery));
        manual.add(new ItemStack(ECBlocks.magicalFurnace));

        ECBlocks.furnaceMagic.getSubBlocks(Item.getItemFromBlock(ECBlocks.furnaceMagic), this, manual);

        manual.add(new ItemStack(ECBlocks.magicalJukebox));

        manual.add(new ItemStack(ECBlocks.emberForge));
        manual.add(new ItemStack(ECBlocks.magicalQuarry));
        manual.add(new ItemStack(ECBlocks.monsterClinger));
        manual.add(new ItemStack(ECBlocks.corruptionCleaner));
        manual.add(new ItemStack(ECBlocks.assembler));
        manual.add(new ItemStack(ECBlocks.holopad));
        manual.add(new ItemStack(ECBlocks.magicalMirror));
        manual.add(new ItemStack(ECBlocks.magicalDisplay));

        manual.add(new ItemStack(ECBlocks.ecController));
        manual.add(new ItemStack(ECBlocks.ecAcceptor));
        manual.add(new ItemStack(ECBlocks.ecBalancer));
        manual.add(new ItemStack(ECBlocks.ecEjector));
        manual.add(new ItemStack(ECBlocks.ecHoldingChamber));
        manual.add(new ItemStack(ECBlocks.ecStateChecker));
        manual.add(new ItemStack(ECBlocks.ecRedstoneController));

        manual.add(new ItemStack(ECBlocks.rayTower));
        manual.add(new ItemStack(ECBlocks.redstoneTransmitter));

        ECBlocks.rightClicker.getSubBlocks(Item.getItemFromBlock(ECBlocks.rightClicker), this, manual);

        manual.add(new ItemStack(ECBlocks.magicalHopper));
        manual.add(new ItemStack(ECBlocks.metadataManager));
        manual.add(new ItemStack(ECBlocks.weaponMaker));
        manual.add(new ItemStack(ECBlocks.blockBreaker));
        manual.add(new ItemStack(ECBlocks.advBreaker));

        ECBlocks.device.getSubBlocks(Item.getItemFromBlock(ECBlocks.device), this, manual);

        ECBlocks.chest.getSubBlocks(Item.getItemFromBlock(ECBlocks.chest), this, manual);

        manual.add(new ItemStack(ECBlocks.newMim));
        manual.add(new ItemStack(ECBlocks.mimInvStorage));
        manual.add(new ItemStack(ECBlocks.mimScreen));
        manual.add(new ItemStack(ECBlocks.mimCrafter));
        manual.add(new ItemStack(ECBlocks.mimEjector));
        manual.add(new ItemStack(ECBlocks.mimEjectorP));
        manual.add(new ItemStack(ECBlocks.mimInjector));
        manual.add(new ItemStack(ECBlocks.mimInjectorP));

        manual.add(new ItemStack(ECBlocks.magicPlating));
        manual.add(new ItemStack(ECBlocks.platingPale));
        manual.add(new ItemStack(ECBlocks.demonicPlating));
        manual.add(new ItemStack(ECBlocks.invertedBlock));
        manual.add(new ItemStack(ECBlocks.fortifiedGlass));
        manual.add(new ItemStack(ECBlocks.fortifiedStone));
        manual.add(new ItemStack(ECBlocks.voidGlass));
        manual.add(new ItemStack(ECBlocks.voidStone));

        for (int i = 0; i < ECBlocks.fence.length; i++) {
            manual.add(new ItemStack(ECBlocks.fence[i]));
        }
        manual.add(new ItemStack(ECBlocks.coldStone));
        manual.add(new ItemStack(ECBlocks.blockPale));

        ECBlocks.mithrilineCrystal.getSubBlocks(Item.getItemFromBlock(ECBlocks.mithrilineCrystal), this, manual);

        ECBlocks.oreDrops.getSubBlocks(Item.getItemFromBlock(ECBlocks.oreDrops), this, manual);
        ECBlocks.compressed.getSubBlocks(Item.getItemFromBlock(ECBlocks.compressed), this, manual);
        ECBlocks.drops.getSubBlocks(Item.getItemFromBlock(ECBlocks.drops), this, manual);

        for (int i = 0; i < ECBlocks.lightCorruption.length; i++) {
            ECBlocks.lightCorruption[i].getSubBlocks(Item.getItemFromBlock(ECBlocks.lightCorruption[i]), this, manual);
        }

        manual.add(new ItemStack(ECBlocks.elementalCrystal));

        manual.add(new ItemStack(ECBlocks.portal));
        manual.add(new ItemStack(ECBlocks.concrete));
        manual.add(new ItemStack(ECBlocks.cacti));
        manual.add(new ItemStack(ECBlocks.dreadDirt));
        manual.add(new ItemStack(ECBlocks.flowerGreen));
        manual.add(new ItemStack(ECBlocks.fruit));
        manual.add(new ItemStack(ECBlocks.root));
        manual.add(new ItemStack(ECBlocks.tallGrass));
        manual.add(new ItemStack(ECBlocks.levitator));
        manual.add(new ItemStack(ECBlocks.spreader));
        manual.add(new ItemStack(ECBlocks.air));
        manual.add(new ItemStack(ECBlocks.torch));

        for (int i = 0; i < ECBlocks.fancyBlocks.size(); i++) {
            ECBlocks.fancyBlocks.get(i).getSubBlocks(Item.getItemFromBlock(ECBlocks.fancyBlocks.get(i)), this, manual);

        }

        list.addAll(manual);

        List<ItemStack> defaultList = new ArrayList<ItemStack>();
        super.displayAllReleventItems(defaultList);

        for (ItemStack stack : defaultList)
        {
            boolean alreadyAdded = false;

            for (ItemStack manualStack : manual)
            {
                if (stack.getItem() == manualStack.getItem()
                    && stack.getItemDamage() == manualStack.getItemDamage())
                {
                    alreadyAdded = true;
                    break;
                }
            }

            if (!alreadyAdded)
            {
                list.add(stack);
            }
        }
    }

}
