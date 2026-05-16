package com.vodafone.vodafone_eshop_taf.tests.profile.myOrders;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import com.vodafone.vodafone_eshop_taf.utilities.DeliveryDateUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class orderDetailsStepDefs extends BaseTest {

    @Then("order id should be {string} in order details page")
    public void orderIdShouldBeInOrderDetailsPage(String orderId) {
        Assert.assertTrue(browser.eshopWebsite.orderDetails.getOrderId().getText().contains(orderId));
    }

    @Then("order date should be {string} in order details page")
    public void orderDateShouldBeInOrderDetailsPage(String orderDate) {
        Assert.assertTrue(browser.eshopWebsite.orderDetails.getOrderDate().getText().contains(orderDate));
    }

    @Then("order estimated delivery time should be {string} in order details page")
    public void orderEstimatedDeliveryTimeShouldBeInOrderDetailsPage(String estimatedDelivery) {
        Assert.assertTrue(browser.eshopWebsite.orderDetails.getOrderEstimatedDelivery().getText().contains(estimatedDelivery));
    }

    @Then("order estimated delivery time should be the range for city {string} in order details page")
    public void orderEstimatedDeliveryTimeShouldBeTheRangeForCityInOrderDetailsPage(String city) {
        String actualDeliveryDate = browser.eshopWebsite.orderDetails.getOrderEstimatedDelivery().getText();
        DeliveryDateUtils.DateRange expected = DeliveryDateUtils.calculateExpectedRange(city);
        DeliveryDateUtils.DateRange actual = DeliveryDateUtils.parseFromUI(actualDeliveryDate);
        System.out.println(expected);
        System.out.println(actual);
        Assert.assertTrue(DeliveryDateUtils.validateExact(expected, actual));
    }


    @Then("first item name in order summary should be {string} in order details page")
    public void firstItemNameInOrderSummaryShouldBeInOrderDetailsPage(String firstItemName) {
        Assert.assertEquals(browser.eshopWebsite.orderDetails.getFirstItemName().getText(),firstItemName);
    }

    @Then("first item price in order summary should be {string} in order details page")
    public void firstItemPriceInOrderSummaryShouldBeInOrderDetailsPage(String firstItemPrice) {
        Assert.assertTrue(browser.eshopWebsite.orderDetails.getFirstItemPrice().getText().contains(firstItemPrice));
    }

    @Then("order should has the tag {string} in order details page")
    public void orderShouldHasTheTagInOrderDetailsPage(String tagName) {
        Assert.assertEquals(browser.eshopWebsite.orderDetails.getSmartTechTag().getText(),tagName);
    }

    @Then("total price for order should equal {string} in order details page")
    public void totalPriceForOrderShouldEqualInOrderDetailsPage(String orderPrice) {
        Assert.assertTrue(browser.eshopWebsite.orderDetails.getTotalPrice().getText().contains(orderPrice));
    }

    @Then("cancel order button should be displayed in order details page")
    public void cancelOrderButtonShouldBeDisplayedInOrderDetailsPage() {
        browser.eshopWebsite.orderDetails.getCancelOrderButton().isDisplayed();
    }

    @When("click on cancel order button in order details page")
    public void clickOnCancelOrderButtonInOrderDetailsPage() {
        browser.eshopWebsite.orderDetails.clickOnCancelOrderButton();
    }

    @When("click on yes button for order cancel in order details page")
    public void clickOnYesButtonForOrderCancelInOrderDetailsPage() {
        browser.eshopWebsite.myOrders = browser.eshopWebsite.orderDetails.clickOnYesButtonForCancel();
    }

}
