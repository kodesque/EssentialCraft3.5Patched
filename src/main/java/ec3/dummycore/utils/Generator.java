package ec3.dummycore.utils;

import DummyCore.Utils.Coord3D;
import DummyCore.Utils.Pair;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;

public class Generator {
    public static final DummyCore.Utils.Generator instance = new DummyCore.Utils.Generator();
    public World worldObj;
    public boolean isWorking;
    public boolean hasOffset;
    public Coord3D offset;
    public Block setTo;
    public int genMetadata;
    public int flag;

    public Generator() {
    }

    public static AxisAlignedBB centerBB(AxisAlignedBB genBox) {
        return AxisAlignedBB.func_72330_a(genBox.field_72340_a - (genBox.field_72336_d - genBox.field_72340_a) / (double)2.0F, genBox.field_72338_b - (genBox.field_72337_e - genBox.field_72338_b) / (double)2.0F, genBox.field_72339_c - (genBox.field_72334_f - genBox.field_72339_c) / (double)2.0F, genBox.field_72336_d - (genBox.field_72336_d - genBox.field_72340_a) / (double)2.0F, genBox.field_72337_e - (genBox.field_72337_e - genBox.field_72338_b) / (double)2.0F, genBox.field_72334_f - (genBox.field_72334_f - genBox.field_72339_c) / (double)2.0F);
    }

    public static AxisAlignedBB normaliseBB(AxisAlignedBB genBox) {
        double minX = genBox.field_72340_a;
        double minY = genBox.field_72338_b;
        double minZ = genBox.field_72339_c;
        double maxX = genBox.field_72336_d;
        double maxY = genBox.field_72337_e;
        double maxZ = genBox.field_72334_f;
        return AxisAlignedBB.func_72330_a(maxX < minX ? genBox.field_72336_d : genBox.field_72340_a, maxY < minY ? genBox.field_72337_e : genBox.field_72338_b, maxZ < minZ ? genBox.field_72334_f : genBox.field_72339_c, maxX < minX ? genBox.field_72340_a : genBox.field_72336_d, maxY < minY ? genBox.field_72338_b : genBox.field_72337_e, maxZ < minZ ? genBox.field_72339_c : genBox.field_72334_f);
    }

    public ArrayList<Coord3D> getBlocksOfType(AxisAlignedBB genBox) {
        this.gen();
        this.prepareBB(genBox);
        ArrayList<Coord3D> lst = new ArrayList();

        for(int x = MathHelper.func_76128_c(genBox.field_72340_a); x <= MathHelper.func_76128_c(genBox.field_72336_d); ++x) {
            for(int y = MathHelper.func_76128_c(genBox.field_72338_b); y <= MathHelper.func_76128_c(genBox.field_72337_e); ++y) {
                for(int z = MathHelper.func_76128_c(genBox.field_72339_c); z <= MathHelper.func_76128_c(genBox.field_72334_f); ++z) {
                    if (this.worldObj.func_147439_a(x, y, z) == this.setTo && this.worldObj.func_72805_g(x, y, z) == this.genMetadata) {
                        Coord3D c = new Coord3D((float)x, (float)y, (float)z);
                        lst.add(c);
                    }
                }
            }
        }

        this.restoreBB(genBox);
        return lst;
    }

    public void setOffset(Coord3D coord) {
        this.offset = coord;
        this.hasOffset = true;
    }

    public void setOffset(int x, int y, int z) {
        this.offset = new Coord3D((float)x, (float)y, (float)z);
        this.hasOffset = true;
    }

    public void startWorldgen(World world) {
        if (world.field_72995_K) {
            throw new IllegalArgumentException("Worldgen on CLIENT side is not allowed!");
        } else if (this.isWorking) {
            throw new IllegalStateException("Already generating!");
        } else {
            this.offset = null;
            this.hasOffset = false;
            this.isWorking = true;
            this.worldObj = world;
            this.setTo = Blocks.field_150350_a;
            this.genMetadata = 0;
            this.flag = 2;
        }
    }

    public void endWorldgen() {
        if (!this.isWorking) {
            throw new IllegalStateException("Not generating!");
        } else {
            this.offset = null;
            this.isWorking = false;
            this.worldObj = null;
            this.hasOffset = false;
            this.setTo = null;
            this.genMetadata = 0;
            this.flag = 0;
        }
    }

    public void setFlag(int i) {
        this.gen();
        this.flag = i;
    }

    public boolean gen() {
        if (!this.isWorking) {
            throw new IllegalStateException("Can't worlgen if not generating!");
        } else if (this.worldObj.field_72995_K) {
            throw new IllegalArgumentException("Worldgen on CLIENT side is not allowed!");
        } else {
            return this.isWorking;
        }
    }

    public void restoreBB(AxisAlignedBB genBox) {
        this.gen();
        if (this.hasOffset) {
            genBox.field_72340_a -= (double)this.offset.x;
            genBox.field_72338_b -= (double)this.offset.y;
            genBox.field_72339_c -= (double)this.offset.z;
            genBox.field_72336_d -= (double)this.offset.x;
            genBox.field_72337_e -= (double)this.offset.y;
            genBox.field_72334_f -= (double)this.offset.z;
        }

    }

    public void prepareBB(AxisAlignedBB genBox) {
        this.gen();
        if (this.hasOffset) {
            genBox.field_72340_a += (double)this.offset.x;
            genBox.field_72338_b += (double)this.offset.y;
            genBox.field_72339_c += (double)this.offset.z;
            genBox.field_72336_d += (double)this.offset.x;
            genBox.field_72337_e += (double)this.offset.y;
            genBox.field_72334_f += (double)this.offset.z;
        }

    }

    public void setBlock(Block b) {
        this.gen();
        this.setTo = b;
        this.genMetadata = 0;
    }

    public void setMeta(int i) {
        this.gen();
        this.genMetadata = i;
    }

    public void randomiseCuboid(AxisAlignedBB genBox, Pair<Block, Integer>... pairs) {
        this.gen();
        this.prepareBB(genBox);
        int x = MathHelper.func_76128_c(genBox.field_72340_a);
        int y = MathHelper.func_76128_c(genBox.field_72338_b);
        int z = MathHelper.func_76128_c(genBox.field_72339_c);
        int eX = MathHelper.func_76128_c(genBox.field_72336_d);
        int eY = MathHelper.func_76128_c(genBox.field_72337_e);
        int eZ = MathHelper.func_76128_c(genBox.field_72334_f);

        for(int dx = x; dx <= eX; ++dx) {
            for(int dy = y; dy <= eY; ++dy) {
                for(int dz = z; dz <= eZ; ++dz) {
                    int i = this.worldObj.field_73012_v.nextInt(pairs.length);
                    if (this.worldObj.func_147439_a(dx, dy, dz) == this.setTo) {
                        this.worldObj.func_147465_d(dx, dy, dz, (Block)pairs[i].obj1, (Integer)pairs[i].obj2, this.flag);
                    }
                }
            }
        }

        this.restoreBB(genBox);
    }

    public void addFullSphere(AxisAlignedBB genBox) {
        this.gen();
        genBox = normaliseBB(genBox);
        this.prepareBB(genBox);
        double radiusX = (genBox.field_72336_d - genBox.field_72340_a) / (double)2.0F;
        double radiusY = (genBox.field_72337_e - genBox.field_72338_b) / (double)2.0F;
        double radiusZ = (genBox.field_72334_f - genBox.field_72339_c) / (double)2.0F;
        int dx = MathHelper.func_76128_c(genBox.field_72340_a + radiusX);
        int dy = MathHelper.func_76128_c(genBox.field_72338_b + radiusY);
        int dz = MathHelper.func_76128_c(genBox.field_72339_c + radiusZ);
        double invRadiusX = (double)1.0F / radiusX;
        double invRadiusY = (double)1.0F / radiusY;
        double invRadiusZ = (double)1.0F / radiusZ;
        int ceilRadiusX = (int)Math.ceil(radiusX);
        int ceilRadiusY = (int)Math.ceil(radiusY);
        int ceilRadiusZ = (int)Math.ceil(radiusZ);
        double nextXn = (double)0.0F;
        boolean filled = true;

        label51:
        for(int x = 0; x <= ceilRadiusX; ++x) {
            double xn = nextXn;
            nextXn = (double)(x + 1) * invRadiusX;
            double nextYn = (double)0.0F;

            for(int y = 0; y <= ceilRadiusY; ++y) {
                double yn = nextYn;
                nextYn = (double)(y + 1) * invRadiusY;
                double nextZn = (double)0.0F;

                for(int z = 0; z <= ceilRadiusZ; ++z) {
                    double zn = nextZn;
                    nextZn = (double)(z + 1) * invRadiusZ;
                    double distanceSq = lengthSq(xn, yn, zn);
                    if (distanceSq > (double)1.0F) {
                        if (z == 0) {
                            if (y == 0) {
                                break label51;
                            }
                            continue label51;
                        }
                        break;
                    }

                    if (filled || !(lengthSq(nextXn, yn, zn) <= (double)1.0F) || !(lengthSq(xn, nextYn, zn) <= (double)1.0F) || !(lengthSq(xn, yn, nextZn) <= (double)1.0F)) {
                        this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz + z)));
                        this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz + z)));
                        this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy - y)), MathHelper.func_76141_d((float)(dz + z)));
                        this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz - z)));
                        this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy - y)), MathHelper.func_76141_d((float)(dz + z)));
                        this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy - y)), MathHelper.func_76141_d((float)(dz - z)));
                        this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz - z)));
                        this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy - y)), MathHelper.func_76141_d((float)(dz - z)));
                    }
                }
            }
        }

        this.restoreBB(genBox);
    }

    public void addHollowCylinder(AxisAlignedBB genBox) {
        this.gen();
        genBox = normaliseBB(genBox);
        this.prepareBB(genBox);
        double radiusX = (genBox.field_72336_d - genBox.field_72340_a) / (double)2.0F;
        double height = genBox.field_72337_e - genBox.field_72338_b;
        double radiusZ = (genBox.field_72334_f - genBox.field_72339_c) / (double)2.0F;
        int dx = MathHelper.func_76128_c(genBox.field_72340_a + radiusX);
        int dy = MathHelper.func_76128_c(genBox.field_72338_b);
        int dz = MathHelper.func_76128_c(genBox.field_72339_c + radiusZ);
        boolean filled = false;
        radiusX += (double)0.5F;
        radiusZ += (double)0.5F;
        if (height != (double)0.0F) {
            if (height < (double)0.0F) {
                height = -height;
                dy = MathHelper.func_76128_c(-height);
            }

            if (dy < 0) {
                dy = 0;
            } else if ((double)dy + height - (double)1.0F > (double)this.worldObj.func_72940_L()) {
                height = (double)(this.worldObj.func_72940_L() - dy + 1);
            }

            double invRadiusX = (double)1.0F / radiusX;
            double invRadiusZ = (double)1.0F / radiusZ;
            int ceilRadiusX = (int)Math.ceil(radiusX);
            int ceilRadiusZ = (int)Math.ceil(radiusZ);
            double nextXn = (double)0.0F;

            label59:
            for(int x = 0; x <= ceilRadiusX; ++x) {
                double xn = nextXn;
                nextXn = (double)(x + 1) * invRadiusX;
                double nextZn = (double)0.0F;

                for(int z = 0; z <= ceilRadiusZ; ++z) {
                    double zn = nextZn;
                    nextZn = (double)(z + 1) * invRadiusZ;
                    double distanceSq = lengthSq(xn, zn);
                    if (distanceSq > (double)1.0F) {
                        if (z == 0) {
                            break label59;
                        }
                        break;
                    }

                    if (filled || !(lengthSq(nextXn, zn) <= (double)1.0F) || !(lengthSq(xn, nextZn) <= (double)1.0F)) {
                        for(int y = 0; (double)y < height; ++y) {
                            this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz + z)));
                            this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz + z)));
                            this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz - z)));
                            this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz - z)));
                        }
                    }
                }
            }

            this.restoreBB(genBox);
        }
    }

    public void addFullCylinder(AxisAlignedBB genBox) {
        this.gen();
        genBox = normaliseBB(genBox);
        this.prepareBB(genBox);
        double radiusX = (genBox.field_72336_d - genBox.field_72340_a) / (double)2.0F;
        double height = genBox.field_72337_e - genBox.field_72338_b;
        double radiusZ = (genBox.field_72334_f - genBox.field_72339_c) / (double)2.0F;
        int dx = MathHelper.func_76128_c(genBox.field_72340_a + radiusX);
        int dy = MathHelper.func_76128_c(genBox.field_72338_b);
        int dz = MathHelper.func_76128_c(genBox.field_72339_c + radiusZ);
        boolean filled = true;
        radiusX += (double)0.5F;
        radiusZ += (double)0.5F;
        if (height != (double)0.0F) {
            if (height < (double)0.0F) {
                height = -height;
                dy = MathHelper.func_76128_c(-height);
            }

            if (dy < 0) {
                dy = 0;
            } else if ((double)dy + height - (double)1.0F > (double)this.worldObj.func_72940_L()) {
                height = (double)(this.worldObj.func_72940_L() - dy + 1);
            }

            double invRadiusX = (double)1.0F / radiusX;
            double invRadiusZ = (double)1.0F / radiusZ;
            int ceilRadiusX = (int)Math.ceil(radiusX);
            int ceilRadiusZ = (int)Math.ceil(radiusZ);
            double nextXn = (double)0.0F;

            label59:
            for(int x = 0; x <= ceilRadiusX; ++x) {
                double xn = nextXn;
                nextXn = (double)(x + 1) * invRadiusX;
                double nextZn = (double)0.0F;

                for(int z = 0; z <= ceilRadiusZ; ++z) {
                    double zn = nextZn;
                    nextZn = (double)(z + 1) * invRadiusZ;
                    double distanceSq = lengthSq(xn, zn);
                    if (distanceSq > (double)1.0F) {
                        if (z == 0) {
                            break label59;
                        }
                        break;
                    }

                    if (filled || !(lengthSq(nextXn, zn) <= (double)1.0F) || !(lengthSq(xn, nextZn) <= (double)1.0F)) {
                        for(int y = 0; (double)y < height; ++y) {
                            this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz + z)));
                            this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz + z)));
                            this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz - z)));
                            this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz - z)));
                        }
                    }
                }
            }

            this.restoreBB(genBox);
        }
    }

    public void addHollowSphere(AxisAlignedBB genBox) {
        this.gen();
        genBox = normaliseBB(genBox);
        this.prepareBB(genBox);
        double radiusX = (genBox.field_72336_d - genBox.field_72340_a) / (double)2.0F;
        double radiusY = (genBox.field_72337_e - genBox.field_72338_b) / (double)2.0F;
        double radiusZ = (genBox.field_72334_f - genBox.field_72339_c) / (double)2.0F;
        int dx = MathHelper.func_76128_c(genBox.field_72340_a + radiusX);
        int dy = MathHelper.func_76128_c(genBox.field_72338_b + radiusY);
        int dz = MathHelper.func_76128_c(genBox.field_72339_c + radiusZ);
        double invRadiusX = (double)1.0F / radiusX;
        double invRadiusY = (double)1.0F / radiusY;
        double invRadiusZ = (double)1.0F / radiusZ;
        int ceilRadiusX = (int)Math.ceil(radiusX);
        int ceilRadiusY = (int)Math.ceil(radiusY);
        int ceilRadiusZ = (int)Math.ceil(radiusZ);
        double nextXn = (double)0.0F;
        boolean filled = false;

        label51:
        for(int x = 0; x <= ceilRadiusX; ++x) {
            double xn = nextXn;
            nextXn = (double)(x + 1) * invRadiusX;
            double nextYn = (double)0.0F;

            for(int y = 0; y <= ceilRadiusY; ++y) {
                double yn = nextYn;
                nextYn = (double)(y + 1) * invRadiusY;
                double nextZn = (double)0.0F;

                for(int z = 0; z <= ceilRadiusZ; ++z) {
                    double zn = nextZn;
                    nextZn = (double)(z + 1) * invRadiusZ;
                    double distanceSq = lengthSq(xn, yn, zn);
                    if (distanceSq > (double)1.0F) {
                        if (z == 0) {
                            if (y == 0) {
                                break label51;
                            }
                            continue label51;
                        }
                        break;
                    }

                    if (filled || !(lengthSq(nextXn, yn, zn) <= (double)1.0F) || !(lengthSq(xn, nextYn, zn) <= (double)1.0F) || !(lengthSq(xn, yn, nextZn) <= (double)1.0F)) {
                        this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz + z)));
                        this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz + z)));
                        this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy - y)), MathHelper.func_76141_d((float)(dz + z)));
                        this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz - z)));
                        this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy - y)), MathHelper.func_76141_d((float)(dz + z)));
                        this.block(MathHelper.func_76141_d((float)(dx + x)), MathHelper.func_76141_d((float)(dy - y)), MathHelper.func_76141_d((float)(dz - z)));
                        this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy + y)), MathHelper.func_76141_d((float)(dz - z)));
                        this.block(MathHelper.func_76141_d((float)(dx - x)), MathHelper.func_76141_d((float)(dy - y)), MathHelper.func_76141_d((float)(dz - z)));
                    }
                }
            }
        }

        this.restoreBB(genBox);
    }

    public void addWallsCuboid(AxisAlignedBB genBox) {
        this.gen();
        this.addCuboid(AxisAlignedBB.func_72330_a(genBox.field_72340_a, genBox.field_72338_b, genBox.field_72339_c, genBox.field_72336_d, genBox.field_72338_b, genBox.field_72334_f));
        this.addCuboid(AxisAlignedBB.func_72330_a(genBox.field_72340_a, genBox.field_72337_e, genBox.field_72339_c, genBox.field_72336_d, genBox.field_72337_e, genBox.field_72334_f));
        this.addCuboid(AxisAlignedBB.func_72330_a(genBox.field_72340_a, genBox.field_72338_b, genBox.field_72339_c, genBox.field_72340_a, genBox.field_72337_e, genBox.field_72334_f));
        this.addCuboid(AxisAlignedBB.func_72330_a(genBox.field_72336_d, genBox.field_72338_b, genBox.field_72339_c, genBox.field_72336_d, genBox.field_72337_e, genBox.field_72334_f));
        this.addCuboid(AxisAlignedBB.func_72330_a(genBox.field_72340_a, genBox.field_72338_b, genBox.field_72339_c, genBox.field_72336_d, genBox.field_72337_e, genBox.field_72339_c));
        this.addCuboid(AxisAlignedBB.func_72330_a(genBox.field_72340_a, genBox.field_72338_b, genBox.field_72334_f, genBox.field_72336_d, genBox.field_72337_e, genBox.field_72334_f));
    }

    public boolean block(int x, int y, int z) {
        this.gen();
        return this.worldObj.func_147465_d(x, y, z, this.setTo, this.genMetadata, this.flag);
    }

    public void addCuboid(AxisAlignedBB genBox) {
        this.gen();
        this.prepareBB(genBox);
        int x = MathHelper.func_76128_c(genBox.field_72340_a);
        int y = MathHelper.func_76128_c(genBox.field_72338_b);
        int z = MathHelper.func_76128_c(genBox.field_72339_c);
        int eX = MathHelper.func_76128_c(genBox.field_72336_d);
        int eY = MathHelper.func_76128_c(genBox.field_72337_e);
        int eZ = MathHelper.func_76128_c(genBox.field_72334_f);
        this.addCuboid(x, y, z, eX, eY, eZ);
        this.restoreBB(genBox);
    }

    public void addCuboid(int x, int y, int z, int eX, int eY, int eZ) {
        this.gen();

        for(int dx = x; dx <= eX; ++dx) {
            for(int dy = y; dy <= eY; ++dy) {
                for(int dz = z; dz <= eZ; ++dz) {
                    this.block(dx, dy, dz);
                }
            }
        }

    }

    private static double lengthSq(double x, double y, double z) {
        return x * x + y * y + z * z;
    }

    private static double lengthSq(double x, double z) {
        return x * x + z * z;
    }
}
