import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends TestData {

	public MyTestCases() {
		
	}
	

	Women_Tops_TeesPageTestCases WomenPage;
	CreatAnAccountAndSignInPageTestCases creatAnAccountPage;

	@Override
	@BeforeTest
	public void setUp() {
		super.setUp(); // Call the setUp method from TestData class
		WomenPage = new Women_Tops_TeesPageTestCases(driver); // Initialize MainPageTestCases with the WebDriver
		creatAnAccountPage = new CreatAnAccountAndSignInPageTestCases(driver);
	}

	@Test(priority = 1, enabled = false)
	public void signUp() {

		creatAnAccountPage.signUpTest();
	}

	@Test(priority = 1)
	public void signIn() {

		creatAnAccountPage.signInTest();
	}

	@Test(priority = 2)
	public void addThreeFirstItemsOnWomenSection() {

		WomenPage.addThreeFirstItemsOnWomenSectionTest();

	}

	@Test(priority = 3)
	public void addToCart() {

		WomenPage.addToCartTest();
	}

	@Test(priority = 4)
	public void theTotalItemsInTheCart() {
		WomenPage.theTotalItemsInTheCartTest();
	}

	@Test(priority = 5)
	public void totalPriceRandomly() throws InterruptedException {
		WomenPage.totalPriceRandomlyTest();

	}
}
