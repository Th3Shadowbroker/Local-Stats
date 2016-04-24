package com.th3shadowbroker.loc.obj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.th3shadowbroker.loc.sys.CustomConfig;
import org.bukkit.Bukkit;

public class PlayerProfile {

	//Profile-File Object
	protected CustomConfig profile;
	protected Player player;
	protected Plugin plugin;
	
	//Strings
	protected String configPrefix;
	
	//Object-Constructor 
	public PlayerProfile(Plugin plugin ,Player player)
	{
		
                Plugin loc = Bukkit.getPluginManager().getPlugin("LOCStats");
		this.profile = new CustomConfig(loc, "profiles.yml");
		this.player = player;
		this.plugin = plugin;
		this.configPrefix = "[" + plugin.getName() + "]";
		
                if ( plugin.getName().equals(loc.getName()) )
                {
                    loadDefaults();
                    
                }else{
                    
                    System.out.println("[API] " + plugin.getName() + " hooked LocStats-API");
                    
                }
	}
	
	//Set custom stats: string
	public void setStat(String name,String value)
	{
		
		profile.getConfig().set(configPrefix + "." + player.getUniqueId().toString() + "." + name, value);
		
		save();
		
	}
	
	//Set external stat: string
	public void setExternalStat(Plugin externalPlugin, String name, String value)
	{
		
		profile.getConfig().set("[" + externalPlugin.getName() + "]" + "." + player.getUniqueId().toString() + "." + name, value);
		
		save();
		
	}
        
        //Set custom stats: boolean
	public void setStat(String name,boolean value)
	{
		
		profile.getConfig().set(configPrefix + "." + player.getUniqueId().toString() + "." + name, value);
		
		save();
		
	}
	
	//Set external stat: boolean
	public void setExternalStat(Plugin externalPlugin, String name, boolean value)
	{
		
		profile.getConfig().set("[" + externalPlugin.getName() + "]" + "." + player.getUniqueId().toString() + "." + name, value);
		
		save();
		
	}
        
        //Set custom stats: integer
	public void setStat(String name,int value)
	{
		
		profile.getConfig().set(configPrefix + "." + player.getUniqueId().toString() + "." + name, value);
		
		save();
		
	}
	
	//Set external stat: integer
	public void setExternalStat(Plugin externalPlugin, String name, int value)
	{
		
		profile.getConfig().set("[" + externalPlugin.getName() + "]" + "." + player.getUniqueId().toString() + "." + name, value);
		
		save();
		
	}
        
        //Set custom stats: float
	public void setStat(String name,float value)
	{
		
		profile.getConfig().set(configPrefix + "." + player.getUniqueId().toString() + "." + name, value);
		
		save();
		
	}
	
	//Set external stat: float
	public void setExternalStat(Plugin externalPlugin, String name, float value)
	{
		
		profile.getConfig().set("[" + externalPlugin.getName() + "]" + "." + player.getUniqueId().toString() + "." + name, value);
		
		save();
		
	}
	
	//Load defaults
	private void loadDefaults()
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
		Date currentTime = new Date();
		
		profile.getConfig().addDefault(configPrefix + "." + player.getUniqueId().toString() + ".LastName", player.getName());
		profile.getConfig().addDefault(configPrefix + "." + player.getUniqueId().toString() + ".LastIP", player.getAddress().toString());
		profile.getConfig().addDefault(configPrefix + "." + player.getUniqueId().toString() + ".LastLogin", formatter.format(currentTime));
		
		profile.getConfig().options().copyDefaults(true);
		
		save();
		
	}
	
	//Get UID
	public UUID getUID()
	{
		
		return player.getUniqueId();
		
	}
        
        //Return stat as string
        public String getStatStr(String name)
        {
            
            return profile.getConfig().getString(configPrefix + "." + name);
            
        }
        
        //Return stat as integer
        public Integer getStatInt(String name)
        {
            
            return profile.getConfig().getInt(configPrefix + "." + name);
            
        }
        
        //Return stat as float
        public float getStatFloat(String name){
            
            return (float) profile.getConfig().getInt(configPrefix + "." + name);
            
        }
        
         //Return stat as boolean
        public boolean getStatBool(String name){
            
            return profile.getConfig().getBoolean(configPrefix + "." + name);
            
        }
        
        //Return external stat as String
	public String getExternalStatStr(Plugin externalPlugin, String name)
	{
		
		return profile.getConfig().getString("[" + externalPlugin.getName() + "]" + "." + player.getUniqueId().toString() + "." + name);
		
	}
        
         //Return external stat as Integer
	public Integer getExternalStatInt(Plugin externalPlugin, String name)
	{
		
		return profile.getConfig().getInt("[" + externalPlugin.getName() + "]" + "." + player.getUniqueId().toString() + "." + name);
		
	}
        
        //Return external stat as Boolean
	public Boolean getExternalStatBool(Plugin externalPlugin, String name)
	{
		
		return profile.getConfig().getBoolean("[" + externalPlugin.getName() + "]" + "." + player.getUniqueId().toString() + "." + name);
		
	}
        
         //Return external stat as Float
	public Float getExternalStatFloat(Plugin externalPlugin, String name)
	{
		
		return (float) profile.getConfig().getInt("[" + externalPlugin.getName() + "]" + "." + player.getUniqueId().toString() + "." + name);
		
	}
	
	//Save config
	private void save()
	{
		
		profile.saveConfig();
		
	}
	
}
