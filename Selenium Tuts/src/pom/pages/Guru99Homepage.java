package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99Homepage {
	WebDriver driver = null;
	public Guru99Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	By managerid = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
	
	public String getManagerID() {
		
		return driver.findElement(managerid).getText();
		
	}
	
}
