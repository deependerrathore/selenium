package testng.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterizationWithTestNGXML {
	String driverPath = "/home/deep/Downloads/geckodriver";
	WebDriver driver;

	@Test
	@Parameters({"author","searchKey"})
	public void testParameterWithXML(@Optional("ABC") String author,@Optional("Russia") String searchKey) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
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
