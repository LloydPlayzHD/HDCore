package eu.lloydplayzhd.hdcore;

import eu.lloydplayzhd.hdcore.Commands.ClearChat;
import eu.lloydplayzhd.hdcore.Commands.Creative;
import eu.lloydplayzhd.hdcore.Commands.Day;
import eu.lloydplayzhd.hdcore.Commands.Discord;
import eu.lloydplayzhd.hdcore.Commands.Feed;
import eu.lloydplayzhd.hdcore.Commands.FireRes;
import eu.lloydplayzhd.hdcore.Commands.Haste;
import eu.lloydplayzhd.hdcore.Commands.Heal;
import eu.lloydplayzhd.hdcore.Commands.Nightvision;
import eu.lloydplayzhd.hdcore.Commands.Speed;
import eu.lloydplayzhd.hdcore.Commands.Store;
import eu.lloydplayzhd.hdcore.Commands.Strength;
import eu.lloydplayzhd.hdcore.Commands.Survival;
import eu.lloydplayzhd.hdcore.Commands.Trash;
import eu.lloydplayzhd.hdcore.Commands.Ts;
import eu.lloydplayzhd.hdcore.Commands.Twitter;
import eu.lloydplayzhd.hdcore.Commands.Vote;
import eu.lloydplayzhd.hdcore.Commands.Website;
import eu.lloydplayzhd.hdcore.Commands.Rules;
import eu.lloydplayzhd.hdcore.Commands.Confirm;
import eu.lloydplayzhd.hdcore.Commands.CopyInventory;
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
  implements CommandExecutor, Listener {
	  
public void onEnable()
  {
	// Why the fuck you looking at my code! lel Hi!
	// You can just DM me on Spigot for the source code... You know that right...
	// HDCore on Spigot [LloydPlayzHD]
    System.out.println("HDCore has been enabled!");
    System.out.println(ChatColor.RED + "----------------------  " + ChatColor.YELLOW + " HDCore " + ChatColor.RED + "  ----------------------");
    System.out.println(ChatColor.RED + "* Version: " + ChatColor.YELLOW + getDescription().getVersion() + ChatColor.RED);
    System.out.println(ChatColor.RED + "* Plugin Author: " + ChatColor.YELLOW + getDevelopers());
    System.out.println(ChatColor.RED + "* Plugin Status:" + ChatColor.YELLOW + " Activated" + ChatColor.RED);
    System.out.println(ChatColor.RED + "* Plugin Update: " + ChatColor.YELLOW + "https://tinyurl.com/y8u5f6bo");
    System.out.println(ChatColor.RED + "----------------------  " + ChatColor.YELLOW + " HDCore " + ChatColor.RED + "  ----------------------");
    System.out.println(ChatColor.YELLOW + " Thank you for downloading Project Cover X [Survival 1]");
    registerConfig();
    getCommand("speed").setExecutor(new Speed(this));
    getCommand("strength").setExecutor(new Strength(this));
    getCommand("nv").setExecutor(new Nightvision(this));
    getCommand("cc").setExecutor(new ClearChat(this));
    getCommand("website").setExecutor(new Website(this));
    getCommand("ts").setExecutor(new Ts(this));
    getCommand("twitter").setExecutor(new Twitter(this));
    getCommand("discord").setExecutor(new Discord(this));
    getCommand("haste").setExecutor(new Haste(this));
    getCommand("store").setExecutor(new Store(this));
    getCommand("fireres").setExecutor(new FireRes(this));
    getCommand("day").setExecutor(new Day(this));
    getCommand("trash").setExecutor(new Trash(this));
    getCommand("creative").setExecutor(new Creative(this));
    getCommand("survival").setExecutor(new Survival(this));
    getCommand("heal").setExecutor(new Heal(this));
    getCommand("feed").setExecutor(new Feed(this));
    getCommand("vote").setExecutor(new Vote(this));
    getCommand("rule").setExecutor(new Rules(this));
    getCommand("hdcore").setExecutor(new Confirm(this));
    getCommand("copyinv").setExecutor(new CopyInventory(this));
    PluginManager pm = getServer().getPluginManager();
    getServer().getPluginManager().registerEvents(this, this);
    
    pm.registerEvents(this, this);
  }
//Why the fuck you looking at my code! lel Hi!
//You can just DM me on Spigot for the source code... You know that right...
//HDCore on Spigot [LloydPlayzHD]

private void registerConfig()
  {
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  public List<String> getDevelopers()
  {
    return Arrays.asList(new String[] { "LloydPlayzHD" });
  }
  public void onDisable()
  {
	    System.out.println(ChatColor.RED + "----------------------  " + ChatColor.YELLOW + " HDCore " + ChatColor.RED + "  ----------------------");
	    System.out.println(ChatColor.RED + "* Version: " + ChatColor.YELLOW + getDescription().getVersion() + ChatColor.RED);
	    System.out.println(ChatColor.RED + "* Plugin Author: " + ChatColor.YELLOW + getDevelopers());
	    System.out.println(ChatColor.RED + "* Plugin Status:" + ChatColor.YELLOW + " Desactivated" + ChatColor.RED);
	    System.out.println(ChatColor.RED + "* Plugin Update: " + ChatColor.YELLOW + "https://tinyurl.com/y8u5f6bo");
	    System.out.println(ChatColor.RED + "----------------------  " + ChatColor.YELLOW + " HDCore " + ChatColor.RED + "  ----------------------");
	    System.out.println(ChatColor.YELLOW + " Thank you for using HDCore");
	    System.out.println(ChatColor.YELLOW +" Unlike other plugins. This is all the credits we give our self. Enjoy!" + ChatColor.RED + " - Lloyd");
  }
}

