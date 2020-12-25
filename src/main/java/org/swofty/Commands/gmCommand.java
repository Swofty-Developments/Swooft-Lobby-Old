package org.swofty.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.swofty.Core.Api;
import org.swofty.Core.Ranks;

 public class gmCommand {

    public static void onGmCommand(CommandSender sender, Command command, String label, String[] args, String rank, Boolean allowConsole) {
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

            if (args.length == 0) {
                player.sendMessage(Api.colorize("&aYou have to select a gamemode"));
                return;
            }

            switch (args[0]) {
                case "0":
                case "s":
                case "survival":
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Api.colorize("&aYou have set your gamemode to SURVIVAL"));
                    return;

                case "1":
                case "c":
                case "creative":
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(Api.colorize("&aYou have set your gamemode to CREATIVE"));
                    return;

                case "2":
                case "a":
                case "adventure":
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(Api.colorize("&aYou have set your gamemode to ADVENTURE"));
                    return;
            }

            player.sendMessage(Api.colorize("&aCould not find gamemode '" + args[0] + "'"));
        }
    }
 }