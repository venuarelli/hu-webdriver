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
 * This class contains all Newsfeedtest features.
 * @author Venu
 */
public class NewsFeedTest extends BaseLoginWebDriverTest{
	/**
	 * Instance variable for newsfeedpage.
	 */
	NewsFeedPage newsFeedPage;
	/**
	 * Instance variable for messagespage.
	 */
	MessagesPage messagesPage;
	/**
	 * Instance variable for Publicuserprofilepage.
	 */
	PublicUserProfilePage publicUserProfilePage;
	/**
	 * Before class for loginHU and navigate to newsfeed page.
	 */
	@BeforeClass
	public void beforeClassLogin(){
		newsFeedPage = loginHUAndNavigateToNewsFeedPage();
	}
	/**
	 * Method to verify newsfeedpage.
	 */
	@Test(description = "Method to verify newsfeedpage.")
	public void verifyNewsFeedPage(){
		String title  = webDriver.getTitle();
		System.out.println(title);
	}
	
	/**
	 * Test Case to verify Send message from user profile.
	 */
	@Test(description = "Test Case to verify Send message from user profile.")
	public void testSendMessageFromUserProfile(){
		//click on public user.
		publicUserProfilePage = newsFeedPage.clickOnPublicUser();
		//Get recipient name from propertyfile.
		String addRecipient = publicUserProfilePage.getPublicUserProfileName();
		//click on messages button.
		publicUserProfilePage.clickOnMessageBUtton();
		//Creating Object fro MessagesPage.
		messagesPage = new MessagesPage(webDriver);
		//Get list of recipient names.
		List<String>recipientNames = messagesPage.getRecipientsNames();
		//verfy recipient name matched with addrecipient or not.
		Assert.assertTrue(recipientNames.toString().contains(addRecipient),"recipientName  not matched with expected.");
	}
	
	
	
	
	@AfterClass
	public void afterClassLogout(){
		//newsFeedPage.
	}

}
