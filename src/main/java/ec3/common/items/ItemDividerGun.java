package ec3.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import ec3.common.entities.EntityDividerProjectile;
import ec3.common.init.ECAchievements;
import ec3.utils.ECUtils;

public class ItemDividerGun extends ItemStoresMRUInNBT {

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int indexInInventory, boolean isCurrentItem) {
        super.onUpdate(itemStack, world, entity, indexInInventory, isCurrentItem);
        if (entity instanceof EntityPlayer && entity.ticksExisted % 20 == 0) EntityPlayer.class.cast(entity)
            .triggerAchievement(ECAchievements.achievementList.get("hologramGun"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stk, World w, EntityPlayer p) {
        p.setItemInUse(stk, getMaxItemUseDuration(stk));
        return stk;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.bow;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return 20;
    }

    public ItemStack onEaten(ItemStack stk, World w, EntityPlayer p) {
        if ((ECUtils.tryToDecreaseMRUInStorage(p, -5000) || this.setMRU(stk, -5000))) {
            w.playSound(p.posX, p.posY, p.posZ, "essentialcraft:sound.beam", 1, 2, false);
            EntityDividerProjectile proj = new EntityDividerProjectile(w, p);
            if (!w.isRemote) w.spawnEntityInWorld(proj);
        }
        return stk;
    }

}
