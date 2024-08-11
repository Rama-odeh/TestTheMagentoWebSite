import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestData {

	WebDriver driver;
	Actions actions = new Actions(driver);
	String url = "https://magento.softwaretestingboard.com/";
	Random rand = new Random();
	double numbers = 0;
	double expectedPrice = 70.0;
	
	@BeforeTest
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	
	@AfterTest
	public void tearDown() {
		// Quit the WebDriver after the tests are completed.
		if (driver != null) {
			driver.quit();
		}
	}
}
