package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;

import com.ceeety.autotest.flight_reminder.utils.Common;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ScanQRCodePage extends BasePage{
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='更多']")
	private MobileElement more;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='从相册选取二维码']")
	private MobileElement toAlbum;
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desc,'2017-06-08 15:49')]")
	private MobileElement qRCodePic;
	
	public ScanQRCodePage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public FlightReminderHomePage scanQRCode(){

		Common.WaitForElementIsDisplayed(driver, more);
		more.click();
		Common.WaitForElementIsDisplayed(driver, toAlbum);
		toAlbum.click();
		Common.WaitForElementIsDisplayed(driver, qRCodePic);
		qRCodePic.click();
		

		return new FlightReminderHomePage(driver);
	}
	
}
