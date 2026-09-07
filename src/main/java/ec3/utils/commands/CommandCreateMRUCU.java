package ec3.utils.commands;

import java.util.List;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

import ec3.common.entities.EntityMRUPresence;
import ec3.utils.commands.handlers.CommandEC;

public class CommandCreateMRUCU extends CommandEC {

    public static void handle(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        int var3 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[1], 1, 60000);
        int var4 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[2], 1, 20000);
        EntityPlayerMP player = par2ArrayOfStr.length == 0 ? getCommandSenderAsPlayer(par1ICommandSender)
            : getPlayer(par1ICommandSender, par2ArrayOfStr[0]);

        EntityMRUPresence mru = new EntityMRUPresence(player.worldObj);
        mru.setPositionAndRotation(player.posX, player.posY + 1, player.posZ, 0, 0);
        mru.setMRU(var3);
        mru.setBalance((float) var4 / 10000);
        player.worldObj.spawnEntityInWorld(mru);

        func_152373_a(par1ICommandSender, CommandEC.instance, "commands.summon.success", new Object[0]);
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
