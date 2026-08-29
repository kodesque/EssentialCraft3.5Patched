package ec3.common.world.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeCorruptionChaos extends BiomeGenBase {

    public BiomeCorruptionChaos(int par1) {
        super(par1);
        this.biomeName = "Corrupted Land";
    }

    public int getBiomeGrassColor() {
        return 0x770000;
    }

    public int getBiomeFoliageColor() {
        return 0x770000;
    }

    public int getWaterColorMultiplier() {
        return 0x770000;
    }

    public int getModdedBiomeGrassColor(int original) {
        return 0x770000;
    }

    public int getModdedBiomeFoliageColor(int original) {
        return 0x770000;
    }
}
