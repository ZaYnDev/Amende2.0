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
		    	p.sendMessage("�6-----==={ Amende }===-----");
		    	p.sendMessage("");
		    	p.sendMessage("Auteur: �dMine_ZaYn �f(ZaYnDev)");
		    	p.sendMessage("WebSite: �dhttp://zayn-dev.pe.hu/");
		    	p.sendMessage("");
		    	p.sendMessage("Plugin: �dType RP, le but �tant de pouvoir mettre des amendes a nos tr�s chers joueurs !");
		    	p.sendMessage("");
		    	p.sendMessage("A faire: ");
		    //DONE:	p.sendMessage("- Un syst�me de menotte ? �aEn cours...");
		    	p.sendMessage("- Les messages configurables ? �eEn r�flexion...");
		    	p.sendMessage("- Des amendes automatiques ? �eId�e de �6Drahoxx �esur �aMinecraft.fr");
		    	p.sendMessage("- Vos id�es ? �cOn attends...");
		    	p.sendMessage("");
		    	p.sendMessage("�6-----==={ ZaYn }===-----");
		    	p.sendMessage("");
		    }
		    
		    
		    return false;
	  }
	  

}
