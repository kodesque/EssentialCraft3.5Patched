package ec3.dummycore.utils;

import DummyCore.Utils.DataStorage;
import DummyCore.Utils.DummyData;

public class Coord2D {
    public float x;
    public float z;

    public Coord2D(float i, float j) {
        this.x = i;
        this.z = j;
    }

    public Coord2D() {
        this(0.0F, 0.0F);
    }

    public String toString() {
        return "||x:" + this.x + "||z:" + this.z;
    }

    public static DummyCore.Utils.Coord2D fromString(String data) {
        DummyData[] dt = DataStorage.parseData(data);
        float cX = Float.parseFloat(dt[0].fieldValue);
        float cZ = Float.parseFloat(dt[1].fieldValue);
        return new DummyCore.Utils.Coord2D(cX, cZ);
    }
}
