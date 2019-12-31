package me.soeren.commands.jails;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class unJailCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(arg3.length == 1) {
				Player target = Bukkit.getPlayer(arg3[0]);
				if(target != null) {
					FileConfiguration config = Main.getPlugin().getConfig();
					int x = config.getInt("Jail.Prisoner."+target+".X");
					int y = config.getInt("Jail.Prisoner."+target+".Y");
					int z = config.getInt("Jail.Prisoner."+target+".Z");
					int yaw = config.getInt("Jail.Prisoner."+target+".Yaw");
					int pitch = config.getInt("Jail.Prisoner."+target+".Pitch");
					World world = Bukkit.getWorld(config.getString("Jail.Prisoner."+target+".World"));
					
					Location location = new Location(world, x, y, z, yaw, pitch);
					target.setGameMode(GameMode.SURVIVAL);
					target.teleport(location);
					
					player.sendMessage(target.getDisplayName()+" Wurde befreit");
				}
			}else {
				
			}
		}
		return false;
	}

}
