package listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.ReporterUtil;
import util.ScreenShotUtil;

public class FrameworkListener implements ISuiteListener, ITestListener {

    @Override
    public void onStart(ISuite suite) {
        ReporterUtil.createReport(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        ReporterUtil.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReporterUtil.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReporterUtil.getTest().pass("PASSED!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReporterUtil.getTest().fail("FAILED!!");
        String abcd = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(abcd).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReporterUtil.getTest().skip("Skipped!!");

    }


}
