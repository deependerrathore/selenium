package pdfemail.base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pdfemail.customization.JyperionListener;

//Add listener for pdf report generation

@Listeners(JyperionListener.class)
public class TestGuru99PDFEmail extends BaseClass {

	WebDriver driver;

	//Testcase failed so screen shot generate
	@Test
	public void testPDFReportOne() {
		driver = BaseClass.getDriver();
		driver.get("https://www.google.co.in");
		Assert.assertTrue(false);
	}


	//Testcase failed so screen shot generate

	@Test

	public void testPDFReporTwo(){

		driver = BaseClass.getDriver();

		driver.get("http:/guru99.com");

		Assert.assertTrue(false);

	}



	//Test test case will be pass, so no screen shot on it

	@Test

	public void testPDFReportThree(){

		driver = BaseClass.getDriver();

		driver.get("http://demo.guru99.com");

		Assert.assertTrue(true);

	}
}
