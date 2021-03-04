/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.cbutils.events;

import net.craftions.cbutils.CBUtils;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(e.getClickedBlock() != null){
            if(e.getClickedBlock().getType().equals(Material.OAK_SIGN)){
                Sign sign = (Sign) e.getClickedBlock().getState();
                if(sign.getLine(0).equals("[§aShop§e]")){
                    Material mat = Material.getMaterial(sign.getLine(1));
                    int cost = Integer.parseInt(sign.getLine(2));
                    if(CBUtils.econ.getBalance(e.getPlayer()) >= cost){
                        CBUtils.econ.withdrawPlayer(e.getPlayer(), cost);
                        e.getPlayer().getInventory().addItem(new ItemStack(mat));
                    }else {
                        e.getPlayer().sendMessage("§cDu brauchst mindestens §e$ " + cost);
                    }
                }
            }
        }
    }
}
