package ec3.common.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.common.entities.EntityMRUPresence;
import ec3.common.init.ECEntities;

public class ItemSpawnEggEC extends ItemMonsterPlacer {

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack p_82790_1_, int p_82790_2_) {
        return 0xffffff;
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_,
        int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (p_77648_3_.isRemote) {
            return true;
        } else {
            Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
            p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
            p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
            p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];
            double d0 = 0.0D;

            if (p_77648_7_ == 1 && block.getRenderType() == 11) {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(
                p_77648_3_,
                p_77648_1_.getItemDamage(),
                (double) p_77648_4_ + 0.5D,
                (double) p_77648_5_ + d0,
                (double) p_77648_6_ + 0.5D);

            if (entity != null) {
                if (entity instanceof EntityLivingBase && p_77648_1_.hasDisplayName()) {
                    ((EntityLiving) entity).setCustomNameTag(p_77648_1_.getDisplayName());
                }

                if (!p_77648_2_.capabilities.isCreativeMode) {
                    --p_77648_1_.stackSize;
                }
            }

            return true;
        }
    }

    public String getItemStackDisplayName(ItemStack p_77653_1_) {
        String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
        String s1 = ECEntities.registeredEntities.get(p_77653_1_.getItemDamage())
            .getName();

        if (s1 != null) {
            s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        }

        return s;
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return false;
    }

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_) {
        return this.itemIcon;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item i, CreativeTabs t, List l) {
        for (int j = 0; j < ECEntities.registeredEntities.size(); ++j) {
            l.add(new ItemStack(i, 1, j));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_) {
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString());
    }

    public static Entity spawnCreature(World world, int id, double x, double y, double z) {
        try {
            Entity entity = null;

            for (int j = 0; j < 1; ++j) {
                entity = ECEntities.registeredEntities.get(id)
                    .getConstructor(World.class)
                    .newInstance(world);

                if (entity != null && entity instanceof EntityLivingBase) {
                    EntityLivingBase entityliving = (EntityLivingBase) entity;
                    entity.setLocationAndAngles(
                        x,
                        y,
                        z,
                        MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F),
                        0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    if (entity instanceof EntityLiving) EntityLiving.class.cast(entityliving)
                        .onSpawnWithEgg((IEntityLivingData) null);

                    if (entity instanceof EntityMRUPresence) {
                        EntityMRUPresence mrucu = ((EntityMRUPresence) entity);

                        mrucu.setMRU(2000 * world.rand.nextInt(10));
                        mrucu.setBalance(world.rand.nextFloat());
                    }

                    world.spawnEntityInWorld(entity);
                    if (entity instanceof EntityLiving) EntityLiving.class.cast(entityliving)
                        .playLivingSound();
                }
            }

            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
