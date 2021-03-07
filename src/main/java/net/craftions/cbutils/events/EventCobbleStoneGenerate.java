/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.cbutils.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class EventCobbleStoneGenerate implements Listener {

    @EventHandler
    public void onGenerate(BlockFromToEvent event){
        if(event.getBlock().getType() != event.getToBlock().getType()){
            if (event.getBlock().getType().equals(Material.COBBLESTONE)) {

            }
        }
    }
}
