package com.craftcontrol.command;

import com.craftcontrol.provider.ServerInfoProvider;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WorldCommand implements CommandExecutor {

    private final ServerInfoProvider serverInfoProvider;

    public WorldCommand (ServerInfoProvider serverInfoProvider) {
        this.serverInfoProvider = serverInfoProvider;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        sender.sendMessage("========== Worlds ==========");

        sender.sendMessage("");

        sender.sendMessage("Количество миров: " + serverInfoProvider.getWorldCount());

        sender.sendMessage("");

        sender.sendMessage("============================");

        return true;
    }

}
