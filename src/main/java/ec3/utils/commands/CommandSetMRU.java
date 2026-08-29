package ec3.utils.commands;

import java.util.List;

import ec3.utils.ECUtils;
import ec3.utils.commands.handlers.CommandEC;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;

import ec3.common.entities.EntityMRUPresence;
import ec3.utils.dummycore.utils.math.Coord3D;

public class CommandSetMRU extends CommandEC {

    public static void handle(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        int var3 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 1, 60000);
        EntityPlayerMP player = par2ArrayOfStr.length == 0 ? getCommandSenderAsPlayer(par1ICommandSender)
            : getPlayer(par1ICommandSender, par2ArrayOfStr[0]);
        EntityMRUPresence mru = (EntityMRUPresence) ECUtils
            .getClosestMRUCU(player.worldObj, new Coord3D(player.posX, player.posY, player.posZ), 16);
        if (mru != null) {
            mru.setMRU(var3);
        } else {
            throw new WrongUsageException(
                "commands.balance.noMRU", new Object[0]
            );
        }

        func_152373_a(par1ICommandSender, CommandEC.instance, "commands.MRU.success", new Object[0]);
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
