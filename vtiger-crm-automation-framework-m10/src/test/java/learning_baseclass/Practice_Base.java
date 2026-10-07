package learning_baseclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Practice_Base {
	
	@BeforeSuite
	public void repConfig() {
		System.out.println("report configuration");
	}
	
	@BeforeClass
	public void setUp() {
		System.out.println("open browser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("login");
	}

	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}

	@AfterClass
	public void tearDown() {
		System.out.println("tearDown");
	}
	
	@AfterSuite
	public void repBackup() {
		System.out.println("report backup");
	}

}
