package com.hu.webdriver.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;
import com.hu.webdriver.pages.NewsFeedPage;

/**
 * This class contains login page features.
 * @author Venu
 *
 */
public class HULoginPage extends BasePage{

	@FindBy (name = "email")
	WebElement userName;
	
	@FindBy (name ="password")
	WebElement password;
	
	@FindBy (id = "login-submit-button")
	WebElement login;
	
	public void setUserName(String userName){ 
		clearAndType(this.userName, userName);
	}
	public void setPassword(String password){
		clearAndType(this.password, password);
	}
	public NewsFeedPage clickOnSubmit(){
		login.click();
		return new NewsFeedPage(driver);
	}
	/**
	 * Constructor to initialize the HULogin page.
	 * @param driver
	 */
	public HULoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method to login into HU Page.
	 */
	public void loginHU(){
		String userName = this.propertyUtil.getProperty("hu_username");
		String password = this.propertyUtil.getProperty("hu_password");
		loginHU(userName,password);
	}

	/**
	 * Method to login into HU Page.
	 * @param userName
	 * @param password
	 */
	public void loginHU(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickOnSubmit();
	}
}
