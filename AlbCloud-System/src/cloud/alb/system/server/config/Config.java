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
			config.set("Message.JoinMSG", "§7[§a+§7] §r%player%");
			config.set("Message.QuitMSG", "§7[§c-§7] §r%player%");
			config.set("Message.ChatFormat", "%player% §r» §r§7%msg%");
			//Rank.Admin
			config.set("Rank.Admin.Prefix", "§4Admin | §7");
			config.set("Rank.Admin.Permission", "group.admin");
			config.set("Rank.Admin.Weight", 50);
			//Rank.Mod
			config.set("Rank.Moderator.Prefix", "§cMod | §7");
			config.set("Rank.Moderator.Permission", "group.moderator");
			config.set("Rank.Moderator.Weight", 40);
			//Rank.Builder
			config.set("Rank.Builder.Prefix", "§2Builder | §7");
			config.set("Rank.Builder.Permission", "group.builder");
			config.set("Rank.Builder.Weight", 30);
			//Rank.Premium
			config.set("Rank.Premium.Prefix", "§6Premium | §7");
			config.set("Rank.Premium.Permission", "group.premium");
			config.set("Rank.Premium.Weight", 10);
			//Rank.VIP
			config.set("Rank.VIP.Prefix", "§eVIP | §7");
			config.set("Rank.VIP.Permission", "group.vip");
			config.set("Rank.VIP.Weight", 5);
			//Rank.Member
			config.set("Rank.Member.Prefix", "§7Member | ");
			config.set("Rank.Member.Permission", "group.member");
			config.set("Rank.Member.Weight", 1);
			//Rank.GUEST
			config.set("Rank.Guest.Prefix", "§7");
			config.set("Rank.Guest.Permission", "");
			config.set("Rank.Guest.Weight", 0);
			
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

	public static String getJoinMsg(Player p) { return config.getString("Message.JoinMSG").replace("%player%", p.getDisplayName()); }
	
	public static String getQuitMsg(Player p) { return config.getString("Message.QuitMSG").replace("%player%", p.getDisplayName()); }
	
	public static String getFormattedChatMessage(Player p, String msg) { return config.getString("Message.ChatFormat").replace("%player%", p.getDisplayName()).replace("%msg%", msg); }
	
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

	public static int getRankWeight(Rank rank) {
		if(rank.equals(Rank.ADMIN)) return 200-config.getInt("Rank.Admin.Weight");
		if(rank.equals(Rank.MODERATOR)) return 200-config.getInt("Rank.Moderator.Weight");
		if(rank.equals(Rank.BUILDER)) return 200-config.getInt("Rank.Builder.Weight");
		if(rank.equals(Rank.PREMIUM)) return 200-config.getInt("Rank.Premium.Weight");
		if(rank.equals(Rank.VIP)) return 200-config.getInt("Rank.VIP.Weight");
		if(rank.equals(Rank.MEMBER)) return 200-config.getInt("Rank.Member.Weight");
		if(rank.equals(Rank.GUEST)) return 200-config.getInt("Rank.Guest.Weight");
		return 200;
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
