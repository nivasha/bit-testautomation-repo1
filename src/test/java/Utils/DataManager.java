package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataManager {

    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    public static Object[][] getCredentials(String sheetname){

        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/TestData/Data.xlsx");
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetname);
            int totalRows = sheet.getLastRowNum();
            int totalColumns = sheet.getRow(1).getLastCellNum();

            Object[][] testData = new Object[totalRows][totalColumns];
            for(int rowIndex = 0; rowIndex < totalRows; rowIndex++){
                for(int colIndex = 0; colIndex < totalColumns; colIndex++){
                    testData[rowIndex][colIndex] = sheet.getRow(rowIndex+1).getCell(colIndex).toString();
                }
            }
            workbook.close();
            file.close();
            return testData;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //test comment
}
