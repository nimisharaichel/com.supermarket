package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;

public class LogInTest extends Base {
	LogInPage loginpage;

	@Test(groups = { "Smoke", "Sanity" })
	public void verify_LogIn() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		Assert.assertTrue(loginpage.is_ProfileImageDisplayed());
	}

	@Test(groups = "Sanity")

	public void verify_InvalidLogInAlertMessage() {
		loginpage = new LogInPage(driver);
		loginpage.logIn("admin", "123");
		loginpage.get_AlertMessageNotification();
		String expectedResult = Constants.EXPECTED_ALERT_TEXT;
		String actualResult = loginpage.get_AlertMessageNotification();
		Assert.assertEquals(actualResult, expectedResult, "This testcase passed");
	}

	@Test
	public void verify_LogOutFunctionality() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		loginpage.click_AdminButton();
		loginpage.click_LogOutButton();
		String expectedResult = Constants.EXPECTED_TEXTMESSAGE_LOGOUTBUTTON;
		String actualResult = loginpage.getText_LogOutButton();
		Assert.assertEquals(actualResult, expectedResult);
	}
}
