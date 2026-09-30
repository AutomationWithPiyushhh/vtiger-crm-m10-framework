package types_of_exe;

import org.testng.annotations.Test;

public class LeadTest {

	@Test(groups = {"smoke", "reg"})
	public void createLeadTest() {
		System.out.println("Lead created");
	}

	@Test(groups = "reg")
	public void modifyLeadTest() {
		System.out.println("Lead modified");
	}

	@Test(groups = "reg")
	public void deleteLeadTest() {
		System.out.println("Lead deleted");
	}
}
