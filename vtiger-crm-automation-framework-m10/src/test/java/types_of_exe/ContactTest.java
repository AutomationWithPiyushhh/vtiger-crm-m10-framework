package types_of_exe;

import org.testng.annotations.Test;

public class ContactTest {

	@Test(groups = "reg")
	public void createContactTest() {
		System.out.println("Contact created");
	}

	@Test(groups = "smoke")
	public void modifyContactTest() {
		System.out.println("Contact modified");
	}

	@Test(groups = "smoke")
	public void deleteContactTest() {
		System.out.println("Contact deleted");
	}
}
