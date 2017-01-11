package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import data.TestDataPool;
import infra.SeleniumDescriptive;
import pageObjects.PO_BookAFlight;
import utils.ReportUtils;
 
public class BookAFlight {
	SeleniumDescriptive sd = new SeleniumDescriptive();
	

	public void bookFlight_Passengers(WebDriver driver){
		HashMap<String,String> h = new HashMap<String,String>();		
		h = TestDataPool.rowData;	
	//	h.put("MiddleName", "Jones");
		
		// Book A Flight
				//Passengers
				sd.setText(driver, PO_BookAFlight.TEXTBOX_FIRSTNAME1, h.get("FirstName")); //Reusable using Encapsulation
				//driver.findElement(By.xpath("//input[contains(@name,'passFirst0')]")).sendKeys(h.get("FirstName")); // Non-Resuable

				sd.setText(driver, PO_BookAFlight.TEXTBOX_LASTNAME1, h.get("LastName")); //Framework code
				//driver.findElement(By.xpath("//input[contains(@name,'passLast0')]")).sendKeys("Smith"); // Raw code

				sd.setText(driver, PO_BookAFlight.TEXTBOX_FIRSTNAME2, h.get("FirstName2"));
				//driver.findElement(By.xpath("//input[contains(@name,'passFirst1')]")).sendKeys("Mary");
				
				sd.setText(driver, PO_BookAFlight.TEXTBOX_LASTNAME2, h.get("LastName2"));
				//driver.findElement(By.xpath("//input[contains(@name,'passLast1')]")).sendKeys("Smith");
	
	}
	public void bookFlight_CreditCard(WebDriver driver){
		HashMap<String,String> h = new HashMap<String,String>();		
		h = TestDataPool.rowData;	
		//Credit Card
		
		sd.selectDropdown(driver, PO_BookAFlight.DROPDOWN_CREDITCARDTYPE, h.get("CreditcardType"));
		//new Select(driver.findElement(By.xpath("//select[contains(@name,'creditCard')]"))).selectByVisibleText("Discover");
		
		driver.findElement(By.xpath("//input[contains(@name,'creditnumber')]")).sendKeys("1234567890123456"); //16-Digits
		
		String credicardExp = h.get("CredicardExp");
		String[] ccExp=credicardExp.split("-"); //12-2010   -> ccExp[0] = "12", ccExp[1]= "2010"
		
		
		sd.selectDropdown(driver, PO_BookAFlight.DROPDOWN_CREDITCARDEXPIRATIONMONTH, ccExp[0]);
	 	//new Select(driver.findElement(By.xpath("//select[contains(@name,'cc_exp_dt_mn')]"))).selectByVisibleText("05");
		
		sd.selectDropdown(driver, PO_BookAFlight.DROPDOWN_CREDITCARDEXPIRATIONYEAR, ccExp[1]);
		//new Select(driver.findElement(By.xpath("//select[contains(@name,'cc_exp_dt_yr')]"))).selectByVisibleText("2010");

		driver.findElement(By.xpath("//input[contains(@name,'cc_frst_name')]")).sendKeys("John");
		driver.findElement(By.xpath("//input[contains(@name,'cc_last_name')]")).sendKeys("Smith");
		
		ReportUtils.reportResult("Pass", "Book A Flight ", "Book A Flight page has been successfully displayed!");

		
		driver.findElement(By.xpath("//input[contains(@name,'buyFlights')]")).click();

		}

}
