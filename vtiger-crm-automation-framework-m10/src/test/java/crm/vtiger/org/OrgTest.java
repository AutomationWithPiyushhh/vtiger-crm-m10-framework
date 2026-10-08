package crm.vtiger.org;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.HomePage;

public class OrgTest extends BaseClass {
	
//	@Test
//	public void createLeadTest() {
//		System.out.println("creating leads for organization");
//		Assert.assertTrue(false);
//	}
	

	@Test
	public void createOrgTest() throws IOException, ParseException, InterruptedException {
//		report gen for particular test method
		ExtentTest test = report.createTest("createOrgTest");
				
		long random = JavaUtility.generateRandomNumber();
		String orgName = FileUtility.getDataFromExcelFile("org", 3, 0) + random;
		HomePage hp = new HomePage(driver);

		hp.getOrgLink().click();
		
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

		driver.findElement(By.cssSelector("[src='themes/softed/images/select.gif']")).click();
		String PID = driver.getWindowHandle();
		wdUtil.switchToWindowByUrl("TasksEditView");
		String orgName2 = FileUtility.getDataFromExcelFile("org", 12, 0);
		driver.findElement(By.name("search_text")).sendKeys(orgName2 + Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='" + orgName2 + "']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().window(PID);

		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		Assert.assertEquals(orgName, actOrgName+"abc");

		test.log(Status.FAIL, "Test script got failed...");
	}
}