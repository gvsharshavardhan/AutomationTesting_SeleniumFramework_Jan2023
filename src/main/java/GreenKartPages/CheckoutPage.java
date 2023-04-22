package GreenKartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static driverManager.DriverManager.getDriver;

public class CheckoutPage extends BasePage {

    //locators
    By enterPromoCodeFieldLocator = By.xpath("//input[@placeholder='Enter promo code']");
    By applyButton = By.xpath("//button[@class='promoBtn']");
    By placeOrderButton = By.xpath("//button[contains(.,'Place Order')]");
    By promoInfo = By.xpath("//span[@class='promoInfo']");
    By discountPercentage = By.xpath("//span[@class='discountPerc']");
    By productsFromTable = By.xpath("//tbody//tr//td[2]/p");

    //methods
    //          https://rahulshettyacademy.com/seleniumPractise/#/cart
    //String[] abc =  ["https://rahulshettyacademy", "com/seleniumPractise/#/cart"]
    //abc[0].split("//") -> ["https:","rahulshettyacademy"]


    public String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getPromoCodeFromURL() {
        return getUrl().split(".com")[0].replace("https://","");
    }

    public void verifyPromoCodeIsApplied() {
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(enterPromoCodeFieldLocator));
        getDriver().findElement(enterPromoCodeFieldLocator).sendKeys(getPromoCodeFromURL());
        click(applyButton);
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(promoInfo));
    }

    public int getDiscount() {
        return Integer.parseInt(getText(discountPercentage).replace("%", ""));
    }

    public List<String> getProductsFromTheTable() {
        List<WebElement> products = getDriver().findElements(productsFromTable);
        List<String> productsFromTable = new ArrayList<>();
        for (WebElement product : products) {
            productsFromTable.add(product.getText().split("-")[0].trim());
        }
        return productsFromTable;
    }

    public CountryPage placeOrder() {
        click(placeOrderButton);
        return new CountryPage();
    }
}
