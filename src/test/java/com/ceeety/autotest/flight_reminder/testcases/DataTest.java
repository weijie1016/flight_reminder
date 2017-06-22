package com.ceeety.autotest.flight_reminder.testcases;

import org.testng.annotations.Test;

import com.ceeety.autotest.flight_reminder.utils.InitData;

import org.testng.annotations.BeforeTest;

import java.sql.SQLException;

import org.testng.annotations.AfterTest;

public class DataTest {
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() throws ClassNotFoundException, SQLException {
	  InitData.initTestData();
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
