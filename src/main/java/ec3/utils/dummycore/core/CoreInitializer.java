package ec3.utils.dummycore.core;

import java.util.Arrays;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ec3.utils.dummycore.config.DummyConfig;
import ec3.utils.dummycore.config.IDummyConfig;
import ec3.utils.dummycore.events.DummyEventHandler;
import ec3.utils.dummycore.network.handlers.DummyPacketHandler;
import ec3.utils.dummycore.network.handlers.DummyTilePacketHandler;
import ec3.utils.dummycore.network.packets.DummyPacket;
import ec3.utils.dummycore.network.packets.DummyPacketTile;
import ec3.utils.dummycore.network.proxy.NetProxyServer;
import ec3.utils.dummycore.utils.*;
import ec3.utils.dummycore.utils.data.DummyDataUtils;
import ec3.utils.dummycore.utils.system.LoadingUtils;
import ec3.utils.dummycore.utils.system.ModVersionChecker;
import net.minecraft.command.CommandHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * @author Modbder
 * @version From DummyCore 1.0
 */
public class CoreInitializer {

    public static CoreInitializer instance;
    public static IDummyConfig cfg = new DummyConfig();
    public static SimpleNetworkWrapper network;
    @SidedProxy(clientSide = "ec3.utils.dummycore.network.proxy.NetProxyClient", serverSide = "ec3.utils.dummycore.network.proxy.NetProxyServer")
    public static NetProxyServer proxy;
    public static final DummyPacketHandler packetHandler = new DummyPacketHandler();

    public static void preInit(FMLPreInitializationEvent e) {

        Core.registerModAbsolute(
            CoreInitializer.class,
            "DummyCore",
            e.getModConfigurationDirectory()
                .getAbsolutePath(),
            cfg,
            false);

        network = NetworkRegistry.INSTANCE.newSimpleChannel("DummyCore");
        network.registerMessage(DummyPacketHandler.class, DummyPacket.class, 0, Side.SERVER);
        network.registerMessage(DummyPacketHandler.class, DummyPacket.class, 0, Side.CLIENT);
        network.registerMessage(DummyTilePacketHandler.class, DummyPacketTile.class, 1, Side.SERVER);
        network.registerMessage(DummyTilePacketHandler.class, DummyPacketTile.class, 1, Side.CLIENT);

        MinecraftForge.EVENT_BUS.register(new DummyEventHandler());
        MinecraftForge.EVENT_BUS.register(new DummyDataUtils());
        FMLCommonHandler.instance()
            .bus()
            .register(new DummyEventHandler());

        proxy.registerInfo();

        ModVersionChecker.addRequest(CoreInitializer.class, "https://www.dropbox.com/s/iwdfv0mc4qns00f/DummyCoreVersion.txt?dl=1");
    }

    public static void init(FMLInitializationEvent e) {
        proxy.registerInit();
    }

    public static void onServerStop(FMLServerStoppedEvent e) {
        DummyDataUtils.stop();
    }

    public static void serverStart(FMLServerStartingEvent event) {
        MinecraftServer mcserver = event.getServer();
        ((CommandHandler) mcserver.getCommandManager()).registerCommand(new CommandTransfer());
    }

    public static void fmlLogMissingTextures() {
        proxy.removeMissingTextureErrors();
    }
}
