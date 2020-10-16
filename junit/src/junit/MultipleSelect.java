package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class MultipleSelect {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice/";
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
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(element);
		Thread.sleep(2000);
		System.out.println("Select orange by value");
		sel.selectByValue("orange");
		Thread.sleep(2000);
		System.out.println("DeSelect ");
		sel.deselectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("Select peach by Index");
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select apple by visible text");
		sel.selectByVisibleText("Apple");
		
		Thread.sleep(2000);
		System.out.println("Print the list of all the options");
		List<WebElement> selected = sel.getAllSelectedOptions();
		for(WebElement option: selected) {
			System.out.println(option.getText());
		}
		
		Thread.sleep(2000);
		System.out.println("Deselecting all the options");
		sel.deselectAll();
	}

}
