package testng.selenium;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class AlphabeticTestCases {
  @Test(priority=1)
  public void c_test() {
	  Assert.assertTrue(true);
  }
  @Test(priority=2)
  public void a_test(){
	  Assert.fail();
  }
  @Test(priority=3)
  public void b_test(){
	  throw new SkipException("skipping this test case...");
  }
  
}
