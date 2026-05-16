package com.vodafone.vodafone_eshop_taf.tests.red;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RedStepDefs extends BaseTest {

    private String linePrice;
    private String simNumberInRedPage;

    @When("click on red tab in mega menu")
    public void setSimNumberInFlexPage() {
        browser.eshopWebsite.home.megaMenu.clickOnRedTab();
    }

    @Then("the stepper on the red lines page should be displayed")
    public void theStepperOnTheRedLinesPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.redLines.isStepperPresent(), "The vf-stepper component is not present");
    }

    @Then("the main title on the red lines page should be displayed with text {string}")
    public void mainTitleShouldBeDisplayedWithText(String title) {
        Assert.assertEquals(title, browser.eshopWebsite.redLines.getMainPageTitle());
    }

    @When("scroll down to terms and conditions section")
    public void scrollDownToTermsAndConditionsSection()
    {
        browser.eshopWebsite.redLines.scrollToTermsAndConditionSection();
    }

    @Then("the terms and condition section on the red lines page should be clickable")
    public void termsAndConditionsSectionShouldBeDisplayed() {
        browser.eshopWebsite.redLines.clickOnTermsAndConditionSection();
    }

    @Then("the line price on the Red lines page should be displayed as {string}")
    public void theLinePriceOnTheRedLinesPageShouldBeDisplayedAs (String price) {
        Assert.assertEquals(browser.eshopWebsite.redLines.getLinePriceText(), price);
    }

    @When("click on the first available red line in red line page")
    public void clickOnTheFirstAvailableRedLineInRedLinePage() throws InterruptedException {
        simNumberInRedPage = browser.eshopWebsite.redLines.getFirstLineNumber();
        browser.eshopWebsite.redLines.scrollToLinesSection();
        browser.eshopWebsite.redLines.clickOnFirstLineButton();
    }

    @When("click on the choose this line button in red line page")
    public void clickOnTheChooseThisLineButtonInRedLinePage () throws InterruptedException {
        browser.eshopWebsite.redLines.clickOnChooseLineButton();
    }

    @Then("the msisdn number displayed on the red plans summary page should match the chosen number in red lines page")
    public void theMsisdnNumberDisplayedOnTheRedPlansSummaryPageShouldMatchTheChosenNumberInRedLinesPage() {
        Assert.assertEquals(simNumberInRedPage,
                browser.eshopWebsite.redLinesSummary.getMsisdnNumber());
    }

    @Then("the chosen line price on the red plans summary page should be displayed as {string}")
    public void theChosenLinePriceOnTheRedPlansSummaryPageShouldBeDisplayedAs(String linePrice) {
        String actualPrice = browser.eshopWebsite.redLinesSummary.getLinePriceInPlansPage();
        String numericPrice = actualPrice.replaceAll("\\D+", "");
        Assert.assertEquals(numericPrice, linePrice);
    }

    @Then("{string} name in plans section in red plans page should be {string}")
    public void NameInPlansSectionInRedPlansPageShouldBe(String plan ,String expectedPlanName) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getPlanName(plan), expectedPlanName);
    }

    @Then("{string} data in plans section in red plans page should be {string}")
    public void dataInPlansSectionInRedPlansPageShouldBe(String plan ,String expectedData) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getPlanData(plan), expectedData);
    }

    @Then("{string} voice in plans section in red plans page should be {string}")
    public void voiceInPlansSectionInRedPlansPageShouldBe(String plan ,String expectedVoice) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getPlanVoice(plan), expectedVoice);
    }

    @Then("{string} family members in plans section in red plans page should be {string}")
    public void familyMembersInPlansSectionInRedPlansPageShouldBe(String plan ,String expectedFamilyMembersNo) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getPlanFamilyMembersNo(plan), expectedFamilyMembersNo);
    }

    @When("click on see more info in any card of plans in red plans page")
    public void clickOnSeeMoreInfoInAnyCardOfPlansInRedPlansPage () {
        browser.eshopWebsite.redLinesPlans.clickOnSeeMoreButton();
    }

    @Then("subscription title during promotional period in red plan details overlay in red plans page should be {string}")
    public void onOverlayInRedPlansPageShouldBeDisplayedFirst (String expectedSubscriptionTitle) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getOverlayMonthelySubscibtionDuringPromotionalPeriod(), expectedSubscriptionTitle);
    }

    @Then("vat title during promotional period in red plan details overlay in red plans page should be {string}")
    public void onOverlayInRedPlansPageShouldBeDisplayedSecond (String expectedVatTitle) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getOverlaySubscibtionVatDuringPromotionalPeriod(), expectedVatTitle);
    }

    @When("click overlay close button with any Red Plan in Red Plan page")
    public void clickOverlayCloseButtonWithAnyRedPlanInRedPlanPage() {
        browser.eshopWebsite.redLinesPlans.clickOverlayCloseButton();
    }

    @When("click on edit button in red plans page")
    public void clickOnEditButtonInRedPlansPage() {
        browser.eshopWebsite.redLinesPlans.clickEditButton();
    }

    @Then("choose this line button in red line page should be dimmed")
    public void ChooseThisLineButtonInRedLinePageShouldBeDimmed() {
        WebElement button = browser.eshopWebsite.redLines.getChooseThisLineButton();
        Assert.assertEquals(button.getAttribute("aria-disabled"),
                "true",
                "Expected 'Choose this line' button to be aria-disabled"
        );
    }

    @When("click on {string} select button in red plan page")
    public void clickOnSelectButtonInRedPlanPage(String plan) throws InterruptedException {
        Thread.sleep(5000);
        browser.eshopWebsite.redLinesPlans.scrollToSelectPlanButton(plan);
        browser.eshopWebsite.redLinesPlans.clickSelectButton(plan);
    }

    @Then("{string} name in with rate plan section in red summary page should be {string}")
    public void nameInWithRatePlanSectionInRedSummaryPageShouldBe(String plan ,String expectedPlanName) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(browser.eshopWebsite.redLinesSummary.getPlanName(plan), expectedPlanName);
    }

    @Then("{int} in red family lines card in red summary page should be same total family members no for {string}")
    public void InRedFamilyLinesCardInRedSummaryPageShouldBeSameTotalFamilyMembersNoFor (int expectedFamilyMembersNo , String plan) {
        Assert.assertEquals(browser.eshopWebsite.redLinesSummary.chooseFamilyLines(plan), expectedFamilyMembersNo);
    }

    @When("clicks the Clear button to empty the shopping cart")
    public void clicksTheClearButtonToEmptyTheShoppingCart () {
        browser.eshopWebsite.home.clickClearButton();
    }

    @When("enter national id {string} in red summary page")
    public void enterNationalIdInRedSummaryPage (String nationalId) {
        browser.eshopWebsite.redLinesSummary.enterNationalId(nationalId);
    }

    @When("click on submit button in red summary page")
    public void clickOnSubmitButtonInRedSummaryPage(){
        browser.eshopWebsite.redLinesSummary.clickOnSubmitNationalId();
    }

    @Then("user should be redirected to page with link {string} in red line page")
    public void checkIfRedirectToRedLinePage(String partialLink) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }

    @Then("subscription title after promotional period in red plan details overlay in red plans page should be {string}")
    public void subscriptionTitleAfterPromotionalPeriodInRedPlanDetailsOverlayInRedPlansPageShouldBe( String expectedSubscriptionTitle) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getOverlayMonthelySubscibtionAfterPromotionalPeriod(), expectedSubscriptionTitle);
    }

    @Then("vat title after promotional period in red plan details overlay in red plans page should be {string}")
    public void vatTitleAfterPromotionalPeriodInRedPlanDetailsOverlayInRedPlansPageShouldBe( String expectedVatTitle) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getOverlaySubscibtionVatAfterPromotionalPeriod(), expectedVatTitle);

    }

    @Then("subscription channels title in red plan details overlay in red plans page should be {string}")
    public void subscriptionChannelsTitleInRedPlanDetailsOverlayInRedPlansPageShouldBe(String expectedSubscribtionToTitle) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getSubscibtionToTitle(), expectedSubscribtionToTitle);

    }

    @Then("more benefits title in red plan details overlay in red plans page should be {string}")
    public void moreBenefitsTitleInRedPlanDetailsOverlayInRedPlansPageShouldBe(String expectedMoreBenefitsTitle) {
        Assert.assertEquals(browser.eshopWebsite.redLinesPlans.getMoreBenefitsTitle(), expectedMoreBenefitsTitle);

    }

    @Then("user should be redirected to page with link {string} in cart page")
    public void userShouldBeRedirectedToPageWithLinkInCartPage(String partialLink) throws InterruptedException {
        browser.eshopWebsite.cart.waitRedirectionToCartPage(partialLink);
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }

    @When("scroll to the line price on the red line page")
    public void scrollToTheLinePriceOnTheRedLinePage() {
        browser.eshopWebsite.redLines.scrollToLinePrice();
    }

    @When("click on rate plan in the rate plan page")
    public void clickOnRatePlanInTheRatePlanPage() {
        browser.eshopWebsite.redLinesPlans.clickRatePlan();
    }

    @When("scroll to lines section header in red line page")
    public void scrollToLinesSectionHeaderInRedLinePage() {
      browser.eshopWebsite.redLines.scrollToLinesSection();
    }

    @When("select myself option in red summary page")
    public void selectMyselfOptionInRedSummaryPage() {
        browser.eshopWebsite.redLinesSummary.clickSelectOptionBuyingFor();
    }

    @When("enter first name {string} in red summary page")
    public void enterFirstNameInRedSummaryPage(String firstName) {
        browser.eshopWebsite.redLinesSummary.enterFirstName(firstName);
    }

    @When("enter last name {string} in red summary page")
    public void enterLastNameInRedSummaryPage(String lastName) {
        browser.eshopWebsite.redLinesSummary.enterLastName(lastName);
    }

    @When("click on the next button in red summary page")
    public void clickOnTheNextButtonInRedSummaryPage() {
        browser.eshopWebsite.redLinesSummary.clickOnNextButton();
    }

    @When("click on provide one of the following documents check box in red summary page")
    public void clickOnProvideOneOfTheFollowingDocumentsCheckBoxInRedSummaryPage() {
        browser.eshopWebsite.redLinesSummary.clickOnProvideOneOfTheFollowingDocumentsCheckBox();
    }
}
