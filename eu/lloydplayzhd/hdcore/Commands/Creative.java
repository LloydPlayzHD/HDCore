package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.lloydplayzhd.hdcore.Main;

public class Creative implements CommandExecutor {
	private Main plugin;
  public Creative(Main pl) {
	  plugin = pl;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	    if (!(sender instanceof Player)) {
	    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
	        return false;
	        }
	      Player p = (Player)sender;
	      if (p.hasPermission("gamemode.creative")) {
	          String Prefix;
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	          String Creative;
	          Creative= ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Creative"));
	          p.sendMessage(Prefix + " " + Creative);
	          p.setGameMode(GameMode.CREATIVE);
           return true;
	      } else {
	          String Prefix;
	          String CreativeNoPerm;
	          CreativeNoPerm = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("CreativeNoPerm"));
	          Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
	        p.sendMessage(Prefix + " " + CreativeNoPerm);
    return true;
  }
}
}

