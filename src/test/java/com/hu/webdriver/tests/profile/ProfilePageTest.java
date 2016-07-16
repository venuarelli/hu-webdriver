 package com.hu.webdriver.tests.profile;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.HUGroups;
import com.hu.webdriver.pages.profile.ProfilePage;
import com.hu.webdriver.pages.profile.UpDateProfilePage;
import com.hu.webdriver.tests.BaseLoginWebDriverTest;

/** 
 * This Class Contains ProfilePage features
 * @author Venu
 *
 */
public class ProfilePageTest extends BaseLoginWebDriverTest{
	/**
	 * Instance variable for ProfilePage.
	 */
	ProfilePage profilePage;
	/**
	 * Before Class for Login nad Navigate to ProfilePage.
	 */
	@BeforeClass
	public void beforeMethodNavigateToProfile(){
		Reporter.log("Executing-----beforeclass");
		//Login and Navigate to ProfilePage.
		profilePage = loginHUAndNavigateToProfilePage();
	}
	/**
	 * Test Case to verify Enter BIO.
	 */
	@Test(groups={HUGroups.PROFILE},description = "Test Case to verify Enter BIO.")
	public void testEnterBIO(){
		//Get bio from propetyfile.
		String bio = propertyUtil.getProperty("hu_bio");
		//Enetr BIO Data.
		profilePage.fillYourBio(bio);
		//Click on Save Changes Button.
		profilePage.clickOnSaveChangesButton();
		//Creating Object for UpdateProfilePage
		UpDateProfilePage updateProfilePage = new UpDateProfilePage(webDriver);
		// Get the actual and expcted text.
		String actualText = updateProfilePage.getBIOText();
		String expectedText = propertyUtil.getProperty("profile.bio");
		//Verify Bio data on page.  
		Assert.assertTrue(actualText.contains(expectedText),"Bio data text is not matched with expected");
		profilePage.clearBIO();
	}
	/**
	 * Test Case to Verify EditBIO.
	 */
	@Test(groups={HUGroups.PROFILE},description = "Test Case to Verify Edit BIO")
	public void testEditBIO(){
		//Get BIO from Property File.
		String editBIO = propertyUtil.getProperty("hu_editbio");
		//Enetr BIO data.
		profilePage.editYourBio(editBIO);
		//Click On Save Changes.
		profilePage.clickOnSaveChangesButton();
		//Creating Object for Update ProfilePage.
		UpDateProfilePage upDateProfilePage = new UpDateProfilePage(webDriver);
		//Get the actual and expected text.
		String actualText = upDateProfilePage.getBIOText();
		String expectedText = propertyUtil.getProperty("hu_editbio");
		//Verify BIO Data On Page.
		Assert.assertFalse(actualText.contains(expectedText),"Bio data Text is not Matched with Expected");
	}
	
	/**
	 * Test Case to verify Addding New Symptom.
	 */
	@Test(groups={HUGroups.PROFILE},description = "Test case to vrify Adding New Symptom")
	public void testAddANewSymptom(){
		//Get Symptom Data from Property File.
		String symptom = propertyUtil.getProperty("hu_symptom");
		//Enter Symptom Data.
		profilePage.enterSymptom(symptom);
		profilePage.enterSymptom(""+Keys.ENTER);
		//Click On Save Changes.
		profilePage.clickOnSaveChangesButton();
		//Creating Object for Update ProfilePage.
		UpDateProfilePage updateProfilePage = new UpDateProfilePage(webDriver);
		//Get the actual and expected Text.
		String actualText = updateProfilePage.getBruiseText();
		String expectedText = propertyUtil.getProperty("profile.symptom");
		//Vderify Symptom Data On Page.
		Assert.assertEquals(actualText.toUpperCase(), expectedText,"Symptom is not matched with expected");
	}
	/**
	 * Test case to verify Adding A New Condition.
	 */
	@Test (groups={HUGroups.PROFILE},description = "Test case to verify Adding New Condition")
	public void testAddANewCondition(){
		//Get Condition Data from PropertyFile.
		String condition = propertyUtil.getProperty("hu_condition");
		//Enter Condition Data.
		profilePage.enterCondition(condition);
		profilePage.enterCondition(""+Keys.ENTER);
		//Click On Save Changes.
		profilePage.clickOnSaveChangesButton();
		//Creating Object for UpdateProfile Page.
		UpDateProfilePage upDateProfilePage = new UpDateProfilePage(webDriver);
		//Get the actual and expected.
		String actualText = upDateProfilePage.getThyrotoxicosisText();
		String expectedText = propertyUtil.getProperty("profile.condition");
		//Verify Condition Data On Page.
		Assert.assertEquals(actualText, expectedText.toUpperCase(),"Condition is not matched to Expected");
}
	@Test(groups={HUGroups.PROFILE},description = "Test Case To verify Adding A New Treatment")
	public void testAddANewTreatment(){
		//Get Treatment Data from PropertyPage.
		String treatement = propertyUtil.getProperty("hu_treatment");
		//Enter Treatment Data.
		profilePage.enterTreatement(treatement);
		profilePage.enterTreatement(""+Keys.ENTER);
		//Click On Save Changes.
		profilePage.clickOnSaveChangesButton();
		//Creating Object for UpdateProfilePage.
		UpDateProfilePage upDateProfilePage = new UpDateProfilePage(webDriver);
	    //Get actual and expected Text.	
		String actualText  = upDateProfilePage.getMethotrexateText();
		String expectedText = propertyUtil.getProperty("profile.treatment");
		//Verify Treatement Data On Page.
		Assert.assertEquals(actualText, expectedText.toUpperCase(),"Treatment is not matched with Expected");
	}
	/**
	 * Test Case to verify Edit My DOB
	 */
	@Test(groups={HUGroups.PROFILE},description = "Test Case to verify Edit My DOB")
	public void testEditMyDOB(){
		//Get Data from Property Page.
		String date  = propertyUtil.getProperty("profile.date");
		//Enter date Data. 
		profilePage.selectDateDropDown(date);
		//Get Data from Property Page.
		String month  = propertyUtil.getProperty("profile.month");
		//Enter Month Data. 
		profilePage.selectMonthDropDown(month);
		//Get Data from Propety Page.
		String year = propertyUtil.getProperty("profile.year");
		//Enter year Data. 
		profilePage.selectYearDropDown(year);
		//Click On Save Changes.
		profilePage.clickOnSaveChangesButton();
		//Get Profile Page Text.
		profilePage.getProfilePageText();
		//Creting Object for Update ProfilePage.
		UpDateProfilePage upDateProfilePage = new UpDateProfilePage(webDriver);
		//Get actual and Expected text.
		String actualText = upDateProfilePage.getProfilePageText();
		String expectedText = propertyUtil.getProperty("profile.profiletext");
		//Verify DOB Data On Page.
		Assert.assertEquals(actualText, expectedText,"Profile Text is not Matched with Expected");
	}
	/**
	 * Test Case to Verify Edit Gender
	 */
	@Test(groups={HUGroups.PROFILE},description = "Test Case to Verify Edit Gender")
	public void testEditGender(){
		//Set Gender.
		profilePage.setGender();
		//Click On Save Changes.
		profilePage.clickOnSaveChangesButton();
		//Creating Object for UpdateProfile Page.
		UpDateProfilePage upDateProfilePage = new UpDateProfilePage(webDriver);
		//Get actual and expected Text.
		String actualText = upDateProfilePage.getGenderText();
		String expectedText = propertyUtil.getProperty("profile.gender");
		//Verify Gender Data On Page.
		Assert.assertEquals(actualText, expectedText,"Gendr text is not Matched with Expected");
	}
	/**
	 * Test case to verify upload profile picture.
	 *//*
	@Test(groups={HUGroups.PROFILE},description = "Test case to verify upload profile picture.")
	public void testUploadPicture(){
		UpDateProfilePage update = new UpDateProfilePage(webDriver);
		update.clickOnUploadButton();
		
	}*/
}