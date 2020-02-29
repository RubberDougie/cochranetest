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

	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div/div[1]/section/div[1]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[8]/div/ul/li[1]/a/span[1]")
	private WebElement clinicalAnswersClickableText;

	/*
	 * 
	 * @FindBy(id = "firstname") private WebElement firstName;
	 * 
	 * @FindBy(id = "firstname") private WebElement firstName;
	 * 
	 * @FindBy(id = "firstname") private WebElement firstName;
	 * 
	 * @FindBy(id = "firstname") private WebElement firstName;
	 * 
	 * @FindBy(id = "firstname") private WebElement firstName;
	 * 
	 * @FindBy(id = "lastname") private WebElement lastName;
	 * 
	 * @FindBy(id = "address") private WebElement address;
	 * 
	 * @FindBy(id = "zipcode") private WebElement zipCode;
	 * 
	 * @FindBy(id = "signup") private WebElement submitButton;
	 * 
	 */

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

	public WebElement getCochraneReviewsTab() {
		return cochraneReviewsTab;
	}

	public WebElement getCochraneProtocolsTab() {
		return cochraneProtocolsTab;
	}

	public WebElement getCochraneProtocolsAssertChecker() {
		return cochraneProtocolsAssertChecker;
	}

	/*
	 * public boolean isInitialized() { return firstName.isDisplayed(); }
	 * 
	 * public void enterName(String firstName, String lastName) {
	 * this.firstName.clear(); this.firstName.sendKeys(firstName);
	 * 
	 * this.lastName.clear(); this.lastName.sendKeys(lastName); }
	 * 
	 * public void enterAddress(String address, String zipCode) {
	 * this.address.clear(); this.address.sendKeys(address);
	 * 
	 * this.zipCode.clear(); this.zipCode.sendKeys(zipCode); }
	 * 
	 * public ReceiptPage submit() { submitButton.click(); return new
	 * ReceiptPage(driver); }
	 */
}
