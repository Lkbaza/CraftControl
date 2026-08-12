package com.craftcontrol.Interface;

public interface ServerInfoProvider {

    int getOnlinePlayerCount();

    int getWorldCount();

    String getMinecraftVersion();

    String getName();

    long getUsedMemoryMB();

    long getMaxMemoryMB();

}
