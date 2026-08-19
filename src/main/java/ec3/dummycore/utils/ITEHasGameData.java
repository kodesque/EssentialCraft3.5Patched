package ec3.dummycore.utils;

import DummyCore.Utils.Coord3D;
import DummyCore.Utils.DummyData;

public interface ITEHasGameData {
    String getData();

    void setData(DummyData[] var1);

    Coord3D getPosition();
}

