package net.craftions.cbutils.command;

import net.craftions.cbutils.CBUtils;
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
            if(CBUtils.econ.getBalance((Player) sender) >= 100){
                if(args.length == 1){
                    CBUtils.econ.depositPlayer((Player) sender, -100);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:give " + sender.getName() + " minecraft:player_head{SkullOwner:" + args[0] + "}");
                    sender.sendMessage("§2Du hast den Kopf von §2" + args[0] + "§2 erhalten!");
                }else{
                    sender.sendMessage("§cBitte nutze /kopf <spielername>");
                }
            }else {
                sender.sendMessage("§cDu brauchst mindestens $ 100");
            }
        }else {
            sender.sendMessage("You need to be a player.");
        }
        return true;
    }
}
