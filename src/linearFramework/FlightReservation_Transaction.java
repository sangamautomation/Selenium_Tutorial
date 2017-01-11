package linearFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightReservation_Transaction {

	public static void main(String[] args) {
	 
	    System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Drivers\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com"); //AUT = Application Under Test = http://newtours.demoaut.com
		
		//Sign in
		
		WebElement username=driver.findElement(By.name("username"));
		
		username.sendKeys("user1");
		
		driver.findElement(By.name("password")).sendKeys("Password123");
		
		
	}

}
