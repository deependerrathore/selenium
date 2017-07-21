package dataprovider;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;



public class ParameterByMethodInDataprovider {
	
  WebDriver driver;
  String driverPath = "/home/deep/Downloads/geckodriver";
  @BeforeTest
  public void setup() {
	  System.setProperty("webdriver.gecko.driver",driverPath);
	  
	  driver = new FirefoxDriver();
	  System.out.println("Launching Firefox driver");
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://www.google.com");
	  
  }
  
  @Test(dataProvider="SearchProvider")
  public void testMethodA(String author , String searchKey) throws InterruptedException{
	  
	  WebElement searchText = driver.findElement(By.name("q"));
	  searchText.sendKeys(searchKey);
	  driver.findElement(By.name("btnG")).click();
	  System.out.println("welcome -> " +author +" your search key is " + searchKey );
	  Thread.sleep(3000);
	  
	  
	  String testValue = searchText.getAttribute("value");
	  System.out.println(testValue +"::::"+searchKey);
      searchText.clear();
      //Verify if google text box is showing correct value
	  
	  Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	  
	  
  }
  
  @Test(dataProvider="SearchProvider")
  public void testMethodB(String searchKey) throws InterruptedException{
      {
      	WebElement searchText = driver.findElement(By.name("q"));
          //Search text in search box
          searchText.sendKeys(searchKey);
          driver.findElement(By.name("btnG")).click();
          //Print only search string
          System.out.println("Welcome ->Unknown user Your search key is->"+searchKey);
          Thread.sleep(3000);
          String testValue = searchText.getAttribute("value");
          System.out.println(testValue +"::::"+searchKey);
          searchText.clear();
          //Verify if google text box is showing correct value
          Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
      }
  }    
  
  @DataProvider(name="SearchProvider")
  public Object[][] getDataFromDataProvider(Method m){
	  if (m.getName().equalsIgnoreCase("testMethodA")) {
		  return new Object[][]{
			  {"deepender","india"} ,
			  {"Narender","Rajasthan"} , 
			  {"Indu","Bharat"}  
		  };
	  } else {
		  return new Object[][]{
			  {"UK"} ,
			  {"Paris"} , 
			  {"Budapest"}  
		  };
	  }
	  
  }
  
  @AfterTest
  public void close(){
	  driver.close();
  }
}
