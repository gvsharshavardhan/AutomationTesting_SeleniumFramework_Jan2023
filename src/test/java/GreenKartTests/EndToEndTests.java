package GreenKartTests;

import GreenKartPages.CheckoutPage;
import GreenKartPages.CountryPage;
import GreenKartPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EndToEndTests extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void greenKartEndToEndTest() {

        homePage.navigateToHomePage();
        homePage.waitUntilBrocolliElementIsVisible();

        List<String> veggies = List.of("Orange", "Almonds");
        for (String veg : veggies) {
            homePage.addToCart(veg);
        }

        //Assert1
        int actualItemsCount = homePage.getItemsValueAsInteger();
        int expectedItemsCount = veggies.size();
        Assert.assertEquals(actualItemsCount, expectedItemsCount, "Veggies count is not as expected!!");

        homePage.openCartIcon();
        CheckoutPage checkoutPage = homePage.proceedToCheckout();

        checkoutPage.verifyPromoCodeIsApplied();

        int ActualDiscount = checkoutPage.getDiscount();
        int expectedDiscount = 10;
        Assert.assertEquals(ActualDiscount, expectedDiscount);

        List<String> actualProductsFromTheTable = checkoutPage.getProductsFromTheTable();
        Assert.assertTrue(actualProductsFromTheTable.containsAll(veggies), "All the veggies are not present in the table!");


        CountryPage countryPage = checkoutPage.placeOrder();
        countryPage.selectACountry("India");
        countryPage.agreeTermsAndConditions();
        countryPage.proceedToFinalpage();

        Assert.assertTrue(homePage.isThankYouMessagePresentOnTheScreen(), "Success message is not displayed on the screen!");

        homePage.waitUntilBrocolliElementIsVisible();
        Assert.assertEquals(homePage.getTitle(), "GreenKart - veg and fruits kart", "It did not navigate us to home page!");
    }
}
