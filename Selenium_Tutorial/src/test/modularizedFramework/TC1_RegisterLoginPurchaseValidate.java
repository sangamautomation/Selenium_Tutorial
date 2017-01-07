package test.modularizedFramework;

import org.openqa.selenium.WebDriver;

import flows.MercuryToursFlow;
import setup.TestRunSetup;
import setup.TestSetup;

public class TC1_RegisterLoginPurchaseValidate {

	public static void main(String[] args) throws Exception{
		WebDriver driver = null;
		MercuryToursFlow mt = new MercuryToursFlow();
		
		try {
			//Test Setup
			String browser = args[0];
 			String URL = args[1]; //"http://demoaut.com/";
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
