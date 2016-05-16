package com.hu.webdriver.pages.messages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;
/**
 * This Class contains all MessagesPage features.
 * @author Venu
 *
 */
public class MessagesPage extends BasePage{

	/**
	 * WebElemnt for Compose Button.
	 */
	@FindBy(linkText = "Compose")
	WebElement composeButton;
	/**
	 * WebElement for AddRecipients.
	 */
	@FindBy(xpath  = "//input[@placeholder='Add recipients']")
	WebElement addRecipients;
	/**
	 * WebElement for recipientsnames.
	 */
	@FindBy(xpath = "//div[@class='recipient-name']")
	List<WebElement> recipientsNames;
	/**
	 * WebElement for SelectMessage.
	 */
	@FindBy (xpath = "(//input[@type='checkbox'])[1]")
	WebElement selectMessage;
	/**
	 * WebElement for delete.
	 */
	@FindBy (id = "messages-delete-button")
	WebElement delete;
	/**
	 * WebElement for welcomeToHealthy.
	 */
	@FindBy(xpath = "((//li[@class='media'])[1]/div/following-sibling::div)[2]/h4//span")
	WebElement welcomeToHealthy;
	/**
	 * WebElement for undo.
	 */
	@FindBy (xpath = "//a[text()='Undo?']")
	WebElement undo;
	/**
	 * WebElement for Select All Messages in Inbox.
	 */
	@FindBy (id = "messages-selectall-button")
	WebElement selectAll;
	/**
	 * WebElement for no messages text.
	 */
	@FindBy(xpath = "//div[contains(text(),'no messages')]")
	WebElement noMessagesText;
	/**
	 * WebElement for tessa36.
	 */
	@FindBy (xpath = "//div[text()='tessa36']")
	WebElement tessa36;
	/**
	 * WebElement for subject.
	 */
	@FindBy (id = "compose-subject-input")
	WebElement enterSubject;
	/**
	 * WebElement for Enter Message.
	 */
	@FindBy (id = "compose-body-input")
	WebElement enterMessage;
	/**
	 * Webelement for SendMessage Button.
	 */
	@FindBy (xpath ="//input[@type='submit']")
	WebElement sendMessageButton;
	/**
	 * WebElement for Sent Text;
	 */
	@FindBy(xpath = "")
	WebElement sentText;
	/**
	 * WebElement for SubjectRequired Text.
	 */
	@FindBy(xpath = "//*[contains(text(),'Subject')]")
	WebElement subjectRequiredText;
	/**
	 * WebElement for Body is Required Text.
	 */
	@FindBy (xpath = "//*[contains(text(),'Body')]")
	WebElement bodyIsRequired;
	/**
	 * Constructor to Initialize the Messages Page.
	 * @param driver
	 */
	public MessagesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	/**
	 * Method to click on Compose Button.
	 */
	public void clickOnComposeButton(){
		findVisibleElement(By.linkText("Compose"), MAXIMUM);
		composeButton.click();
	}
	/**
	 * Method to Enter AddRecipients.
	 */
	public void clickOnAddRecipients(String addRecipients){
		findVisibleElement(By.xpath("//input[@placeholder='Add recipients']"), MAXIMUM);
		this.addRecipients.sendKeys(addRecipients);
		//clearAndType(this.addRecipients, addRecipients);
	}
	/**
	 * Method to get RecipientsNames.
	 */
	public List<String> getRecipientsNames(){
		List<String> recipientsNameList = getListOfStrings(recipientsNames);
		return recipientsNameList;
	}
	/**
	 * Method to Select Messsage.
	 */
	public void selectMessage(){
		findVisibleElement(By.xpath("(//input[@type='checkbox'])[1]"), MAXIMUM);
		selectMessage.click();
	}
	/**
	 * Method to Deletemessage.
	 */
	public void clickOnDeleteButton(){ 
		findVisibleElement(By.id("messages-delete-button"), MAXIMUM);
		delete.click();
	}
	/**
	 * Method to get No messages Text.
	 * @return  text.
	 * 
	 */
	public String getFirstInboxMessageText(){
		String text = welcomeToHealthy.getText();
		return text;
	}
	/**
	 * Method to Check First Inbox Message is visible or not.
	 * @param deletedMessage
	 * @return isDisplayed.
	 */
	public boolean isFirstInboxMessageTextVisible(String deletedMessage) {
		for (int i = 1; i <= 5; i++) {
			String xpath = "((//li[@class='media'])[" + i
					+ "]/div/following-sibling::div)[2]/h4//" + "span[text()='"
					+ deletedMessage + "']";
			if (isDisplayed(By.xpath(xpath))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to click on Undo
	 */
	public void clickOnUndo(){
		findVisibleElement(By.xpath("//a[text()='Undo?']"), MINIMUM);
		undo.click();
	}
	/**
	 * Method to click On SelectAll.
	 */
	
	public void clickOnSelectAll(){
		findVisibleElement(By.id("messages-selectall-button"), MAXIMUM);
		selectAll.click();
	}
	/**
	 * Method for get No Messages Text.
	 * @return text.
	 */
	public String getNoMessagesText(){
		findVisibleElement(By.xpath("//div[contains(text(),'no messages')]"), MAXIMUM);
		String text = noMessagesText.getText();
		return text;
	}
	/**
	 * Method for enter Subject.
	 * @param text
	 */
	public void enterSubject(String text){
		findVisibleElement(By.id("compose-subject-input"), MAXIMUM);
		clearAndType(enterSubject, text);
	}
	/**
	 * Method for enter Message.
	 * @param text
	 */
	public void enterMessage(String text){
		findVisibleElement(By.id("compose-body-input"), MAXIMUM);
		clearAndType(enterMessage, text);
	}
	/**
	 * Method for Click SendMessage Button.
	 */
	public void clickOnSendMessageButton(){
		findVisibleElement(By.xpath("//input[@type='submit']"), MAXIMUM);
		sendMessageButton.click();
	}
	/**
	 * Metho dto get Compose Text.
	 * @return text. 
	 * 
	 */
	public String getComposeText(){
		findVisibleElement(By.linkText("Compose"), MAXIMUM);
		String text = composeButton.getText();
		return text;
	}
	/**
	 * Method to get Sent Text
	 * @return text.
	 */
	public String getSentText(){
		findVisibleElement(By.xpath(""), MAXIMUM);
		String text = sentText.getText();
		return text;
	}
	/**
	 * Method to get SubjectRequired text.
	 * @return
	 */
	public String getSubjectRequiredText(){
		findVisibleElement(By.xpath("//*[contains(text(),'Subject')]"), MAXIMUM);
		String text = subjectRequiredText.getText();
		return text;
	}
	/**
	 * Method to get Body required Text.
	 * @return
	 */
	public String getBodyIsRequiredText(){
		findVisibleElement(By.xpath("//*[contains(text(),'Body')]"), MAXIMUM);
		String text = bodyIsRequired.getText();
		return text;
	}
	
	
}

