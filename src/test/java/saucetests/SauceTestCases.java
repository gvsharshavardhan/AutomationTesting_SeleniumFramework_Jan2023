package saucetests;

import GreenKartTests.BaseTest;
import org.testng.annotations.Test;
import saucePages.CompletePage;
import saucePages.SauceLoginPage;

public class SauceTestCases extends BaseTest {
    SauceLoginPage sauceLoginPage = new SauceLoginPage();

    @Test
    public void oneItemTest() {

        CompletePage completePAGE = sauceLoginPage.login().singleItemCheckout().enterInfo();
        System.out.println(completePAGE.getHeaderMessage());
        completePAGE.goToHomePage();
    }

    @Test
    public void allItemTest() {
        CompletePage completePage = sauceLoginPage.login().allItemsCheckout().enterInfo();
        System.out.println(completePage.getHeaderMessage());
        completePage.goToHomePage();
    }

}