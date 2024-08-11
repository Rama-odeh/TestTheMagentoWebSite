import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Women_Tops_TeesPageTestCases extends TestData {

	WebDriver driver;

	// Constructor to initialize WebDriver
	public Women_Tops_TeesPageTestCases(WebDriver driver) {
		this.driver = driver;
	}

	public void addThreeFirstItemsOnWomenSectionTest() {

		WebElement element = driver.findElement(By.xpath("//span[text()='Women']"));
		actions.moveToElement(element).perform();

		WebElement element2 = driver.findElement(By.id("ui-id-9"));
		actions.moveToElement(element2).perform();

		driver.findElement(By.id("ui-id-13")).click();

	}

	public void addToCartTest() {

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

		}
	}

	public void theTotalItemsInTheCartTest() {
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

	}
	
	public void totalPriceRandomlyTest() throws InterruptedException {
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
