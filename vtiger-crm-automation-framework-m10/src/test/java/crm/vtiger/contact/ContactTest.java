package crm.vtiger.contact;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import junit.framework.Assert;

/**
 * Test Script: Create Contact
 *
 * Purpose: This script automates the creation of a new Contact in the Vtiger
 * CRM application.
 *
 * Test Flow: 1. Launch Chrome browser 2. Maximize browser window 3. Configure
 * implicit wait 4. Navigate to Vtiger CRM application 5. Login using valid
 * credentials 6. Navigate to Contacts module 7. Open Create Contact page 8.
 * Enter Contact last name 9. Save the Contact 10. Verify the created Contact
 * last name 11. Logout from the application 12. Close the browser
 *
 * Expected Result: Contact should be created successfully and the actual last
 * name should match the entered last name.
 *
 * Application: Vtiger CRM
 *
 * Browser: Google Chrome
 *
 * Author: AutomationWithPiyush
 */
public class ContactTest extends BaseClass {

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		ExtentTest test = report.createTest("createContactTest");
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		String lastName = FileUtility.getDataFromExcelFile("contact", 1, 0);
		WebElement lastNameField = driver.findElement(By.name("lastname"));
		lastNameField.sendKeys(lastName);

		// Save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// Verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertEquals(lastName, actLastName);
		test.log(Status.PASS, "this is passed");
	}
}