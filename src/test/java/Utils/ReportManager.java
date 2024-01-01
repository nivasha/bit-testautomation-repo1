package Utils;

import Tests.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager implements ITestListener {


    private ExtentReports extentReports;
    private ExtentTest test;
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test = extentReports.createTest(iTestResult.getName());
        test.log(Status.PASS,"Test case passed successfully");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test = extentReports.createTest(iTestResult.getName());
        test.log(Status.FAIL,"Test case Failed");
        test.log(Status.FAIL,"Reason for failure "+iTestResult.getThrowable().getMessage());

        String imgPath = new TestBase().captureScreenshot(iTestResult.getName());
        test.addScreenCaptureFromPath("."+imgPath);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test = extentReports.createTest(iTestResult.getName());
        test.log(Status.SKIP,"Test case is skipped");
        test.log(Status.SKIP,"Reason for skipping "+iTestResult.getThrowable().getMessage());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repname = "Test_Report_"+timeStamp+".html";
       // ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repname);
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./"+TestBase.resource.getString("reports")+repname);
        extentSparkReporter.config().setReportName("Website Central Test Reports");
        extentSparkReporter.config().setDocumentTitle("Automation Tests");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Application","BitDefender Website Central");
        extentReports.setSystemInfo("Username",System.getProperty("user.name"));
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();

    }
}
