package ec3.dummycore.utils;

import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IAttributeModifier {
    String getType(ItemStack var1, EntityPlayer var2);

    double getValue(ItemStack var1, EntityPlayer var2);

    IAttribute getAttribute(ItemStack var1, EntityPlayer var2);

    String last5OfUUID(ItemStack var1, EntityPlayer var2);

    int getOperation(ItemStack var1, EntityPlayer var2);
}
