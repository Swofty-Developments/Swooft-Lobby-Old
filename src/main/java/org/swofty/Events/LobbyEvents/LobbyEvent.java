package org.swofty.Events.LobbyEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.swofty.Core.Api;
import org.swofty.Core.Ranks;

public class LobbyEvent implements Listener {

    @EventHandler
    public void onPlayerDamageByBlock(EntityDamageByBlockEvent event) {
        if (event.getEntity() instanceof Player) {
            if (Api.checkGamemode((Player) event.getEntity(), "lobby")) {

                event.setCancelled(true);

            }
        }
    }

    @EventHandler
    public void onPlayerDamageByPlayer(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (Api.checkGamemode((Player) event.getEntity(), "lobby")) {

                event.setCancelled(true);

            }
        }
    }

    @EventHandler
    public void onFoodLoss(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            if (Api.checkGamemode((Player) event.getEntity(), "lobby")) {

                event.setCancelled(true);

            }
        }
    }

    @EventHandler
    public void onHealthLoss(PlayerItemDamageEvent event) {
        if (Api.checkGamemode(event.getPlayer(), "lobby")) {

            event.setCancelled(true);

        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDropItem(EntityDropItemEvent event) {
        if (event.getEntity() instanceof Player) {
            if (Api.checkGamemode((Player) event.getEntity(), "lobby")) {

                event.setCancelled(true);

            }
        }
    }

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
        if (Api.checkGamemode((Player) event.getPlayer(), "lobby")) {

            if (Ranks.getRank(event.getPlayer()) != "admin") {
                event.setCancelled(true);
            }

        }
    }

    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent event) {
        if (Api.checkGamemode((Player) event.getPlayer(), "lobby")) {

            if (Ranks.getRank(event.getPlayer()) != "admin") {
                event.setCancelled(true);
            }

        }
    }
}
