package ec3.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import ec3.common.init.ECItems;
import ec3.utils.dummycore.utils.MiscUtils;

public class GunItemRenderHelper implements IItemRenderer {

    protected static RenderItem itemRender = new RenderItem();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {

        return type == ItemRenderType.INVENTORY;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        itemRender.renderItemIntoGUI(
            Minecraft.getMinecraft().fontRenderer,
            Minecraft.getMinecraft().renderEngine,
            item,
            0,
            0,
            true);
        MiscUtils.bindTexture("essentialcraft", "textures/special/whitebox.png");
        GL11.glColor3f(0.058F, 0.058F, 0.058F);
        itemRender.renderIcon(14, 0, ECItems.genericItem.getIconFromDamage(2), 2, 14);
        GL11.glColor3f(0.2F, 0.2F, 0.1F);
        itemRender.renderIcon(14, 0, ECItems.genericItem.getIconFromDamage(2), 1, 13);
        GL11.glColor3f(0.73F, 0F, 0F);
        if (item.hasTagCompound()) {
            NBTTagCompound tag = MiscUtils.getStackTag(item);
            if (tag.hasKey("stats")) {
                float current = tag.getFloat("gunShots");
                float max = tag.getCompoundTag("stats")
                    .getFloat("shots");
                if (current > max) current = max;
                int textureOffset = MathHelper.floor_double(13 - current / max * 13D);
                itemRender
                    .renderIcon(14, textureOffset, ECItems.genericItem.getIconFromDamage(2), 1, 13 - textureOffset);
            }
        }
        GL11.glColor3f(1, 1, 1);
    }

}
