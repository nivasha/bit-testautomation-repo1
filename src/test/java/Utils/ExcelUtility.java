package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {
    private String path;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private FileInputStream file;

    public ExcelUtility(String path) throws IOException {
        this.path = path;
        file = new FileInputStream(path);
        workbook = new XSSFWorkbook(file);
    }

    public int getRowCount(String sheetname) {
        sheet = workbook.getSheet(sheetname);
        return sheet.getLastRowNum();
    }

    public int getColumnCount(String sheetname) {
        sheet = workbook.getSheet(sheetname);
        return sheet.getRow(1).getLastCellNum();
    }

    public Object[][] readDate(String sheetname) {
        try {
            int rows = getRowCount(sheetname);
            int columns = getColumnCount(sheetname);
            Object[][] testdata = new Object[rows][columns];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    testdata[r][c] = sheet.getRow(r + 1).getCell(c).toString();
                }
            }
            closeWorkbook();
            file.close();
            return testdata;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}
