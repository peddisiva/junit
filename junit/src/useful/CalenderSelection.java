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

class CalenderSelection {
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
		driver.findElement(By.xpath("//body[contains(@class,'uitk-no-outline')]/div[@id='app']/div/div[contains(@class,'app-layer-base--active')]/div[contains(@class,'uitk-grid pageWhiteBackground')]/div[contains(@class,'uitk-cell Storefront-Homepage')]/div[contains(@class,'StorefrontWizardRegionBEX')]/div/figure[contains(@class,'uitk-image bexHeroImageFigure withBackgroundColor')]/div[contains(@class,'wizardCard all-t-padding-twelve all-x-padding-six SimpleContainer')]/div[contains(@class,'uitk-card uitk-grid all-cell-1-1 elevation-4')]/div[contains(@class,'uitk-cell lobFormInCard')]/div[contains(@class,'uitk-tabs-container')]/ul[@id='uitk-tabs-button-container']/li[contains(@class,'active')]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='d1-btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-desktop-pagination-container')]//button[1]")).click();
		WebElement colMonth = driver.findElement(By.xpath("//div[@class='uitk-new-date-picker-desktop-months-container']/div[1]/table"));
		List<WebElement> dates = colMonth.findElements(By.tagName("button"));
		for (WebElement date: dates) {
			if(date.getAttribute("data-day").equals("21")) {
				Thread.sleep(3000);
				date.click();
				Thread.sleep(2000);
				break;
			}
		}
		Thread.sleep(3000);
	}

}
