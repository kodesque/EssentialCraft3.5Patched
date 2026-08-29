package ec3.common.init.custom;

import net.minecraft.item.ItemStack;

import ec3.api.weapons.GunRegistry.GunMaterial;
import ec3.api.weapons.GunRegistry.LenseMaterial;
import ec3.api.weapons.GunRegistry.ScopeMaterial;
import ec3.common.items.ItemGenericEC;
import ec3.common.init.ECItems;

public class ECWeapons {

    public static void register() {
        new GunMaterial("mru").setRecipe(ItemGenericEC.getStkByName("magicalIngot"))
            .appendData("durability", 120)
            .appendData("damage", 8)
            .appendData("reload", 5)
            .appendData("knockback", 6)
            .appendData("spread", 3)
            .appendData("speed", 3)
            .appendData("shots", 2);

        new GunMaterial("pale").setRecipe(ItemGenericEC.getStkByName("paleIngot"))
            .appendData("durability", 160)
            .appendData("damage", 11)
            .appendData("reload", 8)
            .appendData("knockback", 2)
            .appendData("spread", 6)
            .appendData("speed", 1)
            .appendData("shots", 2);

        new GunMaterial("mithriline").setRecipe(ItemGenericEC.getStkByName("mithrilineIngot"))
            .appendData("durability", 300)
            .appendData("damage", 14)
            .appendData("reload", 12)
            .appendData("knockback", 12)
            .appendData("spread", 1)
            .appendData("speed", 6)
            .appendData("shots", 12);

        new GunMaterial("void").setRecipe(ItemGenericEC.getStkByName("voidPlating"))
            .appendData("durability", 1200)
            .appendData("damage", 18)
            .appendData("reload", 4)
            .appendData("knockback", 2)
            .appendData("spread", 6)
            .appendData("speed", 2)
            .appendData("shots", 8);

        new GunMaterial("demonic").setRecipe(ItemGenericEC.getStkByName("ackroniteIngot"))
            .appendData("durability", 3000)
            .appendData("damage", 26)
            .appendData("reload", 2)
            .appendData("knockback", 0)
            .appendData("spread", 1)
            .appendData("speed", 1)
            .appendData("shots", 20);

        new ScopeMaterial("mru", false).setRecipe(ItemGenericEC.getStkByName("magicPurifyedGlassAlloy"))
            .appendData("scope.zoom", 1.2F);

        new ScopeMaterial("mru", true).setRecipe(ItemGenericEC.getStkByName("magicalIngot"))
            .appendData("scope.zoom", 3F);
        new ScopeMaterial("pale", true).setRecipe(ItemGenericEC.getStkByName("paleIngot"))
            .appendData("scope.zoom", 5F);
        new ScopeMaterial("mithriline", true).setRecipe(ItemGenericEC.getStkByName("mithrilineIngot"))
            .appendData("scope.zoom", 7F);
        new ScopeMaterial("void", true).setRecipe(ItemGenericEC.getStkByName("voidPlating"))
            .appendData("scope.zoom", 12F);
        new ScopeMaterial("demonic", true).setRecipe(ItemGenericEC.getStkByName("ackroniteIngot"))
            .appendData("scope.zoom", 16F);

        new LenseMaterial("chaos").setRecipe(new ItemStack(ECItems.matrixProj, 1, 1));
        new LenseMaterial("frozen").setRecipe(new ItemStack(ECItems.matrixProj, 1, 2));
        new LenseMaterial("pure").setRecipe(new ItemStack(ECItems.matrixProj, 1, 3));
        new LenseMaterial("shade").setRecipe(new ItemStack(ECItems.matrixProj, 1, 4));

    }

}
