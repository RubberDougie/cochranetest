package com.kimschiller.selenium.FunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CochraneCDSRReviewsTest {

	@Test
	public void testStuffGoodNameIKnow() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.cochranelibrary.com/cdsr/reviews");

		CochraneCDSRReviews cochraneCDSRReviews = new CochraneCDSRReviews(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsTab(), "class", "tab"));

		assertTrue(cochraneCDSRReviews.isInitialized());

		cochraneCDSRReviews.navigateToCochraneProtocols();

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(cochraneCDSRReviews.getCochraneProtocolsAssertChecker(),
				"class", ""));

		String assertValue = cochraneCDSRReviews.getCochraneProtocolsAssertChecker().getText()
				.contains("Cochrane Protocols") ? "True" : "False";
		assertEquals("True", assertValue);
	}
}