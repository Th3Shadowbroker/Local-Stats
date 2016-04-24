package com.th3shadowbroker.loc.update;

import com.th3shadowbroker.loc.main;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UpdateChecker {
     
    private main plugin;
	private URL feed;
	
	private String version;
	private String link;
	
	public UpdateChecker(main plugin,String url){
		this.plugin = plugin;
		
		try {
			this.feed = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean updateAvailable(){
		
		try {
			InputStream In = feed.openConnection().getInputStream();
			Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(In);
			
			Node latestFile = xmlDoc.getElementsByTagName("item").item(0);
			NodeList children = latestFile.getChildNodes();
			
			version = children.item(1).getTextContent().replaceAll("[a-zA-Z ]", "");
			link = children.item(3).getTextContent();
			
			if( ! version.equals(plugin.getDescription().getVersion()) ){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public String getDlVersion(){
		return version;
	}
	
	public String getDownloadURL(){
		return link;
	}
    
}
