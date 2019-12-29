package me.soeren.commands.economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class BalanceCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			FileConfiguration config = Main.getPlugin().getConfig();
			double money = config.getDouble("Economy."+player.getDisplayName()+".Money");
			player.sendMessage("Du hast: "+money+" Euronen");
			Main.getPlugin().saveConfig();
		}else {
			sender.sendMessage("Dieser Command darf nur von Spielern benutzt werden");
				
			
		}
		return false;
	}
	
}
