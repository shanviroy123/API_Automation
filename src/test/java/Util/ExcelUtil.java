package Util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtil {
    public static Object[][] getData(String filePath, String SheetName) throws Exception {
        try {
            FileInputStream file= new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet= workbook.getSheet(SheetName);
            int rowCount= sheet.getPhysicalNumberOfRows();
            int colCount= sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rowCount-1][colCount];
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                String firstCell =
                        row.getCell(0).toString();
                if(firstCell.equalsIgnoreCase("END")) {
                    break;
                }
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }
            workbook.close();
            return data;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
