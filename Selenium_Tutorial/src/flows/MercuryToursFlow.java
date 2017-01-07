package flows;

import org.openqa.selenium.WebDriver;

import pages.Register;

public class MercuryToursFlow {
	
	public void mercuryTours(WebDriver driver) throws Exception{
		
		try {
			new Register().registration(driver);
			//new SignOn().login();
		} catch (Exception e) {
 			e.printStackTrace();
 			throw e;
		}
	}

}
