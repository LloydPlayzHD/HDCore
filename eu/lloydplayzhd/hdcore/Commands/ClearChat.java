package eu.lloydplayzhd.hdcore.Commands;

import eu.lloydplayzhd.hdcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat
  implements CommandExecutor
{
  private Main plugin;
  
  public ClearChat(Main pl)
  {
    this.plugin = pl;
  }
  
  public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
  {
    Player p = (Player)s;
    if (!p.hasPermission("clearchat.use"))
    {
      String Prefix = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Prefix"));
      
      String ClearChatNoPerm = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("ClearChatNoPerm"));
      p.sendMessage(Prefix + " " + ClearChatNoPerm);
    }
    else
    {
    	Bukkit.broadcastMessage("LOL If you see me you are a legend!");
      for (int t = 2; t < 250; t++) {
        Bukkit.broadcastMessage("");
      }
      String ClearChatCleared = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("ClearChatCleared").replace("%player%", p.getDisplayName()));
      String Prefix = ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Prefix"));
      Bukkit.broadcastMessage(Prefix + " " + ClearChatCleared);
    }
    return false;
  }
}
