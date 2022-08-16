package me.FortiBrine.OnlyHit.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.FortiBrine.OnlyHit.main.Main;

public class Listener implements org.bukkit.event.Listener {
	
	private Main plugin;
	public Listener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		
		FileConfiguration config = plugin.getConfig();
		
		if (event.isCancelled()) return;
		
		if (!(event.getDamager() instanceof Player)) return;
		if (!(event.getEntity() instanceof Player)) return;
		
		Player damager = (Player) event.getDamager();
		Player entity = (Player) event.getEntity();
		
		String message = config.getString("message");
		message = message.replace("%player", damager.getDisplayName());
		message = message.replace("%user", damager.getName());
		message = message.replace("&", "\u00a7");
		
		entity.sendMessage(message);
	
	}
}
