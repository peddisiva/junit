package useful;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class HandelingFrams {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";
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
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//legend[contains(text(),'iFrame Example')]"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		//Thread.sleep(2000);
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.xpath("//input[@id='search-courses']")).sendKeys("python");
		//Thread.sleep(2000);
		
		String toCompare = "Selenium WebDriver With Python 3.x";
		
		List<WebElement> titles = driver.findElements(By.xpath("//div[@class='course-listing']"));
		System.out.println(titles.size());
		for(WebElement title: titles) {
			WebElement text = title.findElement(By.tagName("a"));
			String finalText = text.getText().replaceAll("\n", " ");
			System.out.println(finalText);
			if(finalText.contains(toCompare)) {
				js.executeScript("arguments[0].style.border = '3px solid red' ", title);
				Thread.sleep(3000);
				text.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

}
