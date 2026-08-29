package ec3.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import ec3.client.models.ModelSolarPrism;

public class RenderSolarPrismAsItem implements IItemRenderer {

    public static final ResourceLocation textures = new ResourceLocation(
        "essentialcraft:textures/special/models/solarPrism.png");
    public static final ModelSolarPrism prism = new ModelSolarPrism();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {

        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        if (type == ItemRenderType.INVENTORY) {
            GL11.glTranslatef(0, -1, 0);
            GL11.glScalef(0.6F, 1F, 0.6F);
        }
        prism.render(0.0625F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

}
