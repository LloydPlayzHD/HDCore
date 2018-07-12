package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.lloydplayzhd.hdcore.Main;

public class Strength
  implements CommandExecutor{

		private Main plugin;
	  public Strength(Main pl) {
		  plugin = pl;
	}
 
public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
  {
    if (!(s instanceof Player)) {
    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
        return false;    }
    Player p = (Player)s;
    if (!p.hasPermission("strength.use"))
    {
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      p.sendMessage(Prefix + " " + "You do not have permission!");
    }
    else if (!p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
    {
        String Prefix;
        String StrengthEnable;
        StrengthEnable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("StrengthEnable"));
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 80000, 1));
      p.sendMessage(Prefix + " " + StrengthEnable);
    }
    else if (p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
    {
      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
      String Prefix;
      String StrengthDisable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      StrengthDisable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("StrengthDisable"));
      p.sendMessage(Prefix + " " + StrengthDisable);
    }
    return false;
  }
}
