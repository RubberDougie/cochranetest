package com.rubberdougie.pageobjects;

// https://www.cochranelibrary.com/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CochraneLibrary extends PageObject {

	@FindBy(xpath = "//*[@id=\"portlet_scolaristopics_WAR_scolaristopics\"]/div[1]/div/div/div/div[2]/div/div[2]/dl/dd[1]/ul/li[1]/a/button")
	private WebElement gastroSearchButton;

	@FindBy(xpath = "/html/head/meta[2]")
	private WebElement url;

	public CochraneLibrary(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return url.getAttribute("content").contains("https://www.cochranelibrary.com");
	}

	public CochraneLibraryTopicSearchResult gastroSearch() {
		gastroSearchButton.click();
		return new CochraneLibraryTopicSearchResult(driver);
	}

	public WebElement getGastroSearchButton() {
		return gastroSearchButton;
	}
}
