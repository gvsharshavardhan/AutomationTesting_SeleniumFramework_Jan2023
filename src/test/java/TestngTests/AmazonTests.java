package TestngTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTests {

    @Test(testName = "Am test 1")
    public void amazonTest1(){
        Assert.assertTrue(true);
    }

    @Test(testName = "Am test 2")
    public void amazonTest2(){
        Assert.assertTrue(false);
    }

//    @Test
    public void amazonTest3(){
        Assert.assertTrue(false);
    }
}
