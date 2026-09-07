package ec3.common.world.structures;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import ec3.common.init.ECBlocks;
import ec3.common.init.ECItems;
import ec3.utils.ECExplosion;

public class WorldGenDestroyedHouse extends WorldGenerator {

    public int floorsAmount, rad;

    public WorldGenDestroyedHouse(int i) {
        floorsAmount = i;
    }

    public WorldGenDestroyedHouse(int i, int j) {
        floorsAmount = i;
        rad = j;
    }

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

    public int getGroundToGenerate(World w, int x, int y, int z) {
        while (y > 5) {
            if (!w.isAirBlock(x, y, z) && w.getBlock(x, y, z) != Blocks.water) {
                if (w.getBlock(x, y, z) != ECBlocks.concrete && w.getBlock(x, y, z) != ECBlocks.fortifiedStone) {
                    break;
                } else {
                    return -1;
                }
            }
            --y;
        }
        if (y == 5) return -1;
        return y;
    }

    @Override
    public boolean generate(World w, Random r, int x, int y, int z) {
        int genY = getGroundToGenerate(w, x, y, z);
        if (genY != -1) {
            y = genY;
            if (rad == 0) rad = r.nextInt(6) + 3;
            for (int i = 0; i < floorsAmount + 1; ++i) {
                generateFloor(w, r, x, y + 5 * i, z, i, rad);
            }
            return true;
        }
        return false;
    }

    public void generateFloor(World w, Random r, int x, int y, int z, int floorNum, int size) {
        for (int dx = -size; dx <= size; ++dx) {
            for (int dz = -size; dz <= size; ++dz) {
                if (floorNum == 0) {
                    if (((dx == -size || dx == size) && (dz == -size || dz == size)) || (dx == 0 && dz == 0)) {
                        w.setBlock(x + dx, y - 1, z + dz, ECBlocks.levitator, 0, 3);
                    }
                }
                for (int dy = 0; dy < 5; ++dy) {
                    if (w.getBlock(x + dx, y + dy, z + dz) != Blocks.water)
                        w.setBlock(x + dx, y + dy, z + dz, Blocks.air, 0, 3);
                    int tryInt = dy + 1;
                    if (w.rand.nextInt(tryInt) == 0) w.setBlock(x + dx, y + dy, z + dz, ECBlocks.concrete);
                    if (dy == 0 || dy == 4) {
                        w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fortifiedStone, 0, 3);
                    }
                    if (dx == -size || dx == size) {
                        w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fortifiedStone, 0, 3);
                        if (dy > 0 && dy < 4 && dz > -size + 1 && dz < size - 1) {
                            w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fortifiedGlass, 0, 3);
                        }
                    }
                    if (dz == -size || dz == size) {
                        w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fortifiedStone, 0, 3);
                        if (dy > 0 && dy < 4 && dx > -size + 1 && dx < size - 1) {
                            w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fortifiedGlass, 0, 3);
                        }
                    }
                    if (floorsAmount == 0) floorsAmount = 1;
                    if (r.nextInt(floorsAmount * 10) < floorNum) {
                        ECExplosion explosion = new ECExplosion(w, null, x + dx, y + dy, z + dz, 3 + (floorNum / 3));
                        explosion.doExplosionA();
                        explosion.doExplosionB(true);
                    }
                }
            }
        }
    }

}
