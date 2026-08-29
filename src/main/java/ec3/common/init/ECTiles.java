package ec3.common.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.registry.GameRegistry;
import ec3.common.tile.logistics.TileAMINEjector;
import ec3.common.tile.logistics.TileAMINInjector;
import ec3.common.tile.redstone.TileAdvancedBlockBreaker;
import ec3.common.tile.redstone.TileAnimalSeparator;
import ec3.common.tile.consumers.TileChargingChamber;
import ec3.common.tile.producers.TileColdDistillator;
import ec3.common.tile.world.TileCorruption;
import ec3.common.tile.consumers.TileCorruptionCleaner;
import ec3.common.tile.consumers.TileCrafter;
import ec3.common.tile.producers.TileCreativeMRUSource;
import ec3.common.tile.consumers.TileCrystalController;
import ec3.common.tile.consumers.TileCrystalExtractor;
import ec3.common.tile.crafting.TileCrystalFormer;
import ec3.common.tile.producers.TileDarknessObelisk;
import ec3.common.tile.crafting.TileDemonicPentacle;
import ec3.common.tile.world.TileElementalCrystal;
import ec3.common.tile.crafting.TileEmberForge;
import ec3.common.tile.producers.TileEnderGenerator;
import ec3.common.tile.producers.TileFlowerBurner;
import ec3.common.tile.consumers.TileFurnaceMagic;
import ec3.common.tile.producers.TileHeatGenerator;
import ec3.common.tile.logistics.TileMIM;
import ec3.common.tile.logistics.TileMINEjector;
import ec3.common.tile.logistics.TileMINInjector;
import ec3.common.tile.consumers.TileMRUCoil;
import ec3.common.tile.consumers.TileMRUCoilHardener;
import ec3.common.tile.producers.TileMRUReactor;
import ec3.common.tile.consumers.TileMagicalAssembler;
import ec3.common.tile.storage.TileMagicalChest;
import ec3.common.tile.logistics.TileMagicalDisplay;
import ec3.common.tile.consumers.TileMagicalEnchanter;
import ec3.common.tile.consumers.TileMagicalFurnace;
import ec3.common.tile.redstone.TileMagicalHopper;
import ec3.common.tile.consumers.TileMagicalJukebox;
import ec3.common.tile.transport.TileMagicalMirror;
import ec3.common.tile.consumers.TileMagicalQuarry;
import ec3.common.tile.consumers.TileMagicalRepairer;
import ec3.common.tile.consumers.TileMagicalTeleporter;
import ec3.common.tile.crafting.TileMagicianTable;
import ec3.common.tile.consumers.TileMagmaticSmelter;
import ec3.common.tile.producers.TileMatrixAbsorber;
import ec3.common.tile.consumers.TileMithrilineCrystal;
import ec3.common.tile.crafting.TileMithrilineFurnace;
import ec3.common.tile.consumers.TileMonsterHarvester;
import ec3.common.tile.consumers.TileMonsterHolder;
import ec3.common.tile.producers.TileMoonWell;
import ec3.common.tile.logistics.TileNewMIM;
import ec3.common.tile.logistics.TileNewMIMCraftingManager;
import ec3.common.tile.logistics.TileNewMIMExportNode;
import ec3.common.tile.logistics.TileNewMIMExportNode_Persistant;
import ec3.common.tile.logistics.TileNewMIMImportNode;
import ec3.common.tile.logistics.TileNewMIMImportNode_Persistant;
import ec3.common.tile.logistics.TileNewMIMInventoryStorage;
import ec3.common.tile.logistics.TileNewMIMScreen;
import ec3.common.tile.consumers.TilePlayerPentacle;
import ec3.common.tile.consumers.TilePotionSpreader;
import ec3.common.tile.crafting.TileRadiatingChamber;
import ec3.common.tile.transport.TileRayTower;
import ec3.common.tile.redstone.TileRedstoneTransmitter;
import ec3.common.tile.consumers.TileRightClicker;
import ec3.common.tile.producers.TileSolarPrism;
import ec3.common.tile.producers.TileSunRayAbsorber;
import ec3.common.tile.producers.TileUltraFlowerBurner;
import ec3.common.tile.producers.TileUltraHeatGenerator;
import ec3.common.tile.crafting.TileWeaponMaker;
import ec3.common.tile.crafting.TileWindRune;
import ec3.common.tile.storage.TileChamberAcceptor;
import ec3.common.tile.storage.TileChamberBalancer;
import ec3.common.tile.storage.TileChamberController;
import ec3.common.tile.storage.TileChamberEjector;
import ec3.common.tile.consumers.TileHoldingChamber;
import ec3.common.tile.storage.TileChamberRedstoneController;
import ec3.common.tile.storage.TileChamberStateChecker;
import ec3.api.config.Config;

public class ECTiles {

    public static final List<Class<? extends TileEntity>> cfgDependant = new ArrayList<Class<? extends TileEntity>>();

    public static void register() {
        addTileToMapping(TileChamberController.class);
        addTileToMapping(TileChamberAcceptor.class);
        addTileToMapping(TileChamberBalancer.class);
        addTileToMapping(TileChamberEjector.class);
        addTileToMapping(TileHoldingChamber.class);
        addTileToMapping(TileChamberRedstoneController.class);
        addTileToMapping(TileChamberStateChecker.class);
        addTileToMapping(TileRayTower.class);
        addTileToMapping(TileCorruption.class);
        addTileToMapping(TileMoonWell.class);
        addTileToMapping(TileSolarPrism.class);
        addTileToMapping(TileSunRayAbsorber.class);
        addTileToMapping(TileColdDistillator.class);
        addTileToMapping(TileFlowerBurner.class);
        addTileToMapping(TileHeatGenerator.class);
        addTileToMapping(TileEnderGenerator.class);
        addTileToMapping(TileMagicianTable.class);
        addTileToMapping(TileMagicalQuarry.class);
        addTileToMapping(TileMonsterHolder.class);
        addTileToMapping(TilePotionSpreader.class);
        addTileToMapping(TileMagicalEnchanter.class);
        addTileToMapping(TileMonsterHarvester.class);
        addTileToMapping(TileMagicalRepairer.class);
        addTileToMapping(TileMatrixAbsorber.class);
        addTileToMapping(TileRadiatingChamber.class);
        addTileToMapping(TileMagmaticSmelter.class);
        addTileToMapping(TileMagicalJukebox.class);
        addTileToMapping(TileElementalCrystal.class);
        addTileToMapping(TileCrystalFormer.class);
        addTileToMapping(TileCrystalController.class);
        addTileToMapping(TileCrystalExtractor.class);
        addTileToMapping(TileChargingChamber.class);
        addTileToMapping(TileMagicalTeleporter.class);
        addTileToMapping(TileMagicalFurnace.class);
        addTileToMapping(TileEmberForge.class);
        addTileToMapping(TileMRUCoilHardener.class);
        addTileToMapping(TileMRUCoil.class);
        addTileToMapping(TileCorruptionCleaner.class);
        addTileToMapping(TileMRUReactor.class);
        addTileToMapping(TileMINEjector.class);
        addTileToMapping(TileAMINEjector.class);
        addTileToMapping(TileMINInjector.class);
        addTileToMapping(TileAMINInjector.class);
        addTileToMapping(TileMIM.class);
        addTileToMapping(TileDarknessObelisk.class);
        addTileToMapping(TileUltraHeatGenerator.class);
        addTileToMapping(TileUltraFlowerBurner.class);
        addTileToMapping(TileMagicalAssembler.class);
        addTileToMapping(TileMagicalMirror.class);
        addTileToMapping(TileMagicalDisplay.class);
        addTileToMapping(TileMithrilineCrystal.class);
        addTileToMapping(TileMithrilineFurnace.class);
        addTileToMapping(TilePlayerPentacle.class);
        addTileToMapping(TileWindRune.class);
        addTileToMapping(TileRightClicker.class);
        addTileToMapping(TileRedstoneTransmitter.class);
        addTileToMapping(TileMagicalHopper.class);
        addTileToMapping(TileDemonicPentacle.class);
        addTileToMapping(TileWeaponMaker.class);
        addTileToMapping(TileFurnaceMagic.class);
        addTileToMapping(TileMagicalChest.class);
        addTileToMapping(TileNewMIMInventoryStorage.class);
        addTileToMapping(TileNewMIM.class);
        addTileToMapping(TileNewMIMScreen.class);
        addTileToMapping(TileNewMIMCraftingManager.class);
        addTileToMapping(TileNewMIMExportNode.class);
        addTileToMapping(TileNewMIMImportNode.class);
        addTileToMapping(TileAdvancedBlockBreaker.class);
        addTileToMapping(TileNewMIMExportNode_Persistant.class);
        addTileToMapping(TileNewMIMImportNode_Persistant.class);
        addTileToMapping(TileCrafter.class);
        addTileToMapping(TileCreativeMRUSource.class);
        addTileToMapping(TileAnimalSeparator.class);
    }

    public static void addTileToMapping(Class<? extends TileEntity> tile) {
        GameRegistry.registerTileEntity(tile, "ec3:" + tile.getCanonicalName());
        try {
            if (tile.getMethod("setupConfig", Configuration.class) != null) {
                cfgDependant.add(tile);
                tile.getMethod("setupConfig", Configuration.class)
                    .invoke(null, Config.config);
            }
        } catch (Exception e) {
            return;
        }

    }

}
