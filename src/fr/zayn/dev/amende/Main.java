package fr.zayn.dev.amende;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin implements Listener
{
	private static Main plugin;
	public static Main instance;
	public static Economy economy;
	public static boolean isArrested;
	public List<UUID> freeze = new ArrayList();
	FileConfiguration config;
	File cFile;
	
	public static Plugin getPlugin()
	{
		return Bukkit.getPluginManager().getPlugin("Amende");
	}
	public void onEnable()
	{
		instance = this;
		
		this.config = getConfig();
	    this.config.options().copyDefaults(true);
		saveConfig();
		
		isArrested = false;
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new AmendeListeners(), this);
		if ((Bukkit.getPluginManager().getPlugin("Vault") instanceof Vault))
		{
			RegisteredServiceProvider<Economy> service = Bukkit.getServicesManager().getRegistration(Economy.class);
			if (service != null) {
				economy = (Economy)service.getProvider();
			}
		}
		getCommand("amende").setExecutor(new AmendeCommands());
		getCommand("ainfo").setExecutor(new InfoCommand());
	}

	
	public static Main getInstance()
	{
		return instance;
	}
	
	public static Economy getEconomy()
	{
		return economy;
	}

}
