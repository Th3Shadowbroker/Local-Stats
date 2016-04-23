package com.th3shadowbroker.locs;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import com.th3shadowbroker.loc.cmd.Loc;
import com.th3shadowbroker.loc.events.Player_Join;
import com.th3shadowbroker.loc.sys.ColorCode;
import com.th3shadowbroker.loc.sys.PluginConfig;

public class main extends JavaPlugin{
	
	public PluginConfig config;
		
	public String prefix;
	public String cprefix = "[LocStats] ";
	
	public String author = "Th3Shadowbroker";
	public String version = "1.0.0";

	//Load-Process
	public void onEnable()
	{
		
		loadConfig();
		
		System.out.println(cprefix + "Config generated...");
		
		loadPrefix();
		
		System.out.println(cprefix + "Loaded prefixes...");
		
		registerExecutors();
		
		System.out.println(cprefix + "Registered Executors...");
		
		registerEvents();
		
		System.out.println(cprefix + "Events registered...");
		
	}
	
	//Unload-Process
	public void onDisable()
	{
	
		config.saveConfig();
		
		System.out.println(cprefix + "LOCStats disabled...");
		
	}
	
	//Register command executors
	public void registerExecutors()
	{
	
		this.getCommand("loc").setExecutor(new Loc(this));
		
	}
	
	//Register events
	public void registerEvents()
	{
		
		this.getServer().getPluginManager().registerEvents(new Player_Join(this), this);
		System.out.println(cprefix + "LocStats->Player_Join Event registered...");
				
	}
	
	//Load Prefixes
	public void loadPrefix()
	{
		
		this.prefix = ColorCode.CC( config.getString("Chat.Prefix") ) + " ";//Load Chat-Prefix
		this.cprefix = config.getString("Chat.ConsolePrefix") + " ";//Load Console-Prefix
		
	}
	
	//Generate config-file
	public void loadConfig()
	{
		
		/*
		 * DEFAULT SETTINGS
		 */
		ArrayList<String> settingsName = new ArrayList<String>();
		ArrayList<String> settingsValues = new ArrayList<String>();
		
		settingsName.add("Chat.Prefix");settingsValues.add("&9[LocStats]&f"); //Chat-/InGame-Prefix
		settingsName.add("Chat.ConsolePrefix");settingsValues.add("[LocStats]"); //Console-Prefix
		
		this.config = new PluginConfig(this, settingsName, settingsValues, true);
		
	}
	
}
