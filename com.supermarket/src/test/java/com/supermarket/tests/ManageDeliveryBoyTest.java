package com.supermarket.tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageDeliveryBoy;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;

public class ManageDeliveryBoyTest extends Base {


LogInPage login;
ManageDeliveryBoy deliveryboy;
Excel excel;

@Test(priority = 3,groups = { "Smoke", "Sanity" })
public void enter_DeliveryBoyDataByExcel() {
	excel =new Excel();
	excel.setExcelFile("DeliveryBoyDetails","DeliveryBoyList");
	String enterName=excel.getCellData(4,1);
	String emailId=excel.getCellData(4,2);
	String mobileNo=excel.getCellData(4,3);
	String address=excel.getCellData(4,4);
	String userName=excel.getCellData(4, 5);
	String passWord=excel.getCellData(4, 5);
	login=new LogInPage(driver);
	login.logIn();
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.click_NewButton();
	deliveryboy.create_DeliveryBoyDetails(enterName,emailId,mobileNo,address,userName,passWord);
	deliveryboy.click_SaveButton();
	String expectedResult=Constants.EXPECTEDRESULT_BACKGROUNDCOLOROFDANGERALERT;
    String actualResult=deliveryboy.getBackgroundColor_DangerAlertMsgOfDeliveryBoy();
    Assert.assertEquals(actualResult, expectedResult);
}

@Test(priority = 2,groups = "Sanity")
public void enter_ManageDeliveryData() {
	login=new LogInPage(driver);
	login.logIn();
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.click_NewButton();
	deliveryboy.create_DeliveryBoyDetails("ZuriyaSunil","zuriSunil87@gmail.com","68727889509","flat n0-199, north-east ernakulam p.o kochi","zurisunil1990","120078");
	deliveryboy.click_SaveButton();
	String expectedResult=Constants.EXPECTEDRESULT_BACKGROUNDCOLOROFSUCCESSALERT;
	String actualResult=deliveryboy.textSucessAlertMessage_BackgroundColor();
	Assert.assertEquals(actualResult, expectedResult);
	
}

@Test(dataProvider = "sixDimensional",dataProviderClass=com.supermarket.base.DataProviderClass.class,priority = 1)
public void enter_ManageDeliveryBoyDataByDataProvider(String data1,String data2,String data3,String data4,String data5,String data6) {
	login=new LogInPage(driver);
	login.logIn();
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.click_NewButton();
	deliveryboy.enter_NameOfDeliveryBoy(data1);
	deliveryboy.enter_EmailIdDeliveryBoy(data2);
	deliveryboy.enter_MobileNoDeliveryBoy(data3);
	deliveryboy.enter_AddressOfDeliveryBoy(data4);
	deliveryboy.enter_UserNameOfDeliveryBoy(data5);
	deliveryboy.enter_PassWordOfDeliveryBoy(data6);
	deliveryboy.click_SaveButton();
	String expectedResult=Constants.EXPECTEDRESULT_BACKGROUNDCOLOROFDANGERALERT;
	String actualResult=deliveryboy.getBackgroundColor_DangerAlertMsgOfDeliveryBoy();
	Assert.assertEquals(actualResult, expectedResult);
	
}
@Test(priority = 4,groups = "Smoke")
public void verify_DeleteFunctionality() {
	login=new LogInPage(driver);
	login.logIn();
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.scrollDownthePage();
	String expectedResult=Constants.EXPECTEDRESULT_BACKGRIUNDCOLOROFDELETEBUTTON;
	String actualResult=deliveryboy.deleteDeliveryBoyData("devi");
	Assert.assertEquals(actualResult, expectedResult);
	
}
@Test
public void verify_StatusFunctionality() {
	login=new LogInPage(driver);
	login.logIn();
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.changeStatus_ManageDeliveryBoy("Suju");
	String expectedResult=Constants.EXPECTEDRESULT_BACKGROUNDCOLOROFSUCCESSALERT;
	String actualResult=deliveryboy.textSucessAlertMessage_BackgroundColor();
	Assert.assertEquals(actualResult, expectedResult);
	
}
@Test
public void verify_SearchFunctionality() {
	login=new LogInPage(driver);
	login.logIn();
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.click_SearchButton();
	deliveryboy.search_ByNameField("ZuriyaSunil");
	deliveryboy.click_SearchFieldButton();
	String expectedResult=Constants.EXPECTEDRESULT_SEARCHBYNAME;
	String actualResult=deliveryboy.get_TextSearchName();
	Assert.assertEquals(actualResult, expectedResult);
}
@Test
public void verify_NewDeliveryBoyCreation() {
	
	login=new LogInPage(driver);
	login.logIn();
	String timeStamp=GeneralUtility.get_TimeStamp();
	deliveryboy=new ManageDeliveryBoy(driver);
	deliveryboy.scrollDownthePage();
	deliveryboy.click_ManageDeliveryBoyButton();
	deliveryboy.click_NewButton();
	deliveryboy.create_DeliveryBoyDetails("ZuriyaSunil_"+timeStamp,"zuriSunil87@gmail.com","68727889509","flat n0-199, north-east ernakulam p.o kochi","zurisunil1990_"+timeStamp,"120078");
	deliveryboy.click_SaveButton();
	deliveryboy.click_SearchButton();
	deliveryboy.search_ByNameField("ZuriyaSunil_"+timeStamp);
	deliveryboy.click_SearchFieldButton();
	String expectedResult=Constants.EXPECTEDRESULT_SEARCHBYNAME+timeStamp;
	String actualResult=deliveryboy.get_TextSearchName();
	Assert.assertEquals(actualResult, expectedResult);
}

}
