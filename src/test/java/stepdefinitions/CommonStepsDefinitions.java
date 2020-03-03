package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kimschiller.selenium.FunctionalTests.CochraneLibrary;
import com.kimschiller.selenium.FunctionalTests.CochraneLibraryTopicSearchResult;
import com.kimschiller.selenium.FunctionalTests.PageObject;

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
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the More button then the Clnical Answers button")
	public void the_user_clicks_the_More_button_then_the_Clnical_Answers_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user is shown the Clinical Answers data")
	public void the_user_is_shown_the_Clinical_Answers_data() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	/*
	 * @Given("the user opens the Cochrane CDSR Reviews page") public void
	 * the_user_opens_the_Cochrane_CDSR_Reviews_page() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	@When("the user clicks the Cochrane Protocols tab")
	public void the_user_clicks_the_Cochrane_Protocols_tab() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user is shown the subset of reviews for that visible tab")
	public void the_user_is_shown_the_subset_of_reviews_for_that_visible_tab() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	/*
	 * @Given("the user opens the Cochrane CDSR Reviews page") public void
	 * the_user_opens_the_Cochrane_CDSR_Reviews_page() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	@When("the user enters the start date, end date, then clicks the button")
	public void the_user_enters_the_start_date_end_date_then_clicks_the_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user is shown data appropriate to the date range")
	public void the_user_is_shown_data_appropriate_to_the_date_range() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}