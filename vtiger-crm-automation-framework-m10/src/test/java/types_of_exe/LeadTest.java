package types_of_exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeadTest {

	@Parameters("browser")
	@Test(groups = {"smoke", "reg"})
	public void createLeadTest(String browser) throws InterruptedException {
		WebDriver driver;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else
			driver = new ChromeDriver();
		
		System.out.println("Lead created");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(groups = "reg", enabled = false)
	public void modifyLeadTest() {
		System.out.println("Lead modified");
	}

	@Test(groups = "reg", enabled = false)
	public void deleteLeadTest() {
		System.out.println("Lead deleted");
	}
}
