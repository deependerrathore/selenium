import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadFile {
	public static void main(String args[]){
		
WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("http://demo.guru99.com/selenium/upload/");
		
		String fileToUpload = "/home/deep/Downloads/geckodriver";
		
		//Have to use wait as without using it we are uanble to upload fine
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]"));
		
		upload.sendKeys(fileToUpload);
		
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.name("send")).click();
		
		
	}
}
