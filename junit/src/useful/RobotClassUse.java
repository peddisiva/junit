package useful;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class RobotClassUse {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://go.microsoft.com/fwlink/?LinkId=252781";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String directory = "C:\\Users\\Siva\\Desktop\\sree\\shots\\";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		String characters = "abcdefghijklmnopqurstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for(int i=0; i<length; i++) {
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	@Test
	void test() throws InterruptedException, AWTException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("peddisiva1@gmail.com");
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("Siva7482");
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='KmsiCheckboxField']")).click();
		driver.findElement(By.xpath("//input[@id='idBtn_Back']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='upload-link__text ms-u-hiddenLgDown']")).click();
		
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		StringSelection stringSelection = new StringSelection("C:\\Users\\Siva\\Desktop\\sree\\url_check\\updated.csv");
//		copying file address to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.setAutoDelay(2000);
//		control+v press
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
//		control+v release
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
//		pressing and releasing enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(8000);
	}

}
