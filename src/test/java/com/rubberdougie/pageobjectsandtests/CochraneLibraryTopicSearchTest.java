package com.rubberdougie.pageobjectsandtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CochraneLibraryTopicSearchTest extends GlobalPageMethods {

	private WebDriverWait wait;
	private CochraneLibrary cochraneLibrary;

	@Before
	public void beforeFunction() {
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/");

		cochraneLibrary = new CochraneLibrary(driver);

		assertTrue(cochraneLibrary.isInitialized());
	}

	@After
	public void afterFunction() {
		driver.close();
	}

	@Test
	public void testTopicSearchButton() {

		/*
		 * Given
		 */

		/*
		 * When
		 */

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(cochraneLibrary.getGastroSearchButton()));
		CochraneLibraryTopicSearchResult cochraneLibraryTopicSearchResult = cochraneLibrary.gastroSearch();

		/*
		 * Then
		 */

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.attributeContains(cochraneLibraryTopicSearchResult.getCochraneReviewsTab(),
				"class", "tab"));
		assertTrue(cochraneLibraryTopicSearchResult.isInitialized());

		assertEquals("Gastroenterology & hepatology", cochraneLibraryTopicSearchResult.getTopicTitle1().getText());
	}
}
