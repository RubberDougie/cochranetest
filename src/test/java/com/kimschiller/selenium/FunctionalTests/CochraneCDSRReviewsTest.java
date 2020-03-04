package com.kimschiller.selenium.FunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@Test
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

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cochraneCDSRReviews.getResultsNumberElement()));

		int highestResultOnPage = cochraneCDSRReviews.getHighestDisplayedResultNumber(
				cochraneCDSRReviews.getMaxResultsPerPage(), cochraneCDSRReviews.getResultsNumber(),
				cochraneCDSRReviews.getPageNumber());
		// System.out.println(highestResultOnPage);
		wait = new WebDriverWait(driver, 10);
		/*
		 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
		 * "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/div/section/div[1]/div/div/div/div[2]/div/div[1]/div[3]/div["
		 * + highestResultOnPage + "]/div[1]/div/label"))));
		 */
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/div/section/div[1]/div/div/div/div[2]/div/div[1]/div[3]/div["
						+ highestResultOnPage + "]/div[1]/div/label")));

		int currentLastResultNumber = Integer
				.parseInt(
						cochraneCDSRReviews
								.getLowerOfNthOrRemainderResultOnPage(cochraneCDSRReviews.getMaxResultsPerPage(),
										cochraneCDSRReviews.getResultsNumber(), cochraneCDSRReviews.getPageNumber())
								.getText());
		System.out.println("WHEN:   " + currentLastResultNumber);

		/*
		 * Then
		 */

	}
}