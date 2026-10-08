package learning_baseclass;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(learning_baseclass.Listeners_Implementation.class)
public class OrgTest extends Practice_Base {
	@Test
	public void createOrgTest() {
		System.out.println("create Org");
	}
	
	@Test
	public void modifyOrgTest() {
		System.out.println("modify Org");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "modifyOrgTest")
	public void deleteOrgTest() {
		System.out.println("delete Org");
	}
}
