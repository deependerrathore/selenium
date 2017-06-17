import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","/home/deep/Downloads/geckodriver");
		
		WebDriver driver;
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");

	}

}
