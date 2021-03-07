package net.craftions.cbutils;

import net.craftions.cbutils.command.CommandAdmin;
import net.craftions.cbutils.command.CommandHead;
import net.craftions.cbutils.command.CommandSign;
import net.craftions.cbutils.events.EventInteract;
import net.craftions.cbutils.events.EventInteractEntity;
import net.craftions.cbutils.events.EventSignChange;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class CBUtils extends JavaPlugin {

    public static Economy econ = null;

    @Override
    public void onEnable() {
        setupEconomy();
        getCommand("signieren").setExecutor(new CommandSign());
        getCommand("kopf").setExecutor(new CommandHead());
        getCommand("admin").setExecutor(new CommandAdmin());
        Bukkit.getPluginManager().registerEvents(new EventSignChange(), this);
        Bukkit.getPluginManager().registerEvents(new EventInteract(), this);
        Bukkit.getPluginManager().registerEvents(new EventInteractEntity(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
