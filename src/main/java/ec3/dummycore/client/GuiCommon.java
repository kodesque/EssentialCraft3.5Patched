package ec3.dummycore.client;

import DummyCore.Client.GuiElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class GuiCommon extends GuiContainer {

    public List<GuiElement> elementList;
    public TileEntity genericTile;
    public ResourceLocation guiGenLocation;
    public ResourceLocation slotLocation;

    public GuiCommon(Container c) {
        super(c);
        this.elementList = new ArrayList();
        this.guiGenLocation = new ResourceLocation("textures/gui/container/dispenser.png");
        this.slotLocation = new ResourceLocation("textures/gui/container/dispenser.png");
    }

    public GuiCommon(Container c, TileEntity tile) {
        this(c);
        this.genericTile = tile;
    }

    protected void drawGuiContainerBackgroundLayer(float f1, int i1, int i2) {
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.mc.renderEngine.bindTexture(guiGenLocation);
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(k+60, l+16, 6, 6, 28, 54);
        this.drawTexturedModalRect(k+88, l+16, 6, 6, 28, 54);

        for(int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i)
        {
            Slot slt = (Slot) this.inventorySlots.inventorySlots.get(i);
            renderSlot(slt);
            GL11.glColor3f(1, 1, 1);
        }

        for(int i = 0; i < this.elementList.size(); ++i)
        {
            GuiElement element = elementList.get(i);
            Minecraft.getMinecraft().renderEngine.bindTexture(element.getElementTexture());
            element.draw(k+element.getX(),l+element.getY());
            GL11.glColor3f(1, 1, 1);
        }

    }

    public void renderSlot(Slot slt)
    {
        GL11.glColor3f(1, 1, 1);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.mc.renderEngine.bindTexture(slotLocation);
        this.drawTexturedModalRect(k+slt.xDisplayPosition-1, l+slt.yDisplayPosition-1, 7, 83, 18, 18);
    }
}
