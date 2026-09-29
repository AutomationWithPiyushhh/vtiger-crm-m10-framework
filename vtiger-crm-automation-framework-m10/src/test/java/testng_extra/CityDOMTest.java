package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CityDOMTest {
	@Test(enabled = false)
	public void createNoida() {
		System.out.println("Noida created");
	}

	@Test(dependsOnMethods = "createNoida")
	public void modifyNoida() {
		Assert.assertTrue(false);
		System.out.println("Noida modified to Greater Noida");
	}

	@Test(dependsOnMethods = "modifyNoida")
	public void deleteGreaterNoida() {
		System.out.println("GreaterNoida deleted");
	}

}
