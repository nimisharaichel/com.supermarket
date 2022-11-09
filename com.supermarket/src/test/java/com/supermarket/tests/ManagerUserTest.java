package com.supermarket.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageUser;

public class ManagerUserTest extends Base {
	LogInPage loginpage;
	ManageUser manageuser;
	

	@Test
	public void verify_manageUserDeactivation() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		manageuser=new ManageUser(driver);
		manageuser.click_ManageUser();
		manageuser.deactivate_User("jothish thachamoochikkal");
		String expectedResult=Constants.SUCESSALERTMESSAGE_CHANGESTATUSOFMANAGERUSER;
		String actualResult=manageuser.getAttribute_ChangeStatusOfManageUser();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test
	public void verify_SearchValidDataOfManagerUser() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		manageuser=new ManageUser(driver);
		manageuser.click_ManageUser();
		manageuser.click_SearchFieldInManageUser();
		manageuser.searchDataByName_ManageUser("jothish");
		manageuser.searchDataByEmail_ManageUser("tkjothish@gmail.com");
		manageuser.searchByPhoneNo_ManageUser("0210682128");
		manageuser.searchBystatus_ManageUser(2);
		manageuser.click_searchButtonOfManageUser();
		String expectedResult=Constants.SEARCHTEXTNAME_MANAGEUSER;
		String actualResult=manageuser.getText_SearchDataOfManageUser();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test
	public void verify_SearchInvalidDataOfManagerUser() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		manageuser=new ManageUser(driver);
		manageuser.click_ManageUser();
		manageuser.click_SearchFieldInManageUser();
		manageuser.searchDataByName_ManageUser("Riyanka M");
		manageuser.searchDataByEmail_ManageUser("riyam@gmail.com");
		manageuser.searchByPhoneNo_ManageUser("76389807632");
		manageuser.searchBystatus_ManageUser(2);
		manageuser.click_searchButtonOfManageUser();
		String expectedResult=Constants.SEARCHINVALIDNAME_MANAGEUSER;
		String actualResult=manageuser.getText_SearchInvalidDataOfManageUser();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
}
