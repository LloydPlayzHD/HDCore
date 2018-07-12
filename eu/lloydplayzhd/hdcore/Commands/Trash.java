package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import eu.lloydplayzhd.hdcore.Main;

public class Trash implements CommandExecutor {
	private Main plugin;
  public Trash(Main pl) {
	  plugin = pl;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	    if (!(sender instanceof Player)) {
	    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
	        return false;	      }
	      Player p = (Player)sender;
	      if (p.hasPermission("trash.use")) {
	          String Prefix;
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	          String TrashOpen;
	          TrashOpen= ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("OpenMessage"));
	          p.sendMessage(Prefix + " " + TrashOpen);
	          String TrashTitle;
	          TrashTitle= ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("TrashTitle"));
	       Inventory inv1 = Bukkit.getServer().createInventory(p, 54, ChatColor.YELLOW + TrashTitle);
           p.openInventory(inv1);
        // Why the fuck you looking at my code! lel Hi!
        // You can just DM me on Spigot for the source code... You know that right...
        // HDCore on Spigot [LloydPlayzHD]
           return true;
	      } else {
	          String Prefix;
	          String TrashNoPerm;
	          TrashNoPerm = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("TrashNoPerm"));
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	        p.sendMessage(Prefix + " " + TrashNoPerm);
    return true;
  }
}
}

