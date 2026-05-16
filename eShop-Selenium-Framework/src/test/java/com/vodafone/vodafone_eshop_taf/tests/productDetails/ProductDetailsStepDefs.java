package com.vodafone.vodafone_eshop_taf.tests.productDetails;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.pages.ProductDetails;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;


public class ProductDetailsStepDefs extends BaseTest {

    String TopSellingFirstItemTitleInHomePage;
    String ProductTitleInProductDetailsPage;
    String ProductTitleInCartPage;


    @When("get first item title in top selling section in home page")
    public void getFirstItemTitleInTopSellingSectionInHomePage() {
        TopSellingFirstItemTitleInHomePage = browser.eshopWebsite.home.getFirstItemTitleInTopSelling().getText();
    }


    @When("click on add to cart button in product details page")
    public void clickOnAddToCartButtonInProductDetailsPage() {
        browser.eshopWebsite.cart = browser.eshopWebsite.productDetails.clickOnAddToCartButton();
    }

    @When("click on add to cart button in product details page for guest user")
    public void clickOnAddToCartButtonInProductDetailsPageForGuestUser() {
        browser.eshopWebsite.login = browser.eshopWebsite.productDetails.clickOnAddToCartButtonForGuestUser();
    }


    @Then("device name in product details page should be the same as the device name in home page")
    public void
    deviceNameInProductDetailsPageShouldBeTheSameAsTheDeviceNameInHomePage() {
        ProductTitleInProductDetailsPage = browser.eshopWebsite.productDetails.getProductTitle().getText();
        Assert.assertEquals(TopSellingFirstItemTitleInHomePage.toLowerCase(), ProductTitleInProductDetailsPage.toLowerCase());
    }

    @When("scroll down to specifications section in product details page")
    public void scrollDownToSpecificationsTabInProductDetailsPage() {
        browser.eshopWebsite.productDetails.scrollToSpecificationsTab();
    }

    @Then("specifications tab should be displayed in product details page")
    public void specificationsTabShouldBeDisplayedInProductDetailsPage() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getSpecificationsTab().isDisplayed());
    }

    @Then("the price with 12 months interest in the product details page should match the expected price")
    public void thePriceWith12MonthsInterestInTheProductDetailsPageShouldMatchTheExpectedPrice() {
        double productPriceInProductDetailsPage = browser.eshopWebsite.productDetails.getProductPriceText();
        double expectedProductPriceWith12MonthsInterest = productPriceInProductDetailsPage / 12;
        Assert.assertEquals(
                browser.eshopWebsite.productDetails.getProductInstallmentPriceText(),
                Math.floor(expectedProductPriceWith12MonthsInterest));
    }


    @When("scroll down to Terms and conditions tab in product details page")
    public void scrollDownToTermsAndConditionsTabInProductDetailsPage() {
        browser.eshopWebsite.productDetails.scrollToTermsAndConditionsTabInProductDetails();
    }

    @Then("terms and conditions section in product details page should be displayed")
    public void termsAndConditionsTabInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getTermsAndConditionsTabInProductDetails().isDisplayed());
    }


    @When("click on buy now button in product details page")
    public void clickOnBuyNowButtonInProductDetailsPage() {
        browser.eshopWebsite.cart = browser.eshopWebsite.productDetails.clickOnBuyNowButton();
    }

    @When("click on buy now button in product details page for guest user")
    public void clickOnBuyNowButtonInProductDetailsPageForGuestUser() {
        browser.eshopWebsite.login = browser.eshopWebsite.productDetails.clickOnBuyNowButtonForGuestUser();
    }

    @Then("user will redirect to {string} login page")
    public void userWillRedirectToLoginPage(String partialLink) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }

    @Then("product title in product details page should be displayed")
    public void productTitleInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getProductTitle().isDisplayed());
    }

    @When("click on specifications section in product details page")
    public void clickOnSpecificationsSectionInProductDetailsPage() {
        browser.eshopWebsite.productDetails.clickOnSpecificationsTabInProductDetailsPage();
    }

    @Then("specifications section body in product details page should be displayed")
    public void specificationsSectionBodyInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getSpecificationsSectionBodyText().isDisplayed());
    }

    @Then("click on terms section in product details page")
    public void clickOnTermsSectionInProductDetailsPage() {
        browser.eshopWebsite.productDetails.clickOnTermsSectionButton();
    }

    @Then("terms section body in product details page should be displayed")
    public void termsSectionBodyInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getTermsSectionBody().isDisplayed());
    }

    @Then("product color in product details page should be displayed")
    public void productColorInProductDetailsPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getProductColor().isDisplayed());
    }

    @Then("product image in product details page should be displayed")
    public void productImageInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getProductImage().isDisplayed());
    }

    @Then("product storage in product details page should be displayed")
    public void productStorageInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getProductStorage().isDisplayed());
    }

    @Then("product installment section header in product details page should be displayed")
    public void productInstallmentSectionHeaderInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.productInstallmentSectionHeader().isDisplayed());
    }

    @Then("product title in cart page should be the same as the product name in product details page")
    public void productTitleInCartPageShouldBeTheSameAsTheProductNameInProductDetailsPage() throws InterruptedException {
        ProductTitleInCartPage = browser.eshopWebsite.cart.getProductTitle().getText();
        Assert.assertEquals(ProductTitleInCartPage.toLowerCase(), ProductTitleInProductDetailsPage.toLowerCase());
    }

    @Then("product quantity in cart page should be displayed")
    public void productQuantityInCartPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.cart.getProductQuantityInCartPage().isDisplayed());
    }

    @Then("product price in product details page should be displayed")
    public void productPriceInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.productPriceInProductDetailsPage().isDisplayed());
    }

    @Then("add to cart button in product details page should be displayed")
    public void addToCartButtonInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getAddToCartButton().isDisplayed());
    }

    @Then("buy now button in product details page should be displayed")
    public void buyNowButtonInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getBuyNowButtonInProductDetails().isDisplayed());
    }

    @Then("cart icon in header section increased by one")
    public void cartIconInHeaderSectionIncreasedByOne() {
        Assert.assertEquals(browser.eshopWebsite.cart.getCartCounter(), "1");
    }

    @When("click on add to compare check box in product details page")
    public void clickOnAddToCompareCheckBoxInProductDetailsPage() throws InterruptedException {
        browser.eshopWebsite.productDetails.clickOnAddToCompareCheckBoxInProductDetailsPage();
    }

    @Then("compare section should be displayed in product details page")
    public void compareSectionShouldBeDisplayedInProductDetailsPage() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getCompareSectionInProductPageDetails().isDisplayed());
    }

    @Then("compare button should be disabled in product details page")
    public void compareButtonShouldBeDisabledInProductDetailsPage() {
        Assert.assertFalse(browser.eshopWebsite.productDetails.getCompareButton().isEnabled());
    }

    @Then("clear all button in product page details should be displayed")
    public void clearAllButtonInProductPageDetailsShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getClearCompareButton().isDisplayed());
    }

    @When("click on monthly installments plans section in product details page")
    public void clickOnMonthlyInstallmentsPlansSectionInProductDetailsPage() {
        browser.eshopWebsite.productDetails.getMonthlyInstallmentsPlansSection().click();
    }

    @Then("installments plans options should be displayed product details page")
    public void installmentsPlansOptionsShouldBeDisplayedProductDetailsPage() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getInstallmentsPlansOptions().isDisplayed());
    }

    @Then("cib bank icon in payment card content in product details page should be displayed")
    public void cibBankIconInPaymentCardContentInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getCibBankIcon().isDisplayed());
    }

    @Then("misr bank icon in payment card content in product details page should be displayed")
    public void misrBankIconInPaymentCardContentInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getMisrBankIcon().isDisplayed());
    }

    @When("click on bnpl installments tab in product details page")
    public void clickOnBnplInstallmentsTabInProductDetailsPage() {
        browser.eshopWebsite.productDetails.getBnblInstallmentsTab().click();
    }

    @Then("seven icon in payment card content in product details page should be displayed")
    public void sevenIconInPaymentCardContentInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getSevenIcon().isDisplayed());
    }

    @Then("aman icon in payment card content in product details page should be displayed")
    public void amanIconInPaymentCardContentInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getAmanIcon().isDisplayed());
    }

    @Then("insurance options section title should be displayed")
    public void insuranceOptionsSectionTitleShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getInsuranceSectionTitle().isDisplayed());
    }

    @Then("option of insurance {string} should be displayed in product details page")
    public void optionOfInsuranceShouldBeDisplayedInProductDetailsPage(String insuranceType) {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getInsuranceOptionHeader(insuranceType).isDisplayed());
    }

    @When("click on insurance {string} details button in product details page")
    public void clickOnInsuranceDetailsButtonInProductDetailsPage(String insuranceType) {
        browser.eshopWebsite.productDetails.clickOnInsuranceDetailsButton(insuranceType);
    }

    @Then("click on add insurance button {string} in product details page")
    public void clickOnAddInsuranceButtonInProductDetailsPage(String insuranceType) {
        browser.eshopWebsite.productDetails.clickOnAddInsuranceButton(insuranceType);
    }

    @Given("open the product details page of item with link {string}")
    public void openTheProductDetailsPageOfItemWithLink(String productPageLink) throws InterruptedException {
        webDriverHandler.navigateTo(productPageLink);
        Thread.sleep(3000);
        try {
            browser.eshopWebsite.home.clickOnCloseCookiesLayoutButton();
        } catch (TimeoutException e) {
            System.out.println("Close cookies button not found, continuing with execution.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        browser.eshopWebsite.productDetails = new ProductDetails();
    }

    @Then("trade in section should be displayed in product details page")
    public void tradeInSectionShouldBeDisplayedInProductDetailsPage() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getTradeInSection().isDisplayed());
    }

    @Then("click on trade in button in product details page")
    public void clickOnTradeInButtonInProductDetailsPage() {
        browser.eshopWebsite.productDetails.clickOnTradeInButton();
    }

    @When("click on notify me button in product details page")
    public void clickOnNotifyMeButtonInProductDetailsPage() {
        browser.eshopWebsite.productDetails.clickOnNotifyMeButton();
    }

    @When("click on notify me button in product details page for guest user")
    public void clickOnNotifyMeButtonInProductDetailsPageForGuestUser() {
        browser.eshopWebsite.productDetails.clickOnNotifyMeButtonForGuestUser();
    }

    @Then("notify me popup should appear in product details page")
    public void notifyMePopupShouldAppearInProductDetailsPage() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getNotifyMePopup().isDisplayed());
    }

    @When("click on confirm button in notify me popup in product details page")
    public void clickOnConfirmButtonInNotifyMePopupInProductDetailsPage() {
        browser.eshopWebsite.productDetails.clickOnConfirmButtonInNotifyMeButton();
    }

    @Then("notify me button should be disabled in product details page")
    public void notifyMeButtonShouldBeDisabledInProductDetailsPage() {
        Assert.assertFalse(browser.eshopWebsite.productDetails.getNotifyMeButton().isEnabled());
    }

    @Then("notify me button text should appear as {string} in product details page")
    public void notifyMeButtonTextShouldAppearAsInProductDetailsPage(String notifiedText) {
        Assert.assertEquals(browser.eshopWebsite.productDetails.getNotifyMeButton().getText(), notifiedText);
    }

    @When("get product title in product details page")
    public void getProductTitleInProductDetailsPage() {
        ProductTitleInProductDetailsPage = browser.eshopWebsite.productDetails.getProductTitle().getText();
    }

    @When("scroll down to recommended for you section in product details page")
    public void scrollDownToRecommendedForYouSectionInProductDetailsPage() throws InterruptedException {
        Thread.sleep(1500);
        browser.eshopWebsite.productDetails.scrollToRecommendedForYouSection();
    }

    @Then("recommended for you section in product details page should be displayed")
    public void recommendedForYouSectionInProductDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.productDetails.getRecommendedForYouSection().isDisplayed());
    }

    @Then("recommended for you section in product details page should have less than 50 sku")
    public void recommendedForYouSectionInProductDetailsPageShouldHaveLessThan50Sku() {

        int actualSkuCount = browser.eshopWebsite.productDetails.getRecommendedForYouSkuCount();

        Assert.assertTrue(actualSkuCount < 50, "recommended for you section has " + actualSkuCount + " SKUs, expected less than 50");
    }


    @When("select payment partner card {string} in product details page")
    public void selectPaymentPartnerCardInProductDetailsPage(String partnerName) {
        browser.eshopWebsite.productDetails.selectPaymentPartner(partnerName);
    }

    @When("click on learn more button in product details page")
    public void clickOnLearnMoreButtonInProductDetailsPage() {
        browser.eshopWebsite.paymentDetails = browser.eshopWebsite.productDetails.clickOnLearnMoreButton();
    }
}
