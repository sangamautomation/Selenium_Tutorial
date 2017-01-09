package pages_HardCoded;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ReportUtils;
import utils.StringUtils;

public class FlightConfirmation {

	public void confirmation(WebDriver driver){
	//Flight Confirmation - Validation
		
		String confirmationMessage_Expected = "Your itinerary has been booked!"; //Business Rule/Req
		String confirmationMessage_Actual = driver.findElement(By.xpath("//table//tbody//tr//td//p//font//b//font[contains(text(),'itinerary has been booked')]")).getText();

		/*	if(confirmationMessage_Expected.equals(confirmationMessage_Actual))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		 */
		StringUtils.compare(confirmationMessage_Expected, confirmationMessage_Actual);

		String toPrice = driver.findElement(By.xpath("//table/tbody/tr[3]/td/font")).getText(); // Technique: Mention exact row number to avoid multiple matches
		int beginIndex= toPrice.indexOf("$"); //eg. 43
		toPrice = toPrice.substring(beginIndex) ;//$270 each
		int endIndex= toPrice.indexOf(" "); //eg. 3
 		toPrice = toPrice.substring(0, endIndex); //$270
 		toPrice = toPrice.replace("$","");
 		
 		int toPriceInt =  Integer.parseInt(toPrice);
 		
 		System.out.println("toPrice = "+toPrice);
		
		String fromPrice = driver.findElement(By.xpath("//table/tbody/tr[5]/td/font")).getText();
		int bIndex= fromPrice.indexOf("$"); //eg. 43
		fromPrice = fromPrice.substring(bIndex) ;//270 each
		int eIndex= fromPrice.indexOf(" "); //eg. 3
		fromPrice = fromPrice.substring(0, eIndex); //$270
		fromPrice = fromPrice.replace("$","");
		
		int fromPriceInt = Integer.parseInt(fromPrice);
		
		System.out.println("fromPrice = "+fromPrice);
		
	   String noPassengers=driver.findElement(By.xpath("//table/tbody/tr/td/font[contains(text(),'passengers')]")).getText();
	   
	   int index=noPassengers.indexOf(" ");
	   noPassengers=noPassengers.substring(0, index);//2 passengers
	   
	   int noP=Integer.parseInt(noPassengers);
	   
	   System.out.println("Number of passengers="+noP);
		
	   String Totaltaxes = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]/font/font/font/b/font[contains(text(),'USD')]")).getText();
	   //$89 USD -- 89
	   Totaltaxes = Totaltaxes.substring(1, Totaltaxes.indexOf(" "));
	   int Totaltaxesint = Integer.parseInt(Totaltaxes);
	   System.out.println("Totaltaxesint = "+Totaltaxesint);

	String totalPrice=    driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/font/b/font/font/b/font")).getText();//$1175 USD
	   totalPrice = totalPrice.substring(1, totalPrice.indexOf(" "));
	   int totalPriceint = Integer.parseInt(totalPrice);
	   
	   System.out.println("totalPriceint = "+totalPriceint);
	   
	   // Confirmation #
	 
	   String confirmNo = driver.findElement(By.xpath("//table/tbody/tr/td[1]/b/font/font/b/font[1][contains ( text(), 'Confirmation')]")).getText();
	   if(("Flight Confirmation # 2017-01-05183104").matches("[a-zA-Z]+ [a-zA-Z]+ # ((19|20)\\d{2})-[0-9]{2}-[0-9]{2}\\d{6}"))	
		   System.out.println("Confirmation number matches the pattern per business requirement");
	   else
		   System.out.println("Confirmation number matches the pattern per business requirement");

	   // FINAL Calculation
	   
	   if (totalPriceint == (toPriceInt+fromPriceInt)*2+Totaltaxesint) {
 		ReportUtils.reportResult("Pass", "Total Price", "Total Price is calculated correctly!");
	   }
		else
		{
 		ReportUtils.reportResult("Fail", "Total Price", "Total Price is NOT calculated correctly!");
		}
	}

 

}
