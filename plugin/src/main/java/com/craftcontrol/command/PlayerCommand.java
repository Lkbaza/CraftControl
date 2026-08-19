package com.craftcontrol.command;

import com.craftcontrol.service.PlayerService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayerCommand implements CommandExecutor {

    private final PlayerService playerService;

    public PlayerCommand (PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        sender.sendMessage("========== Players ==========");

        sender.sendMessage("");

        sender.sendMessage("Игроков онлайн: " + playerService.getOnlinePlayerCount());

        sender.sendMessage("Максимум игроков: " + playerService.getMaxPlayers());

        sender.sendMessage("");

        sender.sendMessage("============================");

        return true;
    }

}
