package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;

public class LogInTest extends Base {
	LogInPage loginpage;
	
	@Test
	public void verify_LogIn() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		
		Assert.assertTrue(loginpage.is_ProfileImageDisplayed());
	}

	@Test

	public void verify_InvalidLogInAlertMessage() {
		loginpage = new LogInPage(driver);
		loginpage.logIn("admin","123");
		loginpage.get_AlertMessageNotification();
		

		String expectedResult=Constants.EXPECTED_ALERT_TEXT;
		String actualResult = loginpage.get_AlertMessageNotification();
		System.out.println("The actual text alert message:"+actualResult);
		Assert.assertEquals(actualResult, expectedResult,"This testcase failed");
	}
}
