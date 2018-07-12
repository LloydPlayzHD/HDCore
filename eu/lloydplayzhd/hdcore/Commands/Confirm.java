package eu.lloydplayzhd.hdcore.Commands;

import java.util.List;
import eu.lloydplayzhd.hdcore.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class Confirm
  implements CommandExecutor, Listener
{
  private final Main plugin;
  
  public Confirm(Main plugin)
  {
    this.plugin = plugin;
  }
  
  public String prettifyString(String chatcolorchanger)
  {
    return ChatColor.translateAlternateColorCodes('&', chatcolorchanger);
  }
  
  public boolean onCommand(CommandSender commandSender, Command command, String commandLabel, String[] args)
  {
    if ((command.getName().equalsIgnoreCase("hdcore")) && (args.length == 0))
    {
      List<String> Lines = this.plugin.getConfig().getStringList("HDCoreCommand.message");
      for (String stringList : Lines) {
        commandSender.sendMessage(prettifyString(stringList).replace("{version}", this.plugin.getDescription().getVersion()));
      }
      return true;
    }
    if ((command.getName().equalsIgnoreCase("hdcore")) && (args.length == 1) && (args[0].equalsIgnoreCase("reload")))
    {
      if (commandSender.hasPermission("hdcore.reload"))
      {
        this.plugin.reloadConfig();
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
        commandSender.sendMessage(prettifyString(Prefix + " " + this.plugin.getConfig().getString("HDCoreCommand.ReloadSuccess")));
        Bukkit.getAllowFlight();
        return true;
      }
      String Prefix;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      commandSender.sendMessage(prettifyString(Prefix + " " + this.plugin.getConfig().getString("HDCoreCommand.ReloadFailed")));
      return true;
    }
    if ((command.getName().equalsIgnoreCase("hdcore")) && (args.length == 1) && (args[0].equalsIgnoreCase("backup")))
    {
      {
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
        commandSender.sendMessage(Prefix + " Success");
      	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Testing");
        return true;
      }
    }
 return false;
  }
}
