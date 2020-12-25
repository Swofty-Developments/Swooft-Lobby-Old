package org.swofty.Core;

import org.bukkit.entity.Player;

public class Ranks {

    public static Boolean checkRankLower(Player player, String rank) {
        int rankId = 0;
        int playerRankId = 0;

        if (rank.equalsIgnoreCase("all")) {
            return true;
        }

        switch (rank) {
            case "default": rankId = 0; break;
            case "vip": rankId = 1; break;
            case "vip+": rankId = 2; break;
            case "mvp": rankId = 3; break;
            case "mvp+": rankId = 4; break;
            case "mvp++": rankId = 5; break;
            case "admin": rankId = 6;
        }

        switch (getRank(player)) {
            case "default": playerRankId = 0; break;
            case "vip": playerRankId = 1; break;
            case "vip+": playerRankId = 2; break;
            case "mvp": playerRankId = 3; break;
            case "mvp+": playerRankId = 4; break;
            case "mvp++": playerRankId = 5; break;
            case "admin": playerRankId = 6;
        }

        return playerRankId >= rankId;
    }

    public static String getRank(Player player) {

        if (player.isOp()) {
            return "admin";
        }

        if (player.hasPermission("rank.default")) {
            return "default";
        } else if (player.hasPermission("rank.vip")) {
            return "vip";
        } else if (player.hasPermission("rank.vip+")) {
            return "vip+";
        } else if (player.hasPermission("rank.mvp")) {
            return "mvp";
        } else if (player.hasPermission("rank.mvp+")) {
            return "mvp+";
        } else if (player.hasPermission("rank.mvp++")) {
            return "mvp++";
        } else if (player.hasPermission("rank.admin")) return "admin";

        Api.log("Unable to assign '" + player.getDisplayName() + "' to a rank");
        return "default";
    }

    public static String getRankPrefix(Player player) {

        if (player.isOp()) {
            return "§c§lADMIN§r§c";
        }

        switch (Ranks.getRank(player)) {
                case "default": return "§7";
                case "vip": return "§a§lVIP§r§a";
                case "vip+": return "§a§lVIP+§r§a";
                case "mvp": return "§b§lMVP§r§b";
                case "mvp+": return "§b§lMVP+§r§b";
                case "mvp++": return "§6§lMVP++§r§7";
                case "admin": return "§c§lADMIN§r§c";
        }

        Api.log("Unable to assign '" + player.getDisplayName() + "' to a rank");
        return "§7";
    }

}