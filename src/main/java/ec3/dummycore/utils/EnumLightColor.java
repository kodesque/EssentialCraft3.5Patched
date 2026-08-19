package ec3.dummycore.utils;

import DummyCore.Utils.DummyColor;

public enum EnumLightColor {
    BLACK(51, 51, 51),
    RED(255, 51, 51),
    GREEN(51, 255, 51),
    BROWN(102, 51, 51),
    BLUE(51, 51, 255),
    PURPLE(255, 51, 255),
    CYAN(51, 153, 255),
    SILVER(153, 153, 153),
    GRAY(102, 102, 102),
    PINK(255, 102, 102),
    LIME(102, 255, 51),
    YELLOW(255, 255, 51),
    LIGHTBLUE(153, 153, 255),
    MAGENTA(255, 51, 204),
    ORANGE(255, 153, 51),
    WHITE(204, 204, 204);

    private DummyCore.Utils.DummyColor mainColor;
    private int colorID = 0;
    private static int globalID = -1;

    private EnumLightColor(int red, int green, int blue) {
        this.mainColor = new DummyCore.Utils.DummyColor(red, green, blue);
        this.colorID = this.setGlobal();
    }

    public DummyColor getColor() {
        return this.mainColor;
    }

    private int setGlobal() {
        return ++globalID;
    }

    public int getLightID() {
        return this.colorID;
    }
}
