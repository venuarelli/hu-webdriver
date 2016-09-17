package com.hu.webdriver.pages;

import org.apache.log4j.Logger;

public class Log4jExample {
	
	
	static Logger log = Logger.getLogger(Log4jExample.class);
	
	public static void main(String[] args) {
		log.info("Information Log.");
		log.warn("Warning Log");
		log.fatal("Fatal Log");
		log.debug("Debug Log");
		log.error("Error Log");
	}

}
