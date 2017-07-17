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
		
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupb");
		
		//List of columns
		List <WebElement> col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		
		System.out.println("Number of cols are :" + col.size());
		
		//List of rows
		List <WebElement> row = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr"));
		
		System.out.println("Number of rows are: "+ row.size());
		
	}
}
