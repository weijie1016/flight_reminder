package com.ceeety.autotest.flight_reminder.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchShortcuts;


public class Wait {
	public static void WaitForElementIsDisplayed(MobileDriver driver,final WebElement e){
		new WebDriverWait(driver,30).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver arg0) {
				return e.isDisplayed();
			}
		});
//		int xAxisStartPoint=e.getLocation().getX();
//		Log.getLogger().info("x1:"+xAxisStartPoint);
//		int xAxisEndPoint=xAxisStartPoint+e.getSize().getWidth();
//		Log.getLogger().info("x2:"+xAxisEndPoint);
//		int yAxisStartPoint=e.getLocation().getY();
//		Log.getLogger().info("y1:"+yAxisStartPoint);
//		int yAxisEndPoint=yAxisStartPoint+e.getSize().getHeight();
//		Log.getLogger().info("y2:"+yAxisEndPoint);
//		driver.swipe((xAxisEndPoint-xAxisStartPoint)/2+xAxisStartPoint,
//				     (yAxisEndPoint-yAxisStartPoint)/2+yAxisStartPoint,
//				     (xAxisEndPoint-xAxisStartPoint)/2+xAxisStartPoint-1,
//				     (yAxisEndPoint-yAxisStartPoint)/2+yAxisStartPoint,
//				      1000);
		
		Assert.assertTrue(e.isDisplayed());
		
	}
}
