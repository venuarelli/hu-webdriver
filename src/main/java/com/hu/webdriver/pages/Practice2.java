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

public class Practice2 {
	WebDriver driver;

	/*public void takeScreenShot(){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(" "+file.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void scrollToBottom(WebDriver driver){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void implicitywait(int seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public void findVisibleElement(WebElement element,int seconds){
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void findClickableElement(WebElement element,int seconds){
		WebDriverWait wait = new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean isEnable(WebElement element){
		boolean isEnabled = false;
		isEnabled = element.isEnabled();
		return isEnabled;
	}
	public void switchToAlert(boolean isAccept){
		Alert alert = driver.switchTo().alert();
		if(isAccept){
			alert.accept();
		}else {
			alert.dismiss();
		}
	}
	
	public void actions(WebElement element){
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	public void selectDropDown(WebElement element,String value,int index,String visibleText){
		Select slct = new Select(element);
		if(index >=0){
			slct.selectByIndex(index);
		}else if(value !=null){
			slct.selectByValue(value);
		}else if(visibleText !=null){
			slct.selectByVisibleText(visibleText);
		}
		
	}*/
	
	
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
	 * @param sec
	 */
	public void elementToBeVisibility(WebElement element,int sec){
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @param sec
	 */
	public void elementToBeClickable(WebElement element,int sec){
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * @param element
	 * @param sec
	 */
	public void elementToBeSelected(WebElement element,int sec){
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	/**
	 * 
	 * @param element
	 * @param index
	 * @param value
	 * @param visibleText
	 */
	public void selectAPI(WebElement element,int index,String value,String visibleText){
		Select select = new Select(element);
		if(index >=0){
			select.selectByIndex(index);
		}else if(value !=null){
			select.selectByValue(value);
		}else if(visibleText !=null){
			select.selectByVisibleText(visibleText);
		}
	}
	/**
	 * 
	 * @param element
	 */
	public void actionsAPI(WebElement element){
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	/**
	 * 
	 * @param isAccept
	 */
	public void alertAPI(boolean isAccept){
		Alert alert = driver.switchTo().alert();
		if(isAccept){
			alert.accept();
		}else{
			alert.dismiss();
	}
	}
	/**
	 * 
	 */
	public void takeScrreenShot(){
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(" "+srcFile.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void scrollToBottom(){
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean isEnable(WebElement element){
		boolean isEnable = false;
		isEnable = element.isEnabled();
		return isEnable;
	}
	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean isSelected(WebElement element){
		boolean isSelected = false;
		isSelected = element.isSelected();
		return isSelected;
	}
	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean isDisplayed(WebElement element){
		boolean isEnabled = false;
		isEnabled = element.isEnabled();
		return isEnabled;
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
	 * @param window
	 */
	public void switchToWindow(String window){
		driver.switchTo().window(window);
	}
	/**
	 * 
	 * @return
	 */
	public String getTitle(){
		String title = driver.getTitle();
		return title;
	}
	/**
	 * 
	 * @param element
	 * @return
	 */
	public String getText(WebElement element){
		String text = element.getText();
		return text;
	}
	/**
	 * 
	 * @return
	 */
	public String getCurrentURL(){
		String url = driver.getCurrentUrl();
		return url;
	}
	/**
	 * 
	 * @param element
	 * @param name
	 * @return
	 */
	public String getAttributeValue(WebElement element,String name){
		String value = element.getAttribute(name);
		return value;
	}
	/**
	 * 
	 * @param millis
	 */
	public void waitForSeconds(int sec){
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
