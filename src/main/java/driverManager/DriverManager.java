package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.PropertiesUtil;

public class DriverManager {

    private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
    private static WebDriver driver;

    public static void InitiateDriver() {
        String browser = PropertiesUtil.getBrowserName();
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        tl.set(driver);
//        driver.manage().window().maximize();
    }


    public static WebDriver getDriver() {
        return tl.get();
    }

    public static void quitBrowser() {
        tl.get().quit();
    }
}
