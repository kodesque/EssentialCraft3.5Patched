package ec3.client.guielement.general;

import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import ec3.api.mru.ITEHasMRU;
import ec3.root.EssentialCraftCore;
import ec3.utils.dummycore.client.GuiElement;
import ec3.utils.dummycore.utils.math.MathUtils;
import ec3.utils.dummycore.utils.MiscUtils;

public class GuiMRUStorage extends GuiElement {

    private ResourceLocation rec = new ResourceLocation("essentialcraft", "textures/gui/mruStorage.png");

    public int x;
    public int y;
    public ITEHasMRU tile;

    public GuiMRUStorage(int i, int j, ITEHasMRU t) {
        x = i;
        y = j;
        tile = t;
    }

    @Override
    public ResourceLocation getElementTexture() {

        return rec;
    }

    @Override
    public void draw(int posX, int posY) {
        this.drawTexturedModalRect(posX, posY, 0, 0, 18, 72);
        int percentageScaled = MathUtils.pixelatedTextureSize(tile.getMRU(), tile.getMaxMRU(), 72);
        IIcon icon = (IIcon) EssentialCraftCore.proxy.getClientIcon("mru");
        MiscUtils.drawTexture(posX + 1, posY - 1 + (74 - percentageScaled), icon, 16, percentageScaled - 2, 0);
    }

    @Override
    public int getX() {

        return x;
    }

    @Override
    public int getY() {

        return y;
    }

}
