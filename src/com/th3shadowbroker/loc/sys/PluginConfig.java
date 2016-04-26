package com.th3shadowbroker.loc.sys;

import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;

import com.th3shadowbroker.loc.main;

public class PluginConfig {
	
	protected main plugin;
	protected FileConfiguration config;
	protected ArrayList<String> settingsName;
	protected ArrayList<String> settingsValues;
		
	public PluginConfig(main plugin, ArrayList<String> settings, ArrayList<String> values,boolean autoload)
	{
		
		this.plugin = plugin;
		this.config = plugin.getConfig();
		this.settingsName = settings;
		this.settingsValues = values;
		
		if (autoload == true)
		{
			
			generateConfig();
			
		}
		
	}
	
	//Laedt die Standard-Config
	public void generateConfig()
	{
		
			
		for(int i = 0; i != settingsName.size(); i++)
		{
			
			config.addDefault(settingsName.get(i), settingsValues.get(i));
			
		}
		
		config.options().copyDefaults(true);
		
		saveConfig();
		
	}
	
	//Speichert alle Aenderungen
	public void saveConfig()
	{
		
		plugin.saveConfig();
		
	}
	
	//Setzt einen Wert: String
	public void set(String path, String value)
	{
		
		config.set(path, value);
		
		saveConfig();
		
	}
	
	//Setzt einen Wert: Integer
	public void set(String path, Integer value)
	{
		
		config.set(path, value);
		
		saveConfig();
		
	}
	
	//Setzt einen Wert: Boolean
	public void set(String path, Boolean value)
	{
		
		config.set(path, value);
		
		saveConfig();
		
	}

	
	//Gibt einen Wert als String wieder
	public String getString(String path)
	{
		
		return config.getString(path);
		
	}
	
	//Gibt einen Wert als Integer wieder
	public Integer getInteger(String path)
	{
		
		return config.getInt(path);
		
	}
	
	//Gibt einen Wert als Boolean wieder
	public Boolean getBool(String path)
	{
		
		return config.getBoolean(path);
		
	}
	
}
