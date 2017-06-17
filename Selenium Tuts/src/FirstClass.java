/*
 	WebDriver script that would:
	1.fetch Mercury Tours' homepage
	2.verify its title
	3.print out the result of the comparison
	4.close it before ending the entire program.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","/home/deep/Downloads/geckodriver");
		
		//declaration and instantiation of objects/variables
		WebDriver driver;
		
		driver = new FirefoxDriver();
		
		String baseURL = "http://newtours.demoaut.com";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		
		//lanuch firefox and direct it to the baseURL
		driver.get(baseURL);
		
		//get the actual value of the title
		actualTitle = driver.getTitle();
		
		/*
		 * Compare the actual title of the page with the expected one and print
		 * 
		 */
		
		if(actualTitle.contentEquals(expectedTitle)){
			System.out.println("Test Passed");
		}else{
			System.out.println("Test Failed");
		}
		
		//close firefox
		driver.close();
		
		//exit the program explicitly
		System.exit(0);

	}

}
