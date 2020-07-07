package cloud.alb.system.player.ranks;

import org.bukkit.entity.Player;

public enum Rank {

	ADMIN, MODERATOR, BUILDER, PREMIUM, VIP, MEMBER, GUEST;
	
	public static String getRankPrefix(Rank rank) {
		if(rank.equals(Rank.ADMIN)) return "§4Admin | ";
		if(rank.equals(Rank.MODERATOR)) return "§cMod | ";
		if(rank.equals(Rank.BUILDER)) return "§2Builder | ";
		if(rank.equals(Rank.PREMIUM)) return "§6Premium | ";
		if(rank.equals(Rank.VIP)) return "§eVIP | ";
		if(rank.equals(Rank.MEMBER)) return "§7Member | ";
		else return "§7";
	}
	
	public static Rank getPlayerRank(Player p) {
		if(p.hasPermission("group.admin")) return Rank.ADMIN;
		if(p.hasPermission("group.moderator")) return Rank.MODERATOR;
		if(p.hasPermission("group.builder")) return Rank.BUILDER;
		if(p.hasPermission("group.premium")) return Rank.PREMIUM;
		if(p.hasPermission("group.vip")) return Rank.VIP;
		if(p.hasPermission("group.member")) return Rank.MEMBER;
		else return Rank.GUEST;
	}
	
	public static String setPlayerRankedName(Player p) {
		p.setDisplayName(Rank.getRankPrefix(Rank.getPlayerRank(p)) + p.getName() + "§r");
		return p.getDisplayName();
	}
	
}
