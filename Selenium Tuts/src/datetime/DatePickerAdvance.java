package datetime;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DatePickerAdvance {
	@Test
	public void testDatePicker() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "/home/deep/Downloads/geckodriver");
		//DAte and Time to be set in textbox
		String dateTime = "28/08/2000 4:00 AM";
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//button to open calendar
		WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
		selectDate.click();
		
		//button to move next in calendar
		WebElement nextLink = driver.findElement(By.xpath("//div[@data-role='calendar']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
		
		//button to click in center of calendar header
		WebElement midLink = driver.findElement(By.xpath("//div[@data-role='calendar']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));
		
		//button to move previous month in calendar
		WebElement prevLink = driver.findElement(By.xpath("//div[@data-role='calendar']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]"));
		
		
		
		
		//Split the date time to get only the date part
		String[] date_dd_mm_yyyy = dateTime.split(" ")[0].split("/");
		
		//get the year difference between current year and year to set in calander
		int yearDiff  = Integer.parseInt(date_dd_mm_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		
		
		
		midLink.click();
				
		if (yearDiff != 0) {
			
			//if you have to move next year
			if (yearDiff > 0) {
				
				for (int i = 0; i < yearDiff; i++) {
					//System.out.println("Year Diff->"+i);
					nextLink.click();
				}
			}else if(yearDiff < 0){
				for (int i = 0; i < yearDiff*(-1); i++) {
					//System.out.println("Year Diff->"+i);
					prevLink.click();
				}
			}
			
		
		}
		
		Thread.sleep(2000);

        //Get all months from calendar to select correct one
		List <WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@data-role='calendar']//table//tbody//td"));
		list_AllMonthToBook.get(Integer.parseInt(date_dd_mm_yyyy[1])-1).click();
		Thread.sleep(2000);
		//get all dates from calendar to select correct one
		 List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@data-role='calendar']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
		 
		 list_AllDateToBook.get(Integer.parseInt(date_dd_mm_yyyy[0])-1).click();
		
		
	}

}
