package com.craftcontrol.service;

import com.craftcontrol.provider.ServerInfoProvider;
import org.bukkit.Bukkit;

public class ServerInfoService implements ServerInfoProvider {

    @Override
    public int getOnlinePlayerCount() {
        return Bukkit.getOnlinePlayers().size();
    }

    @Override
    public int getWorldCount() {
        return Bukkit.getWorlds().size();
    }

    @Override
    public String getMinecraftVersion() {
        return Bukkit.getMinecraftVersion();
    }

    @Override
    public String getName() {
        return Bukkit.getName();
    }

    @Override
    public long getUsedMemoryMB() {

        Runtime runtime = Runtime.getRuntime();

        long usedMemory = runtime.totalMemory() - runtime.freeMemory();

        return usedMemory / 1024 / 1024;
    }

    @Override
    public long getMaxMemoryMB() {

        Runtime runtime = Runtime.getRuntime();

        return runtime.maxMemory() / 1024 / 1024;
    }
}
