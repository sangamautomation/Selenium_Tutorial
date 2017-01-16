package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class PO_FlightFinder {
	//Fields
	public static final String DROPDOWN_PASSENGERSCOUNT=  "//select[contains(@name,'passCount')]";
	public static final String LINK_FLIGHTS= "//a[contains(text(),'Flights')]";
	
	public static final String DROPDOWN_FROMPORT = "//select[contains(@name,'fromPort')]"; ////table/tbody/tr[2]/td[2]/font/b/font/font/b/font
	public static final String DROPDOWN_FROMMONTH = "//select[contains(@name,'fromMonth')]";
	public static final String DROPDOWN_FROMDAY = "//select[contains(@name,'fromDay')]";
	public static final String DROPDOWN_TOPORT = "//select[contains(@name,'toPort')]";
	public static final String DROPDOWN_TOMONTH = "//select[contains(@name,'toMonth')]";
	public static final String DROPDOWN_TODAY = "//select[contains(@name,'toDay')]";
	public static final String DROPDOWN_AIRLINES = "//select[contains(@name,'airline')]";
	public static final String LINK_FINDFLIGHTS = "//input[contains(@name,'findFlights')]";

	
  
   
	//Methods (Returning dynamic xpath values)
 	public static String radio_ServiceClass(String value){
		return "//input[contains(@name,'servClass') and contains (@value,'"+value+"')]";//First
	}
}
