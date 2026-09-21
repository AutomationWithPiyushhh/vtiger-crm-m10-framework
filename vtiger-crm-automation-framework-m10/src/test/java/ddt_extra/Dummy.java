package ddt_extra;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dummy {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("http://49.249.29.4:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("[id='submitButton']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@alt='vtiger-crm-logo.gif']")));

		driver.findElement(By.xpath("//*[@class='hdrTabBg']//tbody//tbody//tr//td//a[text()='Email']")).click();

		String mainWindow = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[text()='Compose']")).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> secondWindows = driver.getWindowHandles();

		for (String window : secondWindows) {

			if (!window.equals(mainWindow)) {

				driver.switchTo().window(window);

				System.out.println("Switched to Compose window");
				System.out.println("Compose Window URL: " + driver.getCurrentUrl());

				driver.manage().window().maximize();

				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Select']"))).click();

				System.out.println("Select button clicked");

				break;
			}
		}

		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			driver.switchTo().window(window);

			String currentUrl = driver.getCurrentUrl();

			System.out.println("Current Window URL: " + currentUrl);

			if (currentUrl.contains("Contact")) {

				System.out.println("Third window / Contact window found");

				driver.manage().window().maximize();

				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Vinayak Malgaund"))).click();

				System.out.println("TestContact clicked");

				break;
			}
		}
	}
}
