package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageSlider;
import com.supermarket.utilities.Excel;

public class ManageSliderTest extends Base{
	LogInPage loginpage;
	ManageSlider manageslider;
	
	@Test
	public void verify_UpdateFunctionalityOfManageSlider() {
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageslider=new ManageSlider(driver);
		manageslider.click_ManageSlider();
		manageslider.updateOfManageSlide("http://guru99.com");
		manageslider.update_LinkfieldOfManageSlide("http://guru9899.com");
		manageslider.click_UpdateButton();
		String expectedResult=Constants.SUCESSALERTMESSAGE_MANAGESLIDE;
		String actualResult=manageslider.getAttribute_SuccessAlertMessageOfUpdateData();
		Assert.assertEquals(actualResult, expectedResult);
	}
@Test
public void verify_EnterDataOfManageSlide() {
	loginpage=new LogInPage(driver);
	loginpage.logIn();
	manageslider=new ManageSlider(driver);
	manageslider.click_ManageSlider();
	manageslider.click_NewButtonOfManageSlide();
	manageslider.enter_ImageUpload(Constants.IMAGEUPLOAD_MANAGESLIDE+"\\Image1.jpg");
	manageslider.enter_LinkField("http://guru099.com");
	manageslider.click_SaveButton();
	String expectedResult=Constants.SUCESSALERTMESSAGE_MANAGESLIDE;
	String actualResult=manageslider.getAttribute_SuccessAlertMessageOfUpdateData();
	Assert.assertEquals(actualResult, expectedResult);
}
@Test
public void verify_CreateManageSlideFromExcel() {
	loginpage=new LogInPage(driver);
	loginpage.logIn();
	manageslider=new ManageSlider(driver);
	manageslider.click_ManageSlider();
	manageslider.click_NewButtonOfManageSlide();
	manageslider.enter_ImageUpload(Constants.IMAGEUPLOAD_MANAGESLIDE+"\\Image2.png");
	String link1;
	Excel excel =new Excel();
	excel.setExcelFile("LinkDetails","LinkSheet1");
	link1=excel.getCellData(0, 1);
	manageslider.enter_LinkField(link1);
	manageslider.click_SaveButton();
	String expectedResult=Constants.SUCESSALERTMESSAGE_MANAGESLIDE;
	String actualResult=manageslider.getAttribute_SuccessAlertMessageOfUpdateData();
	Assert.assertEquals(actualResult, expectedResult);
}
	
}
