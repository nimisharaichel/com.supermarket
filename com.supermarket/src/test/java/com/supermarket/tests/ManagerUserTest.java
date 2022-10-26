package com.supermarket.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
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
		
		
	}
	@Test
	public void verify_deleteDataOfManageUser() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		manageuser=new ManageUser(driver);
		manageuser.click_ManageUser();
		manageuser.deleteData_User("rex lex");
	}
	@Test
	public void verify_SearchValidDataOfManagerUser() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		manageuser=new ManageUser(driver);
		manageuser.click_ManageUser();
		manageuser.click_SearchFieldInManageUser();
		manageuser.searchDataByName_ManageUser("Riyanka M");
		manageuser.searchDataByEmail_ManageUser("riyam@gmail.com");
		manageuser.searchByPhoneNo_ManageUser("0000000000");
		manageuser.searchBystatus_ManageUser();
		manageuser.click_searchButtonOfManageUser();
		
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
		manageuser.searchBystatus_ManageUser();
		manageuser.click_searchButtonOfManageUser();
		
	}
}
