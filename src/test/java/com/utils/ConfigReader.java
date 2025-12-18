package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

// Property Handling – Single Responsibility

public class ConfigReader {

	private static Properties prop;

	public static Properties loadProperties() {
		prop = new Properties();
		try {
			String path = System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties";
			FileInputStream file = new FileInputStream(path);
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}