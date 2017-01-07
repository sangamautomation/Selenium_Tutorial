package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.ReportUtils;

public class BookAFlight {
	
	public void bookFlight_Passengers(WebDriver driver){
		// Book A Flight
				//Passengers
				driver.findElement(By.xpath("//input[contains(@name,'passFirst0')]")).sendKeys("John");
				driver.findElement(By.xpath("//input[contains(@name,'passLast0')]")).sendKeys("Smith");

				driver.findElement(By.xpath("//input[contains(@name,'passFirst1')]")).sendKeys("Mary");
				driver.findElement(By.xpath("//input[contains(@name,'passLast1')]")).sendKeys("Smith");
	
	}
	public void bookFlight_CreditCard(WebDriver driver){
	 
		//Credit Card
		new Select(driver.findElement(By.xpath("//select[contains(@name,'creditCard')]"))).selectByVisibleText("Discover");
		driver.findElement(By.xpath("//input[contains(@name,'creditnumber')]")).sendKeys("1234567890123456"); //16-Digits
		new Select(driver.findElement(By.xpath("//select[contains(@name,'cc_exp_dt_mn')]"))).selectByVisibleText("05");
		new Select(driver.findElement(By.xpath("//select[contains(@name,'cc_exp_dt_yr')]"))).selectByVisibleText("2010");

		driver.findElement(By.xpath("//input[contains(@name,'cc_frst_name')]")).sendKeys("John");
		driver.findElement(By.xpath("//input[contains(@name,'cc_last_name')]")).sendKeys("Smith");
		
		ReportUtils.reportResult("Pass", "Book A Flight ", "Book A Flight page has been successfully displayed!");

		
		driver.findElement(By.xpath("//input[contains(@name,'buyFlights')]")).click();

		}

}
