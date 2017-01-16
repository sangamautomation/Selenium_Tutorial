package infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.DateUtils;
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
			System.out.println("["+DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss")+"] | Clicked the link :" + xpathLocator );
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
			System.out.println("["+DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss")+"]"+" | Entered in the field :" + xpathLocator + " = "+ valueToEnter);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void setTextByName(WebDriver driver, String name_DOM, String valueToEnter){

		try {
			driver.findElement(By.name(name_DOM)).clear();
			driver.findElement(By.name(name_DOM)).sendKeys(valueToEnter);
			System.out.println("["+DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss")+"]"+" | Entered in the field :" + name_DOM + " = "+ valueToEnter);

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
			System.out.println("["+DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss")+"]"+" | Selected the Radiobutton :" + xpathLocator );

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
			System.out.println("["+DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss")+"]"+" | Selected the Checkbox :" + xpathLocator );

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
		System.out.println("["+DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss")+"]"+" | Selected the value from Dropdown :" + xpathLocator + " = " +valueToSelect);

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
		System.out.println("["+DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss")+"]"+" | Selected the value from Dropdown :" + xpathLocator + " = " +indexToSelect);

	}


	/**
	 * getWidgetText - returns captured text of a webelement by taking driver and it's xpath as arguments in order to validate
	 * @param driver
	 * @param xpathLocator
	 * @return
	 */
	public String getWidgetText(WebDriver driver, String xpathLocator){
		System.out.println("["+DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss")+"]"+" | Captured text :" + xpathLocator + " = " +driver.findElement(By.xpath(xpathLocator)).getText());

		return driver.findElement(By.xpath(xpathLocator)).getText();

	}


}