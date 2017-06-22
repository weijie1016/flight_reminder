package com.ceeety.autotest.flight_reminder.testcases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ceeety.autotest.flight_reminder.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class NewTest {
	private static AppiumDriverLocalService service;
	private static AppiumDriver<WebElement> driver;

	@Test
	public void f() {
		// driver.findElement(By.xpath("//android.view.View[@text='搜索或输入网址']")).sendKeys("http://www.baidu.com");
		// driver.findElement(By.xpath("//android.widget.TextView[@text='进入']")).click();
		//
		//
		// Set<String> contextHandles = driver.getContextHandles();
		// for (String context : contextHandles) {
		// Log.getLogger().info(context);
		// }
		Reporter.log("打开百度首页");
		driver.get("http://www.baidu.com");
		Reporter.log("输入关键字appium");
		driver.findElement(By.id("index-kw")).sendKeys("appium");
		Reporter.log("点击搜索按钮");
		driver.findElement(By.id("index-bn1")).click();
		Log.getLogger().info(driver.getTitle());
		Reporter.log("断言结果页title");
		Assert.assertEquals(driver.getTitle(), "百度一下");
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		// System.setProperty("NODE_HOME", "D:\\nodejs");
		// System.setProperty("APPIUM_HOME","C:\\Appium\\node_modules\\.bin");
		// service=AppiumDriverLocalService.buildService(
		// new AppiumServiceBuilder()
		// .usingDriverExecutable()
		// .withAppiumJS(new File("C:\\Appium\\node_modules\\.bin\\appium"))
		// .withIPAddress("127.0.0.1")
		// .usingPort(4723));
		service = AppiumDriverLocalService.buildDefaultService();

		service.start();
		Log.getLogger().info(service.isRunning());
		if (!service.isRunning()) {
			throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
		}

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("deviceName", "1976974f"); //
		capabilities.setCapability("deviceName", "a7aa6477d03"); //
		capabilities.setCapability("platformVersion", "6.0"); //
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("appPackage", "com.tencent.mtt");
		capabilities.setCapability("appActivity", "com.tencent.mtt.MainActivity");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		// driver = new AndroidDriver<WebElement>(new
		// URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = new AndroidDriver<WebElement>(service.getUrl(), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
		if (service != null) {
			service.stop();
		}
	}

	public static AppiumDriver getDriver() {

		return driver;
	}

//	@AfterMethod(alwaysRun = true)
//	public void afterMethod(ITestResult result) throws Exception {
//		if (!result.isSuccess()) {
//			catchExceptions(result);
//		}
//
//	}
//
//	public void catchExceptions(ITestResult result) {
//		System.out.println("result" + result);
//		String methodName = result.getName();
//		System.out.println(methodName);
//		if (!result.isSuccess()) {
//			File file = new File("");
//			Reporter.setCurrentTestResult(result);
//			System.out.println(file.getAbsolutePath());
//			Reporter.log(file.getAbsolutePath());
//			String filePath = file.getAbsolutePath();
//			filePath = filePath.replace("/opt/apache-tomcat-7.0.64/webapps", "http://172.18.44.114:8080");
//			Reporter.log("<img src='" + filePath + "/" + result.getName() + ".jpg' height='100' width='100'/>");
//			int width = 100;
//			int height = 100;
//			String s = "这是一张测试图片";
//			File screenShotFile = new File(file.getAbsolutePath() + "/" + result.getName() + ".jpg");
//
//			Font font = new Font("Serif", Font.BOLD, 10);
//			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//			Graphics2D g2 = (Graphics2D) bi.getGraphics();
//			g2.setBackground(Color.BLACK);
//			g2.clearRect(0, 0, width, height);
//			g2.setPaint(Color.RED);
//
//			FontRenderContext context = g2.getFontRenderContext();
//			Rectangle2D bounds = font.getStringBounds(s, context);
//			double x = (width - bounds.getWidth()) / 2;
//			double y = (height - bounds.getHeight()) / 2;
//			double ascent = -bounds.getY();
//			double baseY = y + ascent;
//
//			g2.drawString(s, (int) x, (int) baseY);
//
//			try {
//				ImageIO.write(bi, "jpg", screenShotFile);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
