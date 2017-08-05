package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Excercise1 {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/");
		
		driver.findElement(By.xpath("//a[@href=contains(text(),\"animatedcolors.xlsm\")]")).click();
		
		Robot robot = new Robot();// Robot class throws AWT Exception	
		Thread.sleep(2000);// Thread.sleep throws InterruptedExceptio
		
		robot.keyPress(KeyEvent.VK_DOWN); // press arrow down key of keyboard to navigate and select Save radio button
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// press enter key of keyboard to perform above selected action	
		
	}
}
