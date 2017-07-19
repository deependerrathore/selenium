package testng.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	
	public String baseUrl = "http://newtours.demoaut.com/";
	
	String driverPath = "/home/deep/Downloads/geckodriver";
	
	public WebDriver driver;
	
	@Test
	public void f() {
		System.out.println("Launch firefox......");
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		
		driver.get(baseUrl);
		
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.close();
	}
}
