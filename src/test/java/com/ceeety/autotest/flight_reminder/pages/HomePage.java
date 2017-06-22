package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;

import com.ceeety.autotest.flight_reminder.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static com.ceeety.autotest.flight_reminder.utils.Wait.*;

public class HomePage extends BasePage{
	@AndroidFindBy(xpath="//android.view.View[@text='test']")
	private WebElement chat;

	public HomePage(AppiumDriver driver) {
		super(driver);
	}
	public ChatPage toChatPage(){
		WaitForElementIsDisplayed(driver, chat);
		chat.click();
		return new ChatPage(driver);
	}
	
	
}
