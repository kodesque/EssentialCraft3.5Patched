package ec3.utils.commands.handlers;

import ec3.utils.commands.CommandCreateMRUCU;
import ec3.utils.commands.CommandRemoveMRUCU;
import ec3.utils.commands.CommandSetBalance;
import ec3.utils.commands.CommandSetMRU;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;

import java.util.List;

public class CommandEC extends CommandBase {
    public static CommandEC instance;

    public CommandEC() {
        instance = this;
    }

    @Override
    public String getCommandName() {
        return "essentialcraft";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "commands.summon.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        if (args.length == 0) {
            throw new WrongUsageException(getCommandUsage(sender));
        }

        String subCommand = args[0];

        String[] subArgs = getSubCommandArgs(args);

        if (subCommand.equalsIgnoreCase("setMRUClosestMRUCU")) {

            CommandSetMRU.handle(sender, subArgs);

            return;
        } else if (subCommand.equalsIgnoreCase("setBalanceClosestMRUCU")) {

            CommandSetBalance.handle(sender, subArgs);

            return;

        } else if (subCommand.equalsIgnoreCase("createMRUCU")) {

            CommandCreateMRUCU.handle(sender, subArgs);

            return;

        } else if (subCommand.equalsIgnoreCase("removeClosestMRUCU")) {

            CommandRemoveMRUCU.handle(sender, subArgs);

            return;
        }

        throw new WrongUsageException(
            "commands.summon.usage", new Object[0]
        );
    }

    @Override
    public List addTabCompletionOptions(
        ICommandSender sender,
        String[] args) {

        if (args.length == 1) {

            return getListOfStringsMatchingLastWord(
                args,
                "setMRUClosestMRUCU",
                "setBalanceClosestMRUCU",
                "createMRUCU",
                "removeClosestMRUCU"
            );
        }

        String subCommand = args[0];

        String[] subArgs = getSubCommandArgs(args);

        if (subCommand.equalsIgnoreCase("setMRUClosestMRUCU")) {

            return CommandSetMRU.complete(
                sender,
                subArgs
            );

        } else if (subCommand.equalsIgnoreCase("setBalanceClosestMRUCU")) {

            return CommandSetBalance.complete(
                sender,
                subArgs
            );

        } else if (subCommand.equalsIgnoreCase("createMRUCU")) {

            return CommandCreateMRUCU.complete(
                sender,
                subArgs
            );
        } else if (subCommand.equalsIgnoreCase("removeClosestMRUCU")) {

            return CommandRemoveMRUCU.complete(
                sender,
                subArgs
            );
        }

        return null;
    }

    private String[] getSubCommandArgs(String[] args) {

        String[] subArgs = new String[args.length - 1];

        System.arraycopy(
            args,
            1,
            subArgs,
            0,
            subArgs.length
        );

        return subArgs;
    }

    public static String[] getAllOnlineUsernames() {
        return MinecraftServer.getServer()
            .getAllUsernames();
    }

}
