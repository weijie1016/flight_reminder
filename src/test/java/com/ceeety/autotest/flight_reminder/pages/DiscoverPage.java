package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;

import com.ceeety.autotest.flight_reminder.base.BasePage;
import com.ceeety.autotest.flight_reminder.utils.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DiscoverPage extends BasePage {
	@AndroidFindBy(xpath="//android.widget.TextView[@text='扫一扫']")
	private WebElement scanQRCode;

	public DiscoverPage(AppiumDriver driver) {
		super(driver);
	}
	public ScanQRCodePage toScanQRCodePage(){
		Wait.WaitForElementIsDisplayed(driver, scanQRCode);
		scanQRCode.click();
		return new ScanQRCodePage(driver);
	}
}
