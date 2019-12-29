package me.soeren.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitRocket implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
				Inventory rocketInventory = Bukkit.createInventory(null, 9, "§6§L KitInventar");
				ItemStack rocket = new ItemStack(Material.FIREWORK_ROCKET);
				ItemMeta rocketItemMeta = rocket.getItemMeta();
				rocketItemMeta.setDisplayName("§6wusch");
				rocket.setAmount(64);
				rocketInventory.setItem(4, rocket);
				rocketInventory.setItem(0, rocket);
				rocketInventory.setItem(8, rocket);

				player.openInventory(rocketInventory);
				
			}else {
				sender.sendMessage("§4Dieser Command ist nur für Spieler verfügbar");
			}
		return false;
	}
}