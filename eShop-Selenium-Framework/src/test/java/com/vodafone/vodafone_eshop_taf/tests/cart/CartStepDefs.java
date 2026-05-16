package com.vodafone.vodafone_eshop_taf.tests.cart;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.pages.PageBase;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartStepDefs extends BaseTest {

    private String deviceColorInProductDetailsPage;
    private String deviceCapacityInProductDetailsPage;

    @When("click on the first phone item in best selling phones in shop page")
    public void clickOnTheFirstPhoneItemInBestSellingPhonesInShopPage() {
        browser.eshopWebsite.productDetails = browser.eshopWebsite.home.clickOnBestSellingFirstItemLink();
    }

    @When("click on cart icon in the home page header")
    public void clickOnCartIconInTheHomePageHeader() throws InterruptedException {
        browser.eshopWebsite.cart=browser.eshopWebsite.home.clickOnCartIconInHomePage();
    }

    @When("click on increase the counter of item button in cart page")
    public void clickOnIncreaseTheCounterOfItemButtonInCartPage() throws InterruptedException {
        browser.eshopWebsite.cart.clickOnIncreaseProductCountIcon();
    }

    @When("click on remove item icon in cart page")
    public void clickOnRemoveItemIconInCartPage() throws InterruptedException {
        browser.eshopWebsite.cart.clickOnDeleteProductIcon();
    }

    @When("click on continue shopping button in cart page")
    public void clickOnContinueShoppingButtonInCartPage() {
        browser.eshopWebsite.cart.clickOnContinueShoppingButton();
    }

    @Then("user should be redirected to home page with link {string}")
    public void userShouldBeRedirectedToHomePageWithLink(String link){
        Assert.assertEquals(WebDriverHandler.getCurrentUrl(), link);
    }

    @When("click on checkout button in cart page")
    public void clickOnCheckoutButtonInCartPage(){
        browser.eshopWebsite.checkout = browser.eshopWebsite.cart.clickOnProceedToCheckoutButton();
    }

    @Then("user should be redirected to home page")
    public void userShouldBeRedirectedToHomePage() {
        Assert.assertTrue(browser.eshopWebsite.home.getShopByBrandHeader().isDisplayed());
    }

    @Then("first item in cart page should be displayed")
    public void firstItemInCartPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.cart.getFirstItemInShoppingCart().isDisplayed());
    }
    @Then("order summary header in cart page should be displayed")
    public void orderSummaryHeaderInCartPageShouldBeDisplayed() {
    Assert.assertTrue(browser.eshopWebsite.cart.getOrderSummaryText().isDisplayed());
    }
    @Then("cart summary header in cart page should be displayed")
    public void cartSummaryHeaderInCartPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.cart.getCartSummaryText().isDisplayed());
    }
    @Then("go to checkout button in cart summary section in cart page should be displayed")
    public void goToCheckoutButtonInCartSummarySectionInCartPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.cart.getGoToCheckoutButton().isDisplayed());
    }
    @Then("continue shopping button in cart summary section in cart page should be displayed")
    public void continueShoppingButtonInCartSummarySectionInCartPageShouldBeDisplayed()
    {
        Assert.assertTrue(browser.eshopWebsite.cart.getContinueShoppingButton().isDisplayed());
    }

    @Then("second item in cart page should be displayed")
    public void secondItemInCartPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.cart.getSecondItemInShoppingCart().isDisplayed());
    }

    @When("enter promo code with text {string} in cart page")
    public void enterPromoCodeWithTextInCartPage(String promoCode) {
        browser.eshopWebsite.cart.enterPromoCodeInPromoCodeTextField(promoCode);
    }

    @When("click on promo code button in cart page")
    public void clickOnPromoCodeButtonInCartPage() throws InterruptedException {
        Thread.sleep(3000);
        browser.eshopWebsite.cart.clickOnPromoCodeButton();
    }

    @When("click on apply button in cart page")
    public void clickOnApplyButtonInCartPage() {
        browser.eshopWebsite.cart.clickOnApplyButton();
    }


    @Then("device name in cart page should be displayed")
    public void deviceNameInCartPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue( browser.eshopWebsite.cart.getProductName().isDisplayed());
    }

    @Then("device color in shopping cart page should be the same as the device color in product details page")
    public void deviceColorInShoppingCartPageShouldBeTheSameAsTheDeviceColorInProductDetailsPage() throws InterruptedException {
        WebElement element  = browser.eshopWebsite.productDetails.getProductColorText();
        Assert.assertEquals(deviceColorInProductDetailsPage, element.getText());
    }

    @Then("total price in cart page should be equal the summation of 2 item price")
    public void totalPriceInCartPageShouldBeEqualTheSummationOf2ItemPrice() throws InterruptedException {
        Assert.assertEquals(
                browser.eshopWebsite.cart.getTotalOrderCostPrice(),
                browser.eshopWebsite.cart.getSumOfOrderItemsCostPrice()
        );
    }

    @Then("the applied discount percentage is equal {int}%")
    public void theAppliedDiscountPercentageIsEqual(int discount){
        Assert.assertEquals(
                (int) Math.ceil(
                        browser.eshopWebsite.cart.getExtraDiscountValueFloat()
                                / browser.eshopWebsite.cart.getTotalCostBeforeDiscountFloat()
                                * 100)
                        ,discount);
    }

    @Then("the applied discount value is equal {int}")
    public void theAppliedDiscountValueIsEqual(int discount){
        Assert.assertEquals(browser.eshopWebsite.cart.getExtraDiscountValueInt(),discount);
    }

    @When("click on cart icon in header")
    public void clickOnCartImageInHeader() {
        browser.eshopWebsite.cart = browser.eshopWebsite.header.clickOnShoppingCartIcon();
    }


    @When("get device color in product details page")
    public void getDeviceColorInProductDetailsPage(){
        deviceColorInProductDetailsPage = browser.eshopWebsite.productDetails.getProductColorText().getText();
    }

    @When("get device capacity in product details page")
    public void getDeviceCapacityInProductDetailsPage() {
        deviceCapacityInProductDetailsPage = browser.eshopWebsite.productDetails.getProductCapacityText();
    }

    @Then("error message in cart page should be {string}")
    public void errorMessageInCartPageShouldBe(String counter) throws InterruptedException {
        Assert.assertEquals(browser.eshopWebsite.cart.getMaximumAllowedQuantity().getText(), counter);
    }

    @Then("error message in cart page should be displayed with text {string}")
    public void errorMessageInCartPageShouldBeDisplayedWithText(String errorMessageText) {
        Assert.assertTrue(browser.eshopWebsite.cart.getInvalidPromoCodeErrorMessage().getText().contains(errorMessageText), errorMessageText);
    }

    @Then("applied message in cart page should be displayed with text {string}")
        public void appliedMessageInCartPageShouldBeDisplayedWithText(String appiledMessageText){
        Assert.assertTrue(browser.eshopWebsite.cart.getValidPromoCodeMessage().getText().contains(appiledMessageText),appiledMessageText);
        }


    @Then("number of items in cart icon in header should be {string}")
    public void numberOfItemsInCartIconInHeaderShouldBe(String itemsNumber) throws InterruptedException {
        Assert.assertEquals(browser.eshopWebsite.cart.getNumberOfAddedItemsInCartIcon().getText(), itemsNumber);
    }


    @When("cart page should be empty with message {string} in cart page")
    public void cartPageShouldBeEmptyWithMessageInCartPage(String emptyCartMessage) throws InterruptedException {
        Assert.assertEquals(browser.eshopWebsite.cart.getEmptyCartText().getText(), emptyCartMessage);
    }

    @When("click on continue shopping button in empty cart page")
    public void clickOnContinueShoppingButtonInEmptyCartPage() {
        browser.eshopWebsite.cart.clickOnContinueShoppingBtn();
    }

    @When("click on remove button for {string} item in cart page")
    public void clickOnRemoveButtonForItemInCartPage(String itemPosition) throws InterruptedException {
        browser.eshopWebsite.cart.clickOnRemoveItemByName(itemPosition);
    }

    @When("click on remove button for insurance of item {string} in cart page")
    public void clickOnRemoveButtonForInsuranceOfItemInCartPage(String insurancePosition) throws InterruptedException {
        browser.eshopWebsite.cart.clickOnRemoveInsuranceOfItemByName(insurancePosition);
    }

    @Then("check red points section is displayed in cart page")
    public void checkRedPointsSectionIsDisplayedInCartPage() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.cart.getRedPointSection().isDisplayed());
    }

    @When("click on dropdown arrow in red points section in cart page")
    public void clickOnDropdownArrowInRedPointsSectionInCartPage() {
        browser.eshopWebsite.cart.clickOnRedPointDropDownButton();
    }

    @When("enter amount {string} in egyptian pounds in red points section in cart page")
    public void enterAmountInEgyptianPoundsInRedPointsSectionInCartPage(String amount) {
        browser.eshopWebsite.cart.enterAmountInRedPointsSection(amount);
    }

    @When("click on apply button in red points section in cart page")
    public void clickOnApplyButtonInRedPointsSectionInCartPage() {
        browser.eshopWebsite.cart.clickOnRedPointApplyButton();
    }

    @Then("success message in red points section in cart page should be displayed with text {string}")
    public void successMessageInRedPointsSectionInCartPageShouldBeDisplayedWithText(String successMessage) throws InterruptedException {
        Thread.sleep(4000);
        String responseMessage = browser.eshopWebsite.cart.getRedPointSuccessMessage().getText();
        Assert.assertEquals(responseMessage, successMessage);
        Thread.sleep(3000);
    }

    @When("delete redeemed points from cart page")
    public void deleteRedeemedPointsFromCartPage() throws InterruptedException {
        browser.eshopWebsite.cart.clickOnDeleteRedemptionRedPointsButton();
        Thread.sleep(3000);
    }

    @When("click on start shopping button in empty cart page")
    public void clickOnStartShoppingButtonInEmptyCartPage() {
        browser.eshopWebsite.cart.clickOnStartShoppingButton();
    }

    @Then("check subtotal section in order summary section in cart page is displayed")
    public void checkSubtotalSectionInOrderSummarySectionInCartPageIsDisplayed() throws InterruptedException {
        browser.eshopWebsite.cart.getSubtotalSectionInCartPage().isDisplayed();
    }

    @Then("check number of items in subtotal section in order summary section in cart page is {string}")
    public void checkNumberOfItemsInSubtotalSectionInOrderSummarySectionInCartPageIs(String itemsNumber) throws InterruptedException {
        Assert.assertEquals(browser.eshopWebsite.cart.getItemsFieldInSubtotalSection().getText(), itemsNumber);
    }

    @Then("check total price in EGP in order summary section in cart page is {string}")
    public void checkTotalPriceInEGPInOrderSummarySectionInCartPageIs(String totalPrice) throws InterruptedException {
        Assert.assertEquals(browser.eshopWebsite.cart.getTotalPriceInCartPage().getText(), totalPrice);
    }

    @Then("check red installment section is displayed in cart page")
    public void checkRedInstallmentSectionIsDisplayedInCartPage() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.cart.getRedInstallmentSection().isDisplayed());
    }

    @Then("check {string} insurance is added for {string} item in cart page")
    public void checkInsuranceIsAddedForItemInCartPage(String expectedInsuranceName, String itemName) throws InterruptedException {
        Thread.sleep(3000);
        String actualInsuranceName = browser.eshopWebsite.cart.getInsuranceTypeOfItemByName(itemName);
        Assert.assertEquals(actualInsuranceName, expectedInsuranceName);
    }

    @When("paste the copied code in voucher section")
    public void pasteTheCopiedCodeInVoucherSection(){
        browser.eshopWebsite.cart.getPromoCodeTextField().sendKeys(Keys.CONTROL, "v");
    }

}
