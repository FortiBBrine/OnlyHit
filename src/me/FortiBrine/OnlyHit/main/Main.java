package me.FortiBrine.OnlyHit.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.FortiBrine.OnlyHit.listeners.Listener;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		File config = new File(this.getDataFolder()+File.separator+"config.yml");
		if (!config.exists()) {
			this.getConfig().options().copyDefaults(true);
			this.saveDefaultConfig();
		}
		
		Bukkit.getPluginManager().registerEvents(new Listener(this), this);
	}
}
