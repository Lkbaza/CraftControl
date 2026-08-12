package com.craftcontrol.command;


import com.craftcontrol.provider.ServerInfoProvider;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MemoryCommand implements CommandExecutor {

    private final ServerInfoProvider serverInfoProvider;

        public MemoryCommand(ServerInfoProvider serverInfoProvider) {
            this.serverInfoProvider = serverInfoProvider;
        }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

            sender.sendMessage("========== Memory ==========");

            sender.sendMessage("");

            sender.sendMessage("Память");

            sender.sendMessage("");

            sender.sendMessage("Использовано: " + serverInfoProvider.getUsedMemoryMB() + " MB");

            sender.sendMessage("Максимум: " + serverInfoProvider.getMaxMemoryMB() + " MB");

            sender.sendMessage("");

            sender.sendMessage("============================");

            return true;
    }
}
