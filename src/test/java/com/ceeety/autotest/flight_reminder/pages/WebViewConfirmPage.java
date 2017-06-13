package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ceeety.autotest.flight_reminder.utils.Log;

import io.appium.java_client.AppiumDriver;

public class WebViewConfirmPage extends BasePage {

	@FindBy(xpath="//div[contains(@class,\"main-ct2\")]")
	private WebElement confirmInfoElement;
	public WebViewConfirmPage(AppiumDriver driver) {
		super(driver,"webview");
	}
	public void getConfirmInfo(){
		Log.getLogger().info(confirmInfoElement.getAttribute("textContent").toString());

	}
}
