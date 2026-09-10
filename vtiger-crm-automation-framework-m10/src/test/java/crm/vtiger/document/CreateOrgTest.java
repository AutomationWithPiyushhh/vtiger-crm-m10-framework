package crm.vtiger.document;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException {
//		open the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		navigate to URL
		driver.get("http://49.249.29.4:8888/");

//		Login
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement loginButton = driver.findElement(By.id("submitButton"));

		username.sendKeys("admin");
		password.sendKeys("admin");
		loginButton.click();

//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		long random = System.currentTimeMillis() / 1000;
		String orgName = "google_" + random;

		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);
		
//		save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

//		verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Organization Created Successfully...");
		} else {
			System.out.println("Failed to create organization...");
		}

//		logout
		WebElement profileIcon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);
		act.moveToElement(profileIcon).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

//		close the browser
		Thread.sleep(2000);
		driver.quit();

	}
}
