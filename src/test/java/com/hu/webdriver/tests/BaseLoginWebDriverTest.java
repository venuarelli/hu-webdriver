package com.hu.webdriver.tests;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.hu.webdriver.pages.NewsFeedPage;
import com.hu.webdriver.pages.home.HUHomePage;
import com.hu.webdriver.pages.login.HULoginPage;
import com.hu.webdriver.pages.messages.MessagesPage;
import com.hu.webdriver.pages.profile.ProfilePage;

/**
 * This Class Contains all BaseLoginWebDriverTest features.
 * @author Venu.
 *
 */
public class BaseLoginWebDriverTest extends BaseTest{
	/**
	 * Instance Variable for NewsFeedPage.
	 */
	protected NewsFeedPage newsFeedPage;
	/**
	 * Method to login HU and navigate to News feed page.
	 * @return NewsFeedPage.
	 */
	public NewsFeedPage loginHUAndNavigateToNewsFeedPage(){
		HUHomePage homePage = new HUHomePage(this.webDriver);
		HULoginPage loginPage = homePage.clickOnLoginButton();
		loginPage.loginHU();
		return new NewsFeedPage(this.webDriver);
	}
	/**
	 * Methosd to Login HU And navigate to Profile Page.
	 * @return Profile Page.
	 */
	
	public ProfilePage loginHUAndNavigateToProfilePage(){
		Reporter.log("Executing-----loginHUAndNavigateToProfilePage");
		NewsFeedPage newsFeedPage = loginHUAndNavigateToNewsFeedPage();
		newsFeedPage.clickOnUpdateProfile();
		return new ProfilePage(webDriver);
	}
	/**
	 * Method to Login HU and Navigate to MessagesPage.
	 * @return MessagesPage.
	 */
	public MessagesPage loginHuAndNavigateToMessagesPage(){
		NewsFeedPage newsFeedPage = loginHUAndNavigateToNewsFeedPage();
		newsFeedPage.clickOnMessages();
		return new MessagesPage(webDriver);
		
	}
	/**
	 * AfterClass for Logout.
	 */
	@AfterClass(alwaysRun=true)
	public void afterClassLogout(){
		NewsFeedPage newsFeedPage = new NewsFeedPage(webDriver);
		newsFeedPage.logout();
	}
	
	/**
	 * Before Test for launch home page url.
	 */
	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		Reporter.log("Executing-----beforeTest");
		this.webDriver = getWebDriver();
		this.webDriver.get(getHomePageURL());
		this.webDriver.manage().window().maximize();
	}
	
	/**
	 * After test logout from the page and navigate to home page.
	 */
	@AfterTest(alwaysRun=true)
	public void logOutFromHU(){
		this.webDriver.quit();
	}
}
