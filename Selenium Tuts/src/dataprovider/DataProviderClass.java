package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
  @DataProvider(name="SearchProvider")
  public Object[][] searchrovider() {
	  return new Object[][]{
		  {"deepender","India"},
		  {"Rahul","Itly"},
		  {"Mukesh","Bhutan"}
	  };
  }
}
