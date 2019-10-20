package utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream excelFile = null;

    public FileInputStream readExcel(String fileName) {
        String filePath = System.getProperty("user.dir") + "\\Data\\"+fileName+".xlsx";
        File srcFile = new File(filePath);
        try {
            excelFile = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found, terminating process!! : Check file path of TestData ");
            System.exit(0);
        }
        return excelFile;
    }

    public Object[][] getExcelData(String fileName) throws IOException {
        excelFile = readExcel(fileName);
        XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workBook.getSheetAt(0);

        int TotalNumberOfRows = sheet.getLastRowNum() + 1;

        int TotalNumberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfColumns];

        for (int i = 0; i < TotalNumberOfRows; i++)
            for (int j = 0; j < TotalNumberOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }

        workBook.close();
        return arrayExcelData;
    }
}
