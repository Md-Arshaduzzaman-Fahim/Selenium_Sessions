package seleniumSessions_02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassTest1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		
		driver.get("https://www.spicejet.com");
		
		WebElement e = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-le9fof r-1otgn73']/div[1]"));
		WebElement e2 = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar' and text()='Extra Seat']"));
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		Passanger(driver, "Adult", 1);
		Thread.sleep(1000);
		Passanger(driver, "Child", 2);
		Thread.sleep(1000);
		Passanger(driver, "Infant", 1);
		
		
		action.moveToElement(e).build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(e2));
		
		action.click(e2).build().perform();
		
		
		
		
	}
	
	public static void Passanger(WebDriver driver, String cat, int num) {
		
		driver.findElement(By.xpath("//div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e' and text()='Passengers']")).click();
		
		
		WebElement passanger = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-1i10wst r-1kfrs79' and contains(text(),'"+cat+"')]//parent::div[@class='css-1dbjc4n']//following-sibling::div[@class='css-1dbjc4n r-1awozwy r-18u37iz']/div[3]")); 
		
		for(int i=1; i<=num; i++) {
		
			passanger.click();
		}
		
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79' and text()='Done']//parent::div")).click();
	}

}
