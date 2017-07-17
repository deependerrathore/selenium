import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchingBetweenPopups {
	
	public static void main(String args[]){
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		WebDriver driver;
		
		driver = new FirefoxDriver();
		
		driver.get("http://jsbin.com/usidix/1");
		
		driver.findElement(By.tagName("input")).click();
		
		String msg = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		System.out.println(msg + "This is the alert box msg");
		
		driver.close();
		
		
		//driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		/*driver.findElement(By.tagName("input")).click();
		
		String alertmsg = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		System.out.println(alertmsg);
		driver.quit();*/
	}

}
