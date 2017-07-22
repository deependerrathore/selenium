package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFIle {
  @Test
  public void readExcel(String filePath,String fileName,String sheetName) throws IOException {
	  //Create an Object of file class to open xlsx/xls file
	  File file = new File(filePath+"/"+fileName);
	  
	  //Create an Object of FileInputStream class to read excel
	  FileInputStream fis = new FileInputStream(file);
	  
	  Workbook excelDemoFile = null;
	  //Find the file extension by splitting file name in substring  and getting only extension name
	  //System.out.println(fileName.indexOf("."));
	  String fileExtensionName = fileName.substring(fileName.indexOf("."));
	  //System.out.println(fileExtensionName);
	  //Check condition if the file is xlsx file
	  if(fileExtensionName.equals(".xlsx")){
		  excelDemoFile = new XSSFWorkbook(fis); 
	  }else if (fileExtensionName.equals(".xls")) {
		  excelDemoFile = new HSSFWorkbook(fis);
	  }else {
		  System.out.println("Invalid file extension");
	  }
	  
	  //Read sheet inside the workbook by its name
	  Sheet demoSheet = excelDemoFile.getSheet(sheetName);
	  
	  //Find number of rows in excel file
	  int rowCount = demoSheet.getLastRowNum() - demoSheet.getFirstRowNum();
	  
	  //Create a loop over all the rows of excel file to read it
	  for (int i = 0; i < rowCount; i++) {
		  Row row = demoSheet.getRow(i);
		  //Create a loop to print cell values in a row
		  for (int j = 0; j < row.getLastCellNum(); j++) {
			  //Print Excel data in console
			  System.out.print(row.getCell(j).getStringCellValue()+"||");
		  }
		  
		  System.out.println();
	  }

	  
	  
  }
  
  //Main function is calling readExcel function to read data from excel file
  public static void main(String[] args) throws IOException {
	  ReadExcelFIle ref = new ReadExcelFIle();
	  //Prepare the path of excel file
	  String filePath = System.getProperty("user.dir")+"/src/excel/";
	  
	  ref.readExcel(filePath, "ExcelDemoFile.xls", "Sheet1");
  }
}
