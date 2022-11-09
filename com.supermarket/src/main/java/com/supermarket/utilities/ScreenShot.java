package com.supermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

public class ScreenShot {
TakesScreenshot takesscreenshot;

public void take_ScreenShot(WebDriver driver,String imageName) {
	
	try {
		
		takesscreenshot=(TakesScreenshot) driver;// to pick the scrrenshot
		File screenshotfile=takesscreenshot.getScreenshotAs(OutputType.FILE);//to take the screenshot
		String timeStamp=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//attach along with image
		String destination=System.getProperty("user.dir")+"\\ScreenShots\\"+imageName+ " "+timeStamp+".png";
		File finalNewDestination=new File(destination);
		FileHandler.copy(screenshotfile, finalNewDestination);
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
