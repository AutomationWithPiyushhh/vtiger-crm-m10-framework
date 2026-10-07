package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public WebDriverUtility wdUtil;
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	
	@BeforeSuite
	public void repConfig() {
//		configuration
		String time = JavaUtility.getCurrentDateTime();
		spark = new ExtentSparkReporter("./ad_reports/" + time + ".html");

		spark.config().setDocumentTitle("sauce demo reports");
		spark.config().setReportName("login reports");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "edge");
		report.setSystemInfo("window", "11");
	}

	@BeforeClass
	public void setUp() throws IOException, ParseException {
		// Open browser
		String browser = FileUtility.getDataFromJsonFile("bro");
		Reporter.log("[INFO] Launching " + browser + " browser...", true);

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

		wdUtil = new WebDriverUtility(driver);

		// Maximize browser
		Reporter.log("[INFO] Maximizing browser window...", true);
		wdUtil.maxWin();

		// Configure implicit wait
		Reporter.log("[INFO] Configuring implicit wait: 15 seconds...", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@BeforeMethod
	public void login() throws IOException, ParseException {

		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("un");
		String password = FileUtility.getDataFromJsonFile("pwd");
		LoginPage lp = new LoginPage(driver);

		// Navigate to URL
		Reporter.log("[INFO] Navigating to Vtiger CRM application...", true);
		driver.get(url);
		Reporter.log("[INFO] Application launched successfully.", true);

		// Login
		Reporter.log("[INFO] Starting login process...", true);
		lp.login(username, password);
		Reporter.log("[INFO] Login process completed successfully.", true);
	}

	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);

		// Logout
		Reporter.log("[INFO] Starting logout process...", true);
		WebElement profileIcon = hp.getProfileIcon();
		Reporter.log("[INFO] Hovering over profile icon...", true);

		wdUtil.hover(profileIcon);
		Reporter.log("[INFO] Clicking Sign Out...", true);

		driver.findElement(By.linkText("Sign Out")).click();
		Reporter.log("[INFO] Logout completed successfully.", true);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		// Close browser
		Reporter.log("[INFO] Closing browser...", true);
		driver.quit();
	}
	
	@AfterSuite
	public void repBackup() {
		report.flush();
	}
}
