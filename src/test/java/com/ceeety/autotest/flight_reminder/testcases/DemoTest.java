package com.ceeety.autotest.flight_reminder.testcases;

import org.testng.annotations.Test;

import com.ceeety.autotest.flight_reminder.utils.Log;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class DemoTest {
	WebDriver driver;

	@Test
	public void f() {
		  driver.get("https://testerhome.com/topics/6954");
		  Log.getLogger().info(driver.getPageSource());
	}

	@BeforeTest
  public void beforeTest() throws MalformedURLException {
	 
	  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("androidPackage", "com.tencent.mm");
		  options.setExperimentalOption("androidUseRunningApp", true);
		  options.setExperimentalOption("androidActivity", ".plugin.webview.ui.tools.WebViewUI");
		  options.setExperimentalOption("androidProcess", "com.tencent.mm:tools");
		  DesiredCapabilities capability = DesiredCapabilities.chrome();
		  capability.setCapability("deviceName", "1976974f");
		  capability.setCapability("platformVersion", "6.0");
		  capability.setCapability("version", "6.0");
		  capability.setCapability("platformName", "Android");
		  capability.setCapability("platform", "Android");
		  capability.setCapability(ChromeOptions.CAPABILITY, options);
		  
          String url = "http://127.0.0.1:8000/wd/hub";
		  driver = new AndroidDriver<WebElement>(new URL(url), capability);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}


	@AfterTest
	public void afterTest() {
		  driver.quit();
	}

}
