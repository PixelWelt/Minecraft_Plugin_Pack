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
				
				if(!(target == null)) {
					target.setGameMode(GameMode.SURVIVAL);
					
					FileConfiguration config = Main.getPlugin().getConfig();

					int x = (int) config.getDouble("Jail.Prisoner."+target.getDisplayName()+".X");
					int y = (int) config.getDouble("Jail.Prisoner."+target.getDisplayName()+".Y");
					int z = (int) config.getDouble("Jail.Prisoner."+target.getDisplayName()+".Z");
					int yaw = (int) config.getDouble("Jail.Prisoner."+target.getDisplayName()+".Yaw");
					int pitch = (int) config.getDouble("Jail.Prisoner."+target.getDisplayName()+".Pitch");
					World world = Bukkit.getWorld(config.getString("Jail.Prisoner."+target.getDisplayName()+".World"));
					Location location = new Location(world, x, y, z, yaw, pitch);
					target.teleport(location);

					player.sendMessage(target.getDisplayName()+" Wurde befreit");
				}
			}else {
				
			}
		}
		return false;
	}

}
