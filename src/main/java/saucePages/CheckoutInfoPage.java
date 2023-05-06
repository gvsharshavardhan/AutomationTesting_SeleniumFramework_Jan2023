package saucePages;

import GreenKartPages.BasePage;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import util.ReporterUtil;
import util.ScreenShotUtil;

public class CheckoutInfoPage extends BasePage {
    By firstnameLocator = By.xpath("//*[contains(@placeholder,'First Name')]");
    By lastNameLocator = By.xpath("//*[contains(@placeholder,'Last Name')]");
    By postalCodeLocator = By.xpath("//*[contains(@placeholder,'Postal')]");
    By continueLocator = By.xpath("//*[contains(@value,'Continue')]");

    By finishLocator = By.xpath("//button[contains(.,'Finish')]");

    public CompletePage enterInfo() {
       sendKeys(firstnameLocator,"harsha");
       sendKeys(lastNameLocator,"vardhan");
       sendKeys(postalCodeLocator,"ab36s2");
       click(continueLocator);
       click(finishLocator);
        String abcd = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(abcd).build());
       return new CompletePage();
    }
}
