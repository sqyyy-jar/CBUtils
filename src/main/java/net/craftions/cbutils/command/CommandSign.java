package net.craftions.cbutils.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CommandSign implements CommandExecutor {

    @Override
    public boolean onCommand(@org.jetbrains.annotations.NotNull CommandSender sender, @org.jetbrains.annotations.NotNull Command command, @org.jetbrains.annotations.NotNull String label, @org.jetbrains.annotations.NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.getInventory().getItemInMainHand().getType() != Material.AIR){
                String newLore = "";
                for(int i = 0; i < args.length; i++){
                    newLore += args[i] + "";
                }
                ItemStack i = p.getInventory().getItemInMainHand();
                ItemMeta meta = i.getItemMeta();
                List<String> lore = new ArrayList<>();
                lore.add("");
                lore.add("§cSigniert von §e" + p.getName());
                lore.add("§f" + newLore);
                i.setItemMeta(meta);
                p.getInventory().setItemInMainHand(i);
                p.sendMessage("§2Das Item wurde erfolgreich signiert!");
            }else {
                p.sendMessage("§cBitte halte das Item, dass du signieren willst in der Haupt-Hand.");
            }
        }else {
            sender.sendMessage("You need to be a player.");
        }
        return true;
    }
}
