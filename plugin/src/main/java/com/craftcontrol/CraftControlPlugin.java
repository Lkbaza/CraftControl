package com.craftcontrol;

import com.craftcontrol.command.StatusCommand;
import com.craftcontrol.service.ServerInfoService;
import org.bukkit.plugin.java.JavaPlugin;
import com.craftcontrol.command.StatusCommand;

public class CraftControlPlugin extends JavaPlugin {

    private ServerInfoService serverInfoService;

    @Override
    public void onEnable() {

        serverInfoService = new ServerInfoService();

        StatusCommand statusCommand = new StatusCommand(serverInfoService);

        getCommand("cc").setExecutor(statusCommand);

        getLogger().info("[CraftControl] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("[CraftControl] Plugin disabled!");
    }
}
