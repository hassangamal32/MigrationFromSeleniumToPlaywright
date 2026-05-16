package com.vodafone.vodafone_eshop_taf.pages;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Mnp extends PageBase {

    private final By MnpStepper = By.xpath("//vf-stepper/div/div");

    private final By MnpHeader = By.xpath("//*[@class='mnp-header']");

    private final By MnpSubHeader = By.xpath("//*[@class='mnp-sub-header']");

    private final By EnterYourNameTextField = By.xpath("//input[@formcontrolname='name']");

    private final By EnterYourMobileNumberTextField = By.xpath("//input[@formcontrolname='phone']");

    private final By EnterYourEmailTextField = By.xpath("//input[@formcontrolname='email']");

    private final By submitButton = By.xpath("//button[@class='btn-primary']");

    private final By redEssentialCardSelectButton = By.xpath("//button[@class='btn btn-primary']");

    private final By yourMobileNumberEditButton= By.xpath("//button[@class='edit']");

    private final By yourRatePlanEditButton= By.xpath("//div[@class='card-header']/button");

    private final By iAmReadToPickUpMySim = By.xpath("//button[@class='btn btn-outline-primary']");

    private final By storesMenu = By.xpath("//*[@id=\"ngb-panel-0-header\"]/button");

    private final By firstStoreButton = By.xpath("//*[@id=\"ngb-panel-0\"]/div/div[1]");

    private final By calenderDropDownMenu = By.className("calender");

    private final By timeSlotDropDownMenu = By.xpath("//select[@class='time-slots-select-picker']");

    private final By selectDateAndTimeButton = By.xpath("//button[@class='btn-primary']");

    private final By yourBookingSummaryText = By.xpath("//div[@class='store-confirmation']/h3");

    private final By cancelButton = By.xpath("//button[@class='btn-outline-primary']");

    private final By confirmButton = By.xpath("//button[@class='btn-primary']");

    public WebElement getMnpStepper() {
        return safeFindElement(MnpStepper);
    }

    public WebElement getMnpHeader() {
        return safeFindElement(MnpHeader);
    }

    public WebElement getMnpSubHeader() {
        return safeFindElement(MnpSubHeader);
    }

    public WebElement getEnterYourNameTextField() {
        return safeFindElement(EnterYourNameTextField);
    }

    public WebElement getEnterYourMobileNumberTextField() {
        return safeFindElement(EnterYourMobileNumberTextField);
    }

    public WebElement getEnterYourEmailTextField() {
        return safeFindElement(EnterYourEmailTextField);
    }

    public WebElement getSubmitButton() {
        return safeFindElement(submitButton);
    }

    public WebElement getRedEssentialCardSelectButton() {
        return safeFindElement(redEssentialCardSelectButton);
    }

    public WebElement getYourMobileNumberEditButton() {
        return safeFindElement(yourMobileNumberEditButton);
    }

    public WebElement getYourRatePlanEditButton() {
        return safeFindElement(yourRatePlanEditButton);
    }

    public WebElement getIamReadyToPickUpMySimButton() {
        return safeFindElement(iAmReadToPickUpMySim);
    }

    public WebElement getStoresMenu() throws InterruptedException {
        waitElementToBeClickable(storesMenu);
        return safeFindElement(storesMenu);
    }

    public WebElement getFirstStore() throws InterruptedException {
        waitElementToBeClickable(firstStoreButton);
        return safeFindElement(firstStoreButton);
    }

    public WebElement getCalenderDropDownMenu() {
        return safeFindElement(calenderDropDownMenu);
    }

    public WebElement getTimeSlotDropDownMenu() {
        return safeFindElement(timeSlotDropDownMenu);
    }

    public WebElement getSelectDateAndTimeButton() {
        return safeFindElement(selectDateAndTimeButton);
    }

    public WebElement getYourBookingSummaryText() {
        return safeFindElement(yourBookingSummaryText);
    }

    public WebElement getCancelButton() {
        return safeFindElement(cancelButton);
    }

    public WebElement getConfirmButton() {
        return safeFindElement(confirmButton);
    }

    public void clickOnSubmitButton() {
        JavascriptExecutorClick(getSubmitButton());
    }

    public void clickOnSelectButtonInRedEssentialCard() {
        JavascriptExecutorClick(getRedEssentialCardSelectButton());
    }

    public void clickOnEditButtonInYourMobileNumberSection() {
        JavascriptExecutorClick(getYourMobileNumberEditButton());
    }

    public void clickOnEditButtonInYourRatePlanSection() {
        JavascriptExecutorClick(getYourRatePlanEditButton());
    }

    public void clickOnIamReadyToPickUpMySimButton() {
        JavascriptExecutorClick(getIamReadyToPickUpMySimButton());
    }

    public void clickOnFirstStoreButtonInMnpPage() throws InterruptedException {
        JavascriptExecutorClick(getStoresMenu());
        JavascriptExecutorClick(getFirstStore());
    }

    public void clickOnSelectDateAndTimeButton() {
        JavascriptExecutorClick(getSelectDateAndTimeButton());
    }

    public void selectDateFromCalender() {
        JavascriptExecutorClick(getCalenderDropDownMenu());
        JavascriptExecutor js = (JavascriptExecutor) WebDriverHandler.getWebDriver();
        js.executeScript("document.getElementsByClassName('calender')[0].value='" + setDate(2) + "';");
        js.executeScript("var event = new Event('change'); document.getElementsByClassName('calender')[0].dispatchEvent(event);");
    }

    public void selectTimeSlot() {
        selectFromDropDownWithPartialText(timeSlotDropDownMenu, "2");
    }

    public void enterFullNameInEnterYourNameTextField(String fullName) {
        sendText(EnterYourNameTextField, fullName);
    }

    public void enterMobileNumberInEnterYourMobileNumberTextField(String nonVodafoneMobileNumber) {
        getEnterYourMobileNumberTextField().sendKeys(nonVodafoneMobileNumber);
    }

    public void enterEmailInEnterYourEmailTextField(String email) {
        sendText(EnterYourEmailTextField, email);
    }

}
