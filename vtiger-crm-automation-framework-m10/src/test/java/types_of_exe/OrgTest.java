package types_of_exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrgTest {

	@Parameters("browser")
	@Test(groups = "smoke")
	public void createOrgTest(String browser) throws InterruptedException {
		WebDriver driver;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else
			driver = new ChromeDriver();
		
		System.out.println("Org created");
		Thread.sleep(3000);
		driver.quit();
	}

	@Parameters({"un", "pwd"})
	@Test(groups = "reg", enabled =  false)
	public void modifyOrgTest(String un, String pwd) {
//		String un = "admin";
//		String pwd = "manager";
		
		System.out.println(un + " " + pwd);
	}

	@Test(groups = "reg", enabled = false)
	public void deleteOrgTest() {
		System.out.println("org deleted");
	}
}
