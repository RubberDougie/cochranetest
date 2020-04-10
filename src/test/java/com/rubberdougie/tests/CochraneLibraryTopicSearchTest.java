package com.rubberdougie.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rubberdougie.pageobjects.CochraneLibrary;
import com.rubberdougie.pageobjects.CochraneLibraryTopicSearchResult;

public class CochraneLibraryTopicSearchTest extends GlobalTestMethods {

	private WebDriverWait wait;
	private CochraneLibrary cochraneLibrary;

	@Before
	public void beforeFunction() {
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/");

		cochraneLibrary = new CochraneLibrary(driver);

		assertTrue(cochraneLibrary.isInitialized());
	}

	@Test
	public void testTopicSearchButton() {

		/*
		 * Given
		 */

		/*
		 * When
		 */

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(cochraneLibrary.getGastroSearchButton()));
		CochraneLibraryTopicSearchResult cochraneLibraryTopicSearchResult = cochraneLibrary.gastroSearch();

		/*
		 * Then
		 */

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(cochraneLibraryTopicSearchResult.getCochraneReviewsTab(),
				"class", "tab"));
		assertTrue(cochraneLibraryTopicSearchResult.isInitialized());

		assertEquals("Gastroenterology & hepatology", cochraneLibraryTopicSearchResult.getTopicTitle1().getText());
	}
}
