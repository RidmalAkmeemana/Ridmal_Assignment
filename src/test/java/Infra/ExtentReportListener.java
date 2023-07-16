package Infra;

import Pages.RegisterPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener
{
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private WebDriver driver;

    public void onStart(ITestContext context) {

        RegisterPage registerPage = new RegisterPage(driver);
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Description", "Testing");
        extent.setSystemInfo("APP URL", registerPage.setUrl());
        extent.setSystemInfo("Name of QA", "Ridmal Akmeemana");
        extent.setSystemInfo("OS", System.getProperty("os.name"));

        sparkReporter.config().setDocumentTitle("Report");
        sparkReporter.config().setReportName("Testing");
        sparkReporter.config().setTheme(Theme.DARK);
        //sparkReporter.config().setTimelineEnabled(true);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public void onTestStart(ITestResult result) {

        String methodName = result.getMethod().getMethodName();

        String testName = methodName;
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {

        test.get().pass(MarkupHelper.createLabel("TEST PASSED", ExtentColor.GREEN));

    }

    public void onTestFailure(ITestResult result) {

        test.get().fail(MarkupHelper.createLabel("TEST FAILED", ExtentColor.RED));
        test.get().fail(result.getThrowable());

    }

    public void onTestSkipped(ITestResult result) {

        test.get().skip(MarkupHelper.createLabel("TEST PASSED", ExtentColor.ORANGE));
        test.get().skip(result.getThrowable());

    }
}
