package me.soeren.commands.jails;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.soeren.main.Main;

public class addJailCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {
		FileConfiguration config = Main.getPlugin().getConfig();
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(arg3.length == 1) {
				int x =(int) player.getLocation().getX();
				int y = (int) player.getLocation().getY();
				int z = (int) player.getLocation().getZ();
				int yaw = (int) player.getLocation().getYaw();
				int pitch = (int) player.getLocation().getPitch();
				String world = player.getLocation().getWorld().getName();
				
				config.set("Jail.Jails."+arg3[0]+".World", world);
				config.set("Jail.Jails."+arg3[0]+".X", x);
				config.set("Jail.Jails."+arg3[0]+".Y", y);
				config.set("Jail.Jails."+arg3[0]+".Z", z);
				config.set("Jail.Jails."+arg3[0]+".Pitch", pitch);
				config.set("Jail.Jails."+arg3[0]+".Yaw", yaw);
				
				
				ArrayList<String> jaillist = (ArrayList<String>) config.getStringList("Jail.List");
				String jail = arg3[0];
				jaillist.add(jail);
				config.set("Jail.List", jaillist);
				Main.getPlugin().saveConfig();
				
				
				player.sendMessage("Jail erfolgreich gesetzt");
				
			}else {
				
			}
		}
		return false;
	}

}
