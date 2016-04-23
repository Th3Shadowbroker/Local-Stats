package com.th3shadowbroker.loc.sys;

public class ColorCode {

	public static String CC(String input)
	{
		
		if ( input.contains("&") )
		{
			
			return input.replaceAll("&", "§");
			
		}else{
			
			return input;
			
		}
		
	}
	
}
