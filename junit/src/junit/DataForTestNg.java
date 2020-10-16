package junit;

import org.testng.annotations.DataProvider;

public class DataForTestNg {
	
	@DataProvider(name="inputs")
	public Object[][] getData(){
		return new Object[][] {
			{"bmw","c3"},
			{"benz","c300"}
		};
	}
}
