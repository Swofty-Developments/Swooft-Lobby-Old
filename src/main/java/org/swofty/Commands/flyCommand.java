package org.swofty.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.swofty.Core.Api;
import org.swofty.Core.Ranks;

 public class flyCommand {

    public static void onFlyCommand(CommandSender sender, Command command, String label, String[] args, String rank, Boolean allowConsole) {
        if (!allowConsole) {
            if (!(sender instanceof Player)) {
                Bukkit.getLogger().info("Console is not allowed to use this command");
                return;
            }
        }
        Player player = (Player) sender;
        if (!Ranks.checkRankLower(player, rank)) {
            player.sendMessage(Api.colorize("&cYou need atleast " + rank.toUpperCase() + " to do this command"));
        } else {

            if (Ranks.getRank(player).equalsIgnoreCase("admin")) {
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage(Api.colorize("&aYou have disabled flight"));
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage(Api.colorize("&aYou have enabled flight"));
                }
                return;
            }

            if (Api.checkGamemode(player, "lobby")) {
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage(Api.colorize("&aYou have disabled flight"));
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage(Api.colorize("&aYou have enabled flight"));
                }
            } else {
                player.sendMessage(Api.colorize("&cYou can only use this in-game"));
            }

        }
    }
 }