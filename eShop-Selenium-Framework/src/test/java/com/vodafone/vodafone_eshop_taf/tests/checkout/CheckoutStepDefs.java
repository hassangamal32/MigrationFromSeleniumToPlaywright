package com.vodafone.vodafone_eshop_taf.tests.checkout;


import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutStepDefs extends BaseTest {
    private String paymentMethodsTabSubURL = "/payment-methods";
    private String checkoutTabSubURL = "/shipping";

    @Then("checkout stepper in checkout page should be displayed")
    public void checkoutStepperInCheckoutPageShouldAppear() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.checkout.getCheckoutStepper().isDisplayed());
    }

    @Then("cart section in checkout page should be displayed")
    public void cartSectionInCheckoutPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.checkout.getCartSection().isDisplayed());
    }

    @Then("order summary section in checkout page should be displayed")
    public void orderSummarySectionInCheckoutPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.checkout.getOrderSummarySection().isDisplayed());
    }

    @Then("price in cart section should be equal to price in order summary section")
    public void cartTotalPriceShouldBeEqualToTheProductPrice() throws InterruptedException {
        Assert.assertEquals(
                browser.eshopWebsite.checkout.getTotalCartPriceInCartSectionText(),
                browser.eshopWebsite.checkout.getTotalCartPriceInOrderSummarySectionText()
        );
    }

    @Then("shipping fees value in in checkout page should be {string}")
    public void shippingFeesValueInCheckoutPageShouldBe(String shippingFeesValue) throws InterruptedException {
        Assert.assertEquals(browser.eshopWebsite.checkout.getShippingFeesValue(), shippingFeesValue);
    }

    @Then("delivery options text in checkout page should be displayed")
    public void DeliveryOptionsTextInCheckoutPageShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.checkout.getDeliveryOptionsText().isDisplayed());
    }

    @When("choose city name with text {string} from cities dropdown list in checkout page")
    public void chooseCityNameWithTextFromCitiesDropdownListInCheckoutPage(String cityName) throws InterruptedException {
        browser.eshopWebsite.checkout.selectCityNameFromCityNameDropDownList(cityName);
    }

    @When("choose district name with text {string} from districts dropdown list in checkout page")
    public void chooseDistrictNameWithTextFromDistrictsDropdownListInCheckoutPage(String districtName) throws InterruptedException {
        browser.eshopWebsite.checkout.selectDistrictNameFromDistrictNameDropDownList(districtName);
    }


    @When("enter street name with text {string} in checkout page")
    public void enterStreetNameWithTextInCheckoutPage(String streetName) {
        browser.eshopWebsite.checkout.enterStreetNameInStreetNameTextField(streetName);
    }

    @When("enter building number with text {string} in checkout page")
    public void enterBuildingNumberWithTextInCheckoutPage(String buildingNumber) {
        browser.eshopWebsite.checkout.enterBuildingNumberInBuildingNumberTextField(buildingNumber);
    }

    @When("enter floor number with text {string} in checkout page")
    public void enterFloorNumberWithTextInCheckoutPage(String floorNumber) {
        browser.eshopWebsite.checkout.enterFloorNumberInFloorNumberTextField(floorNumber);
    }

    @When("enter flat number with text {string} in checkout page")
    public void enterFlatNumberWithTextInCheckoutPage(String flatNumber) {
        browser.eshopWebsite.checkout.enterApartmentNumberInApartmentNumberTextField(flatNumber);
    }

    @When("enter landmark with text {string} in checkout page")
    public void enterLandmarkWithTextInCheckoutPage(String landmark) {
        browser.eshopWebsite.checkout.enterLandmarkInLandmarkTextField(landmark);
    }

    @Then("user should be redirected to checkout page with link {string}")
    public void userShouldBeRedirectedToCheckoutPageWithLink(String checkoutLink) throws InterruptedException {
        browser.eshopWebsite.checkout.waitRedirectionToCheckoutPage(checkoutTabSubURL);
        Assert.assertEquals(WebDriverHandler.getWebDriver().getCurrentUrl(), checkoutLink);
    }

    @Then("user should be redirected to payment methods page with link {string}")
    public void userShouldBeRedirectedToPaymentMethodsPageWithLink(String paymentMethodsLink) throws InterruptedException {
        Thread.sleep(2000);
        browser.eshopWebsite.checkout.waitRedirectionToCheckoutPage(paymentMethodsTabSubURL);
        Assert.assertEquals(WebDriverHandler.getWebDriver().getCurrentUrl(), paymentMethodsLink);
    }

    @Then("cart text should be displayed in checkout page with text {string}")
    public void cartTextShouldBeDisplayedInCheckoutPageWithText(String cartTextInCheckoutPage) {
        Assert.assertEquals(browser.eshopWebsite.checkout.getCartTextInCheckoutPage().getText().replace("\n", " "), cartTextInCheckoutPage);
    }

    @When("click on delete button in saved address section in checkout page")
    public void clickOnDeleteButtonInSavedAddressSectionInCheckoutPage() throws InterruptedException {
        browser.eshopWebsite.checkout.clickOnDeleteAddressButtons();
    }

    @When("go to payment button in delivery option card in checkout page should be dimmed")
    public void goToPaymentButtonInDeliveryOptionCardInCheckoutPageShouldDimmed() {
        Assert.assertFalse(browser.eshopWebsite.checkout.getGoToPaymentButton().isEnabled());
    }

    @Then("order over 60k info message in checkout page should be {string}")
    public void orderOver60KInfoMessageInCheckoutPageShouldBe(String infoMessage) {
        Assert.assertEquals(browser.eshopWebsite.checkout.getOrdersOver60KText(), infoMessage);
    }


    @When("go to payment button in delivery option card in checkout page should be clickable")
    public void goToPaymentButtonInDeliveryOptionCardInCheckoutPageShouldBeClickable() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(browser.eshopWebsite.checkout.getGoToPaymentButton().isEnabled());
    }

    @When("click on go to payment button in checkout page")
    public void clickOnGoToPaymentButtonInCheckoutPage() throws InterruptedException {
        Thread.sleep(2000);
        browser.eshopWebsite.payment=browser.eshopWebsite.checkout.clickOnGoToPaymentButton();
    }

    @Then("payment options section in checkout page should be displayed")
    public void paymentOptionsSectionInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getPaymentOptionsText().isDisplayed());
    }

    @Then("paying full amount tab in checkout page should be displayed")
    public void payingFullAmountInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getPayingFullAmountTab().isDisplayed());
    }

    @Then("vodafone cash payment method in checkout page should be {string}")
    public void vodafoneCashPaymentMethodInCheckoutPageShouldBe(String vodafoneCashText) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(browser.eshopWebsite.checkout.getVodafoneCash().getText(), vodafoneCashText);
    }

    @Then("online credit card payment method in checkout page should be {string}")
    public void onlineCreditCardPaymentMethodInCheckoutPageShouldBe(String onlineCreditCardText) {
        Assert.assertEquals(browser.eshopWebsite.checkout.getOnlineCreditCard().getText(), onlineCreditCardText);
    }

    @Then("credit card on delivery payment method in checkout page should be {string}")
    public void creditCardOnDeliveryPaymentMethodInCheckoutPageShouldBe(String creditCardOnDeliveryText) {
        Assert.assertEquals(browser.eshopWebsite.checkout.getCreditCardOnDelivery().getText(), creditCardOnDeliveryText);
    }

    @Then("cash on delivery payment method in checkout page should be {string}")
    public void cashOnDeliveryPaymentMethodInCheckoutPageShouldBe(String cashOnDeliveryText) {
        Assert.assertEquals(browser.eshopWebsite.checkout.getCashOnDelivery().getText(), cashOnDeliveryText);
    }

    @Then("online credit card radio button in payment option card in checkout page should be clickable")
    public void onlineCreditCardRadioButtonInPaymentOptionCardInCheckoutPageShouldBeClickable() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getOnlineCreditCard().isEnabled());
    }

    @Then("vodafone cash radio button in payment option card in checkout page should be dimmed")
    public void vodafoneCashRadioButtonInPaymentOptionCardInCheckoutPageShouldBeDimmed() {
        Assert.assertFalse(browser.eshopWebsite.checkout.getVodafoneCash().isSelected());
    }

    @Then("cash on delivery radio button in payment option card in checkout page should be dimmed")
    public void cashOnDeliveryRadioButtonInPaymentOptionCardInCheckoutPageShouldBeDimmed() {
        Assert.assertFalse(browser.eshopWebsite.checkout.getCashOnDelivery().isSelected());
    }

    @Then("credit card on delivery radio button in payment option card in checkout page should be dimmed")
    public void creditCardOnDeliveryRadioButtonInPaymentOptionCardInCheckoutPageShouldBeDimmed() {
        Assert.assertFalse(browser.eshopWebsite.checkout.getCreditCardOnDelivery().isSelected());
    }

    @Then("installment tab in checkout page should be displayed")
    public void InstallmentTabInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getInstallmentTab().isDisplayed());
    }

    @When("click on installment tab in checkout page")
    public void clickOnInstallmentTabInCheckoutPage() {
        browser.eshopWebsite.checkout.clickOnInstallmentTab();
    }

    @Then("HSBC payment method in checkout page should be displayed")
    public void HSBCPaymentMethodInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getHSBCRadioButton().isDisplayed());
    }

    @Then("CIB payment method in checkout page should be displayed")
    public void CIBPaymentMethodInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getCibBankPaymentMethodButton().isDisplayed());
    }

    @Then("cairo bank payment method in checkout page should be displayed")
    public void cairoBankPaymentMethodInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getcairoBankPaymentMethodButton().isDisplayed());
    }

    @When("click on Buy now pay later radio button")
    public void clickOnBuyNowPayLaterRadioButton() {
        browser.eshopWebsite.checkout.clickOnBuyNowPayLaterRadioButton();
    }

    @Then("forsa payment method in checkout page should be displayed")
    public void forsaPaymentMethodInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getForsaRadioButton().isDisplayed());
    }

    @Then("souhoola payment method in checkout page should be displayed")
    public void souhoolaPaymentMethodInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getSouhoolaRadioButton().isDisplayed());
    }

    @Then("valu payment method in checkout page should be displayed")
    public void valuPaymentMethodInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getValuRadioButton().isDisplayed());
    }

    @Then("red installments payment method in checkout page should be displayed")
    public void redInstallmentsPaymentMethodInCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getRedInstallmentsRadioButton().isDisplayed());
    }

    @When("click on new Address button in checkout page")
    public void clickOnNewAddressButton() {
        browser.eshopWebsite.checkout.clickOnNewAddressButton();
    }

    @When("save address button should be clickable")
    public void saveAddressButtonShouldBeClickable() {
        Assert.assertTrue(browser.eshopWebsite.checkout.getSaveAddressButton().isDisplayed() && browser.eshopWebsite.checkout.getSaveAddressButton().isEnabled());
    }

    @Then("click on save address button")
    public void clickOnSaveAddressButton() {
        browser.eshopWebsite.checkout.clickOnSaveAddressButton();
    }

    @Then("street name in the saved addresses section in checkout page should be equal to {string}")
    public void streetNameInTheSavedAddressesSectionInCheckoutPageShouldBeEqualTo(String streetName) {
        String actual = browser.eshopWebsite.checkout.getSavedAddress().getText();
        Assert.assertTrue(actual.contains(streetName),
                "Expected address to contain: " + streetName + " but was: " + actual);
    }

    @When("click on set as default address checkbox")
    public void clickOnSetAsDefaultAddressCheckbox() {
        browser.eshopWebsite.checkout.clickOnDefaultAddressCheckbox();
    }

}
