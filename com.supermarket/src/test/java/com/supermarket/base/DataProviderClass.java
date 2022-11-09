package com.supermarket.base;

import org.testng.annotations.DataProvider;

import com.supermarket.utilities.Excel;

public class DataProviderClass {
	Excel excel;
	@DataProvider(name="PushNotificationExcelData")
	public Object[][] push_Notification(){
		excel=new Excel();
		excel.setExcelFile("PushNotification","Notification");
		return excel.get_MultiDimensionalObjectArray(3, 2);
		
	}
	@DataProvider (name="sixDimensional")
	public Object[][] six_Dimensions()
	{
		return new Object [][] {{"krupa","kripa23@gmail.com","7865234567","flat-56 othera p.o thiruvalla","krupakutty","009993"}};
		
		
		
	}
	@DataProvider (name="twoDimensional")
	public Object[][] two_Dimensions()
	{
		return new Object [][] {{"Street23","200"},{"SandalsStreet25","150"}};
		
		
		
	}
}
