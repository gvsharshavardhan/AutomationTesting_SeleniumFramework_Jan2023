package Demo;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ExcelDemo {
    XSSFWorkbook wb;

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() {

        String location = "./src/main/resources/TestData.xlsx";

        try {
            wb = new XSSFWorkbook(location);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = wb.getSheet("login");

        int noOfRows = sheet.getLastRowNum() + 1; //6
        int noOFColumns = sheet.getRow(0).getLastCellNum();//3

        String[][] data = new String[noOfRows - 1][noOFColumns]; //string[5][3] 0-4 0-2

        for (int i = 1; i < noOfRows; i++) {// 1,5
            XSSFRow row = sheet.getRow(i);

            data[i - 1][0] = row.getCell(0).getStringCellValue();
            data[i - 1][1] = row.getCell(1).getStringCellValue();
            data[i - 1][2] = row.getCell(2).getStringCellValue();

        }

        return data;
    }

}
