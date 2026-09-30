package types_of_exe;

import org.testng.annotations.Test;

public class OrgTest {

	@Test(groups = "smoke")
	public void createOrgTest() {
		System.out.println("org created");
	}

	@Test(groups = "reg")
	public void modifyOrgTest() {
		System.out.println("org modified");
	}

	@Test(groups = "reg")
	public void deleteOrgTest() {
		System.out.println("org deleted");
	}
}
