package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;

public class ReporterUtil {
    private static ExtentReports extentReports = new ExtentReports();

    private static ThreadLocal<ExtentTest> tl = new ThreadLocal<>();
    private static ExtentTest test;

    public static void createReport(String name) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String time = localDateTime.getHour() + "_" +
                localDateTime.getMinute() + "_" +
                localDateTime.getSecond();

        ExtentSparkReporter spark = new ExtentSparkReporter("reports/spark_" + time + ".html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(name);
        extentReports.attachReporter(spark);
    }

    public static void flushReport() {
        extentReports.flush();
    }

    public static void createTest(String testCaseName) {
        test = extentReports.createTest(testCaseName);
        tl.set(test);
    }

    public static ExtentTest getTest() {
        return tl.get();
    }

}