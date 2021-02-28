package net.craftions.cbutils;

import net.craftions.cbutils.command.CommandHead;
import net.craftions.cbutils.command.CommandSign;
import org.bukkit.plugin.java.JavaPlugin;

public final class CBUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("signieren").setExecutor(new CommandSign());
        getCommand("kopf").setExecutor(new CommandHead());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
