import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrokenLinks {
	public static void main(String args[]){
		
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		
		driver = new FirefoxDriver();
		
		String homePage = "https://www.google.co.in";
		String url = "";
		HttpURLConnection huc = null;
		int respcode = 200;
		driver.get(homePage);
		int counter = 0;
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		Iterator<WebElement> it = links.iterator();
		
		while(it.hasNext()){
			
			System.out.println(counter++);
			url = it.next().getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println(url +" This URL is not configured for anchor tag or is empty");
				continue;
			} 
			if(!url.startsWith(homePage)) {
				System.out.println(url + " This URL belongs to another domain so skipping it");
				continue;
			}
			
			try {
				
				huc = (HttpURLConnection) (new URL(url).openConnection());
				
				huc.setRequestMethod("HEAD");
				
				huc.connect();
				
				respcode = huc.getResponseCode();
				System.out.println(respcode);
				
				if (respcode >= 400) {
					System.out.println(url + "This url is broken");
				}else{
					System.out.println(url + "This url is valid");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		
		driver.quit();
	}
}
