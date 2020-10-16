package useful;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class KeyPressAction {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("siva@siva.com");
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='commit']")).sendKeys(Keys.ENTER);
	}

}
