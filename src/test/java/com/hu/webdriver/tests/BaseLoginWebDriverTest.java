package com.hu.webdriver.tests;

import org.testng.annotations.AfterClass;

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
		HUHomePage homePage = new HUHomePage(webDriver);
		HULoginPage loginPage = homePage.clickOnLoginButton();
		loginPage.loginHU();
		return new NewsFeedPage(webDriver);
	}
	/**
	 * Methosd to Login HU And navigate to Profile Page.
	 * @return Profile Page.
	 */
	
	public ProfilePage loginHUAndNavigateToProfilePage(){
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
	@AfterClass
	public void afterClassLogout(){
		NewsFeedPage newsFeedPage = new NewsFeedPage(webDriver);
		newsFeedPage.logout();
	}
}
