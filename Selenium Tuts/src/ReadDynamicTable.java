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
		
		List <WebElement> data = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		
		for (int i = 1; i < data.size(); i++) {
			System.out.println(driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]")).getText());
		}
		
		
	}
}
