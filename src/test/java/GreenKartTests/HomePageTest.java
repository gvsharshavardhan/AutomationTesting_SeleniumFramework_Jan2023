package GreenKartTests;

import GreenKartPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();


    @Test
    public void PageTitleTest() {
        homePage.navigateToHomePage();
        homePage.waitUntilBrocolliElementIsVisible();

        String actualTitle = homePage.getTitle();
        String expectedTitle = "GreenKart - veg and fruits kart123";

        Assert.assertEquals(actualTitle, expectedTitle, "Page Title is not as Expected!");
    }


    @Test
    public void DefaultPriceAndItemsTest() {


        homePage.navigateToHomePage();
        homePage.waitUntilBrocolliElementIsVisible();

        Assert.assertEquals(homePage.getItemsValueAsInteger(), 0, "Items default value is not 0!!");
        Assert.assertEquals(homePage.getPriceValueAsInteger(), 0, "Price default value is not 0!!");


    }


}
