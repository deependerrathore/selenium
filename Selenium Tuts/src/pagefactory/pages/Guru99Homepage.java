package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Homepage {
	WebDriver driver = null;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	WebElement managerID;
	
	public Guru99Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getManagerID() {
		
		return managerID.getText();
		
	}
	
}
