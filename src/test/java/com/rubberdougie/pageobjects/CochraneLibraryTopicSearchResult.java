package com.rubberdougie.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CochraneLibraryTopicSearchResult extends PageObject {

	@FindBy(xpath = "//*[@id=\"column-2\"]/div[1]/div[1]/ul/li[1]")
	private WebElement cochraneReviewsTab;

	@FindBy(xpath = "//*[@id=\"facetDisplaySection\"]/ul/li/ul/li/span/a")
	private WebElement topicTitle1;

	public CochraneLibraryTopicSearchResult(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return cochraneReviewsTab.isDisplayed();
	}

	public WebElement getCochraneReviewsTab() {
		return cochraneReviewsTab;
	}

	public WebElement getTopicTitle1() { // should make a parameterized version taking in the name
		return topicTitle1;
	}
}