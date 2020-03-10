package com.rubberdougie.pageobjectsandtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CochraneLibraryTopicSearchTest {

	@Test
	public void testStuffGoodNameIKnoww2() {

		/*
		 * Given
		 */

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(900, 900));
		driver.navigate().to("https://www.cochranelibrary.com/");

		CochraneLibrary cochraneLibrary = new CochraneLibrary(driver);

		assertTrue(cochraneLibrary.isInitialized());

		/*
		 * When
		 */

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cochraneLibrary.getGastroSearchButton()));
		CochraneLibraryTopicSearchResult cochraneLibraryTopicSearchResult = cochraneLibrary.gastroSearch();

		/*
		 * Then
		 */

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneLibraryTopicSearchResult.getCochraneReviewsTab(),
				"class", "tab"));
		assertTrue(cochraneLibraryTopicSearchResult.isInitialized());

		assertEquals("Gastroenterology & hepatology", cochraneLibraryTopicSearchResult.getTopicTitle1().getText());

		driver.close();
	}
}
