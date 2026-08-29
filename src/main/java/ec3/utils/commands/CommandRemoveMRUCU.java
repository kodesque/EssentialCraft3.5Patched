package ec3.utils.commands;

import ec3.utils.ECUtils;
import ec3.utils.commands.handlers.CommandEC;
import ec3.utils.dummycore.utils.math.Coord3D;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class CommandRemoveMRUCU extends CommandEC  {

    public static void handle(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        EntityPlayerMP player = par2ArrayOfStr.length == 0 ? getCommandSenderAsPlayer(par1ICommandSender)
            : getPlayer(par1ICommandSender, par2ArrayOfStr[0]);

        ec3.common.entities.EntityMRUPresence mru = (ec3.common.entities.EntityMRUPresence) ECUtils
            .getClosestMRUCU(player.worldObj, new Coord3D(player.posX, player.posY, player.posZ), 16);

        if (mru != null) {
            mru.setDead();
        } else {
            throw new WrongUsageException(
                "commands.balance.noMRU", new Object[0]
            );
        }

        player.worldObj.spawnEntityInWorld(mru);

        func_152373_a(par1ICommandSender, CommandEC.instance, "commands.remove.success", new Object[0]);
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    @SuppressWarnings("rawtypes")
    public static List complete(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        return par2ArrayOfStr.length == 1
            ? getListOfStringsMatchingLastWord(par2ArrayOfStr, CommandEC.getAllOnlineUsernames())
            : null;
    }

}
