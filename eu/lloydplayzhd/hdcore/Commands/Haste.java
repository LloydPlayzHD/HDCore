package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.lloydplayzhd.hdcore.Main;

public class Haste
implements CommandExecutor{

	private Main plugin;
  public Haste(Main pl) {
	  plugin = pl;
}
public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
        return false;  
        }
    Player p = (Player)sender;
    if (!p.hasPermission("haste.use"))
    {
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      p.sendMessage(Prefix + " " + "You do not have permission!");
    }
    else if (!p.hasPotionEffect(PotionEffectType.FAST_DIGGING))
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 80000, 1));
      String Prefix;
      String HasteEnable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      HasteEnable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("HasteEnable"));
      p.sendMessage(Prefix + " " + HasteEnable);
    }
    else if (p.hasPotionEffect(PotionEffectType.FAST_DIGGING))
    {
      p.removePotionEffect(PotionEffectType.FAST_DIGGING);
      String Prefix;
      String HasteDisable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      HasteDisable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("HasteDisable"));
      p.sendMessage(Prefix + " " + HasteDisable);
    }
    return false;
  }
}
