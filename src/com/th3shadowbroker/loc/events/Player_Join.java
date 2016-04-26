package com.th3shadowbroker.loc.events;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.th3shadowbroker.loc.main;
import com.th3shadowbroker.loc.obj.PlayerProfile;

@SuppressWarnings("unused")
public class Player_Join implements Listener{

	private main plugin;
	private String prefix;
	
	public Player_Join(main plugin)
	{
		
		this.plugin = plugin;
		this.prefix = plugin.prefix;
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent ev)
	{
		
		Player player = ev.getPlayer();
		
		PlayerProfile profile = new PlayerProfile(plugin, player);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
		Date currentTime = new Date();
		
		profile.setStat("LastName", player.getName());
		profile.setStat("LastIP", player.getAddress().toString());
		profile.setStat("LastLogin", formatter.format(currentTime));
		
		System.out.println(plugin.cprefix + "Profile loaded: " + profile.getUID());
		
	}
	
}
