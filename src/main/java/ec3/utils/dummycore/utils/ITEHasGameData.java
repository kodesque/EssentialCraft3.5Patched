package ec3.utils.dummycore.utils;

import ec3.utils.dummycore.utils.data.DummyData;
import ec3.utils.dummycore.utils.math.Coord3D;

public interface ITEHasGameData {

    public abstract String getData();

    public abstract void setData(DummyData[] data);

    public abstract Coord3D getPosition();

}
