package pages;

import java.util.HashMap;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import data.TestDataPool;
import infra.SeleniumDescriptive;
import pageObjects.PO_FlightFinder;
import utils.ReportUtils;

public class FlightFinder {
	
	
	public void findFlights(WebDriver driver) throws InterruptedException{
		
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

	//	Thread.sleep(200000);
//JOptionPane.showMessageDialog(null, "Debug it!!!");
		
		sd.selectDropdown(driver, PO_FlightFinder.DROPDOWN_FROMPORT , 2);
//		Select fromPort=new Select(driver.findElement(By.xpath("//select[contains(@name,'fromPort')]")));
//		fromPort.selectByIndex(2);
		
		String DepartingOn = h.get("DepartingOn");//February,10
		String[] fromMonth = DepartingOn.split(",");
		
		sd.selectDropdown(driver, PO_FlightFinder.DROPDOWN_FROMMONTH , fromMonth[0]); //"FEBRUARY"
// 		Select fromMonth=new Select(driver.findElement(By.xpath("//select[contains(@name,'fromMonth')]")));
//		fromMonth.selectByValue("3");

		sd.selectDropdown(driver, PO_FlightFinder.DROPDOWN_FROMDAY , fromMonth[1]);//"10"
//		Select fromDay=new Select(driver.findElement(By.xpath("//select[contains(@name,'fromDay')]")));
//		fromDay.selectByIndex(6);

		sd.selectDropdown(driver, PO_FlightFinder.DROPDOWN_TOPORT , h.get("DepartingFrom")); //"Portland"
//		Select toPort=new Select(driver.findElement(By.xpath("//select[contains(@name,'toPort')]")));
//		toPort.selectByVisibleText("Portland");

		String ReturningOn = h.get("ReturningOn");
		String[] toMonth = ReturningOn.split(",");//March,22

		sd.selectDropdown(driver, PO_FlightFinder.DROPDOWN_TOMONTH , toMonth[0]);
//		Select toMonth=new Select(driver.findElement(By.xpath("//select[contains(@name,'toMonth')]")));
//		toMonth.selectByValue("7");

		sd.selectDropdown(driver, PO_FlightFinder.DROPDOWN_TODAY , toMonth[1]);
//		Select toDay=new Select(driver.findElement(By.xpath("//select[contains(@name,'toDay')]")));
//		toDay.selectByIndex(10);

		//Preferences

		
		sd.selectRadiobutton(driver, PO_FlightFinder.radio_ServiceClass(h.get("ServiceClass")));
		//driver.findElement(By.xpath("//input[contains(@name,'servClass') and contains (@value,'First')]")).click(); //  //input[contains(@name,'servClass') and contains (@value,'First')]
		
		sd.selectDropdown(driver, PO_FlightFinder.DROPDOWN_AIRLINES, h.get("Airline"));
		//select[contains(@name,'airline')]
//		Select airline=new Select(driver.findElement(By.xpath("//select[contains(@name,'airline')]")));
//		airline.selectByVisibleText("Unified Airlines");
		//input[contains(@name,'findFlights')]
		
		// Report
		ReportUtils.reportResult("Pass", "Flight Finder", "Flight Finder has been successfully displayed!");

		sd.clickLink(driver, PO_FlightFinder.LINK_FINDFLIGHTS);
		//driver.findElement(By.xpath("//input[contains(@name,'findFlights')]")).click();
 	
		
	}

}
