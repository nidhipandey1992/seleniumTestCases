//package com.siebel.mcrmapp.testsuite;

package com.gmail.app.testsuite;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.gmail.app.testsuite.GmailLoginTest;
import com.gmail.gmailapp.main.support.SeleniumFunctions;
import com.gmail.gmailapp.main.support.Constants;
import com.gmail.gmailapp.test.support.LaunchBrowserCall;
import com.gmail.gmailogin.main.classes.GmailLogin;
import com.gmail.gmailogin.main.locators.GmailLoginUILocators;

public class GmailLoginTest  {
	WebDriver uidriver=null;
    LaunchBrowserCall obj=null;
    SeleniumFunctions close=null;
    GmailLogin test=null;
    String methodName=null;
    Logger logger =Logger.getLogger("GmailLoginTest"); 
    
    GmailLoginUILocators testing=null;
    public String locate=null;
    public String phone=null;
    public String pwd=null;
    SeleniumFunctions linkmethod=null;
    Constants detail=null;
    
   @Test(priority=1)
   public void loginUser() throws Exception {
	/*00_001 Login User*/
	test=new GmailLogin();
	logger.info("----------------------Starting Test1----------------------");
	test.confirmHomeScreen("mgAdministratorUser");
	
	/*testing=new GmailLoginUILocators();
	testing.GeneralAdminUILocatorsandSelFunctions();
	locate=testing.loginFieldLocator;
	
	linkmethod=new SeleniumFunctions();
	linkmethod.clickByLinkText(locate);
	logger.info("----------------------Login link clicked---------------------");
	
	testing=new GmailLoginUILocators();
	testing.GeneralAdminUILocatorsandSelFunctions();
	locate=testing.userIDFieldLocator;
	phone=testing.phoneNumber;
	
	linkmethod=new SeleniumFunctions();
	linkmethod.enterDataByxpath(locate,phone);
	logger.info("----------------------Phone number entered---------------------");
	
	testing=new GmailLoginUILocators();
	testing.GeneralAdminUILocatorsandSelFunctions();
	locate=testing.passwordFieldLocator;
	pwd=testing.password;
	
	linkmethod=new SeleniumFunctions();
	linkmethod.enterDataByxpath(locate,pwd);
	logger.info("----------------------Password entered---------------------");
	
	testing=new GmailLoginUILocators();
	testing.GeneralAdminUILocatorsandSelFunctions();
	locate=testing.submitFieldLocator;
	
	linkmethod=new SeleniumFunctions();
	linkmethod.clickByxpath(locate);
	logger.info("----------------------Submit/Login button clicked---------------------");
	*/
	
	
	logger.info("----------------------Finished Test1---------------------");
	   
	   
	   
   }
    
  @BeforeTest
  public void beforeTest() throws Exception {
   obj=new LaunchBrowserCall();
   uidriver=obj.launchBrowserAndUrl();
  }

//  @AfterTest
//  public void afterTest() throws Exception {
//   close=new SeleniumFunctions();
//   close.browserClose();
//  }
  
  @AfterMethod
  public void takeScreenShotOnFailure(ITestResult testResult) throws Exception{
   try{
	   close=new SeleniumFunctions();
	   methodName=testResult.getName();
	   
	   if (testResult.getStatus() == ITestResult.FAILURE){
		   close.takeAScreenshot(methodName);
	  }
	  else if(testResult.getStatus() == ITestResult.SUCCESS){
		  logger.info(methodName+" test has passed");
	  }
	 }
   catch(Exception e){
	   System.out.println("Exception "+e);
	 }
  }
}