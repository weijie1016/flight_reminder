package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BaiduPage extends BasePage{
	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement keyword;
	@AndroidFindBy(className="android.widget.Button")
	private WebElement searchBtn;
	public BaiduPage(AppiumDriver driver) {
		super(driver,"webview");
	}
	public void typeKeyword(){
		keyword.sendKeys("appium");
	}
	public void clickSearchBtn(){
		searchBtn.click();
	}
	public BaiduPage doSearch(){
		typeKeyword();
		clickSearchBtn();
		return this;
	}
}