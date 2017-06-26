import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementTest {
	public static void main(String agrs[]){
		
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		
		WebElement login = driver.findElement(By.id("email"));
		
		login.sendKeys("deepak.republic@gmail.com"	);
		
	}
}
