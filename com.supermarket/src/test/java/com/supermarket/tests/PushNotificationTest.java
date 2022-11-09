package com.supermarket.tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.PushNotificationPage;
import com.supermarket.utilities.PdfReader;

public class PushNotificationTest extends Base {
	PushNotificationPage pushnotify;
	LogInPage loginpage;
	PdfReader pdfreader;

	@Test(priority = 1)
	public void verify_PushNotification() {
		HashMap<String, String> map = new HashMap<String, String>();
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		pushnotify = new PushNotificationPage(driver);
		pushnotify.click_PushNotificationButton();
		pdfreader = new PdfReader();
		map = pdfreader.readPdf_Data("PushNotification");
		String deliveryBoyTitle= map.get("Title 1");
		String deliveryBoyDescription= map.get("Description1");
		pushnotify.getTextSuccessAlert_PushNotification(deliveryBoyTitle,deliveryBoyDescription);
		String expectedResult = Constants.SUCESSALERTMESSAGE_PUSHNOTIFICATION;
		String actualResult = pushnotify.getAttribute_PushNotification();
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(dataProvider = "PushNotificationExcelData", dataProviderClass = com.supermarket.base.DataProviderClass.class,priority = 2)
	public void verify_PushNotificationDataByDataProvider(String message, String description) {

		loginpage = new LogInPage(driver);
		loginpage.logIn();
		pushnotify = new PushNotificationPage(driver);
		pushnotify.click_PushNotificationButton();
		pushnotify.enterDataForPushNotification(message);
		pushnotify.enterData_PushNotification(description);
		pushnotify.click_SaveButton();
		String expectedResult = Constants.SUCESSALERTMESSAGE_PUSHNOTIFICATION;
		String actualResult = pushnotify.getAttribute_PushNotification();
		Assert.assertEquals(actualResult, expectedResult);

	}


}
