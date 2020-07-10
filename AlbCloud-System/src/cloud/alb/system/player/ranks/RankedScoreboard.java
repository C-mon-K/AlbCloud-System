package cloud.alb.system.player.ranks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import cloud.alb.system.server.config.Config;


public class RankedScoreboard {

	static Scoreboard board;
	static String adminName, moderatorName, builderName, premiumName, vipName, memberName, guestName;
	
	public static void registerScoreboardTeams() {
		
		board =  Bukkit.getScoreboardManager().getMainScoreboard();
		
		adminName = "" + Config.getRankWeight(Rank.ADMIN);
		moderatorName = "" + Config.getRankWeight(Rank.MODERATOR);
		builderName = "" + Config.getRankWeight(Rank.BUILDER);
		premiumName = "" + Config.getRankWeight(Rank.PREMIUM);
		vipName = "" + Config.getRankWeight(Rank.VIP);
		memberName = "" + Config.getRankWeight(Rank.MEMBER);
		guestName = "" + Config.getRankWeight(Rank.GUEST);
		
		board.registerNewTeam(adminName);
		board.getTeam(adminName).setPrefix(Config.getRankPrefix(Rank.ADMIN));
		board.registerNewTeam(moderatorName);
		board.getTeam(moderatorName).setPrefix(Config.getRankPrefix(Rank.MODERATOR));
		board.registerNewTeam(builderName);
		board.getTeam(builderName).setPrefix(Config.getRankPrefix(Rank.BUILDER));
		board.registerNewTeam(premiumName);
		board.getTeam(premiumName).setPrefix(Config.getRankPrefix(Rank.PREMIUM));
		board.registerNewTeam(vipName);
		board.getTeam(vipName).setPrefix(Config.getRankPrefix(Rank.VIP));
		board.registerNewTeam(memberName);
		board.getTeam(memberName).setPrefix(Config.getRankPrefix(Rank.MEMBER));
		board.registerNewTeam(guestName);
		board.getTeam(guestName).setPrefix(Config.getRankPrefix(Rank.GUEST));
		
	}
	
	public static void unregisterScoreboardTeams() {
		board.getTeam(adminName).unregister();
		board.getTeam(moderatorName).unregister();
		board.getTeam(builderName).unregister();
		board.getTeam(premiumName).unregister();
		board.getTeam(vipName).unregister();
		board.getTeam(memberName).unregister();
		board.getTeam(guestName).unregister();
	}
	
	@SuppressWarnings("deprecation")
	public static void addPlayer(Player p) {
	
		switch(Rank.getPlayerRank(p)) {
			case ADMIN: board.getTeam(adminName).addPlayer(p); break;
			case MODERATOR: board.getTeam(moderatorName).addPlayer(p); break;
			case BUILDER: board.getTeam(builderName).addPlayer(p); break;
			case PREMIUM: board.getTeam(premiumName).addPlayer(p); break;
			case VIP: board.getTeam(vipName).addPlayer(p); break;
			case MEMBER: board.getTeam(memberName).addPlayer(p); break;
			case GUEST: board.getTeam(guestName).addPlayer(p); break;
		}

		Bukkit.getOnlinePlayers().forEach((all) -> all.setScoreboard(board)) ;
		
	}
	
	@SuppressWarnings("deprecation")
	public static void removePlayer(Player p) {
		switch(Rank.getPlayerRank(p)) {
			case ADMIN: board.getTeam(adminName).removePlayer(p);
			case MODERATOR: board.getTeam(moderatorName).removePlayer(p);
			case BUILDER: board.getTeam(builderName).removePlayer(p);
			case PREMIUM: board.getTeam(premiumName).removePlayer(p);
			case VIP: board.getTeam(vipName).removePlayer(p);
			case MEMBER: board.getTeam(memberName).removePlayer(p);
			case GUEST: board.getTeam(guestName).removePlayer(p);
		}
		Bukkit.getOnlinePlayers().forEach((all) -> all.setScoreboard(board));
	}
	
}
