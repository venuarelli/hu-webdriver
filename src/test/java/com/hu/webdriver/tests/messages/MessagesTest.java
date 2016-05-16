package com.hu.webdriver.tests.messages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hu.webdriver.pages.NewsFeedPage;
import com.hu.webdriver.pages.messages.MessagesPage;
import com.hu.webdriver.pages.messages.PublicUserProfilePage;
import com.hu.webdriver.tests.BaseLoginWebDriverTest;
/**
 * This Class contains all MessagesTest features.
 * @author Venu.
 *
 */
public class MessagesTest  extends BaseLoginWebDriverTest{
	//Instance variable for MessagesPage.
	MessagesPage messagesPage;
	PublicUserProfilePage publicUserProfilePage;
	NewsFeedPage newsFeedPage;
	/**
	 * Before Class for Login and Navigate to Messages page.
	 */
	@BeforeClass
	public void beforeMethodNavigateToMessagesPage(){
		messagesPage = loginHuAndNavigateToMessagesPage();
	}
	/**
	 * Test Case to verify Add recipients.
	 */
	@Test(description ="Test Case to verify Add recipients.")
	public void addRecipients(){
		messagesPage.clickOnComposeButton();
		String addRecipients1 = propertyUtil.getProperty("messages.addrecipients1");
		String addRecipients2 = propertyUtil.getProperty("messages.addrecipients2");
		messagesPage.clickOnAddRecipients(addRecipients1);
		messagesPage.waitForSeconds(10);
		messagesPage.clickOnAddRecipients(""+Keys.ENTER);
		messagesPage.clickOnAddRecipients(addRecipients2);
		messagesPage.waitForSeconds(20);
		messagesPage.clickOnAddRecipients(""+Keys.ENTER);
		
		List<String> recipientsNames = messagesPage.getRecipientsNames();
		
		Assert.assertTrue(recipientsNames.contains(addRecipients1), "Recipients1 name not matched with expected");
		Assert.assertTrue(recipientsNames.contains(addRecipients2), "Recipients2 name not matched with expected");
	}
	/**
	 * Test Case to verify Delete message.
	 */
	@Test(description = "Test Case to verify Delete message.")
	public void testDeleteMessage(){
		//Select a message.
		messagesPage.selectMessage();
		//Get First Message From Inbox.
		String firstMessage = messagesPage.getFirstInboxMessageText();
		//Click On Delete.
		messagesPage.clickOnDeleteButton();
		// Check whether Welcome to healthy is deleted or not.
		boolean isDisplayed = messagesPage.isFirstInboxMessageTextVisible(firstMessage);
		//Verify 'Welcome to Healthy' message deleted from inbox.
		Assert.assertFalse(isDisplayed,"Welcome to healthy message is not deleted from inbox");
	}
	/**
	 * Test Case to verify undo a message in Inbox.
	 */
	@Test(description = "Test Case to verify undo a message in Inbox.")
	public void testUndoMessage(){
		//Click on Select Message from Inbox.
		messagesPage.selectMessage();
		//Get First Message from Inbox.
		String message = messagesPage.getFirstInboxMessageText();
		//Click On delete.
		messagesPage.clickOnDeleteButton();
		//Click on Undo.
		messagesPage.clickOnUndo();
		//Check whether Welcome to healthy message is present or not.
		boolean isDisplayed = messagesPage.isFirstInboxMessageTextVisible(message);
		//Verify welcome to healthy Undo to Onbox.
		Assert.assertTrue(isDisplayed,"Welcome to healthy message is present in inbox");
	}
	/**
	 * Test case to verify Delete Multiple Messages in Inbox.
	 */
	@Test(description = "Test Case to verify Delete multiple messages in Inbox.")
	public void testDeleteMultipleMessages(){
		//Click on Select ALL Button.
		messagesPage.clickOnSelectAll();
		//Click on Delete button.
		messagesPage.clickOnDeleteButton();
		//Get Actual and Expected Text.
		String actualText =  messagesPage.getNoMessagesText();
		String expectedText = propertyUtil.getProperty("messages.noMessages");
		//Verify No Messages Text is Present or not on Inbox.
		Assert.assertEquals(actualText, expectedText,"No Messages Text is not matched with expected.");
	}
	/**
	 * Test Case to verify ADD Recipient.
	 */
	@Test(description = "Test Case to verify ADD Recipient.")
	public void testAddRecipient(){
		//Click On Compose Button.
		messagesPage.clickOnComposeButton();
		//Get  RecipientName from Property File.
		String addRecipient = propertyUtil.getProperty("messages.addrecipients1");
		//Enter Add Recipients
		messagesPage.clickOnAddRecipients(addRecipient);
		//Wait for Five Seconds.
		messagesPage.waitForSeconds(FIVE);
		//Click On button.
		messagesPage.clickOnAddRecipients(""+Keys.ENTER);
		//Get RecipientNames.
		List<String> recipientNames = messagesPage.getRecipientsNames();
		//Verify Search Recipient is matched with Expected or not.
		Assert.assertTrue(recipientNames.toString().contains(addRecipient),"recipientName  not matched with expected.");
	}
	/**
	 * Test Case to verify Compose A Message.
	 */
	@Test(description = "Test Case to verify Compose A Message.")
	public void testComposeMessage(){
		messagesPage.clickOnComposeButton();
		String addRecipients = propertyUtil.getProperty("messages.addrecipients1");
		messagesPage.clickOnAddRecipients(addRecipients);
		messagesPage.waitForSeconds(FIVE);
		messagesPage.clickOnAddRecipients(""+Keys.ENTER);
		String subject = propertyUtil.getProperty("messages.subject");
		messagesPage.enterSubject(subject);
		String message = propertyUtil.getProperty("messages.message");
		messagesPage.enterMessage(message);
		messagesPage.clickOnSendMessageButton();
		String actualText = messagesPage.getComposeText();
		String expectedText = propertyUtil.getProperty("messages.compose");
		Assert.assertEquals(actualText, expectedText,"Compose text is not matched with expected.");
	}
	/**
	 * Test Case to verify EmptySubject.
	 */
	@Test(description = "Test Case to verify EmptySubject.")
	public void testEmptySubject(){
		messagesPage.clickOnComposeButton();
		String addRecipients = propertyUtil.getProperty("messages.addrecipients1");
		messagesPage.clickOnAddRecipients(addRecipients);
		messagesPage.waitForSeconds(FIVE);
		messagesPage.clickOnAddRecipients(""+Keys.ENTER);
		String message = propertyUtil.getProperty("messages.message");
		messagesPage.enterMessage(message);
		messagesPage.clickOnSendMessageButton();
		String actualText = messagesPage.getSubjectRequiredText();
		String expectedText = propertyUtil.getProperty("messages.subjectrequired");
		Assert.assertEquals(actualText, expectedText,"SubjectRequired Text is not matched with Expected.");
	}
	/**
	 * Test Case to verify Empty Message.
	 */
	@Test(description = "Test Case to verify Empty Message.")
	public void testEmptyMessage(){
		messagesPage.clickOnComposeButton();
		String addRecipients = propertyUtil.getProperty("messages.addrecipients1");
		messagesPage.clickOnAddRecipients(addRecipients);
		messagesPage.waitForSeconds(FIVE);
		messagesPage.clickOnAddRecipients(""+Keys.ENTER);
		String subject = propertyUtil.getProperty("messages.subject");
		messagesPage.enterSubject(subject);
		messagesPage.clickOnSendMessageButton();
		String actualText = messagesPage.getBodyIsRequiredText();
		String expectedText = propertyUtil.getProperty("messagess.bodyisrequired");
		Assert.assertEquals(actualText, expectedText,"Body Is Required Text Is not matched with Expected.");
	}/*
	*//**
	 * Test Case to verify Clicking several times on ‘Send message’.
	 *//*
	@Test(description = "Test Case to verify Clicking several times on ‘Send message’.")
	public void testSeveralTimesClickSendMessageButton(){
		messagesPage.clickOnComposeButton();
		String addRecipients = propertyUtil.getProperty("messages.addrecipients1");
		messagesPage.clickOnAddRecipients(addRecipients);
		messagesPage.waitForSeconds(FIVE);
		messagesPage.clickOnAddRecipients(""+Keys.ENTER);
		String subject = propertyUtil.getProperty("messages.subject");
		messagesPage.enterSubject(subject);
		String message = propertyUtil.getProperty("messages.message");
		messagesPage.enterMessage(message);
		messagesPage.clickOnSendMessageButton();
		messagesPage.clickOnSendMessageButton();
		messagesPage.clickOnSendMessageButton();
		messagesPage.clickOnSendMessageButton();
		String actualText = messagesPage.getComposeText();
		String expectedText = propertyUtil.getProperty("messages.compose");
		Assert.assertEquals(actualText, expectedText,"Compose text is not matched with expected.");	
	}*/
	
	/**
	 * Test Case to verify Send message from user profile.
	 */
	@Test(description = "Test Case to verify Send message from user profile.")
	public void testSendMessageFromUserProfile(){
		newsFeedPage.clickOnPublicUser();
		String addRecipient = publicUserProfilePage.getPublicUserProfileName();
		publicUserProfilePage.clickOnMessageBUtton();
		List<String>recipientNames = messagesPage.getRecipientsNames();
		Assert.assertTrue(recipientNames.toString().contains(addRecipient),"recipientName  not matched with expected.");
	}
}
