//package com.siebel.mcrmapp.main.support;

package com.gmail.gmailapp.main.support;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gmail.gmailapp.test.support.LaunchBrowserCall;
import java.io.File;
import java.io.IOException;


public class SeleniumFunctions extends LaunchBrowserCall{
	static List<WebElement> items=null;
	static WebElement item=null;
	DateFormat dateFormat=null;
    Date currentDate=null;
	String Date=null;
	File directory=null;
	Logger logger =Logger.getLogger("SeleniumFunctions");
	FileRead read=new FileRead();
	
	    public SeleniumFunctions() throws Exception{
		super();
		}

/* Click Functions StartRegion */
		public void clickByCssSelector(String locator){
		    waitForUIElementBycssSelector(locator);
			WebElement element=uidriver.findElement(By.cssSelector(locator));
			element.click();
			logger.info("Clicked the locator "+locator);
		}
		public void clickByLinkText(String locator){
			waitForUIElementBylinktext(locator);
			WebElement element=uidriver.findElement(By.linkText(locator));
			element.click();
			logger.info("Clicked the locator "+locator);
		}
		public void clickById(String locator){
			waitForUIElementByid(locator);
			WebElement element=uidriver.findElement(By.id(locator));
			element.click();
			logger.info("Clicked the locator "+locator);
		}
		public void clickByxpath(String locator){
			waitForUIElementByxpath(locator);
			WebElement element=uidriver.findElement(By.xpath(locator));
			element.click();
			logger.info("Clicked the locator "+locator);
		}	
		public void clicklistByxpath(String locator, int index){
//			waitForUIElementByxpath(locator);
			List <WebElement> elements=uidriver.findElements(By.xpath(locator));
			elements.get(index).click();
			logger.info("Clicked the locator "+locator);
		}
		public void clickByname(String locator){
			waitForUIElementByName(locator);
			WebElement element=uidriver.findElement(By.name(locator));
			element.click();
			logger.info("Clicked the locator "+locator);
		}
/* Click Functions EndRegion */

		
/*Functions to insert, clear or get data in TextBox, StartRegion*/	
		  public void enterTextDataListByxpath(String locator,int index,String text)
	      {
	         List<WebElement> items=uidriver.findElements(By.xpath(locator));  
	        WebElement element= items.get(index);
	        element.clear();
	        element.sendKeys(text);
	      }
		public void enterDataByCssSelector(String locator, String text){
			waitForUIElementBycssSelector(locator);
			WebElement element=uidriver.findElement(By.cssSelector(locator));
			element.sendKeys(text);
		}
		public void enterDataByxpath(String locator, String text){
			waitForUIElementByxpath(locator);
			WebElement element=uidriver.findElement(By.xpath(locator));
			element.sendKeys(text);
		}
		public void enterDataByid(String locator, String text){
			waitForUIElementByid(locator);
			WebElement element=uidriver.findElement(By.id(locator));
			element.sendKeys(text);
		}
		public void enterDataByname(String locator, String text){
			waitForUIElementByName(locator);
			WebElement element=uidriver.findElement(By.name(locator));
			element.sendKeys(text);
		}
		public void clearTextDataByCssSelector(String locator){
			waitForUIElementBycssSelector(locator);
			WebElement element=uidriver.findElement(By.cssSelector(locator));
			element.clear();
		}
		
		public void clearTextDataByxpath(String locator){
			waitForUIElementByxpath(locator);
			WebElement element=uidriver.findElement(By.xpath(locator));
			element.clear();
		}
		public void clearTextDataByid(String locator){
			waitForUIElementByid(locator);
			WebElement element=uidriver.findElement(By.id(locator));
			element.clear();
		}
		public void clearTextDataByname(String locator){
			waitForUIElementByName(locator);
			WebElement element=uidriver.findElement(By.name(locator));
			element.clear();
		}
		public void clearTextDataBytagname(String locator){
			waitForUIElementByTagName(locator);
			WebElement element=uidriver.findElement(By.tagName(locator));
			element.clear();
		}
	       public String getattributeValueByxpath(String locator){
	        	 waitForUIElementByxpath(locator);
	        	   WebElement element=uidriver.findElement(By.xpath(locator));
	    		return	element.getAttribute("value");      
	        }
	       public String getattributeValueByid(String locator){
	        	 waitForUIElementByid(locator);
	        	   WebElement element=uidriver.findElement(By.id(locator));
	    		return	element.getAttribute("value");      
	        }
	       public String getattributeValueByname(String locator){
	        	 waitForUIElementByName(locator);
	        	   WebElement element=uidriver.findElement(By.name(locator));
	    		return	element.getAttribute("value");      
	        }
	       public String getattributeValueBycssSelector(String locator){
	        	 waitForUIElementBycssSelector(locator);
	        	   WebElement element=uidriver.findElement(By.cssSelector(locator));
	    		return	element.getAttribute("value");      
	        }
	       public String getattributeTitleByxpath(String locator){
	        	 waitForUIElementByxpath(locator);
	        	   WebElement element=uidriver.findElement(By.xpath(locator));
	    		return	element.getAttribute("title");      
	        }
	       public String getattributeTitleBycssSelector(String locator){
	        	 waitForUIElementByxpath(locator);
	        	   WebElement element=uidriver.findElement(By.cssSelector(locator));
	    		return	element.getAttribute("title");      
	        }
       
        public void elementScrollDOwn(String locator){
               WebElement element=uidriver.findElement(By.xpath(locator));
               element.sendKeys(Keys.PAGE_DOWN);
        }
        
        public void elementScrollUp(String locator){
               waitForUIElementBycssSelector(locator);
               WebElement element=uidriver.findElement(By.cssSelector(locator));
               element.sendKeys(Keys.PAGE_UP);
        }
        public void elementScrollDownByCss(String locator)
    	{
    		waitForUIElementBycssSelector(locator);
    		WebElement element=uidriver.findElement(By.cssSelector(locator));
    		element.sendKeys(Keys.PAGE_DOWN);

    	}
    	public void elementScrollRightByXpath(String locator)
    	{
    		WebElement element = uidriver.findElement(By.xpath(locator));
    		element.sendKeys(Keys.RIGHT);
    	}

/*Functions to insert data in TextBox, EndRegion*/

		
/*Functions to hover WebElements, StartRegion*/		
	    public void elementHoverByCssSelector(String locator)
	    {
			Actions touch=new Actions(uidriver);
			waitForUIElementBycssSelector(locator);
			WebElement element=uidriver.findElement(By.cssSelector(locator));
			touch.moveToElement(element).perform();
		}
 /*Functions to hover WebElements, EndRegion*/

	    
/*Wait and Browser functions, StartRegion*/	  
        public void waitForPageLoad(){
	 		uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
        public void waitForOneSecond()
        {
        	long end = System.currentTimeMillis() + 1000;
             while (System.currentTimeMillis() < end) {
              }
        }
        
        public void waitForTwoSecond()
        {
        	long end = System.currentTimeMillis() + 2000;
             while (System.currentTimeMillis() < end) {
              }
        }
        
        public void waitForThreeSecond()
        {
        	long end = System.currentTimeMillis() + 3000;
             while (System.currentTimeMillis() < end) {
              }
        }
        
        public void waitForFourSecond()
        {
        	long end = System.currentTimeMillis() + 4000;
             while (System.currentTimeMillis() < end) {
              }
        }
        
        public void waitForFiveSecond()
        {
        	long end = System.currentTimeMillis() + 5000;
             while (System.currentTimeMillis() < end) {
              }
        }
        
        public void waitforElementPresentByid(String locator){
        	@SuppressWarnings("unused")
			WebElement element=null;
        	logger.info("Waiting for the element to be available");
        	 element = (new WebDriverWait(uidriver, 30).
        			 until(ExpectedConditions.presenceOfElementLocated(By.id(locator))));
        }
        
	    public void browserClose(){
	    	logger.info("----Closing Browser----");
	    	if(uidriver.toString().contains("null")){
	    		logger.info("No browser to close");
	    	}
	    	else{
	    	uidriver.close();
	    	}
		}
	    
	    public void pageRefresh(){
	    	logger.info("----Refreshing the screen----");
	    	uidriver.navigate().refresh();
	    }
	    
	    public void goBack(){
	    	logger.info("----Refreshing the screen----");
	    	uidriver.navigate().back();
	    }
	    
	    public void waitForUIElementByid(String locator){
	    	logger.info("Waiting for locator "+locator);
	    	WebDriverWait wait = new WebDriverWait(uidriver, 40000);
	    	wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));	
	    }
	    public void waitForUIElementBylinktext(String locator){
	    	logger.info("Waiting for locator "+locator);
	    	WebDriverWait wait = new WebDriverWait(uidriver, 40000);
	    	wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));	
	    }
	    public void waitForUIElementByxpath(String locator){
	    	logger.info("Waiting for locator "+locator);
	    	WebDriverWait wait = new WebDriverWait(uidriver, 40000);
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));	
	    }
	    public void waitForUIElementBycssSelector(String locator){
	    	logger.info("Waiting for locator "+locator);
	    	WebDriverWait wait = new WebDriverWait(uidriver, 40000);
	    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));	
	    }
	    public void waitForUIElementByName(String locator){
	    	logger.info("Waiting for locator "+locator);
	    	WebDriverWait wait = new WebDriverWait(uidriver, 40000);
	    	wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));	
	    }
	    public void waitForUIElementByTagName(String locator){
	    	logger.info("Waiting for locator "+locator);
	    	WebDriverWait wait = new WebDriverWait(uidriver, 40000);
	    	wait.until(ExpectedConditions.elementToBeClickable(By.tagName(locator)));	
	    }	    
//	    public void waitForUIElementBycssSelectorList(String locator){
//	    	logger.info("Waiting for locator "+locator);
//	    	WebDriverWait wait = new WebDriverWait(uidriver, 300000);
//	    	List<WebElement> elements=uidriver.findElements(By.cssSelector(locator));
//	    	wait.until(ExpectedConditions.visibilityOfAllElements(elements));
//	    }
	    public void openNewTab() throws IOException, InterruptedException{
	    	uidriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			ArrayList<String> tabs = new ArrayList<String> (uidriver.getWindowHandles());
			uidriver.switchTo().window(tabs.get(1));
	    }
	    public void closeTab() throws IOException, InterruptedException{
	    	ArrayList<String> tabs = new ArrayList<String> (uidriver.getWindowHandles());
	    	uidriver.switchTo().window(tabs.get(0));
	    	uidriver.close();
	    	uidriver.switchTo().window(tabs.get(1));
	    }
/*Wait and Browser functions, EndRegion*/

	    
/*Get only elements, StartRegion*/
	    public WebElement getElementbyCssSelector(String locator){
	    	waitForUIElementBycssSelector(locator);
		   WebElement item=uidriver.findElement(By.cssSelector(locator));
	    	  return item;  
	    }
	    public WebElement getElementbyId(String locator){
	    	waitForUIElementByid(locator);
		   WebElement item=uidriver.findElement(By.id(locator));
	    	  return item;  
	    }	   
	    public WebElement getElementbyxpath(String locator){
//	    	waitForUIElementByxpath(locator);
		   WebElement item=uidriver.findElement(By.xpath(locator));
	    	  return item;  
	    }	   
       public List<WebElement> getElementbyxpathList(String locator){
//    	   waitForUIElementByxpath(locator);
    	  List<WebElement> items=uidriver.findElements(By.xpath(locator));  
    	  return items;  
        }      
       public List<WebElement> getElementbyCssSelectorList(String locator){
//    	   waitForUIElementBycssSelector(locator);
    	  List<WebElement> items=uidriver.findElements(By.cssSelector(locator));
    	  return items;  
        }      
       public List<WebElement> getElementbyIdList(String locator){
//    	   waitForUIElementByid(locator);
    	  List<WebElement> items=uidriver.findElements(By.id(locator));
    	  return items;  
        }
       public List<WebElement> getElementbytagnameList(String locator){
//    	   waitForUIElementByTagName(locator);
    	   List<WebElement> items=uidriver.findElements(By.tagName(locator));
    	   return items;
       }
       public List<WebElement> getElementbynameList(String locator){
//    	   waitForUIElementByxpath(locator);
    	  List<WebElement> items=uidriver.findElements(By.name(locator));  
    	  return items;  
        }
/*Get only elements, EndRegion*/ 

       
/*Functions for drop down,radio button, start region*/
       public void selectFromDropDownByvisibleText(String locator, String text){
    	   waitForUIElementByName(locator);
     	  WebElement element=uidriver.findElement(By.name(locator));  
     	  Select item=new Select(element);
     	  item.selectByVisibleText(text);
         }
       public void selectFromDropDownByvisibleTextBycssSelector(String locator, String text){
//    	   waitForUIElementByName(locator);
     	  WebElement element=uidriver.findElement(By.cssSelector(locator));  
     	  Select item=new Select(element);
     	  item.selectByVisibleText(text);
         }
       public void selectFromDropDownByvalue(String locator, String Value){
    	   waitForUIElementByName(locator);
      	  WebElement element=uidriver.findElement(By.name(locator));  
      	  Select item=new Select(element);
      	  item.selectByValue(Value);
          }
       public void selectRadioButtonbytext(String locator, String text){
    	   List<WebElement> items=uidriver.findElements(By.cssSelector(locator));
    	 for(WebElement element:items){
    		 if(element.getAttribute("value").equalsIgnoreCase(text)){
    			 element.click();
    			 break;
    		 }
    	   }
    	 }
       public boolean checkifRadioButtonSelected(String locator, String text){
    			boolean value=false;
    			List<WebElement> items=uidriver.findElements(By.cssSelector(locator));
    			for(WebElement element:items){
    				if(element.getAttribute("value").equalsIgnoreCase(text)){
    					value=element.isSelected();
    					break;
    				}
    			}
    			return value; 			
    		}
       public String selectedDropDownvaluebycssSelector(String locator){
      	 waitForUIElementBycssSelector(locator);
           WebElement element=uidriver.findElement(By.cssSelector(locator));  
           Select item=new Select(element);
           return item.getFirstSelectedOption().getText();
  }
       
/*Functions for drop down,radio button, EndRegion*/


/*Alerts handling, Start region*/
       
       public void acceptAlert(){
          Alert alert = uidriver.switchTo().alert();
          alert.accept();
       }
       public void dismissAlert(){
           Alert alert = uidriver.switchTo().alert();
           alert.dismiss();
        }
       public String getAlertText(){
    	   Alert alert = uidriver.switchTo().alert();
           return alert.getText();
       }
       
       public boolean alertPresent(){
    	   try{
    	   uidriver.switchTo().alert();
    	   return true;
    	   }
    	   catch(Exception e){
    	   return false;  
    	   }
       }
       
       public String readAlertText()
       {
   		Alert alert = uidriver.switchTo().alert();
   		String message=alert.getText();
   		return message;
   	  }
     
/*Alerts handling, End region*/  

       
/*Screenshot,DateFormat functions,  StartRegion*/
       
       public String UseDate_OnlyFormat(){
           dateFormat=new SimpleDateFormat("dd/MM/yyyy");
           currentDate=new Date();
             Date=dateFormat.format(currentDate);
             return Date;
          }
         
         @SuppressWarnings("deprecation")
		public String AddMonthFormat(){
            DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
            Date currentDate=new Date();
            currentDate.setMonth(currentDate.getMonth() + 11);
            String Date=dateFormat.format(currentDate);
            return Date;
           }


       public void takeAScreenshot(String FileName) throws IOException{
    	   try{
    	    File directory=makeDirectory(FileName);
    	    String Date=UseDateFormat();
    	    File snapshot =((TakesScreenshot)uidriver).getScreenshotAs(OutputType.FILE);
    	    FileUtils.copyFile(snapshot, new File(directory+"/"+FileName+"_"+Date+".jpg"));
    	   }
    	   catch(Exception e){
    		System.out.println("Issue in snapshot creation");
    	   }
       }
       public String UseDateFormat(){
    	  dateFormat=new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
    	  currentDate=new Date();
          Date=dateFormat.format(currentDate);
          return Date;
       }
       
       public String getSystemDate(){
      	  dateFormat=new SimpleDateFormat("dd/MM/yyyy");
      	  currentDate=new Date();
            Date=dateFormat.format(currentDate);
            String systemDate=Date;
            return systemDate;
         }

		public String changeDateInSimpleFormat(String date){    	 
      	 dateFormat=new SimpleDateFormat("dd/MM/yyyy");
      	 String parserFormat=read.getCountrySpecificValue("joinedDateFormat");
      	 SimpleDateFormat parser=new SimpleDateFormat(parserFormat);
      	 Date parsedDate=null;
      	  try {
      		  parsedDate=parser.parse(date);
      	  } 
      	  catch (ParseException e) {
      		logger.info("Error while parsing the date");
      	  }
            String formattedDate=dateFormat.format(parsedDate);
            return formattedDate;
         }

       public String getFutureDate(){
     	  dateFormat=new SimpleDateFormat("dd/MM/yyyy");
     	  currentDate=new Date();
           Date=dateFormat.format(currentDate);
           Date newDate=addDays(currentDate,3);
           String futureDate=dateFormat.format(newDate);
           return futureDate;
        }
       @SuppressWarnings("deprecation")
	public String getSystemTime(){
    	   currentDate=new Date();
    	   StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(currentDate.getHours());
		stringBuilder.append(":");
		stringBuilder.append(currentDate.getMinutes());
		stringBuilder.append(":");
		stringBuilder.append(currentDate.getSeconds());
		String time=(stringBuilder.toString());
    	   return time;
       }
       
       public String getCurrentDate(){
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
           Date date1 =new Date();
           String localDate =sdf.format(date1);
           return localDate;
       }
     
           public static Date addDays(Date date, int days)
           {
               Calendar cal = Calendar.getInstance();
               cal.setTime(date);
               cal.add(Calendar.DATE, days); //minus number would decrement the days
               return cal.getTime();
           }
      
       public int UseDateOnlyFormat(String deldate) throws ParseException{
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
           Date date1 =new Date();
           LocalDate localDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           LocalDate localDate1;
           int day1=localDate.getDayOfMonth();
           Date date2= sdf.parse(deldate);
           localDate1=date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           int day2=localDate1.getDayOfMonth();
           
        
           int difference =day2-day1;
           return difference;
}

       public File makeDirectory(String FileName){
    	   directory=new File("../SiebelMCRMAutomation/Screenshots/" +FileName);
    	   if(!directory.exists())
    		   directory.mkdir();
    	   else
    		   System.out.println("Directory Already exists");
    	   return directory;
       }
/*Screenshot,DateFormat functions,Make Directory Functions, EndRegion*/   
 
 /*Get UI text, Start region*/
     public String getTextByXpath(String locator){
    	 waitForUIElementByxpath(locator);
  	   WebElement element=uidriver.findElement(By.xpath(locator));
		return	element.getText();  
		}
 /*Get UI text, End region*/  
     
/*Check presence of UI element, Start region*/
     public boolean elementCheckByXpath(String locator){
		  try
		    {
			  logger.info("Checking locator " + locator);
		        uidriver.findElement(By.xpath(locator));
		        return true;
		    }
		    catch (Exception e)
		    {
		        return false;
		    }
	}
     public boolean elementCheckByLinkText(String locator){
 		try
 		{
 			uidriver.findElement(By.linkText(locator));
 			return true;
 		}
 		catch (Exception e)
 		{
 			return false;
 		}
 	}
     public boolean elementCheckBycssSelector(String locator){
 		  try
 		    {
 		        uidriver.findElement(By.cssSelector(locator));
 		        return true;
 		    }
 		    catch (Exception e)
 		    {
 		        return false;
 		    }
 	}
     
     public boolean elementCheckByxpathlist(String locator){
		  try
		    {
			  Thread.sleep(2000);
			  uidriver.findElements(By.xpath(locator));  
//			  uidriver.findElement(By.cssSelector(locator));
		        return true;
		    }
		    catch (Exception e)
		    {
		        return false;
		    }
	}
     
     public boolean elementCheckBycssSelectorlist(String locator){
		  try
		    {
			  Thread.sleep(2000);
			  uidriver.findElements(By.xpath(locator));  
//			  uidriver.findElement(By.cssSelector(locator));
		        return true;
		    }
		    catch (Exception e)
		    {
		        return false;
		    }
	}
     
     public boolean checkButtonDisabledbyxpath(String locator)
		{
			try{
				WebElement button=getElementbyxpath(locator);
				String disabled=button.getAttribute("disabled");
				if(disabled.equalsIgnoreCase("disabled") || disabled.equalsIgnoreCase("true"))
					return true;
				else
					return false;
			}
			catch(Exception e)
			{
				return false;
			}
		}
     
     public boolean checkElementDisabledBycssSelector(String locator){
 		try{
 			WebElement element=uidriver.findElement(By.cssSelector(locator));
 			if(element.getAttribute("disabled").contains("disabled"));
 				return true;				
 		}
 		catch(Exception e){
 			return false;
 		}
 	}
/*Check presence of UI element, End region*/
     
/*Keyboard functions, Start region*/
     public void pressEnter(){
         Keyboard kb = ((RemoteWebDriver)uidriver).getKeyboard();
         kb.pressKey(Keys.ENTER);
  }
     public void pressCtrlPlusS(){
         new Actions(uidriver)
            .sendKeys(Keys.chord(Keys.CONTROL, "s"))
            .perform();
   }
     public void pressCtrlPlusD(){
         new Actions(uidriver)
            .sendKeys(Keys.chord(Keys.CONTROL, "d"))
            .perform();
   }
     public void pressCtrlPlusB(){
         new Actions(uidriver)
            .sendKeys(Keys.chord(Keys.CONTROL, "b"))
            .perform();
   }
     public void pressTab(){
         Keyboard kb = ((RemoteWebDriver)uidriver).getKeyboard();
         kb.pressKey(Keys.TAB);
  }
     public void pressSpace(){
         Keyboard kb = ((RemoteWebDriver)uidriver).getKeyboard();
         kb.pressKey(Keys.SPACE);
  }
/*Keyboard functions, End region*/
     
/*Scroll functions, Start region*/
 public void makeElementViewByxpath(String locator) throws Exception{
	 WebElement element = uidriver.findElement(By.xpath(locator));
		((JavascriptExecutor) uidriver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
//	 JavascriptExecutor jsx = (JavascriptExecutor) uidriver;
//	 jsx.executeScript("window.scrollBy(30,0)", "");
 }
 
 public void makeElementViewBycssSelector(String locator) throws Exception{
	 WebElement element = uidriver.findElement(By.cssSelector(locator));
		((JavascriptExecutor) uidriver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
//	 JavascriptExecutor jsx = (JavascriptExecutor) uidriver;
//	 jsx.executeScript("window.scrollBy(30,0)", "");
 }
 
 public void makeElementViewBylinkText(String locator) throws Exception{
	 WebElement element = uidriver.findElement(By.linkText(locator));
		((JavascriptExecutor) uidriver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
 }
 
 public void scrollDown() throws Exception{
	 JavascriptExecutor jsx = (JavascriptExecutor) uidriver;
	//Vertical scroll - down by 100 pixels
	jsx.executeScript("window.scrollBy(0,100)", "");
 }
 
 public void scrollUp() throws Exception{
	 JavascriptExecutor jsx = (JavascriptExecutor) uidriver;
	//Vertical scroll - down by 100 pixels
	jsx.executeScript("window.scrollBy(0,-55)", "");
 }
 
 public void sendEnterKeyByXpath(String locator){
	 WebElement element= uidriver.findElement(By.xpath(locator));
	 element.sendKeys(Keys.ENTER);
 }
 
 public void sendEnterKeyByCss(String locator){
	 WebElement element= uidriver.findElement(By.cssSelector(locator));
	 element.sendKeys(Keys.ENTER);
 }

 public String getGreyedOutValueByCss(String locator){
	 logger.info("Getting value of locator " + locator);
	 WebElement element= uidriver.findElement(By.cssSelector(locator));
		return element.getAttribute("value");
	} 
 
 public String getGreyedOutValueByXpath(String locator){
	 	logger.info("Getting value of locator " + locator);
		WebElement element= uidriver.findElement(By.xpath(locator));
		return element.getAttribute("value");
	}
/*Scroll functions, End region*/     

/*Check if element clickable, start region*/
 public boolean elementClickableCssSelector(String locator){
     try
       {
           uidriver.findElement(By.cssSelector(locator)).click();
           return true;
       }
       catch (Exception e)
       {
           return false;
       }
}
 /*Check if element clickable, end region*/
}