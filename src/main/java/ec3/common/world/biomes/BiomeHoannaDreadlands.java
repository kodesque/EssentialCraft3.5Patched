package ec3.common.world.biomes;

import ec3.common.world.structures.WorldGenDeadCacti;
import net.minecraft.world.biome.BiomeGenBase;

import ec3.common.init.ECBlocks;

public class BiomeHoannaDreadlands extends BiomeGenBase {

    public int grassColor = 16777215;
    public int waterColor = 16777215;
    public int leavesColor = 16777215;

    public BiomeHoannaDreadlands setGrassColor(int i) {
        grassColor = i;
        return this;
    }

    public BiomeHoannaDreadlands setWaterColor(int i) {
        waterColor = i;
        return this;
    }

    public BiomeHoannaDreadlands setLeavesColor(int i) {
        leavesColor = i;
        return this;
    }

    public BiomeHoannaDreadlands setName(String s) {
        this.biomeName = s;
        return this;
    }

    public BiomeHoannaDreadlands(int par1) {
        super(par1);
        this.topBlock = ECBlocks.dreadDirt;
        this.fillerBlock = ECBlocks.dreadDirt;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = -999;
        this.theBiomeDecorator.cactiPerChunk = -999;
        this.theBiomeDecorator.cactusGen = new WorldGenDeadCacti();

        this.spawnableCreatureList.clear();
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
