package session.sessionhandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHandling {
	public static void main(String...strings) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",  "/home/deep/Downloads/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		WebDriver driver1 = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("identifierId")).sendKeys("deepak.republic@gmail.com");
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("the.script28");
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
				
		driver1.get("https://www.google.com");
		driver1.findElement(By.linkText("Sign in")).click();
		driver1.findElement(By.id("identifierId")).sendKeys("deepenrathore28@gmail.com");
		driver1.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();

		Thread.sleep(3000);
		driver1.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("one.republic");
		driver1.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		
	}
	
}
