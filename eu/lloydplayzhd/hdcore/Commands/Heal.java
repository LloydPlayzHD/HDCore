package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.lloydplayzhd.hdcore.Main;

public class Heal implements CommandExecutor {
	private Main plugin;
  public Heal(Main pl) {
	  plugin = pl;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	    if (!(sender instanceof Player)) {
	    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
	        return false;	      }
	      Player p = (Player)sender;
	      if (p.hasPermission("heal.use")) {
	          String Prefix;
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	          String Heal;
	          Heal= ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Heal"));
	          p.sendMessage(Prefix + " " + Heal);
              p.setHealth(20);
           return true;
	      } else {
	          String Prefix;
	          String HealNoPerm;
	          HealNoPerm = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("HealNoPerm"));
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	        p.sendMessage(Prefix + " " + HealNoPerm);
    return true;
  }
}
}

