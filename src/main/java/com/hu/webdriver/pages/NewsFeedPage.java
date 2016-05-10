package com.hu.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author venkatesh
 *
 */
public class NewsFeedPage extends BasePage{
	/**
	 * Constructor to Initialize the NewsFeedPage 
	 * @param driver
	 */
	public NewsFeedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	/**
	 * WebElement for NewsFeed Text
	 */
	@FindBy (xpath = "(//li/a[text()='News Feed'])[1]")
	WebElement newsFeed;
	/**
	 * WebElement for UpdateProfile 
	 */
	@FindBy (xpath = "//a[@href='/profile/edit']")
	WebElement updateProfile;
	/**
	 * WebElemnt for DropDown For Profile,Messages and Logout
	 */
	@FindBy (xpath = "(//span[@class='icon-down-open-1'])[1]")
	WebElement userMenuDropdown;
	/**
	 * WebElement for Logout
	 */
	@FindBy(id = "sitebar-logout-button")
	WebElement logout;
	/**
	 * WebElemenet for  
	 */
	@FindBy(id = "sitebar-messages-button")
	WebElement messages;
	/**
	 * Method to get NewsFeed Text.
	 * @return newsfeed text
	 */
	public String getNewsFeedText(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li/a[text()='News Feed'])[1]")));
		return  newsFeed.getText();
	}
	/**
	 * Method to Click On UpdateProfile.
	 */
	public void clickOnUpdateProfile(){
		findVisibleElement(By.xpath("//a[@href='/profile/edit']"), 30);
		updateProfile.click();
	}
	/**
	 * Method to Click On User Menu Drop Down. 
	 */
	public void clickOnUserMenuDropDown(){
		userMenuDropdown.click();
	}
	public void clickOnMessages(){
		userMenuDropdown.click();
		findVisibleElement(By.id("sitebar-messages-button"), 30);
		messages.click();
	}
	/**
	 * Method to Click On Logout.
	 */
	public void logout(){
		userMenuDropdown.click();
		findVisibleElement(By.id("sitebar-logout-button"), 30);
		logout.click();
	}
}
