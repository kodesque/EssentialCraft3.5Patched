package ec3.dummycore.client;

import DummyCore.Client.MainMenuRegistry;
import DummyCore.Utils.DummyData;
import cpw.mods.fml.client.GuiScrollingList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;

public class GuiSlotMenuList extends GuiScrollingList {
    private GuiMenuList parent;

    public GuiSlotMenuList(GuiMenuList parent, int listWidth) {
        super(Minecraft.getMinecraft(), listWidth, parent.height, 32, parent.height - 66 + 4, 10, 35);
        this.parent = parent;
    }

    protected int getSize() {
        return MainMenuRegistry.menuList.size();
    }

    protected void elementClicked(int var1, boolean var2) {
        this.parent.selectIndex(var1);
    }

    protected boolean isSelected(int var1) {
        return this.parent.indexSelected(var1);
    }

    protected void drawBackground() {
        this.parent.drawDefaultBackground();
    }

    protected int getContentHeight() {
        return this.getSize() * 35 + 1;
    }

    protected void drawSlot(int listIndex, int var2, int var3, int var4, Tessellator var5) {
        DummyData data = (DummyData)MainMenuRegistry.menuInfoLst.get(listIndex);
        this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(data.fieldName, this.listWidth - 10), this.left + 3, var3 + 2, 16777215);
        this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(data.fieldValue, this.listWidth - 10), this.left + 3, var3 + 12, 13421772);
    }
}
