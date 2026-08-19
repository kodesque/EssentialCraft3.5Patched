package ec3.dummycore.utils;

public class DummyBounds {
    private final float min;
    private final float max;

    public DummyBounds(float m1, float m2) {
        this.min = m1;
        this.max = m2;
    }

    public boolean isInRange(float f) {
        return f > this.min && f < this.max;
    }
}
