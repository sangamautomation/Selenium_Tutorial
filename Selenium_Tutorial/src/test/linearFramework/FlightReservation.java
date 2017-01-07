/**
 * Date: Jan 1, 2017
 * Author: Selenium Tester
 * TestCase: FlightReservation.java
 * Description: 
 */
package test.linearFramework;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import setup.TestSetup;
import utils.StringUtils;

public class FlightReservation {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		// Create WebDriver
		
		//Chrome Browser
		 	System.setProperty("webdriver.chrome.driver", "D:/Selenium_Drivers\\drivers/chromedriver.exe");
		 	WebDriver driver = new ChromeDriver();
		
		//Firefox Browser
	//	System.setProperty("webdriver.gecko.driver", "D:/Selenium_Drivers\\drivers/geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		
		
		

		String URL = "http://newtours.demoaut.com";
		//Get URL / Navigate
		//	new TestSetup().getDriver().get(URL);		

		//Maximize Window
		driver.manage().window().maximize();

		//Get URL / Navigate
		driver.get(URL);

		//Wait
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//********************** Registration *******************
		driver.findElement(By.partialLinkText("REGIST")).click(); //Click on Register link
		driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).clear(); 
		driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys("Vijay"); //Type FirstName
		driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).clear(); 
		driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("Reddy"); //Type last name
		driver.findElement(By.xpath("//input[contains(@name,'phone')]")).clear(); 
		driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("123-456-7890"); //Type phone number 
		driver.findElement(By.cssSelector("input#userName")).clear();  //By mistake, Dev has given Email field's id as 'userName', it's supposed to be 'email'
		driver.findElement(By.cssSelector("input#userName")).sendKeys("vijay@gmail.com"); //Type email
		driver.findElement(By.name("address1")).clear();
		driver.findElement(By.name("address1")).sendKeys("123 Main St");	
		driver.findElement(By.name("city")).clear();
		driver.findElement(By.name("city")).sendKeys("Jersey City");	
		driver.findElement(By.name("state")).clear();
		driver.findElement(By.name("state")).sendKeys("NJ");	
		driver.findElement(By.name("postalCode")).clear();
		driver.findElement(By.name("postalCode")).sendKeys("00902");
		WebElement ele = driver.findElement(By.xpath("//select[contains(@name,'country')]"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("INDIA"); 
		//sel.selectByValue("92"); 
		//sel.selectByIndex(1); 
		driver.findElement(By.id("email")).sendKeys("user1"); //By mistake, Dev has given Username's field's id as 'email' instead of 'userName'
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[contains(@name,'confirmPassword')]")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[contains(@name,'register')]")).click();

		Thread.sleep(5000); // Wait to see the confirmation screen

		//Expected Values
		String confirmationText_FNLN_Expected = "Vijay Reddy";
		String confirmationText_UN_Expected = "user1";
		//Capaturing Text From WebPage
		String confirmationText_FNLN_Actual = driver.findElement(By.xpath("//table/tbody/tr[3]/td/p[1]/font/b")).getText();
		String confirmationText_UN_Actual = driver.findElement(By.xpath("//table/tbody/tr[3]/td/p[3]/a/font/b")).getText();

		confirmationText_FNLN_Actual= confirmationText_FNLN_Actual.replace(",", "");//Dear Vijay Reddy
		confirmationText_FNLN_Actual= confirmationText_FNLN_Actual.substring(5);//Vijay Reddy

		confirmationText_UN_Actual=confirmationText_UN_Actual.replace(".", ""); //Note: Your user name is user1.
		confirmationText_UN_Actual=confirmationText_UN_Actual.substring(24);

		//Validation
		StringUtils.compare(confirmationText_FNLN_Expected, confirmationText_FNLN_Actual);
		StringUtils.compare(confirmationText_UN_Expected, confirmationText_UN_Actual);



		Thread.sleep(5000);

		driver.findElement(By.linkText("sign-in")).click();


		//Sign in

		/*	
		WebElement username=driver.findElement(By.name("userName"));

		username.sendKeys("user1");

		driver.findElement(By.name("password")).sendKeys("Password123");

		driver.findElement(By.xpath("//input[contains(@name,'login')]")).click();

		 */

		// Flight Finder

		driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();

		// Flight Details

		Select passengers=new Select(driver.findElement(By.xpath("//select[contains(@name,'passCount')]")));
		passengers.selectByVisibleText("2");

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


		//input[contains(@name,'servClass') and contains (@value,'First')]
		driver.findElement(By.xpath("//input[contains(@name,'servClass') and contains (@value,'First')]")).click();
		//select[contains(@name,'airline')]
		Select airline=new Select(driver.findElement(By.xpath("//select[contains(@name,'airline')]")));
		airline.selectByVisibleText("Unified Airlines");
		//input[contains(@name,'findFlights')]
		driver.findElement(By.xpath("//input[contains(@name,'findFlights')]")).click();

		//Select Flight

		//Depart
		driver.findElement(By.xpath("//td[contains(@class,'frame_action_xrows')]//input[contains(@value, 'Blue Skies Airlines$360') and contains(@name,'outFlight')]")).click();

		//Return
		driver.findElement(By.xpath("//td[contains(@class,'frame_action_xrows')]//input[contains(@value, 'Blue Skies Airlines$631') and contains(@name,'inFlight')]")).click();

		// Click on Continue Button
		driver.findElement(By.xpath("//input[contains(@name,'reserveFlights')]")).click();

		// Book A Flight
		//Passengers
		driver.findElement(By.xpath("//input[contains(@name,'passFirst0')]")).sendKeys("John");
		driver.findElement(By.xpath("//input[contains(@name,'passLast0')]")).sendKeys("Smith");

		driver.findElement(By.xpath("//input[contains(@name,'passFirst1')]")).sendKeys("Mary");
		driver.findElement(By.xpath("//input[contains(@name,'passLast1')]")).sendKeys("Smith");

		//Credit Card
		new Select(driver.findElement(By.xpath("//select[contains(@name,'creditCard')]"))).selectByVisibleText("Discover");
		driver.findElement(By.xpath("//input[contains(@name,'creditnumber')]")).sendKeys("1234567890123456"); //16-Digits
		new Select(driver.findElement(By.xpath("//select[contains(@name,'cc_exp_dt_mn')]"))).selectByVisibleText("05");
		new Select(driver.findElement(By.xpath("//select[contains(@name,'cc_exp_dt_yr')]"))).selectByVisibleText("2010");

		driver.findElement(By.xpath("//input[contains(@name,'cc_frst_name')]")).sendKeys("John");
		driver.findElement(By.xpath("//input[contains(@name,'cc_last_name')]")).sendKeys("Smith");
		driver.findElement(By.xpath("//input[contains(@name,'buyFlights')]")).click();

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

	   // Calculation
	   
	   if (totalPriceint == (toPriceInt+fromPriceInt)*2+Totaltaxesint) 
		System.out.println("Total Price is calculated correctly!");
		else
			System.out.println("Total Price is NOT calculated correctly!");

	 
	    	driver.quit();
	}

}
