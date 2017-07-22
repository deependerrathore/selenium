package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	public void writeToExcelFile(String filePath, String fileName, String sheetName) throws IOException {
		
		File file = new File(filePath+"/"+fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		String excelFileExtension = fileName.substring(fileName.indexOf("."));
		
		Workbook excelDemoFile = null;
		
		if (excelFileExtension.equals(".xlsx")) {
			excelDemoFile = new XSSFWorkbook(fis);
		} else if(excelFileExtension.equals(".xls")){
			excelDemoFile = new HSSFWorkbook(fis);
		}else {
			IOException io = new IOException("Invalid file extension");
		}
		
		Sheet excelDemoSheet = excelDemoFile.getSheet(sheetName);
		
		int rowCount = excelDemoSheet.getLastRowNum() - excelDemoSheet.getFirstRowNum();
		for (int i = 0; i < rowCount; i++) {
			Row row = excelDemoSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"||");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) throws IOException {
		WriteExcelFile wef = new WriteExcelFile();
		String filePath = System.getProperty("user.dir")+"/src/excel";
		wef.writeToExcelFile(filePath, "ExcelDemoFile.xls", "Sheet1");
	}
}
