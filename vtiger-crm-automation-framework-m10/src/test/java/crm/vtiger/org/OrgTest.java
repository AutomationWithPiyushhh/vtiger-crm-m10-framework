package crm.vtiger.org;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

/**
 * Test Script: Create Organization
 *
 * Purpose: This script automates the creation of a new Organization in the
 * Vtiger CRM application.
 *
 * Test Flow: 1. Launch browser 2. Maximize browser window 3. Configure implicit
 * wait 4. Navigate to Vtiger CRM application 5. Login using valid credentials
 * 6. Navigate to Organizations module 7. Open Create Organization page 8.
 * Generate a unique organization name 9. Enter organization name 10. Add member
 * 11. Save the organization 12. Verify the created organization name 13. Logout
 * 14. Close the browser
 *
 * Expected Result: Organization should be created successfully and the actual
 * organization name should match the generated name.
 *
 * Application: Vtiger CRM
 *
 * Browser: Configured through JSON file
 *
 * Author: AutomationWithPiyush
 */
public class OrgTest {

	/**
	 * Method to create organization in Vtiger CRM application.
	 *
	 * @throws ParseException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void createOrgTest() throws IOException, ParseException, InterruptedException {

		// Get data from JSON file
		String browser = FileUtility.getDataFromJsonFile("bro");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("un");
		String password = FileUtility.getDataFromJsonFile("pwd");

		// Generate random number
		long random = JavaUtility.generateRandomNumber();

		// Get organization name from Excel and append random number
		String orgName = FileUtility.getDataFromExcelFile("org", 3, 0) + random;

		Reporter.log("==============================================", true);
		Reporter.log("       CREATE ORGANIZATION TEST STARTED       ", true);
		Reporter.log("==============================================", true);

		// Open browser
		Reporter.log("[INFO] Launching " + browser + " browser...", true);

		WebDriver driver = null;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			Reporter.log("[WARN] Invalid browser specified. Launching Chrome by default.", true);
			driver = new ChromeDriver();
		}

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		// Maximize browser
		Reporter.log("[INFO] Maximizing browser window...", true);
		wdUtil.maxWin();

		// Configure implicit wait
		Reporter.log("[INFO] Configuring implicit wait: 15 seconds...", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Navigate to URL
		Reporter.log("[INFO] Navigating to Vtiger CRM application...", true);
		driver.get(url);
		Reporter.log("[INFO] Application launched successfully.", true);

		// Login
		Reporter.log("[INFO] Starting login process...", true);

		lp.login(username, password);

		Reporter.log("[INFO] Login process completed successfully.", true);

		// Navigate to Organizations module
		Reporter.log("[INFO] Navigating to Organizations module...", true);
		hp.getOrgLink().click();

		// Open Create Organization page
		Reporter.log("[INFO] Opening Create Organization page...", true);
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		// Display generated organization name
		Reporter.log("[INFO] Generated Organization Name: " + orgName, true);

		// Enter organization name
		WebElement orgField = driver.findElement(By.name("accountname"));

		Reporter.log("[INFO] Entering Organization Name...", true);
		orgField.sendKeys(orgName);

		// Add member
		Reporter.log("[INFO] Opening member selection window...", true);

		driver.findElement(By.cssSelector("[src='themes/softed/images/select.gif']")).click();

		String PID = driver.getWindowHandle();

		Reporter.log("[INFO] Switching to member selection window...", true);

		wdUtil.switchToWindowByUrl("TasksEditView");

		// Get member organization name from Excel
		String orgName2 = FileUtility.getDataFromExcelFile("org", 12, 0);

		Reporter.log("[INFO] Searching for organization/member: " + orgName2, true);

		driver.findElement(By.name("search_text")).sendKeys(orgName2 + Keys.ENTER);

		Reporter.log("[INFO] Selecting organization/member...", true);

		driver.findElement(By.xpath("//a[text()='" + orgName2 + "']")).click();

		Reporter.log("[INFO] Accepting alert...", true);

		driver.switchTo().alert().accept();

		// Switch back to parent window
		Reporter.log("[INFO] Switching back to Organization window...", true);

		driver.switchTo().window(PID);

		Thread.sleep(3000);

		// Save organization
		Reporter.log("[INFO] Saving Organization...", true);

		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		Reporter.log("[INFO] Organization save operation completed.", true);

		// Verification
		Reporter.log("[INFO] Starting Organization creation verification...", true);

		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		Reporter.log("[INFO] Expected Organization Name: " + orgName, true);

		Reporter.log("[INFO] Actual Organization Name: " + actOrgName, true);

		if (actOrgName.equals(orgName + "abc")) {

			Reporter.log("[PASS] Organization Created Successfully.", true);

		} else {

			Reporter.log("[FAIL] Failed to create organization.", true);
		}

		// Logout
		Reporter.log("[INFO] Starting logout process...", true);

		WebElement profileIcon = hp.getProfileIcon();

		Reporter.log("[INFO] Hovering over profile icon...", true);

		wdUtil.hover(profileIcon);

		Reporter.log("[INFO] Clicking Sign Out...", true);

		driver.findElement(By.linkText("Sign Out")).click();

		Reporter.log("[INFO] Logout completed successfully.", true);

		// Close browser
		Reporter.log("[INFO] Waiting for 2 seconds before closing browser...", true);

		Thread.sleep(2000);

		Reporter.log("[INFO] Closing browser...", true);

		driver.quit();

		Reporter.log("==============================================", true);
		Reporter.log("       CREATE ORGANIZATION TEST FINISHED      ", true);
		Reporter.log("==============================================", true);
	}
}
