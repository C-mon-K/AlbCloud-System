package cloud.alb.system.server.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import cloud.alb.system.player.ranks.Rank;


public class Config {

	static File configFile = new File("plugins\\AlbCloud\\System\\config.yml");
	static FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
	
	public static boolean initialiseConfigFile() {

		if(!configFile.exists()) {
			try {
				
				new File("plugins\\AlbCloud").mkdir();
				new File("plugins\\\\AlbCloud\\System").mkdir();
				configFile.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
			config.set("Message.JoinMSG", "§7[§a+§7] §r%p%");
			config.set("Message.QuitMSG", "§7[§c-§7] §r%p%");
			//Rank.Admin
			config.set("Rank.Admin.Prefix", "§4Admin | §7");
			config.set("Rank.Admin.Permission", "group.admin");
			//Rank.Mod
			config.set("Rank.Moderator.Prefix", "§cMod | §7");
			config.set("Rank.Moderator.Permission", "group.moderator");
			//Rank.Builder
			config.set("Rank.Builder.Prefix", "§2Builder | §7");
			config.set("Rank.Builder.Permission", "group.builder");
			//Rank.Premium
			config.set("Rank.Premium.Prefix", "§6Premium | §7");
			config.set("Rank.Builder.Permission", "group.premium");
			//Rank.VIP
			config.set("Rank.VIP.Prefix", "§eVIP | §7");
			config.set("Rank.VIP.Permission", "group.vip");
			//Rank.Member
			config.set("Rank.Member.Prefix", "§7Member | ");
			config.set("Rank.Member.Permission", "group.member");
			//Rank.GUEST
			config.set("Rank.Guest.Prefix", "§7");
			config.set("Rank.Guest.Permission", "");
			
			try {
				config.save(configFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Bukkit.getConsoleSender().sendMessage("§7[§6System§7] Found §cno config.yml §7 for plugin §cAlbCloud-System§7!");
			Bukkit.getConsoleSender().sendMessage("§7[§6System§7] §aSuccesfully created /plugins/AlbCloud/System/config.yml§7 and set §astandard values§7!");
			return true;
			
		}
		else {
			Bukkit.getConsoleSender().sendMessage("§7[§6System§7] §aSuccesfully found config §7file for  plugin §aAlbCloud-System§7!");
			return true;
		}
	
	}

	public static String getJoinMsg(Player p) { return config.getString("Message.JoinMSG").replace("%p%", p.getDisplayName()); }
	
	public static String getQuitMsg(Player p) { return config.getString("Message.JoinMSG").replace("%p%", p.getDisplayName()); }
	
	public static String getRankPrefix(Rank rank) {
		if(rank.equals(Rank.ADMIN)) return config.getString("Rank.Admin.Prefix");
		if(rank.equals(Rank.MODERATOR)) return config.getString("Rank.Moderator.Prefix");
		if(rank.equals(Rank.BUILDER)) return config.getString("Rank.Builder.Prefix");
		if(rank.equals(Rank.PREMIUM)) return config.getString("Rank.Premium.Prefix");
		if(rank.equals(Rank.VIP)) return config.getString("Rank.VIP.Prefix");
		if(rank.equals(Rank.MEMBER)) return config.getString("Rank.Member.Prefix");
		if(rank.equals(Rank.GUEST)) return config.getString("Rank.Guest.Prefix");
		return "$7";
	}

	public static String getRankPermission(Rank rank) {
		if(rank.equals(Rank.ADMIN)) return config.getString("Rank.Admin.Permission");
		if(rank.equals(Rank.MODERATOR)) return config.getString("Rank.Moderator.Permission");
		if(rank.equals(Rank.BUILDER)) return config.getString("Rank.Builder.Permission");
		if(rank.equals(Rank.PREMIUM)) return config.getString("Rank.Premium.Permission");
		if(rank.equals(Rank.VIP)) return config.getString("Rank.VIP.Permission");
		if(rank.equals(Rank.MEMBER)) return config.getString("Rank.Member.Permission");
		if(rank.equals(Rank.GUEST)) return config.getString("Rank.Guest.Permission");
		return "permission.default";
	}
	
	
}
