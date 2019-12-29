package me.soeren.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class SetSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("SPP.setSpawn")) {
				
			
				if(arg3.length == 0) {
					FileConfiguration config = Main.getPlugin().getConfig();
					config.set("Spawn.World", player.getWorld().getName());
					config.set("Spawn.X", player.getLocation().getX());
					config.set("Spawn.Y", player.getLocation().getY());
					config.set("Spawn.Z", player.getLocation().getZ());
					config.set("Spawn.Yaw", player.getLocation().getYaw());
					config.set("Spawn.Pitch", player.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					player.sendMessage("§bSpawnpunkt erfolgreich gesetzt");
					
				}else {
					player.sendMessage("§cBitte benutze den command richtig");
				}
			}else {
				sender.sendMessage("Dieser Command ist nur für Spieler");
			}
		}
		return false;
	}
	
}
