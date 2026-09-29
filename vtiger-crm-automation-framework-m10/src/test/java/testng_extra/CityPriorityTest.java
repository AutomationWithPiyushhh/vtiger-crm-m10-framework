package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CityPriorityTest {
	@Test(priority = -1)
	public void createNoida() {
		System.out.println("Noida created");
	}
	
	
	@Test
	public void modifyNoida() {
		Assert.assertTrue(false);
		System.out.println("Noida modified to Greater Noida");
	}
	
	@Test(priority = 1)
	public void deleteGreaterNoida() {
		System.out.println("GreaterNoida deleted");		
	}

}	
