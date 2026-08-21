package com.craftcontrol.service;

public class StatusService {

    private final ServerInfoService serverInfoService;
    private final PlayerService playerService;
    private final WorldService worldService;
    private final MemoryService memoryService;

    public StatusService (ServerInfoService serverInfoService, PlayerService playerService, WorldService worldService, MemoryService memoryService) {
     this.serverInfoService = serverInfoService;
     this.playerService = playerService;
     this.worldService = worldService;;
     this.memoryService = memoryService;

    }

    public String getServerName() {
        return serverInfoService.getName();
    }

    public String getMinecraftVersion() {
        return serverInfoService.getMinecraftVersion();
    }

    public int getOnlinePlayers() {
        return playerService.getOnlinePlayerCount();
    }

    public int getWorldCount() {
        return worldService.getWorldCount();
    }
    
    public long getUsedMemoryMB() {
        return memoryService.getUsedMemoryMB();
    }
    
    public long getMaxMemoryMB() {
        return memoryService.getMaxMemoryMB();
    }

}
