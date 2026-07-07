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

        sender.sendMessage("CraftControl работает!");

        return true;
    }
}
