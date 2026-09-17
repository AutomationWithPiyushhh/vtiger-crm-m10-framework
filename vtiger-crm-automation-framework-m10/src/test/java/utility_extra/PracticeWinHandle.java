package utility_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.WebDriverUtility;

public class PracticeWinHandle {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.automationwithpiyush.com/");

//		step 1> perform the task which will open new windows
		driver.findElement(By.cssSelector("[onclick='openSocialChannels()']")).click();

//		step 2> get the home address
		String PID = driver.getWindowHandle();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		wdUtil.switchToWindowByTitle("Linked");

//		step 5> perform the task
		Thread.sleep(3000);
		driver.close();

//		step 6> come back home
		driver.switchTo().window(PID);
	}
}
