package types_of_exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactTest {

	@Parameters("browser")
	@Test(groups = "reg")
	public void createContactTest(String browser) throws InterruptedException {
		WebDriver driver;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else
			driver = new ChromeDriver();

		System.out.println("Contact created");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(groups = "smoke", enabled = false)
	public void modifyContactTest() {
		System.out.println("Contact modified");
	}

	@Test(groups = "smoke", enabled = false)
	public void deleteContactTest() {
		System.out.println("Contact deleted");
	}
}
