package com.kimschiller.selenium.FunctionalTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CochraneCDSRReviews extends PageObject {

	/*
	 * https://www.cochranelibrary.com/cdsr/reviews
	 */

	private boolean hasMorePages = true;
	private int pageNumber = 1;
	private int maxResultsPerPage = 25; // default

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

	@FindBy(className = "results-number")
	private WebElement resultsNumber;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/div/section/div[1]/div/div/div/div[2]/div/div[1]/div[2]/form/div[4]/div[2]/div[2]/div/div")
	private WebElement maxNumberPerPageSelector;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/div/section/div[1]/div/div/div/div[2]/div/div[1]/div[2]/form/div[4]/div[2]/div[2]/div/ul")
	private WebElement maxNumberPerPageSelectorList;

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/div/section/div[1]/div/div/div/div[2]/div/div[1]/div[2]/form/div[4]/div[2]/div[2]/div/ul/li[3]")
	private WebElement maxPerPageSelector50;

	@FindBy(className = "pagination-next-link")
	private WebElement nextPageButton;

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

	public WebElement getMaxNumberPerPageSelector() {
		return maxNumberPerPageSelector;
	}

	public WebElement getMaxNumberPerPageSelectorList() {
		return maxNumberPerPageSelectorList;
	}

	public WebElement getMaxPerPageSelector50() {
		return maxPerPageSelector50;
	}

	public WebElement getResultsNumberElement() {
		return resultsNumber;
	}

	public int getResultsNumber() {
		System.out.println("test get results number func:    " + resultsNumber.getText());
		return Integer.parseInt(resultsNumber.getText());
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public boolean hasMorePages() {
		return hasMorePages;
	}

	public int getMaxResultsPerPage() {
		return maxResultsPerPage;
	}

	public boolean setMaxReulstsPerPage(int maxPerPage) {
		if ((maxResultsPerPage = maxPerPage) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public int getHighestDisplayedResultNumber(int maxResultsPerPage, int resultsNumber, int pageNumber) {
		int highestPossibleNumberOnPageAssumingFull = maxResultsPerPage * pageNumber;

		int highestResultOnPage;
		if (resultsNumber > highestPossibleNumberOnPageAssumingFull) {
			highestResultOnPage = highestPossibleNumberOnPageAssumingFull;
		} else {
			highestResultOnPage = resultsNumber;
			hasMorePages = false; // a side-effect that might not be smart
		}

		return highestResultOnPage;
	}

	public WebElement getLowerOfNthOrRemainderResultOnPage(int maxResultsPerPage, int resultsNumber, int pageNumber) {
		int highestResultOnPage = getHighestDisplayedResultNumber(maxResultsPerPage, resultsNumber, pageNumber);

		return driver.findElement(
				By.xpath("//*[@id=\"column-2\"]/div[1]/div[3]/div[" + highestResultOnPage + "]/div[1]/div/label"));
	}

	public WebElement getNextPageButtonAndIncreasePageNumber() {
		pageNumber++;
		return nextPageButton;
	}
}