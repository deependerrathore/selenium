import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchingBetweenFrames {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
		
		driver.switchTo().frame("classFrame");
		
		driver.findElement(By.linkText("Index")).click();
		
		driver.close();
	}	
}
