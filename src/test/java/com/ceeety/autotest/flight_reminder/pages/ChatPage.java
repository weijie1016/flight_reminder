package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;

import com.ceeety.autotest.flight_reminder.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static com.ceeety.autotest.flight_reminder.utils.Wait.*;

public class ChatPage extends BasePage {
	@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[156,1290][606,1740]']")
	private WebElement qRCodePic;
	@AndroidFindBy(xpath="//com.tencent.mm.ui.mogic.WxViewPager")
	private WebElement qRCodePicDetails;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='识别图中二维码']")
	private WebElement identityQRCode;
	public ChatPage(AppiumDriver driver) {
		super(driver);
	}
	
	public WebViewFlightNoPage toFlightPage(){
		WaitForElementIsDisplayed(driver, qRCodePic);
		qRCodePic.click();
		WaitForElementIsDisplayed(driver, qRCodePicDetails);
		driver.tap(1, qRCodePicDetails, 3000);
		WaitForElementIsDisplayed(driver, identityQRCode);
		identityQRCode.click();
		return new WebViewFlightNoPage(driver);
	} 
}
