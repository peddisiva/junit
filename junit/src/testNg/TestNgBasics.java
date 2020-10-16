package testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class TestNgBasics {
  @Test(groups= {"cars","suv"})
  public void car1() {
	  System.out.println("running car1");
	  Assert.assertTrue(false);
  }
  
  @Test(groups= {"cars","sedan"})
  public void car2() {
	  System.out.println("running car2");
	  Assert.assertTrue(true);
  }
  
  @Test(groups= {"bikes"})
  public void bike() {
	  System.out.println("running bike");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class");
  }

  @AfterClass
  public void afterClass(ITestResult testResult) {
	  System.out.println("After class");
	  if(testResult.getStatus() == ITestResult.FAILURE) {
		  System.out.println("failed: "+ testResult.getName());
	  }
	  if(testResult.getStatus() == ITestResult.SUCCESS) {
		  System.out.println("passed: "+ testResult.getName());
	  }
  }

}
