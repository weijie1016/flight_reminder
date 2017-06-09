package com.ceeety.autotest.flight_reminder.testcases;



import org.testng.annotations.Test;

import com.ceeety.autotest.flight_reminder.pages.FlightReminderHomePage;

public class LoginTest extends BaseTest {
	@Test
	public void testLogin() throws InterruptedException {
		
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.doLogin().clickBaiduTab().doSearch();
//		loginPage
			//点“更多”
			//.clickMoreBtn()
			//点击“切换帐号”
			//.clickSwitchAccount()
			//点击“使用其它方式登录”
			//.clickToLoginButton()
			//输入“帐号”为QQ号
			//.doLogin()
//			.toDiscoverPage()
//			.toScanQRCodePage()
//			.scanQRCode()
		FlightReminderHomePage flightReminderHomePage=new FlightReminderHomePage(driver);
		flightReminderHomePage.typeFlightNo();
	}
}
