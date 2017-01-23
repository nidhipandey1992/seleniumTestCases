//package com.siebel.mcrmapp.test.support;

package com.gmail.gmailapp.test.support;

import org.openqa.selenium.WebDriver;
import com.gmail.gmailapp.main.support.FileRead;


public class LaunchBrowserCall{
	FileRead read=null;
	BrowserAndUrlLaunch ust=null;
    protected static WebDriver uidriver=null;
    public String studyClass=null;
    
    
    public LaunchBrowserCall() throws Exception{
    	ust=new BrowserAndUrlLaunch(); 
		read=new FileRead();		
    }
	public WebDriver launchBrowserAndUrl() throws Exception{
		//Setting up the Country
        read.GetCountryData("True", "Country");

		if(read.GetSheet1Data("Test1", "Browser").equals("Firefox")){
			uidriver=ust.launchFirefoxbrowser();
			return uidriver;
		}
		else if(read.GetSheet1Data("Test1", "Browser").equals("IE")){
			uidriver=ust.launchIEBrowser();
			return uidriver;
		}
		else{
			uidriver=ust.launchChromeBrowser();
			return uidriver;
		}
	}

}
