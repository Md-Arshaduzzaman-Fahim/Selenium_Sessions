package seleniumSessions_02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test01 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/?mkcid=1&mkrid=711-53200-19255-0&siteid=0&campid=5338933784&customid=gxdefault&toolid=10001&mkevt=1");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		By searchBox = By.id("gh-ac");
		
		By srchBtn = By.id("gh-btn");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		
		Util u = new Util(driver);
		
		String s = u.getElement(searchBox).getAttribute("placeholder");
		System.out.println(s);
		
		u.send_keys(searchBox, "gaming laptop");
		u.doClick(srchBtn);

	}

}
