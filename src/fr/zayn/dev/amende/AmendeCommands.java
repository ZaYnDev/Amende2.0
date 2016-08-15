package fr.zayn.dev.amende;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AmendeCommands implements CommandExecutor
{
	static Player police;
	public static int montant;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		police = (Player)sender;
		if (!(sender instanceof Player)) {
			return false;
		}
		if (!sender.hasPermission("amende.exe")) {
			return false;
		}
		if (args.length == 0) {
			sender.sendMessage("§cArguments invalides : Essayez §a/amende §c<name> <amount>");
			return true;
		}
		Player victime = Bukkit.getPlayer(args[0]);
		if ((args.length == 1) && (victime != null)) {
			sender.sendMessage("§cArgument invaldes : Essayez §a/amende <name> §c<amount>");
			return true;
		}
		if ((args.length == 1) && (victime == null)) {
			sender.sendMessage("§c" + victime.getName() + " n'existe pas.");
			return false;
		}
		if (args.length > 2) {
			sender.sendMessage("§cArguments invalides : Essayez §a/amende §c<name> <amount>");
			return false;
		}
		montant = Integer.parseInt(args[1]);
		if ((args.length == 2) && (victime != null)) {
			Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "Amende de " + args[1] + " " + Main.getPlugin().getConfig().getString("ServerMoney")); 
			
			ItemStack refused = new ItemStack(Material.WOOL, 1, DyeColor.RED.getDyeData());
			ItemMeta mrefused = refused.getItemMeta();
			mrefused.setDisplayName("§cRefuser le payment");
			refused.setItemMeta(mrefused);
			
			ItemStack accepted = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getDyeData());
			ItemMeta maccepted = refused.getItemMeta();
			maccepted.setDisplayName("§aAccepter le payment");
			accepted.setItemMeta(maccepted);
			
			inv.setItem(1, refused);
			inv.setItem(3, accepted);
			if (montant <= 0)
			{
				sender.sendMessage("§cA quoi bon donner une amende de 0 " + Main.getPlugin().getConfig().getString("ServerMoney") + " ?!");
				return false;
			}
			Main.getInstance();
			if (Main.getEconomy().getBalance(victime) < montant) {
				police.sendMessage("§6" + victime.getName() + " §cn'a pas assez d'argent pour payer cette amende. Le joueur ne possède que: " + Main.getEconomy().getBalance(victime) + Main.getPlugin().getConfig().getString("ServerMoney"));
			}else{
				victime.openInventory(inv);
			}
		}
		return false;
	}
	
	public static int getAmount()
	{
		return montant;
	}
	
	public static Player getPolicer()
	{
		return police;
	}

}
