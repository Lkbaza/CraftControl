package com.craftcontrol.command;

import com.craftcontrol.service.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatusCommand implements CommandExecutor {

    private final StatusService statusService;

    public StatusCommand(StatusService statusService) {
        this.statusService = statusService;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        sender.sendMessage("========= CraftControl =========");

        sender.sendMessage("");

        sender.sendMessage("Версия сервера: " +
                statusService.getServerName() + " " +
                statusService.getMinecraftVersion());
        sender.sendMessage("Игроков онлайн: " + statusService.getOnlinePlayers());
        sender.sendMessage("Миров: " + statusService.getWorldCount());

        sender.sendMessage("");

        sender.sendMessage("  Использовано памяти: " + statusService.getUsedMemoryMB() + " MB");
        sender.sendMessage("  Максимум памяти : " + statusService.getMaxMemoryMB() + " MB");

        sender.sendMessage("");

        sender.sendMessage("==============================");

        return true;
    }
}
