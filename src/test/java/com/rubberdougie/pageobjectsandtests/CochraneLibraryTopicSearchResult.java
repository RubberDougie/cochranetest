package com.rubberdougie.pageobjectsandtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CochraneLibraryTopicSearchResult extends PageObject {

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[1]")
	private WebElement cochraneReviewsTab;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[2]/form/div[1]/ul/li/ul/li/span/a")
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