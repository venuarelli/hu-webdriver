package com.hu.webdriver.tests.profile;

import org.testng.annotations.Test;
import com.hu.webdriver.pages.profile.ProfilePage;
import com.hu.webdriver.tests.BaseLoginWebDriverTest;

public class ProfileImageUploadTest extends BaseLoginWebDriverTest{

	@Test
	public void testUploadProfileImage(){
		ProfilePage profilePage = loginHUAndNavigateToProfilePage();
		profilePage.clickOnUploadButton();
		Process p =null;
		try {
			p = Runtime.getRuntime().exec("C:\\Users\\venkatesh\\Documents\\HuUpload.exe");
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
