package org.swofty.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.swofty.Core.Api;
import org.swofty.Core.Ranks;

public class setspawnCommand {

    public static void onSetSpawnCommand(CommandSender sender, Command command, String label, String[] args, String rank, Boolean allowConsole) {
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

            Api.setSpawn(player.getLocation());
            player.sendMessage(Api.colorize("&aYou have set spawn to " + Api.getSpawn().getBlockX() + " " + Api.getSpawn().getBlockY() + " " + Api.getSpawn().getBlockZ()));

        }
    }
 }