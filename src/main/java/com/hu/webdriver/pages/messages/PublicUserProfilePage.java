package com.hu.webdriver.pages.messages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hu.webdriver.pages.BasePage;
/**
 * This class contains all Publiuserprofilepage features.
 * @author venu
 *
 */
public class PublicUserProfilePage extends BasePage {

	/**
	 * WebElement for Public user profile name.
	 */
	@FindBy (xpath = "//h1[@class='entity-header-title']")
	WebElement publicUserName;
	/**
	 * WebElement for click on message Button.
	 */
	@FindBy (xpath = "(//a[@class='btn btn-blank'])[1]")
	WebElement messageButton;
	/**
	 * Constructor to Initialize Public user profile name.
	 * @param driver
	 */
	public PublicUserProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	/**
	 * Method to get Public user profile name.
	 * @return text.
	 */
	public String getPublicUserProfileName(){
		findVisibleElement(By.xpath("//h1[@class='entity-header-title']"), MAXIMUM);
		String text = publicUserName.getText();
		return text;
	}
	/**
	 * Method to click on message button.
	 */
	public void clickOnMessageBUtton(){
		messageButton.click();
	}
}
