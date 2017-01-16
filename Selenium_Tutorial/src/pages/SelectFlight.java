package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import data.TestDataPool;
import infra.SeleniumDescriptive;
import pageObjects.PO_SelectFlight;
import utils.ReportUtils;

public class SelectFlight {
	
	SeleniumDescriptive sd = new SeleniumDescriptive();
	
 	public void selectFlight(WebDriver driver){
 		HashMap<String,String> h = new HashMap<>();		
 		h = TestDataPool.rowData;	
 		
	//******************* Select Flight ****************************

	//Depart
	
 	sd.selectRadiobutton(driver, PO_SelectFlight.RADIO_DEPARTFLIGHT);
//	driver.findElement(By.xpath("//td[contains(@class,'frame_action_xrows')]//input[contains(@value, 'Blue Skies Airlines$360') and contains(@name,'outFlight')]")).click();
 	//Return
 	sd.selectRadiobutton(driver, PO_SelectFlight.RADIO_RETURNFLIGHT);
 	//driver.findElement(By.xpath("//td[contains(@class,'frame_action_xrows')]//input[contains(@value, 'Blue Skies Airlines$631') and contains(@name,'inFlight')]")).click();
 	
	ReportUtils.reportResult("Pass", "Select Flight", "Select Flight has been successfully displayed!");
 	
	// Click on Continue Button
	sd.clickLink(driver, PO_SelectFlight.LINK_CONTINUE);
	//driver.findElement(By.xpath("//input[contains(@name,'reserveFlights')]")).click();


	}
	
}
