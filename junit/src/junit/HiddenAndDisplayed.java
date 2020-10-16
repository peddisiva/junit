package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class HiddenAndDisplayed {
	WebDriver driver;
	String baseUrl;
	String baseUrl1;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice/";
		baseUrl1 = "https://www.expedia.co.in/?pwaDialog=travelers-dialog-wizard-hotel-pwa-v2-1&pwaLob=wizard-hotel-pwa-v2";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void testLetskodeit() throws InterruptedException {
		driver.get(baseUrl);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text box is displayed: "+textBox.isDisplayed());
		Thread.sleep(2000);
		WebElement hide = driver.findElement(By.id("hide-textbox"));
		hide.click();
		System.out.println("Clicked on hide button");
		System.out.println("Text box is displayed: "+textBox.isDisplayed());
		Thread.sleep(2000);
		WebElement show = driver.findElement(By.id("show-textbox"));
		show.click();
		System.out.println("Clicked on show button");
		System.out.println("Text box is displayed: "+textBox.isDisplayed());
	}
	
	@Test
	void testExpedia() {
		driver.get(baseUrl1);
		WebElement childDropdown = driver.findElement(By.xpath("//select[@id='child-age-input-0-0']"));
		System.out.println("Child dropdown is displayed: "+childDropdown.isDisplayed());
	}

}
