package testng.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WithoutParameterization {
	public static String driverPath = "/home/deep/Downloads/geckodriver";
	WebDriver driver;
	
	@Test
  public void testNoParameter() throws InterruptedException {
		String author = "Deepak";
		String searchKey = "India";
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://google.com");
		
		WebElement searchText = driver.findElement(By.name("q"));
		
		searchText.sendKeys(searchKey);
		
		driver.findElement(By.name("btnG")).click();
		
		System.out.println("Welcome " + author + " Your search key is " + searchKey);
		
		System.out.println("Thread will sleep now");
		
		Thread.sleep(3000);
		
		System.out.println("Value in google search is " + searchText.getAttribute("value") + "::: Value given by input is " + searchKey);
		
		//varify the result in google search box
		Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
		
  }
}
