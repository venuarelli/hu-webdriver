package com.hu.webdriver.pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;
import com.hu.webdriver.pages.login.HULoginPage;

public class HUHomePage extends BasePage{

	/**
	 * 
	 */
	@FindBy (xpath = "//a[@href='/login']")
	WebElement logInButton;
	
	public HUHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public HULoginPage clickOnLoginButton(){
		logInButton.click();
		return new HULoginPage(driver);
	}

}
