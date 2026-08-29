package ec3.common.world.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeCorruptionFrozen extends BiomeGenBase {

    public BiomeCorruptionFrozen(int par1) {
        super(par1);
        this.biomeName = "Corrupted Land";
    }

    public int getBiomeGrassColor() {
        return 0x0077ff;
    }

    public int getBiomeFoliageColor() {
        return 0x0077ff;
    }

    public int getWaterColorMultiplier() {
        return 0x0077ff;
    }

    public int getModdedBiomeGrassColor(int original) {
        return 0x0077ff;
    }

    public int getModdedBiomeFoliageColor(int original) {
        return 0x0077ff;
    }
}
