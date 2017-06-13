package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class WebViewPhoneNoPage extends BasePage{
	@FindBy(id="mobile1")
	private WebElement phoneNo;
	@FindBy(id="nextPage_phone")
	private WebElement subscribeLnk;
	public WebViewPhoneNoPage(AppiumDriver driver) {
		super(driver,"webview");
	}
	public WebViewConfirmPage typePhoneNoAndNext(){
		 phoneNo.sendKeys("13811112222");
		 subscribeLnk.click();
		 return new WebViewConfirmPage(driver);
	}
}
