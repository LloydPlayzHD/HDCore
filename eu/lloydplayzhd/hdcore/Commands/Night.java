package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.lloydplayzhd.hdcore.Main;

public class Night implements CommandExecutor {
	private Main plugin;
  public Night(Main pl) {
	  plugin = pl;
  }
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
	    if (!(sender instanceof Player)) {
	    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
	        return false;	      }
	      Player p = (Player)sender;
	      if (p.hasPermission("Night.use")) {
	          String Prefix;
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	          String Night;
	          Night = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Night"));
	          p.sendMessage(Prefix + " " + Night);
	      	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set 1800");
         return true;
	      } else {
	          String Prefix;
	          String NightNoPerm;
	          NightNoPerm = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NightNoPerm"));
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	        p.sendMessage(Prefix + " " + NightNoPerm);
  return true;
}
}
}

