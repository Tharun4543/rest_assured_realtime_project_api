package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
    private Workbook workbook;
    private org.apache.poi.ss.usermodel.Sheet sheet;

    // Constructor to load the Excel file
    public ExcelUtility(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0); // Assuming you want to work with the first sheet
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the row count of the sheet
    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    // Get the column count of a given row
    public int getColumnCount(int rowNum) {
        int col = sheet.getRow(rowNum).getLastCellNum();
        return col;
        
    }

    // Read data from a specific cell
    public String readData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        String cell = row.getCell(colNum).toString();
        return cell;
    }

    // Write data to a specific cell
    public void writeData(int rowNum, int colNum, String data) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.createCell(colNum);
        cell.setCellValue(data);
        try {
            FileOutputStream fos = new FileOutputStream("output.xlsx"); // Change the file name as needed
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Close the workbook
    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}