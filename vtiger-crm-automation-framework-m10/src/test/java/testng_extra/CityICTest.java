package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CityICTest {
	@Test(invocationCount = 3, threadPoolSize = 3)
	public void createNoida() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void modifyNoida() {
		Assert.assertTrue(false);
		System.out.println("Noida modified to Greater Noida");
	}

	@Test
	public void deleteGreaterNoida() {
		System.out.println("GreaterNoida deleted");
	}

}
