package TestngTests;

import org.testng.annotations.Test;

public class DemoTests {

    @Test(priority = 3)
    public void abcd() {
        System.out.println("abcd");
    }

    @Test(priority = 10)
    public void lmn() {
        System.out.println("lmn");
    }

    @Test(priority = 20)
    public void amxd() {
        System.out.println("amxd");
    }

}
