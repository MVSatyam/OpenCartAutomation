package Utilities;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    FileInputStream input;
    FileOutputStream output;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        input = new FileInputStream(path);
        wb = new XSSFWorkbook(input);
        sheet = wb.getSheet(sheetName);

        return sheet.getLastRowNum();
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        input = new FileInputStream(path);
        wb = new XSSFWorkbook(input);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);

        return row.getLastCellNum();
    }

    public Object[][] getData(String sheetName, int rows, int cols) throws IOException {
        input = new FileInputStream(path);
        wb = new XSSFWorkbook(input);
        sheet = wb.getSheet(sheetName);

        List<Object[]> data = new ArrayList<>();

        for (int r = 0; r <= rows; r++) {
            List<String> rowData = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                rowData.add(String.valueOf(sheet.getRow(r).getCell(c)));
            }
            data.add(rowData.toArray(new Object[]{}));
        }

        return data.toArray(new Object[0][]);
    }

}
