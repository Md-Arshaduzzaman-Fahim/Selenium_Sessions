package seleniumSessions_02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathwWebTable {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver ;
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		driver.get("https://www.espncricinfo.com/series/world-cup-super-league-2020-2022-23-1227837/bangladesh-vs-ireland-2nd-odi-1364125/full-scorecard");
		
//		String wicket_by = driver.findElement(By.xpath("//span[text()='Harry Tector']//ancestor::td//following-sibling::td//span/span")).getText();
//		System.out.println(wicket_by);
		
		WicketBy(driver, "Harry Tector");  
		Score(driver, "Harry");
		
		WicketBy(driver, "Stephen Doheny");
		Score(driver, "Stephen Doheny");
	}
	
	public static void WicketBy(WebDriver driver, String name) {
	  String wicket_by = driver.findElement(By.xpath("//span[text()='"+name+"']//ancestor::td//following-sibling::td//span/span")).getText();
	  System.out.println("for: "+name);
	  System.out.println(wicket_by);
	}
	
	public static void Score(WebDriver driver, String name) {
		List<WebElement> scoreList =  driver.findElements(By.xpath("//span[contains(text(),'"+name+"')]//ancestor::td//following-sibling::td[@class='ds-w-0 ds-whitespace-nowrap ds-min-w-max ds-text-right']"));
		for(int i=0; i<scoreList.size(); i++) {
			String s = scoreList.get(i).getText();
			System.out.println(s);
		}
	}

}
