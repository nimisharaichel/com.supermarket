package com.supermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageDeliveryBoy;
import com.supermarket.utilities.Excel;

public class ManageDeliveryBoyTest extends Base {


LogInPage login;
ManageDeliveryBoy deliveryboy;
Excel excel;

@Test
public void create_DeliveryBoyData() {
	String enterName;
	String emailId;
	String mobileNo;
	String address;
	String userName;
	String passWord;
	excel =new Excel();
	excel.setExcelFile("DeliveryBoyDetails","DeliveryBoyList");
	enterName=excel.getCellData(4,1);
	emailId=excel.getCellData(4,2);
	mobileNo=excel.getCellData(4,3);
	address=excel.getCellData(4,4);
	userName=excel.getCellData(4, 5);
	passWord=excel.getCellData(4, 5);
	login=new LogInPage(driver);
	login.logIn();
	
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.click_NewButton();
	

	deliveryboy.create_DeliveryBoyDetails(enterName,emailId,mobileNo,address,userName,passWord);
	deliveryboy.click_SaveButton();
	Assert.assertTrue(deliveryboy.is_SaveButtonSelected());
	System.out.println(deliveryboy.getDangerAlertMsgOfDeliveryBoy());
}

@Test
public void verify_ManageDeliveryBoyTextAlertMessage() {
	login=new LogInPage(driver);
	login.logIn();
	
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.click_NewButton();
	deliveryboy.create_DeliveryBoyDetails("Nimishakovelil","varghese87@gmail.com","789675695","flat n0-18, ernakulam p.o kochi","varg1990","89078");
	
	deliveryboy.click_SaveButton();
	System.out.println(deliveryboy.get_TextAlertMessageOfDeliveryBoy());
	Assert.assertTrue(deliveryboy.textAlertMessage_IsDisplayed());
}
@Test
public void delete_ManageDeliveryBoyData() {
	login=new LogInPage(driver);
	login.logIn();
	
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.scrollDownthePage();
	deliveryboy.deleteDeliveryBoyData("Ani");
	
}

}
