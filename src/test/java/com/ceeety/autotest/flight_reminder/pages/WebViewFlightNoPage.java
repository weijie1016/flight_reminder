package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class WebViewFlightNoPage extends BasePage {
	@FindBy(id="flight")
	private WebElement flightNo;
	@FindBy(id="nextPage_flight")
	private WebElement subscribeLnk;
	public WebViewFlightNoPage(AppiumDriver driver) {
		super(driver,"webview");
		PageFactory.initElements(driver, this);
	}
	//输入航班号点击订阅
	public WebViewPhoneNoPage typeFlightNoAndNext() {
		flightNo.sendKeys("5212");
		subscribeLnk.click();
		return new WebViewPhoneNoPage(driver);
	}
}