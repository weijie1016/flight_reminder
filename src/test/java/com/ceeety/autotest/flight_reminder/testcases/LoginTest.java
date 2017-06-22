package com.ceeety.autotest.flight_reminder.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ceeety.autotest.flight_reminder.base.BaseTest;
import com.ceeety.autotest.flight_reminder.datadriver.CSVDataDriver;
import com.ceeety.autotest.flight_reminder.pages.LoginPage;

public class LoginTest extends BaseTest {

	// @Test(dataProvider="data")
	@Test
	public void testLogin() throws InterruptedException{

		LoginPage loginPage = new LoginPage(driver);
		//// loginPage.doLogin().clickBaiduTab().doSearch();
		loginPage
				// //点“更多”
				// //.clickMoreBtn()
				// //点击“切换帐号”
				// //.clickSwitchAccount()
				// //点击“使用其它方式登录”
				// //.clickToLoginButton()
				// //输入“帐号”为QQ号
				// //.doLogin()
//				.toDiscoverPage()
//				.toScanQRCodePage()
//				.scanQRCode()
				.toHomePage()
				.toChatPage()
				.toFlightPage()
				
		
		
				.typeFlightNoAndNext()
				.typePhoneNoAndNext()
				.confirmAndNext()
				.getServicesInfo();
				
				
		
		
		
		
		// System.out.print(data.get("字段1"));
		// System.out.print(data.get("字段2"));
		// System.out.print(data.get("字段3"));
		// System.out.println();
	}

//	@DataProvider(name = "data")
//	public Iterator<Object[]> Numbers() throws IOException {
//		return (Iterator<Object[]>) new CSVDataDriver(this.getClass().getName());
//	}

}
