package me.soeren.commands.jails;

import java.util.ArrayList;

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

public class JailPlayerCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender command, Command sender, String label, String[] arg3) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("Jail.jailPlayer")) {
				if(arg3.length == 2) {
					Player target = Bukkit.getPlayer(arg3[0]);
					if(target != null) {
						
					
						String jail = arg3[1];
						
						target.setGameMode(GameMode.ADVENTURE);
						//target.setCustomName("Gefangener");					
						
						
						
						FileConfiguration config = Main.getPlugin().getConfig();
						@SuppressWarnings("unchecked")
						ArrayList<String> jaillist = (ArrayList<String>) config.get("Jail.List");
						if(jaillist.contains(jail)) {
							config.set("Jail.Prisoner."+target+".X", target.getLocation().getX());
							config.set("Jail.Prisoner."+target+".Y", target.getLocation().getY());
							config.set("Jail.Prisoner."+target+".Z", target.getLocation().getZ());
							config.set("Jail.Prisoner."+target+".Yaw", target.getLocation().getYaw());
							config.set("Jail.Prisoner."+target+".Pitch", target.getLocation().getPitch());
							
							int x = (int) config.get("Jail.Jails."+jail+".X");
							int y = (int) config.get("Jail.Jails."+jail+".Y");
							int z = (int) config.get("Jail.Jails."+jail+".Z");
							int yaw = (int) config.get("Jail.Jails."+jail+".Yaw");
							int pitch = (int) config.get("Jail.Jails."+jail+".Pitch");
							World world = Bukkit.getWorld(config.getString("Jail.Jails."+jail+".World"));
							
							Location location = new Location(world, x,y,z,yaw,pitch);
							target.teleport(location);
						}else {
							player.sendMessage("Dieses Jail exxistiert nicht");
						}
					
					}else {
						
					}
				}else {
					
				}
			}
			
		}
		
		
		return false;
	}

}
