package GreenKartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertiesUtil;
import util.ReporterUtil;

import java.time.Duration;

import static driverManager.DriverManager.getDriver;

public class BasePage {


    public void click(By by) {
        ReporterUtil.getTest().info("Clicked on :" + by.toString());
        waitUntilEleIsVisible(by).click();
    }

    public String getText(By by) {

        String text = waitUntilEleIsVisible(by).getText().trim();
        ReporterUtil.getTest().info("Getting text from screen: " + text);
        return text;
    }

    public WebDriverWait explicitWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(PropertiesUtil.getExplicitTimeOutInSeconds()));
    }

    public WebElement waitUntilEleIsVisible(By by) {
        return explicitWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getElement(By by) {
        return waitUntilEleIsVisible(by);
    }

    public void mySleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendKeys(By by, String text) {
        ReporterUtil.getTest().info("sending text: " + text);
        waitUntilEleIsVisible(by).sendKeys(text);
    }

}
