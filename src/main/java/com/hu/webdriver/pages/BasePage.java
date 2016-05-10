package com.hu.webdriver.pages;

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
	
	public void implicityWait(int seconds){ 
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public void findVisibleElement(By by,int seconds){
		WebDriverWait wait  = new WebDriverWait(driver, seconds); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
	
}
