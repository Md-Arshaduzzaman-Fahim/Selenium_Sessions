package seleniumSessions_02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerryMultipleSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		Util u = new Util(driver);
		
		By Jselect = By.id("justAnInputBox");
		
		u.doClick(Jselect);
		
		Choice(driver,  "all");

	}
	
	
	public static void Choice(WebDriver driver, String... value) {
		Util u2 = new Util(driver);
		
		By choiseList = By.xpath("//span[@class='comboTreeItemTitle']");
		
		List<WebElement> choices = u2.getElements(choiseList);
		if(value[0].equalsIgnoreCase("All")) {
			for(int all=0; all<choices.size(); all++) {
				try {
				choices.get(all).click();
				}
				catch(Exception e){
					
				}
			}
		}
		else {
			for(int i=0; i<choices.size(); i++) {
				String text = choices.get(i).getText();
				for(int j=0; j<value.length; j++) {
					if(text.equals(value[j])) {
						choices.get(i).click();
					}
				}
				
			}
		}
		
	}

}
