package com.craftcontrol;

import com.craftcontrol.command.CraftControlCommand;
import com.craftcontrol.command.MemoryCommand;
import com.craftcontrol.command.StatusCommand;
import com.craftcontrol.service.ServerInfoService;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftControlPlugin extends JavaPlugin {

    private ServerInfoService serverInfoService;

    @Override
    public void onEnable() {

        ServerInfoService serverInfoService = new ServerInfoService();

        StatusCommand statusCommand = new StatusCommand(serverInfoService);

        MemoryCommand memoryCommand = new MemoryCommand(serverInfoService);

        CraftControlCommand craftControlCommand = new CraftControlCommand(statusCommand, memoryCommand);

        getCommand("cc").setExecutor(craftControlCommand);

        getLogger().info("[CraftControl] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("[CraftControl] Plugin disabled!");
    }
}
