package com.craftcontrol;

import com.craftcontrol.command.*;
import com.craftcontrol.service.MemoryService;
import com.craftcontrol.service.PlayerService;
import com.craftcontrol.service.ServerInfoService;
import com.craftcontrol.service.WorldService;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftControlPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        ServerInfoService serverInfoService = new ServerInfoService();

        PlayerService playerService = new PlayerService();

        WorldService worldService = new WorldService();

        MemoryService memoryService = new MemoryService();

        StatusCommand statusCommand = new StatusCommand(serverInfoService, playerService, worldService, memoryService);

        MemoryCommand memoryCommand = new MemoryCommand(memoryService);

        WorldCommand worldCommand = new WorldCommand(worldService);

        PlayerCommand playerCommand = new PlayerCommand(playerService);

        CraftControlCommand craftControlCommand = new CraftControlCommand(statusCommand, memoryCommand, worldCommand, playerCommand);

        getCommand("cc").setExecutor(craftControlCommand);

        getLogger().info("[CraftControl] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("[CraftControl] Plugin disabled!");
    }
}
