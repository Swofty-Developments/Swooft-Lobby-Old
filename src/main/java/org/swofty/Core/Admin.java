package org.swofty.Core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Admin {

    public static ArrayList<Player> adminLogging = new ArrayList<>();

    public static void setAdminLogging(Player player, Boolean bool) {
        if (bool) {
            adminLogging.add(player);
        } else {
            adminLogging.remove(player);
        }
    }

    public static Boolean getAdminLogging(Player player) {
        if (adminLogging.contains(player)) {
            return true;
        } else {
            return false;
        }
    }

    public static void adminLog(String msg) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (Ranks.getRank(player).equals("admin")) {
                player.sendMessage(Api.colorize("&c[LOG] Serv&f: " + msg));
            }
        }
    }
}
