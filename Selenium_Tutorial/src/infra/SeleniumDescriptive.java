package infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Commiting to git account to sangamautomation (Selenium_Tutorial)
/**
 *SeleniumDescriptive - For All Infrastructural Level Reusable Functions
 */
public class SeleniumDescriptive {
	
	/**
	 * clickLink - Click on link by specific xpath
	 * @param driver
	 * @param xpathLocator
	 */
	public void clickLink(WebDriver driver, String xpathLocator){
		
		try {
			driver.findElement(By.xpath(xpathLocator)).click();
		} catch (Exception e) {
 			e.printStackTrace();
 			throw e;
		}
		
	}

/**
 * setText - Enter text into text field by taking driver and xpath as args
 * @param driver
 * @param xpathLocator
 * @param valueToEnter
 */
public void setText(WebDriver driver, String xpathLocator, String valueToEnter){
		
		try {
			driver.findElement(By.xpath(xpathLocator)).sendKeys(valueToEnter);
		} catch (Exception e) {
 			e.printStackTrace();
 			throw e;
		}
		
	}
	
public void selectRadiobutton(WebDriver driver, String xpathLocator){
	
	try {
		driver.findElement(By.xpath(xpathLocator)).click();
	} catch (Exception e) {
			e.printStackTrace();
			throw e;
	}

}
}