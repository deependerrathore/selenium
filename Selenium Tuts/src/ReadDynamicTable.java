import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDynamicTable {
	public static void main(String args[]){
		String max;
		double r = 0 ,m= 0;
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupa");
		
		List <WebElement> data = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
		
		for (int i = 1; i < data.size(); i++) {
			
			
			try {
				NumberFormat f = NumberFormat.getNumberInstance();
				Number num = f.parse(data.get(i).getText());
				
				max = num.toString();
				
				m = Double.parseDouble(max);
				
				if(m>r){
					
					r = m;
					
				}
				
				//System.out.println(num);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("The maximum value is :" + r );
		
		
		
	}
}
