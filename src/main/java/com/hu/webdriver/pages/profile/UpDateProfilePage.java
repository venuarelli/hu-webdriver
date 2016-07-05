package com.hu.webdriver.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hu.webdriver.pages.BasePage;
/**
 * This class contains all the UpDateProfilePage fatures
 *  
 * @author Venu
 *
 */
public class UpDateProfilePage extends BasePage {
	/**
	 * WebElement for BIO Text.
	 */
	@FindBy (xpath = "//div[@class='entity-centerText']/span")
	WebElement bioText ;
	/**
	 * WebElement for Bruise Text.
	 */
	@FindBy (xpath = "//a[text()='Bruise']")
	WebElement bruiseText;
	/**
	 * WebElement for Methotrexate Text.
	 */
	@FindBy (xpath = "//a[text()='Methotrexate']" )
	WebElement methotrexateText;
	/**
	 * WebElement for Thyrotoxicosis Text.
	 */
	@FindBy (xpath = "//a[text()='Thyrotoxicosis']")
	WebElement thyrotoxicosisText;
	/**
	 * WebElement for ProfilePageText
	 */
	@FindBy (xpath ="//span[text()='Hi! world']")
	WebElement profilePageText;
	/**
	 * WebElement for Gender Text
	 */
	@FindBy (xpath = "//td[text()='M']")
	WebElement genderText;
	/**
	 * WebElement for UploadButton.
	 */
	@FindBy (xpath = "//span[text()='Upload']")
	WebElement uploadButton;
	/**
	 * ConStructor to Initialize UpDateProfilePage.
	 * @param driver
	 */
	public UpDateProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	/**
	 * Method to Get BIOText
	 */
	public String getBIOText(){
		findVisibleElement(By.xpath("//div[@class='entity-centerText']/span"), 30);
		String text = bioText.getText();
		return text;
	}
	
	/**
	 * Method to get Bruise Text.
	 * @return text
	 */
	public String getBruiseText(){
		findVisibleElement(bruiseText, FIVE);
		String text = bruiseText.getText();
		return text;
	}
	/**
	 * Method to  GetThyrotoxicosis Text. 
	 * @return text
	 */
	public String getThyrotoxicosisText(){
		String text  = thyrotoxicosisText.getText();
		return text;
	}
	/**
	 * Method to getMethotrexate Text.
	 * @return text
	 */
	public String getMethotrexateText(){
		findVisibleElement(methotrexateText, MAXIMUM);
		String text = methotrexateText.getText();
		return text;
	}
	/**
	 * Method to getProfilePageText
	 * @return
	 */
	public String getProfilePageText(){
		String  text = profilePageText.getText();
		return text;
	}
	/**
	 * Method to Get Gender Text
	 * @return text
	 */
	public String getGenderText(){
		findVisibleElement(By.xpath("//td[text()='M']"), 30);
		String text = genderText.getText();
		return text;
	}
	/**
	 * Method to click on Uploadbutton.
	 */
	public void clickOnUploadButton(){
		uploadButton.click();
	}
}
