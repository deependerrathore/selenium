import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementBy {
	public static void main(String args[]){
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		
		//Taking facebook as example
		//1. By.className - This will find the first inputtext class and put deepender as text
		//driver.findElement(By.className("inputtext")).sendKeys("deepender");
		
		//2. By.cssSelector
		//driver.findElement(By.cssSelector("//[@id='u_0_3']")).sendKeys("Deepender");
		
		
		
	}
}
