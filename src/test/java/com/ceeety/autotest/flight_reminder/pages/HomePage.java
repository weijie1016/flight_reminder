package com.ceeety.autotest.flight_reminder.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage{
	
	@AndroidFindBy(xpath="//android.widget.TabWidget/android.widget.LinearLayout[3]")
	private MobileElement baiduTab;
	@AndroidFindBy(xpath="//android.widget.TabWidget/android.widget.LinearLayout[4]")
	private MobileElement personTab;
	
	public HomePage(AppiumDriver driver) {
		super(driver);
	}
	public BaiduPage clickBaiduTab(){
		baiduTab.click();
		return new BaiduPage(driver);
	}

}
