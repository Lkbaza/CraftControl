package com.craftcontrol.service;

import org.bukkit.Bukkit;

public class ServerInfoService {

    public String getMinecraftVersion() {
        return Bukkit.getMinecraftVersion();
    }

    public String getName() {
        return Bukkit.getName();
    }
}
