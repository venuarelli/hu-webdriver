package com.hu.webdriver.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.hu.webdriver.utils.HUPropertyUtil;

/**
 * This class contains base test features.
 * @author Venu
 *
 */
public class BaseTest {
	
	 public static final int MAXIMUM = 30;
	 public static final int MINIMUM = 10;
	 public static final int ONE = 1;
	 public static final int TWO = 2;
	 public static final int FIVE = 5;

	/**
	 * Instance variable for Webdriver.
	* */
	public WebDriver webDriver;
	/**
	 * Instance Variable for HUpropertyUtil
	 */
	public HUPropertyUtil propertyUtil; 
	
	/**
	 * Method  for BaseTest.
	 */
	public BaseTest(){
		propertyUtil = new HUPropertyUtil();
	}
	
	/**
	 * Method to get the WebDriver object.
	 * @return driver
	 */
	WebDriver getWebDriver(){
		String driver = this.propertyUtil.getProperty("driver");
		this.webDriver = getWebDriver(driver);
		return this.webDriver;
	}
	
	/**
	 * Method to initialize webdriver.
	 * @param driver
	 * @return webdriver
	 */
	public WebDriver getWebDriver(String driver){
		if(driver.equals("firefox")){
			this.webDriver  = new FirefoxDriver();
		}else if(driver.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\binaries\\chromedriver.exe");
			this.webDriver = new ChromeDriver();
		}else if(driver.equals("ie")){
			System.setProperty("webdriver.ie.driver", "src\\main\\resources\\binaries\\IEDriverServer.exe");
			this.webDriver = new InternetExplorerDriver();
		}else {
			this.webDriver = new HtmlUnitDriver();
		}
		return this.webDriver;
	}
	
	/**
	 * Method to get the home page URL.
	 * @return url.
	 */
	public String getHomePageURL(){
		String url = this.propertyUtil.getProperty("hu_url");
		return url;
	}
	
	/**
	 * Before Test for launch home page url.
	 */
	@BeforeTest
	public void beforeTest(){
		WebDriver driver = getWebDriver();
		driver.get(getHomePageURL());
		driver.manage().window().maximize();
	}
	
	/**
	 * After test logout from the page and navigate to home page.
	 */
	@AfterTest
	public void logOutFromHU(){
		this.webDriver.quit();
	}
}
