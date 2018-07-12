package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.lloydplayzhd.hdcore.Main;

public class Survival implements CommandExecutor {
	private Main plugin;
  public Survival(Main pl) {
	  plugin = pl;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	    if (!(sender instanceof Player)) {
	    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
	        return false;	      }
	      Player p = (Player)sender;
	      if (p.hasPermission("gamemode.survival")) {
	          String Prefix;
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	          String Survival;
	          Survival= ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Survival"));
	          p.sendMessage(Prefix + " " + Survival);
	          p.setGameMode(GameMode.SURVIVAL);
           return true;
	      } else {
	          String Prefix;
	          String SurvivalNoPerm;
	          SurvivalNoPerm = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("SurvivalNoPerm"));
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	        p.sendMessage(Prefix + " " + SurvivalNoPerm);
    return true;
  }
}
}

