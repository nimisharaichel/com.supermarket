package com.supermarket.constants;

public class Constants {
public static final String CONFIGURE_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";

public static final String PDF_FILE_PATH="file:\\"+System.getProperty("user.dir")+"\\src\\main\\resources\\PdfFiles";
	
/**Login page**/
public static final String EXPECTED_ALERT_TEXT="Alert!";

/**Sub-Manage Expense**/
//public static final String USERFILE_UPLOADOFSUBMANAGEEXPENSE=System.getProperty("user.dir")+"\\com.supermarket\\FileUpload\\GrocerylList.pdf";
public static final String USERFILE_UPLOADOFSUBMANAGEEXPENSE="C:\\Users\\USER\\git\\com.supermarket\\com.supermarket\\src\\main\\resources\\FileUpload\\GrocerylList.pdf";

public static final String EXPECTEDRESULT_UPADTEDDATAOFSUBMANAGEEXPENSE="    \r\n"
		+ "Expense Record Updated Successfully";


/**Manage Order**/
public static final String EXPECTEDTEXT_LISTORDER="List Orders";

/**Manage Product**/
public static final String IMAGEUPLOAD_MANAGEPRODUCT=System.getProperty("user.dir")+"\\src\\main\\resources\\ImageUpload";

/**Extent report**/
public static final String EXTENTREPORT_PATH=System.getProperty("user.dir")+"\\extentreport";
}