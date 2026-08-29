package ec3.client.guielement.general;

import net.minecraft.util.ResourceLocation;

import ec3.utils.dummycore.client.GuiElement;

public abstract class GuiTextField extends GuiElement {

    private ResourceLocation rec = new ResourceLocation("essentialcraft", "textures/gui/slot_common.png");

    public int x;
    public int y;

    public GuiTextField(int i, int j) {
        x = i;
        y = j;
    }

    @Override
    public ResourceLocation getElementTexture() {

        return rec;
    }

    @Override
    public void draw(int posX, int posY) {
        this.drawTexturedModalRect(posX, posY, 0, 0, 17, 18);
        this.drawTexturedModalRect(posX + 17, posY, 1, 0, 16, 18);
        this.drawTexturedModalRect(posX + 17 + 16, posY, 1, 0, 16, 18);
        this.drawTexturedModalRect(posX + 17 + 32, posY, 1, 0, 16, 18);
        this.drawTexturedModalRect(posX + 17 + 48, posY, 1, 0, 17, 18);
        drawText(posX, posY);
    }

    public abstract void drawText(int posX, int posY);

    @Override
    public int getX() {

        return x;
    }

    @Override
    public int getY() {

        return y;
    }

}
