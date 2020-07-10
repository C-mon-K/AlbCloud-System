package cloud.alb.system;

import org.bukkit.plugin.java.JavaPlugin;

import cloud.alb.system.player.ranks.RankedScoreboard;
import cloud.alb.system.server.config.Config;
import cloud.alb.system.server.listener.ChatListener;
import cloud.alb.system.server.listener.JoinListener;
import cloud.alb.system.server.listener.QuitListener;

public class AlbCloudSystem extends JavaPlugin {

	@Override
	public void onEnable() {
		Config.initialiseConfigFile();
		new JoinListener(this);
		new QuitListener(this);
		new ChatListener(this);
		RankedScoreboard.registerScoreboardTeams();
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		RankedScoreboard.unregisterScoreboardTeams();
		super.onDisable();
	}
	
}
