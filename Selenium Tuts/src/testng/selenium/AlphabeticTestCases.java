package testng.selenium;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class AlphabeticTestCases {
  @Test
  public void c_test() {
	  Assert.assertTrue(true);
  }
  @Test
  public void a_test(){
	  Assert.assertFalse(true);
  }
  @Test
  public void b_test(){
	  throw new SkipException("skipping this test case...");
  }
  
}
