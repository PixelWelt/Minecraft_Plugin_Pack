package me.soeren.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.soeren.commands.ClearChatCommand;
import me.soeren.commands.HealCommand;
import me.soeren.commands.KitRocket;
import me.soeren.commands.SetSpawnCommand;
import me.soeren.commands.SpawnCommand;
import me.soeren.commands.economy.BalanceCommand;
import me.soeren.commands.economy.PayCommand;
import me.soeren.commands.economy.SetMoneyCommand;
import me.soeren.commands.warp.ListWarpCommand;
import me.soeren.commands.warp.SetWarpCommand;
import me.soeren.commands.warp.WarpCommand;
import me.soeren.listeners.JoinListener;
import me.soeren.listeners.SleepListener;


public class Main extends JavaPlugin{
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		
		logger.info("Soerens Plugin Paket erfolgreich geladen");
		
		//essentials
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		
	
		
		//Admincommands
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("clearchat").setExecutor(new ClearChatCommand());
		
		//kitcommands
		getCommand("KitRocket").setExecutor(new KitRocket());
		
		//economy Commands
		getCommand("pay").setExecutor(new PayCommand());
		getCommand("balance").setExecutor(new BalanceCommand());
		getCommand("setMoney").setExecutor(new SetMoneyCommand());
		
		//warp Commands
		getCommand("setwarp").setExecutor(new SetWarpCommand());
		getCommand("Warp").setExecutor(new WarpCommand());
		getCommand("listwarp").setExecutor(new ListWarpCommand());
		
		//listener
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new JoinListener(), this);
		pluginManager.registerEvents(new SleepListener(), this);
	}

	public void onDisable() {
		logger.info("Ciao");
		logger.info("");
	}

	public static Main getPlugin() {
		return plugin;
	}

	public static void setPlugin(Main plugin) {
		Main.plugin = plugin;
	}
}
