import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatAnAccountAndSignInPageTestCases extends TestData {

	WebDriver driver;

	// Constructor to initialize WebDriver
	public CreatAnAccountAndSignInPageTestCases(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signUpTest() {

		WebElement createAnAccount = driver.findElement(
				By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
		createAnAccount.click();
		driver.findElement(By.id("firstname")).sendKeys("Rama");
		driver.findElement(By.id("lastname")).sendKeys("Odeh");
		driver.findElement(By.id("email_address")).sendKeys("ramaabdullah@gmail.com");
		driver.findElement(By.id("password")).sendKeys("rama#Odeh33");
		driver.findElement(By.id("password-confirmation")).sendKeys("rama#Odeh33");
		driver.findElement(By.cssSelector(".action.submit.primary")).click();
	}
	
	public void signInTest() {

		WebElement signIn = driver.findElement(By.xpath(
				"//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']"));
		signIn.click();
		driver.findElement(By.id("email")).sendKeys("ramaabdullah@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("rama#Odeh33");
		driver.findElement(By.id("send2")).click();
	}
}
