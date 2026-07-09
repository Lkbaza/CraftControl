package com.craftcontrol.service;

import org.bukkit.Bukkit;


public class ServerInfoService {

    public int getOnlinePlayerCount() {
        return Bukkit.getOnlinePlayers().size();
    }

    public int getWorldCount() {
        return Bukkit.getWorlds().size();
    }

    public String getMinecraftVersion() {
        return Bukkit.getMinecraftVersion();
    }

    public String getName() {
        return Bukkit.getName();
    }


    public long getUsedMemoryMB() {

        Runtime runtime = Runtime.getRuntime();

        long usedMemory = runtime.totalMemory() - runtime.freeMemory();

        return usedMemory / 1024 / 1024;
    }

    public long getMaxMemoryMB() {

        Runtime runtime = Runtime.getRuntime();

        return runtime.maxMemory() / 1024 / 1024;
    }
}
