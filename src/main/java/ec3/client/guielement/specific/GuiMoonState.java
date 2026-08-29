package ec3.client.guielement.specific;

import ec3.client.guielement.general.GuiTextField;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import ec3.utils.dummycore.utils.MiscUtils;

public class GuiMoonState extends GuiTextField {

    public GuiMoonState(int i, int j) {
        super(i, j);
    }

    @Override
    public ResourceLocation getElementTexture() {

        return super.getElementTexture();
    }

    @Override
    public void draw(int posX, int posY) {
        this.drawTexturedModalRect(posX, posY, 0, 0, 18, 18);
        MiscUtils.bindTexture("essentialcraft", "textures/gui/gui_moon_phases.png");
        int moonPhase = Minecraft.getMinecraft().theWorld.getMoonPhase();
        this.drawTexturedModalRect(posX + 1, posY + 1, 16 * moonPhase, 0, 16, 16);
        drawText(posX, posY);
    }

    @Override
    public int getX() {

        return super.getX();
    }

    @Override
    public int getY() {

        return super.getY();
    }

    @Override
    public void drawText(int posX, int posY) {

    }

}
