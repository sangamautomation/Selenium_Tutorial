package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.TestDataPool;
import infra.SeleniumDescriptive;
import pageObjects.PO_SignOn;
import utils.ReportUtils;
import utils.StringUtils;

public class SignOn {

	/**
	 * login - Login into Flight Reservation application using credentials provided during registration
	 * @param driver
	 * @throws Exception 
	 */
	SeleniumDescriptive sd = new SeleniumDescriptive();

	public void login(WebDriver driver) throws Exception{
		HashMap<String,String> h = new HashMap<>();		
 		h = TestDataPool.rowData;	
		try {
			//Expected Values
			String confirmationText_FNLN_Expected = h.get("FirstName")+ " "+ h.get("LastName")  ;//"Vijay Reddy";
			String confirmationText_UN_Expected = h.get("UserName");// "user1";
			String confirmationText_FNLN_Actual = null;
			String confirmationText_UN_Actual = null ;
			//Capaturing Text From WebPage
			sd.getWidgetText(driver, PO_SignOn.TEXT_confirmationText_FNLN_Actual);
		//	String confirmationText_FNLN_Actual = driver.findElement(By.xpath("//table/tbody/tr[3]/td/p[1]/font/b")).getText();
			sd.getWidgetText(driver, PO_SignOn.TEXT_confirmationText_UN_Actual);
 		//	String confirmationText_UN_Actual = driver.findElement(By.xpath("//table/tbody/tr[3]/td/p[3]/a/font/b")).getText();

			confirmationText_FNLN_Actual= confirmationText_FNLN_Actual.replace(",", "");//Dear Vijay Reddy
			confirmationText_FNLN_Actual= confirmationText_FNLN_Actual.substring(5);//Vijay Reddy

			confirmationText_UN_Actual=confirmationText_UN_Actual.replace(".", ""); //Note: Your user name is user1.
			confirmationText_UN_Actual=confirmationText_UN_Actual.substring(24);


			//Validation
			boolean flag_fnln = StringUtils.compare(confirmationText_FNLN_Expected, confirmationText_FNLN_Actual);
			boolean flag_un = StringUtils.compare(confirmationText_UN_Expected, confirmationText_UN_Actual);

			if (flag_fnln)  
				ReportUtils.reportResult("Pass", "Validation on FN/LN", "Registration is successful for FN LN!");
			else
				ReportUtils.reportResult("Fail", "Validation on FN/LN", "Registration is NOT successful FN LN!");

			if (flag_un)  
				ReportUtils.reportResult("Pass", "Validation on UN", "Registration is successful for UN!");
			else
				ReportUtils.reportResult("Fail", "Validation on UN", "Registration is NOT successful for UN!");

			 


			Thread.sleep(5000);

			driver.findElement(By.linkText("sign-in")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}


	}

}
