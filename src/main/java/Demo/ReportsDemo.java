package Demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;

public class ReportsDemo {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        int hour = localDateTime.getHour();
        int nano = localDateTime.getNano();

        ExtentReports extent = new ExtentReports();

        ExtentSparkReporter spark = new ExtentSparkReporter("reports/harsha" + hour + "_" + nano + ".html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Selenium reports test");
        extent.attachReporter(spark);


        ExtentTest test1 = extent.createTest("Test 1");
        test1.info("donw with step 1");
        test1.info("donw with step 2");
        test1.info("donw with step 3");
        test1.fail("test 1 successful");

        test1.assignAuthor("Nandhini");
        test1.assignCategory("smoke");
        test1.assignDevice("Windows");

        ExtentTest test2 = extent.createTest("Test 2");
        test2.info("donw with step 1");
        test2.info("donw with step 2");
        test2.info("donw with step 3");
        test2.pass("test 1 successful");

        test2.assignAuthor("Manju");
        test2.assignCategory("Reg");
        test2.assignDevice("Linux");

        ExtentTest test3 = extent.createTest("Test 3");
        test3.info("donw with step 1");
        test3.info("donw with step 2");
        test3.info("donw with step 3");
        test3.pass("test 1 successful");

        test3.assignAuthor("Anusha");
        test3.assignCategory("Reg");
        test3.assignDevice("windows");

        ExtentTest test4 = extent.createTest("Test 4");
        test4.info("donw with step 1");
        test4.info("donw with step 2");
        test4.info("donw with step 3");
        test4.pass("test 1 successful");

        test4.assignAuthor("Harsha");
        test4.assignCategory("smoke");
        test4.assignDevice("linux");


        extent.flush();



    }

}
