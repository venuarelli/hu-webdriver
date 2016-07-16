package com.hu.webdriver.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;
import com.hu.webdriver.pages.login.HULoginPage;
/**
 * This class contains all HUHomePage Features.
 * @author venu
 *
 */
public class HUHomePage extends BasePage{
	
	public static final int MAXIMUM = 30;

	/**
	 * WebElement for LoginButton
	 */
	@FindBy (linkText = "Log in")
	WebElement logInButton;
	
/**
 * 	Constructor to Initialize the HUHomePage
 *  @param driver
 */
	public HUHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	/**
	 * Method to Click On LoginBUtton
	 * @return HULogin page.
	 */
	public HULoginPage clickOnLoginButton(){
		//findVisibleElement(logInButton, MAXIMUM);
		findVisibleElement(By.xpath("(//a[@href='/login'])[1]"), MAXIMUM);
		logInButton.click();
		return new HULoginPage(driver);
	}

}
