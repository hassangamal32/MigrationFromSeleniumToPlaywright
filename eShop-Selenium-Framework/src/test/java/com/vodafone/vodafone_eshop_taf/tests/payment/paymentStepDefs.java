package com.vodafone.vodafone_eshop_taf.tests.payment;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class paymentStepDefs extends BaseTest {

    @When("select payment method {string} in payment page")
    public void selectPaymentMethodInPaymentPage(String paymentMethodName) {
        browser.eshopWebsite.payment.selectPaymentMethod(paymentMethodName);
    }

    @When("click on place order button in payment page")
    public void clickOnPlaceOrderButtonInPaymentPage() {
        browser.eshopWebsite.orderConfirmation = browser.eshopWebsite.payment.clickOnPlaceOrderButton();
        browser.eshopWebsite.orderConfirmation.waitForUrlContains("/checkout/order-summary");
    }



}
