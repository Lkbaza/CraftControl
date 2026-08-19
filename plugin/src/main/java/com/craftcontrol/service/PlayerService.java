package com.craftcontrol.service;

import org.bukkit.Bukkit;

public class PlayerService {

    public int getOnlinePlayerCount() {
        return Bukkit.getOnlinePlayers().size();
    }

    public int getMaxPlayers() {
        return Bukkit.getMaxPlayers();
    }

}
