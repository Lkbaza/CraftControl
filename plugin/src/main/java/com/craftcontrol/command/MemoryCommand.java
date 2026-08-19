package com.craftcontrol.command;


import com.craftcontrol.service.MemoryService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MemoryCommand implements CommandExecutor {

    private final MemoryService memoryService;

        public MemoryCommand(MemoryService memoryService) {
            this.memoryService = memoryService;
        }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

            sender.sendMessage("========== Memory ==========");

            sender.sendMessage("");

            sender.sendMessage("Память");

            sender.sendMessage("");

            sender.sendMessage("Использовано: " + memoryService.getUsedMemoryMB() + " MB");

            sender.sendMessage("Максимум: " + memoryService.getMaxMemoryMB() + " MB");

            sender.sendMessage("");

            sender.sendMessage("============================");

            return true;
    }
}
