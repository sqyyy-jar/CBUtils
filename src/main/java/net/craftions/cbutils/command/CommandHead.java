package net.craftions.cbutils.command;

import net.craftions.cbutils.CBUtils;
import net.craftions.cbutils.Prices;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandHead implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            if(CBUtils.econ.getBalance((Player) sender) >= Prices.command_kopf){
                if(args.length == 1){
                    CBUtils.econ.withdrawPlayer((Player) sender, Prices.command_kopf);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:give " + sender.getName() + " minecraft:player_head{SkullOwner:" + args[0] + "}");
                    sender.sendMessage("§e$ " + Prices.command_kopf + "§awurden von deinem Konto abgezogen!");
                }else{
                    sender.sendMessage("§cBitte nutze /kopf <spielername>");
                }
            }else {
                sender.sendMessage("§cDu brauchst mindestens $ " + Prices.command_kopf);
            }
        }else {
            sender.sendMessage("You need to be a player.");
        }
        return true;
    }
}
