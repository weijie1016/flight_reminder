package com.ceeety.autotest.flight_reminder.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.ceeety.autotest.flight_reminder.base.BaseTest;
import com.ceeety.autotest.flight_reminder.testcases.NewTest;
import com.ceeety.autotest.flight_reminder.utils.Log;

import io.appium.java_client.AppiumDriver;

public class TestNGListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
		Log.getLogger().info(tr.getName() + "Failure");
		try {
			takeScreenShot(tr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
	
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSkipped(tr);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		super.onTestStart(result);
	}

	private void takeScreenShot(ITestResult tr) throws IOException {
		Reporter.setCurrentTestResult(tr);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		File file = new File(System.getProperty("user.dir") + "\\screenshots\\");
		String fileName = mDateTime + "_" + tr.getName() + ".png";
		String filePath = file.getAbsolutePath() + "\\" + fileName;
		File screenShot = NewTest.getDriver().getScreenshotAs(OutputType.FILE);
		if (file.exists()) {
			FileUtils.cleanDirectory(file);
		}
		FileUtils.copyFile(screenShot, new File(filePath));
		

//		Reporter.log("<a href=" + filePath + ">click to open screenshot</a>");
		Reporter.log("<img src=\""+filePath+"\" width=\"300px\" />");
	}
}