package ec3.dummycore.junk;

//public class GuiMenuList extends GuiScreen {
//    private GuiScreen mainMenu;
//    private GuiSlotMenuList modList;
//    private int selected = -1;
//    private Class<?> selectedMod;
//    private int listWidth;
//
//    public GuiMenuList(GuiScreen mainMenu) {
//        this.mainMenu = mainMenu;
//    }
//
//    public void func_73866_w_() {
//        for(DummyData data : MainMenuRegistry.menuInfoLst) {
//            this.listWidth = Math.max(this.listWidth, this.getFontRenderer().func_78256_a(data.fieldName) + 10);
//            this.listWidth = Math.max(this.listWidth, this.getFontRenderer().func_78256_a(data.fieldValue) + 10);
//        }
//
//        this.listWidth = Math.min(this.listWidth, 150);
//        this.field_146292_n.add(new GuiButton(6, this.field_146294_l / 2 - 75, this.field_146295_m - 38, I18n.func_135052_a("gui.done", new Object[0])));
//        this.modList = new GuiSlotMenuList(this, this.listWidth);
//        this.modList.registerScrollButtons(this.field_146292_n, 7, 8);
//    }
//
//    protected void func_146284_a(GuiButton button) {
//        if (button.field_146124_l) {
//            switch (button.field_146127_k) {
//                case 6:
//                    this.field_146297_k.func_147108_a(this.mainMenu);
//                    return;
//            }
//        }
//
//        super.func_146284_a(button);
//    }
//
//    public int drawLine(String line, int offset, int shifty) {
//        this.field_146289_q.func_78276_b(line, offset, shifty, 14151146);
//        return shifty + 10;
//    }
//
//    public void func_73863_a(int p_571_1_, int p_571_2_, float p_571_3_) {
//        this.modList.drawScreen(p_571_1_, p_571_2_, p_571_3_);
//        this.func_73732_a(this.field_146289_q, "Menu List", this.field_146294_l / 2, 16, 16777215);
//        int offset = this.listWidth + 20;
//        if (this.selectedMod != null) {
//            DummyData data = (DummyData)MainMenuRegistry.menuInfoLst.get(this.selected);
//            GL11.glEnable(3042);
//            offset = (this.listWidth + this.field_146294_l) / 2;
//            this.func_73732_a(this.field_146289_q, data.fieldName, offset, 35, 16777215);
//            this.func_73732_a(this.field_146289_q, data.fieldValue, offset, 45, 16777215);
//            GL11.glDisable(3042);
//        }
//
//        super.func_73863_a(p_571_1_, p_571_2_, p_571_3_);
//    }
//
//    Minecraft getMinecraftInstance() {
//        return this.field_146297_k;
//    }
//
//    FontRenderer getFontRenderer() {
//        return this.field_146289_q;
//    }
//
//    public void selectIndex(int var1) {
//        this.selected = var1;
//        if (var1 >= 0 && var1 <= MainMenuRegistry.menuList.size()) {
//            this.selectedMod = (Class)MainMenuRegistry.menuList.get(this.selected);
//        } else {
//            this.selectedMod = null;
//        }
//
//        DummyConfig.setMainMenu(this.selected);
//    }
//
//    public boolean indexSelected(int var1) {
//        return var1 == this.selected;
//    }
//}
