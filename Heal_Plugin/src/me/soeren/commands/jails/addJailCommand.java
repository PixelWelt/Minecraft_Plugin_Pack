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
			if(arg3.length >= 0) {
				config.set("Jail.Jails."+arg3[0]+".X", player.getLocation().getX());
				config.set("Jail.Jails."+arg3[0]+".Y", player.getLocation().getY());
				config.set("Jail.Jails."+arg3[0]+".Z", player.getLocation().getZ());
				config.set("Jail.Jails."+arg3[0]+".Yaw", player.getLocation().getYaw());
				config.set("Jail.Jails."+arg3[0]+".Pitch", player.getLocation().getPitch());
				config.set("Jail.Jails."+arg3[0]+".World", player.getWorld().getName());
				@SuppressWarnings("unchecked")
				ArrayList<String> jaillist = (ArrayList<String>) config.get("Jail.List");
				jaillist.add(arg3[0]);
				config.set("Jail.List", jaillist);
				Main.getPlugin().saveConfig();
				
				
				player.sendMessage("Jail erfolgreich gesetzt");
				
			}else {
				
			}
		}
		return false;
	}

}
