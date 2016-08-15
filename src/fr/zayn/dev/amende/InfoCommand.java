package fr.zayn.dev.amende;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor
{
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
	  {
		  Player p = (Player)sender;
		    if (commandLabel.equalsIgnoreCase("ainfo"))
		    {
		    	p.sendMessage("");
		    	p.sendMessage("§6-----==={ Amende }===-----");
		    	p.sendMessage("");
		    	p.sendMessage("Auteur: §dMine_ZaYn §f(ZaYnDev)");
		    	p.sendMessage("WebSite: §dhttp://zayn-dev.pe.hu/");
		    	p.sendMessage("");
		    	p.sendMessage("Plugin: §dType RP, le but étant de pouvoir mettre des amendes a nos très chers joueurs !");
		    	p.sendMessage("");
		    	p.sendMessage("A faire: ");
		    //DONE:	p.sendMessage("- Un système de menotte ? §aEn cours...");
		    	p.sendMessage("- Les messages configurables ? §eEn réflexion...");
		    	p.sendMessage("- Des amendes automatiques ? §eIdée de §6Drahoxx §esur §aMinecraft.fr");
		    	p.sendMessage("- Vos idées ? §cOn attends...");
		    	p.sendMessage("");
		    	p.sendMessage("§6-----==={ ZaYn }===-----");
		    	p.sendMessage("");
		    }
		    
		    
		    return false;
	  }
	  

}
