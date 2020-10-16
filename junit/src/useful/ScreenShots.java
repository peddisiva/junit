package useful;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ScreenShots {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/?pwaLob=wizard-hotel-pwa-v2";
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
	void test() throws InterruptedException {
		driver.get(baseUrl);
		String searchingText = "Newark (EWR - Liberty Intl.)";
		String partialText = "New";
		WebElement textButton = driver.findElement(By.xpath("//div[@id='location-field-destination-menu']//button[@class='uitk-faux-input']"));
		textButton.click();
		WebElement text = driver.findElement(By.xpath("//input[@id='location-field-destination']"));
		text.sendKeys(partialText);
		WebElement element = driver.findElement(By.xpath("//ul[@class='uitk-typeahead-results no-bullet']"));
		
		List<WebElement> results = element.findElements(By.tagName("li")); 
		int size = results.size();
		System.out.println(size);
//		for(int i = 0; i<size; i++) {
//			//WebElement x = results.get(i);
//			String x = results.get(i).getText();
//			System.out.println(x);
//		}
		System.out.println(searchingText);
		Thread.sleep(3000);
		for(WebElement result: results) {
			System.out.println(result.getText());
			System.out.println("");
			String x = result.getText().replaceAll("\n", " ");
			System.out.println(x);
			System.out.println("");
			boolean isFound = x.indexOf(searchingText) !=-1? true: false;
			System.out.println(isFound);
			if(isFound) {
				System.out.println("contains");
				result.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

}
