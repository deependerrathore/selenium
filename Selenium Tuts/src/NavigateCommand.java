import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateCommand {

	public static void main(String args[]){
		
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.navigate().to("https://www.google.com");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		/*
		 * the above script first go to facebook then google then again to facebook and then google
		 * 
		 */
		
	}
}
