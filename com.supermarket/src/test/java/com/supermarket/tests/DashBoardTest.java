package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.DashBoardPage;
import com.supermarket.pages.LogInPage;

public class DashBoardTest extends Base {
	LogInPage loginpage;
	DashBoardPage dashboardpage;

	@Test(groups = { "Smoke", "Sanity" })
	public void verify_DashboardLogSymbol() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		dashboardpage = new DashBoardPage(driver);
		Assert.assertTrue(dashboardpage.logoSymbol_DashBoard());

	}
}
