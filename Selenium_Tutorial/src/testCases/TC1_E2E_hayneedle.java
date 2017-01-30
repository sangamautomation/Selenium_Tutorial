package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import infra.SeleniumDescriptive;
import setup.TestRunSetup;
import setup.TestSetup;
import utils.KeyboardUtils;

/**
 * Test Case Description: 
 */
public class TC1_E2E_hayneedle {

	public static void main(String[] args) throws Exception {
		WebDriver driver =null;
		KeyboardUtils k = new KeyboardUtils();
		try {
			//********* Declarations ***********
			
			String URL = "http://www.hayneedle.com/";
			SeleniumDescriptive sd = new SeleniumDescriptive();
			
		//	System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Drivers\\drivers\\geckodriver.exe");
		//	driver = new FirefoxDriver();
	 		//	driver.manage().window().maximize();

			driver = TestSetup.launchBrowser("Chrome");
		
					
			driver.get(URL);
			//driver.navigate().to(URL);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			try {
				sd.clickLink(driver, "//div[text()='no thanks']");
			} catch (Exception e) {
 				e.printStackTrace();
 				System.out.println("There is no popup...");
			}
			
			//Thread.sleep(10000);
			
			// Transactions - Create Account
	 		driver.findElement(By.xpath("//span[text()='Account']")).click();
	 		SeleniumDescriptive.clickLink(driver, "//*[@id='HN_Accounts_DD']/ul/li[5]/a[contains(text(),'Create an Account')]");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(10000);
		  	sd.setText(driver, "//div//div//div[contains(@account-data,'account')]//form//div//input[contains(@id,'email')]", "Abcdef@gmail.com"); //webdriver+xpath option
		  	sd.setText(driver, "//input[contains(@id,'password')]", "Automation@123");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  	sd.clickLink(driver, "//button[contains(text(),'Sign In')]");
		  	
 		// 	k.type("Abcdef@gmail.com"); //robot option

	 		
			// Sign in (using Robot) as Xpath has conflict
		/*	Robot r = new Robot();
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);*/
		
		
			// Search
			sd.setText(driver, "//input[@ng-model='searchQuery']", "jewelry");
			sd.clickLink(driver, "//form[@id='searchCatPri']/button");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
				
	//		sd.clickLink(driver,"//img[contains(@src,'MHF2444.jpg')]");   //span[contains(text(),'under $150')]   //img[@alt='Armoires under $150']
			
			 Thread.sleep(1000000);;
			 
			//div[@id="main_content_inner_div"]/div[2]/div[1]//div[@id="sign-in-container"]//form[@id="hnSignIn"]//div[@id="hnSignIn"]/div[3]//input[contains(@id,'email')]
 			//div//div//div[contains(@account-data,'account')]//form//div//input[contains(@id,'email')]
		} catch (Exception e) {
 			e.printStackTrace();
 			throw e;
		}
		
		
		driver.quit();

	}

}
