package net.craftions.cbutils.events;

import net.craftions.cbutils.CBUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class EventInteractEntity implements Listener {
    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType().equals(EntityType.BOAT)) {
            if (!e.getHand().equals(EquipmentSlot.HAND)) {
                e.setCancelled(true);
                return;
            }
            if (e.getPlayer().isSneaking()) {
                e.setCancelled(true);
                return;
            }
            e.setCancelled(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(CBUtils.getPlugin(CBUtils.class), () -> {
                try {
                    Bukkit.getEntity(e.getRightClicked().getUniqueId()).addPassenger(Bukkit.getPlayer(e.getPlayer().getUniqueId()));
                } catch (NullPointerException ignored) {
                }
            }, 0);
        }
    }
}
