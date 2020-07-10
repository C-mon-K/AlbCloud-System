package cloud.alb.system.server.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import cloud.alb.system.server.config.Config;

public class ChatListener implements Listener {

	public ChatListener(Plugin plugin) { Bukkit.getPluginManager().registerEvents(this, plugin); }
	
	@EventHandler
	public static void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		e.setFormat(Config.getFormattedChatMessage(p, msg));
		
		
	}
}
