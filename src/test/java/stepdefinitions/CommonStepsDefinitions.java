package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStepsDefinitions {
	@Given("^the user inputs valid \"([^.+]*)\" and \"([^.+]*)\"$")
	public void the_user_inputs_valid_username_and_password(String user, String password) {
		System.out.println(user + " " + password);
	}

	@Given("^the user inputs valid username and password$")
	public void the_user_inputs_valid_username_and_password() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Given("^the user inputs valid departure date \\\"([^.+]*)\\\" and arrival date \\\"([^.+]*)\\\"$")
	public void the_user_inputs_valid_departure_date_and_arrival_date(String departureDate, String arrivalDate) {
		System.out.println(departureDate + " " + arrivalDate);
	}

	@When("^user clicks Submit button$")
	public void user_clicks_submit_button() {
		System.out.println("hi2");
	}

	@Then("^the user is redirected to the flight page$")
	public void the_user_is_redirected_to_the_flight_page() {
		System.out.println("hi3");
	}

	@When("user clicks the search button")
	public void user_clicks_the_search_button() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^user is redirected to page matching \\\"([^.+]*)\\\"$")
	public void user_is_redirected_to_page_matching(String string) {
		// Write code here that turns the phrase above into concrete actions;
		System.out.println(string);
	}

	@Given("the user inputs valid departure date departureDate and arrival date arrivalDate")
	public void the_user_inputs_valid_departure_date_departureDate_and_arrival_date_arrivalDate() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("^user inputs in the search box the search term \\\"([^.+]*)\\\"$")
	public void user_inputs_in_the_search_box_the_search_term(String string) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
		WebDriverWait wait = new WebDriverWait(browser, 10);
		// WebElement searchBar = browser.findElement(By.id("searchInput"));
		WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchInput")));
		searchBar.sendKeys(string);
		System.out.println(string);
		// System.out.println(searchBar.getAttribute("value")); // searchBar.getText()
		// returned blank
		wait = new WebDriverWait(browser, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(searchBar, string));
		searchBar.submit();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// WebElement href = browser.findElement(By.xpath("//a[@href='/beta/login']"))
		browser.close();
		System.out.println(string);
	}

	@Given("user opens the Biography portal")
	public void user_opens_the_Biography_portal() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("https://en.wikipedia.org/wiki/Portal:Biography");
		WebDriverWait wait = new WebDriverWait(browser, 10);
		// WebElement searchBar = browser.findElement(By.id("searchInput"));
		WebElement leftButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/div[3]/div[3]/div[4]/div/table/tbody/tr/td/div[3]/div[1]/div[2]/div[1]/ul/li[1]/div/div[1]/div/span[1]/a/span[1]")));
		Thread.sleep(3000);
		leftButton.click();
		Thread.sleep(2000);
		leftButton.click();
		Thread.sleep(2000);
	}

	@When("user clicks the {string} left arrow")
	public void user_clicks_the_left_arrow(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user is redirected to the left")
	public void user_is_redirected_to_the_left() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}