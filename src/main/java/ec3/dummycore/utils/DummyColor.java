package ec3.dummycore.utils;

import DummyCore.Utils.MathUtils;

public class DummyColor {
    private int[] color = new int[3];

    public DummyColor(int red, int green, int blue) {
        this.color[0] = red;
        this.color[1] = green;
        this.color[2] = blue;
    }

    public int getRed() {
        return this.color[0];
    }

    public int getGreen() {
        return this.color[1];
    }

    public int getBlue() {
        return this.color[2];
    }

    public int getColorInHex() {
        int ret = 0;
        int rHex = MathUtils.convertToHex(this.getRed());
        int gHex = MathUtils.convertToHex(this.getGreen());
        int bHex = MathUtils.convertToHex(this.getBlue());
        rHex *= 10000;
        gHex *= 100;
        ret = rHex + gHex + bHex;
        return ret;
    }
}
