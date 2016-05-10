package com.hu.webdriver.tests;

import org.testng.annotations.AfterClass;

import com.hu.webdriver.pages.NewsFeedPage;
import com.hu.webdriver.pages.home.HUHomePage;
import com.hu.webdriver.pages.login.HULoginPage;
import com.hu.webdriver.pages.messages.MessagesPage;
import com.hu.webdriver.pages.profile.ProfilePage;
import com.hu.webdriver.tests.messages.MessagesTest;

public class BaseLoginWebDriverTest extends BaseTest{
	
	protected NewsFeedPage newsFeedPage;
	/**
	 * Method to login HU and navigate to News feed page.
	 * @return
	 */
	public NewsFeedPage loginHUAndNavigateToNewsFeedPage(){
		HUHomePage homePage = new HUHomePage(webDriver);
		HULoginPage loginPage = homePage.clickOnLoginButton();
		loginPage.loginHU();
		return new NewsFeedPage(webDriver);
	}
	
	public ProfilePage loginHUAndNavigateToProfilePage(){
		NewsFeedPage newsFeedPage = loginHUAndNavigateToNewsFeedPage();
		newsFeedPage.clickOnUpdateProfile();
		return new ProfilePage(webDriver);
	}
	
	public MessagesPage loginHuAndNavigateToMessagesPage(){
		NewsFeedPage newsFeedPage = loginHUAndNavigateToNewsFeedPage();
		newsFeedPage.clickOnMessages();
		return new MessagesPage(webDriver);
		
	}

	@AfterClass
	public void afterClassLogout(){
		NewsFeedPage newsFeedPage = new NewsFeedPage(webDriver);
		newsFeedPage.logout();
	}
}
