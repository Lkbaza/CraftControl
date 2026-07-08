package com.craftcontrol.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CraftControlCommand implements CommandExecutor {


    private final StatusCommand statusCommand;

    public CraftControlCommand(StatusCommand statusCommand) {
        this.statusCommand = statusCommand;
    }

@Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if (args.length == 0) {
            sender.sendMessage("Использование: /cc status");
            return true;
        } else if (args[0].equals("status")) {
            statusCommand.onCommand(sender, command, label, args);
            return true;
        } else {
            sender.sendMessage("Неизвестная подкоманда");
            return true;
        }
    }
}