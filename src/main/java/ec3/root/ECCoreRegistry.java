package ec3.root;

import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import ec3.api.config.Config;
import ec3.api.world.WorldEventLibrary;
import ec3.common.init.ECBiomes;
import ec3.common.init.ECBlocks;
import ec3.common.init.ECDimensions;
import ec3.common.init.ECItems;
import ec3.common.init.ECRecipes;
import ec3.common.init.ECTiles;
import ec3.common.world.event.WorldEventDarkness;
import ec3.common.world.event.WorldEventEarthquake;
import ec3.common.world.event.WorldEventFumes;
import ec3.common.world.event.WorldEventSunArray;
import ec3.events.ECEventHandler;
import ec3.network.PacketNBT;
import ec3.network.proxy.ClientProxy;
import ec3.network.proxy.CommonProxy;
import ec3.network.proxy.PacketDispatcherEC;
import ec3.utils.player.PlayerTickHandler;
import ec3.utils.player.PlayerTracker;

public class ECCoreRegistry {

    public static ECCoreRegistry instance;

    public static void register() {
        Config.instance = new Config();
        ECBlocks.instance = new ECBlocks();
        ECItems.instance = new ECItems();
        ECTiles.register();
        ECDimensions.core = new ECDimensions();
        if (EssentialCraftCore.proxy != null)
            NetworkRegistry.INSTANCE.registerGuiHandler(EssentialCraftCore.core, EssentialCraftCore.proxy);
        else {
            Side s = FMLCommonHandler.instance()
                .getEffectiveSide();
            if (s == Side.CLIENT) EssentialCraftCore.proxy = new ClientProxy();
            else EssentialCraftCore.proxy = new CommonProxy();

            NetworkRegistry.INSTANCE.registerGuiHandler(EssentialCraftCore.core, EssentialCraftCore.proxy);
        }
        EssentialCraftCore.network = NetworkRegistry.INSTANCE.newSimpleChannel("essentialcraft3");
        EssentialCraftCore.network.registerMessage(PacketDispatcherEC.class, PacketNBT.class, 0, Side.SERVER);
        EssentialCraftCore.network.registerMessage(PacketDispatcherEC.class, PacketNBT.class, 0, Side.CLIENT);
        ECRecipes.instance = new ECRecipes();
        ECBiomes.core = new ECBiomes();
        // MagicalEnergiserRecipes.smeltingBase = new MagicalEnergiserRecipes();
        // MagicianTableRecipes.smeltingBase = new MagicianTableRecipes();
        // TickRegistry.registerTickHandler(new PlayerTick(), Side.SERVER);
        // MinecraftForge.EVENT_BUS.register(new ForgeEventHandlerECII());
        MinecraftForge.EVENT_BUS.register(new PlayerTickHandler());
        FMLCommonHandler.instance()
            .bus()
            .register(new PlayerTickHandler());
        MinecraftForge.EVENT_BUS.register(new ECEventHandler());
        FMLCommonHandler.instance()
            .bus()
            .register(new ECEventHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerTracker());
        // GameRegistry.registerPlayerTracker(new PlayerTrackerECII());

        WorldEventLibrary.registerWorldEvent(new WorldEventSunArray());
        WorldEventLibrary.registerWorldEvent(new WorldEventFumes());
        WorldEventLibrary.registerWorldEvent(new WorldEventDarkness());
        WorldEventLibrary.registerWorldEvent(new WorldEventEarthquake());
    }

}
