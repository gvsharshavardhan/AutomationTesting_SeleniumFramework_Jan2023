package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static driverManager.DriverManager.getDriver;

public class ScreenShotUtil {

    public static String takeScreenShot(){
       return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
