package com.ceeety.autotest.flight_reminder.testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	protected AppiumDriver<WebElement> driver;

	@BeforeTest
	public void beforeTest() throws MalformedURLException{
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "app");
		File app = new File(appDir, "weixin658android1060.apk");
		System.out.println("---------------------------");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("app",app.getAbsolutePath());
		capabilities.setCapability("noReset", true);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "a7aa6477d03");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("noSign","true");
		capabilities.setCapability("unicodeKeyboard","True");
		capabilities.setCapability("resetKeyboard","True");
		capabilities.setCapability("appPackage", "com.tencent.mm");
		capabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
		capabilities.setCapability("recreateChromeDriverSessions", "True");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidProcess", "com.tencent.mm:tools");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		System.out.println(System.getenv("classpath"));
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
