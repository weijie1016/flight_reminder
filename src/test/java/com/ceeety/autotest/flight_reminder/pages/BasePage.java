package com.ceeety.autotest.flight_reminder.pages;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ceeety.autotest.flight_reminder.utils.Log;
import com.ceeety.autotest.flight_reminder.utils.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;

public class BasePage {
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='发现']")
	private WebElement discoverTab;
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='返回']")
	private WebElement returnBtn;
	protected AppiumDriver<WebElement> driver;

	public BasePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
	}

	public BasePage(AppiumDriver driver, String flag) {
		this(driver);
		
		if (flag.equalsIgnoreCase("webview")) {

			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
//				System.out.println(contextName);
				Log.getLogger().info(contextName);

				if (contextName.contains("WEBVIEW")) {
					driver.context(contextName);
					this.driver = driver;
					
				} else {
//					System.out.println("no WEBVIEW");
					Log.getLogger().info("no WEBVIEW");
				}
			}
			
		}
		
	}

	public DiscoverPage toDiscoverPage() {
		Wait.WaitForElementIsDisplayed(driver, discoverTab);
		discoverTab.click();
		return new DiscoverPage(driver);
	}
}