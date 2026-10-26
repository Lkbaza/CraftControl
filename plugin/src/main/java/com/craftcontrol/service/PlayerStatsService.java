package com.craftcontrol.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class PlayerStatsService {

    private final Map<UUID, Integer> kills = new HashMap<>();
    private File file;
    private YamlConfiguration config;

    public PlayerStatsService(JavaPlugin plugin) {
        plugin.getDataFolder().mkdirs();

        this.file = new File(plugin.getDataFolder(), "player-stats.yml");
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public void loadStats() {
        ConfigurationSection section = config.getConfigurationSection("kills");
        if (section == null) {
            return;
        }
        for (String key : section.getKeys(false)) {
            UUID playerId = UUID.fromString(key);
            int count = section.getInt(key);
            kills.put(playerId, count);
        }
    }

    public void saveStats() {
        for (Map.Entry<UUID, Integer> entry : kills.entrySet()) {
            config.set("kills." + entry.getKey().toString(), entry.getValue());
        }
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public int getKills(UUID playerId) {
        return kills.getOrDefault(playerId, 0);
    }

    public void addKill(UUID playerId) {
        kills.merge(playerId, 1, Integer::sum);
        saveStats();
    }
}
