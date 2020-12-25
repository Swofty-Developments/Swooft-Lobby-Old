package org.swofty.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.swofty.Core.Admin;
import org.swofty.Core.Api;
import org.swofty.Core.Ranks;
import org.swofty.Core.Scoreboard;

public class adminlogCommand {

    public static void onAdminLogCommand(CommandSender sender, Command command, String label, String[] args, String rank, Boolean allowConsole) {
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

            if (!Admin.getAdminLogging(player)) {

                switch (Api.getGamemode(player)) {
                    case "lobby":
                        Scoreboard.setLobbyAdminScoreboard(player);
                        Admin.setAdminLogging(player, true);
                        player.sendMessage(Api.colorize("&aEnabled admin-logging"));


                }

            } else {

                switch (Api.getGamemode(player)) {
                    case "lobby":
                        Scoreboard.setLobbyScoreboard(player);
                        Admin.setAdminLogging(player, false);
                        player.sendMessage(Api.colorize("&aDisabled admin-logging"));


                }

            }
        }
    }
 }