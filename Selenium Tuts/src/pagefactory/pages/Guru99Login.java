package pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Login{
	
	/**

     * All WebElements are identified by @FindBy annotation

     */
	
	WebDriver driver;
	
	@FindBy(name="uid")
	WebElement userGuru99Name;
	
	@FindBy(name="password")
	WebElement passGuru99Word;
	
	@FindBy(className="barone")
	WebElement titleText;
	
	@FindBy(name="btnLogin")
	WebElement login;
	

	
	public Guru99Login(WebDriver driver) {
		this.driver = driver;
		////This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Set username in the textfield
	public void setUsername(String varUsername) {
		userGuru99Name.sendKeys(varUsername);
	}
	
	public void setPassword(String varPassword) {
		passGuru99Word.sendKeys(varPassword);
	}
	
	public void clkLoginBtn() {
		login.click();
	}
	
	public String getLoginTitle() {
		return titleText.getText();
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
