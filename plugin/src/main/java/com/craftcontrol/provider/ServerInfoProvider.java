package com.craftcontrol.provider;

public interface ServerInfoProvider {

    int getOnlinePlayerCount();

    int getWorldCount();

    String getMinecraftVersion();

    String getName();

    long getUsedMemoryMB();

    long getMaxMemoryMB();

}
