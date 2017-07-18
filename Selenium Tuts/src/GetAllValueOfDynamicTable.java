import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetAllValueOfDynamicTable {
	public static void main(String args[]){
		
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("http://demo.guru99.com/selenium/table/");
		
		WebElement mytable = driver.findElement(By.xpath("/html/body/table/tbody"));
		
		//To locate rows of table
		List <WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		
		//To calculate rows of table
		int row_count = rows_table.size();
		
		
		for (int i = 0; i < row_count; i++) {
			//To locate cols of table
			List <WebElement> cols_row = rows_table.get(i).findElements(By.tagName("td"));
					
			//To calculate cols of table
			int cols_count = cols_row.size();
			
			for (int j = 0; j < cols_count; j++) {
				String cell_text = cols_row.get(j).getText();
				System.out.println("Cell Value of row number "+i+" and column number "+j+" Is "+cell_text);
			}
			
			System.out.println("-------------------------------------------------");
			
		}
		
		
	}
}
