package saucePages;

import GreenKartPages.BasePage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import org.openqa.selenium.By;
import util.PropertiesUtil;
import util.ReporterUtil;
import util.ScreenShotUtil;

import static driverManager.DriverManager.getDriver;

public class SauceLoginPage extends BasePage {
    //locators
    By loginLocator = By.xpath("//*[contains(@value,'Login')]");
    By username = By.xpath("//input[contains(@placeholder,'Username')]");
    By password = By.xpath("//input[contains(@placeholder,'Password')]");


    //methods
    public ProductsPage login() {
        getDriver().get(PropertiesUtil.getValueFromPropertyFile("sauceURL"));
        String abcd = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(abcd).build());
        ReporterUtil.getTest().info("Logged into the application :: " + PropertiesUtil.getValueFromPropertyFile("sauceURL"));
        getDriver().findElement(username).sendKeys(PropertiesUtil.getValueFromPropertyFile("sauceUsername"));
        ReporterUtil.getTest().info("entered username as: " + PropertiesUtil.getValueFromPropertyFile("sauceUsername"));
        getDriver().findElement(password).sendKeys(PropertiesUtil.getValueFromPropertyFile("saucePassword"));
        ReporterUtil.getTest().info("entered passowrd as: " + PropertiesUtil.getValueFromPropertyFile("saucePassword"));
        click(loginLocator);
        ReporterUtil.getTest().info("clicked on login button");
        return new ProductsPage();
    }


}
