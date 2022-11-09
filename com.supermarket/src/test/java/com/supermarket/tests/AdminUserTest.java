package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUser;
import com.supermarket.pages.LogInPage;
import com.supermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {
	LogInPage loginpage;
	AdminUser adminuser;

	
	@Test
	public void verify_CreateAdminUserData() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		String timeStamp=GeneralUtility.get_TimeStamp();
		adminuser=new AdminUser(driver);
		adminuser.click_AdminUserLink();
		adminuser.click_NewButtonOfAdminUser();
		adminuser.enterDetailsOfAdminUser("Admin1_"+timeStamp,"admin1_"+timeStamp);
		String expectedResult=Constants.SUCCESSALERTMESSAGE_ADMINUSER;
		String actualResult=adminuser.getAttribute_AlertMessageOfAdminUser();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test
	public void verify_EnterAdminUserDataDetails() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		adminuser=new AdminUser(driver);
		adminuser.click_AdminUserLink();
		adminuser.click_NewButtonOfAdminUser();
		adminuser.enter_AdminUserDataUsingList("nimisha","123456");
		adminuser.click_SaveButtonOfAdminUser();
		String expectedResult=Constants.DANGERALERTMESSAGE_ADMINUSER;
		String actualResult=adminuser.getAttribute_DangerAlertMessageOfAdminUser();
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test
	public void verify_NewAdminUserLogInFunctionality() {
		adminuser=new AdminUser(driver);
		adminuser.enterUserNameOfLogIn("nimisha");
		adminuser.enterPassWordOfLogIn("123456");
		adminuser.clickSignInButton();
		String expectedResult=Constants.ADMINNAME_LOGIN;
		String actualResult=adminuser.getText_AdminNameOfLogIn();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
}
