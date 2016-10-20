package cz.eNcoo.AdvancedReport;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	Server server = Bukkit.getServer();

	@Override
	public void onEnable() {
		server.getPluginManager().registerEvents(new Listeners(), this);
		getCommand("report").setExecutor(this);
	}

	@Override
	public void onDisable() {

	}

	private void reportPlayerGUI(Player reporter, Player reported) {
		Inventory inv = server.createInventory(null, 54, "§8§lReport menu");
		// Chat vulgarism
		ItemStack cv = new ItemStack(Material.EMPTY_MAP);
		ItemMeta cvMeta = cv.getItemMeta();
		ArrayList<String> cvLore = new ArrayList<String>();
		// Abuse of bugs
		ItemStack aob = new ItemStack(Material.EMPTY_MAP);
		ItemMeta aobMeta = aob.getItemMeta();
		ArrayList<String> aobLore = new ArrayList<String>();
		// Hacking
		ItemStack h = new ItemStack(Material.EMPTY_MAP);
		ItemMeta hMeta = h.getItemMeta();
		ArrayList<String> hLore = new ArrayList<String>();
		// Griefing game
		ItemStack gg = new ItemStack(Material.EMPTY_MAP);
		ItemMeta ggMeta = gg.getItemMeta();
		ArrayList<String> ggLore = new ArrayList<String>();
		// Long-term AFK
		ItemStack lta = new ItemStack(Material.EMPTY_MAP);
		ItemMeta ltaMeta = lta.getItemMeta();
		ArrayList<String> ltaLore = new ArrayList<String>();
		// Most frequently used
		@SuppressWarnings("deprecation")
		ItemStack mfu = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
		ItemMeta mfuMeta = mfu.getItemMeta();
		@SuppressWarnings("unused")
		ArrayList<String> mfuLore = new ArrayList<String>();
		// Frequently used
		@SuppressWarnings("deprecation")
		ItemStack fu = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.ORANGE.getData());
		ItemMeta fuMeta = fu.getItemMeta();
		@SuppressWarnings("unused")
		ArrayList<String> fuLore = new ArrayList<String>();
		// Less used
		@SuppressWarnings("deprecation")
		ItemStack lu = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.YELLOW.getData());
		ItemMeta luMeta = fu.getItemMeta();
		@SuppressWarnings("unused")
		ArrayList<String> luLore = new ArrayList<String>();
		// Barrier
		ItemStack barrier = new ItemStack(Material.BARRIER);
		ItemMeta barrierMeta = barrier.getItemMeta();
		@SuppressWarnings("unused")
		ArrayList<String> barrierLore = new ArrayList<String>();
		// Skull of reported player
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		skullMeta.setDisplayName("§7You reporting §c" + reported.getName() + "§7.");
		skullMeta.setOwner(reported.getName());
		skull.setItemMeta(skullMeta);

		cvMeta.setDisplayName("§2§lEN§8§l» §c§lChat vulgarism");
		cvLore.add("§2§lCZ§8§l» §c§lNadavky v chatu");
		cvMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		cvMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		cvMeta.setLore(cvLore);
		cv.setItemMeta(cvMeta);

		aobMeta.setDisplayName("§2§lEN§8§l» §c§lAbuse of bugs");
		aobLore.add("§2§lCZ§8§l» §c§lZneuzivani bugu");
		aobMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		aobMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		aobMeta.setLore(aobLore);
		aob.setItemMeta(aobMeta);

		hMeta.setDisplayName("§2§lEN§8§l» §c§lHacking/Cheating");
		hLore.add("§2§lCZ§8§l» §c§lHacky/Podvadeni");
		hMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		hMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		hMeta.setLore(hLore);
		h.setItemMeta(hMeta);

		ggMeta.setDisplayName("§2§lEN§8§l» §c§lGriefing game");
		ggLore.add("§2§lCZ§8§l» §c§lKazi hru");
		ggMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ggMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		ggMeta.setLore(ggLore);
		gg.setItemMeta(ggMeta);

		ltaMeta.setDisplayName("§2§lEN§8§l» §c§lLong-term AFK");
		ltaLore.add("§2§lCZ§8§l» §c§lDlouhodoba neaktivita");
		ltaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ltaMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		ltaMeta.setLore(ltaLore);
		lta.setItemMeta(ltaMeta);

		mfuMeta.setDisplayName("§7Most frequently used.");
		mfu.setItemMeta(mfuMeta);

		fuMeta.setDisplayName("§7Frequently used.");
		fu.setItemMeta(fuMeta);

		luMeta.setDisplayName("§7Less used.");
		lu.setItemMeta(luMeta);

		barrierMeta.setDisplayName("§7Quit");
		barrier.setItemMeta(barrierMeta);

		inv.setItem(4, skull);
		inv.setItem(8, barrier);
		inv.setItem(18, lu);
		inv.setItem(20, fu);
		inv.setItem(22, mfu);
		inv.setItem(24, fu);
		inv.setItem(26, lu);
		inv.setItem(27, cv);
		inv.setItem(29, aob);
		inv.setItem(31, h);
		inv.setItem(33, gg);
		inv.setItem(35, lta);
		inv.setItem(36, lu);
		inv.setItem(38, fu);
		inv.setItem(40, mfu);
		inv.setItem(42, fu);
		inv.setItem(44, lu);

		reporter.openInventory(inv);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("report")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 1 && args[0] != "help") {
					if (server.getPlayer(args[0]) != null) {
						reportPlayerGUI(player, server.getPlayer(args[0]));
						return true;
					} else {
						player.sendMessage("§4§lError§8§l» §7Player §c" + args[0] + " §7is not online.");
						return true;
					}
				}
				player.sendMessage("§4§lError§8§l» §7Try §c/report help §7for help.");
				return true;
			}
			sender.sendMessage("Error > This command is only for ingame use.");
			return true;
		}
		return true;
	}
}
