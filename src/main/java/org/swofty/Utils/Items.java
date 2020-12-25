package org.swofty.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.swofty.Core.Api;

public class Items {

    public void giveLobbyItems(Player player) {
        // Create Item Instances
        ItemStack rules = new ItemStack(Material.IRON_SWORD);
        ItemMeta rulesMeta = rules.getItemMeta();
        rulesMeta.setDisplayName(Api.colorize("&cRules"));
        rules.setItemMeta(rulesMeta);

        ItemStack ranked = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta rankedMeta = ranked.getItemMeta();
        rankedMeta.setDisplayName(ChatColor.GOLD + "Ranked Duels");
        ranked.setItemMeta(rankedMeta);

        ItemStack ffa = new ItemStack(Material.NETHER_STAR);
        ItemMeta ffaMeta = ffa.getItemMeta();
        ffaMeta.setDisplayName(ChatColor.GOLD + "FFA");
        ffa.setItemMeta(ffaMeta);

        ItemStack events = new ItemStack(Material.BOOK);
        ItemMeta eventsMeta = events.getItemMeta();
        eventsMeta.setDisplayName(ChatColor.GOLD + "Events");
        events.setItemMeta(eventsMeta);

        ItemStack reports = new ItemStack(Material.COMPASS);
        ItemMeta reportsMeta = reports.getItemMeta();
        reportsMeta.setDisplayName(ChatColor.GOLD + "Report a Player");
        reports.setItemMeta(reportsMeta);

        ItemStack mods = new ItemStack(Material.CHEST);
        ItemMeta modsMeta = mods.getItemMeta();
        modsMeta.setDisplayName(ChatColor.GOLD + "Mods/Cosmetics");
        mods.setItemMeta(modsMeta);

        // Put in Inventory
        Inventory inv = player.getInventory();
        inv.setItem(0 , rules);
        inv.setItem(4, ffa);
        inv.setItem(8, mods);
    }

}
