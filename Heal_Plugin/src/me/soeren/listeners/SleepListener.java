package me.soeren.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class SleepListener implements Listener{
	
	public void onPlayerWakeUp(PlayerBedLeaveEvent event) {
		Player player = event.getPlayer();
		player.sendMessage("Guten Morgen Sonnenschein");
	}
	public void onPlayersleeptry(PlayerBedEnterEvent event) {
		Player player = event.getPlayer();
		player.setBedSpawnLocation(player.getLocation());
		player.sendMessage("Spawnpunkt gesetzt");
	}
}
