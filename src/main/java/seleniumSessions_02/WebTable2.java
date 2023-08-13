package seleniumSessions_02;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver ;
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		driver.get("https://www.espncricinfo.com/series/world-cup-super-league-2020-2022-23-1227837/bangladesh-vs-ireland-2nd-odi-1364125/full-scorecard");
		
		String w =  WicketBy(driver, "Harry Tector");  
		ArrayList<String> a = Score(driver, "Harry");
		
		String w2 =  WicketBy(driver, "Stephen Doheny");
		ArrayList<String> a2 = Score(driver, "Stephen Doheny");
		
		System.out.println("For Harry:");
		System.out.println(w);
		System.out.println(a);
		
		System.out.println("For Stephen:");
		System.out.println(w2);
		System.out.println(a2);
	}
	
	
	public static String WicketBy(WebDriver driver, String name) {
		  String wicket_by = driver.findElement(By.xpath("//span[text()='"+name+"']//ancestor::td//following-sibling::td//span/span")).getText();
		  return wicket_by;
		}
		
		public static ArrayList<String> Score(WebDriver driver, String name) {
			ArrayList<String> arr = new ArrayList<String>();
			List<WebElement> scoreList =  driver.findElements(By.xpath("//span[contains(text(),'"+name+"')]//ancestor::td//following-sibling::td[@class='ds-w-0 ds-whitespace-nowrap ds-min-w-max ds-text-right']"));
			for(int i=0; i<scoreList.size(); i++) {
				String s = scoreList.get(i).getText();
				arr.add(i, s);
			}
			return arr;
		}

}
