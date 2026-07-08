package com.craftcontrol;

import com.craftcontrol.command.CraftControlCommand;
import com.craftcontrol.command.StatusCommand;
import com.craftcontrol.service.ServerInfoService;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftControlPlugin extends JavaPlugin {

    private ServerInfoService serverInfoService;

    @Override
    public void onEnable() {

        serverInfoService = new ServerInfoService();

        StatusCommand statusCommand = new StatusCommand(serverInfoService);

        CraftControlCommand craftControlCommand = new CraftControlCommand(statusCommand);

        getCommand("cc").setExecutor(craftControlCommand);

        getLogger().info("[CraftControl] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("[CraftControl] Plugin disabled!");
    }
}
