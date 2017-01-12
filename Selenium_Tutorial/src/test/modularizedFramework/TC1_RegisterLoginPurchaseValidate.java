package test.modularizedFramework;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import data.Constants;
import data.TestDataPool;
import flows.MercuryToursFlow;
import setup.TestRunSetup;
import setup.TestSetup;
import utils.PropertyUtils;

public class TC1_RegisterLoginPurchaseValidate {

	public static void main(String[] args) throws Exception{
		WebDriver driver = null;
		MercuryToursFlow mt = new MercuryToursFlow();
	//	new TestDataPool("TC1_RegisterLoginPurchaseValidate");//XLSX
		new TestDataPool(3);//XLS

		try {
			//Test Setup
			String browser = PropertyUtils.propertyFile_Read(Constants.path_PropertyFile_config, "browserType");
			//String browser = args[0];
 			String URL =PropertyUtils.propertyFile_Read(Constants.path_PropertyFile_config, "URL") ; //"http://demoaut.com/";
  			//String URL = args[1]; //"http://demoaut.com/";
			driver = new TestSetup().launchBrowser(browser);
 			TestRunSetup.prerequisites(driver, URL);
			
 			//Mercury Tours Flow
 			mt.mercuryTours(driver);
	 		
			
		} catch (Exception e) {
			System.out.println("Entered Catch Block...");
  			e.printStackTrace();
 			throw e; 
		}
		finally{
			System.out.println("Entered Finally Block...");
			//driver.close();// Close particular instance of browser 
			driver.quit(); // Close all instances of browser
		}
		
	}
	
	
}
