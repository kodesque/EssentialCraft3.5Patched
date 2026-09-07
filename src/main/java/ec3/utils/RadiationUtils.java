package ec3.utils;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.FakePlayer;

import ec3.api.config.Config;
import ec3.common.init.ECBiomes;
import ec3.common.init.ECPotions;
import ec3.utils.dummycore.utils.math.MathUtils;

public class RadiationUtils {

    public static void increasePlayerRadiation(EntityPlayer e, int amount) {
        int current = getPlayerRadiation(e);
        setPlayerRadiation(e, current + amount);
    }

    public static void setPlayerRadiation(EntityPlayer player, int amount) {
        if (amount < 0) amount = 0;
        if (!(player instanceof FakePlayer)) ECUtils.getData(player)
            .modifyRadiation(amount);
    }

    public static int getPlayerRadiation(EntityPlayer player) {
        if ((player instanceof FakePlayer)) return 0;
        return ECUtils.getData(player)
            .getPlayerRadiation();
    }

    public static void playerTick(EntityPlayer player) {
        if ((player instanceof FakePlayer)) return;
        int dimID = player.dimension;
        if (dimID == Config.dimensionID) {
            int chunkX = player.chunkCoordX;
            int chunkZ = player.chunkCoordZ;
            Random rnd = new Random(
                Long.parseLong((int) MathUtils.module(chunkX) * 128 + "" + (int) MathUtils.module(chunkZ) * 128));
            BiomeGenBase biome = player.worldObj.getBiomeGenForCoords((int) player.posX, (int) player.posZ);
            int rndRad = rnd.nextInt(6);
            if (biome == ECBiomes.firstWorldBiomeArray[8]) rndRad += 2;
            if (biome == ECBiomes.firstWorldBiomeArray[4]) rndRad += 6;
            rndRad = (int) ((float) rndRad * ECUtils.getGenResistance(2, player));
            increasePlayerRadiation(player, rndRad);
            rnd = null;
        }
        int amount = getPlayerRadiation(player);
        if (amount > 0) if (player.dimension == Config.dimensionID) increasePlayerRadiation(player, -1);
        else increasePlayerRadiation(player, -5);
        if (amount > 0) {
            boolean hasEffect = player.getActivePotionEffect(ECPotions.radiation) != null;
            if (hasEffect) {
                int currentDuration = amount;
                int newModifier = currentDuration / 10000;
                player.removePotionEffect(ECPotions.radiation.id);
                player.addPotionEffect(new PotionEffect(ECPotions.radiation.id, currentDuration, newModifier, true));
            } else {
                player.addPotionEffect(new PotionEffect(ECPotions.radiation.id, 200, 0, true));
            }
        }
    }

}
