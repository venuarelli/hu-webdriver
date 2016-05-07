package com.hu.webdriver.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/**
 * This class contains all property files utilities.
 * @author venkatesh
 * @since May 7, 2016
 *
 */
public class HUPropertyUtil {

	/**
	 * Instance varaible for properties.
	 */
	Properties properties = new Properties();
	
	/**
	 * Constructor to load the all property files.
	 */
	public HUPropertyUtil(){
		try {
			FileReader fileReader = new FileReader(new File("src\\main\\resources\\default.properties"));
			properties.load(fileReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileReader fileReader = new FileReader(new File("src\\main\\resources\\hu.properties"));
			properties.load(fileReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to get the property value.
	 * @param property
	 * @return
	 */
	public String getProperty(String property){
		return properties.getProperty(property);
	}
}
