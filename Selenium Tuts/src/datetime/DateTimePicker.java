package datetime;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DateTimePicker {
	@Test
	public static void dateTimePicker() {
		
		
	
		File file = new File("/home/deep/Downloads/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("test-type");
        options.addArguments("--start-maximized");
        //options.addArguments("--disable-web-security");
        //options.addArguments("--allow-running-insecure-content");
        //options.addArguments(" --enable-automation");
        capabilities.setCapability("chrome.binary","/home/deep/Downloads/chromedriver");  
        capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
        WebDriver driver = new ChromeDriver(capabilities);  
   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/selenium/");
		WebElement datetimepickerElement = driver.findElement(By.xpath("//form//xpath//[@name='bdaytime']"));
		
		//Fill date as mm/dd/yyyy as 09/25/2013

		datetimepickerElement.sendKeys("08022017");
		
		
		datetimepickerElement.sendKeys(Keys.TAB);
		
		datetimepickerElement.sendKeys("0245PM");
	}
}
