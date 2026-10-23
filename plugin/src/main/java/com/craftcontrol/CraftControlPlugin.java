package com.craftcontrol;

import com.craftcontrol.command.*;
import com.craftcontrol.service.*;
import org.bukkit.plugin.java.JavaPlugin;
import com.craftcontrol.listener.PlayerStatsListener;
import com.craftcontrol.service.PlayerStatsService;

public class CraftControlPlugin extends JavaPlugin {

    private PlayerStatsService playerStatsService;

    @Override
    public void onEnable() {

        ServerInfoService serverInfoService = new ServerInfoService();

        PlayerService playerService = new PlayerService();

        WorldService worldService = new WorldService();

        MemoryService memoryService = new MemoryService();

        StatusService statusService = new StatusService(serverInfoService, playerService, worldService, memoryService);

        this.playerStatsService = new PlayerStatsService();

        PlayerStatsListener playerStatsListener = new PlayerStatsListener(this.playerStatsService);

        getServer().getPluginManager().registerEvents(playerStatsListener, this);

        StatusCommand statusCommand = new StatusCommand(statusService);

        MemoryCommand memoryCommand = new MemoryCommand(memoryService);

        WorldCommand worldCommand = new WorldCommand(worldService);

        PlayerCommand playerCommand = new PlayerCommand(playerService, this.playerStatsService);

        CraftControlCommand craftControlCommand = new CraftControlCommand(statusCommand, memoryCommand, worldCommand, playerCommand);

        getCommand("cc").setExecutor(craftControlCommand);

        getLogger().info("[CraftControl] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("[CraftControl] Plugin disabled!");
    }
}
