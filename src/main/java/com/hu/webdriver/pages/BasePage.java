package com.hu.webdriver.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hu.webdriver.utils.HUPropertyUtil;

/**
 * This class contains all base methods for entire project.
 * 
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
	 * 
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		propertyUtil = new HUPropertyUtil();
	}

	/**
	 * Method to clear and type the text.
	 * 
	 * @param element
	 * @param text
	 */
	public void clearAndType(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method to implicityWait.
	 * 
	 * @param seconds
	 */
	public void implicityWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Method to findvisibleElement.
	 * 
	 * @param by
	 * @param seconds
	 */
	public void findVisibleElement(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * Method to findvisibilityElement.
	 * 
	 * @param element
	 * @param seconds
	 */
	public void findVisibleElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(this.driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Method to findClkable Element.
	 * 
	 * @param by
	 * @param seconds
	 */
	public void findClickableElement(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Method to findclickable Element.
	 * 
	 * @param element
	 * @param seconds
	 */
	public void findClickableElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Method too get list of strings.
	 * 
	 * @param elements
	 * @return list.
	 */
	public List<String> getListOfStrings(List<WebElement> elements) {
		List<String> list = new ArrayList<String>();
		for (WebElement element : elements) {
			list.add(element.getText());
		}
		return list;
	}

	/**
	 * Method to check whether webelement is visible or not.
	 * 
	 * @param element
	 *            (Web Element)
	 * @return boolean (true if webelement is visible else false)
	 */
	public boolean isDisplayed(WebElement element) {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
		} catch (Exception e) {
		}
		return isDisplayed;
	}

	/**
	 * Methhod for isdisplayed.
	 * 
	 * @param by
	 * @return isDisplayed.
	 */
	public boolean isDisplayed(By by) {
		boolean isDisplayed = false;
		try {
			findVisibleElement(by, 10);
			isDisplayed = driver.findElement(by).isDisplayed();
		} catch (Exception e) {
		}
		return isDisplayed;
	}

	/**
	 * Method to Wait for Seconds.
	 * 
	 * @param sec
	 */
	public void waitForSeconds(int sec) {

		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to select Drop Down.
	 * 
	 * @param element
	 * @param index
	 * @param value
	 * @param visibleText
	 */
	public void selectDropDown(WebElement element, int index, String value,
			String visibleText) {
		Select select = new Select(element);
		if (index >= 0) {
			select.selectByIndex(index);
		} else if (value != null) {
			select.selectByValue(value);
		} else if (visibleText != null) {
			select.selectByVisibleText(visibleText);
		}
	}

	/**
	 * Method to move to element.
	 * 
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/**
	 * Method to switch to frame.
	 * 
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * Method to Switch To Alert.
	 * 
	 * @param isAccept
	 */
	public void switchToAlert(boolean isAccept) {
		Alert alert = driver.switchTo().alert();
		if (isAccept) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}

	/**
	 * method to switch to window.
	 * 
	 * @param windowName
	 */
	public void switchToWindow(String windowName) {
		driver.switchTo().window(windowName);
	}

	/**
	 * Method to get text.
	 * 
	 * @param element
	 * @return text
	 */
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * Method to get Attribute value.
	 * 
	 * @param element
	 * @param attribute
	 * @return text
	 */
	public String getAttributeValue(WebElement element, String attribute) {
		String text = element.getAttribute(attribute);
		return text;
	}

	/**
	 * Method get title.
	 * 
	 * @return title.
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * method to get current url
	 * 
	 * @return url.
	 */
	public String getCurrentURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 * Method to take screenshot.
	 */
	public void takeScreenShot() {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(
					"C:\\Eclipse\\hu-webdriver\\screenshots" + file.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to is Enabled.
	 * 
	 * @param element
	 * @return isEnabled.
	 */
	public boolean isEnabled(WebElement element) {
		boolean isEnabled = false;
		isEnabled = element.isEnabled();
		return isEnabled;
	}

	/**
	 * Method to isEnabled.
	 * 
	 * @param by
	 * @return isEnabled.
	 */
	public boolean isEnabled(By by) {
		boolean isEnabled = false;
		findVisibleElement(by, MAXIMUM);
		isEnabled = driver.findElement(by).isEnabled();
		return isEnabled;
	}

	/**
	 * method to is Selected.
	 * 
	 * @param element
	 * @return isSelected.
	 */
	public boolean isSelected(WebElement element) {
		boolean isSelected = false;
		isSelected = element.isSelected();
		return isSelected;
	}

	/**
	 * Method to isSelected.
	 * 
	 * @param by
	 * @return isSelected.
	 */
	public boolean isSelected(By by) {
		boolean isSelected = false;
		findVisibleElement(by, MAXIMUM);
		isSelected = driver.findElement(by).isSelected();
		return isSelected;
	}

	/**
	 * Method to Scroll to Bottom.
	 * 
	 * @param driver
	 */
	public void scrollToBottom(WebDriver driver) {
		((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
