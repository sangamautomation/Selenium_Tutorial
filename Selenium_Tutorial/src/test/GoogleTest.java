package test;

 import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.StringUtils;

public class GoogleTest {
	/**
	 * Date Dec 30, 2016
	 * Author SeleniumAutomationEngineer
	 * TestCase: GoogleTest.java
	 * Description: Test case will 
	 *  1. load website: google.com 
		2. type "Say Cheese!" in the search bar & submit search
		3. Read the title of the page
		4. get it & Store it in a String variable
		5. print it to console
		Expected Result: Browser title should be displayed as "Say Cheese! - Google Search"

		Enhancements: 1.Take Screenshot
		 			  2.Validate the Result: Compare the Actual Value with Expected Value
					  3.Pass or Fail the Test case
	 */

	public class Test {

	}

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;

		try {
			//System Property set for chrome driver path
			System.setProperty("webdriver.chrome.driver", "D:/Selenium_Drivers\\drivers\\chromedriver.exe");

			//WebDriver Instantiation & Launch Browser
			driver = new ChromeDriver();
			/*WebDriver driver1 = new FirefoxDriver();
			WebDriver driver2 = new InternetExplorerDriver();
			WebDriver driver3 = new OperaDriver();
			WebDriver driver4 = new SafariDriver();
			WebDriver driver5 = new MarionetteDriver();
			WebDriver driver6 = new EdgeDriver();
			 */

			//Launch/Load URL Application
			driver.get("http://www.google.com");

			//Maximize Browser Window
			driver.manage().window().maximize();

			//Wait until the application page loads
			// Thread.sleep(5000); //Static wait 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit Wait with Max Timeout Period


			// Type search criteria in the search field
			//Fetch xpath of search field
			//Get WebElement for XPath of that particular element

			WebElement ele = driver.findElement(By.xpath("//input[contains(@id,'lst-ib')]")); //Xpath of Chrome = //input[contains(@id,'lst-ib')] Xpath of Firefox = //input[id='gs_htif0'] //org.openqa.selenium.NoSuchElementException:

			/*	WebElement ele1 = driver.findElement(By.id("gs_htif0"));
			WebElement ele2 = driver.findElement(By.className(""));
			WebElement ele3 = driver.findElement(By.linkText("Free up space for 2017 with Google Photos"));
			WebElement ele4 = driver.findElement(By.name(""));
			WebElement ele5 = driver.findElement(By.partialLinkText("with Google Photos"));
			WebElement ele6 = driver.findElement(By.tagName(""));
			 */
			//Operate on the WebElement
			ele.sendKeys("Say Cheese!"); //Set the textbox with value

			//Submit the Search Page
			//ele.submit(); //Submit
			//driver.findElement(By.xpath("//span[contains(@class,'sbico')]")).click(); //Clicking on Search button icon
			driver.findElement(By.xpath("//button[contains(@value,'Search')]")).click(); //Clicking on Search button icon


			//Wait
			Thread.sleep(5000);

			//Take Screenshot:
			
			
			Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); // Screensize
			System.out.println(rect.toString());
			BufferedImage image = new Robot().createScreenCapture(rect);//PrintScreen
			System.out.println(image.toString());

			ImageIO.write(image, "jpg", new File("D:\\Selenium_Logs\\Screenshots/sceenshot2.jpg"));

			//Get the Page Title and Store it in String variable
			String pageTitle_Expected="Say Cheese! ";//- Google Search
			String pageTitle_Actual = driver.getTitle(); //Read title of page


			//Print it to Console
			System.out.println("Page title is: "+pageTitle_Actual);

			//Validation
			StringUtils.compare(pageTitle_Expected, pageTitle_Actual );

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			//Close the Browser
			driver.quit();	
		}

	}
}
