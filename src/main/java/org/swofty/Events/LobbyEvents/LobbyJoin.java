package org.swofty.Events.LobbyEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.swofty.Core.Admin;
import org.swofty.Core.Api;
import org.swofty.Core.Ranks;
import org.swofty.Core.Scoreboard;

public class LobbyJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Api.checkGamemode(event.getPlayer(), "lobby")) {

            if (Admin.getAdminLogging(event.getPlayer())) {
                Scoreboard.setLobbyAdminScoreboard(event.getPlayer());
            } else {
                Scoreboard.setLobbyScoreboard(event.getPlayer());
            }

            switch (Ranks.getRank(event.getPlayer())) {
                case "default":
                    event.setJoinMessage(" ");
                    return;

                case "vip":
                    event.setJoinMessage(Api.colorize("&a&lVIP " + event.getPlayer().getDisplayName() + " &djoined the lobby"));
                    break;

                case "vip+":
                    event.setJoinMessage(Api.colorize("&a&lVIP+ " + event.getPlayer().getDisplayName() + " &djoined the lobby"));
                    break;

                case "mvp":
                    event.setJoinMessage(Api.colorize("&b&lMVP " + event.getPlayer().getDisplayName() + " &djoined the lobby"));
                    break;

                case "mvp+":
                    event.setJoinMessage(Api.colorize("&b&lMVP+ " + event.getPlayer().getDisplayName() + " &djoined the lobby"));
                    break;

                case "mvp++":
                    event.setJoinMessage(Api.colorize("&6&lMVP++ " + event.getPlayer().getDisplayName() + " &djoined the lobby"));
                    break;

                case "admin":
                    event.setJoinMessage(Api.colorize("&c&lADMIN " + event.getPlayer().getDisplayName() + " &djoined the lobby"));
                    break;
            }

            event.getPlayer().teleport(Api.getSpawn());
        }
    }
}
