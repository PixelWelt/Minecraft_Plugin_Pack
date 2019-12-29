package me.soeren.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class SpawnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("SPP.spawn")) {
				
				FileConfiguration config = Main.getPlugin().getConfig();
				World world = Bukkit.getWorld(config.getString("Spawn.World"));
				double x = config.getDouble("Spawn.X");
				double y = config.getDouble("Spawn.Y");
				double z = config.getDouble("Spawn.Z");
				float yaw = (float) config.getDouble("Spawn.Yaw");
				float pitch = (float) config.getDouble("Spawn.Pitch");
				
				Location location = new Location(world, x, y, z, yaw, pitch);
				player.teleport(location);
				
				
			}else {
				player.sendMessage("§cDazu bist du nicht berechtigt");
			}
		}else {
			sender.sendMessage("§cDieser Command ist nur für Spieler");
		}
		
		return false;
	}

}
