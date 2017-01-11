package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import data.TestDataPool;
import infra.SeleniumDescriptive;
import pageObjects.PO_FlightFinder;
import utils.ReportUtils;

public class FlightFinder {
	
	
	public void findFlights(WebDriver driver){
		
	SeleniumDescriptive sd = new SeleniumDescriptive();
	HashMap<String,String> h = new HashMap();
	h = TestDataPool.rowData;
	
	
		// Flight Finder

	 	sd.clickLink(driver,PO_FlightFinder.LINK_FLIGHTS ); //LINK_FLIGHTS= "//a[contains(text(),'Flights')]"
	//	driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();

		// Flight Details

		sd.selectDropdown(driver, PO_FlightFinder.DROPDOWN_PASSENGERSCOUNT, "2");//Hybrid approach
		
		//Select passengers=new Select(driver.findElement(By.xpath("//select[contains(@name,'passCount')]")));
		//passengers.selectByVisibleText("2");

		Select fromPort=new Select(driver.findElement(By.xpath("//select[contains(@name,'fromPort')]")));
		fromPort.selectByIndex(2);

		Select fromMonth=new Select(driver.findElement(By.xpath("//select[contains(@name,'fromMonth')]")));
		fromMonth.selectByValue("3");

		Select fromDay=new Select(driver.findElement(By.xpath("//select[contains(@name,'fromDay')]")));
		fromDay.selectByIndex(6);

		Select toPort=new Select(driver.findElement(By.xpath("//select[contains(@name,'toPort')]")));
		toPort.selectByVisibleText("Portland");

		Select toMonth=new Select(driver.findElement(By.xpath("//select[contains(@name,'toMonth')]")));
		toMonth.selectByValue("7");

		Select toDay=new Select(driver.findElement(By.xpath("//select[contains(@name,'toDay')]")));
		toDay.selectByIndex(10);

		//Preferences


		sd.selectRadiobutton(driver, PO_FlightFinder.radio_ServiceClass(h.get("ServiceClass")));
		//driver.findElement(By.xpath("//input[contains(@name,'servClass') and contains (@value,'First')]")).click(); //  //input[contains(@name,'servClass') and contains (@value,'First')]
		 
		//select[contains(@name,'airline')]
		Select airline=new Select(driver.findElement(By.xpath("//select[contains(@name,'airline')]")));
		airline.selectByVisibleText("Unified Airlines");
		//input[contains(@name,'findFlights')]
		
		// Report
		ReportUtils.reportResult("Pass", "Flight Finder", "Flight Finder has been successfully displayed!");

		
		driver.findElement(By.xpath("//input[contains(@name,'findFlights')]")).click();
 	
		
	}

}
