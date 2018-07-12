package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.lloydplayzhd.hdcore.Main;

public class Vote implements CommandExecutor {
	private Main plugin;
  public Vote(Main pl) {
	  plugin = pl;
}
public boolean onCommand(CommandSender arg0, Command command, String label, String[] args)
  {
    if (!(arg0 instanceof Player)) {
    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
        return false;
    }
    Player p = (Player)arg0;
    for(String msg : plugin.getConfig().getStringList("vote")) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
    return false;
  }
}
