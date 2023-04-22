package GreenKartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertiesUtil;

import java.time.Duration;

import static driverManager.DriverManager.getDriver;

public class HomePage extends BasePage {

    //locators

    String HomePageURL = PropertiesUtil.getURL();
    By ItemsValueLocator = By.xpath("//td[contains(.,'Items')]/following-sibling::td/strong");
    By PriceValueLocator = By.xpath("//td[contains(.,'Price')]/following-sibling::td/strong");

    By BrocolliItemLocator = By.xpath("//h4[contains(.,'Brocolli')]");

    String addToCartXpath = "//h4[contains(.,'$$')]/parent::div//button";

    By cartIconLocator = By.xpath("//a[@class='cart-icon']");

    By proceedToCheckoutLocator = By.xpath("//button[contains(.,'PROCEED TO CHECKOUT')]");


    //methods, actions locators

    public void navigateToHomePage() {
        getDriver().get(HomePageURL);
    }

    public void waitUntilBrocolliElementIsVisible() {
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(BrocolliItemLocator));
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public int getItemsValueAsInteger() {
        return Integer.parseInt(getText(ItemsValueLocator));
    }

    public int getPriceValueAsInteger() {
        return Integer.parseInt(getText(PriceValueLocator));
    }

    public void addToCart(String veggie) {
        click(By.xpath(addToCartXpath.replace("$$", veggie)));
    }

    public void openCartIcon() {
        click(cartIconLocator);
    }

    public CheckoutPage proceedToCheckout() {
        click(proceedToCheckoutLocator);
        return new CheckoutPage();
    }

    public boolean isThankYouMessagePresentOnTheScreen(){
        return getDriver().findElements(By.xpath("//*[contains(.,'Thank you')]")).size()>0;
    }
}
