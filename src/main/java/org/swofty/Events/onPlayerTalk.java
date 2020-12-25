package org.swofty.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.swofty.Core.Api;
import org.swofty.Core.Ranks;

public class onPlayerTalk implements Listener {

    @EventHandler
    public void onPlayerTalk(AsyncPlayerChatEvent event) {
        event.setCancelled(true);

        if (Ranks.getRank(event.getPlayer()).equalsIgnoreCase("default")) {
            Bukkit.broadcastMessage(Api.colorize(Ranks.getRankPrefix(event.getPlayer()) + event.getPlayer().getDisplayName() + "&f: "+ event.getMessage()));
            return;
        }

        Bukkit.getServer().broadcastMessage(Api.colorize(Ranks.getRankPrefix(event.getPlayer()) + " " + event.getPlayer().getDisplayName() + "&f: " + event.getMessage()));
    }
}
