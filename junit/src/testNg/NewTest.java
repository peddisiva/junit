package testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners(CustomListeners.class)
public class NewTest {
	private static final Logger log = LogManager.getLogger(NewTest.class.getName());
  @Test(dataProvider = "inputs", dataProviderClass = junit.DataForTestNg.class)
  public void f(String input1, String input2) {
	  System.out.println("hi......."+input1+"...."+input2);
	  log.debug("debug log from f");
	  log.error("error log from f");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("running car1");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After class");
  }

}
