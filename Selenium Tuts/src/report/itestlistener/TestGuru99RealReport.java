package report.itestlistener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReadGuru99TimeReport.class)
public class TestGuru99RealReport {
	
	
  @Test
  public void testReadReportOne() {
	  Assert.assertTrue(true);
  }
  
  @Test
  public void testReadReportTwo() {
	  Assert.assertTrue(false);
	  
  }
  
//Test case depends on failed testcase= testRealReportTwo
  	@Test(dependsOnMethods="testReadReportTwo")
  	public void testReadReportThree() {
  		
  	}
}
