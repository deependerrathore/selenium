package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	public void writeToExcelFile(String filePath, String fileName, String sheetName,String[] dataToWrite) throws IOException {
		
		File file = new File(filePath+"/"+fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		String excelFileExtension = fileName.substring(fileName.indexOf("."));
		
		Workbook excelDemoFile = null;
		
		if (excelFileExtension.equals(".xlsx")) {
			excelDemoFile = new XSSFWorkbook(fis);
		} else if(excelFileExtension.equals(".xls")){
			excelDemoFile = new HSSFWorkbook(fis);
		}else {
			System.out.println("Invalid file exceltion");
			//IOException io = new IOException("Invalid file extension");
		}
		
		Sheet excelDemoSheet = excelDemoFile.getSheet(sheetName);
		
		int rowCount = excelDemoSheet.getLastRowNum() - excelDemoSheet.getFirstRowNum();
		
		//Get the first row from the sheet
		Row row = excelDemoSheet.getRow(0);
		
		
		//Create a new row and append it at last of sheet
		Row newRow = excelDemoSheet.createRow(rowCount+1);
		
		//Create a loop over the cell of newly created Row
		for (int i = 0; i < row.getLastCellNum(); i++) {
			//Fill data to last row
			Cell cell = newRow.createCell(i);
			cell.setCellValue(dataToWrite[i]);
		}
		
		//Close Input Stream
		fis.close();
		
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream fos = new FileOutputStream(file);
		
		//Write data to excel file
		excelDemoFile.write(fos);
		
		//Close the output stream
		fos.close();
	}
	public static void main(String[] args) throws IOException {
		WriteExcelFile wef = new WriteExcelFile();
		String filePath = System.getProperty("user.dir")+"/src/excel/";
		
		//Create an array with the data in the same order in which you expect to be filled in excel file

        String[] valueToWrite = {"Rahul","Engineer"};
		wef.writeToExcelFile(filePath, "Exceldata.xlsx", "Sheet1",valueToWrite);
	}
}
