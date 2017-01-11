package pageObjects;

public class PO_FlightFinder {
	//Fields
	public static final String DROPDOWN_PASSENGERSCOUNT=  "//select[contains(@name,'passCount')]";
	public static final String LINK_FLIGHTS= "//a[contains(text(),'Flights')]";
	
	//Methods (Returning dynamic xpath values)
 	public static String radio_ServiceClass(String value){
		return "//input[contains(@name,'servClass') and contains (@value,'"+value+"')]";//First
	}
}
