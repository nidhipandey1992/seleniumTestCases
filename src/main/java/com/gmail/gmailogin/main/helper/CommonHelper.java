//package com.siebel.mcrm.main.helper;

package com.gmail.gmailogin.main.helper;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import com.siebel.mcrm.main.locators.CommonHelperUILocators;
import com.gmail.gmailapp.main.support.Constants;
import com.gmail.gmailapp.main.support.FileRead;

public class CommonHelper
{
	String testData=null;
	String exception=null;
	List<WebElement> elements=null;
	WebElement element=null;
	Logger logger=Logger.getLogger("CommonHelper");
	protected String excelData=null;
	protected FileRead read=null;
	Constants constant=new Constants();
	int countHelp=0;

	public CommonHelper() throws Exception{
		read=new FileRead();
	}

	public void loginUser(String role) throws Exception{
		logger.info("-------Logging in to Gmail app---------");

	}
	
}
