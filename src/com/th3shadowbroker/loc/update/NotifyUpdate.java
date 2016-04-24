package com.th3shadowbroker.loc.update;

import com.th3shadowbroker.loc.sys.ColorCode;
import com.th3shadowbroker.locs.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NotifyUpdate implements Listener{
    
    private main plugin;
    
    public NotifyUpdate(main plugin)
    {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerJoinUpdateCheck(PlayerJoinEvent ev)
    {
        Player p = ev.getPlayer();
        UpdateChecker upc = new UpdateChecker(plugin, "http://dev.bukkit.org/bukkit-plugins/localstats/files.rss");
        
        if ( p.isOp() )
        {
            
            if ( upc.updateAvailable() )
            {
                
                p.sendMessage(plugin.prefix + ColorCode.CC("&ePlease update LOCStats !"));
                p.sendMessage(plugin.prefix + ColorCode.CC("&eDownload the newest version from http://bit.ly/localstats"));
                
            }
            
        }
        
    }
    
}
