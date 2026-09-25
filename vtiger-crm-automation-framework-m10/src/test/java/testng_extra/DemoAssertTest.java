package testng_extra;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoAssertTest {
	@Test
	public void hardAssertion() {
		boolean s1 = true;
		boolean s2 = false;
		
		String str1 = "abc";
		String str2 = "xyz";
		String str3 = "abc";
		
		Object obj1 = null;
		Object obj2 = new Object();
		
//		Assert.assertTrue(s1);
//		Assert.assertFalse(s2);
//		Assert.assertEquals(str1, str3);
//		Assert.assertNull(obj1);
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertTrue(s2);
		sa.assertFalse(s1);
		sa.assertEquals(str2, str3);
		sa.assertNull(obj2);
		
//		sa.assertAll();
		
		
		
		
		
		
	}
}
