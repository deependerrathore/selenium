package screenshot.takeScr;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author deep
 *
 */
public class TakeScreenshot {
	
  WebDriver driver;
	@Test
  public void testTakeScreenshot() throws IOException {
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		driver.get("https://www.google.co.in");
		
		Assert.assertTrue(true);
		this.takeSceenshot(driver, System.getProperty("user.dir")+"/src/screenshot/screenshots/test.png");
  }
	
	/**
	 * take screenshot
	 * @param driver
	 * @param fileWithPath
	 * @throws IOException 
	 */
	public void takeSceenshot(WebDriver driver,String fileWithPath) throws IOException {

        //Convert web driver object to TakeScreenshot
		TakesScreenshot scrnshot = (TakesScreenshot)driver;
		
		//Call getScreenshotAs method to create image file
		File srcFile = scrnshot.getScreenshotAs(OutputType.FILE);
		
		//Move image to new destination
		File destFile = new File(fileWithPath);
		
		//copy file at destinatin
		FileUtils.copyFile(srcFile, destFile);
		
	}

}


