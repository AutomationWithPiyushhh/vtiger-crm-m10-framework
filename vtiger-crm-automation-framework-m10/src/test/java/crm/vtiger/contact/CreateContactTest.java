package crm.vtiger.contact;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;

/**
 * Test Script: Create Contact
 *
 * Purpose:
 * This script automates the creation of a new Contact
 * in the Vtiger CRM application.
 *
 * Test Flow:
 * 1. Launch Chrome browser
 * 2. Maximize browser window
 * 3. Configure implicit wait
 * 4. Navigate to Vtiger CRM application
 * 5. Login using valid credentials
 * 6. Navigate to Contacts module
 * 7. Open Create Contact page
 * 8. Enter Contact last name
 * 9. Save the Contact
 * 10. Verify the created Contact last name
 * 11. Logout from the application
 * 12. Close the browser
 *
 * Expected Result:
 * Contact should be created successfully and the
 * actual last name should match the entered last name.
 *
 * Application:
 * Vtiger CRM
 *
 * Browser:
 * Google Chrome
 *
 * Author: AutomationWithPiyush
 */
public class CreateContactTest {

	/**
	 * Main method to execute the Create Contact test.
	 *
	 * @param args command-line arguments
	 * @throws InterruptedException if thread execution is interrupted
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		
//		get data from json file
		String browser = FileUtility.getDataFromJsonFile("bro");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("un");
		String password = FileUtility.getDataFromJsonFile("pwd");

		System.out.println("==============================================");
		System.out.println("       CREATE Contact TEST STARTED       ");
		System.out.println("==============================================");

		// Open the browser
		System.out.println("[INFO] Launching Chrome browser...");

		WebDriver driver = null;
		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("edge"))
			driver = new EdgeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();

		System.out.println("[INFO] Maximizing browser window...");
		driver.manage().window().maximize();

		System.out.println("[INFO] Configuring implicit wait: 15 seconds...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Navigate to URL
		System.out.println("[INFO] Navigating to Vtiger CRM application...");
		driver.get(url);
		System.out.println("[INFO] Application launched successfully.");

		// Login
		System.out.println("[INFO] Starting login process...");

		WebElement usernameField = driver.findElement(By.name("user_name"));
		WebElement passwordField = driver.findElement(By.name("user_password"));
		WebElement loginButton = driver.findElement(By.id("submitButton"));

		System.out.println("[INFO] Entering username...");
		usernameField.sendKeys(username);

		System.out.println("[INFO] Entering password...");
		passwordField.sendKeys(password);

		System.out.println("[INFO] Clicking Login button...");
		loginButton.click();

		System.out.println("[INFO] Login process completed.");

		// Create Contact
		System.out.println("[INFO] Navigating to Contacts module...");
		driver.findElement(By.linkText("Contacts")).click();

		System.out.println("[INFO] Opening Create Contact page...");
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

//		get data from excel file
		String lastName = FileUtility.getDataFromExcelFile("contact", 1, 0);
		
		System.out.println("[INFO] Contact Last Name: " + lastName);

		WebElement lastNameField = driver.findElement(By.name("lastname"));

		System.out.println("[INFO] Entering Contact Last Name...");
		lastNameField.sendKeys(lastName);

		// Save
		System.out.println("[INFO] Saving Contact...");
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		System.out.println("[INFO] Contact save operation completed.");

		// Verification
		System.out.println("[INFO] Starting Contact creation verification...");

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		System.out.println("[INFO] Expected Last Name: " + lastName);
		System.out.println("[INFO] Actual Last Name: " + actLastName);

		if (actLastName.equals(lastName)) {
			System.out.println("[PASS] Contact Created Successfully...");
		}

		// Logout
		System.out.println("[INFO] Starting logout process...");

		WebElement profileIcon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);

		System.out.println("[INFO] Hovering over profile icon...");
		act.moveToElement(profileIcon).build().perform();

		System.out.println("[INFO] Clicking Sign Out...");
		driver.findElement(By.linkText("Sign Out")).click();

		System.out.println("[INFO] Logout completed successfully.");

		// Close the browser
		System.out.println("[INFO] Waiting for 2 seconds before closing browser...");
		Thread.sleep(2000);

		System.out.println("[INFO] Closing browser...");
		driver.quit();

		System.out.println("==============================================");
		System.out.println("          CREATE CONTACT TEST FINISHED       ");
		System.out.println("==============================================");
	}
}