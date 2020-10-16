package useful;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

class SeleniumWithSikuli {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.youtube.com/watch?v=j2dkdqfzY9Y&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void test() throws FindFailed, InterruptedException {
		driver.get(baseUrl);
		Screen s = new Screen();
//		settings
		Pattern settings = new Pattern("settings.PNG"); 
		s.wait(settings, 3000); 
		s.click();
//		720p
		Pattern seven = new Pattern("720p.png");
		s.wait(seven, 3000);
		s.click();
//		400p
		Pattern four = new Pattern("144p.png");
		s.wait(four, 3000);
		s.click();
//		pause
		Pattern pause = new Pattern("pause.PNG"); 
		s.wait(pause, 3000); 
		s.click();
//		play
//		Pattern play = new Pattern("play.PNG");
//		
//		s.wait(play, 0); 
//		s.click();
		Thread.sleep(5000);
	}

}
