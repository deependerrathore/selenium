package pom.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.Guru99Homepage;
import pom.pages.Guru99Login;

public class POMLoginTestCase {
	WebDriver driver;
	Guru99Login objLogin;
	Guru99Homepage objHomepage;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");
		
	}
	 /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */
  @Test(priority=0)
  public void test_home_page_appear_correctly() {
	  //create login page object
	  objLogin = new Guru99Login(driver);
	  //verify login page title
	  String loginPageTitle = objLogin.getLoginTitle();
	//  System.out.println(loginPageTitle);
	  Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
	  
	  //login to application
	  objLogin.loginToGuru99("mngr90508", "nYpanUq");
	  
	  //go to next page i.e homepage
	  objHomepage = new Guru99Homepage(driver);
	  
	  //verify homepage
	  Assert.assertTrue(objHomepage.getManagerID().equalsIgnoreCase("Manger Id : mngr90508"));
  }
}
