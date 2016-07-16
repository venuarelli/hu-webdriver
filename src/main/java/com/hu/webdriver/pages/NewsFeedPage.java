package com.hu.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.messages.PublicUserProfilePage;
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
		PageFactory.initElements(this.driver, this);
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
	 * WebElemenet for messages. 
	 */
	@FindBy(id = "sitebar-messages-button")
	WebElement messages;
	/**
	 * WebElement for public user.
	 */
	@FindBy (xpath = "(//img[@class='avatar-img'])[3]")
	WebElement publicUser;
	/**
	 * Method to get NewsFeed Text.
	 * @return newsfeed text
	 */
	public String getNewsFeedText(){
		findVisibleElement(By.xpath("(//li/a[text()='News Feed'])[1]"), MAXIMUM);
		return  newsFeed.getText();
	}
	/**
	 * Method to Click On UpdateProfile.
	 */
	public void clickOnUpdateProfile(){
		findVisibleElement(By.xpath("//a[@href='/profile/edit']"), MAXIMUM);
		updateProfile.click();
	}
	/**
	 * Method to Click On User Menu Drop Down. 
	 */
	public void clickOnUserMenuDropDown(){
		findVisibleElement(By.xpath("(//span[@class='icon-down-open-1'])[1]"), MAXIMUM);
		userMenuDropdown.click();
	}
	/**
	 * Method to click on messages.
	 */
	public void clickOnMessages(){
		findVisibleElement(By.xpath("(//span[@class='icon-down-open-1'])[1]"), MAXIMUM);
		userMenuDropdown.click();
		findVisibleElement(By.id("sitebar-messages-button"), MAXIMUM);
		messages.click();
	}
	/**
	 * Method to Click On Logout.
	 */
	public void logout(){
		userMenuDropdown.click();
		findVisibleElement(By.id("sitebar-logout-button"), MAXIMUM);
		logout.click();
	}
	/**
	 * Method to Click On Public User.
	 * @return PublicUserProfilePage.
	 */
	public PublicUserProfilePage clickOnPublicUser(){
		findVisibleElement(By.xpath("(//img[@class='avatar-img'])[3]"), MAXIMUM);
		publicUser.click();
		return new PublicUserProfilePage(driver);
	}
}
