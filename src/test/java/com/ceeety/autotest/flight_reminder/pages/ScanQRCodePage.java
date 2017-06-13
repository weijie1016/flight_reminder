package com.ceeety.autotest.flight_reminder.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.ceeety.autotest.flight_reminder.utils.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

public class ScanQRCodePage extends BasePage {
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='更多']")
	private WebElement more;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='从相册选取二维码']")
	private WebElement toAlbum;
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'2017-06-12 12:04')]")
	// @AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desc,'2017-06-08
	// 15:49')]")
	private WebElement qRCodePic;

	public ScanQRCodePage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebViewFlightNoPage scanQRCode() {
		Wait.WaitForElementIsDisplayed(driver, more);
		more.click();
		Wait.WaitForElementIsDisplayed(driver, toAlbum);
		toAlbum.click();
		Wait.WaitForElementIsDisplayed(driver, qRCodePic);
		qRCodePic.click();


		return new WebViewFlightNoPage(driver);
	}

}
