package com.ceeety.autotest.flight_reminder.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class DemoTest {
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidPackage", "com.tencent.mm");
		options.setExperimentalOption("androidUseRunningApp", true);
		options.setExperimentalOption("androidActivity", ".plugin.webview.ui.tools.WebViewUI");
		options.setExperimentalOption("androidProcess", "com.tencent.mm:tools");
		

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(ChromeOptions.CAPABILITY, options);
		String url = "http://127.0.0.1:8000/wd/hub";
		driver = new AndroidDriver<WebElement>(new URL(url), capability);
	}
	@Test
	public void f(){
		driver.get("http://www.baidu.com");
		System.out.println(driver.getPageSource());
	}

	@AfterTest
	public void AfterTest() {
		driver.quit();
	}
}