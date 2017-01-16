package flows;

import org.openqa.selenium.WebDriver;

import pages.BookAFlight;
import pages.FlightConfirmation;
import pages.FlightFinder;
import pages.Register;
import pages.SelectFlight;
import pages.SignOn;

public class MercuryToursFlow {
	
	public void mercuryTours(WebDriver driver) throws Exception{
		// Pages
		try {
			new Register().registration(driver);
		//	 new SignOn().login(driver);
			 new FlightFinder().findFlights(driver);
			 new SelectFlight().selectFlight(driver);
			 new BookAFlight().bookFlight_Passengers(driver);
			 new BookAFlight().bookFlight_CreditCard(driver);
			 new FlightConfirmation().confirmation(driver);
		
			 
		} catch (Exception e) {
 			e.printStackTrace();
 			throw e;
		}
	}

}
