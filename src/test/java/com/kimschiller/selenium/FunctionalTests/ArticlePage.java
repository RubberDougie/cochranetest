package com.kimschiller.selenium.FunctionalTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends PageObject {

	@FindBy(xpath = "//*[@id=\"portlet_scolariscontentdisplay_WAR_scolariscontentdisplay\"]/div[1]/div/div/div[1]/article/header/h1")
	private WebElement articleNameElement;

	public ArticlePage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return articleNameElement.isDisplayed();
	}

	public WebElement getArticleNameElement() {
		return articleNameElement;
	}
}