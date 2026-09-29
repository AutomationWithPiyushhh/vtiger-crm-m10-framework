package testng_extra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPDemoTest {
	@Test(dataProvider = "getData")
	public void login(String un, String pwd) {
//		String un = "admin";
//		String pwd = "admin@123";

		System.out.println("username is : " + un);
		System.out.println("password is : " + pwd);
	}

//	Mark a method as supplying data for a test method.
	@DataProvider
	public Object[][] getData() {

		Object[][] creds = new Object[4][2];
//							num of row => num of execution
//							num of col => num of parameters

		creds[0][0] = "sid";
		creds[0][1] = "1234";

		creds[1][0] = "krishna";
		creds[1][1] = "67890";

		creds[2][0] = "anugrah";
		creds[2][1] = "anu@123";

		creds[3][0] = "Arushi";
		creds[3][1] = "KuchBhi";

		return creds;
	}

}
