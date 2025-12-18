package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

// Property Handling – Single Responsibility
// Properties → Java class to handle .properties files (key=value)
// FileInputStream → Reads file from disk

public class ConfigReader {

	private static Properties prop;
	
	/*	
	Why static?
		-> Properties should be shared
		-> Loaded once and reused
		-> Avoids reading file repeatedly
	Why private?
		-> Encapsulation - It is the process of hiding internal data by making fields private and providing controlled access through public methods
		-> Access only through methods
	*/

	public static Properties loadProperties() {
		
		/*
		static → can be called without object creation
		Returns Properties → caller can do getProperty("browser")
		*/
		
		prop = new Properties();
		try {
			String path = System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties";
			FileInputStream file = new FileInputStream(path);
			prop.load(file);			
			/*
			Opens config file
			Loads key-value pairs into memory
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}