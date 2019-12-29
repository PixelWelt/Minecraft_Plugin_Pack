package me.soeren.commands.warp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class WarpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(arg3.length == 1) {
				FileConfiguration config = Main.getPlugin().getConfig();
				
				World world = Bukkit.getWorld(config.getString("Warp."+arg3[0]+".World"));
				int x = (int) config.getDouble("Warp."+arg3[0]+".X");
				int y = (int) config.getDouble("Warp."+arg3[0]+".Y");
				int z = (int) config.getDouble("Warp."+arg3[0]+".Z");
				int yaw = (int) config.getDouble("Warp."+arg3[0]+".Yaw");
				int pitch = (int) config.getDouble("Warp."+arg3[0]+".Pitch");
				
				
				Location location = new Location(world, x, y, z, yaw, pitch);
				player.teleport(location);
			}else {
				player.sendMessage("Bitte gib auch einen Zielort an");
			}
		}else {
			sender.sendMessage("Dieser Command ist nur für Spieler");
		}
		return false;
	}
	
}
