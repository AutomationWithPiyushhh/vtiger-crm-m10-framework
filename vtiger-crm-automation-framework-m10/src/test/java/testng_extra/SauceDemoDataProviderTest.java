
package testng_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoDataProviderTest {
	@Test(dataProvider = "getData")
	public void login(String username, String password) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");

//		String username = "standard_user";
//		String password = "secret_sauce";

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("login-button")).click();

//		verify
		boolean status = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(status);

		Thread.sleep(1000);
		driver.quit();
	}

//	Mark a method as supplying data for a test method.
	@DataProvider
	public Object[][] getData() {

		Object[][] creds = new Object[6][2];
//							num of row => num of execution
//							num of col => num of parameters => num of data at a time

		creds[0][0] = "standard_user";
		creds[0][1] = "secret_sauce";

		creds[1][0] = "locked_out_user";
		creds[1][1] = "secret_sauce";

		creds[2][0] = "problem_user";
		creds[2][1] = "secret_sauce";

		creds[3][0] = "performance_glitch_user";
		creds[3][1] = "secret_sauce";

		creds[4][0] = "error_user";
		creds[4][1] = "secret_sauce";

		creds[5][0] = "visual_user";
		creds[5][1] = "secret_sauce";

		return creds;
	}

}