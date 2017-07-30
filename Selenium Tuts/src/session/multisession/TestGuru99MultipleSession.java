package session.multisession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestGuru99MultipleSession {
	@Test
	public void executSessionOne() {
		//First session of WebDriver
		System.setProperty("webdriver.gecko.driver",  "/home/deep/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();
		//Goto guru99 site
		driver.get("http://demo.guru99.com/V4/");
		//find user name text box and fill it
		driver.findElement(By.name("uid")).sendKeys("mngr90508");
	}
	
	@Test
	public void executSessionTwo() {
		//First session of WebDriver
		System.setProperty("webdriver.gecko.driver",  "/home/deep/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();
		//Goto guru99 site
		driver.get("http://demo.guru99.com/V4/");
		//find user name text box and fill it
		driver.findElement(By.name("uid")).sendKeys("mngr90509");
	}
	
	@Test
	public void executSessionThree() {
		//First session of WebDriver
		System.setProperty("webdriver.gecko.driver",  "/home/deep/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();
		//Goto guru99 site
		driver.get("http://demo.guru99.com/V4/");
		//find user name text box and fill it
		driver.findElement(By.name("uid")).sendKeys("mngr90507");
	}
	
	
}
