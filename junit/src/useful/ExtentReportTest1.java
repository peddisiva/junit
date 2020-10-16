package useful;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTest1 {
	private WebDriver driver;
	private String baseUrl;
	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "http://www.letskodeit.com/";
		
		reports = ExtentFactory.getInstance();
		test = reports.startTest("verify welcom to ExtentReport1");
		test.log(LogStatus.INFO, "Browser started");
		
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened");
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
//		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
//		signupLink.click();
		
		WebElement loginLink = driver.findElement(By.xpath("//div[@class='ast-button']"));
		loginLink.click();
		test.log(LogStatus.INFO, "Clicked on login link");
		
		WebElement emailField = driver.findElement(By.xpath("//div[@class='text-center zen-login']//input[@id='email']"));
		emailField.sendKeys("test@email.com");
		test.log(LogStatus.INFO, "Entered emailId");
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		passwordField.sendKeys("abcabc");
		test.log(LogStatus.INFO, "Entered password");
		
		WebElement goButton = driver.findElement(By.xpath("//input[@class='btn btn-default btn-block btn-md dynamic-button']"));
		goButton.click();
		test.log(LogStatus.INFO, "Clicked on login button");
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "All Courses");
		test.log(LogStatus.PASS, "Verified Title text");
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if(testResult.getStatus() == ITestResult.FAILURE) {
			String path = ScreenshortsClass.takeScreenshot(driver, testResult.getName());
			String imagepath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Failed Verifing Title text", imagepath);
		}
		reports.endTest(test);
		reports.flush();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
