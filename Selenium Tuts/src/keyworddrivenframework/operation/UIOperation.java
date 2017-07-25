package keyworddrivenframework.operation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {
	WebDriver driver;
	public UIOperation(WebDriver driver) {
		this.driver = driver;
	}

	public void perform(Properties p, String operation, String objectName , String objectType, String value) throws Exception {
		System.out.println("");
		switch (operation.toUpperCase()) {
		case "CLICK":
			//Perform click
			driver.findElement(this.getObject(p,objectName,objectType)).click();
			break;
		case "SETTEXT":
			//set text to username
			driver.findElement(this.getObject(p, objectName, objectType)).sendKeys(value);
			break;
		case "GOTOURL":
			driver.get(p.getProperty(value));
			break;
		case "GETTEXT":
			//get text from url
			driver.findElement(this.getObject(p, objectName, objectType)).getText();
		default:
			break;
		}
	}

	/**
	 * Find element BY using object type and value
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return 
	 * @return
	 * @throws Exception
	 */
	public By getObject(Properties p,String objectName,String objectType) throws Exception {
		//Find by XPATH
		if (objectType.equalsIgnoreCase("XPATH")) {
			return By.xpath(p.getProperty(objectName));
		}
		//Find by NAME
		else if (objectType.equalsIgnoreCase("NAME")) {
			return By.name(p.getProperty(objectName));
		}
		//Find by CLASSNAME
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {
			return By.className(p.getProperty(objectName));
		}
		//Find by CSS
		else if (objectType.equalsIgnoreCase("CSS")) {
			return By.cssSelector(p.getProperty(objectName));
		}
		//Find by LINK
		else if (objectType.equalsIgnoreCase("LINK")) {
			return By.linkText(p.getProperty(objectName));
		}
		//Find by PATIALLINK
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {
			return By.partialLinkText(p.getProperty(objectName));
		}
		//else throw error
		else{
			throw new Exception("Wrong object type");
		}
	}
}
