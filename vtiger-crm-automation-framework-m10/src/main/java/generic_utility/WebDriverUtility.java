package generic_utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	WebDriver driver;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver = driver; 
	}
	
	public void hover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}
	
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void select(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
//	window handling
	
	public void switchToWindowByTitle(String partialTitle) {
		Set<String> CIDs = driver.getWindowHandles();
		for (String i : CIDs) {
			driver.switchTo().window(i);
			if (driver.getTitle().contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void switchToWindowByUrl(String partialURL) {

//		step 3> get all the session ids
		Set<String> CIDs = driver.getWindowHandles();
		
//		step 4> go through each and every window
		for (String i : CIDs) {
			driver.switchTo().window(i);
//			step 5> break the loop wherever condition meets
			if (driver.getCurrentUrl().contains(partialURL)) {
				break;
			}
		}
	}
	
}
