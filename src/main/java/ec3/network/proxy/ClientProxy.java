package ec3.network.proxy;

import java.util.ArrayList;
import java.util.List;

import ec3.client.render.entities.*;
import ec3.client.render.handlers.ClientRenderHandler;
import ec3.client.render.handlers.RenderHandlerEC;
import ec3.client.render.items.GunItemRenderHelper;
import ec3.client.render.items.RenderElementalCrystalAsItem;
import ec3.client.render.items.RenderOrbitalRemote;
import ec3.client.render.items.RenderSolarPrismAsItem;
import ec3.client.render.tiles.*;
import ec3.client.render.world.RenderCloudsHoanna;
import ec3.client.render.world.RenderSkyHoanna;
import ec3.utils.dummycore.network.handlers.DummyPacketHandler;
import ec3.utils.dummycore.network.packets.DummyPacket;
import ec3.utils.dummycore.utils.data.DummyData;
import ec3.utils.dummycore.utils.math.MathUtils;
import ec3.utils.dummycore.utils.math.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.client.gui.logistics.GuiAMINEjector;
import ec3.client.gui.logistics.GuiAMINInjector;
import ec3.client.gui.consumers.GuiChargingChamber;
import ec3.client.gui.producers.GuiColdDistillator;
import ec3.client.gui.consumers.GuiCorruptionCleaner;
import ec3.client.gui.consumers.GuiCrafter;
import ec3.client.gui.items.GuiCraftingFrame;
import ec3.client.gui.consumers.GuiCrystalController;
import ec3.client.gui.consumers.GuiCrystalExtractor;
import ec3.client.gui.crafting.GuiCrystalFormer;
import ec3.client.gui.producers.GuiDarknessObelisk;
import ec3.client.gui.crafting.GuiDemon;
import ec3.client.gui.producers.GuiEnderGenerator;
import ec3.client.gui.items.GuiFilter;
import ec3.client.gui.producers.GuiFlowerBurner;
import ec3.client.gui.consumers.GuiFurnaceMagic;
import ec3.client.gui.producers.GuiHeatGenerator;
import ec3.client.gui.logistics.GuiMIM;
import ec3.client.gui.logistics.GuiMIMCraftingManager;
import ec3.client.gui.logistics.GuiMIMInventoryStorage;
import ec3.client.gui.logistics.GuiMINEjector;
import ec3.client.gui.logistics.GuiMINInjector;
import ec3.client.gui.storage.GuiMRUAcceptor;
import ec3.client.gui.consumers.GuiMRUCoil;
import ec3.client.gui.storage.GuiMRUInfo;
import ec3.client.gui.consumers.GuiMagicalAssembler;
import ec3.client.gui.storage.GuiMagicalChest;
import ec3.client.gui.consumers.GuiMagicalEnchanter;
import ec3.client.gui.consumers.GuiMagicalFurnace;
import ec3.client.gui.consumers.GuiMagicalJukebox;
import ec3.client.gui.consumers.GuiMagicalQuarry;
import ec3.client.gui.consumers.GuiMagicalRepairer;
import ec3.client.gui.consumers.GuiMagicalTeleporter;
import ec3.client.gui.crafting.GuiMagicianTable;
import ec3.client.gui.consumers.GuiMagmaticSmeltery;
import ec3.client.gui.producers.GuiMatrixAbsorber;
import ec3.client.gui.crafting.GuiMithrilineFurnace;
import ec3.client.gui.consumers.GuiMonsterHarvester;
import ec3.client.gui.consumers.GuiMonsterHolder;
import ec3.client.gui.producers.GuiMoonWell;
import ec3.client.gui.logistics.GuiNewMIM;
import ec3.client.gui.logistics.GuiNewMIMScreen;
import ec3.client.gui.consumers.GuiPlayerPentacle;
import ec3.client.gui.consumers.GuiPotionSpreader;
import ec3.client.gui.storage.GuiRadiatingChamber;
import ec3.client.gui.transport.GuiRayTower;
import ec3.client.gui.items.GuiResearchBook;
import ec3.client.gui.redstone.GuiRightClicker;
import ec3.client.gui.producers.GuiSunRayAbsorber;
import ec3.client.gui.producers.GuiUltraFlowerBurner;
import ec3.client.gui.producers.GuiUltraHeatGenerator;
import ec3.client.gui.crafting.GuiWeaponBench;
import ec3.client.models.ModelArmorEC;
import ec3.client.FX.FXSpell;
import ec3.client.FX.FXColoredFlame;
import ec3.client.FX.FXFog;
import ec3.client.FX.FXItem;
import ec3.client.FX.FXMRU;
import ec3.client.FX.FXArrow;
import ec3.client.render.*;
import ec3.common.init.ECBlocks;
import ec3.common.entities.EntityArmorDestroyer;
import ec3.common.entities.EntityDemon;
import ec3.common.entities.EntityDivider;
import ec3.common.entities.EntityDividerProjectile;
import ec3.common.entities.EntityHologram;
import ec3.common.entities.EntityMRUArrow;
import ec3.common.entities.EntityMRUPresence;
import ec3.common.entities.EntityMRURay;
import ec3.common.entities.EntityOrbitalStrike;
import ec3.common.entities.EntityPlayerClone;
import ec3.common.entities.EntityPoisonFume;
import ec3.common.entities.EntityShadowKnife;
import ec3.common.entities.EntitySolarBeam;
import ec3.common.entities.EntityWindMage;
import ec3.common.inventory.ContainerAMINEjector;
import ec3.common.inventory.ContainerAMINInjector;
import ec3.common.inventory.ContainerChargingChamber;
import ec3.common.inventory.ContainerColdDistillator;
import ec3.common.inventory.ContainerCorruptionCleaner;
import ec3.common.inventory.ContainerCrafter;
import ec3.common.inventory.ContainerCraftingFrame;
import ec3.common.inventory.ContainerCrystalController;
import ec3.common.inventory.ContainerCrystalExtractor;
import ec3.common.inventory.ContainerCrystalFormer;
import ec3.common.inventory.ContainerDarknessObelisk;
import ec3.common.inventory.ContainerDemon;
import ec3.common.inventory.ContainerEnderGenerator;
import ec3.common.inventory.ContainerFilter;
import ec3.common.inventory.ContainerFlowerBurner;
import ec3.common.inventory.ContainerFurnaceMagic;
import ec3.common.inventory.ContainerHeatGenerator;
import ec3.common.inventory.ContainerMIM;
import ec3.common.inventory.ContainerMINEjector;
import ec3.common.inventory.ContainerMINInjector;
import ec3.common.inventory.ContainerMRUAcceptor;
import ec3.common.inventory.ContainerMRUCoil;
import ec3.common.inventory.ContainerMRUInfo;
import ec3.common.inventory.ContainerMagicalAssembler;
import ec3.common.inventory.ContainerMagicalEnchanter;
import ec3.common.inventory.ContainerMagicalFurnace;
import ec3.common.inventory.ContainerMagicalHopper;
import ec3.common.inventory.ContainerMagicalJukebox;
import ec3.common.inventory.ContainerMagicalQuarry;
import ec3.common.inventory.ContainerMagicalRepairer;
import ec3.common.inventory.ContainerMagicalTeleporter;
import ec3.common.inventory.ContainerMagicianTable;
import ec3.common.inventory.ContainerMagmaticSmeltery;
import ec3.common.inventory.ContainerMatrixAbsorber;
import ec3.common.inventory.ContainerMithrilineFurnace;
import ec3.common.inventory.ContainerMonsterHarvester;
import ec3.common.inventory.ContainerMonsterHolder;
import ec3.common.inventory.ContainerMoonWell;
import ec3.common.inventory.ContainerNewMIM;
import ec3.common.inventory.ContainerNewMIMSimpleNode;
import ec3.common.inventory.ContainerPotionSpreader;
import ec3.common.inventory.ContainerRadiatingChamber;
import ec3.common.inventory.ContainerRayTower;
import ec3.common.inventory.ContainerRedstoneTransmitter;
import ec3.common.inventory.ContainerRightClicker;
import ec3.common.inventory.ContainerSunRayAbsorber;
import ec3.common.inventory.ContainerUltraFlowerBurner;
import ec3.common.inventory.ContainerUltraHeatGenerator;
import ec3.common.inventory.ContainerWeaponBench;
import ec3.common.inventory.InventoryCraftingFrame;
import ec3.common.inventory.InventoryMagicFilter;
import ec3.common.items.ItemSecret;
import ec3.common.init.ECItems;
import ec3.common.tile.logistics.TileAMINEjector;
import ec3.common.tile.logistics.TileAMINInjector;
import ec3.common.tile.redstone.TileAdvancedBlockBreaker;
import ec3.common.tile.redstone.TileAnimalSeparator;
import ec3.common.tile.consumers.TileChargingChamber;
import ec3.common.tile.producers.TileColdDistillator;
import ec3.common.tile.consumers.TileCorruptionCleaner;
import ec3.common.tile.consumers.TileCrafter;
import ec3.common.tile.consumers.TileCrystalController;
import ec3.common.tile.consumers.TileCrystalExtractor;
import ec3.common.tile.crafting.TileCrystalFormer;
import ec3.common.tile.producers.TileDarknessObelisk;
import ec3.common.tile.crafting.TileDemonicPentacle;
import ec3.common.tile.world.TileElementalCrystal;
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
import ec3.common.tile.logistics.TileNewMIMImportNode;
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
import ec3.common.tile.storage.TileChamberStateChecker;
import ec3.utils.dummycore.client.GuiCommon;
import ec3.api.config.Config;

public class ClientProxy extends CommonProxy {

    public static final List<Pair<String, ISound>> playingMusic = new ArrayList<Pair<String, ISound>>();

    public boolean listHasKey(String key) {
        for (int i = 0; i < playingMusic.size(); ++i) {
            if (playingMusic.get(i)
                .getFirst()
                .equals(key)) return true;
        }

        return false;
    }

    public int positionOf(String key) {
        for (int i = 0; i < playingMusic.size(); ++i) {
            if (playingMusic.get(i)
                .getFirst()
                .equals(key)) return i;
        }

        return 0;
    }

    @Override
    public void stopSound(String soundID) {
        if (listHasKey(soundID)) {
            Minecraft.getMinecraft()
                .getSoundHandler()
                .stopSound(
                    playingMusic.get(positionOf(soundID))
                        .getSecond());
            playingMusic.remove(soundID);
        }
    }

    @Override
    public void startSound(String soundID, String soundName) {

        if (!listHasKey(soundID)) {
            PositionedSoundRecord s = PositionedSoundRecord.func_147673_a(new ResourceLocation(soundName));
            playingMusic.add(new Pair<String, ISound>(soundID, s));
            Minecraft.getMinecraft()
                .getSoundHandler()
                .stopSounds();
            Minecraft.getMinecraft()
                .getSoundHandler()
                .playSound(s);
        }
    }

    ResourceLocation villagerSkin = new ResourceLocation("essentialcraft", "textures/entities/magician.png");

    @SuppressWarnings("unchecked")
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == Config.guiID[0]) {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile == null) {
                // Item:filter
                if (x == 0 && y == -1 && z == 0) {
                    InventoryMagicFilter inventory = new InventoryMagicFilter(player.getCurrentEquippedItem());
                    return new GuiFilter(new ContainerFilter(player, inventory), inventory);
                }
                // Item: Crafting Frame
                if (x == 0 && y == -2 && z == 0) {
                    InventoryCraftingFrame inventory = new InventoryCraftingFrame(player.getCurrentEquippedItem());
                    return new GuiCraftingFrame(new ContainerCraftingFrame(player, inventory), inventory);
                }
            }
            if (tile instanceof TileRayTower) {
                return new GuiRayTower(new ContainerRayTower(player.inventory, tile), tile);
            }
            if (tile instanceof TileChamberAcceptor) {
                return new GuiMRUAcceptor(new ContainerMRUAcceptor(player.inventory, tile), tile);
            }
            if (tile instanceof TileChamberStateChecker) {
                return new GuiMRUInfo(new ContainerMRUInfo(player.inventory, tile), tile);
            }
            if (tile instanceof TileMoonWell) {
                return new GuiMoonWell(new ContainerMoonWell(player.inventory, tile), tile);
            }
            if (tile instanceof TileSunRayAbsorber) {
                return new GuiSunRayAbsorber(new ContainerSunRayAbsorber(player.inventory, tile), tile);
            }
            if (tile instanceof TileColdDistillator) {
                return new GuiColdDistillator(new ContainerColdDistillator(player.inventory, tile), tile);
            }
            if (tile instanceof TileFlowerBurner) {
                return new GuiFlowerBurner(new ContainerFlowerBurner(player.inventory, tile), tile);
            }
            if (tile instanceof TileHeatGenerator) {
                return new GuiHeatGenerator(new ContainerHeatGenerator(player.inventory, tile), tile);
            }
            if (tile instanceof TileEnderGenerator) {
                return new GuiEnderGenerator(new ContainerEnderGenerator(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicianTable) {
                return new GuiMagicianTable(new ContainerMagicianTable(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicalQuarry) {
                return new GuiMagicalQuarry(new ContainerMagicalQuarry(player.inventory, tile), tile);
            }
            if (tile instanceof TileMonsterHolder) {
                return new GuiMonsterHolder(new ContainerMonsterHolder(player.inventory, tile), tile);
            }
            if (tile instanceof TilePotionSpreader) {
                return new GuiPotionSpreader(new ContainerPotionSpreader(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicalEnchanter) {
                return new GuiMagicalEnchanter(new ContainerMagicalEnchanter(player.inventory, tile), tile);
            }
            if (tile instanceof TileMonsterHarvester) {
                return new GuiMonsterHarvester(new ContainerMonsterHarvester(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicalRepairer) {
                return new GuiMagicalRepairer(new ContainerMagicalRepairer(player.inventory, tile), tile);
            }
            if (tile instanceof TileMatrixAbsorber) {
                return new GuiMatrixAbsorber(new ContainerMatrixAbsorber(player.inventory, tile), tile);
            }
            if (tile instanceof TileRadiatingChamber) {
                return new GuiRadiatingChamber(new ContainerRadiatingChamber(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagmaticSmelter) {
                return new GuiMagmaticSmeltery(new ContainerMagmaticSmeltery(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicalJukebox) {
                return new GuiMagicalJukebox(new ContainerMagicalJukebox(player.inventory, tile), tile);
            }
            if (tile instanceof TileCrystalFormer) {
                return new GuiCrystalFormer(new ContainerCrystalFormer(player.inventory, tile), tile);
            }
            if (tile instanceof TileCrystalController) {
                return new GuiCrystalController(new ContainerCrystalController(player.inventory, tile), tile);
            }
            if (tile instanceof TileCrystalExtractor) {
                return new GuiCrystalExtractor(new ContainerCrystalExtractor(player.inventory, tile), tile);
            }
            if (tile instanceof TileChargingChamber) {
                return new GuiChargingChamber(new ContainerChargingChamber(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicalTeleporter) {
                return new GuiMagicalTeleporter(new ContainerMagicalTeleporter(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicalFurnace) {
                return new GuiMagicalFurnace(new ContainerMagicalFurnace(player.inventory, tile), tile);
            }
            if (tile instanceof TileMRUCoil) {
                return new GuiMRUCoil(new ContainerMRUCoil(player.inventory, tile), tile);
            }
            if (tile instanceof TileCorruptionCleaner) {
                return new GuiCorruptionCleaner(new ContainerCorruptionCleaner(player.inventory, tile), tile);
            }
            if (tile instanceof TileAMINEjector) {
                return new GuiAMINEjector(new ContainerAMINEjector(player.inventory, tile), tile);
            }
            if (tile instanceof TileMINEjector) {
                return new GuiMINEjector(new ContainerMINEjector(player.inventory, tile), tile);
            }
            if (tile instanceof TileAMINInjector) {
                return new GuiAMINInjector(new ContainerAMINInjector(player.inventory, tile), tile);
            }
            if (tile instanceof TileMINInjector) {
                return new GuiMINInjector(new ContainerMINInjector(player.inventory, tile), tile);
            }
            if (tile instanceof TileMIM) {
                return new GuiMIM(new ContainerMIM(player.inventory, tile), tile);
            }
            if (tile instanceof TileDarknessObelisk) {
                return new GuiDarknessObelisk(new ContainerDarknessObelisk(player.inventory, tile), tile);
            }
            if (tile instanceof TileUltraHeatGenerator) {
                return new GuiUltraHeatGenerator(new ContainerUltraHeatGenerator(player.inventory, tile), tile);
            }
            if (tile instanceof TileUltraFlowerBurner) {
                return new GuiUltraFlowerBurner(new ContainerUltraFlowerBurner(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicalAssembler) {
                return new GuiMagicalAssembler(new ContainerMagicalAssembler(player.inventory, tile), tile);
            }
            if (tile instanceof TileMithrilineFurnace) {
                return new GuiMithrilineFurnace(new ContainerMithrilineFurnace(player.inventory, tile), tile);
            }
            if (tile instanceof TileRightClicker) {
                return new GuiRightClicker(new ContainerRightClicker(player.inventory, tile), tile);
            }
            if (tile instanceof TileRedstoneTransmitter) {
                return new GuiCommon(new ContainerRedstoneTransmitter(player.inventory, tile), tile);
            }
            if (tile instanceof TileMagicalHopper) {
                return new GuiCommon(new ContainerMagicalHopper(player.inventory, tile), tile);
            }
            if (tile instanceof TileWeaponMaker) {
                return new GuiWeaponBench(new ContainerWeaponBench(player.inventory, tile), tile);
            }
            if (tile instanceof TileFurnaceMagic) {
                return new GuiFurnaceMagic(new ContainerFurnaceMagic(player.inventory, tile), tile);
            }
            if (tile instanceof TilePlayerPentacle) {
                return new GuiPlayerPentacle(tile);
            }
            if (tile instanceof TileMagicalChest) {
                return new GuiMagicalChest(player.inventory, (TileMagicalChest) tile);
            }
            if (tile instanceof TileNewMIMInventoryStorage) {
                return new GuiMIMInventoryStorage(player.inventory, (TileNewMIMInventoryStorage) tile);
            }
            if (tile instanceof TileNewMIM) {
                return new GuiNewMIM(new ContainerNewMIM(player.inventory, tile), tile);
            }
            if (tile instanceof TileNewMIMScreen) {
                return new GuiNewMIMScreen((TileNewMIMScreen) tile, player);
            }
            if (tile instanceof TileNewMIMCraftingManager) {
                return new GuiMIMCraftingManager(player.inventory, (TileNewMIMCraftingManager) tile);
            }
            if (tile instanceof TileNewMIMExportNode || tile instanceof TileNewMIMImportNode
                || tile instanceof TileAdvancedBlockBreaker) {
                return new GuiCommon(new ContainerNewMIMSimpleNode(player.inventory, tile), tile);
            }
            if (tile instanceof TileCrafter) {
                return new GuiCrafter(new ContainerCrafter(player.inventory, (TileCrafter) tile), (TileCrafter) tile);
            }
            if (tile instanceof TileAnimalSeparator) {
                return new GuiRayTower(new ContainerRayTower(player.inventory, tile), tile);
            }
        }
        if (ID == Config.guiID[1]) {
            List<EntityDemon> demons = world.getEntitiesWithinAABB(
                EntityDemon.class,
                AxisAlignedBB.getBoundingBox(x - 1, y - 1, z - 1, x + 1, y + 1, z + 1));
            if (!demons.isEmpty()) {
                return new GuiDemon(new ContainerDemon(player, demons.get(0)));
            }
        }
        return null;
    }

    @Override
    public void openBookGUIForPlayer() {
        Minecraft.getMinecraft()
            .displayGuiScreen(new GuiResearchBook());
    }

    @Override
    public void openPentacleGUIForPlayer(TileEntity tile) {
        Minecraft.getMinecraft()
            .displayGuiScreen(new GuiPlayerPentacle(tile));
    }

    @Override
    public void registerRenderInformation() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMRUPresence.class, new RenderMRUCU());
        RenderingRegistry.registerEntityRenderingHandler(EntityMRUArrow.class, new FXArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntitySolarBeam.class, new RenderSolarBeam());
        RenderingRegistry.registerEntityRenderingHandler(EntityWindMage.class, new RenderWindMage());
        RenderingRegistry.registerEntityRenderingHandler(EntityPoisonFume.class, new RenderPoisonFume());
        RenderingRegistry
            .registerEntityRenderingHandler(EntityShadowKnife.class, new RenderSnowball(ECItems.shadeKnife));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityArmorDestroyer.class, new RenderSnowball(ECItems.magicalSlag));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityDividerProjectile.class, new RenderSnowball(ECItems.magicalSlag));
        RenderingRegistry.registerEntityRenderingHandler(EntityMRURay.class, new RenderMRURay());
        RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, new RenderDemon());
        RenderingRegistry.registerEntityRenderingHandler(EntityHologram.class, new RenderHologram());
        RenderingRegistry.registerEntityRenderingHandler(EntityPlayerClone.class, new RenderPlayerClone());
        RenderingRegistry.registerEntityRenderingHandler(EntityOrbitalStrike.class, new RenderOrbitalStrike());
        RenderingRegistry.registerEntityRenderingHandler(EntityDivider.class, new RenderDivider());
        RenderingRegistry.registerBlockHandler(new RenderBlocksEC());
        MinecraftForge.EVENT_BUS.register(new ClientRenderHandler());
        FMLCommonHandler.instance()
            .bus()
            .register(new RenderHandlerEC());
        MinecraftForge.EVENT_BUS.register(new RenderHandlerEC());
        MinecraftForgeClient.registerItemRenderer(
            Item.getItemFromBlock(ECBlocks.elementalCrystal),
            new RenderElementalCrystalAsItem());
        MinecraftForgeClient
            .registerItemRenderer(Item.getItemFromBlock(ECBlocks.solarPrism), new RenderSolarPrismAsItem());
        MinecraftForgeClient.registerItemRenderer(ECItems.pistol, new GunItemRenderHelper());
        MinecraftForgeClient.registerItemRenderer(ECItems.rifle, new GunItemRenderHelper());
        MinecraftForgeClient.registerItemRenderer(ECItems.sniper, new GunItemRenderHelper());
        MinecraftForgeClient.registerItemRenderer(ECItems.gatling, new GunItemRenderHelper());
        MinecraftForgeClient.registerItemRenderer(ECItems.magicalBuilder, new RenderMagicalBuilder());
        MinecraftForgeClient.registerItemRenderer(ECItems.orbitalRemote, new RenderOrbitalRemote());
        // MinecraftForgeClient.registerItemRenderer(ItemsCore.research_book, new RenderMagicalBook());
        MinecraftForgeClient.registerItemRenderer(ECItems.collectedSpawner, new RenderCollectedSpawner());
        for (int i = 0; i < ECItems.magicArmorItems.length; ++i) {
            if (ECItems.magicArmorItems[i] != null)
                MinecraftForgeClient.registerItemRenderer(ECItems.magicArmorItems[i], new ArmorRenderer());
        }

        kbArmorBoost = new KeyBinding("ComputerArmorBoost", Keyboard.KEY_Z, "key.categories.gameplay");
        ClientRegistry.registerKeyBinding(kbArmorBoost);
        kbArmorVision = new KeyBinding("ComputerArmorNightVision", Keyboard.KEY_X, "key.categories.gameplay");
        ClientRegistry.registerKeyBinding(kbArmorVision);
    }

    @Override
    public void registerTileEntitySpecialRenderer() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileRayTower.class, new RenderRayTower());
        ClientRegistry.bindTileEntitySpecialRenderer(TileChamberAcceptor.class, new RenderMRULink());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSolarPrism.class, new RenderSolarPrism());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSunRayAbsorber.class, new RenderSunRayAbsorber());
        ClientRegistry.bindTileEntitySpecialRenderer(TileColdDistillator.class, new RenderColdDistillator());
        ClientRegistry.bindTileEntitySpecialRenderer(TileFlowerBurner.class, new RenderFlowerBurner());
        ClientRegistry.bindTileEntitySpecialRenderer(TileHeatGenerator.class, new RenderHeatGenerator());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEnderGenerator.class, new RenderEnderGenerator());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicianTable.class, new RenderMagicianTable());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalQuarry.class, new RenderMagicalQuarry());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMonsterHolder.class, new RenderMonsterHolder());
        ClientRegistry.bindTileEntitySpecialRenderer(TilePotionSpreader.class, new RenderPotionSpreader());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalEnchanter.class, new RenderMagicalEnchanter());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMonsterHarvester.class, new RenderMonsterHarvester());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalRepairer.class, new RenderMagicalRepairer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMatrixAbsorber.class, new RenderMatrixAbsorber());
        ClientRegistry.bindTileEntitySpecialRenderer(TileRadiatingChamber.class, new RenderRadiatingChamber());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagmaticSmelter.class, new RenderMagmaticSmelter());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalJukebox.class, new RenderMagicalJukebox());
        ClientRegistry.bindTileEntitySpecialRenderer(TileElementalCrystal.class, new RenderElementalCrystal());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCrystalFormer.class, new RenderCrystalFormer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCrystalController.class, new RenderCrystalController());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCrystalExtractor.class, new RenderCrystalExtractor());
        ClientRegistry.bindTileEntitySpecialRenderer(TileChargingChamber.class, new RenderChargingChamber());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMRUCoilHardener.class, new RenderMRUCoilHardener());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMRUCoil.class, new RenderMRUCoil());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCorruptionCleaner.class, new RenderCorruptionCleaner());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMRUReactor.class, new RenderMRUReactor());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMINEjector.class, new RenderMINEjector());
        ClientRegistry.bindTileEntitySpecialRenderer(TileAMINEjector.class, new RenderMINEjector());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMINInjector.class, new RenderMINInjector());
        ClientRegistry.bindTileEntitySpecialRenderer(TileAMINInjector.class, new RenderMINInjector());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMIM.class, new RenderMIM());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDarknessObelisk.class, new RenderDarknessObelisk());
        ClientRegistry.bindTileEntitySpecialRenderer(TileUltraHeatGenerator.class, new RenderUltraHeatGenerator());
        ClientRegistry.bindTileEntitySpecialRenderer(TileUltraFlowerBurner.class, new RenderUltraFlowerBurner());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalAssembler.class, new RenderMagicalAssembler());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalMirror.class, new RenderMagicalMirror());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalDisplay.class, new RenderMagicalDisplay());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMithrilineCrystal.class, new RenderMithrilineCrystal());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMithrilineFurnace.class, new RenderMithrilineFurnace());
        ClientRegistry.bindTileEntitySpecialRenderer(TilePlayerPentacle.class, new RenderPlayerPentacle());
        ClientRegistry.bindTileEntitySpecialRenderer(TileWindRune.class, new RenderWindRune());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDemonicPentacle.class, new RenderDemonicPentacle());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalChest.class, new RenderMagicalChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileNewMIM.class, new RenderNewMIM());
    }

    @Override
    public World getClientWorld() {
        return FMLClientHandler.instance()
            .getClient().theWorld;
    }

    @Override
    public Object getClientIcon(String str) {
        if (str.equals("mru")) return mruIcon;
        if (str.equals("chaosIcon")) return chaosIcon;
        if (str.equals("frozenIcon")) return frozenIcon;
        if (str.equals("mruParticleIcon")) return mruParticleIcon;
        if (str.equals("particle_fogFX")) return fogIcon;
        if (str.contains("consSpellParticle")) {
            int index = str.indexOf('_');
            if (index != -1) {
                int arrayNum = Integer.parseInt(str.substring(index + 1));
                return c_spell_particle_array[arrayNum];
            }
        }
        return null;
    }

    @Override
    public void spawnParticle(String name, float x, float y, float z, double i, double j, double k) {
        if (name.equals("mruFX"))
            Minecraft.getMinecraft().effectRenderer.addEffect(new FXMRU(getClientWorld(), x, y, z, i, j, k));
        if (name.equals("cSpellFX"))
            Minecraft.getMinecraft().effectRenderer.addEffect(new FXSpell(getClientWorld(), x, y, z, i, j, k));
        if (name.equals("fogFX"))
            Minecraft.getMinecraft().effectRenderer.addEffect(new FXFog(getClientWorld(), x, y, z, i, j, k));
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean itemHasEffect(ItemStack stk) {
        if (stk.getItem() instanceof ItemSecret) {
            int metadata = stk.getItemDamage();
            switch (metadata) {
                case 0: {
                    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                    World wrld = Minecraft.getMinecraft().theWorld;
                    List playerLst = wrld.getEntitiesWithinAABB(
                        EntityPlayer.class,
                        AxisAlignedBB.getBoundingBox(
                            player.posX - 10,
                            player.posY - 10,
                            player.posZ - 10,
                            player.posX + 10,
                            player.posY + 10,
                            player.posZ + 10));
                    BiomeGenBase biome = wrld.getBiomeGenForCoords((int) player.posX, (int) player.posY);
                    return (wrld.getWorldTime() % 24000 >= 14000 && wrld.getWorldTime() % 24000 <= 16000)
                        && (player.rotationPitch <= -42 && player.rotationPitch >= -65)
                        && (playerLst.size() == 1)
                        && (!wrld.isRaining() && (biome.getTempCategory() == TempCategory.WARM
                            || biome.getTempCategory() == TempCategory.MEDIUM));
                }
            }
        }
        return false;
    }

    @Override
    public Object getClientModel(int id) {
        switch (id) {
            case 0:
                return chest;
            case 1:
                return legs;
            case 2:
                return chest1;
            default:
                break;
        }
        return chest;
    }

    @Override
    public Object getRenderer(int index) {
        if (index == 0) return skyedRenderer;
        else return cloudedRenderer;
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public void ItemFX(double... ds) {
        Minecraft.getMinecraft().effectRenderer.addEffect(
            new FXItem(Minecraft.getMinecraft().theWorld, ds[0], ds[1], ds[2], 1, 0, 1, ds[3], ds[4], ds[5]));
    }

    @Override
    public void FlameFX(double... ds) {
        Minecraft.getMinecraft().effectRenderer.addEffect(
            new FXColoredFlame(
                Minecraft.getMinecraft().theWorld,
                ds[0],
                ds[1],
                ds[2],
                ds[3],
                ds[4],
                ds[5],
                ds[6],
                ds[7],
                ds[8],
                ds[9]));
    }

    public void SmokeFX(double... ds) {
        if (ds.length == 7) {
            Minecraft.getMinecraft().effectRenderer.addEffect(
                new ec3.client.FX.SmokeFX(
                    Minecraft.getMinecraft().theWorld,
                    ds[0],
                    ds[1],
                    ds[2],
                    ds[3],
                    ds[4],
                    ds[5],
                    (float) ds[6]));
        }
        if (ds.length == 10) {
            Minecraft.getMinecraft().effectRenderer.addEffect(
                new ec3.client.FX.SmokeFX(
                    Minecraft.getMinecraft().theWorld,
                    ds[0],
                    ds[1],
                    ds[2],
                    ds[3],
                    ds[4],
                    ds[5],
                    (float) ds[6],
                    ds[7],
                    ds[8],
                    ds[9]));
        }
    }

    @Override
    public void MRUFX(double... ds) {
        if (ds.length <= 6) {
            Minecraft.getMinecraft().effectRenderer
                .addEffect(new FXMRU(getClientWorld(), ds[0], ds[1], ds[2], ds[3], ds[4], ds[5]));
        } else Minecraft.getMinecraft().effectRenderer.addEffect(
            new FXMRU(getClientWorld(), ds[0], ds[1], ds[2], ds[3], ds[4], ds[5], ds[6], ds[7], ds[8]));
    }

    @Override
    public void wingsAction(EntityPlayer e, ItemStack s) {
        if (GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindJump)
            && Minecraft.getMinecraft().inGameHasFocus) {
            e.worldObj.spawnParticle(
                "reddust",
                e.posX + MathUtils.randomDouble(e.worldObj.rand) / 2,
                e.posY - 1 + MathUtils.randomDouble(e.worldObj.rand),
                e.posZ + MathUtils.randomDouble(e.worldObj.rand) / 2,
                0,
                1,
                1);
            e.motionY += 0.1F;
            e.fallDistance = 0F;
            double pX = e.posX;
            double pY = e.posY;
            double pZ = e.posZ;
            String dataString = new String();
            dataString += "||mod:EC3.Item.Wings";
            dataString += "||x:" + pX + "||y:" + pY + "||z:" + pZ;
            dataString += "||playername:" + e.getCommandSenderName();
            DummyPacket pkt = new DummyPacket(dataString);
            DummyPacketHandler.sendToServer(pkt);
        }
    }

    @Override
    public void handlePositionChangePacket(DummyData[] packetData) {
        double sX = Double.parseDouble(packetData[1].fieldValue);
        double sY = Double.parseDouble(packetData[2].fieldValue);
        double sZ = Double.parseDouble(packetData[3].fieldValue);
        float yaw = Float.parseFloat(packetData[4].fieldValue);
        float pitch = Float.parseFloat(packetData[5].fieldValue);
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        player.setPositionAndRotation(sX, sY, sZ, yaw, pitch);
        player.rotationYawHead = player.rotationYaw;
    }

    public void handleSoundPlay(DummyData[] packetData) {
        double sX = Double.parseDouble(packetData[1].fieldValue);
        double sY = Double.parseDouble(packetData[2].fieldValue);
        double sZ = Double.parseDouble(packetData[3].fieldValue);
        float volume = Float.parseFloat(packetData[4].fieldValue);
        float pitch = Float.parseFloat(packetData[5].fieldValue);
        String sound = packetData[6].fieldValue;
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        player.worldObj.playSound(sX, sY, sZ, sound, volume, pitch, false);
    }

    public static IIcon mruIcon;
    public static IIcon mruParticleIcon;
    public static IIcon[] c_spell_particle_array = new IIcon[4];
    public static IIcon chaosIcon;
    public static IIcon frozenIcon;

    @SideOnly(Side.CLIENT)
    private static IRenderHandler skyedRenderer = new RenderSkyHoanna();

    @SideOnly(Side.CLIENT)
    private static IRenderHandler cloudedRenderer = new RenderCloudsHoanna();
    public static IIcon fogIcon;

    private static final ModelArmorEC chest = new ModelArmorEC(1.0f);
    private static final ModelArmorEC chest1 = new ModelArmorEC(0.75f);
    private static final ModelArmorEC legs = new ModelArmorEC(0.5f);

    public static KeyBinding kbArmorBoost;
    public static KeyBinding kbArmorVision;
}
