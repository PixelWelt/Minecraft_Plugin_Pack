package me.soeren.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor{
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player) {
			Player player = (Player) arg0;
			if(arg3.length == 0) {
				player.setHealth(20.0);
				player.setFoodLevel(20);			
				player.sendMessage("§6 Du wurdest geheilt");
			}else if(arg3.length == 1){
				Player target = Bukkit.getPlayer(arg3[0]);
				if(target != null) {
					target.setHealth(20.0);
					target.setFoodLevel(20);
					target.sendMessage("§6 Du wurdest von §6"+ player.getDisplayName() +"§6geheilt");
					player.sendMessage("§6 Du hast den Spieler §e" +target.getDisplayName() + " §6geheilt" );
				}else {
					player.sendMessage("§cERROR 404 Player: "+ arg3[0] + " §cnot found");
				}
			}else {
				player.sendMessage("Bitte nutze §6/heal <Spieler>");
			}
			
		}else {
			arg0.sendMessage("§4Dieser Command ist nur für Spieler verfügbar");
			return false;
		}
		
		return false;
	}
	
}
