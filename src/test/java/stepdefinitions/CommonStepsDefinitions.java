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

}