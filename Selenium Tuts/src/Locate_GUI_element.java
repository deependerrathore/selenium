import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locate_GUI_element {

	public static void main(String []args){
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		WebDriver driver;
		
		driver = new FirefoxDriver();
		
		String baseURL = "http://www.facebook.com";
		String tagname;
		
		driver.get(baseURL);
		tagname = driver.findElement(By.id("email")).getTagName();
		System.out.println(tagname);
		driver.close();
		
		System.exit(0); 
		
	
		
	}
}

/*
Example

By.className	finds elements based on the value of the "class" attribute	findElement(By.className("someClassName"))
By.cssSelector	finds elements based on the driver's underlying CSS Selector engine	findElement(By.cssSelector("input#email"))
By.id	locates elements by the value of their "id" attribute	findElement(By.id("someId"))  
By.linkText	finds a link element by the exact text it displays	findElement(By.linkText("REGISTRATION"))  
By.name	locates elements by the value of the "name" attribute	findElement(By.name("someName"))  
By.partialLinkText	locates elements that contain the given link text	findElement(By.partialLinkText("REG"))  
By.tagName	locates elements by their tag name	findElement(By.tagName("div"))  



By.xpath	locates elements via XPath	findElement(By.xpath("//html/body/div/table/tbody/tr/td[2]/table/ tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/ form/table/tbody/tr[5]"))

*/