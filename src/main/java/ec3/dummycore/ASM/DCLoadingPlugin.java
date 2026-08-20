package ec3.dummycore.ASM;

import java.io.File;
import java.util.Map;

import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import ec3.dummycore.core.Core;

// @MCVersion(value = mcVersion)
public class DCLoadingPlugin implements IFMLLoadingPlugin {

    public DCLoadingPlugin() {
        Core.mcDir = (File) FMLInjectionData.data()[6];
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[] { DCASMManager.class.getName() };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

}
