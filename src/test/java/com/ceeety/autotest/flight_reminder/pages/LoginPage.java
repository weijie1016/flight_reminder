package com.ceeety.autotest.flight_reminder.pages;




import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {
	@AndroidFindBy(id="com.tencent.mm:id/bg9")
	private MobileElement moreButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='切换帐号']")
	private MobileElement switchAccount;
	@AndroidFindBy(id="com.tencent.mm:id/bgd")
	private MobileElement toLoginButton;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='帐   号']/following-sibling::*")
	private MobileElement account;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='密   码']/following-sibling::*")
	private MobileElement password;
	@AndroidFindBy(id="com.tencent.mm:id/bfo")
	private MobileElement loginButton;
	
	
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
	public HomePage doLogin(){
		typeAccount();
		typePassword();
		clickLoginButton();
		return new HomePage(driver);
	}
}