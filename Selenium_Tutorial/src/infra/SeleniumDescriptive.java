package infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//Commiting to git account to sangamautomation (Selenium_Tutorial update)
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
			driver.findElement(By.xpath(xpathLocator)).clear();
			driver.findElement(By.xpath(xpathLocator)).sendKeys(valueToEnter);
		} catch (Exception e) {
 			e.printStackTrace();
 			throw e;
		}
		
	}

public void setTextByName(WebDriver driver, String name_DOM, String valueToEnter){
	
	try {
		driver.findElement(By.name(name_DOM)).clear();
		driver.findElement(By.name(name_DOM)).sendKeys(valueToEnter);
	} catch (Exception e) {
			e.printStackTrace();
			throw e;
	}
	
}
/**
 * selectRadiobutton - Selects Radio Button
 * @param driver
 * @param xpathLocator
 */
public void selectRadiobutton(WebDriver driver, String xpathLocator){
	
	try {
		driver.findElement(By.xpath(xpathLocator)).click();
	} catch (Exception e) {
			e.printStackTrace();
			throw e;
	}

}
/**
 * selectCheckbox - Selects Checkbox
 * @param driver
 * @param xpathLocator
 */
public void selectCheckbox(WebDriver driver, String xpathLocator){
	
	try {
		driver.findElement(By.xpath(xpathLocator)).click();
	} catch (Exception e) {
			e.printStackTrace();
			throw e;
	}

}


/**
 * 
 * selectDropdown - to select a value from dropdown using visible text
 * @param driver
 * @param xpathLocator
 * @param valueToSelect
 */
public void selectDropdown(WebDriver driver, String xpathLocator, String valueToSelect){
	WebElement ele = driver.findElement(By.xpath(xpathLocator));
	Select sel = new Select(ele);
	sel.selectByVisibleText(valueToSelect);
 
}

/**
* 
* selectDropdown - to select a value from dropdown using index
* @param driver
* @param xpathLocator
* @param valueToSelect
*/
public void selectDropdown(WebDriver driver, String xpathLocator, int indexToSelect){
	WebElement ele = driver.findElement(By.xpath(xpathLocator));
	Select sel = new Select(ele);
	sel.selectByIndex(indexToSelect);

}


}