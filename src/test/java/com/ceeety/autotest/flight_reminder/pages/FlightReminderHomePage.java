package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ceeety.autotest.flight_reminder.utils.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FlightReminderHomePage extends BasePage{
	@FindBy(id="flight")
	private WebElement flightNo;
//	private WebElement subscribe;
	
	public FlightReminderHomePage(AppiumDriver driver) {
		super(driver,"webview");
	}
	public void typeFlightNo(){
		Common.WaitForElementIsDisplayed(driver, flightNo);
		flightNo.sendKeys("2222");
	}
}