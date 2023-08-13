package seleniumSessions_02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrickInfoTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver ;
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		driver.get("https://www.espncricinfo.com/series/pakistan-under-19s-in-bangladesh-2023-1372069/bangladesh-under-19s-vs-pakistan-under-19s-4th-youth-odi-1372082/full-scorecard");
		
		List<WebElement> batsman = driver.findElements(By.xpath("//td[@class='ds-w-0 ds-whitespace-nowrap ds-min-w-max ds-flex ds-items-center' or @class='ds-w-0 ds-whitespace-nowrap ds-min-w-max ds-flex ds-items-center ds-border-line-primary ci-scorecard-player-notout']//span[@class='ds-text-tight-s ds-font-medium ds-text-typo ds-underline ds-decoration-ui-stroke hover:ds-text-typo-primary hover:ds-decoration-ui-stroke-primary ds-block']"));
		
		for(int i=0; i< batsman.size(); i++) {
			String name = batsman.get(i).getText();
			
			System.out.println();
			
			System.out.print(name+"\t" + "\t");
		
			if(name.contains("(c)")) {
				name = name.replaceAll("[(c)]", "");
			}
			if(name.contains("†")) {
				name = name.replaceAll("†", "");
			}
			
			name = name.trim();
			
			
			Score(driver, name);
		}
	}
	
	public static void Score(WebDriver driver, String name) {
		List<WebElement> scoreList = driver.findElements(By.xpath("//table[@class='ds-w-full ds-table ds-table-md ds-table-auto  ci-scorecard-table']//span[text()='"+name+"']//ancestor::td[@class='ds-w-0 ds-whitespace-nowrap ds-min-w-max ds-flex ds-items-center' or @class='ds-w-0 ds-whitespace-nowrap ds-min-w-max ds-flex ds-items-center ds-border-line-primary ci-scorecard-player-notout']//following-sibling::td"));
		for(int i=0; i<scoreList.size(); i++) {
			String s = scoreList.get(i).getText();
			System.out.print(s+"\t");
		}
	}

}
