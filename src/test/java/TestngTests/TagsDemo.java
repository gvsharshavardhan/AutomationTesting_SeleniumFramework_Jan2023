package TestngTests;

import HarshaProject.HarshaFile;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TagsDemo {

    @Test(testName = "first test", timeOut = 2000)
    public void m1() throws InterruptedException {
//        Thread.sleep(2500);
        System.out.println("m1 test");
    }

    @Test(dependsOnMethods = {"m3","m1"})
    public void m2() {
        System.out.println("m2 test");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void m3() {
        System.out.println("m3 test");
        throw new ArithmeticException("harsha is throwing this exception");

    }

    @Test
    @Parameters("browserName")
    public void m4(String browser){
        System.out.println(browser);
        //implementation is going on
    }


    @Test
    public void testHarshaJar(){
        HarshaFile harshaFile = new HarshaFile();
        harshaFile.m1();
    }

}