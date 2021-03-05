/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.cbutils.command;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class CommandAdmin implements CommandExecutor {

    public static HashMap<Player, Inventory> back = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(back.containsKey(p)){
                p.getInventory().clear();
                p.setGameMode(GameMode.SURVIVAL);
                p.getInventory().setContents(back.get(p).getContents());
                back.remove(p);
            }else {
                back.put(p, p.getInventory());
                p.setGameMode(GameMode.CREATIVE);
                p.getInventory().clear();
            }
        }else {
            sender.sendMessage("you need to be a player.");
        }
        return true;
    }
}
