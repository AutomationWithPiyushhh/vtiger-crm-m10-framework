package learning_baseclass;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Practice_Base {
	
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
	


}
