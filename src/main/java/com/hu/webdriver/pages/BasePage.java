package com.hu.webdriver.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hu.webdriver.utils.HUPropertyUtil;


/**
 * This class contains all base methods for entire project.
 * @author Venu
 *
 */
public class BasePage {
	 public static final int MAXIMUM = 30;
	 public static final int MINIMUM = 10;
	 public static final int ONE = 1;
	 public static final int TWO = 2;
	 public static final int FIVE = 5;
	
	/**
	 * Instance variable for Webdriver.
	 */
	public WebDriver driver;
	
	/**
	 * Instance variable for property util.
	 */
	public HUPropertyUtil propertyUtil;
	
	/**
	 * Constructor to initailize the BasePage.
	 * @param driver
	 */
	public BasePage(WebDriver driver){
		this.driver = driver;
		propertyUtil = new HUPropertyUtil();
	}
	
	/**
	 * Method to clear and type the text.
	 * @param element
	 * @param text
	 */
	public void clearAndType(WebElement element,String text){
		element.clear();
		element.sendKeys(text);
	}
	/**
	 * Method to implicityWait.
	 * @param seconds
	 */
	public void implicityWait(int seconds){ 
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	/**
	 * Method to findvisibleElement.
	 * @param by
	 * @param seconds
	 */
	public void findVisibleElement(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	/**
	 * Method too get list of strings.
	 * @param elements
	 * @return list.
	 */
	public List<String> getListOfStrings(List<WebElement> elements){
		List<String> list = new ArrayList<String>();
		for(WebElement element : elements){
			list.add(element.getText());
		}
		return list;
	}
	
	/**
	 * Method to check whether webelement is visible or not.
	 * @param element (Web Element)
	 * @return boolean (true if webelement is visible else false)
	 */
	public boolean isDisplayed(WebElement element){
		boolean isDisplayed = false;
		try{
			isDisplayed = element.isDisplayed();
		}catch(Exception e){
		}
		return isDisplayed;
	}
	/**
	 *Method to Wait for Seconds. 
	 * @param sec
	 */
	public void waitForSeconds(int sec){
		 
		 try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	/**
	 * Methhod for isdisplayed.
	 * @param by
	 * @return
	 */
	public boolean isDisplayed(By by){
		boolean isDisplayed = false;
		try{
			findVisibleElement(by, 10);
			isDisplayed = driver.findElement(by).isDisplayed();
		}catch(Exception e){
		}
		return isDisplayed;
	}
}
