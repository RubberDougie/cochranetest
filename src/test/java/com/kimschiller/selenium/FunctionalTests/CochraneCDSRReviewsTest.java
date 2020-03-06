package com.kimschiller.selenium.FunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rubberdougie.stringthings.StringThings;

public class CochraneCDSRReviewsTest {

	// @Test
	public void testStuffGoodNameIKnow() {

		/*
		 * Given
		 */

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/cdsr/reviews");

		CochraneCDSRReviews cochraneCDSRReviews = new CochraneCDSRReviews(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class", "tab"));

		assertTrue(cochraneCDSRReviews.isInitialized());

		/*
		 * When
		 */

		cochraneCDSRReviews.navigateToCochraneProtocols();

		/*
		 * Then
		 */

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsAssertChecker(),
				"class", ""));

		String assertValue = cochraneCDSRReviews.getCochraneProtocolsAssertChecker().getText()
				.contains("Cochrane Protocols") ? "True" : "False";
		assertEquals("True", assertValue);
		driver.close();
	}

	// @Test
	public void testMoreTab() {

		/*
		 * Given
		 */

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/cdsr/reviews");

		CochraneCDSRReviews cochraneCDSRReviews = new CochraneCDSRReviews(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class", "tab"));

		assertTrue(cochraneCDSRReviews.isInitialized());

		/*
		 * When
		 */

		cochraneCDSRReviews.navigateToClinicalAnswers();

		/*
		 * Then
		 */

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsAssertChecker(),
				"class", ""));

		String assertValue = cochraneCDSRReviews.getCochraneProtocolsAssertChecker().getText()
				.contains("Clinical Answers") ? "True" : "False";
		assertEquals("True", assertValue);
		driver.close();
	}

	// @Test
	public void testDateRangeInput1() {

		/*
		 * Given
		 */

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/cdsr/reviews");

		CochraneCDSRReviews cochraneCDSRReviews = new CochraneCDSRReviews(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class", "tab"));

		assertTrue(cochraneCDSRReviews.isInitialized());

		/*
		 * When
		 */

		cochraneCDSRReviews.enterAndApplyDateRange1();

		/*
		 * Then
		 */

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsAssertChecker(),
				"class", ""));

		String assertValue = cochraneCDSRReviews.getCustomDateRangeAssertText().getText().contains("Custom date range")
				? "True"
				: "False";
		assertEquals("True", assertValue);
		driver.close();
	}

	// @Test
	public void nameHere() {

		/*
		 * Given
		 */

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/cdsr/reviews");

		CochraneCDSRReviews cochraneCDSRReviews = new CochraneCDSRReviews(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class", "tab"));

		assertTrue(cochraneCDSRReviews.isInitialized());

		/*
		 * When
		 */

		Actions actions = new Actions(driver);
		actions.moveToElement(cochraneCDSRReviews.getMaxNumberPerPageSelector()).click().perform();
		wait = new WebDriverWait(driver, 10);
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

		/*
		 * Then
		 */

		while (cochraneCDSRReviews.hasMorePages() == true) {
			wait = new WebDriverWait(driver, 15);
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
				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class",
						"tab"));

				assertTrue(cochraneCDSRReviews.isInitialized());
			}
		}

		driver.close();
	}

	@Test
	public void testToSeeIfSearchResultSendsToRightPage() {

		/*
		 * Given
		 */

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/cdsr/reviews");

		CochraneCDSRReviews cochraneCDSRReviews = new CochraneCDSRReviews(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class", "tab"));

		assertTrue(cochraneCDSRReviews.isInitialized());

		/*
		 * When
		 */

		WebElement firstResult = cochraneCDSRReviews.getFirstResult();
		String firstResultTitle = firstResult.getText().trim();

		String firstResultURL = firstResult.getAttribute("href").trim();
		driver.navigate().to(firstResultURL);
		ArticlePage articlePage = cochraneCDSRReviews.getArticlePage();

		/*
		 * Then
		 */

		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(articlePage.getArticleNameElement()));
		assertTrue(articlePage.isInitialized());

		assertEquals(firstResultTitle, articlePage.getArticleNameElement().getText().trim());

		driver.close();
	}
}