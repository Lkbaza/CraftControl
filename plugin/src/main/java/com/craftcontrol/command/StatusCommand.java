package com.craftcontrol.command;

import com.craftcontrol.service.MemoryService;
import com.craftcontrol.service.PlayerService;
import com.craftcontrol.service.ServerInfoService;
import com.craftcontrol.service.WorldService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatusCommand implements CommandExecutor {

    private final ServerInfoService serverInfoService;

    private final PlayerService playerService;

    private final WorldService worldService;

    private final MemoryService memoryService;

    public StatusCommand(ServerInfoService serverInfoService, PlayerService playerService, WorldService worldService, MemoryService memoryService) {
        this.serverInfoService = serverInfoService;
        this.playerService = playerService;
        this.worldService = worldService;
        this.memoryService = memoryService;
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
        sender.sendMessage("Игроков онлайн: " + playerService.getOnlinePlayerCount());
        sender.sendMessage("Миров: " + worldService.getWorldCount());

        sender.sendMessage("");

        sender.sendMessage("  Использовано памяти: " + memoryService.getUsedMemoryMB() + " MB");
        sender.sendMessage("  Максимум памяти : " + memoryService.getMaxMemoryMB() + " MB");

        sender.sendMessage("");

        sender.sendMessage("==============================");

        return true;
    }
}
