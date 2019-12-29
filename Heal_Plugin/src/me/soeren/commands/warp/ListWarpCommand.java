package me.soeren.commands.warp;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class ListWarpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("SPP.Warp.List")) {
				FileConfiguration config = Main.getPlugin().getConfig();
				
				ArrayList<String> warppoint = (ArrayList<String>) config.getStringList("Warp.Location");
				player.sendMessage("Warps: "+ warppoint);
			
			}else {
				
			}
		}else {
			
		}
		return false;
	}

}
