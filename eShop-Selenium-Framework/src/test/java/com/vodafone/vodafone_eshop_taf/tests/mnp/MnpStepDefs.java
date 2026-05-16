package com.vodafone.vodafone_eshop_taf.tests.mnp;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MnpStepDefs extends BaseTest {

    @When("scroll down to you can join with your number section in red lines page")
    public void scrollDownToYouCanJoinWithYourNumberSectionInRedLinesPage()
    {
        browser.eshopWebsite.redLines.scrollToSwitchNowButton();
    }

    @When("click on switch now button in red lines page")
    public void clickOnSwitchNowButtonInRedLinesPage() {
        browser.eshopWebsite.mnp = browser.eshopWebsite.redLines.clickOnSwitchNowButton();
    }

    @When("mnp stepper in mnp page should be displayed")
    public void mnpStepperInMnpPageShouldBeDisplayed()
    {
        Assert.assertTrue(browser.eshopWebsite.mnp.getMnpStepper().isDisplayed());
    }

    @When("mnp header in mnp Page should be {string}")
    public void mnpHeaderInMnpPageShouldBe(String MnpHeader)
    {
        Assert.assertEquals(browser.eshopWebsite.mnp.getMnpHeader().getText(),MnpHeader);
    }

    @When("mnp sub header in mnp Page should be {string}")
    public void mnpSubHeaderInMnpPageShouldBe(String MnpSubHeader)
    {
        Assert.assertEquals(browser.eshopWebsite.mnp.getMnpSubHeader().getText(),MnpSubHeader);
    }

    @When("enter your name text field in mnp page should be displayed")
    public void enterYourNameTextFieldInMnpPageShouldBeDisplayed()
    {
        Assert.assertTrue(browser.eshopWebsite.mnp.getEnterYourNameTextField().isDisplayed());
    }

    @When("enter your mobile number text field in mnp page should be displayed")
    public void enterYourMobileNumberTextFieldInMnpPageShouldBeDisplayed()
    {
        Assert.assertTrue(browser.eshopWebsite.mnp.getEnterYourMobileNumberTextField().isDisplayed());
    }

    @When("enter your email text field in mnp page should be displayed")
    public void enterYourEmailTextFieldInMnpPageShouldBeDisplayed()
    {
        Assert.assertTrue(browser.eshopWebsite.mnp.getEnterYourEmailTextField().isDisplayed());
    }

    @When("submit button in mnp page should be dimmed")
    public void submitButtonInMnpPageShouldDimmed()
    {
        Assert.assertFalse(browser.eshopWebsite.mnp.getSubmitButton().isEnabled());
    }

    @When("enter full name with text {string} in mnp page")
    public void enterFullNameWithTextInMnpPage(String fullName) {
        browser.eshopWebsite.mnp.enterFullNameInEnterYourNameTextField(fullName);
    }

    @When("enter mobile number with text {string} in mnp page")
    public void enterMobileNumberWithTextInMnpPage(String nonVodafoneMobileNumber) {
        browser.eshopWebsite.mnp.enterMobileNumberInEnterYourMobileNumberTextField(nonVodafoneMobileNumber);
    }

    @When("enter email address with text {string} in mnp page")
    public void enterEmailAddressWithTextInMnpPage(String email) {
        browser.eshopWebsite.mnp.enterEmailInEnterYourEmailTextField(email);
    }

    @When("click on submit button in mnp page")
    public void clickOnSubmitButtonInMnpPage(){
        browser.eshopWebsite.mnp.clickOnSubmitButton();
    }

    @When("click on select button in red essential card in mnp page")
    public void clickOnSelectButtonInRedEssentialCardInMnpPage() {
      browser.eshopWebsite.mnp.clickOnSelectButtonInRedEssentialCard();
    }

    @When("click on edit button in your mobile number section in mnp summary page")
    public void clickOnEditButtonInYourMobileNumberSectionInMnpSummaryPage()
    {
        browser.eshopWebsite.mnp.clickOnEditButtonInYourMobileNumberSection();
    }

    @When("click on edit button in your rate plan section in mnp summary page")
    public void clickOnEditButtonInYourRatePlanSectionInMnpSummaryPage()
    {
        browser.eshopWebsite.mnp.clickOnEditButtonInYourRatePlanSection();
    }

    @Then("user should be redirected to mnp personal info page with link {string}")
    public void userShouldBeRedirectedToMnpPersonalInfoPageWithLink(String personalInfoLink)
    {
        Assert.assertEquals(WebDriverHandler.getWebDriver().getCurrentUrl(),personalInfoLink);
    }

    @Then("user should be redirected to mnp rate plan page with link {string}")
    public void userShouldBeRedirectedToMnpRatePlanPageWithLink(String ratePlanPageLink)
    {
        Assert.assertEquals(WebDriverHandler.getWebDriver().getCurrentUrl(),ratePlanPageLink);
    }

    @When("click on I am ready to pick up my sim button in mnp page")
    public void clickOnIamReadyToPickUpMySimButtonInMnpPage(){
        browser.eshopWebsite.mnp.clickOnIamReadyToPickUpMySimButton();
    }

    @When("click on the first store from stores menu in mnp page")
    public void clickOnTheFirstStoreFromStoresMenuInMnpPage() throws InterruptedException {
        browser.eshopWebsite.mnp.clickOnFirstStoreButtonInMnpPage();
    }

    @When("select a date from the calender in mnp page")
    public void selectADateFromCalenderInMnpPage(){
        browser.eshopWebsite.mnp.selectDateFromCalender();
    }

    @When("select a time from time slot drop down menu in mnp page")
    public void selectTimeFromTimeSlotDropDownMenu()
    {
        browser.eshopWebsite.mnp.selectTimeSlot();
    }

    @When("click on select date and time button in mnp page")
    public void clickOnSelectDateAndTimeButtonInMnpPage()
    {
        browser.eshopWebsite.mnp.clickOnSelectDateAndTimeButton();
    }

    @Then("user should be redirected to mnp store confirmation page with link {string}")
    public void userShouldBeRedirectedToMnpStoreConfirmationPageWithLink(String storeConfirmationLink)
    {
        Assert.assertEquals(WebDriverHandler.getWebDriver().getCurrentUrl(),storeConfirmationLink);
    }

    @Then("your booking summary text should be {string}")
    public void yourBookingSummaryTextShouldBe(String bookingSummaryText){
        Assert.assertEquals(browser.eshopWebsite.mnp.getYourBookingSummaryText().getText(),bookingSummaryText);
    }

    @Then("cancel button in mnp store confirmation page should be displayed")
    public void cancelButtonInMnpStoreConfirmationPageShouldBeDisplayed()
    {
        Assert.assertTrue(browser.eshopWebsite.mnp.getCancelButton().isDisplayed());
    }

    @Then("confirm button in mnp store confirmation page should be displayed")
    public void confirmButtonInMnpStoreConfirmationPageShouldBeDisplayed()
    {
        Assert.assertTrue(browser.eshopWebsite.mnp.getConfirmButton().isDisplayed());
    }
}
