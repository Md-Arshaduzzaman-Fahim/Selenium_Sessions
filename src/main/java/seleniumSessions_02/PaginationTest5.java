package seleniumSessions_02;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationTest5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		
		driver.get("https://babynames.merschat.com/popular.cgi");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		List<WebElement> e = driver.findElements(By.xpath("//a[contains(text(),'Fahim')]"));
		List<WebElement> ele = driver.findElements(By.xpath("//select[@name='page']/option"));
		int i=0; boolean found = false;
		while(i<ele.size()) {
		if(e.size()==1) {
			
			System.out.println(e.get(0).getText());
			e.get(0).click();
			found=true;
			break;
		}
		
		else {
			ele = driver.findElements(By.xpath("//select[@name='page']/option"));
			ele.get(i).click();
			driver.findElement(By.xpath("//input[@value='Go']")).click(); 
			e = driver.findElements(By.xpath("//a[contains(text(),'Fahim')]"));
		}
		i++;
	  }
		if(found==false) {
			System.out.println("no such name");
		}
	}

}
