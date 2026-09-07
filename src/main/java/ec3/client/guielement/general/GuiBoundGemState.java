package ec3.client.guielement.general;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ResourceLocation;

import ec3.api.mru.ITEHasMRU;
import ec3.common.items.ItemBoundGem;
import ec3.utils.dummycore.utils.math.MathUtils;

public class GuiBoundGemState extends GuiTextField {

    public TileEntity tile;
    public int slotNum;

    public GuiBoundGemState(int i, int j, TileEntity t, int slot) {
        super(i, j);
        tile = t;
        slotNum = slot;
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
        IInventory inventory = (IInventory) tile;
        if (inventory.getStackInSlot(slotNum) == null || !(inventory.getStackInSlot(slotNum)
            .getItem() instanceof ItemBoundGem)) {
            Minecraft.getMinecraft().fontRenderer.drawString(
                new ChatComponentTranslation("essentialcraft.gui.bound.none").getFormattedText(),
                posX + 6,
                posY + 5,
                0xff0000,
                true);
        } else {
            if (inventory.getStackInSlot(slotNum)
                .getTagCompound() == null) {
                Minecraft.getMinecraft().fontRenderer.drawString(
                    new ChatComponentTranslation("essentialcraft.gui.bound.noconnection").getFormattedText(),
                    posX + 4,
                    posY + 5,
                    0xff0000,
                    true);
            } else {
                int o[] = ItemBoundGem.getCoords(inventory.getStackInSlot(slotNum));
                if (this.tile.getWorldObj()
                    .getTileEntity(o[0], o[1], o[2]) == null) {
                    Minecraft.getMinecraft().fontRenderer.drawString(
                        new ChatComponentTranslation("essentialcraft.gui.bound.notile").getFormattedText(),
                        posX + 5,
                        posY + 5,
                        0xff0000,
                        true);
                } else {
                    if (!(this.tile.getWorldObj()
                        .getTileEntity(o[0], o[1], o[2]) instanceof ITEHasMRU)) {
                        Minecraft.getMinecraft().fontRenderer.drawString(
                            new ChatComponentTranslation("essentialcraft.gui.bound.notmagical").getFormattedText(),
                            posX + 12,
                            posY + 5,
                            0xff0000,
                            true);
                    } else {
                        if (!(MathUtils.getDifference(tile.xCoord, o[0]) <= 16
                            && MathUtils.getDifference(tile.yCoord, o[1]) <= 16
                            && MathUtils.getDifference(tile.zCoord, o[2]) <= 16)) {
                            Minecraft.getMinecraft().fontRenderer.drawString(
                                new ChatComponentTranslation("essentialcraft.gui.bound.notinrange").getFormattedText(),
                                posX + 8,
                                posY + 5,
                                0xff0000,
                                true);
                        } else {
                            if (((ITEHasMRU) (tile.getWorldObj()
                                .getTileEntity(o[0], o[1], o[2]))).getMRU() <= 0) {
                                Minecraft.getMinecraft().fontRenderer.drawString(
                                    new ChatComponentTranslation("essentialcraft.gui.bound.noenergy")
                                        .getFormattedText(),
                                    posX + 6,
                                    posY + 5,
                                    0xff0000,
                                    true);
                            } else {
                                Minecraft.getMinecraft().fontRenderer.drawString(
                                    new ChatComponentTranslation("essentialcraft.gui.bound.working").getFormattedText(),
                                    posX + 22,
                                    posY + 5,
                                    0x00ff00,
                                    true);
                            }
                        }
                    }
                }
            }
        }
    }

}
