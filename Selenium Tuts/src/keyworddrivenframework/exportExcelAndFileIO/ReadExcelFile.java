package keyworddrivenframework.exportExcelAndFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {
	public Sheet readExcel(String filePath , String fileName, String sheetName) throws IOException {
		File file = new java.io.File(filePath+"/"+fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		Workbook testCaseWorkBook = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			testCaseWorkBook = new XSSFWorkbook(fis); 
		}else if(fileExtensionName.equals(".xls")){
			testCaseWorkBook = new HSSFWorkbook(fis);
		}
		
		
		Sheet testcaseSheet = testCaseWorkBook.getSheet(sheetName);
		return testcaseSheet;
		
	}
}
