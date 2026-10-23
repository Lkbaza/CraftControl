package com.craftcontrol.command;

import com.craftcontrol.service.PlayerService;
import com.craftcontrol.service.PlayerStatsService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommand implements CommandExecutor {

    private final PlayerService playerService;
    private final PlayerStatsService playerStatsService;

    public PlayerCommand (PlayerService playerService, PlayerStatsService playerStatsService) {
        this.playerService = playerService;
        this.playerStatsService = playerStatsService;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

            if (args.length != 2) {
                sendHelp(sender);
                return true;
            }

        String subCommand = args[1];

        switch (subCommand) {

                case "kills":
                if (!(sender instanceof Player player)) {
                    sender.sendMessage("Эту команду может использовать только игрок.");
                    return true;
                }
                int kills = playerStatsService.getKills(player.getUniqueId());

                sender.sendMessage("Количество убийств: " + kills);
                break;

                case "online":
                sender.sendMessage("Количество игроков онлайн - " + playerService.getOnlinePlayerCount());
                break;

                case "max":
                sender.sendMessage("Максимальное количество игроков - " + playerService.getMaxPlayers());
                break;

                default:
                sender.sendMessage("Ошибка: Неизвестный параметр - " + subCommand);
                break;

        }
        return true;
    }

    private void sendHelp(CommandSender sender) {
        sender.sendMessage("Использование:");
        sender.sendMessage("/cc players online - игроки онлайн");
        sender.sendMessage("/cc players max - максимальное количество игроков");
        sender.sendMessage("/cc players kills - количество убийств");

    }
}
