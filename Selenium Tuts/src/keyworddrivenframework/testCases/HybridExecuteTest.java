package keyworddrivenframework.testCases;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import keyworddrivenframework.exportExcelAndFileIO.ReadExcelFile;
import keyworddrivenframework.operation.ReadObject;
import keyworddrivenframework.operation.UIOperation;

public class HybridExecuteTest {

	WebDriver driver = null;

	@Test(dataProvider="hybridData")
	public void testLogin(String testcaseName, String keyword,String objectName,String objectType,String value) throws Exception {

		if (testcaseName != null && testcaseName.length() != 0) {
			driver= new FirefoxDriver();
		}

		ReadObject object = new ReadObject();
		Properties allObject = object.getObjectRepository();
		UIOperation operation = new UIOperation(driver);
		//call perform function to perform operatin on UI
		operation.perform(allObject, keyword, objectName, objectType, value);

	}

	@DataProvider(name="hybridData")
	public Object[][] getDataFromDataProvider() throws IOException{
		Object object[][] = null;
		ReadExcelFile file = new ReadExcelFile();
		//read keyword sheet
		Sheet sheet = file.readExcel(System.getProperty("user.dir")+"/src/keyworddrivenframework/testCases", "TestCase.xlsx", "KeywordFramework");

		//find total number of rows
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		object = new Object[rowCount][5];
		for (int i = 0; i < object.length; i++) {
			//Loop over all the rows
			Row row = sheet.getRow(i+1);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print excel data in console
				object[i][j] = row.getCell(j).toString();

			}



		}
		System.out.println("");
		return object;
	}
}
