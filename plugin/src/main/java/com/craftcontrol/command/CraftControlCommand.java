package com.craftcontrol.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CraftControlCommand implements CommandExecutor {


    private final StatusCommand statusCommand;

    private final MemoryCommand memoryCommand;

    private final WorldCommand worldCommand;

    public CraftControlCommand(StatusCommand statusCommand, MemoryCommand memoryCommand, WorldCommand worldCommand) {
        this.statusCommand = statusCommand;
        this.memoryCommand = memoryCommand;
        this.worldCommand = worldCommand;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if (args.length == 0) {
            sender.sendMessage("Использование:");
            sender.sendMessage("/cc status - информация о сервере");
            sender.sendMessage("/cc memory - информация о памяти");
            sender.sendMessage("/cc world - информация о количествах миров");
            return true;
        } else if (args[0].equals("status")) {
            statusCommand.onCommand(sender, command, label, args);
            return true;
        }    else if (args[0].equals("memory")) {
            memoryCommand.onCommand(sender, command, label, args);
            return true;
        } else if (args[0].equals("world")) {
            worldCommand.onCommand(sender, command, label, args);
            return true;
        } else {
            sender.sendMessage("Неизвестная подкоманда");
            return true;
        }
    }
}