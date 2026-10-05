package learning_reports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class SauceDemoTest {
	@Test
	public void login() {
//		configuration
		String time = JavaUtility.getCurrentDateTime();
		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_reports/" + time + ".html");

		spark.config().setDocumentTitle("sauce demo reports");
		spark.config().setReportName("login reports");
		spark.config().setTheme(Theme.DARK);

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "edge");
		report.setSystemInfo("window", "11");

//		creates a report for test
		ExtentTest test = report.createTest("login");

		System.out.println("browser opened");
		System.out.println("logged in successfully !!");

		test.log(Status.PASS, "passed");
		test.log(Status.FAIL, "failed");
		test.log(Status.SKIP, "skipped");
		test.log(Status.WARNING, "warning");
		test.log(Status.INFO, "just info");

//		backup
		report.flush();
	}
}
