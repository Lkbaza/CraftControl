package com.craftcontrol.command;

import com.craftcontrol.service.WorldService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WorldCommand implements CommandExecutor {

    private final WorldService worldService;

    public WorldCommand (WorldService worldService) {
        this.worldService = worldService;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        sender.sendMessage("========== Worlds ==========");

        sender.sendMessage("");

        sender.sendMessage("Количество миров: " + worldService.getWorldCount());

        sender.sendMessage("");

        sender.sendMessage("============================");

        return true;
    }

}
