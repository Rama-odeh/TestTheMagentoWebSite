import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	Actions actions = new Actions(driver);
	String url = "https://magento.softwaretestingboard.com/";
	Random rand = new Random();
	double numbers = 0;
	double expectedPrice = 70.0;

	@BeforeTest
	public void mySetup() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1, enabled = false)
	public void signUp() {

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

	@Test(priority = 1)
	public void signIn() {

		WebElement signIn = driver.findElement(By.xpath(
				"//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']"));
		signIn.click();
		driver.findElement(By.id("email")).sendKeys("ramaabdullah@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("rama#Odeh33");
		driver.findElement(By.id("send2")).click();
	}

	@Test(priority = 2)
	public void addThreeFirstItemsOnWomenSection() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//span[text()='Women']"));
		actions.moveToElement(element).perform();

		WebElement element2 = driver.findElement(By.id("ui-id-9"));
		actions.moveToElement(element2).perform();

		driver.findElement(By.id("ui-id-13")).click();

	}

	@Test(priority = 3)
	public void TestaddToCart() throws InterruptedException {

		List<WebElement> products = driver.findElements(By.cssSelector(".item.product.product-item"));
		WebElement product;
		for (int i = 0; i < 3; i++) {
			product = products.get(i);

			WebElement productLink = product.findElement(By.cssSelector(".product-item-link"));
			productLink.click();

			WebElement sizeElement = driver.findElement(By.id("option-label-size-143-item-166"));
			sizeElement.click();

			List<WebElement> colorElements = driver.findElements(By.cssSelector(".swatch-option.color"));
			for (WebElement colorElement : colorElements) {
				if (colorElement.getAttribute("aria-label").equals("Black")
						|| colorElement.getAttribute("aria-label").equals("Blue")) {
					colorElement.click();
					break;
				}
			}

			WebElement addToCartButton = driver.findElement(By.cssSelector(".action.tocart.primary"));
			addToCartButton.click();

			driver.navigate().back();

			products = driver.findElements(By.cssSelector(".item.product.product-item"));
			Thread.sleep(2000);
		}
	}

	@Test(priority = 4)
	public void theTotalItemsInTheCart() throws InterruptedException {
		WebElement itemsNumberOnTheCart = driver.findElement(By.className("counter-number"));
		String itemsNumberOnTheCartAsString = itemsNumberOnTheCart.getText();
		int itemsNumberOnTheCartAsInt = Integer.parseInt(itemsNumberOnTheCartAsString);
		Assert.assertEquals(itemsNumberOnTheCartAsInt, 3);

		driver.findElement(By.cssSelector(".action.showcart")).click();
		WebElement itemss = driver.findElement(By.className("minicart-items-wrapper"));

		List<WebElement> items = itemss.findElements(By.cssSelector(".item.product.product-item"));
		WebElement item;
		for (int i = 0; i < items.size(); i++) {
			item = items.get(i);
			WebElement prices = item.findElement(By.className("price"));
			String price = prices.getText().replace("$", "");
			double num = Double.parseDouble(price);
			numbers += num;

		}

		Assert.assertEquals(numbers, expectedPrice);
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void totalPriceRandomly() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("btn-minicart-close")).click();
		Thread.sleep(4000);
		List<WebElement> items = driver.findElements(By.cssSelector(".item.product.product-item"));
		int randIndex = rand.nextInt(12);
		WebElement item = items.get(randIndex);
		WebElement productLink = item.findElement(By.cssSelector(".product-item-link"));
		productLink.click();

		WebElement sizeElement = driver.findElement(By.id("option-label-size-143-item-166"));
		sizeElement.click();

		List<WebElement> colorElements = driver.findElements(By.cssSelector(".swatch-option.color"));
		for (WebElement colorElement : colorElements) {
			if (colorElement.getAttribute("aria-label").equals("Black")
					|| colorElement.getAttribute("aria-label").equals("Blue")
					|| colorElement.getAttribute("aria-label").equals("Green")
					|| colorElement.getAttribute("aria-label").equals("Red")) {
				colorElement.click();
				break;
			}

		}

		WebElement addToCartButton = driver.findElement(By.cssSelector(".action.tocart.primary"));
		addToCartButton.click();

		driver.navigate().back();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector(".action.showcart")).click();
		Thread.sleep(2000);
		WebElement prices = driver.findElement(By.className("price"));
		String price = prices.getText().replace("$", "");
		double num = Double.parseDouble(price);
		numbers += num;
		System.out.println(numbers);
		System.out.println(expectedPrice);
		Assert.assertEquals(numbers > expectedPrice, true);
	}

}
