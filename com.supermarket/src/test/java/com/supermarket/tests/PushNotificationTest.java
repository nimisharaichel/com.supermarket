package com.supermarket.tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.PushNotificationPage;
import com.supermarket.utilities.PdfReader;

public class PushNotificationTest extends Base {
	PushNotificationPage pushnotify;
	LogInPage loginpage;
	PdfReader pdfreader;
	
	@Test
	public void verify_PushNotification() {
		HashMap<String, String> map=new HashMap<String,String>();
	
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		pushnotify=new PushNotificationPage(driver);
		pushnotify.click_PushNotificationButton();
		pushnotify.getTextSuccessAlert_PushNotification("Track", "Track Notification");
	    System.out.println(pushnotify.getTextAlert_PushNotification());
	    
	    pdfreader=new PdfReader();
	   map= pdfreader.readPdf_Data("PushNotification");
	   System.out.println(map.get("Title 1"));
	  // System.out.println(map);
	}
	
	  @Test(dataProvider="twoDimensional",dataProviderClass =com.supermarket.base.DataProviderClass.class)
	  public void create_PushNotificationDataByDataProvider(String data1,String data2) {
		  
		    loginpage = new LogInPage(driver);
			loginpage.logIn();
			pushnotify=new PushNotificationPage(driver);
			pushnotify.click_PushNotificationButton();
			
		  driver.findElement(By.xpath("//input[@id='title']")).sendKeys(data1);
		  driver.findElement(By.xpath("//input[@id='description']")).sendKeys(data2);
		  driver.findElement(By.xpath("//button[@class='btn btn-block-sm btn-info']")).click();
		  
		  
	  }
	    

	
}
