package ec3.dummycore.client;

import DummyCore.Client.MainMenuRegistry;
import DummyCore.Utils.DummyConfig;
import DummyCore.Utils.DummyData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import org.lwjgl.opengl.GL11;

public class GuiMenuList extends GuiScreen {
    private GuiScreen mainMenu;
    private ec3.dummycore.client.GuiSlotMenuList modList;
    private int selected = -1;
    private Class<?> selectedMod;
    private int listWidth;

    public GuiMenuList(GuiScreen mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void initGui() {
        for(DummyData data : MainMenuRegistry.menuInfoLst) {
            this.listWidth = Math.max(this.listWidth, this.getFontRenderer().getStringWidth(data.fieldName) + 10);
            this.listWidth = Math.max(this.listWidth, this.getFontRenderer().getStringWidth(data.fieldValue) + 10);
        }

        this.listWidth = Math.min(this.listWidth, 150);
        this.buttonList.add(new GuiButton(6, this.width  / 2 - 75, this.height  - 38, I18n.format("gui.done")));
        this.modList = new GuiSlotMenuList(this, this.listWidth);
        this.modList.registerScrollButtons(this.buttonList, 7, 8);
    }

    protected void actionPerformed(GuiButton button) {
        if (button.enabled) {
            switch (button.id) {
                case 6:
                    this.mc.displayGuiScreen(this.mainMenu);
                    return;
            }
        }

        super.actionPerformed(button);
    }

    public int drawLine(String line, int offset, int shifty) {
        this.fontRendererObj.drawString(line, offset, shifty, 14151146);
        return shifty + 10;
    }

    public void func_73863_a(int p_571_1_, int p_571_2_, float p_571_3_) {
        this.modList.drawScreen(p_571_1_, p_571_2_, p_571_3_);
        this.drawCenteredString(this.fontRendererObj, "Menu List", this.width / 2, 16, 16777215);
        int offset = this.listWidth + 20;
        if (this.selectedMod != null) {
            DummyData data = (DummyData)MainMenuRegistry.menuInfoLst.get(this.selected);
            GL11.glEnable(3042);
            offset = (this.listWidth + this.width ) / 2;
            this.drawCenteredString(this.fontRendererObj, data.fieldName, offset, 35, 16777215);
            this.drawCenteredString(this.fontRendererObj, data.fieldValue, offset, 45, 16777215);
            GL11.glDisable(3042);
        }

        super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
    }

    Minecraft getMinecraftInstance() {
        return this.mc;
    }

    FontRenderer getFontRenderer() {
        return this.getFontRenderer();
    }

    public void selectIndex(int var1) {
        this.selected = var1;
        if (var1 >= 0 && var1 <= MainMenuRegistry.menuList.size()) {
            this.selectedMod = (Class)MainMenuRegistry.menuList.get(this.selected);
        } else {
            this.selectedMod = null;
        }

        DummyConfig.setMainMenu(this.selected);
    }

    public boolean indexSelected(int var1) {
        return var1 == this.selected;
    }
}

