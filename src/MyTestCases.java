import org.testng.annotations.Test;

public class MyTestCases extends TestData {

	Women_Tops_TeesPageTestCases WomenPage = new Women_Tops_TeesPageTestCases();
	CreatAnAccountAndSignInPageTestCases creatAnAccountPage = new CreatAnAccountAndSignInPageTestCases();;

	@Test(priority = 1, enabled = false)
	public void signUp() throws InterruptedException {

		creatAnAccountPage.signUpTest();
	}

	@Test(priority = 1)
	public void signIn() throws InterruptedException {

		creatAnAccountPage.signInTest();
	}

	@Test(priority = 2)
	public void addThreeFirstItemsOnWomenSection() throws InterruptedException {

		WomenPage.addThreeFirstItemsOnWomenSectionTest();

	}

	@Test(priority = 3)
	public void addToCart() throws InterruptedException {

		WomenPage.addToCartTest();
	}

	@Test(priority = 4)
	public void theTotalItemsInTheCart() throws InterruptedException {
		WomenPage.theTotalItemsInTheCartTest();
	}

	@Test(priority = 5)
	public void totalPriceRandomly() throws InterruptedException {
		WomenPage.totalPriceRandomlyTest();

	}
}
