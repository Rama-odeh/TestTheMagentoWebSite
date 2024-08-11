import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestData {

	protected static WebDriver driver;
	protected Actions actions;

	protected String url = "https://magento.softwaretestingboard.com/";
	Random rand = new Random();
	double numbers = 0;
	double expectedPrice = 70.0;

	@BeforeSuite
	public void setUp() {
		if (driver == null) {
			setUpDriver();
		} else {
			initializeActions(); // Ensure Actions is initialized
		}
		driver.get(url);
	}

	private void setUpDriver() {
		driver = new ChromeDriver();
		initializeActions(); // Initialize Actions with the new driver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}

	@BeforeMethod
	public void initializeActions() {
		if (actions == null) {
			actions = new Actions(driver);
		}
	}

//	@AfterSuite
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}

}
