import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchingBetweenFrames {
	
	public static void main(String[] args) {
		
		WebDriver dri;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		dri = new FirefoxDriver();
		
		dri.get("http://demo.guru99.com/selenium/deprecated.html");
		
		dri.switchTo().frame("classFrame");
		
		dri.findElement(By.linkText("Help")).click();
		
		dri.close();
		
		
	}	
}
