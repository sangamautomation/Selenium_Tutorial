package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import setup.TestSetup;

public class SeleniumTest {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {
 			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Drivers\\drivers\\chromedriver.exe");
 			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Drivers\\drivers\\geckodriver.exe");

 				driver = new ChromeDriver(); //Chrome
	/*	 	driver = new FirefoxDriver(); //Firefox
		 	driver = new MarionetteDriver();
 		 	driver = new InternetExplorerDriver(); //IE
	*/				
 		// TestSetup.getDriver().findElement(By.xpath("dfsdf")).clear();
			driver.manage().window().maximize();
			Thread.sleep(1000);
			//driver.get("https://www.google.com");
			driver.navigate().to("http://www.kayak.com");
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			//driver.close();
			System.out.println("Entered finally block!");
		}
	}

}
