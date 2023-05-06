package TestngTests;

import Demo.ExcelDemo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest {

    @Test(dataProvider = "excelData", dataProviderClass = ExcelDemo.class)
    public void Test1(String[] a) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
        System.out.print(a[0] + " :: ");
        System.out.print(a[1] + " :: ");
        System.out.println(a[2]);
    }

    @DataProvider(name = "abcd")
    public Object[][] supplyData() {
        Integer[][] testdata = new Integer[3][3];
        testdata[0][0] = 100;
        testdata[0][1] = 200;
        testdata[0][2] = 300;

        testdata[1][0] = 10;
        testdata[1][1] = 20;
        testdata[1][2] = 30;

        testdata[2][0] = 1;
        testdata[2][1] = 2;
        testdata[2][2] = 3;
        return testdata;
    }

}
