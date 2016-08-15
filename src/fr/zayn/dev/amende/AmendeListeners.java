package fr.zayn.dev.amende;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AmendeListeners 
	implements Listener
{
	public int size;
	
	@EventHandler
	public void onClickInventory(InventoryClickEvent e)
	{
		Player p = (Player)e.getWhoClicked();
		if (e.getInventory().getName().contains("Amende de"))
		{
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aAccepter le payment"))
			{
				Bukkit.broadcastMessage("§6" + p.getName() + " §aa accepté de payer l'amende. (" + AmendeCommands.getAmount() + " " + Main.getPlugin().getConfig().getString("ServerMoney") + ")");
				Main.getInstance();Main.getEconomy().withdrawPlayer(p, AmendeCommands.getAmount());
				Player p1;
				for (Iterator localIterator = Bukkit.getOnlinePlayers().iterator(); localIterator.hasNext(); Main.getEconomy().depositPlayer(p1, AmendeCommands.getAmount() / getSize()))
				{
					p1 = (Player)localIterator.next();
					if (p1.hasPermission("amende.police")) {
						this.size = (Bukkit.getOnlinePlayers().size() - 1);
					}
					Main.getInstance();
				}
				p.closeInventory();
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cRefuser le payment"))
			{
				Bukkit.broadcastMessage("§6" + p.getName() + " §ca refusé de payer une amende. (" + AmendeCommands.getAmount() + " " + Main.getPlugin().getConfig().getString("ServerMoney") + ")");
				p.closeInventory();
			}
		}
	}
	
	public int getSize()
	{
		return this.size;
	}

}
