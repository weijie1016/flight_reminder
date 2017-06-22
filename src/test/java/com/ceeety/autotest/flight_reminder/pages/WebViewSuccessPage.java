package com.ceeety.autotest.flight_reminder.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ceeety.autotest.flight_reminder.base.BasePage;
import com.ceeety.autotest.flight_reminder.utils.Log;

import io.appium.java_client.AppiumDriver;

public class WebViewSuccessPage extends BasePage {
	
	@FindBy(xpath="//div[contains(@class,\"main-ct3\")]")
	private WebElement successPageServiceElement;
	public WebViewSuccessPage(AppiumDriver driver) {
		super(driver);
	}
	public void getServicesInfo(){
		Log.getLogger().info(replaceBlank(successPageServiceElement.getAttribute("textContent")));
		
	}
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
}
