package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.lloydplayzhd.hdcore.Main;

public class FireRes
implements CommandExecutor{

	private Main plugin;
  public FireRes(Main pl) {
	  plugin = pl;
}
public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
        return false;    }
    Player p = (Player)sender;
    if (!p.hasPermission("fireres.use"))
    {
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      p.sendMessage(Prefix + " " + "You do not have permission!");
    }
    else if (!p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE))
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 80000, 1));
      String Prefix;
      String FireResEnable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      FireResEnable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("FireResEnable"));
      p.sendMessage(Prefix + " " + FireResEnable);
    }
    else if (p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE))
    {
      p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
      String Prefix;
      String FireResDisable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      FireResDisable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("FireResDisable"));
      p.sendMessage(Prefix + " " + FireResDisable);
    }
    return false;
  }
}
