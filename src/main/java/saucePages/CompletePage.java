package saucePages;

import GreenKartPages.BasePage;
import GreenKartPages.HomePage;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import util.ReporterUtil;
import util.ScreenShotUtil;

public class CompletePage extends BasePage {

    By headerLocator = By.xpath("//h2[contains(@class,'complete-header')]");
    By backhomelOCATOR = By.xpath("//button[contains(.,'Back Home')]");

    public String getHeaderMessage() {
        String abcd = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info( MediaEntityBuilder.createScreenCaptureFromBase64String(abcd).build());
        return getText(headerLocator);

    }

    public HomePage goToHomePage() {
        click(backhomelOCATOR);
        return new HomePage();
    }

}