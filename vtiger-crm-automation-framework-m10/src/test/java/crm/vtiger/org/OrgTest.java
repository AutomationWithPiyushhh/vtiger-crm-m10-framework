package crm.vtiger.org;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.HomePage;
import junit.framework.Assert;

public class OrgTest extends BaseClass {

	@Test
	public void createOrgTest() throws IOException, ParseException, InterruptedException {

		long random = JavaUtility.generateRandomNumber();
		String orgName = FileUtility.getDataFromExcelFile("org", 3, 0) + random;

		Reporter.log("==============================================", true);
		Reporter.log("       CREATE ORGANIZATION TEST STARTED       ", true);
		Reporter.log("==============================================", true);

		HomePage hp = new HomePage(driver);

		Reporter.log("[INFO] Navigating to Organizations module...", true);
		hp.getOrgLink().click();

		Reporter.log("[INFO] Opening Create Organization page...", true);
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		Reporter.log("[INFO] Generated Organization Name: " + orgName, true);

		WebElement orgField = driver.findElement(By.name("accountname"));

		Reporter.log("[INFO] Entering Organization Name...", true);
		orgField.sendKeys(orgName);

		Reporter.log("[INFO] Opening member selection window...", true);
		driver.findElement(By.cssSelector("[src='themes/softed/images/select.gif']")).click();

		String PID = driver.getWindowHandle();

		Reporter.log("[INFO] Switching to member selection window...", true);
		wdUtil.switchToWindowByUrl("TasksEditView");

		String orgName2 = FileUtility.getDataFromExcelFile("org", 12, 0);

		Reporter.log("[INFO] Searching for organization/member: " + orgName2, true);
		driver.findElement(By.name("search_text")).sendKeys(orgName2 + Keys.ENTER);

		Reporter.log("[INFO] Selecting organization/member...", true);
		driver.findElement(By.xpath("//a[text()='" + orgName2 + "']")).click();

		Reporter.log("[INFO] Accepting alert...", true);
		driver.switchTo().alert().accept();

		Reporter.log("[INFO] Switching back to Organization window...", true);
		driver.switchTo().window(PID);

		Thread.sleep(3000);

		Reporter.log("[INFO] Saving Organization...", true);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		Reporter.log("[INFO] Organization save operation completed.", true);

		Reporter.log("[INFO] Starting Organization creation verification...", true);

		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		Reporter.log("[INFO] Expected Organization Name: " + orgName, true);
		Reporter.log("[INFO] Actual Organization Name: " + actOrgName, true);

		Assert.assertEquals(orgName, actOrgName);

		Reporter.log("==============================================", true);
		Reporter.log("       CREATE ORGANIZATION TEST FINISHED      ", true);
		Reporter.log("==============================================", true);
	}
}