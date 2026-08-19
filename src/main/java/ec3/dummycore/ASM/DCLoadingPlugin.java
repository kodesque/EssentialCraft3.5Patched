package ec3.dummycore.ASM;

import DummyCore.ASM.DCASMManager;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

public class DCLoadingPlugin implements IFMLLoadingPlugin {
    public DCLoadingPlugin() {
    }

    public String[] getASMTransformerClass() {
        return new String[]{DCASMManager.class.getName()};
    }

    public String getModContainerClass() {
        return null;
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> data) {
    }

    public String getAccessTransformerClass() {
        return null;
    }
}
