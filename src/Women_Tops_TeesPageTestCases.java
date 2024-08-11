import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Women_Tops_TeesPageTestCases extends TestData {

	public void addThreeFirstItemsOnWomenSectionTest() throws InterruptedException {
		 if (actions == null) {
		        actions = new Actions(driver);
		    }
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Women']"));
		actions.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.id("ui-id-9"));
		actions.moveToElement(element2).perform();
		Thread.sleep(2000);
		driver.findElement(By.id("ui-id-13")).click();
		Thread.sleep(2000);
	}

	public void addToCartTest() throws InterruptedException {

		List<WebElement> products = driver.findElements(By.cssSelector(".item.product.product-item"));
		WebElement product;
		for (int i = 0; i < 3; i++) {
			product = products.get(i);
			Thread.sleep(2000);
			WebElement productLink = product.findElement(By.cssSelector(".product-item-link"));
			productLink.click();
			Thread.sleep(2000);
			WebElement sizeElement = driver.findElement(By.id("option-label-size-143-item-166"));
			sizeElement.click();
			Thread.sleep(2000);
			List<WebElement> colorElements = driver.findElements(By.cssSelector(".swatch-option.color"));
			for (WebElement colorElement : colorElements) {
				if (colorElement.getAttribute("aria-label").equals("Black")
						|| colorElement.getAttribute("aria-label").equals("Blue")) {
					colorElement.click();
					break;
				}
			}
			Thread.sleep(2000);
			WebElement addToCartButton = driver.findElement(By.cssSelector(".action.tocart.primary"));
			addToCartButton.click();
			Thread.sleep(2000);
			driver.navigate().back();

			products = driver.findElements(By.cssSelector(".item.product.product-item"));
			Thread.sleep(2000);
		}
	}

	public void theTotalItemsInTheCartTest() throws InterruptedException {

		WebElement itemsNumberOnTheCart = driver.findElement(By.className("counter-number"));
		String itemsNumberOnTheCartAsString = itemsNumberOnTheCart.getText();
		int itemsNumberOnTheCartAsInt = Integer.parseInt(itemsNumberOnTheCartAsString);
		Assert.assertEquals(itemsNumberOnTheCartAsInt, 3);
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		WebElement addToCartButton = driver.findElement(By.cssSelector(".action.tocart.primary"));
		addToCartButton.click();
		Thread.sleep(2000);
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
