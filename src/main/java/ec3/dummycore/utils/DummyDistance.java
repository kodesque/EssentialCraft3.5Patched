package ec3.dummycore.utils;

import DummyCore.Utils.Coord2D;
import DummyCore.Utils.Coord3D;
import DummyCore.Utils.MathUtils;

public class DummyDistance {
    private final float distance;

    public DummyDistance() {
        this.distance = 0.0F;
    }

    public DummyDistance(Coord3D first, Coord3D second) {
        float diffX = MathUtils.getDifference(first.x, second.x);
        float diffY = MathUtils.getDifference(first.y, second.y);
        float diffZ = MathUtils.getDifference(first.z, second.z);
        this.distance = (float)Math.sqrt((double)(diffX * diffX + diffY * diffY + diffZ * diffZ));
    }

    public DummyDistance(DummyCore.Utils.Coord2D first, Coord2D second) {
        float diffX = MathUtils.getDifference(first.x, second.x);
        float diffZ = MathUtils.getDifference(first.z, second.z);
        this.distance = (float)Math.sqrt((double)(diffX * diffX + diffZ * diffZ));
    }

    public DummyDistance(float first, float second) {
        this.distance = MathUtils.getDifference(first, second);
    }

    public float getDistance() {
        return this.distance;
    }
}
