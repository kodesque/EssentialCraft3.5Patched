package ec3.common.world.structures;

import java.util.Random;

import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import ec3.common.init.ECBlocks;
import ec3.common.init.ECItems;

public class WorldGenMRUSpreader extends WorldGenerator {

    public WorldGenMRUSpreader() {}

    public static final WeightedRandomChestContent[] generatedItems = new WeightedRandomChestContent[] {
        new WeightedRandomChestContent(ECItems.titanite, 0, 8, 64, 20),
        new WeightedRandomChestContent(ECItems.twinkling_titanite, 0, 2, 16, 10),
        new WeightedRandomChestContent(ECItems.genericItem, 5, 1, 64, 15),
        new WeightedRandomChestContent(ECItems.genericItem, 6, 1, 64, 15),
        new WeightedRandomChestContent(ECItems.genericItem, 7, 1, 64, 15),
        new WeightedRandomChestContent(ECItems.genericItem, 8, 1, 64, 15),
        new WeightedRandomChestContent(ECItems.genericItem, 9, 1, 64, 15),
        new WeightedRandomChestContent(ECItems.genericItem, 10, 1, 64, 15),
        new WeightedRandomChestContent(ECItems.genericItem, 11, 1, 64, 15),
        new WeightedRandomChestContent(ECItems.genericItem, 20, 1, 12, 10),
        new WeightedRandomChestContent(ECItems.genericItem, 3, 1, 64, 15),
        new WeightedRandomChestContent(ECItems.genericItem, 35, 1, 1, 6),
        new WeightedRandomChestContent(ECItems.genericItem, 36, 1, 1, 6),
        new WeightedRandomChestContent(ECItems.genericItem, 37, 1, 1, 6) };

    @Override
    public boolean generate(World w, Random r, int x, int y, int z) {
        for (int dx = 0; dx < 3; ++dx) {
            for (int dz = 0; dz < 3; ++dz) {
                for (int dy = 0; dy < 7; ++dy) {
                    if (dy == 0) {
                        if (dx == 1 && dz == 1) {
                            w.setBlock(x + dx, y, z + dz, ECBlocks.magicPlating, 0, 3);
                            if (w.isAirBlock(x + dx, y - 1, z + dz))
                                w.setBlock(x + dx, y - 1, z + dz, ECBlocks.levitator, 0, 3);
                        } else {
                            w.setBlock(x + dx, y, z + dz, ECBlocks.fortifiedStone, 0, 3);
                        }
                    } else {
                        if ((dx == 0 || dx == 2) && (dz == 0 || dz == 2) && dy < 5) {
                            w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fence[2], 0, 3);
                        } else {
                            if ((dx == 1) && (dz == 1) && dy < 6) {
                                w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fence[1], 0, 3);
                            } else {
                                if ((dx == 1) && (dz == 1) && dy == 6) {
                                    w.setBlock(x + dx, y + dy, z + dz, ECBlocks.spreader, 0, 3);
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
