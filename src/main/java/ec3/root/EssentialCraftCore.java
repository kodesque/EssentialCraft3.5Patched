package ec3.root;

import java.util.Arrays;

import cpw.mods.fml.common.Loader;
import net.minecraft.command.CommandHandler;
import net.minecraft.server.MinecraftServer;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import ec3.api.config.Config;
import ec3.common.init.ECAchievements;
import ec3.common.init.ECBiomes;
import ec3.common.init.ECBlocks;
import ec3.common.init.ECDimensions;
import ec3.common.init.ECEntities;
import ec3.common.init.ECItems;
import ec3.common.init.ECPotions;
import ec3.common.init.ECRecipes;
import ec3.common.init.ECStructures;
import ec3.common.init.compat.ECCompatBloodMagic;
import ec3.common.init.custom.ECCorruptionEffects;
import ec3.common.init.custom.ECResearch;
import ec3.common.init.custom.ECWeapons;
import ec3.common.world.structures.WorldGenManager;
import ec3.integration.versionChecker.Check;
import ec3.integration.waila.WailaInitializer;
import ec3.network.proxy.CommonProxy;
import ec3.utils.commands.handlers.CommandEC;
import ec3.utils.commands.handlers.CommandECSimple;
import ec3.utils.dummycore.core.Core;
import ec3.utils.dummycore.core.CoreInitializer;

@Mod(
    modid = EssentialCraftCore.modid,
    name = EssentialCraftCore.name,
    version = EssentialCraftCore.version,
    guiFactory = "ec3.client.gui.ModConfigGuiHandler")
public class EssentialCraftCore {

    // ============================================CORE START=================================================//

    // ============================================CORE VARS==================================================//
    @Instance(EssentialCraftCore.modid)
    public static EssentialCraftCore core;
    @SidedProxy(
        clientSide = "ec3.network.proxy.ClientProxy",
        serverSide = "ec3.network.proxy.CommonProxy",
        modId = EssentialCraftCore.modid)
    public static CommonProxy proxy;
    public static Config cfg = new Config();
    // TODO Do not forget to change the version number every git commit.
    public static final String version = "4.6.8";
    public static final String modid = "essentialcraft";
    public static final String name = "EssentialCraft3.5 Patched";
    public static ModMetadata metadata;
    public static SimpleNetworkWrapper network;
    // ============================================CORE FUNCTIONS=============================================//

    public static boolean isThaumcraftLoaded() {
        return Loader.isModLoaded("thaumcraft");
    }

    // ============================================CORE MOD===================================================//
    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        MinecraftServer mcserver = event.getServer();

        ((CommandHandler) mcserver.getCommandManager()).registerCommand(new CommandEC());
        ((CommandHandler) mcserver.getCommandManager()).registerCommand(new CommandECSimple());

        CoreInitializer.serverStart(event);
    }

    @EventHandler
    public void onServerStop(FMLServerStoppedEvent e) {
        CoreInitializer.onServerStop(e);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CoreInitializer.preInit(event);
        metadata = event.getModMetadata();

        core = this;
        try {
            Core.registerModAbsolute(
                getClass(),
                "Essential Craft 3",
                event.getModConfigurationDirectory()
                    .getAbsolutePath(),
                cfg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Check.checkerCommit();
        WailaInitializer.sendIMC();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        if (core == null) core = this;
        ECCoreRegistry.register();

        if (ECDimensions.core != null) ECDimensions.core.registerDimensionMagic();
        else {
            ECDimensions.core = new ECDimensions();
            ECDimensions.core.registerDimensionMagic();
        }
        if (ECBlocks.instance != null) ECBlocks.instance.loadBlocks();
        else {
            ECBlocks.instance = new ECBlocks();
            ECBlocks.instance.loadBlocks();
        }
        if (ECItems.instance != null) ECItems.instance.loadItems();
        else {
            ECItems.instance = new ECItems();
            ECItems.instance.loadItems();
        }
        if (ECRecipes.instance != null) ECRecipes.instance.main();
        else {
            ECRecipes.instance = new ECRecipes();
            ECRecipes.instance.main();
        }

        if (ECBiomes.core != null) ECBiomes.core.register();
        else {
            ECBiomes.core = new ECBiomes();
            ECBiomes.core.register();
        }
        ECBlocks.postInitLoad();
        ECStructures.register();
        if (proxy != null) {
            proxy.registerRenderInformation();
            proxy.registerTileEntitySpecialRenderer();
        } else {

        }
        ECWeapons.register();
        ECCorruptionEffects.register();

        CoreInitializer.init(event);
    }

    public static boolean clazzExists(String clazzName) {
        try {
            Class<?> clazz = Class.forName(clazzName);
            return clazz != null;
        } catch (Exception e) {
            return false;
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        ECEntities.registerEntities();
        ECCompatBloodMagic.register();
        ECAchievements.register();
        ECPotions.registerPotions();
        GameRegistry.registerWorldGenerator(new WorldGenManager(), 16);
        cfg.postInitParseDecorativeBlocks();
        ECResearch.init();

        metadata.autogenerated = false;
        metadata.modId = modid;
        metadata.version = version;
        metadata.name = name;
        metadata.credits = "Author: Modbder; Patched by: Kodesque;";
        metadata.authorList = Arrays.asList(new String[] { "Modbder", "Kodesque" });
        metadata.description = "EssentialCraft 3 is a huge technomagical mod which adds a new energy system, MRU (Magical Radiation Unit), and various ways to harness it.";
        metadata.url = "https://github.com/kodesque/EssentialCraft3.5Patched";
        metadata.updateUrl = "https://github.com/kodesque/EssentialCraft3.5Patched";
        metadata.logoFile = "assets/essentialcraft/textures/special/logo.png";
    }
}
