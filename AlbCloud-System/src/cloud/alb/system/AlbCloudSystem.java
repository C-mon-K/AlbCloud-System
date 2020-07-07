package cloud.alb.system;

import org.bukkit.plugin.java.JavaPlugin;

import cloud.alb.system.server.config.Config;
import cloud.alb.system.server.listener.JoinListener;
import cloud.alb.system.server.listener.QuitListener;

public class AlbCloudSystem extends JavaPlugin {

	@Override
	public void onEnable() {
		new JoinListener(this);
		new QuitListener(this);
		Config.initialiseConfigFile();
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
}
