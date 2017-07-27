package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99Login{
	WebDriver driver;
	
	By userName = By.name("uid");
	By password = By.name("password");
	By title = By.className("barone");
	By login = By.name("btnLogin");
	
	public Guru99Login(WebDriver driver) {
		this.driver = driver;
	}
	
	//Set username in the textfield
	public void setUsername(String varUsername) {
		driver.findElement(userName).sendKeys(varUsername);
	}
	
	public void setPassword(String varPassword) {
		driver.findElement(password).sendKeys(varPassword);
	}
	
	public void clkLoginBtn() {
		driver.findElement(login).click();
	}
	
	public String getLoginTitle() {
		return driver.findElement(title).getText();
	}
	
	 /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */
	
	public void loginToGuru99(String username , String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clkLoginBtn();
		
	}
}
