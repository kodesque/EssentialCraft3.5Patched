package ec3.common.init;

import static ec3.utils.ECUtils.allowedBlocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.ChestGenHooks;

import ec3.api.structures.EnumStructureType;
import ec3.common.items.BaublesAccessory;
import ec3.common.world.structures.MapGenTown;
import ec3.common.world.structures.StructureModernShaftPieces;
import ec3.common.world.structures.StructureModernShaftStart;
import ec3.common.world.structures.StructureTownPieces;
import ec3.utils.ECUtils;

public class ECStructures {

    public static void register() {
        for (int i = 0; i < BaublesAccessory.names.length; ++i) {
            ChestGenHooks.addItem(
                ChestGenHooks.DUNGEON_CHEST,
                new WeightedRandomChestContent(new ItemStack(ECItems.baublesCore, 1, i), 1, 1, 3));
        }
        MapGenStructureIO.registerStructure(MapGenTown.Start.class, "ec3.Town");
        MapGenStructureIO.registerStructure(StructureModernShaftStart.class, "ec3.ModernShafts");
        StructureTownPieces.registerVillagePieces();
        StructureModernShaftPieces.registerStructurePieces();
        List<Block> structureBlocks_mrucucc = new ArrayList<Block>();
        structureBlocks_mrucucc.add(ECBlocks.fortifiedGlass);
        structureBlocks_mrucucc.add(ECBlocks.magicPlating);
        structureBlocks_mrucucc.add(ECBlocks.ecController);
        structureBlocks_mrucucc.add(ECBlocks.ecAcceptor);
        structureBlocks_mrucucc.add(ECBlocks.ecBalancer);
        structureBlocks_mrucucc.add(ECBlocks.ecEjector);
        structureBlocks_mrucucc.add(ECBlocks.ecHoldingChamber);
        structureBlocks_mrucucc.add(ECBlocks.ecRedstoneController);
        structureBlocks_mrucucc.add(ECBlocks.ecStateChecker);
        structureBlocks_mrucucc.add(ECBlocks.fortifiedStone);
        structureBlocks_mrucucc.add(ECBlocks.voidGlass);
        structureBlocks_mrucucc.add(ECBlocks.voidStone);
        structureBlocks_mrucucc.add(ECBlocks.platingPale);
        structureBlocks_mrucucc.add(ECBlocks.invertedBlock);
        structureBlocks_mrucucc.add(ECBlocks.demonicPlating);
        structureBlocks_mrucucc.add(ECBlocks.fancyBlocks.get(0));
        structureBlocks_mrucucc.add(ECBlocks.fancyBlocks.get(2));
        structureBlocks_mrucucc.add(ECBlocks.fancyBlocks.get(4));
        structureBlocks_mrucucc.add(ECBlocks.fancyBlocks.get(5));
        structureBlocks_mrucucc.add(ECBlocks.fancyBlocks.get(6));
        structureBlocks_mrucucc.add(ECBlocks.fancyBlocks.get(7));
        allowedBlocks.put(EnumStructureType.MRUCUContaigementChamber, structureBlocks_mrucucc);

        List<Block> structureBlocks_mrucoil = new ArrayList<Block>();
        structureBlocks_mrucoil.add(ECBlocks.platingPale);
        structureBlocks_mrucoil.add(ECBlocks.magicPlating);
        structureBlocks_mrucoil.add(ECBlocks.voidStone);
        structureBlocks_mrucoil.add(ECBlocks.invertedBlock);
        structureBlocks_mrucoil.add(ECBlocks.demonicPlating);
        structureBlocks_mrucoil.add(ECBlocks.fancyBlocks.get(4));
        structureBlocks_mrucoil.add(ECBlocks.fancyBlocks.get(5));
        structureBlocks_mrucoil.add(ECBlocks.fancyBlocks.get(6));
        structureBlocks_mrucoil.add(ECBlocks.fancyBlocks.get(7));

        allowedBlocks.put(EnumStructureType.MRUCoil, structureBlocks_mrucoil);

        ECUtils.registerBlockResistance(ECBlocks.fortifiedGlass, 0, 3F);
        ECUtils.registerBlockResistance(ECBlocks.fancyBlocks.get(0), -1, 8F);
        ECUtils.registerBlockResistance(ECBlocks.fancyBlocks.get(2), -1, 3F);
        ECUtils.registerBlockResistance(ECBlocks.fancyBlocks.get(4), -1, 5F);
        ECUtils.registerBlockResistance(ECBlocks.fancyBlocks.get(5), -1, 10F);
        ECUtils.registerBlockResistance(ECBlocks.fancyBlocks.get(6), -1, 18F);
        ECUtils.registerBlockResistance(ECBlocks.fancyBlocks.get(7), -1, 36F);

        ECUtils.registerBlockResistance(ECBlocks.magicPlating, 0, 5F);
        ECUtils.registerBlockResistance(ECBlocks.platingPale, 0, 10F);
        ECUtils.registerBlockResistance(ECBlocks.invertedBlock, 0, 7F);
        ECUtils.registerBlockResistance(ECBlocks.ecController, 0, 100F);
        ECUtils.registerBlockResistance(ECBlocks.ecAcceptor, 0, 100F);
        ECUtils.registerBlockResistance(ECBlocks.ecBalancer, 0, 100F);
        ECUtils.registerBlockResistance(ECBlocks.ecEjector, 0, 100F);
        ECUtils.registerBlockResistance(ECBlocks.ecHoldingChamber, 0, 100F);
        ECUtils.registerBlockResistance(ECBlocks.ecRedstoneController, 0, 100F);
        ECUtils.registerBlockResistance(ECBlocks.ecStateChecker, 0, 100F);
        ECUtils.registerBlockResistance(ECBlocks.fortifiedStone, -1, 2F);
        ECUtils.registerBlockResistance(ECBlocks.voidGlass, -1, 15F);
        ECUtils.registerBlockResistance(ECBlocks.voidStone, -1, 18F);
        ECUtils.registerBlockResistance(ECBlocks.demonicPlating, -1, 36F);
    }

}
