package learning_baseclass;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class ContactTest extends Practice_Base {
	@Test
	public void createContactTest() {
		Reporter.log("create contact", true);
		Reporter.log("verify contact", true);
	}
}
