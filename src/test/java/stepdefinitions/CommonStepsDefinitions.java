package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kimschiller.selenium.FunctionalTests.CochraneCDSRReviews;
import com.kimschiller.selenium.FunctionalTests.CochraneLibrary;
import com.kimschiller.selenium.FunctionalTests.CochraneLibraryTopicSearchResult;
import com.kimschiller.selenium.FunctionalTests.PageObject;
import com.rubberdougie.stringthings.StringThings;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStepsDefinitions {

	public static WebDriver driver;
	public PageObject currentPage;

	@Given("the user opens the Cochrane Library page")
	public void the_user_opens_the_Cochrane_Library_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/");

		CochraneLibrary cochraneLibrary = new CochraneLibrary(driver);

		assertTrue(cochraneLibrary.isInitialized());

		currentPage = cochraneLibrary;
	}

	@When("the user clicks the Gastroenterology & hepatology button")
	public void the_user_clicks_the_Gastroenterology_hepatology_button() {
		CochraneLibrary cochraneLibrary = (CochraneLibrary) currentPage;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cochraneLibrary.getGastroSearchButton()));
		CochraneLibraryTopicSearchResult cochraneLibraryTopicSearchResult = cochraneLibrary.gastroSearch();
		currentPage = cochraneLibraryTopicSearchResult;
	}

	@Then("the user is redirected to the Gastroenterology & hepatology search page")
	public void the_user_is_redirected_to_the_Gastroenterology_hepatology_search_page() {
		CochraneLibraryTopicSearchResult cochraneLibraryTopicSearchResult = (CochraneLibraryTopicSearchResult) currentPage;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneLibraryTopicSearchResult.getCochraneReviewsTab(),
				"class", "tab"));
		assertTrue(cochraneLibraryTopicSearchResult.isInitialized());

		assertEquals("Gastroenterology & hepatology", cochraneLibraryTopicSearchResult.getTopicTitle1().getText());

		driver.close();
	}

	@Given("the user opens the Cochrane CDSR Reviews page")
	public void the_user_opens_the_Cochrane_CDSR_Reviews_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/cdsr/reviews");

		CochraneCDSRReviews cochraneCDSRReviews = new CochraneCDSRReviews(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class", "tab"));

		assertTrue(cochraneCDSRReviews.isInitialized());

		currentPage = cochraneCDSRReviews;
	}

	@When("the user clicks the More button then the Clnical Answers button")
	public void the_user_clicks_the_More_button_then_the_Clnical_Answers_button() {
		CochraneCDSRReviews cochraneCDSRReviews = (CochraneCDSRReviews) currentPage;
		cochraneCDSRReviews.navigateToClinicalAnswers();
		currentPage = cochraneCDSRReviews;
	}

	@Then("the user is shown the Clinical Answers data")
	public void the_user_is_shown_the_Clinical_Answers_data() {
		CochraneCDSRReviews cochraneCDSRReviews = (CochraneCDSRReviews) currentPage;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsAssertChecker(),
				"class", ""));

		String assertValue = cochraneCDSRReviews.getCochraneProtocolsAssertChecker().getText()
				.contains("Clinical Answers") ? "True" : "False";
		assertEquals("True", assertValue);
		driver.close();
	}

	/*
	 * @Given("the user opens the Cochrane CDSR Reviews page") public void
	 * the_user_opens_the_Cochrane_CDSR_Reviews_page() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	@When("the user clicks the Cochrane Protocols tab")
	public void the_user_clicks_the_Cochrane_Protocols_tab() {
		CochraneCDSRReviews cochraneCDSRReviews = (CochraneCDSRReviews) currentPage;
		cochraneCDSRReviews.navigateToCochraneProtocols();
		currentPage = cochraneCDSRReviews;
	}

	@Then("the user is shown the subset of reviews for that visible tab")
	public void the_user_is_shown_the_subset_of_reviews_for_that_visible_tab() {
		CochraneCDSRReviews cochraneCDSRReviews = (CochraneCDSRReviews) currentPage;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsAssertChecker(),
				"class", ""));

		String assertValue = cochraneCDSRReviews.getCochraneProtocolsAssertChecker().getText()
				.contains("Cochrane Protocols") ? "True" : "False";
		assertEquals("True", assertValue);
		driver.close();
	}

	/*
	 * @Given("the user opens the Cochrane CDSR Reviews page") public void
	 * the_user_opens_the_Cochrane_CDSR_Reviews_page() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	@When("the user enters the start date, end date, then clicks the button")
	public void the_user_enters_the_start_date_end_date_then_clicks_the_button() {
		CochraneCDSRReviews cochraneCDSRReviews = (CochraneCDSRReviews) currentPage;
		cochraneCDSRReviews.enterAndApplyDateRange1();
		currentPage = cochraneCDSRReviews;
	}

	@Then("the user is shown data appropriate to the date range")
	public void the_user_is_shown_data_appropriate_to_the_date_range() {
		CochraneCDSRReviews cochraneCDSRReviews = (CochraneCDSRReviews) currentPage;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsAssertChecker(),
				"class", ""));

		String assertValue = cochraneCDSRReviews.getCustomDateRangeAssertText().getText().contains("Custom date range")
				? "True"
				: "False";
		assertEquals("True", assertValue);
		driver.close();
	}

	/*
	 * @Given("the user opens the Cochrane CDSR Reviews page") public void
	 * the_user_opens_the_Cochrane_CDSR_Reviews_page() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	@When("the user clicks the max search results per page list and selects a different selection")
	public void the_user_clicks_the_max_search_results_per_page_list_and_selects_a_different_selection() {
		CochraneCDSRReviews cochraneCDSRReviews = (CochraneCDSRReviews) currentPage;

		Actions actions = new Actions(driver);
		actions.moveToElement(cochraneCDSRReviews.getMaxNumberPerPageSelector()).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cochraneCDSRReviews.getMaxNumberPerPageSelectorList()));
		actions.moveToElement(cochraneCDSRReviews.getMaxPerPageSelector50()).click().perform();

		/*
		 * This WOULD work if the drop down box in question ever updated to not hidden
		 * in the DOM, but it doesn't. I think the website is bugged
		 * 
		 * 
		 * Select maxResultsPerPageSelection = new Select(
		 * driver.findElement(By.xpath(cochraneCDSRReviews.
		 * getMaxResultsPerPageSelectionXpath())));
		 * maxResultsPerPageSelection.selectByVisibleText("50");
		 */

		cochraneCDSRReviews.setMaxReulstsPerPage(50);

		currentPage = cochraneCDSRReviews;
	}

	@Then("the user is shown the results corresponding to the selection of max search results per page")
	public void the_user_is_shown_the_results_corresponding_to_the_selection_of_max_search_results_per_page() {
		CochraneCDSRReviews cochraneCDSRReviews = (CochraneCDSRReviews) currentPage;

		while (cochraneCDSRReviews.hasMorePages() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(cochraneCDSRReviews.getResultsNumberElement()));

			int expectedHighestResultOnPage = cochraneCDSRReviews.getHighestDisplayedResultNumber();
			// System.out.println(highestResultOnPage);
			wait = new WebDriverWait(driver, 30);
			// I have to use the shortened xpath or I can never locate this, why?
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"column-2\"]/div[1]/div[3]/div["
					+ cochraneCDSRReviews.calculateModdedResultIndexForFurtherPages() + "]/div[1]/div/label")));

			int currentLastResultNumber = Integer
					.parseInt(cochraneCDSRReviews
							.getLowerOfNthOrRemainderResultOnPage(cochraneCDSRReviews.getMaxResultsPerPage(),
									cochraneCDSRReviews.getResultsNumber(), cochraneCDSRReviews.getPageNumber())
							.getText());
			assertEquals(expectedHighestResultOnPage, currentLastResultNumber);

			if (cochraneCDSRReviews.hasMorePages() == true) {

				/*
				 * 
				 * only doing first and last page
				 * 
				 */

				String baseURL = StringThings
						.removeEndDigits(cochraneCDSRReviews.getNextPageButton().getAttribute("href"));
				int finalPageNumber = cochraneCDSRReviews.calculateHighestPageNumber();
				String finalPageURL = baseURL + finalPageNumber;

				driver.navigate().to(finalPageURL);

				cochraneCDSRReviews = new CochraneCDSRReviews(driver, finalPageNumber,
						cochraneCDSRReviews.getMaxResultsPerPage());
				wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class",
						"tab"));

				assertTrue(cochraneCDSRReviews.isInitialized());
			}
		}

		driver.close();
	}
}