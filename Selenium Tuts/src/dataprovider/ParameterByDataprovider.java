package dataprovider;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByDataprovider {
	String driverPath = "/home/deep/Downloads/geckodriver";
	WebDriver driver;
	
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
	}
	
	/** Test case to verify google search box
     * @param author
     * @param searchKey
     * @throws InterruptedException
     */
	@Test(dataProvider="SearchProvider")
	public void testMethod(String author , String searchKey) throws InterruptedException{
		WebElement searchText = driver.findElement(By.name("q"));
		
		searchText.sendKeys(searchKey);
		driver.findElement(By.name("btnG")).click();
		
		System.out.println("welcome -> " +author +" your search key is " + searchKey );
		Thread.sleep(3000);
		String testValue = searchText.getAttribute("value");
		System.out.println(testValue +"::::"+searchKey);
		searchText.clear();
        //Verify if the value in google search box is correct
		assertTrue(testValue.equalsIgnoreCase(searchKey));
		
	}
	
	/**
     * @return Object[][] where first column contains 'author'
     * and second column contains 'searchKey'
     */

	@DataProvider(name="SearchProvider")
	public Object[][] getDataFromDataProvider(){
		return new Object[][]{
			{ "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
		};
	}
	
	
	
}
