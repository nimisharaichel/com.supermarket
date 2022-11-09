package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageOfferCode;

public class ManageOfferCodeTest extends Base{
LogInPage loginpage;
ManageOfferCode manageoffercode;

@Test
public void verify_SearchFunctionalityOfManageOfferCode() {
	loginpage=new LogInPage(driver);
	loginpage.logIn();
	manageoffercode=new ManageOfferCode(driver);
	manageoffercode.click_ManageOfferCode();
	manageoffercode.click_SearchButtonOfManageOfferCode();
	manageoffercode.enter_OfferCodeField("345");
	manageoffercode.click_SearchButtonLink();
	String expectedResult=Constants.SEARCHOFFERCODE_MANAGEOFFERCODE;
	String actualResult=manageoffercode.getText_SearchOfferCodeResult();
	Assert.assertEquals(actualResult, expectedResult);
	
	
}
@Test
public void create_DataForManageOfferCode() {
	loginpage=new LogInPage(driver);
	loginpage.logIn();
	manageoffercode=new ManageOfferCode(driver);
	manageoffercode.click_ManageOfferCode();
	manageoffercode.click_NewButton();
	manageoffercode.enter_ManageOfferCodeData();
	manageoffercode.upload_ImageForManageOfferCode(Constants.UPLOADIMAGE_MANAGEOFFERCODE+"\\Image4.png");
	manageoffercode.click_SaveButton();
	String expectedResult=Constants.DANGERALERT_MANAGEOFFERCODE;
	String actualResult=manageoffercode.getAttribute_DangerAlertMessageOfManagerOfferCode();
	Assert.assertEquals(actualResult, expectedResult);
	
}
}
