package testNg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static void main(String[] args) throws FileNotFoundException {
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;
	
		
		String path = "C:\\Users\\Siva\\Desktop\\sree\\ExcelRead.xlsx\\";
		String sheetName = "Sheet1";
		
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			Cell = ExcelWSheet.getRow(0).getCell(0);
			String cellData = Cell.getStringCellValue();
			System.out.println(cellData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
