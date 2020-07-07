package cloud.alb.system.player.ranks;

import org.bukkit.entity.Player;

import cloud.alb.system.server.config.Config;

public enum Rank {

	ADMIN, MODERATOR, BUILDER, PREMIUM, VIP, MEMBER, GUEST;
	
	public static String getRankPrefix(Rank rank) {
		if(rank.equals(Rank.ADMIN)) return Config.getRankPrefix(ADMIN);
		if(rank.equals(Rank.MODERATOR)) return Config.getRankPrefix(MODERATOR);
		if(rank.equals(Rank.BUILDER)) return Config.getRankPrefix(BUILDER);
		if(rank.equals(Rank.PREMIUM)) return Config.getRankPrefix(PREMIUM);
		if(rank.equals(Rank.VIP)) return Config.getRankPrefix(VIP);
		if(rank.equals(Rank.MEMBER)) return Config.getRankPrefix(MEMBER);
		else return "§7";
	}
	
	public static Rank getPlayerRank(Player p) {
		if(p.hasPermission(Config.getRankPermission(Rank.ADMIN))) return Rank.ADMIN;
		if(p.hasPermission(Config.getRankPermission(Rank.MODERATOR))) return Rank.MODERATOR;
		if(p.hasPermission(Config.getRankPermission(Rank.BUILDER))) return Rank.BUILDER;
		if(p.hasPermission(Config.getRankPermission(Rank.PREMIUM))) return Rank.PREMIUM;
		if(p.hasPermission(Config.getRankPermission(Rank.VIP))) return Rank.VIP;
		if(p.hasPermission(Config.getRankPermission(Rank.MEMBER))) return Rank.MEMBER;
		else return Rank.GUEST;
	}
	
	public static String setPlayerRankedName(Player p) {
		p.setDisplayName(Rank.getRankPrefix(Rank.getPlayerRank(p)) + p.getName() + "§r");
		return p.getDisplayName();
	}
	
}
