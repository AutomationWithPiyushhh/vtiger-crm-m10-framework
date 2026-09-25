package testng_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {

	public static void main(String[] args) {
		System.out.println("Hi there...");
	}
	
	@Test
	public void case1() {
		Reporter.log("Hi there...", true);
	}

	
}
