import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetCommand {
	
	public static void main(String args[]){
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		String title = "";
		String pageSource = "";
		String getUrl = "";
		String innerText = "";
		
		//Title 
		title = driver.getTitle();
		System.out.println(title);
		
		
		//URL
		getUrl = driver.getCurrentUrl();
		System.out.println(getUrl);
		
		//Inner Text
		innerText = driver.findElement(By.name("websubmit")).getText();
		System.out.println(innerText);
		
		//Page Source
		pageSource = driver.getPageSource();
		System.out.println(pageSource);
		
		
	}

}
