package org.swofty.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.swofty.Core.Api;
import org.swofty.Core.Ranks;

public class spawnCommand {

    public static void onSpawnCommand(CommandSender sender, Command command, String label, String[] args, String rank, Boolean allowConsole) {
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

            player.teleport(Api.getSpawn());
            player.sendMessage(Api.colorize("&aTeleported to spawn"));

        }
    }
}
