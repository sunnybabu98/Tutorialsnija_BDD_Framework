package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.Loginpage;
import utlity.DataUtil;
import utlity.MyXLSReader;

public class LoginTest extends Base {
	WebDriver driver;
	MyXLSReader excelReader;
	
	@AfterClass
	public void tearDown() {
	    if (this.driver != null) {
	        this.driver.quit();
	    }
	}

	
	
    @Test(dataProvider="dataSupplier")
	public void Testlogin(HashMap<String,String> hMap) {
    	
    	
    	if(!DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {
    		throw new SkipException("Run mode is set to N, hence not Executed");
    	}
   driver = openBrowserApplicationurl(hMap.get("Browser"));
   HomePage homepage = new HomePage(driver);
   homepage.clickonmyaccountdropmenu();
   Loginpage loginpage = homepage.selectLoginoption();
   loginpage.enterEmailAddress(hMap.get("Username"));
   loginpage.enterpassword(hMap.get("Password"));
   AccountPage accountPage = loginpage.clickonloginbutton();
   
    
    
    
    
    String expectedResult = hMap.get("ExpectedResult");
    
    boolean expectedConvertResult = false;
    
    if(expectedResult.equalsIgnoreCase("Success")) {
    
    	  expectedConvertResult = true;
    }else if(expectedResult.equalsIgnoreCase("failure")) {
        
  	  expectedConvertResult = false;
  }
    
    boolean actualResult = false;
    
     actualResult = accountPage.verifyTheDisplayEditYourAccountinormationOption();
 
    	
    
    
    Assert.assertEquals(actualResult, expectedConvertResult);
    
   
	}
    @DataProvider
    public Object[][] dataSupplier()  {
    	Object[][] data = null;
    	try {
    	 excelReader = new MyXLSReader("src\\test\\resourcess\\TutorialsNinja.xlsx");	
    	data = DataUtil.getTestData(excelReader, "LoginTest", "Data");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return data;
    }
    
}
