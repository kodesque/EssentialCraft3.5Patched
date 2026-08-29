package ec3.utils.commands.handlers;

import net.minecraft.command.ICommandSender;

public class CommandECSimple extends CommandEC {

    @Override
    public String getCommandName() {
        return "ec";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/ec <subcommand>";
    }

}
