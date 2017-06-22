package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ceeety.autotest.flight_reminder.base.BasePage;
import com.ceeety.autotest.flight_reminder.utils.Log;

import io.appium.java_client.AppiumDriver;
import static com.ceeety.autotest.flight_reminder.utils.Common.*;

public class WebViewConfirmPage extends BasePage {

	@FindBy(xpath="//div[contains(@class,\"main-ct2\")]")
	private WebElement confirmInfoElement;
	@FindBy(id="nextPage_confirm")
	private WebElement subscribeLnk;
	public WebViewConfirmPage(AppiumDriver driver) {
		super(driver,"webview");
	}
	public void getConfirmInfo(){
		Log.getLogger().info(replaceBlank(confirmInfoElement.getAttribute("textContent")));
	}
	
	public WebViewSuccessPage confirmAndNext(){
		subscribeLnk.click();
		return new WebViewSuccessPage(driver);
	}
	
}