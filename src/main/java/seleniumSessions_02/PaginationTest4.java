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

public class PaginationTest4 {

	public static void main(String[] args) throws InterruptedException  {

		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		
		driver.get("https://www.aliexpress.com/w/wholesale-laptop.html?SearchText=laptop&catId=0&g=y&initiative_id=AS_20230530032518&spm=a2g0o.best.1000002.0&trafficChannel=af");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		List<WebElement> e = driver.findElements(By.xpath("//div[@class='p4p--p4pList--2B-vc3X']//div[@class='item-title-wrap']/a"));
		
		boolean found = false;
		
		while(true) {
		for(int i=0; i<e.size();i++) {
			Thread.sleep(100);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			WebElement nm = e.get(i);
			String name = nm.getText();
			System.out.print("product name: "+name+"    ");
			if(name.contains("\"")) {
				String[] a = name.split("\"");
				name = a[0];
			}
			Thread.sleep(100);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			List<WebElement> e2 = driver.findElements(By.xpath("//a[@class='item-title' and contains(text(),\""+name+"\")]//ancestor::div[@class='product-info']/div/div/span"));
			for(int j=0; j<e2.size(); j++) {
				
				Thread.sleep(100);
				String price_info = e2.get(j).getText();
				System.out.print(price_info+"    ");
				
			}
			System.out.println();
		}
		
		
		
		
			try {
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//				Thread.sleep(100);
		WebElement ele = driver.findElement(By.xpath("//span[@class='comet-icon comet-icon-arrowrightsmall p4p--canClick--2Hpz02O']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		e = driver.findElements(By.xpath("//div[@class='p4p--p4pList--2B-vc3X']//div[@class='item-title-wrap']/a"));
			}
			catch(Exception ex) {
				System.out.println("finished search");
				break;
			}
		
	}
		
	}
	
	//div[@class='product-info']/div/div/span
	
	
	//a[@class='item-title' and contains(text(),'2023 New High-speed External Hard Drive  2TB ...')]//ancestor::div[@class='product-info']/div/div/span
	
	
	//a[@class='item-title' and text()='DERE Laptop 2023 New R16 Pro16-inch 2.5K IPS ...']//ancestor::div[@class='product-info']/div/div/span
}
