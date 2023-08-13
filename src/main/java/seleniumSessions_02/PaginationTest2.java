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

public class PaginationTest2 {

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
			Thread.sleep(400);
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebElement nm = e.get(i);
			String name = nm.getText();
			if(name.equals("gg")) {
				System.out.println(name);
				nm.click();
				found=true;
				break;
			}
			
		}
		
		if(found==true) {
			break;
		}
		
		else {
			try {
//				Thread.sleep(3000);
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
		
	}
	
	
	
}
