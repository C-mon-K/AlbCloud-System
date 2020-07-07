package cloud.alb.system.server.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import cloud.alb.system.player.ranks.Rank;

public class JoinListener implements Listener{

	public JoinListener(Plugin plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		Rank.setPlayerRankedName(p);
		
		e.setJoinMessage("§7[§a+§7] §r" + p.getDisplayName());
		
	}
	
	
}
