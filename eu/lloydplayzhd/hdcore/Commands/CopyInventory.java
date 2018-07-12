package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.lloydplayzhd.hdcore.Main;
// Why the fuck you looking at my code! lel Hi!
// You can just DM me on Spigot for the source code... You know that right...
// HDCore on Spigot [LloydPlayzHD]

public class CopyInventory
  implements CommandExecutor {
		private Main plugin;
		  public CopyInventory(Main pl) {
			  plugin = pl;
		  }
public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
  {
    if (command.getName().equalsIgnoreCase("copyinv"))
    {
      if (arguments.length != 1)
      {
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
        sender.sendMessage(Prefix + ChatColor.RED + "The correct usage is" + ChatColor.GRAY + ":" + label + ChatColor.DARK_GRAY + " <name>");
        return true;
      }
      if (arguments.length == 1)
      {
        Player target = Bukkit.getServer().getPlayer(arguments[0]);
        Player player = (Player)sender;
        player.getInventory().setContents(target.getInventory().getContents());
        player.getInventory().setArmorContents(target.getInventory().getArmorContents());
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
        player.sendMessage(Prefix + ChatColor.GREEN + "You copied the inventory of "+ ChatColor.RED + arguments[0] + ".");
      }
    }
    return false;
  }
}
