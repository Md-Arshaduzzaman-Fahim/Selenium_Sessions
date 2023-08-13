package seleniumSessions_02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {
	
	WebDriver driver;
	
	
	public Util(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * This function gets the element
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
	  element = driver.findElement(locator); 
		}
		catch(Exception e) {
			System.out.println("exception occured in finding the element");
			System.out.println(e.getMessage());
		}
		return element;
	}
	
	public void doClick(By locator) {
		try {
		getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("exception occured in clicking the element");
			System.out.println(e.getMessage());
		}
	}
	
	public void send_keys(By locator, String text) {
		try {
			getElement(locator).sendKeys(text);;
			}
			catch(Exception e) {
				System.out.println("exception occured in sending kyes in the element");
				System.out.println(e.getMessage());
			}
	}
	
	
	
	public List <WebElement> getElements(By locator) {
		List <WebElement> elements = null;
		try {
	  elements = driver.findElements(locator); 
		}
		catch(Exception e) {
			System.out.println("exception occured in finding the element");
			System.out.println(e.getMessage());
		}
		return elements;
	}
	
}
