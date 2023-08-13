package seleniumSessions_02;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationTest3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/s?k=laptop+stand&crid=5A9ZD344PY17&qid=1685446444&sprefix=laptop%2Caps%2C478&ref=sr_pg_1");
		List<WebElement> e;
		List<WebElement> e2 = driver.findElements(By.xpath("//span[@class='s-pagination-strip']//span"));
		String s = e2.get(e2.size()-1).getText();
		int n = Integer.parseInt(s);
		int i=0;
		while(i<=n) {
			List<WebElement> ele = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' and text()='Fellowes I-Spire Series Portable Laptop Stand for Desk']"));
			if(ele.size()==1) {
				ele.get(0).click();
				break;
			}
			
			else {
				e = driver.findElements(By.xpath("//span[@class='s-pagination-strip']//a"));
				WebElement ele2 = e.get(e.size()-1);
				wait.until(ExpectedConditions.elementToBeClickable(ele2));
				ele2.click();
//				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
				ele = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' and text()='Fellowes I-Spire Series Portable Laptop Stand for Desk']"));
			}
			i++;
			
		}
	}
	
	
	//span[@class='s-pagination-strip']//a
	
	
	//span[@class='s-pagination-strip']//span

}
