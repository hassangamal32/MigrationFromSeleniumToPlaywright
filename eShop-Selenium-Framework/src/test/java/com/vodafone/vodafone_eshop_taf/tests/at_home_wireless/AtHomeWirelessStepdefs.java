package com.vodafone.vodafone_eshop_taf.tests.at_home_wireless;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.pages.AtHomeSubscriptionDetails;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AtHomeWirelessStepdefs extends BaseTest {

    String homeWirelessPlusNameInAtHomeRouterPage;
    Double homeWirelessPlusPriceInAtHomeRouterPage;
    private String linkURL="/cart";


    @Then("home wireless plus router title in at home router page should be {string}")
    public void homeWirelessPlusRouterTitleInAtHomeRouterPageShouldBe(String homeWirelessPlus) throws InterruptedException {
        homeWirelessPlusNameInAtHomeRouterPage=browser.eshopWebsite.atHomeRouter.getHomeWireless4GPlusTitle().getText();
        Assert.assertEquals(homeWirelessPlusNameInAtHomeRouterPage, homeWirelessPlus);
    }

    @Then("home wireless router title in at home router page should be {string}")
    public void homeWirelessRouterTitleInAtHomeRouterPageShouldBe(String homeWireless) {
        Assert.assertEquals(browser.eshopWebsite.atHomeRouter.gethomeWireless5GPlusTitle().getText(), homeWireless);
    }

    @Then("first bundle name in at home bundles page should be displayed with text {string}")
    public void firstBundleNameInAtHomeBundlesPageShouldBeDisplayedWithText(String firstBundle) {
        Assert.assertEquals(browser.eshopWebsite.atHomeBundle.getQouta40GBName().getText(), firstBundle);
    }

    @Then("second bundle name in at home bundles page should be displayed with text {string}")
    public void secondBundleNameInAtHomeBundlesPageShouldBeDisplayedWithText(String secondBundle) {
        Assert.assertEquals(browser.eshopWebsite.atHomeBundle.getQouta135GBName().getText(), secondBundle);
    }

    @Then("third bundle name in at home bundles page should be displayed with text {string}")
    public void thirdBundleNameInAtHomeBundlesPageShouldBeDisplayedWithText(String thirdBundle) {
        Assert.assertEquals(browser.eshopWebsite.atHomeBundle.getQouta250GBName().getText(), thirdBundle);
    }

    @Then("fourth bundle name in at home bundles page should be displayed with text {string}")
    public void fourthBundleNameInAtHomeBundlesPageShouldBeDisplayedWithText(String fourthBundle) {
        Assert.assertEquals(browser.eshopWebsite.atHomeBundle.getQouta400GBName().getText(), fourthBundle);
    }

    @When("click on select first quota in at home bundles page")
    public void clickOnSelectFirstQuotaInAtHomeBundlesPage() {
        browser.eshopWebsite.atHomeRouter=browser.eshopWebsite.atHomeBundle.clickOnSelectFirstQuotaInAtHomeBundlesPage();
    }

    @When("click on select button for {string} in at home router page")
    public void clickOnSelectButtonForAtHomeRouterInAtHomeRouterPage(String routerName) throws InterruptedException {
      browser.eshopWebsite.atHomeSubscriptionDetails= (AtHomeSubscriptionDetails) browser.eshopWebsite.atHomeRouter.clickOnSelectButtonForAtHomeRouterInAtHomeRouterPage(routerName);
    }

    @When("get {string} Price in at home router page")
    public void getHomeWirelessPlusPriceInAtHomeRouterPage(String routerName) throws InterruptedException {
        homeWirelessPlusPriceInAtHomeRouterPage=  browser.eshopWebsite.atHomeRouter.getAtHomeRouterPriceText(routerName);
    }

    @When("click on go to checkout button in subscription details page")
    public void clickOnGoToCheckoutButtonInSubscriptionDetailsPage() throws InterruptedException {
        Thread.sleep(2000);
        browser.eshopWebsite.cart = browser.eshopWebsite.atHomeSubscriptionDetails.clickOnCheckOutButton();
    }

    @When("scroll down to please enter your national id section in subscription page")
    public void scrollDownToPleaseEnterYourNationalIDSectionInSubscriptionPage() {
        browser.eshopWebsite.atHomeSubscriptionDetails.getPrepareYourDocumentSection();
    }

    @Then("check please enter your national id section in subscription page should be displayed")
    public void checkPleaseEnterYourNationalIdSectionInSubscriptionPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.atHomeSubscriptionDetails.getPrepareYourDocumentSection().isDisplayed());
    }

    @Then("router price in at home router page should be the same as {string} price in subscription details page")
    public void routerPriceInAtHomeRouterPageShouldBeTheSameAsRouterPriceInSubscriptionDetailsPage (String routerNameINSubscribtionPage) {
        Assert.assertEquals(browser.eshopWebsite.atHomeSubscriptionDetails.getAtHomeRouterPriceText(routerNameINSubscribtionPage), Math.round(homeWirelessPlusPriceInAtHomeRouterPage));

    }

    @When("click on edit button {string} in subscription page")
    public void clickOnEditAtHomeRouterButtonInSubscriptionPage(String routerName) {
        browser.eshopWebsite.atHomeSubscriptionDetails.clickAtHomeRouterEditButton(routerName);
    }

    @Then("home wireless stepper in at home bundles page should be displayed")
    public void homeWirelessStepperInAtAtHomeBundlesPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.atHomeBundle.getHomeWirelessStepper().isDisplayed());
    }

    @Then("at home bundles page title should be {string}")
    public void AtHomeBundlesPageTitleShouldBe(String title) {
        Assert.assertEquals(browser.eshopWebsite.atHomeBundle.getAtHomeBundlesPageTitle().getText(),title);
    }

    @Then("at home bundles page description should be displayed")
    public void AtHomeBundlesPageDescriptionShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.atHomeBundle.getAtHomeBundlesPageDescription().isDisplayed());
    }

    @And("choose routers page title should be {string} in at home router page")
    public void chooseRoutersPageTitleShouldBeInAtHomeRouterPage(String title) {
        Assert.assertEquals(browser.eshopWebsite.atHomeRouter.getChooseRoutersPageTitle().getText(),title);
    }

    @Then("user should be redirected to subscription details page with link {string}")
    public void userShouldBeRedirectedToSubscriptionDetailsPageWithLink(String link) {
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(link));
    }


    @Then("cart icon in header section increased by {string}")
    public void cartIconInHeaderSectionIncreasedBy (String counter) {
        Assert.assertEquals(browser.eshopWebsite.cart.getCartCounter().getText(), counter);
    }

    @And("{string} price in at home router page should be {string}")
    public void priceInAtHomeRouterPageShouldBe(String RouterName, String RouterPrice) throws InterruptedException {
        Assert.assertEquals(browser.eshopWebsite.atHomeRouter.getAtHomeRouterPrice(RouterName).getText(),RouterPrice);
    }

    @And("{string} installment price in at home page should be {string}")
    public void installmentPriceInAtHomePageShouldBe(String RouterName, String RouterInstallmentPrice) {
        Assert.assertEquals(browser.eshopWebsite.atHomeRouter.getAtHomeRouterInstallmentPrice(RouterName).getText(),RouterInstallmentPrice);
    }

    @Then("home wireless router title in at home Subscription details should be {string}")
    public void homeWirelessRouterTitleInAtHomeSubscriptionDetailsShouldBe(String atHomeRouterTitle) {
        Assert.assertEquals(browser.eshopWebsite.atHomeSubscriptionDetails.getAtHomeRouterTitle(atHomeRouterTitle).getText(),atHomeRouterTitle);
    }

    @When("scroll down to terms and conditions button in at home bundles page")
    public void scrollDownToTermsAndConditionsButtonInAtHomeBundlesPage(){
        browser.eshopWebsite.atHomeBundle.scrollToTermsAndConditionText();
    }

    @And("click on terms and condition section in at home bundle page")
    public void clickOnTermsAndConditionSectionInAtHomeBundlePage() {
        browser.eshopWebsite.atHomeBundle.clickOnTermsAndConditionButton();
    }

    @Then("terms section body in at home bundle page should be displayed")
    public void termsSectionBodyInAtHomeBundlePageShouldBeDisplayed() throws InterruptedException {
        browser.eshopWebsite.atHomeBundle.getTermsAndConditionText();
    }

    @Then("user will be redirected to at home summary page with link {string}")
    public void userWillBeRedirectedToAtHomeSummaryPageWithLink(String link) throws InterruptedException {
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(link));
    }

    @When("enter your national id {string} in national id input field in subscription page")
    public void enterYourNationalIDInNationalIdInputFieldInSubscriptionPage(String nationalID) {
        browser.eshopWebsite.atHomeSubscriptionDetails.enterNationalIDField(nationalID);
    }

    @Then("check the national id response message {string} if national id is not eligible for purchasing at home router")
    public void checkTheNationalIDResponseMessageIfNationalIdIsNotEligibleForPurchasingAtHomeRouter(String expectedMessage) {
        String actualMessage = browser.eshopWebsite.atHomeSubscriptionDetails.getNationalIDValidationMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("enter your factory number {string} in factory number input field in subscription page")
    public void enterYourFactoryNumberInFactoryNumberInputFieldInSubscriptionPage(String factoryNumber) {
        browser.eshopWebsite.atHomeSubscriptionDetails.enterFactoryNumberField(factoryNumber);
    }

    @Then("check the factory number response message {string} if factory number is not eligible for purchasing at home router")
    public void checkTheFactoryNumberResponseMessageIfFactoryNumberIsNotEligibleForPurchasingAtHomeRouter(String expectedMessage) {
        String actualMessage = browser.eshopWebsite.atHomeSubscriptionDetails.getFactoryNumberValidationMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("pop up appear with message {string} that national id is not eligible from purchase at home in subscription page")
    public void popUpAppearWithMessageThatNationalIdIsNotEligibleFromPurchaseAtHomeInSubscriptionPage(String responseMessage) {
        String actualMessage = browser.eshopWebsite.atHomeSubscriptionDetails.getPopUpValidationMessage().getText();
        Assert.assertEquals(actualMessage,responseMessage);
    }
}
