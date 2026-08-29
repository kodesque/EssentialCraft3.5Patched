package ec3.common.world.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeHoanna extends BiomeGenBase {

    public int grassColor = 16777215;
    public int waterColor = 16777215;
    public int leavesColor = 16777215;

    public BiomeHoanna setGrassColor(int i) {
        grassColor = i;
        return this;
    }

    public BiomeHoanna setWaterColor(int i) {
        waterColor = i;
        return this;
    }

    public BiomeHoanna setLeavesColor(int i) {
        leavesColor = i;
        return this;
    }

    public BiomeHoanna setName(String s) {
        this.biomeName = s;
        return this;
    }

    public BiomeHoanna(int par1) {
        super(par1);
    }

    public int getBiomeGrassColor() {
        return grassColor;
    }

    public int getBiomeFoliageColor() {
        return leavesColor;
    }

    public int getWaterColorMultiplier() {
        return waterColor;
    }

    public int getModdedBiomeGrassColor(int original) {
        return grassColor;
    }

    public int getModdedBiomeFoliageColor(int original) {
        return leavesColor;
    }
}
