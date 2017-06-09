package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FlightReminderHomePage extends BasePage{
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement flightNo;
//	private WebElement subscribe;
	
	public FlightReminderHomePage(AppiumDriver driver) {
		super(driver,"webview");
	}
	public void typeFlightNo(){
//		driver.context("WEBVIEW_com.tencent.mm:appbrand0");
		flightNo.sendKeys("2222");
	}
}