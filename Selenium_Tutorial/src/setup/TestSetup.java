/**
 * Date: Jan 1, 2017
 * Author: Work
 * TestCase: TestSetup.java
 * Description: 
 */
package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSetup {
	
	public TestSetup(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Drivers\\drivers\\chromedriver.exe");
 	}
	private static WebDriver driver = new ChromeDriver();
	private static WebDriver driver_Firefox = new FirefoxDriver();

	public static WebDriver getDriver(){
		return driver;
	}

}
