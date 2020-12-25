package org.swofty.Core;

import com.google.gson.JsonArray;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Api {

    public static ArrayList<Player> scaffold;

    public static Location spawn = null;

    public static Plugin getPluginMain() {
        return Loader.getPluginMain();
    }

    public static void log(String msg) {
        Bukkit.getLogger().info(msg);
    }

    public static String colorize(String message) { return message.replace("&", "§"); }

    public static void setSpawn(Location loc) { spawn = loc; }

    public static Location getSpawn() {
        if (spawn == null) {
            return Bukkit.getWorld("world").getSpawnLocation();
        }
        return spawn;
    }


    public static Boolean checkGamemode(Player player, String gamemode) {

        switch (gamemode) {
            case "lobby":
                if (player.getWorld().getName().equalsIgnoreCase("world")) {
                    return true;
                }
                return false;

            case "skywars":
                if (player.getWorld().getName().equalsIgnoreCase("skywars")) {
                    return true;
                }
                return false;
        }

        return false;
    }

    public static String getGamemode(Player player) {

        ArrayList<String> gamemodes = new ArrayList<>();
        gamemodes.add("lobby");
        gamemodes.add("skywars");

        for (String in : gamemodes) {
            if (Api.checkGamemode(player, in)) {
                return in;
            }
        }

        return "lobby";
    }

}
