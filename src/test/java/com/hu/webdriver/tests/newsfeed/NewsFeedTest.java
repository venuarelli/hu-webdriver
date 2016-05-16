package com.hu.webdriver.tests.newsfeed;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.NewsFeedPage;
import com.hu.webdriver.pages.messages.MessagesPage;
import com.hu.webdriver.pages.messages.PublicUserProfilePage;
import com.hu.webdriver.tests.BaseLoginWebDriverTest;
/**
 * @author Venu
 */
public class NewsFeedTest extends BaseLoginWebDriverTest{
	
	NewsFeedPage newsFeedPage;
	MessagesPage messagesPage;
	PublicUserProfilePage publicUserProfilePage;
	@BeforeClass
	public void beforeClassLogin(){
		newsFeedPage = loginHUAndNavigateToNewsFeedPage();
	}
	
	@Test
	public void verifyNewsFeedPage(){
		String title  = webDriver.getTitle();
		System.out.println(title);
	}
	
	/**
	 * Test Case to verify Send message from user profile.
	 */
	@Test(description = "Test Case to verify Send message from user profile.")
	public void testSendMessageFromUserProfile(){
		publicUserProfilePage = newsFeedPage.clickOnPublicUser();
		String addRecipient = publicUserProfilePage.getPublicUserProfileName();
		publicUserProfilePage.clickOnMessageBUtton();
		messagesPage = new MessagesPage(webDriver);
		List<String>recipientNames = messagesPage.getRecipientsNames();
		Assert.assertTrue(recipientNames.toString().contains(addRecipient),"recipientName  not matched with expected.");
	}
	
	
	
	
	@AfterClass
	public void afterClassLogout(){
		//newsFeedPage.
	}

}
