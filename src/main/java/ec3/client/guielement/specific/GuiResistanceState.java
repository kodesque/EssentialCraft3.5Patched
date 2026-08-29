package ec3.client.guielement.specific;

import ec3.client.guielement.general.GuiTextField;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import ec3.common.tile.storage.TileChamberController;
import ec3.common.tile.storage.TileChamberStateChecker;

public class GuiResistanceState extends GuiTextField {

    public TileEntity tile;

    public GuiResistanceState(int i, int j, TileEntity t) {
        super(i, j);
        tile = t;
    }

    @Override
    public ResourceLocation getElementTexture() {

        return super.getElementTexture();
    }

    @Override
    public void draw(int posX, int posY) {
        super.draw(posX, posY);
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
        if (tile instanceof TileChamberStateChecker) {
            TileChamberController controllerTile = (TileChamberController) ((TileChamberStateChecker) tile).structureController();
            if (controllerTile != null) Minecraft.getMinecraft().fontRenderer
                .drawString(controllerTile.resistance + " MROV", posX + 2, posY + 5, 0xffffff, true);
        }
    }

}
