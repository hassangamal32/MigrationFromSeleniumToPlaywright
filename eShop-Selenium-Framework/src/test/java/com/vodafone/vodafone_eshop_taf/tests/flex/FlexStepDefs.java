package com.vodafone.vodafone_eshop_taf.tests.flex;


import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FlexStepDefs extends BaseTest {

    private String linePrice;
    private String msisdnNumberInFlexPage;

    @Given("flex lines page is opened in language {string}")
    public void flexLinesPageIsOpenedInLanguage(String preferredLanguage) {
        browser.eshopWebsite.flexLines = browser.openVodafoneFlexPage();
        browser.eshopWebsite.header.switchLanguageTo(preferredLanguage);
    }


    @Then("the line price in the flex lines page should be {string}")
    public void LinePriceShouldBeWithText(String price) {
        Assert.assertEquals(browser.eshopWebsite.flexLines.getLinePriceText(), price);
    }

    @When("user click on the first available flex line in the flex lines page")
    public void userClickOnTheFirstAvailableMSISDNFlexLineInFlexLinesPage() {
        msisdnNumberInFlexPage = browser.eshopWebsite.flexLines.getFirstLineNumber();
        browser.eshopWebsite.flexLines.clickOnFirstLineButton();
    }

    @When("click on Choose this line button in flex lines page")
    public void clickOnTheChooseLineButton() {
        browser.eshopWebsite.flexLines.clickOnChooseLineButton();
    }

    @Then("the msisdn number displayed on the flex plans page should match the chosen number in flex lines page")
    public void theMsisdnNumberDisplayedOnTheFlexPlansPageShouldMatchTheChosenNumberInFlexLinesPage() {
        Assert.assertEquals(browser.eshopWebsite.flexLinesPlans.getMsisdnNumber(), msisdnNumberInFlexPage);
    }

    @Then("the chosen line price in the flex lines plans page should be {string}")
    public void chosenLinePriceInFlexPlansPageShouldBeWithText(String price) {
        Assert.assertEquals(browser.eshopWebsite.flexLinesPlans.getLinePriceTextInPlansPage(), price);
    }

    @Then("the main title on the flex lines page should be displayed with text {string}")
    public void theMainTitleOnTheFlexLinesPageShouldBeDisplayedWithText(String pageTitle) {
        Assert.assertEquals(browser.eshopWebsite.flexLines.getFlexLinePageTitle(), pageTitle);
    }


    @Then("the selected number in flex lines is the same as the clicked number")
    public void theSelectedNumberInFlexLinesIsTheSameAsTheClickedNumber() {
        Assert.assertEquals(browser.eshopWebsite.flexLines.getFirstSelectedLineNumber(), msisdnNumberInFlexPage);
    }


    @When("user click on edit button in flex plans page")
    public void userClickOnEditButton() {
        browser.eshopWebsite.flexLinesPlans.clickOnEditButton();
    }

    @And("selected MSISDN in flex lines page is empty")
    public void SelectedMSISDNInFlexLinesPageIsEmpty() {
        Assert.assertEquals(browser.eshopWebsite.flexLines.getFirstSelectedLineNumber(), "No Selected MSISDNs");
    }

    @Then("user will be redirected to flex lines summary page and title should {string}")
    public void userWillBeRedirectedToFlexLinesSummaryPageAndTitleShould(String pleaseEnterYourID) {
        Assert.assertEquals(browser.eshopWebsite.flexLinesSummary.getYourIDNumberTitle(), pleaseEnterYourID);
    }

    @When("user enter {string} in flex lines summary page")
    public void userEnterInFlexLinesSummaryPage(String validID) {
        browser.eshopWebsite.flexLinesSummary.enterIdNumberField(validID);
    }

    @Then("user click on ID submit button in flex lines summary page")
    public void userClickOnIDButton() {
        browser.eshopWebsite.flexLinesSummary.clickOnIdSubmitButton();
    }

    @Then("{string} name in plans section in flex plans page should be {string}")
    public void nameInPlansSectionInFlexPlansPageShouldBe(String planName, String expectedPlanName) {
        Assert.assertEquals(browser.eshopWebsite.flexLinesPlans.getRatePlansName(planName), expectedPlanName);
    }

    @And("{string} quota in plans section in flex plans page should be {string}")
    public void quotaInPlansSectionInFlexPlansPageShouldBe(String planName, String quota) {
        Assert.assertEquals(browser.eshopWebsite.flexLinesPlans.getRatePlanQuotas(planName), quota);
    }

    @And("the stepper in the flex lines page should be displayed")
    public void theStepperInTheFlexLinesPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.flexLines.isStepperPresent(), "The vf-stepper component is not present");
    }

    @And("terms and conditions title in flex lines page should be {string}")
    public void termsAndConditionsWithInFlexLinesPageShouldBe(String termsAndConditions) {
        Assert.assertEquals(browser.eshopWebsite.flexLines.getTermsAndConditionsText(), termsAndConditions);
    }

    @And("the terms and condition section in the flex lines page should be clickable")
    public void theTermsAndConditionSectionInTheFlexLinesPageShouldBeClickable() {
        browser.eshopWebsite.flexLines.clickOnTermsAndConditions();
    }

    @Then("user should be redirected to page with link {string}")
    public void userShouldBeRedirectedToPageWithLink(String partialLink) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }

    @Then("{string}  see more info button in the flex lines plans page is clickable")
    public void seeMoreInfoButtoninTheFlexLinesPlansPageIsClickable(String planName) {
        Assert.assertTrue(browser.eshopWebsite.flexLinesPlans.getSeeMoreInfoButton(planName).isDisplayed());
    }

    @When("click on see more info button for {string} in the flex lines plans page")
    public void clickOnSeeMoreInfoButtonForInTheFlexLinesPlansPage(String planName) {
        browser.eshopWebsite.flexLinesPlans.clickOnSeeMoreInfoButton(planName);
    }

    @And("{string} select button in the flex lines plans page is clickable")
    public void selectButtonInTheFlexLinesPlansPageIsClickable(String planName) {
        Assert.assertTrue(browser.eshopWebsite.flexLinesPlans.getRatePlanSelectButton(planName).isDisplayed());
    }

    @When("click on select button of {string} in flex lines plans page")
    public void clickOnSelectButtonOfInFlexLinesPlansPage(String planName) {
        browser.eshopWebsite.flexLinesPlans.clickOnRatePlanSelectButton(planName);
    }

    @Then("user should be redirected to page with link {string} in flex lines plans page")
    public void userShouldBeRedirectedToPageWithLinkInFlexLinesPlansPage(String partialLink) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }

    @And("{string} price in plans section in flex plans page should be {string}")
    public void priceInPlansSectionInFlexPlansPageShouldBe(String planName, String planPrice) {
        Assert.assertEquals(browser.eshopWebsite.flexLinesPlans.getRatePlanPrices(planName), planPrice);
    }

    @Then("choose this line button in flex line page should be dimmed")
    public void ButtonInRedLinePageShouldBeDimmed() {
        WebElement button = browser.eshopWebsite.redLines.getChooseThisLineButton();
        boolean isDisabled = button.getAttribute("disabled") != null;
        String opacity = button.getCssValue("opacity");
        boolean isDimmed = isDisabled || Float.parseFloat(opacity) < 1.0;
        Assert.assertFalse(isDimmed, "The 'Choose this line' button is not dimmed, but it should be.");

    }

    @Then("monthly subscription excluding VAT for {string} in flex plan details overlay in flex plans page should be {string}")
    public void monthlySubscriptionExcludingVATForInFlexPlanDetailsOverlayInFlexPlansPageShouldBe(String planName, String monthlySubscriptionExcludingVAT) {
        Assert.assertEquals(browser.eshopWebsite.flexLinesPlans.getMonthlyPriceWithoutVAT_Text(), monthlySubscriptionExcludingVAT);
    }

    @And("monthly subscription including VAT for {string} in flex plan details overlay in flex plans page should be {string}")
    public void monthlySubscriptionIncludingVATForInFlexPlanDetailsOverlayInFlexPlansPageShouldBe(String planName, String monthlySubscriptionIncludingVAT) {
        Assert.assertEquals(browser.eshopWebsite.flexLinesPlans.getMonthlyPriceWithVAT_Text(), monthlySubscriptionIncludingVAT);
    }

    @Then("user will be redirected to flex lines summary page with link {string}")
    public void userWillBeRedirectedToFlexLinesSummaryPageWithLink(String partialLink) throws InterruptedException {
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }

    @Then("user will be redirected to cart page with link {string}")
    public void userWillBeRedirectedToCartPageWithLink(String partialLink) throws InterruptedException {
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }
}
