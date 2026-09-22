package crm.vtiger.lead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import object_repository.LoginPage;

/**
 * Test Script: Create Lead
 *
 * Description:
 * This test script automates the creation and verification of a new Lead
 * in the Vtiger CRM application.
 *
 * Test Scenario:
 * Create a Lead by providing Last Name and Company details,
 * save the Lead, and verify that the entered details are displayed
 * correctly on the Lead details page.
 *
 * Test Steps:
 * 1. Launch Chrome browser.
 * 2. Maximize the browser window.
 * 3. Configure implicit wait.
 * 4. Navigate to the Vtiger CRM application.
 * 5. Login using valid credentials.
 * 6. Navigate to the Leads module.
 * 7. Open the Create Lead page.
 * 8. Enter Last Name.
 * 9. Enter Company name.
 * 10. Save the Lead.
 * 11. Verify Last Name and Company details.
 * 12. Logout from the application.
 * 13. Close the browser.
 *
 * Expected Result:
 * The Lead should be created successfully and the actual Last Name
 * and Company values should match the entered values.
 *
 * Application:
 * Vtiger CRM
 *
 * Browser:
 * Google Chrome
 *
 * Automation Tool:
 * Selenium WebDriver
 *
 * Execution Type:
 * Standalone Java Program
 *
 * Author:
 * AutomationWithPiyush
 */
public class CreateLeadTest {

	/**
	 * Main method used to execute the Lead creation test.
	 *
	 * @param args command-line arguments
	 * @throws InterruptedException if the execution is interrupted
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("==================================================");
		System.out.println("          CREATE LEAD TEST EXECUTION              ");
		System.out.println("==================================================");

		// ==================================================
		// Browser Initialization
		// ==================================================

		System.out.println("[INFO] Test execution started.");
		System.out.println("[INFO] Launching Chrome browser...");

		WebDriver driver = new ChromeDriver();

		System.out.println("[PASS] Chrome browser launched successfully.");

		System.out.println("[INFO] Maximizing browser window...");
		driver.manage().window().maximize();

		System.out.println("[PASS] Browser window maximized successfully.");

		// ==================================================
		// Browser Configuration
		// ==================================================

		System.out.println("[INFO] Configuring implicit wait: 15 seconds...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		System.out.println("[PASS] Implicit wait configured successfully.");

		// ==================================================
		// Application Navigation
		// ==================================================

		System.out.println("[INFO] Navigating to Vtiger CRM application...");

		driver.get("http://49.249.29.4:8888/");

		System.out.println("[PASS] Vtiger CRM application launched successfully.");

		// ==================================================
		// Login
		// ==================================================

		System.out.println("--------------------------------------------------");
		System.out.println("[INFO] Starting login process...");
		System.out.println("--------------------------------------------------");

//		WebElement username = driver.findElement(By.name("user_name"));
//		WebElement password = driver.findElement(By.name("user_password"));
//		WebElement loginButton = driver.findElement(By.id("submitButton"));

		LoginPage lp = new LoginPage(driver);
		
//		WebElement usernameField = lp.getUsername();
//		WebElement passwordField = lp.getPassword();
//		WebElement loginButton = lp.getLoginButton();
//		
//		System.out.println("[INFO] Entering username...");
//		usernameField.sendKeys("admin");
//
//		System.out.println("[PASS] Username entered successfully.");
//
//		System.out.println("[INFO] Entering password...");
//		passwordField.sendKeys("admin");
//		
//		System.out.println("[PASS] Password entered successfully.");
//
//		System.out.println("[INFO] Clicking Login button...");
//		loginButton.click();

		lp.login("admin", "admin");
		
		System.out.println("[PASS] Login completed successfully.");

		// ==================================================
		// Navigate to Leads Module
		// ==================================================

		System.out.println("--------------------------------------------------");
		System.out.println("[INFO] Navigating to Leads module...");
		System.out.println("--------------------------------------------------");

		driver.findElement(By.linkText("Leads")).click();

		System.out.println("[PASS] Leads module opened successfully.");

		// ==================================================
		// Open Create Lead Page
		// ==================================================

		System.out.println("[INFO] Opening Create Lead page...");

		driver.findElement(By.cssSelector("[alt='Create Lead...']")).click();

		System.out.println("[PASS] Create Lead page opened successfully.");

		// ==================================================
		// Enter Lead Details
		// ==================================================

		System.out.println("--------------------------------------------------");
		System.out.println("[INFO] Entering Lead details...");
		System.out.println("--------------------------------------------------");

		String lastName = "kumar";

		WebElement lastNameField = driver.findElement(By.name("lastname"));

		System.out.println("[INFO] Entering Last Name: " + lastName);
		lastNameField.sendKeys(lastName);

		System.out.println("[PASS] Last Name entered successfully.");

		String company = "ceat";

		WebElement companyField = driver.findElement(By.name("company"));

		System.out.println("[INFO] Entering Company: " + company);
		companyField.sendKeys(company);

		System.out.println("[PASS] Company name entered successfully.");

		// ==================================================
		// Save Lead
		// ==================================================

		System.out.println("--------------------------------------------------");
		System.out.println("[INFO] Saving Lead...");
		System.out.println("--------------------------------------------------");

		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		System.out.println("[PASS] Lead save operation completed.");

		// ==================================================
		// Lead Verification
		// ==================================================

		System.out.println("--------------------------------------------------");
		System.out.println("[INFO] Starting Lead creation verification...");
		System.out.println("--------------------------------------------------");

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		String actCompany = driver.findElement(By.id("dtlview_Company")).getText();

		System.out.println("[INFO] Expected Last Name: " + lastName);
		System.out.println("[INFO] Actual Last Name: " + actLastName);

		System.out.println("[INFO] Expected Company: " + company);
		System.out.println("[INFO] Actual Company: " + actCompany);

		if (actLastName.equals(lastName) && actCompany.equals(company)) {
			System.out.println("[PASS] Lead Created Successfully.");
			System.out.println("[PASS] Last Name verification passed.");
			System.out.println("[PASS] Company verification passed.");
		} else {
			System.out.println("[FAIL] Failed to create Lead.");
			System.out.println("[FAIL] Lead details verification failed.");
		}

		// ==================================================
		// Logout
		// ==================================================

		System.out.println("--------------------------------------------------");
		System.out.println("[INFO] Starting logout process...");
		System.out.println("--------------------------------------------------");

		WebElement profileIcon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);

		System.out.println("[INFO] Hovering over profile icon...");
		act.moveToElement(profileIcon).build().perform();

		System.out.println("[PASS] Profile menu displayed.");

		System.out.println("[INFO] Clicking Sign Out...");
		driver.findElement(By.linkText("Sign Out")).click();

		System.out.println("[PASS] Logout completed successfully.");

		// ==================================================
		// Browser Termination
		// ==================================================

		System.out.println("[INFO] Waiting for 2 seconds before closing browser...");
		Thread.sleep(2000);

		System.out.println("[INFO] Closing browser...");

		driver.quit();

		System.out.println("[PASS] Browser closed successfully.");

		// ==================================================
		// Test Execution Completed
		// ==================================================

		System.out.println("==================================================");
		System.out.println("          CREATE LEAD TEST FINISHED               ");
		System.out.println("          TEST EXECUTION COMPLETED                ");
		System.out.println("==================================================");
	}
}