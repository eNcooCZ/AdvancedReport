package cz.eNcoo.AdvancedReport;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getWhoClicked() instanceof Player) {
			String invName = event.getInventory().getName();
			Player player = (Player) event.getWhoClicked();
			ItemStack is = event.getCurrentItem();
			@SuppressWarnings("unused")
			Inventory inv = event.getInventory();
			if (ChatColor.stripColor(invName).equalsIgnoreCase("Report menu")) {
				event.setCancelled(true);
				if (is.getType() == Material.EMPTY_MAP) {
					if (ChatColor.stripColor(is.getItemMeta().getDisplayName())
							.equalsIgnoreCase("EN» Chat vulgarism")) {
						try {
							PreparedStatement sql = MySQL.connection
									.prepareStatement("INSERT INTO `reports` VALUES (null, ?, ?, ?, ?, ?, ?);");
							sql.setString(1, e.getPlayer().getName());
							sql.setString(2, e.getPlayer().getName());
							sql.setString(3, e.getPlayer().getName());
							sql.setString(4, e.getPlayer().getName());
							sql.setString(5, e.getPlayer().getName());
							sql.setString(6, e.getPlayer().getName());
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if (ChatColor.stripColor(is.getItemMeta().getDisplayName()).equalsIgnoreCase("EN» Abuse of bugs")) {
						// Action to do
					}
					if (ChatColor.stripColor(is.getItemMeta().getDisplayName())
							.equalsIgnoreCase("EN» Hacking/Cheating")) {
						player.sendMessage("You clicket to cheating.");
					}
					if (ChatColor.stripColor(is.getItemMeta().getDisplayName()).equalsIgnoreCase("EN» Griefing game")) {
						// Action to do
					}
				}
				if (is.getType() == Material.BARRIER) {
					player.closeInventory();
				}
			}
		}
	}

}
