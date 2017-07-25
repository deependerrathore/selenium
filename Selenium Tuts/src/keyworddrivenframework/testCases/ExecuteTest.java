package keyworddrivenframework.testCases;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import keyworddrivenframework.exportExcelAndFileIO.ReadExcelFile;
import keyworddrivenframework.operation.ReadObject;
import keyworddrivenframework.operation.UIOperation;

public class ExecuteTest {
  @Test
  public void testLogin() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
	  WebDriver driver = new FirefoxDriver();
	  ReadExcelFile file = new ReadExcelFile();
	  ReadObject object = new ReadObject();
	  UIOperation operation = new UIOperation(driver);
	  Properties allObjects = object.getObjectRepository();
	  
	  //Read Keyword sheet
	  Sheet testSheet = file.readExcel(System.getProperty("user.dir")+"/src/keyworddrivenframework/excel/", "TestCase.xlsx", "KeywordFramework");
	  
	  //find number of rows
	  int numberOfRows = testSheet.getLastRowNum() - testSheet.getFirstRowNum();
	  for (int i = 1; i < numberOfRows+1; i++) {
		  System.out.println(i);
		  //Loop over all the rows
		  Row row = testSheet.getRow(i);
		  //Check if the first cell contain a value, if yes, That means it is the new testcase name
		  
		  if (row.getCell(0).toString().length() == 0) {
		  //Print testcase detail on console
			  System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+ row.getCell(3).toString()+"----"+ row.getCell(4).toString());
			//Call perform function to perform operation on UI
			  operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
			  System.out.println("Operation successfully performed");
		  }else {
			//Print the new testcase name when it started
              System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
		  }
	  }
	  
  }
}
