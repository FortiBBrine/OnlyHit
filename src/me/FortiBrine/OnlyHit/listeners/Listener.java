package me.FortiBrine.OnlyHit.listeners;

// import org.bukkit.Bukkit;
import org.bukkit.Location;
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
		
		Location loc = entity.getLocation();
		long x = (long) loc.getX();
		long y = (long) loc.getY();
		long z = (long) loc.getZ();
		String world = loc.getWorld().getName();
		
		String message = config.getString("player.message");
		message = message.replace("%player", damager.getDisplayName());
		message = message.replace("%user", damager.getName());
		message = message.replace("%item", damager.getInventory().getItemInMainHand().getType().name());
		message = message.replace("%x", ""+x);
		message = message.replace("%y", ""+y);
		message = message.replace("%z", ""+z);
		message = message.replace("%world", world);
		message = message.replace("&", "\u00a7");
		
		entity.sendMessage(message);
		
		message = config.getString("console.message");
		message = message.replace("%player1", damager.getDisplayName());
		message = message.replace("%player2", entity.getDisplayName());
		message = message.replace("%user1", damager.getName());
		message = message.replace("%user2", entity.getName());
		message = message.replace("%item", damager.getInventory().getItemInMainHand().getType().name());
		message = message.replace("%x", ""+x);
		message = message.replace("%y", ""+y);
		message = message.replace("%z", ""+z);
		message = message.replace("%world", world);
		message = message.replace("&", "\u00a7");
		
		plugin.getLogger().info(message);
		
	}
}
