package me.soeren.commands.economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class SetMoneyCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("SPP.Economy.SetMoney")) {
				
			
				if(arg3.length == 3) {
					if(arg3[0].contains("add")) {
						Player target = Bukkit.getPlayer(arg3[1]);
						
						FileConfiguration config = Main.getPlugin().getConfig();
						
						double money = config.getDouble("Economy."+target.getDisplayName()+".Money");
						double addAmount =Double.parseDouble(arg3[2]);
						money += addAmount;
						
						config.set("Economy."+target.getDisplayName()+".Money", money);
						Main.getPlugin().saveConfig();
						player.sendMessage("Der Kontostand von: "+target.getDisplayName()+" beträgt nun: " + money);
						}else if(arg3[0].contains("remove")) {
							Player target = Bukkit.getPlayer(arg3[1]);
							
							FileConfiguration config = Main.getPlugin().getConfig();
							
							double money = config.getDouble("Economy."+target.getDisplayName()+".Money");
							double addAmount = Double.parseDouble(arg3[2]);
							money -= addAmount;
							
							config.set("Economy."+target.getDisplayName()+".Money", money);
							player.sendMessage("Der Kontostand von: "+target.getDisplayName()+" beträgt nun: " + money);
							Main.getPlugin().saveConfig();
					}else {
						
					}
				}else {
					
				}
			}else {
				player.sendMessage("Dazu bist du nicht berechtigt");
			}
		}else {
			sender.sendMessage("Dieser Command ist nur für Spieler");
		}
		return false;
	}

}
