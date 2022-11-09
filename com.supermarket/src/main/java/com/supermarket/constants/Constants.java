package com.supermarket.constants;

public class Constants {
public static final String CONFIGURE_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";

public static final String PDF_FILE_PATH="file:\\"+System.getProperty("user.dir")+"\\src\\main\\resources\\PdfFiles";
	
/**Login page**/
public static final String EXPECTED_ALERT_TEXT="Alert!";
public static final String EXPECTED_TEXTMESSAGE_LOGOUTBUTTON="Sign in to start your session";

/**Sub-Manage Expense**/
public static final String USERFILE_UPLOADOFSUBMANAGEEXPENSE=System.getProperty("user.dir")+"\\src\\main\\resources\\FileUpload";
public static final String EXPECTEDRESULT_UPADTEDDATAOFSUBMANAGEEXPENSE="    \r\n"
		+ "Expense Record Updated Successfully";
public static final String DANGERALERT_EXPENSECATEGORY="alert alert-danger alert-dismissible";
public static final String SUCESSALERT_EXPENSECATEGORY="alert alert-success alert-dismissible";

/**Manage Delivery Boy**/
public static final String EXPECTEDRESULT_BACKGROUNDCOLOROFSUCCESSALERT="rgba(40, 167, 69, 1)";
public static final String EXPECTEDRESULT_BACKGROUNDCOLOROFDANGERALERT="rgba(220, 53, 69, 1)";
public static final String EXPECTEDRESULT_BACKGRIUNDCOLOROFDELETEBUTTON="rgba(218, 51, 67, 1)";
public static final String EXPECTEDRESULT_SEARCHBYNAME="ZuriyaSunil_";

/**Manage Order**/
public static final String EXPECTEDTEXT_LISTORDER="List Orders";

/**Manage OfferCode**/
public static final String SEARCHOFFERCODE_MANAGEOFFERCODE="345";
public static final String UPLOADIMAGE_MANAGEOFFERCODE=System.getProperty("user.dir")+"\\src\\main\\resources\\ImageUpload";
public static final String DANGERALERT_MANAGEOFFERCODE="alert alert-danger alert-dismissible";

/**Manage Product**/
public static final String IMAGEUPLOAD_MANAGEPRODUCT=System.getProperty("user.dir")+"\\src\\main\\resources\\ImageUpload";
public static final String SUCESSMESSAGEALERT_ATTRIBUTEVALUE="alert alert-success alert-dismissible";
public static final String TITLENAME_SEARCHFIELD="Fruits P1038";

/**Manage Location**/
public static final String SUCESSALERTMESSAGE_MANAGELOCATION="alert alert-success alert-dismissible";
public static final String SUCESSALERTBACKGROUNDCOLOR_MANAGELOCATION="rgba(40, 167, 69, 1)";

/**Extent report**/
public static final String EXTENTREPORT_PATH=System.getProperty("user.dir")+"\\extentreport";

/**Manage User**/
public static final String  SUCESSALERTMESSAGE_CHANGESTATUSOFMANAGERUSER="alert alert-success alert-dismissible";
public static final String SEARCHTEXTNAME_MANAGEUSER="jothish thachamoochikkal";
public static final String SEARCHINVALIDNAME_MANAGEUSER=".........RESULT NOT FOUND.......";

/**Manage Slide**/
public static final String IMAGEUPLOAD_MANAGESLIDE=System.getProperty("user.dir")+"\\src\\main\\resources\\ImageUpload";
public static final String SUCESSALERTMESSAGE_MANAGESLIDE="alert alert-success alert-dismissible";

/**PushNotification**/
public static final String SUCESSALERTMESSAGE_PUSHNOTIFICATION="alert alert-success alert-dismissible";

/**Admin User**/
public static final String SUCCESSALERTMESSAGE_ADMINUSER="alert alert-success alert-dismissible";
public static final String DANGERALERTMESSAGE_ADMINUSER="alert alert-danger alert-dismissible";
public static final String ADMINNAME_LOGIN="Nimisha";
}

