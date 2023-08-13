package seleniumSessions_02;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	
	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		
		driver.get("https://elaach.com/movies?category=Bollywood&page=1");
		
		List<WebElement> e = driver.findElements(By.xpath("//h3[@class='card__title']/a[text()='Bhediya']"));
		List<WebElement> ele;
		String s = driver.findElement(By.xpath("//ul[@class='pagination pagination']/li[5]/a")).getText();
		int n = Integer.parseInt(s);
		int i=1;
		while(i<=n) {
			
			if(e.size()==1) {
				System.out.println( e.get(0).getText());
				e.get(0).click();
				break;
			}
			
			else {
				if(i<n) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
				 ele = driver.findElements(By.xpath("//ul[@class='pagination pagination']/li/a"));
				 ele.get(ele.size()-1).click();
			 
				 
				 e = driver.findElements(By.xpath("//h3[@class='card__title']/a[text()='Bhediya']"));
				}
			}
			i++;
			
		}
		if(i>n) {
			System.out.println("the movie is not on the website");
		}
	}
	
	
	//h3[@class='card__title']/a[text()='Bhediya']
	
	//ul[@class='pagination pagination']/li[5]/a
	
	//ul[@class='pagination pagination']/li[6]/a

}
