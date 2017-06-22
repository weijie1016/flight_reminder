package com.ceeety.autotest.flight_reminder.base;

import static com.ceeety.autotest.flight_reminder.utils.Common.sleepFor;
import static com.ceeety.autotest.flight_reminder.utils.Wait.WaitForElementIsDisplayed;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ceeety.autotest.flight_reminder.pages.DiscoverPage;
import com.ceeety.autotest.flight_reminder.pages.HomePage;
import com.ceeety.autotest.flight_reminder.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='发现']")
	private WebElement discoverTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='微信']")
	private WebElement homePageTab;
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='返回']")
	private WebElement returnBtn;
	@AndroidFindBy(xpath = "//com.tencent.smtt.webkit.WebView")
	private WebElement webKit;
	protected AppiumDriver<WebElement> driver;

	
    private final static String SCREEN_SHOT_PATH = "test-output/screen-shot";  
    private static String SCREEN_SHOT_NAME = null;  
	
	
	
	public BasePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
	}

	public BasePage(AppiumDriver driver, String flag) {
		long start = new Date().getTime();
		long end = new Date().getTime();
		long limit = 15; // waiting no more than 15 seconds to switch to a
							// WEBVIEW context
		boolean switched = false;
		int maxRetries = 5;
		do {
			sleepFor(1);
			Set<String> contextHandles = driver.getContextHandles();
			for (String context : contextHandles) {
				if (context.contains("WEBVIEW")) {
					// the context change needs some extra time
					int retries = 0;
					do {
						sleepFor(5);
						try {
							driver.context(context);
						} catch (Exception ex) {
							Log.getLogger().info("An error occurred switching the context. Trying again...");
						}
						retries++;
					} while (!driver.getContext().contains("WEBVIEW") && retries < maxRetries);
					switched = true;
				}
			}
			end = new Date().getTime();
		} while (!switched && (start + (limit * 1000)) > end);

		if (!switched) {
			Log.getLogger().info("After waiting for " + limit
					+ " seconds, the driver couldn't switched to the WEBVIEW context, so the test of the hybrid application will failed!");
		}
		this.driver = driver;
		driver.get("http://www.baidu.com");
	}

	public DiscoverPage toDiscoverPage() {
		WaitForElementIsDisplayed(driver, discoverTab);
		discoverTab.click();
		return new DiscoverPage(driver);
	}

	public HomePage toHomePage() {
		WaitForElementIsDisplayed(driver, homePageTab);
		homePageTab.click();
		return new HomePage(driver);
	}

}