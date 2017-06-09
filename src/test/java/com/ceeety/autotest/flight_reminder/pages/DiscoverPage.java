package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DiscoverPage extends BasePage {
	@AndroidFindBy(xpath="//android.widget.TextView[@text='扫一扫']")
	private MobileElement scanQRCode;

	public DiscoverPage(AppiumDriver<WebElement> driver) {
		super(driver);
	}
	public ScanQRCodePage toScanQRCodePage() throws InterruptedException{

		scanQRCode.click();
		return new ScanQRCodePage(driver);
	}
}
