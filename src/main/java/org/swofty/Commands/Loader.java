package org.swofty.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.swofty.Core.Api;

public class Loader {

    public static boolean onCommandLoader(CommandSender sender, Command command, String label, String[] args) {
        switch (label) {
            case "spawn":
                spawnCommand.onSpawnCommand(sender, command, label, args, "all", false);
                break;

            case "setspawn":
                setspawnCommand.onSetSpawnCommand(sender, command, label, args, "admin", false);
                break;

            case "fly":
                flyCommand.onFlyCommand(sender, command, label, args, "vip", false);
                break;

            case "adminlog":
                adminlogCommand.onAdminLogCommand(sender, command, label, args, "admin", false);
                break;

            case "gamemode":
            case "gm":
                gmCommand.onGmCommand(sender, command, label, args, "admin", false);
                break;

        }

        return false;
    }
}
