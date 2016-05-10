package com.hu.webdriver.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hu.webdriver.pages.BasePage;

/**
 * This Class Contains all the ProfilePage features.
 * 
 * @author Venu
 *
 */
public class ProfilePage extends BasePage {
	/**
	 * Constructor to Initialize the ProfilePage
	 * 
	 * @param driver
	 */
	public ProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * WebElement for updateProfile
	 */
	@FindBy(xpath = "//a[@href='/profile/edit']")
	WebElement updateProfile;
	/**
	 * WebElement for FillYour Bio
	 */
	@FindBy(name = "limitedTextArea")
	WebElement fillYourBio;
	/**
	 * WebElement For Save Changes
	 */
	@FindBy(xpath = "//input[@value='Save changes']")
	WebElement saveChanges;
	/**
	 * WebElemnt for DropDown For Profile
	 */
	@FindBy(xpath = "(//span[@class='icon-down-open-1'])[1]")
	WebElement dropDownForProfile;
	/**
	 * WebElement for Profile
	 */
	@FindBy(id = "sitebar-profile-button")
	WebElement profile;
	/**
	 * WebElemnt for following
	 */
	@FindBy(xpath = "//span[text()='Following']")
	WebElement following;
	/**
	 * WebElement for Folowing Button
	 */
	@FindBy(xpath = "//button[text()='Following']")
	WebElement followingButton;
	/**
	 * WebElement for Unfollow Button
	 */
	@FindBy(xpath = "//button[text()='Unfollow']")
	WebElement unFollowButton;
	/**
	 * WebElement for Follow Button
	 */
	@FindBy(xpath = "//button[text()='Follow']")
	WebElement followButton;
	/**
	 * WebElement For Symptom
	 */
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement symptom;
	/**
	 * WebElement for Condition
	 */
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement condition;
	/**
	 * WebElement for Treatments
	 */
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement treatement;
	/**
	 * WebElement for BruiseText
	 */
	@FindBy(xpath = "//a[text()='Bruise']")
	WebElement bruiseText;
	/**
	 * WebElement for ThyrotoxicosisText
	 */
	@FindBy(xpath = "//a[text()='Thyrotoxicosis']")
	WebElement thyrotoxicosisText;
	/**
	 * WebElement for Methotrexate Text
	 */
	@FindBy(xpath = "//a[text()='Methotrexate']")
	WebElement methotrexateText;
	/**
	 * WebElement for Date Drop Down
	 */
	@FindBy(xpath = "(//select[contains(class,day)])[1]")
	WebElement dateDropDown;
	/**
	 * Webelement for Momth Drop Down
	 */
	@FindBy(xpath = "(//select[contains(class,day)])[2]")
	WebElement monthDropDown;
	/**
	 * WebElement for Year Drop Down
	 */
	@FindBy(xpath = "(//select[contains(class,day)])[3]")
	WebElement yearDropDown;
	/**
	 * WebElement for Country DropDown
	 */
	@FindBy(xpath = "(//select[contains(class,day)])[4]")
	WebElement countryDropDown;
	/**
	 * WebElement for ProfilePageText
	 */
	@FindBy(xpath = "//span[text()='Hi! I’m aarellivenu']")
	WebElement profilePageText;
	/**
	 * ` WebElement for Male
	 */
	@FindBy(xpath = "//span[text()='Male']")
	WebElement male;

	/**
	 * WebElement for PostalCode
	 */
	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement postalcode;
	/**
	 * WebElement for BIO Clear.
	 */
	@FindBy(name = "limitedTextArea")
	WebElement bioClear;
	/**
	 * WebElement for Edit Profile.
	 */
	@FindBy(xpath = "//a[@href='/profile/edit']")
	WebElement editProfile;

	/**
	 * Method to click On UpdateProfile
	 */
	public void clickOnUpdateProfile() {
		findVisibleElement(By.xpath("//a[@href='/profile/edit']"), 30);
		updateProfile.click();
	}

	/**
	 * Method to Fill Your Bio
	 */
	public void fillYourBio(String bio) {
		findVisibleElement(By.name("limitedTextArea"), 30);
		clearAndType(fillYourBio, bio);
	}

	/**
	 * Method to Click On SavChanges Button
	 */
	public void clickOnSaveChangesButton() {
		saveChanges.click();
	}

	/**
	 * Method to Edit Your Bio
	 */
	public void editYourBio(String editBIO) {
		findVisibleElement(By.name("limitedTextArea"), 30);
		clearAndType(fillYourBio, editBIO);
	}

	/**
	 * Method to Click On Drop Down For Profile
	 */
	public void clickOnDropDownForProfile() {
		dropDownForProfile.click();
	}

	/**
	 * Method to Click On Profile
	 */
	public void clickOnProfile() {
		profile.click();
	}

	/**
	 * Method to Click On Following
	 */
	public void clickOnFollowing() {
		following.click();
	}

	/**
	 * Method To FollowingButton
	 */
	public void clickOnFollowingButton() {
		followingButton.click();
	}

	/**
	 * Mthod to Click On Follow Button
	 */
	public void clickOnUnFollowButton() {
		unFollowButton.click();
	}

	/**
	 * Method to get Follow text
	 * 
	 * @return text
	 */
	public String getFollowText() {
		String text = followButton.getText();
		return text;
	}

	/**
	 * Method to Enter Symptom
	 */
	public void enterSymptom(String symptom) {
		clearAndType(this.symptom, symptom);
	}

	/**
	 * Method to Enter Condition
	 */
	public void enterCondition(String condition) {
		clearAndType(this.condition, condition);
	}

	/**
	 * Method to Enter Treatment
	 */
	public void enterTreatement(String treatement) {
		clearAndType(this.treatement, treatement);
	}

	/**
	 * Method to Get Bruise Text
	 * 
	 * @return text
	 */
	public String getBruiseText() {
		String text = bruiseText.getText();
		return text;
	}

	/**
	 * Method to GetThyrotoxicosisText
	 * 
	 * @return text
	 */
	public String getThyrotoxicosisText() {
		String text = thyrotoxicosisText.getText();
		return text;
	}

	/**
	 * Method to getMethotrexateText
	 * 
	 * @return text
	 */
	public String getMethotrexateText() {
		String text = methotrexateText.getText();
		return text;
	}

	/**
	 * Method to Select Date Drop Down
	 */
	public void selectDateDropDown(String date) {
		findVisibleElement(By.xpath("(//select[contains(class,day)])[1]"), 30);
		Select select = new Select(dateDropDown);
		select.selectByValue(date);
	}

	/**
	 * Method to Select Month Drop Down
	 */
	public void selectMonthDropDown(String month) {
		findVisibleElement(By.xpath("(//select[contains(class,month)])[2]"), 30);
		Select select = new Select(monthDropDown);
		select.selectByValue(month);
	}

	/**
	 * Method to Slect Year Drop down
	 */
	public void selectYearDropDown(String year) {
		findVisibleElement(By.xpath("(//select[contains(class,year)])[3]"), 30);
		Select select = new Select(yearDropDown);
		select.selectByVisibleText(year);
	}

	/**
	 * Method to Select Country Drop Down
	 */
	public void selectCountryDropDown() {
		Select select = new Select(countryDropDown);
		select.selectByVisibleText("India");
	}

	/**
	 * Method to getProfilePageText
	 * 
	 * @return
	 */
	public String getProfilePageText() {
		findVisibleElement(By.xpath("//span[text()='Hi! I’m aarellivenu']"), 30);
		String text = profilePageText.getText();
		return text;
	}

	/**
	 * Methdo to Set Gender
	 */
	public void setGender() {
		findVisibleElement(By.xpath("//span[text()='Male']"), 30);
		male.click();
	}

	/**
	 * Method to Set Postal Code
	 */
	public void setPostalCode() {
		postalcode.sendKeys("500089");
	}

	/**
	 * Method to Click On EditProfile Button.
	 */
	public void clickOnEditProfile() {
		editProfile.click();
	}

	/**
	 * Method to clear BIO
	 */
	public void clearBIO() {
		clickOnEditProfile();
		findVisibleElement(By.name("limitedTextArea"), 30);
		fillYourBio.clear();
		clickOnSaveChangesButton();
	}

}
