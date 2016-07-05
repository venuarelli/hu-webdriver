package com.hu.webdriver.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {
	WebDriver driver;
	
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public void clearAndType(WebElement element,String text){
		element.clear();
		element.sendKeys(text);
	}
	/**
	 * 
	 * @param seconds
	 */
	public void implicityWait(int seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param element
	 * @param seconds
	 */
	public void findVisibileElement(WebElement element, int seconds){
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @param seconds
	 */
	public void findClickableElement(WebElement element,int seconds){
		WebDriverWait wait = new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * @param element
	 * @return isEnabled
	 */
	public boolean isEnabled(WebElement element){
	boolean isEnabled = false;
	isEnabled = element.isEnabled();
	return isEnabled;
	}
	/**
	 * 
	 * @param element
	 * @return isDisplayed
	 */
	public boolean isDisplayed(WebElement element){
		boolean isDisplayed = false;
		isDisplayed = element.isDisplayed();
		return isDisplayed;
	} 
	/**
	 * 
	 * @param element
	 * @return isSelected
	 */
	public boolean isClickable(WebElement element){
		boolean isSelected = false;
		isSelected = element.isSelected();
		return isSelected;
	}
	/**
	 * 
	 */
	public void takeScreenShot(){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("path"+file.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollToBottom(WebDriver driver){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight");
	}
	/**
	 * 
	 * @param isAccept
	 */
	public void switchToAlert(boolean isAccept){
		Alert alert = driver.switchTo().alert();
		if(isAccept){
			alert.accept();
		}else{
			alert.dismiss();
		}
	}
	/**
	 * 
	 * @param element
	 */
	public void actions(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	/**
	 * 
	 * @param element
	 * @param value
	 * @param visibleText
	 * @param index
	 */
	public void selectDropDown(WebElement element,String value,String visibleText,int index){
		Select select = new Select(element);
		if(index >=0){
		select.selectByIndex(index);
	}else if(value !=null){
		select.selectByValue(value);
	}else if (visibleText !=null){
		select.selectByVisibleText(visibleText);
	}
	}
	/**
	 * 
	 * @param windowName
	 */
	public void switchToWindow(String windowName){
		driver.switchTo().window(windowName);
	}
	/**
	 * 
	 * @param element
	 */
	public void switchToFrame(WebElement element){
		driver.switchTo().frame(element);
	}
	/**
	 * 
	 * @param element
	 * @return text
	 */
	public String getText(WebElement element){
		String text = element.getText();
		return text;
	}
	/**
	 * 
	 * @return url
	 */
	public String getCurrentURL(){
		String url = driver.getCurrentUrl();
		return url;
	}
	/**
	 * 
	 * @return title
	 */
	public String getTitle(){
		String title = driver.getTitle();
		return title;
	}
	/**
	 * 
	 * @param element
	 * @param attribute
	 * @return value
	 */
	public String getAttributeValue(WebElement element,String attribute){
		String value = element.getAttribute(attribute);
		return value;
	}
	/**
	 * 
	 * @param sec
	 */
	public void waitForSeconds(int sec){
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}