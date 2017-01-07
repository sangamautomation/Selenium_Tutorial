package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.Constants;
import utils.ReportUtils;
import utils.ScreenshotUtils;

public class Register {

	/**
	 * registration - Register the person 
	 * @param driver
	 * @throws Exception
	 */
	public void registration(WebDriver driver) throws Exception{
		//********************** Registration *******************
		try {
			driver.findElement(By.partialLinkText("REGIST")).click(); //Click on Register link
			driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).clear(); 
			driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys("Vijay"); //Type FirstName
			driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).clear(); 
			driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("Reddy"); //Type last name
			driver.findElement(By.xpath("//input[contains(@name,'phone')]")).clear(); 
			driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("123-456-7890"); //Type phone number 
			driver.findElement(By.cssSelector("input#userName")).clear();  //By mistake, Dev has given Email field's id as 'userName', it's supposed to be 'email'
			driver.findElement(By.cssSelector("input#userName")).sendKeys("vijay@gmail.com"); //Type email
			driver.findElement(By.name("address1")).clear();
			driver.findElement(By.name("address1")).sendKeys("123 Main St");	
			driver.findElement(By.name("city")).clear();
			driver.findElement(By.name("city")).sendKeys("Jersey City");	
			driver.findElement(By.name("state")).clear();
			driver.findElement(By.name("state")).sendKeys("NJ");	
			driver.findElement(By.name("postalCode")).clear();
			driver.findElement(By.name("postalCode")).sendKeys("00902");
			WebElement ele = driver.findElement(By.xpath("//select[contains(@name,'country')]"));
			Select sel = new Select(ele);
			sel.selectByVisibleText("INDIA"); 
			//sel.selectByValue("92"); 
			//sel.selectByIndex(1); 
			driver.findElement(By.id("email")).sendKeys("user1"); //By mistake, Dev has given Username's field's id as 'email' instead of 'userName'
			driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("Password123");
			driver.findElement(By.xpath("//input[contains(@name,'confirmPassword')]")).sendKeys("Password123");
			
			ReportUtils.reportResult("Pass", "Registration", "Registration is successful!");
			
			driver.findElement(By.xpath("//input[contains(@name,'register')]")).click();
			Thread.sleep(5000); // Wait to see the confirmation screen

		} catch (Exception e) {
 			e.printStackTrace(); //Debug and investigate the exception from console logs
 			throw e; // Throw the exception 
		}

	}
}
