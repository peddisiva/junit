package useful;

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

class AutoComplete {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.co.in/?pwaLob=wizard-hotel-pwa-v2";
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
		String searchingText = "Nework, EWR - Liberty Intl";
		String partialText = "New";
		WebElement textButton = driver.findElement(By.xpath("//div[@id='location-field-destination-menu']//button[@class='uitk-faux-input']"));
		textButton.click();
		WebElement text = driver.findElement(By.xpath("//input[@id='location-field-destination']"));
		text.sendKeys(partialText);
		WebElement element = driver.findElement(By.xpath("//ul[@class='uitk-typeahead-results no-bullet']"));
		List<WebElement> results = element.findElements(By.tagName("li")); 
		int size = results.size();
		for(int i = 0; i<size; i++) {
			System.out.println(results.get(i).getText());
		}
		Thread.sleep(3000);
		for(WebElement result: results) {
			if(result.getText().equals(searchingText)) {
				result.clear();
			}
		}
	}

}
