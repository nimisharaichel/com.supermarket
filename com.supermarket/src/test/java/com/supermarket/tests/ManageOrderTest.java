package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageOrder;

public class ManageOrderTest extends Base{
	LogInPage loginpage;
	ManageOrder manageorder;
	
	@Test
	public void verify_ManageOrder() {
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageorder=new ManageOrder(driver);
		manageorder.click_ManagerOrderLink();
		String expectedResult=Constants.EXPECTEDTEXT_LISTORDER;
		String actualResult=manageorder.getText_ListOrder();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
}
