package com.craftcontrol.service;

public class MemoryService {

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
