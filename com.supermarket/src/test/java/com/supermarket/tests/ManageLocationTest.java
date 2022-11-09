package com.supermarket.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageLocation;

public class ManageLocationTest extends Base {
	ManageLocation managelocation;
	LogInPage loginpage;

	@Test
	public void verify_ManageLocationStatusFunctionality() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		managelocation = new ManageLocation(driver);
		managelocation.click_ManageLocationLink();
		managelocation.click_ChangeStatusOption("Street7");
		String expectedResult = Constants.SUCESSALERTMESSAGE_MANAGELOCATION;
		String actualResult = managelocation.getAttribute_ManageLocation();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(dataProvider = "twoDimensional", dataProviderClass = com.supermarket.base.DataProviderClass.class)
	public void create_ManageLocationData(String data1, String data2) {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		managelocation = new ManageLocation(driver);
		managelocation.click_ManageLocationLink();
		managelocation.enter_DetailsOfManageLocation();
		managelocation.enter_LocationOptionOfMangeLocation(data1);
		managelocation.enter_DeliveryChargeOfManageLocation(data2);
		managelocation.click_SaveButton();
		String expectedResult = Constants.SUCESSALERTMESSAGE_MANAGELOCATION;
		String actualResult = managelocation.getAttribute_ManageLocationSucessAlertMessage();
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test
	public void enter_ManageLocationData_HashMap() {
		HashMap<String, String> map = new HashMap<>();
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		managelocation = new ManageLocation(driver);
		managelocation.click_ManageLocationLink();
		managelocation.enter_DetailsOfManageLocation();
		map.put("location01", "Street18");
		map.put("charge01", "230");
		managelocation.enter_LocationOfManageLocationHashMap(map.get("location01"));
		managelocation.enter_DeliveryChargeOfManageLocationHashMap(map.get("charge01"));
		managelocation.click_SaveButton();
		String expectedResult = Constants.SUCESSALERTMESSAGE_MANAGELOCATION;
		String actualResult = managelocation.getAttribute_ManageLocationSucessAlertMessage();
		Assert.assertEquals(actualResult, expectedResult);

	}
}
