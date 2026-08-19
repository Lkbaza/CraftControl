package com.craftcontrol.service;

import org.bukkit.Bukkit;

public class WorldService {

    public int getWorldCount() {
        return Bukkit.getWorlds().size();
    }

}
