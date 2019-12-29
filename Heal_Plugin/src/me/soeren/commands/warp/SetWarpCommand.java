package me.soeren.commands.warp;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class SetWarpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("SPP.Warp.set")) {
				if(arg3.length == 0) {
					player.sendMessage("bitte gib einen Namen für den Warppunkt an");
					
				}else {
					
					
					int x =(int) player.getLocation().getX();
					int y = (int) player.getLocation().getY();
					int z = (int) player.getLocation().getZ();
					int yaw = (int) player.getLocation().getYaw();
					int pitch = (int) player.getLocation().getPitch();
					String world = player.getLocation().getWorld().getName();
					
					FileConfiguration config = Main.getPlugin().getConfig();
					ArrayList<String> warppoint = (ArrayList<String>) config.getStringList("Warp.Location");
					
					config.set("Warp."+arg3[0]+".World", world);
					config.set("Warp."+arg3[0]+".X", x);
					config.set("Warp."+arg3[0]+".Y", y);
					config.set("Warp."+arg3[0]+".Z", z);
					config.set("Warp."+arg3[0]+".Pitch", pitch);
					config.set("Warp."+arg3[0]+".Yaw", yaw);
					
					warppoint.add(arg3[0]);
					config.set("Warp.Location", warppoint);
						
					Main.getPlugin().saveConfig();
					
					player.sendMessage("Warppunkt gesetzt");
				}
			}else {
				player.sendMessage("Dazu bist du nicht berechtigt");
			}
			
		}else {
			sender.sendMessage("Dieser command ist nur für Spieler");
		}
		return false;
	}

}
