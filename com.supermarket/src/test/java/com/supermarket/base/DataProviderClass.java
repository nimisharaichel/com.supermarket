package com.supermarket.base;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider (name="twoDimensional")
	public Object[][] two_Dimensions()
	{
		return new Object [][] {{"Cosmetics","Add the item to list"},{"Sandals","Add the item to the list"}};
		
		
		
	}

}
