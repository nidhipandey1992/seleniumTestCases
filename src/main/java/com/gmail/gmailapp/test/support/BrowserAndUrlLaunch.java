//package com.siebel.mcrmapp.test.support;

package com.gmail.gmailapp.test.support;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.gmail.gmailapp.main.support.FileRead;


public class BrowserAndUrlLaunch {
       WebDriver driver =null;
       FileRead read=null;
       String IEDriver=null;
       String ChromeDriver=null;
       FirefoxBinary firefoxbin=null;
       Logger logger =Logger.getLogger("LaunchBrowserCall");
       
       public BrowserAndUrlLaunch() throws Exception {
    	   IEDriver="C:/Users/vinay_suri/Desktop/IEDriverServer.exe";
    	   ChromeDriver="C:/Users/vinay_suri/Desktop/chromedriver.exe";
              read=new FileRead();
       }
       
       public WebDriver launchFirefoxbrowser() throws Exception{
              logger.info("----Launching Firefox----");
              driver=new FirefoxDriver();
              driver.manage().window().maximize();
//            driver.get(read.GetSheet1Data("Test1", "AppUrl"));
              driver.get(read.getCountrySpecificValue("url"));
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
              }
       
       public WebDriver launchIEBrowser() throws Exception{
              System.setProperty("webdriver.ie.driver",IEDriver);
              logger.info("----Launching InternetExplorer----");
              driver=new InternetExplorerDriver();
              driver.manage().window().maximize();
//            driver.get(read.GetSheet1Data("Test1", "AppUrl"));
              driver.get(read.getCountrySpecificValue("url"));
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
              return driver;
       }
       
       public WebDriver launchChromeBrowser() throws Exception{
              System.setProperty("webdriver.chrome.driver",ChromeDriver);
              logger.info("----Launching Chrome----");
              driver= new ChromeDriver();
              driver.manage().window().maximize();
//            driver.get(read.GetSheet1Data("Test1", "AppUrl"));
              driver.get(read.getCountrySpecificValue("url"));
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
              return driver;
       }
}
