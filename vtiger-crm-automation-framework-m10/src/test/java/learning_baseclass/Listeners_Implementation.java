package learning_baseclass;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class Listeners_Implementation implements ISuiteListener, ITestListener {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;

	@Override
	public void onStart(ISuite suite) {
		String time = JavaUtility.getCurrentDateTime();
		spark = new ExtentSparkReporter("./ad_reports/" + time + ".html");

		spark.config().setDocumentTitle("sauce demo reports");
		spark.config().setReportName("login reports");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "edge");
		report.setSystemInfo("window", "11");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest test = report.createTest(result.getName());
		test.log(Status.PASS, result.getName() + " passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest test = report.createTest(result.getName());
		test.log(Status.FAIL, result.getName() + " failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTest test = report.createTest(result.getName());
		test.log(Status.SKIP, result.getName() + " skipped");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

}
