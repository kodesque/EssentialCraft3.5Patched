package ec3.common.init;

import net.minecraftforge.common.DimensionManager;

import ec3.api.config.Config;
import ec3.common.world.hoanna.WorldProviderHoanna;

public class ECDimensions {

    public static ECDimensions core;

    public void registerDimensionMagic() {
        DimensionManager.registerProviderType(Config.dimensionID, WorldProviderHoanna.class, false);
        DimensionManager.registerDimension(Config.dimensionID, Config.dimensionID);
    }

}
