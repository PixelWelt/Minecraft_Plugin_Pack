package me.soeren.commands.economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class PayCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(player.hasPermission("SPP.Pay")) {
				if(arg3.length == 2) {
					FileConfiguration config = Main.getPlugin().getConfig();
					double money = config.getDouble("Economy." + player.getDisplayName() +".Money");
					double paidAmount = Double.parseDouble(arg3[1]);
					Player target = Bukkit.getPlayer(arg3[0]);
					if(target != null) {
						if(paidAmount <= money) {
							double targetmoney = config.getDouble("Economy."+target.getDisplayName()+".Money");
							targetmoney += paidAmount;
							config.set("Economy."+target+".Money", targetmoney);
							money =- paidAmount;
							config.set("Economy."+player+".Money", money);
							player.sendMessage("Du hast den Spieler "+target.getDisplayName() +" erfolgreich bezahlt" );
							Main.getPlugin().saveConfig();
						}else {
							player.sendMessage("§cDu hast nicht genug Geld");
						}
					}else {
						player.sendMessage("§cERROR 404 Player: "+ arg3[0] + " §cnot found");
					}
					
				}else {
					player.sendMessage("§cBitte gib auch an wen und wieviel du bezahlen willst");
				}
				
				
			}else {
				player.sendMessage("Dazu hast du keine Berechtigung");
			}
		}else {
			
		}
		return false;
	}

}
