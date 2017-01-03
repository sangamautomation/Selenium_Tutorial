/**
 * Date: Jan 1, 2017
 * Author: Work
 * TestCase: XPathPractice.java
 * Description: 
 */
package rnd;

import org.openqa.selenium.By;

import setup.TestSetup;

public class Locators_XPaths_NonXPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String URL = "http://newtours.demoaut.com";
		//Get URL / Navigate
		TestSetup.getDriver().get(URL);
		//TestSetup.getDriver().navigate().to(URL);
		//TestSetup.getDriver().navigate().back(); //Browser's Back button
		 TestSetup.getDriver().navigate().forward(); //Browser's Forward button
 		TestSetup.getDriver().navigate().refresh();
		

		//Get Page Source
		
		String pageSource = TestSetup.getDriver().getPageSource();
		System.out.println("Page Source is: \n"+pageSource);
		
		//Get Page URL (Eg: http://newtours.demoaut.com/mercurypurchase.php) 
		TestSetup.getDriver().getCurrentUrl();
		
		
		//Non-XPath
		TestSetup.getDriver().findElement(By.className("className"));
		TestSetup.getDriver().findElement(By.cssSelector("#navbar-collapse-1 .ul.li:nth-child(3).a")).sendKeys("Name");
		TestSetup.getDriver().findElement(By.id("id"));
 		TestSetup.getDriver().findElement(By.linkText("REGISTER"));
 		TestSetup.getDriver().findElement(By.partialLinkText("REGIST")); //REGISTER --> REGISTRATION	
		TestSetup.getDriver().findElement(By.name("passFirst0"));
		TestSetup.getDriver().findElement(By.tagName("div"));

		//XPath
		TestSetup.getDriver().findElement(By.xpath("//input[contains(@name,'First')]"));
	
		//Get Title
 		String pageTitle = TestSetup.getDriver().getTitle();
		
 		//Get Text
 		String totalPrice = TestSetup.getDriver().findElement(By.xpath("//table/tbody/tr[9]/td[2]/font/b")).getText();
		System.out.println("Total Price = "+ totalPrice);
		
		//Close Single Browser Instance
 		TestSetup.getDriver().close();
 		
 		//Close Multiple Browser Instance
 		TestSetup.getDriver().quit();
 		
 		
 		
 		
 		
		
	}

}
