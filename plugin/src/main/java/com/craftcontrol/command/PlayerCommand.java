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


        if (args.length == 1) {
            sender.sendMessage("Использование :");
            sender.sendMessage("/cc players online - игроки онлайн");
            sender.sendMessage("/cc players max - максимальное количество игроков");
            return true;
        }

        if (args[1].equals("online")) {
            sender.sendMessage("Количество игроков онлайн - " + playerService.getOnlinePlayerCount());
            return true;
        }

        if (args[1].equals("max")) {
            sender.sendMessage("Максимальное количество игроков - " + playerService.getMaxPlayers());
            return true;
        }

            sender.sendMessage("Ошибка: Неизвестный параметр: " + args[1]);
        return true;
    }
}
