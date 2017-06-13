package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {
	@AndroidFindBy(id="com.tencent.mm:id/bg9")
	private WebElement moreButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='切换帐号']")
	private WebElement switchAccount;
	@AndroidFindBy(id="com.tencent.mm:id/bgd")
	private WebElement toLoginButton;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='帐   号']/following-sibling::*")
	private WebElement account;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='密   码']/following-sibling::*")
	private WebElement password;
	@AndroidFindBy(id="com.tencent.mm:id/bfo")
	private WebElement loginButton;
	

	public LoginPage(AppiumDriver driver) {
		super(driver);
//		PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
	}

	public LoginPage clickMoreBtn(){
		moreButton.click();
		return this;
	}
	public LoginPage clickSwitchAccount(){
		switchAccount.click();
		return this;
	}
	public LoginPage clickToLoginButton(){
		toLoginButton.click();
		return this;
	}
	public void typeAccount(){
		account.sendKeys("183102924");
	}
	public void typePassword(){
		password.sendKeys("weiaolun@123.com");
	}
	public void clickLoginButton(){
		loginButton.click();
	}

}