package com.kimschiller.selenium.FunctionalTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CochraneCDSRReviews extends PageObject {

	/*
	 * https://www.cochranelibrary.com/cdsr/reviews
	 */

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[1]")
	private WebElement cochraneReviewsTab;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[1]/a/span[1]")
	private WebElement cochraneReviewsTabClickableText;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[2]")
	private WebElement cochraneProtocolsTab;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[2]/a/span[1]")
	private WebElement cochraneProtocolsTabClickableText;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/div/section/div[1]/div/div/div/div[2]/div/div[1]/div[2]/form/h2")
	private WebElement cochraneProtocolsAssertChecker;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[8]/a/span[1]")
	private WebElement moreTabClickableText;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[8]/div/ul/li[3]/a/span[1]")
	private WebElement clinicalAnswersClickableTextUnderMore; // for 900x900

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/div/section/div[1]/div/div/div/div[2]/div/div[1]/div[2]/form/div[1]/ul/li/ul/li/span/a")
	private WebElement customDateRangeAssertText;

	@FindBy(id = "customRangeFrom")
	private WebElement startDateInput;

	@FindBy(id = "customRangeTo")
	private WebElement endDateInput;

	@FindBy(id = "applyCustomRange")
	private WebElement applyCustomRangeButton;

	public CochraneCDSRReviews(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return cochraneReviewsTab.isDisplayed();
	}

	public void navigateToCochraneProtocols() {
		Actions actions = new Actions(driver);
		// WebElement mouseHover =
		// driver.findElement(By.xpath("//div[@id='mainmenu1']/div"));
		actions.moveToElement(cochraneProtocolsTabClickableText).click().perform();
		// actions.moveToElement(cochraneProtocolsTab).click().perform();
	}

	public void navigateToClinicalAnswers() {
		Actions actions = new Actions(driver);
		actions.moveToElement(moreTabClickableText).click().perform();
		actions.moveToElement(clinicalAnswersClickableTextUnderMore).click().perform();
	}

	public void enterAndApplyDateRange1() {
		startDateInput.sendKeys("23/01/2011");
		endDateInput.sendKeys("23/01/2019");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applyCustomRangeButton.click();
	}

	public WebElement getCochraneReviewsTab() {
		return cochraneReviewsTab;
	}

	public WebElement getCochraneProtocolsTab() {
		return cochraneProtocolsTab;
	}

	public WebElement getCochraneProtocolsAssertChecker() {
		return cochraneProtocolsAssertChecker;
	}

	public WebElement getCustomDateRangeAssertText() {
		return customDateRangeAssertText;
	}

	public WebElement getMoreTabClickableText() {
		return moreTabClickableText;
	}
}
