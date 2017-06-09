package com.ceeety.autotest.flight_reminder.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	@AndroidFindBy(xpath="//android.widget.TextView[@text='发现']")
	private MobileElement DiscoverTab;
	
	protected  AppiumDriver<WebElement> driver;
	
	public BasePage(AppiumDriver<WebElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
	}
	
	public BasePage(AppiumDriver<WebElement> driver,String flag) {
		if(flag.equalsIgnoreCase("webview")){
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
				System.out.println(contextName);

				if (contextName.contains("WEBVIEW")) {
					driver.context(contextName);
				} else {
					System.out.println("no WEBVIEW");
				}
			}
			this.driver= driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);	
		}else{
			this.driver= driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);	
		}
	}
	
	public DiscoverPage toDiscoverPage(){
		DiscoverTab.click();
		return new DiscoverPage(driver);
	}
}