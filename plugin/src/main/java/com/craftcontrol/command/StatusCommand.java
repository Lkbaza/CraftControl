package com.craftcontrol.command;

import com.craftcontrol.service.ServerInfoService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatusCommand implements CommandExecutor {

    private final ServerInfoService serverInfoService;

    public StatusCommand(ServerInfoService serverInfoService) {
        this.serverInfoService = serverInfoService;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        sender.sendMessage("========= CraftControl =========");

        sender.sendMessage("");

        sender.sendMessage("Версия сервера: " +
                serverInfoService.getName() + " " +
                serverInfoService.getMinecraftVersion());
        sender.sendMessage("Игроков онлайн: " + serverInfoService.getOnlinePlayerCount());
        sender.sendMessage("Миров: " + serverInfoService.getWorldCount());

        sender.sendMessage("");

        sender.sendMessage("  Использовано памяти: " + serverInfoService.getUsedMemoryMB() + " MB");
        sender.sendMessage("  Максимум памяти : " + serverInfoService.getMaxMemoryMB() + " MB");

        sender.sendMessage("");

        sender.sendMessage("==============================");

        return true;
    }
}
