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

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(player.hasPermission("Jail.jailPlayer")) {
				
				if(arg3.length == 2) {
					Player target = Bukkit.getPlayer(arg3[0]);
					
					if(target != null) {
						
					
						String jail = arg3[1];
						
						target.setGameMode(GameMode.ADVENTURE);
						//target.setCustomName("Gefangener");					
						int xOld = (int) target.getLocation().getX();
						int yOld = (int) target.getLocation().getY();
						int zOld = (int) target.getLocation().getZ();		
						int yawOld = (int) target.getLocation().getYaw();
						int pitchOld = (int) target.getLocation().getPitch();
						String worldOld = target.getLocation().getWorld().getName();
						
						FileConfiguration config = Main.getPlugin().getConfig();
						@SuppressWarnings("unchecked")
						ArrayList<String> jaillist = (ArrayList<String>) config.get("Jail.List");
						if(jaillist.contains(jail)) {
							config.set("Jail.Prisoner."+target.getDisplayName()+".X", xOld );
							config.set("Jail.Prisoner."+target.getDisplayName()+".Y", yOld);
							config.set("Jail.Prisoner."+target.getDisplayName()+".Z", zOld);
							config.set("Jail.Prisoner."+target.getDisplayName()+".Yaw", yawOld);
							config.set("Jail.Prisoner."+target.getDisplayName()+".Pitch", pitchOld);
							config.set("Jail.Prisoner."+target.getDisplayName()+".World", worldOld);
							
							int x = (int) config.get("Jail.Jails."+jail+".X");
							int y = (int) config.get("Jail.Jails."+jail+".Y");
							int z = (int) config.get("Jail.Jails."+jail+".Z");
							int yaw = (int) config.get("Jail.Jails."+jail+".Yaw");
							int pitch = (int) config.get("Jail.Jails."+jail+".Pitch");
							World world = Bukkit.getWorld(config.getString("Jail.Jails."+jail+".World"));
							
							Main.getPlugin().saveConfig();
							
							Location location = new Location(world, x,y,z,yaw,pitch);
							target.teleport(location);
						}else {
							player.sendMessage("Dieses Jail existiert nicht");
						}
					
					}else {
						player.sendMessage("Konnte den Spieler nicht finden");
					}
				}else {
					player.sendMessage("Falsche Syntax");
				}
			}
			
		}
		
		
		return false;
	}

}
