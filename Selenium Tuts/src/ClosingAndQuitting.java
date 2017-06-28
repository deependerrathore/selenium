import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClosingAndQuitting {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("http://www.popuptest.com/popuptest2.html");
		
		driver.close();
		//This will only close the currently opened window in our case it is http://www.popuptest.com/popuptest2.html
	}	
}
