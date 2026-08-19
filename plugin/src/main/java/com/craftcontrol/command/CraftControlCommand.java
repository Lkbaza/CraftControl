package com.craftcontrol.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CraftControlCommand implements CommandExecutor {


    private final StatusCommand statusCommand;

    private final MemoryCommand memoryCommand;

    private final WorldCommand worldCommand;

    private final PlayerCommand playerCommand;

    public CraftControlCommand(StatusCommand statusCommand, MemoryCommand memoryCommand, WorldCommand worldCommand, PlayerCommand playerCommand) {
        this.statusCommand = statusCommand;
        this.memoryCommand = memoryCommand;
        this.worldCommand = worldCommand;
        this.playerCommand = playerCommand;
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
            sender.sendMessage("/cc players - информация о количестве игроков онлайн");
            return true;
        }

        switch (args[0].toLowerCase()) {

            case "status":
                return statusCommand.onCommand(sender, command, label, args);

            case "memory":
                return memoryCommand.onCommand(sender, command, label, args);

            case "world":
                return worldCommand.onCommand(sender, command, label, args);

            case "players":
                return playerCommand.onCommand(sender, command, label, args);

            default:
                sender.sendMessage("Неизвестная подкоманда");
                return true;
        }
    }
}