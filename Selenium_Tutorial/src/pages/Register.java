package pages;

import java.util.HashMap;

import org.eclipse.jetty.util.security.Password;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.Constants;
import data.TestDataPool;
import infra.SeleniumDescriptive;
import pageObjects.PO_Register;
import utils.PasswordUtils;
import utils.PropertyUtils;
import utils.ReportUtils;
import utils.ScreenshotUtils;

public class Register {

	/**
	 * registration - Register the person 
	 * @param driver
	 * @throws Exception
	 */
	public void registration(WebDriver driver) throws Exception{
		
		SeleniumDescriptive sd = new SeleniumDescriptive();
		HashMap<String,String> h = new HashMap<>();		
		h = TestDataPool.rowData;	
		
		
				//********************** Registration *******************
		try {
		//	driver.findElement(By.partialLinkText("REGIST")).click(); //Click on Register link
			driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click(); //Click on Register link
 		
			sd.setText(driver, PO_Register.TEXTBOX_FIRSTNAME, h.get("FirstName"));
 			// driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys(h.get("FirstName")); //Type FirstName
		
			sd.setText(driver, PO_Register.TEXTBOX_LASTNAME, h.get("LastName")); // Hybrid (Infra level fn + Page Object Xpath + Datapool parameterization)
			//driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).clear(); 
 			//driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys(h.get("LastName")); //Type last name
			
			sd.setText(driver, PO_Register.TEXTBOX_PHONE, h.get("PhoneNo"));
 			//driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("123-456-7890"); //Type phone number 
			
			
			driver.findElement(By.cssSelector("input#userName")).clear();  //By mistake, Dev has given Email field's id as 'userName', it's supposed to be 'email'
			driver.findElement(By.cssSelector("input#userName")).sendKeys(h.get("Email")); //Type email
 			
			sd.setTextByName(driver, "address1", h.get("Address1"));
 			//driver.findElement(By.name("address1")).sendKeys(h.get("Address1"));	
 
			sd.setTextByName(driver, "city", h.get("City"));
// 			driver.findElement(By.name("city")).clear();
//			driver.findElement(By.name("city")).sendKeys("Jersey City");	
			
			sd.setTextByName(driver, PO_Register.TEXTBOX_STATE, h.get("State"));
// 			driver.findElement(By.name("state")).clear();
//			driver.findElement(By.name("state")).sendKeys("NJ");	
			
			sd.setTextByName(driver, "postalCode", h.get("PostalCode"));
// 			driver.findElement(By.name("postalCode")).clear();
//			driver.findElement(By.name("postalCode")).sendKeys("00902");
			
			sd.selectDropdown(driver, PO_Register.DROPDOWN_COUNTRY, h.get("Country"));
//			WebElement ele = driver.findElement(By.xpath("//select[contains(@name,'country')]"));
//			Select sel = new Select(ele);
//			sel.selectByVisibleText("INDIA"); 
			//sel.selectByValue("92"); 
			//sel.selectByIndex(1); 
			driver.findElement(By.id("email")).sendKeys("user1"); //By mistake, Dev has given Username's field's id as 'email' instead of 'userName'
			
			
			sd.setText(driver, PO_Register.TEXTBOX_USERNAME, h.get("UserName"));
			//driver.findElement(By.xpath("//input[contains(@name,'userName)]")).sendKeys("Prashanthi");
			
			
			String encryptedPassword = PropertyUtils.propertyFile_Read(Constants.path_PropertyFile_config, "password");
			String decryptedPassword = PasswordUtils.decryptString(encryptedPassword);
			
			
			sd.setText(driver, PO_Register.TEXTBOX_PASSWORD, decryptedPassword);
 		//	sd.setText(driver, PO_Register.TEXTBOX_PASSWORD, h.get("Password"));
 		//	driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("Password123");
			sd.setText(driver, PO_Register.TEXTBOX_PASSWORD, PasswordUtils.decryptString(PropertyUtils.propertyFile_Read(Constants.path_PropertyFile_config, "password")));
		//	sd.setText(driver, PO_Register.TEXTBOX_PASSWORD, h.get("Password"));
  		//	driver.findElement(By.xpath(PO_Register.TEXTBOX_CONFIRMPASSWORD)).sendKeys("Password123");
 
 			ReportUtils.reportResult("Pass", "Registration", "Registration is successful!");
			
			// driver.findElement(By.xpath("//input[contains(@name,'register')]")).click();
			sd.clickLink(driver, PO_Register.LINK_REGISTER);
			
			Thread.sleep(5000); // Wait to see the confirmation screen

		} catch (Exception e) {
 			e.printStackTrace(); //Debug and investigate the exception from console logs
 			throw e; // Throw the exception 
		}

	}
}
