package seleniumSessions_02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildLabSchoolTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
        
		driver.get("http://127.0.0.1:8000");
		
//		driver.findElement(By.linkText("Admin login")).click();
//		
//		driver.findElement(By.name("username")).sendKeys("cls_admin01");
//		driver.findElement(By.name("password")).sendKeys("789858");
//		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		
		
		driver.findElement(By.linkText("Grade History")).click();
		driver.findElement(By.name("search")).sendKeys("31");
		driver.findElement(By.xpath("//button")).click();
		
		Marks(driver, "Class One");
		Marks(driver, "Class Two");
	}
	
	
	public static void Marks(WebDriver driver, String clsName) {
		List<WebElement> clsMarks = driver.findElements(By.xpath("//h6[text()='"+clsName+"']//ancestor::tbody//child::tr//td"));
		
		for(int i=0; i<clsMarks.size(); i++) {
			String s = clsMarks.get(i).getText();
			System.out.print(s+"\t");
			if(i%3==0) {
				System.out.println();
			}
		}
		System.out.println();
	}

}
