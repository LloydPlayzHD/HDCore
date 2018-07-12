package eu.lloydplayzhd.hdcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.lloydplayzhd.hdcore.Main;

public class Nightvision
implements CommandExecutor{

		private Main plugin;
	  public Nightvision(Main pl) {
		  plugin = pl;
	}

public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
    	System.out.println(ChatColor.RED + "Console can not see the HDCore commands..");
        return false;    }
    Player p = (Player)sender;
    if ((!p.hasPermission("nv.use")) || (!p.hasPermission("nightvision.use")))
    {
        String Prefix;
        Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      p.sendMessage(Prefix + " " + "You do not have permission!");
    }
    else if (!p.hasPotionEffect(PotionEffectType.NIGHT_VISION))
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 80000, 1));
      String Prefix;
      String NightVisionEnable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      NightVisionEnable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NightVisionEnable"));
      p.sendMessage(Prefix + " " + NightVisionEnable);    }
    else if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION))
    {
      p.removePotionEffect(PotionEffectType.NIGHT_VISION);
      String Prefix;
      String NightVisionDisable;
      Prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix"));
      NightVisionDisable = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NightVisionDisable"));
      p.sendMessage(Prefix + " " + NightVisionDisable);
    }
    return false;
  }
}
