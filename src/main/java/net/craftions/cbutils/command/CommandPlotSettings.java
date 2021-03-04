/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.cbutils.command;

import com.plotsquared.core.api.PlotAPI;
import com.plotsquared.core.location.Location;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandPlotSettings implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Location plotLocation = new Location(p.getWorld().getName(), (int) p.getLocation().getX(), (int) p.getLocation().getY(), (int) p.getLocation().getZ());
            Plot plot = new PlotAPI().getPlotSquared().getApplicablePlotArea(plotLocation).getPlot(plotLocation);
            sender.sendMessage(String.valueOf(plot.getId()));
        }else {
            sender.sendMessage("you need to be a player");
        }
        return true;
    }
}
