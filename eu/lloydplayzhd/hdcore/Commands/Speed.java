package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.lloydplayzhd.hdcore.Main;

public class Speed
implements CommandExecutor{

	private Main plugin;
  public Speed(Main pl) {
	  plugin = pl;
}

public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
        return false;    }
    Player p = (Player)sender;
    if (!p.hasPermission("speed.use"))
    {
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      p.sendMessage(Prefix + " " + "You do not have permission!");
    }
    else if (!p.hasPotionEffect(PotionEffectType.SPEED))
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80000, 1));
      String Prefix;
      String SpeedEnable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      SpeedEnable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("SpeedEnable"));
      p.sendMessage(Prefix + " " + SpeedEnable);
    }
    else if (p.hasPotionEffect(PotionEffectType.SPEED))
    {
      p.removePotionEffect(PotionEffectType.SPEED);
      String Prefix;
      String SpeedDisable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      SpeedDisable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("SpeedDisable"));
      p.sendMessage(Prefix + " " + SpeedDisable);
    }
    return false;
  }
}
