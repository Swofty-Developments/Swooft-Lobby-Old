package org.swofty.Core;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.swofty.Events.*;
import org.swofty.Events.LobbyEvents.LobbyEvent;
import org.swofty.Events.LobbyEvents.LobbyJoin;

public final class Loader extends JavaPlugin implements CommandExecutor {

    private static Plugin plugin;

    public void onEnable() {
        plugin = this;

        // Lobby Events
        Bukkit.getPluginManager().registerEvents(new LobbyEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LobbyJoin(), this);

        // General Events
        Bukkit.getPluginManager().registerEvents(new onPlayerDamageByBlock(), this);
        Bukkit.getPluginManager().registerEvents(new onPlayerDamageByEntity(), this);
        Bukkit.getPluginManager().registerEvents(new onPlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new onPlayerTalk(), this);

        Bukkit.getLogger().info("Enabled Core");
        org.swofty.AntiCheat.Loader.anticheatLoader();
    }

    public static Plugin getPluginMain() {
        return plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        org.swofty.Commands.Loader.onCommandLoader(sender, command, label, args);
        return false;
    }
}
