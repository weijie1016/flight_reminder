package com.ceeety.autotest.flight_reminder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ceeety.autotest.flight_reminder.base.BasePage;

import io.appium.java_client.AppiumDriver;

import static com.ceeety.autotest.flight_reminder.utils.Wait.*;

public class WebViewFlightNoPage extends BasePage {
	@FindBy(id="flight")
	private WebElement flightNo;
	@FindBy(id="nextPage_flight")
	private WebElement subscribeLnk;
	public WebViewFlightNoPage(AppiumDriver driver) {
		super(driver,"webview");
	}
	//输入航班号点击订阅
	public WebViewPhoneNoPage typeFlightNoAndNext() {
////		WaitForElementIsDisplayed(driver,flightNo);
//		flightNo.sendKeys("5212");
////		flightNo.submit();
//		subscribeLnk.click();
//		subscribeLnk.click();
		driver.findElement(By.id("flight")).sendKeys("5215");
		driver.findElement(By.id("nextPage_flight")).click();
		driver.findElement(By.id("nextPage_flight")).click();
		return new WebViewPhoneNoPage(driver);
	}
}