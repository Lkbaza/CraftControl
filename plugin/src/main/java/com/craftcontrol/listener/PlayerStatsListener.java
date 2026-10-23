package com.craftcontrol.listener;
import com.craftcontrol.service.PlayerStatsService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerStatsListener implements Listener {

    private final PlayerStatsService playerStatsService;

    public PlayerStatsListener(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();

        if (killer == null) {
            return;
        }

        playerStatsService.addKill(killer.getUniqueId());
    }
}
