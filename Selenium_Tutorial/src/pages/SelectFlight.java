package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.ReportUtils;

public class SelectFlight {
	
	public void selectFlight(WebDriver driver){
	
	//******************* Select Flight ****************************

	//Depart
	driver.findElement(By.xpath("//td[contains(@class,'frame_action_xrows')]//input[contains(@value, 'Blue Skies Airlines$360') and contains(@name,'outFlight')]")).click();

	//Return
	driver.findElement(By.xpath("//td[contains(@class,'frame_action_xrows')]//input[contains(@value, 'Blue Skies Airlines$631') and contains(@name,'inFlight')]")).click();
 	
	ReportUtils.reportResult("Pass", "Select Flight", "Select Flight has been successfully displayed!");
 	
	// Click on Continue Button
	driver.findElement(By.xpath("//input[contains(@name,'reserveFlights')]")).click();


	}
	
}
