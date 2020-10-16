package useful;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BrowserPopUpWindow {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://www.popuptest.com/";
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
		driver.findElement(By.xpath("//font[1]//b[1]//a[1]")).click();
		Thread.sleep(3000);
		LinkedHashSet<String> handler = (LinkedHashSet<String>) driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("parentWindowId: "+parentWindowId);
		
		String childWindow2;
		for(int i=0; i<2; i++) {
			if(i ==1) {
				childWindow2 = it.next();
				driver.switchTo().window(childWindow2);
				Thread.sleep(3000);
				driver.close();
				break;
			}
			it.next();
		}
		Thread.sleep(3000);
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
	}

}
