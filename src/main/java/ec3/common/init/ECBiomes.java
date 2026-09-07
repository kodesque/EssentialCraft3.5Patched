package ec3.common.init;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

import org.apache.logging.log4j.LogManager;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ec3.api.config.Config;
import ec3.common.world.biomes.BiomeCorruptionChaos;
import ec3.common.world.biomes.BiomeCorruptionFrozen;
import ec3.common.world.biomes.BiomeCorruptionMagic;
import ec3.common.world.biomes.BiomeCorruptionShadow;
import ec3.common.world.biomes.BiomeHoannaDesert;
import ec3.common.world.biomes.BiomeHoannaDreadlands;

public class ECBiomes {

    public static ECBiomes core;

    public ECBiomes() {
        // MinecraftForge.TERRAIN_GEN_BUS.register(this);
    }

    @SubscribeEvent
    public void manageBiomeGen(WorldTypeEvent.InitBiomeGens event) {}

    public void register() {
        chaosCorruption = new BiomeCorruptionChaos(Config.biomeID[0]);
        frozenCorruption = new BiomeCorruptionFrozen(Config.biomeID[1]);
        shadowCorruption = new BiomeCorruptionShadow(Config.biomeID[2]);
        magicCorruption = new BiomeCorruptionMagic(Config.biomeID[3]);

        BiomeManager.removeSpawnBiome(chaosCorruption);
        BiomeManager.removeSpawnBiome(frozenCorruption);
        BiomeManager.removeSpawnBiome(shadowCorruption);
        BiomeManager.removeSpawnBiome(magicCorruption);

        registerFirstWorldBiomes();
    }

    public void registerFirstWorldBiomes() {
        firstWorldBiomeArray[0] = BiomeGenBase.ocean;
        firstWorldBiomeArray[1] = magicCorruption;
        firstWorldBiomeArray[2] = BiomeGenBase.beach;
        firstWorldBiomeArray[3] = BiomeGenBase.river;
        firstWorldBiomeArray[4] = new BiomeHoannaDreadlands(Config.biomeID[5]).setGrassColor(0x889688)
            .setWaterColor(0x889688)
            .setLeavesColor(0x889688)
            .setBiomeName("dreadlands")
            .setDisableRain()
            .setTemperatureRainfall(2.0F, 0.0F)
            .setHeight(new Height(0.125F, 0.126F));
        firstWorldBiomeArray[5] = BiomeGenBase.forest;
        firstWorldBiomeArray[6] = BiomeGenBase.extremeHills;
        firstWorldBiomeArray[7] = chaosCorruption;
        firstWorldBiomeArray[8] = new BiomeHoannaDesert(Config.biomeID[4]).setBiomeName("desert")
            .setColor(16421912)
            .setDisableRain()
            .setTemperatureRainfall(2.0F, 0.0F)
            .setHeight(new Height(0.125F, 0.05F));
        firstWorldBiomeArray[9] = frozenCorruption;

    }

    public static BiomeGenBase getBiome(int p_150568_0_) {
        if (p_150568_0_ >= 0 && p_150568_0_ <= firstWorldBiomeArray.length) {
            return firstWorldBiomeArray[p_150568_0_];
        } else {
            LogManager.getLogger()
                .warn("Biome ID is out of bounds: " + p_150568_0_ + ", defaulting to 0 (Ocean)");
            return firstWorldBiomeArray[0];
        }
    }

    public static BiomeCorruptionChaos chaosCorruption;
    public static BiomeCorruptionFrozen frozenCorruption;
    public static BiomeCorruptionShadow shadowCorruption;
    public static BiomeCorruptionMagic magicCorruption;

    public static BiomeGenBase[] firstWorldBiomeArray = new BiomeGenBase[10];
}
