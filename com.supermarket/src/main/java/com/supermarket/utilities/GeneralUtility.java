package com.supermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	public boolean is_Displayed(WebElement element) {

		return element.isDisplayed();
	}

	public boolean is_Selected(WebElement element) {

		return element.isSelected();
	}

	public boolean is_Enabled(WebElement element) {

		return element.isEnabled();
	}

	public String get_Text(WebElement element) {

		return element.getText();
	}
	public String get_Title(WebElement element) {
		String title= driver.getTitle();
		return title;
	}
	public String get_CurrentUrl() {
	String currentUrl=driver.getCurrentUrl();
		return currentUrl;
	}

	public List<String> get_TextOfElements(String xpath) {
		List<String> text = new ArrayList<String>();
		List<WebElement> elementList = driver.findElements(By.xpath(xpath));
		for (WebElement list : elementList) {
			text.add(list.getText());
		}
		return text;
	}
	public boolean is_ElementTextMatched(WebElement element,String expectedText) {
		return element.getText().equals(expectedText);
		
	}
	public String getCssColorOfElement(WebElement element,String value) {
		return element.getCssValue(value);
	}
	public String getAttributeOfElement(WebElement element,String value) {
		return element.getAttribute(value);
	}
	public static  String get_TimeStamp() {
		String timeStamp=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
		
	}
}

