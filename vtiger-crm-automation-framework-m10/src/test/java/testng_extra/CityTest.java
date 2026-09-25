package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CityTest {
	@Test
	public void createNoida() {
		System.out.println("Noida created");
	}
	
	
	@Test
	public void modifyNoida() {
		System.out.println("Noida modified to Greater Noida");
	}
	
	@Test
	public void deleteGreaterNoida() {
//		if(false)
//			System.out.println("GreaterNoida deleted");
//		else
//			System.out.println("GreaterNoida couldn't be deleted");
		
		Assert.assertTrue(true, "Couldn't create greater noida");
		System.out.println("GreaterNoida deleted");
			
	}

}	
