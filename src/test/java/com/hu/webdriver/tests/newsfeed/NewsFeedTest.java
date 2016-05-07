package com.hu.webdriver.tests.newsfeed;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.NewsFeedPage;
import com.hu.webdriver.tests.BaseTest;
/**
 * @author Venu
 */
public class NewsFeedTest extends BaseTest{
	
	NewsFeedPage newsFeedPage;
	@BeforeClass
	public void beforeClassLogin(){
		newsFeedPage = loginHUAndNavigateToNewsFeedPage();
	}
	
	@Test
	public void verifyNewsFeedPage(){
		String title  = webDriver.getTitle();
		System.out.println(title);
	}
	
	@AfterClass
	public void afterClassLogout(){
		//newsFeedPage.
	}

}
