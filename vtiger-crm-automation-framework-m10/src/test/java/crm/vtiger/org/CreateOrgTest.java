package crm.vtiger.org;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
 * Test Flow: 1. Launch Chrome browser 2. Maximize browser window 3. Configure
 * implicit wait 4. Navigate to Vtiger CRM application 5. Login using valid
 * credentials 6. Navigate to Organizations module 7. Open Create Organization
 * page 8. Generate a unique organization name 9. Enter organization name 10.
 * Save the organization 11. Verify the created organization name 12. Logout
 * from the application 13. Close the browser
 *
 * Expected Result: Organization should be created successfully and the actual
 * organization name should match the generated name.
 *
 * Application: Vtiger CRM
 *
 * Browser: Google Chrome
 *
 * Author: AutomationWithPiyush
 */
public class CreateOrgTest {

	/**
	 * It is the method to create organization in vtiger crm application
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		
//		get data from json file
//		FileReader fr = new FileReader("./src/test/resources/cd.json");
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(fr);
//		JSONObject jObj = (JSONObject) obj;
//		String browser = jObj.get("bro").toString();
//		String url = jObj.get("url").toString();
//		String username = jObj.get("un").toString();
//		String password = jObj.get("pwd").toString();

//		get data from json file
		String browser = FileUtility.getDataFromJsonFile("bro");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("un");
		String password = FileUtility.getDataFromJsonFile("pwd");

		long random = JavaUtility.generateRandomNumber();

		String orgName = FileUtility.getDataFromExcelFile("org", 3, 0) + +random;

		System.out.println("==============================================");
		System.out.println("       CREATE ORGANIZATION TEST STARTED       ");
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

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		
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

		
		WebElement usernameField = lp.getUsername();
		WebElement passwordField = lp.getPassword();
		WebElement loginButton = lp.getLoginButton();

		System.out.println("[INFO] Entering username...");
		usernameField.sendKeys(username);

		System.out.println("[INFO] Entering password...");
		passwordField.sendKeys(password);

		System.out.println("[INFO] Clicking Login button...");
		loginButton.click();

		System.out.println("[INFO] Login process completed.");

		// Create Organization
//		get data from excel file
//		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("org");
//		Row row = sh.getRow(3);
//		Cell cell = row.getCell(0);
//		String orgName = cell.getStringCellValue() + random;

//		String orgName = FileUtility.getDataFromExcelFile("org", 3, 0) + +random;
		System.out.println("[INFO] Navigating to Organizations module...");
//		driver.findElement(By.linkText("Organizations")).click();
		hp.getOrgLink().click();

		System.out.println("[INFO] Opening Create Organization page...");
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

//		String orgName = "google_" + random;

		System.out.println("[INFO] Generated Organization Name: " + orgName);

		WebElement orgField = driver.findElement(By.name("accountname"));

		System.out.println("[INFO] Entering Organization Name...");
		orgField.sendKeys(orgName);

		// Save
		System.out.println("[INFO] Saving Organization...");
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		System.out.println("[INFO] Organization save operation completed.");

		// Verification
		System.out.println("[INFO] Starting Organization creation verification...");

		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		System.out.println("[INFO] Expected Organization Name: " + orgName);
		System.out.println("[INFO] Actual Organization Name: " + actOrgName);

		if (actOrgName.equals(orgName)) {
			System.out.println("[PASS] Organization Created Successfully...");
		} else {
			System.out.println("[FAIL] Failed to create organization...");
		}

		// Logout
		System.out.println("[INFO] Starting logout process...");

		WebElement profileIcon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		System.out.println("[INFO] Hovering over profile icon...");

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

//		Actions act = new Actions(driver);
//		act.moveToElement(profileIcon).build().perform();

		wdUtil.hover(profileIcon);

		System.out.println("[INFO] Clicking Sign Out...");
		driver.findElement(By.linkText("Sign Out")).click();

		System.out.println("[INFO] Logout completed successfully.");

		// Close the browser
		System.out.println("[INFO] Waiting for 2 seconds before closing browser...");
		Thread.sleep(2000);

		System.out.println("[INFO] Closing browser...");
		driver.quit();

		System.out.println("==============================================");
		System.out.println("       CREATE ORGANIZATION TEST FINISHED     ");
		System.out.println("==============================================");
	}
}