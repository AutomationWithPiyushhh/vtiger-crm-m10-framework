package learning_baseclass;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class OrgTest extends Practice_Base {
	@Test
	public void createOrgTest() {
		Reporter.log("create Org", true);
		Reporter.log("verify Org", true);
	}
}
