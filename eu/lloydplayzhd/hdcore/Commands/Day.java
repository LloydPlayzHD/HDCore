package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.lloydplayzhd.hdcore.Main;

public class Day implements CommandExecutor {
	private Main plugin;
  public Day(Main pl) {
	  plugin = pl;
  }
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
	    if (!(sender instanceof Player)) {
	    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
	        return false;	      }
	      Player p = (Player)sender;
	      if (p.hasPermission("day.use")) {
	          String Prefix;
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	          String Day;
	          Day = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Day"));
	          p.sendMessage(Prefix + " " + Day);
	      	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set 0");
         return true;
	      } else {
	          String Prefix;
	          String DayNoPerm;
	          DayNoPerm = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("DayNoPerm"));
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	        p.sendMessage(Prefix + " " + DayNoPerm);
  return true;
}
}
}

