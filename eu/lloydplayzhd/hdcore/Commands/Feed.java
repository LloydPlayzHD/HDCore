package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.lloydplayzhd.hdcore.Main;

public class Feed implements CommandExecutor {
	private Main plugin;
  public Feed(Main pl) {
	  plugin = pl;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	    if (!(sender instanceof Player)) {
	    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
	        return false;	      }
	      Player p = (Player)sender;
	      if (p.hasPermission("feed.use")) {
	          String Prefix;
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	          String Feed;
	          Feed= ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Feed"));
	          p.sendMessage(Prefix + " " + Feed);
              p.setFoodLevel(20);
           return true;
	      } else {
	          String Prefix;
	          String FeedNoPerm;
	          FeedNoPerm = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("FeedNoPerm"));
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	        p.sendMessage(Prefix + " " + FeedNoPerm);
	        
    return true;
  }
}
}
