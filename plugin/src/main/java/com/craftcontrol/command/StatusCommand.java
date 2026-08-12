package com.craftcontrol.command;

import com.craftcontrol.provider.ServerInfoProvider;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatusCommand implements CommandExecutor {

    private final ServerInfoProvider serverInfoProvider;

    public StatusCommand(ServerInfoProvider serverInfoProvider) {
        this.serverInfoProvider = serverInfoProvider;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        sender.sendMessage("========= CraftControl =========");

        sender.sendMessage("");

        sender.sendMessage("Версия сервера: " +
                serverInfoProvider.getName() + " " +
                serverInfoProvider.getMinecraftVersion());
        sender.sendMessage("Игроков онлайн: " + serverInfoProvider.getOnlinePlayerCount());
        sender.sendMessage("Миров: " + serverInfoProvider.getWorldCount());

        sender.sendMessage("");

        sender.sendMessage("  Использовано памяти: " + serverInfoProvider.getUsedMemoryMB() + " MB");
        sender.sendMessage("  Максимум памяти : " + serverInfoProvider.getMaxMemoryMB() + " MB");

        sender.sendMessage("");

        sender.sendMessage("==============================");

        return true;
    }
}
