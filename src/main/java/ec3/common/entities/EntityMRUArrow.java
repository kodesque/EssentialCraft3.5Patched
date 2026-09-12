package ec3.common.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import ec3.root.EssentialCraftCore;
import ec3.utils.dummycore.utils.math.MathUtils;

public class EntityMRUArrow extends EntityArrow {

    public EntityMRUArrow(World p_i1753_1_) {
        super(p_i1753_1_);
    }

    public EntityMRUArrow(World world, EntityLivingBase shootingEntity, EntityLivingBase target, float position, float speed) {
        super(world, shootingEntity, target, position, speed);
        this.canBePickedUp = 0;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted > 60) this.setDead();
//        this.motionX *= 0.8F;
        // this.motionY *= 0.8F;
//        this.motionZ *= 0.8F;
        for (int i = 0; i < 2; ++i) {
            EssentialCraftCore.proxy.spawnParticle(
                "cSpellFX",
                (float) posX + MathUtils.randomFloat(rand) / 10,
                (float) posY + MathUtils.randomFloat(rand) / 10,
                (float) posZ + MathUtils.randomFloat(rand) / 10,
                motionX * 10,
                motionY * 10,
                motionZ * 10);
        }
    }

}
