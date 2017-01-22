package test.modularizedFramework;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import data.Constants;
import data.TestDataPool;
import flows.MercuryToursFlow;
import setup.TestRunSetup;
import setup.TestSetup;
import utils.DateUtils;
import utils.PropertyUtils;

public class TC1_RegisterLoginPurchaseValidate {

	static String startTestCase;
	static String endTestCase;

	public static void main(String[] args) throws Exception{
		System.out.println("_______________________________ TEST START_________________________");
		
		// Calculating Start Timestamps
		startTestCase = DateUtils.getCurrentTimestamp("MMddyyyy HHmmss");
		System.out.println("Test Started @ "+ startTestCase);

		//Instantiations
		WebDriver driver = null;
		MercuryToursFlow mt = new MercuryToursFlow();
		//	new TestDataPool("TC1_RegisterLoginPurchaseValidate");//XLSX
		
		//Datapool Reading
		new TestDataPool(3);//XLS

		try {
			//Test Setup
			String browser = PropertyUtils.propertyFile_Read(Constants.path_PropertyFile_config, "browserType");
			//String browser = args[0];
			String URL =PropertyUtils.propertyFile_Read(Constants.path_PropertyFile_config, "URL") ; //"http://demoaut.com/";
			//String URL = args[1]; //"http://demoaut.com/";
			
			//Launch Browser & Maximize
			driver = new TestSetup().launchBrowser(browser); 
			
			//Hit URL, Wait for Application to Load
			TestRunSetup.prerequisites(driver, URL);

			//Mercury Tours Flow
			mt.mercuryTours(driver);

			//Calculating End Timestamp
			endTestCase = DateUtils.getCurrentTimestamp("MMddyyyy HHmmss");
			System.out.println("Test Ended @ "+ endTestCase);
		} 
		catch (Exception e) {
			System.out.println("Entered Catch Block...");
			e.printStackTrace();
			throw e; 
		}
		finally{
			System.out.println("~Entered Finally Block...");
			String testDuration = DateUtils.getDateTimeDifference(startTestCase, endTestCase, "MMddyyyy HHmmss");
			System.out.println("Test Duration = "+testDuration);
			System.out.println("_______________________________ TEST END_________________________");
			//driver.close();// Close particular instance of browser 
			driver.quit(); // Close all instances of browser
		}

	}


}
