package com.th3shadowbroker.loc.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.th3shadowbroker.loc.main;

public class Loc implements CommandExecutor{

	private main plugin;
	
	public Loc(main plugin)
	{
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
            if (sender instanceof Player)
            {
                /*
                 *  If sender is player
                 */
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("loc"))
		{
			if(p.hasPermission("locstats.admin") | p.isOp())
			{
				p.sendMessage(plugin.prefix + "Local-Statistic System API");
				p.sendMessage(plugin.prefix + "Written by: " + plugin.author);
				p.sendMessage(plugin.prefix + "Current Version: " + plugin.version);
			}
		}
                
            }else{
                
                /*
                 *  If sender is console
                 */
                
                System.out.println(plugin.cprefix + "Local-Statistic System API");
		System.out.println(plugin.cprefix + "Written by: " + plugin.author);
		System.out.println(plugin.cprefix + "Current Version: " + plugin.version);
                
            }
            
		return false;
                
	}

}
