package com.th3shadowbroker.locs;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import com.th3shadowbroker.loc.cmd.Loc;
import com.th3shadowbroker.loc.events.Player_Join;
import com.th3shadowbroker.loc.sys.ColorCode;
import com.th3shadowbroker.loc.sys.PluginConfig;
import com.th3shadowbroker.loc.update.NotifyUpdate;
import com.th3shadowbroker.loc.update.UpdateChecker;

public class main extends JavaPlugin{
	
	public PluginConfig config;
		
	public String prefix;
	public String cprefix = "[LocStats] ";
	
	public String author = this.getDescription().getAuthors().get(0);
	public String version = this.getDescription().getVersion();

	//Load-Process
	public void onEnable()
	{
		
                System.out.println(cprefix + "Checking for updates...");
                
                checkForUpdates();
            
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
                
                this.getServer().getPluginManager().registerEvents(new NotifyUpdate(this), this);
		System.out.println(cprefix + "LocStats->NotifyUpdate Event registered...");
				
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
        
        //Check for Updates
        private void checkForUpdates()
        {
            
            UpdateChecker upc = new UpdateChecker(this,"http://dev.bukkit.org/bukkit-plugins/localstats/files.rss");
            
            if ( upc.updateAvailable() )
            {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("====[NOTICE]====");
                System.out.println("PLEASE UPDATE YOUR LOCSTATS FROM");
                System.out.println("http://bit.ly/localstats");
                System.out.println("================");
                System.out.println(" ");
                System.out.println(" ");
                
            }
            
        }
	
}
