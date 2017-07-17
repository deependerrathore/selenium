import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDynamicTable {
	public static void main(String args[]){
		
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupa");
		
		//List of columns
		WebElement baseTable  = driver.findElement(By.tagName("table"));
		
		//to find the 3rd row of the table
		WebElement tablerow = baseTable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
		System.out.println("Row number" + tablerow.getText());
		
		//to find the 2nd colum of the talbe
		WebElement CellInneed =  baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
		
		System.out.println("Data on 2nd column: "+ CellInneed.getText());
		
	}
}
