package com.supermarket.tests;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.DashBoardPage;
import com.supermarket.pages.LogInPage;

public class DashBoardTest extends Base {
	LogInPage loginpage;
	DashBoardPage dashboardpage;
	
	@Test
	public void verify_Dashboard() {
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		dashboardpage=new DashBoardPage(driver);
		System.out.println("Title:"+dashboardpage.get_TitleOfPage());
		System.out.println("The current Url:"+dashboardpage.get_CurrentUrlOfThePage());
	}
}
