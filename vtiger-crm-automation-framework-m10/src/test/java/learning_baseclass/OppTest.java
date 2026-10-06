package learning_baseclass;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class OppTest extends BaseClass {
	@Test
	public void createOppTest() {
		Reporter.log("create Opp", true);
		Reporter.log("verify Opp", true);
	}
}
