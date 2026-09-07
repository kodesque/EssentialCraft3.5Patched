package ec3.common.world.structures;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import ec3.common.init.ECBlocks;
import ec3.common.init.ECItems;
import ec3.common.items.ItemBaublesWearable;

public class WorldGenMRUTower extends WorldGenerator {

    public WorldGenMRUTower() {}

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
            for (int i = 0; i < 4; ++i) {
                generateFloor(w, x, y + 16 * i, z, 4 - i);
            }
            return true;
        }
        return false;
    }

    public void generateFloor(World w, int x, int y, int z, int rad) {
        for (int dx = -rad; dx <= rad; ++dx) {
            for (int dz = -rad; dz <= rad; ++dz) {
                for (int dy = 0; dy < 16; ++dy) {
                    if ((dx == 1 && dz == 1) || (dx == -1 && dz == -1)
                        || (dx == 1 && dz == -1)
                        || (dx == -1 && dz == 1)) {
                        if (w.getBlock(x + dx, y + dy, z + dz) != Blocks.chest)
                            w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fence[1]);
                    }
                    if ((dx == rad || dx == -rad || dz == -rad || dz == rad) && (dy == 8)) {
                        if (w.getBlock(x + dx, y + dy, z + dz) != Blocks.chest)
                            w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fortifiedStone);
                        if (rad == 1 && (dx == 0 || dz == 0)) {
                            if (w.getBlock(x + dx, y + dy + 1, z + dz) != Blocks.chest) {
                                w.setBlock(x + dx, y + dy + 1, z + dz, Blocks.chest);
                                TileEntityChest chest = (TileEntityChest) w.getTileEntity(x + dx, y + dy + 1, z + dz);
                                if (chest != null) {
                                    WeightedRandomChestContent.generateChestContents(
                                        w.rand,
                                        WorldGenOldCatacombs.generatedItems,
                                        chest,
                                        w.rand.nextInt(12) + 6);
                                    IInventory inv = chest;
                                    for (int i = 0; i < inv.getSizeInventory(); ++i) {
                                        ItemStack stk = inv.getStackInSlot(i);
                                        if (stk != null && stk.getItem() instanceof ItemBaublesWearable) {
                                            ItemBaublesWearable.initRandomTag(stk, w.rand);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if ((dx == -rad || dx == rad) && (dz == -rad || dz == rad)) {
                        if (w.getBlock(x + dx, y + dy, z + dz) != Blocks.chest)
                            w.setBlock(x + dx, y + dy, z + dz, ECBlocks.fence[2]);
                    }
                    if (rad > 1 && (dx == -rad) && (dz == -rad)) {
                        w.setBlock(x + dx + 1, y + dy, z + dz, ECBlocks.fortifiedStone);
                        w.setBlock(x + dx, y + dy, z + dz + 1, ECBlocks.fortifiedStone);
                        if (dy == 15) w.setBlock(x + dx + 1, y + dy, z + dz + 1, ECBlocks.fortifiedStone);
                    }
                    if (rad > 1 && (dx == rad) && (dz == -rad)) {
                        w.setBlock(x + dx - 1, y + dy, z + dz, ECBlocks.fortifiedStone);
                        w.setBlock(x + dx, y + dy, z + dz + 1, ECBlocks.fortifiedStone);
                        if (dy == 15) w.setBlock(x + dx - 1, y + dy, z + dz + 1, ECBlocks.fortifiedStone);
                    }
                    if (rad > 1 && (dx == -rad) && (dz == rad)) {
                        w.setBlock(x + dx + 1, y + dy, z + dz, ECBlocks.fortifiedStone);
                        w.setBlock(x + dx, y + dy, z + dz - 1, ECBlocks.fortifiedStone);
                        if (dy == 15) w.setBlock(x + dx + 1, y + dy, z + dz - 1, ECBlocks.fortifiedStone);
                    }
                    if (rad > 1 && (dx == rad) && (dz == rad)) {
                        w.setBlock(x + dx - 1, y + dy, z + dz, ECBlocks.fortifiedStone);
                        w.setBlock(x + dx, y + dy, z + dz - 1, ECBlocks.fortifiedStone);
                        if (dy == 15) w.setBlock(x + dx - 1, y + dy, z + dz - 1, ECBlocks.fortifiedStone);
                    }
                }
            }
        }
    }

}
