package net.craftions.cbutils.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandHead implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            if(args.length == 1){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + sender.getName() + " mineccraft:player_head{SkullOwner:" + args[0] + "}");
                sender.sendMessage("§2Du hast den Kopf von §2" + args[0] + "§2 erhalten!");
            }else{
                sender.sendMessage("§cBitte nutze /kopf <spielername>");
            }
        }else {
            sender.sendMessage("You need to be a player.");
        }
        return true;
    }
}
