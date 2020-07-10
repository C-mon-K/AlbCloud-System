package cloud.alb.system.server.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import cloud.alb.system.player.ranks.RankedScoreboard;
import cloud.alb.system.server.config.Config;

public class QuitListener implements Listener{

	public QuitListener(Plugin plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		
		e.setQuitMessage(Config.getQuitMsg(p));
		RankedScoreboard.removePlayer(p);
		
	}
	
}
