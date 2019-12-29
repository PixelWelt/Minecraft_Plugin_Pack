package me.soeren.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("SPP.ClearChat")) {
				if(arg3.length == 0){
					
					for(int i = 0; i <= 500; i++) {
						Bukkit.broadcastMessage("    ");
					}
					player.sendMessage("§aChat erfolgreich geleert");
					
				}else {
					player.sendMessage("§ebitte benutze §b/clearchat");
				}
				
			}else {
				player.sendMessage("§cDazu hast du keine Berechtigung");
			}
		}else {
			sender.sendMessage("§cDieser Command darf nur von Spielern benutzt werden");
		}
		return false;
	}

}
