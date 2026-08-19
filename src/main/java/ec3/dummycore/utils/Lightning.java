package ec3.dummycore.utils;

import DummyCore.Utils.Coord3D;
import DummyCore.Utils.MathUtils;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class Lightning {
    public Random rnd;
    public Coord3D[] lightningVecsStart;
    public Coord3D[] lightningVecsEnd;
    public Coord3D start;
    public Coord3D end;
    public float renderTicksExisted;
    public float[] getLightningColor = new float[3];

    public Lightning(Random rand, Coord3D begin, Coord3D stop, float curve, float... color) {
        this.rnd = rand;
        this.start = begin;
        this.end = stop;
        this.getLightningColor = color;
        this.curve(curve);
    }

    private void curve(float factor) {
        float distX = this.end.x - this.start.x;
        float distY = this.end.y - this.start.y;
        float distZ = this.end.z - this.start.z;
        float genDistance = (float)Math.sqrt((double)(distX * distX + distY * distY + distZ * distZ));
        this.lightningVecsStart = new Coord3D[64];
        this.lightningVecsEnd = new Coord3D[64];
        this.generateLightningBetween2Points(this.start, this.end, 0, 8, factor);
        this.generateLightningBetween2Points(this.lightningVecsStart[3], new Coord3D(this.end.x * factor * 10.0F, this.end.y, this.end.z * factor * 10.0F), 8, 4, factor * 3.0F);
        int genIndex = 0;

        for(int i = 0; i < 12; ++i) {
            int rndSteps = this.rnd.nextInt(2);
            genIndex += 1 + rndSteps;
            this.generateLightningBetween2Points(this.lightningVecsStart[i], new Coord3D(this.lightningVecsStart[i].x + MathUtils.randomFloat(this.rnd) * (genDistance / 4.0F), this.lightningVecsStart[i].y + MathUtils.randomFloat(this.rnd) * (genDistance / 4.0F), this.lightningVecsStart[i].z + MathUtils.randomFloat(this.rnd) * (genDistance / 4.0F)), 12 + i, 1 + rndSteps, factor / 2.0F);
        }

        for(int i = 12; i < 12 + genIndex; ++i) {
            if (this.lightningVecsStart[i] != null) {
                this.generateLightningBetween2Points(this.lightningVecsStart[i], new Coord3D(this.lightningVecsStart[i].x + MathUtils.randomFloat(this.rnd) * (genDistance / 8.0F), this.lightningVecsStart[i].y + MathUtils.randomFloat(this.rnd) * (genDistance / 8.0F), this.lightningVecsStart[i].z + MathUtils.randomFloat(this.rnd) * (genDistance / 8.0F)), 12 + genIndex + i, 0, factor);
            }
        }

    }

    private void generateLightningBetween2Points(Coord3D from, Coord3D to, int beginVecIndex, int steps, float curve) {
        float distX = to.x - from.x;
        float distY = to.y - from.y;
        float distZ = to.z - from.z;

        for(int i = 0; i < steps; ++i) {
            if (i == 0) {
                this.lightningVecsStart[beginVecIndex + i] = from;
                this.lightningVecsEnd[beginVecIndex + i] = new Coord3D(this.lightningVecsStart[beginVecIndex + i].x + distX / (float)steps + MathUtils.randomFloat(this.rnd) * curve, this.lightningVecsStart[beginVecIndex + i].y + distY / (float)steps + MathUtils.randomFloat(this.rnd) * curve, this.lightningVecsStart[beginVecIndex + i].z + distZ / (float)steps + MathUtils.randomFloat(this.rnd) * curve);
            } else {
                this.lightningVecsStart[beginVecIndex + i] = this.lightningVecsEnd[beginVecIndex + i - 1];
                this.lightningVecsEnd[beginVecIndex + i] = new Coord3D(this.lightningVecsStart[beginVecIndex + i].x + distX / (float)steps + MathUtils.randomFloat(this.rnd) * curve, this.lightningVecsStart[beginVecIndex + i].y + distY / (float)steps + MathUtils.randomFloat(this.rnd) * curve, this.lightningVecsStart[beginVecIndex + i].z + distZ / (float)steps + MathUtils.randomFloat(this.rnd) * curve);
            }
        }

    }

    public void render(double x, double y, double z, float partialTicks) {
        this.renderTicksExisted += partialTicks / 1.0F;
        if (this.renderTicksExisted >= (float)this.lightningVecsStart.length) {
            this.renderTicksExisted = (float)this.lightningVecsStart.length;
        }

        GL11.glPushMatrix();
        GL11.glEnable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glTranslated(x, y, z);

        for(int i = 0; (float)i < this.renderTicksExisted; ++i) {
            if (this.lightningVecsStart[i] != null) {
                this.renderBeam(this.lightningVecsStart[i], this.lightningVecsEnd[i], 0.8F);
                this.renderBeam(this.lightningVecsStart[i], this.lightningVecsEnd[i], 1.0F);
            }
        }

        GL11.glEnable(2896);
        GL11.glEnable(3553);
        GL11.glPopMatrix();
    }

    public void renderBeam(Coord3D begin, Coord3D stop, float type) {
        if (type != 1.0F) {
            GL11.glLineWidth(3.0F);
        } else {
            GL11.glLineWidth(1.0F);
        }

        GL11.glPushMatrix();
        GL11.glAlphaFunc(516, 0.1F);
        GL11.glEnable(3042);
        GL11.glShadeModel(7425);
        GL11.glEnable(2884);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glBegin(1);
        if (type != 1.0F) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.2F);
        } else {
            GL11.glColor4f(this.getLightningColor[0], this.getLightningColor[1], this.getLightningColor[2], 0.8F);
        }

        GL11.glVertex3d((double)begin.x, (double)begin.y, (double)begin.z);
        GL11.glVertex3d((double)stop.x, (double)stop.y, (double)stop.z);
        GL11.glColor3d((double)1.0F, (double)1.0F, (double)1.0F);
        GL11.glEnd();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glDisable(2884);
        GL11.glPopMatrix();
    }
}
