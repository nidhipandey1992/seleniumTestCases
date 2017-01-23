//package com.siebel.mcrm.main.classes;

package com.gmail.gmailogin.main.classes;

//import static org.testng.AssertJUnit.assertTrue;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.apache.log4j.Logger;
import com.gmail.gmailogin.main.helper.CommonHelper;
import com.gmail.gmailogin.main.locators.GmailLoginUILocators;
import com.gmail.gmailapp.main.support.Constants;
import com.gmail.gmailapp.main.support.FileRead;

public class GmailLogin extends GmailLoginUILocators {
	String testData=null;
	String exception=null;
	String text=null;
	List<WebElement> elements=null;
	WebElement element=null;
	int size=0;
	CommonHelper function=new CommonHelper();
	Logger logger =Logger.getLogger("GmailLogin");
	int length=5;

	int elementindex=0;
	Constants constant=new Constants();
	FileRead read=new FileRead();

	public GmailLogin() throws Exception {
		super();
		
	}

	public void confirmHomeScreen(String role) throws IOException{
		try{
			logger.info("-----'LoginUser' test set started------");
			
		}
		catch(Exception e){
			exception =e.toString();
			Assert.fail(exception);
		}
	}
}