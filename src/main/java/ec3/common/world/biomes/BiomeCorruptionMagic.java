package ec3.common.world.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeCorruptionMagic extends BiomeGenBase {

    public BiomeCorruptionMagic(int par1) {
        super(par1);
        this.biomeName = "Corrupted Land";
    }

    public int getBiomeGrassColor() {
        return 0xff00ff;
    }

    public int getBiomeFoliageColor() {
        return 0xff00ff;
    }

    public int getWaterColorMultiplier() {
        return 0xff00ff;
    }

    public int getModdedBiomeGrassColor(int original) {
        return 0xff00ff;
    }

    public int getModdedBiomeFoliageColor(int original) {
        return 0xff00ff;
    }
}
