package com.craftcontrol.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerStatsService {

    private final Map<UUID, Integer> kills = new HashMap<>();

    public int getKills(UUID playerId) {
        return kills.getOrDefault(playerId, 0);
    }

    public  void addKill(UUID playerId) {
        kills.merge(playerId, 1, Integer::sum);
    }
}
