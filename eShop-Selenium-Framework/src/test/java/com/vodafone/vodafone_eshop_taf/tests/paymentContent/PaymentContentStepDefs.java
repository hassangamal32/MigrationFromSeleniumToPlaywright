package com.vodafone.vodafone_eshop_taf.tests.paymentContent;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PaymentContentStepDefs extends BaseTest {

    @When("scroll to shop now pay later section in home page")
    public void scrollToShopNowPayLaterSectionInHomePage() {
        browser.eshopWebsite.home.scrollDownToShopNowPayLaterSection();
    }

    @Then("shop now pay later section should be displayed in home page")
    public void shopNowPayLaterSectionShouldBeDisplayedInHomePage() {
        Assert.assertTrue(browser.eshopWebsite.home.getShopNowPayLaterSection().isDisplayed());
    }

    @When("click on explore all button in shop now pay later section in home page")
    public void clickOnExploreAllButtonInShopNowPayLaterSectionInHomePage() {
        browser.eshopWebsite.paymentContent = browser.eshopWebsite.home.clickOnExploreAllButtonInShopNowPayLaterSection();
    }

    @Then("dynamic banner should be displayed in payment content page")
    public void dynamicBannerShouldBeDisplayedInPaymentContentPage() {
        Assert.assertTrue(browser.eshopWebsite.paymentContent.getBannerSection().isDisplayed());
    }

    @Then("educational section should be displayed in payment content page")
    public void educationalSectionShouldBeDisplayedInPaymentContentPage() {
        Assert.assertTrue(browser.eshopWebsite.paymentContent.getEducationSection().isDisplayed());
    }

    @Then("banks tab should be selected in payment content page")
    public void banksTabShouldBeSelectedInPaymentContentPage() {
        Assert.assertTrue(browser.eshopWebsite.paymentContent.isBanksTabSelected());
    }

    @Then("bnpls tab should be selected in payment content page")
    public void bnplsTabShouldBeSelectedInPaymentContentPage() {
        Assert.assertTrue(browser.eshopWebsite.paymentContent.isBnplsTabSelected());
    }

    @Then("card of payment partner {string} should be displayed in payment content page")
    public void cardOfPaymentPartnerShouldBeDisplayedInPaymentContentPage(String paymentPartnerName) {
        Assert.assertTrue(browser.eshopWebsite.paymentContent.getPaymentPartnerCard(paymentPartnerName).isDisplayed());
    }

    @When("click on banks tab in payment content page")
    public void clickOnBanksTabInPaymentContentPage() {
        browser.eshopWebsite.paymentContent.clickBanksTab();
    }

    @When("click on bnpls tab in payment content page")
    public void clickOnBnplsTabInPaymentContentPage() {
        browser.eshopWebsite.paymentContent.clickBnplsTab();
    }

    @Then("user should be redirected to payment content page with link {string}")
    public void userShouldBeRedirectedToPaymentContentPageWithLink(String partialLink) {
        browser.eshopWebsite.paymentContent.waitForUrlContains(partialLink);
        Assert.assertEquals(browser.eshopWebsite.paymentContent.getCurrentURL().split("\\?")[0],"https://eshop.vodafone.com.eg" + partialLink);
    }

    @When("click on payment partner card {string} in shop now pay later section in home page")
    public void clickOnPaymentPartnerCardInShopNowPayLaterSectionInHomePage(String partnerName) {
        browser.eshopWebsite.paymentDetails = browser.eshopWebsite.home.clickOnPaymentPartnerCardInShopNowPayLaterSection(partnerName);
    }

    @Then("user should be redirected to payment details page with link {string}")
    public void userShouldBeRedirectedToPaymentDetailsPageWithLink(String partialLink) {
        browser.eshopWebsite.paymentDetails.waitForUrlContains(partialLink);
        Assert.assertEquals(browser.eshopWebsite.paymentDetails.getCurrentURL().split("\\?")[0],"https://eshop.vodafone.com.eg" + partialLink);
    }

    @Then("content of installment plans for payment partner should be displayed in payment details page")
    public void contentOfInstallmentPlansForPaymentPartnerShouldBeDisplayedInPaymentDetailsPage() {
        Assert.assertTrue(browser.eshopWebsite.paymentDetails.getInstallmentPlansContentSection().isDisplayed());
    }

    @When("click on payment partner card {string} in payment content page")
    public void clickOnPaymentPartnerCardInPaymentContentPage(String partnerName) {
        browser.eshopWebsite.paymentDetails = browser.eshopWebsite.paymentContent.clickOnPaymentPartnerCard(partnerName);
    }

    @When("click on installment plans breadcrumb in payment details page")
    public void clickOnInstallmentPlansBreadcrumbInPaymentDetailsPage() {
        browser.eshopWebsite.paymentContent = browser.eshopWebsite.paymentDetails.clickBreadCrumbInstallmentPlansButton();
    }


}