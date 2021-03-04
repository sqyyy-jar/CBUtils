/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.cbutils.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class EventSignChange implements Listener {

    @EventHandler
    public void onChange(SignChangeEvent e){
        if(e.getPlayer().hasPermission("craftions.cbutils.shop.create")){
            if(e.getLine(0).equals("[Shop]")){
                e.setLine(0, "[§aShop§r]");
            }
        }
    }
}
