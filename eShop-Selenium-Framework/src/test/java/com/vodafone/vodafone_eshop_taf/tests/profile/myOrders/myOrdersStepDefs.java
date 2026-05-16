package com.vodafone.vodafone_eshop_taf.tests.profile.myOrders;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import com.vodafone.vodafone_eshop_taf.utilities.DeliveryDateUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class myOrdersStepDefs extends BaseTest {

    @Then("order status on new orders tab in my orders page should be{string}")
    public void orderStatusOnNewOrdersTabInMyOrdersPageShouldBe(String noordertext) {
        Assert.assertEquals(browser.eshopWebsite.myOrders.getNoOrderTitle().getText(),noordertext);
    }

    @When("click on my orders from dropdown menu on header")
    public void clickOnMyOrdersFromDropDownMenu() {
        browser.eshopWebsite.myOrders=browser.eshopWebsite.header.clickOnMyOrdersOption();
    }

    @When("click on order history tab in my orders page")
    public void clickOnOrderHistoryTab() throws InterruptedException {
        browser.eshopWebsite.myOrders.clickOnOrderHistoryTab();
    }

    @Then("order status on order history tab in my orders page should be{string}")
    public void orderStatusOnOrderHistoryTabInMyOrdersPageShouldBe(String noOrderText) {
        Assert.assertEquals(browser.eshopWebsite.myOrders.getNoOrderTitle().getText(),noOrderText);
    }

    @Then("success message popup in my orders page should be{string}")
    public void successMessagePopupInMyOrdersPageShouldBe(String successText) {
          Assert.assertEquals(browser.eshopWebsite.myOrders.getSuccessMessageText().getText(), successText);
    }

    @When("click on buy again button for product on order history tab in my orders page")
    public void clickOnBuyAgainButtonOnOrderHistoryTab() {
        browser.eshopWebsite.myOrders.clickOnBuyAgainButton();
    }

    @Then("search for order by order id {string} in my orders page")
    public void searchForOrderByOrderIdInMyOrdersPage(String orderId) throws InterruptedException {
        Thread.sleep(8000);
        browser.eshopWebsite.myOrders.searchForOrder(orderId);
    }

    @Then("order id should be {string} in my orders page")
    public void orderIdShouldBeInMyOrdersPage(String orderId) {
        System.out.println(browser.eshopWebsite.myOrders.getOrderId().getText());
        Assert.assertTrue(browser.eshopWebsite.myOrders.getOrderId().getText().contains(orderId));
    }

    @Then("order date should be {string} in my orders page")
    public void orderDateShouldBeInMyOrdersPage(String orderDate) {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getOrderDate().getText().contains(orderDate));
    }

    @Then("order estimated delivery time should be {string} in my orders page")
    public void orderEstimatedDeliveryTimeShouldBeInMyOrdersPage(String estimatedDelivery) {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getOrderEstimatedDelivery().getText().contains(estimatedDelivery));
    }

    @Then("order address should be in city {string} in my orders page")
    public void orderAddressShouldBeInCityInMyOrdersPage(String orderCity) {
        String orderAddress = browser.eshopWebsite.myOrders.getOrderAddress().getText();
        String lastWord = orderAddress.substring(orderAddress.lastIndexOf(",") + 1).trim();
        Assert.assertEquals(lastWord, orderCity);
    }

    @Then("order status should be {string} in my orders page")
    public void orderStatusShouldBeInMyOrdersPage(String orderStatus) {
        Assert.assertEquals(browser.eshopWebsite.myOrders.getOrderStatus().getText(),orderStatus);
    }

    @Then("number of items in order should be {string} in my orders page")
    public void numberOfItemsInOrderShouldBeInMyOrdersPage(String numberOfItems) {
        String numberOfItemsText=browser.eshopWebsite.myOrders.getNumberOfItems().getText();
        String number = numberOfItemsText.replaceAll("[^0-9]", ""); // keeps only digits
        Assert.assertEquals(number, numberOfItems);
    }

    @Then("first item name in order summary should be {string} in my orders page")
    public void firstItemNameInOrderSummaryShouldBeInMyOrdersPage(String firstItemName) {
        Assert.assertEquals(browser.eshopWebsite.myOrders.getFirstItemName().getText(),firstItemName);
    }

    @Then("first item price in order summary should be {string} in my orders page")
    public void firstItemPriceInOrderSummaryShouldBeInMyOrdersPage(String firstItemPrice) {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getFirstItemPrice().getText().contains(firstItemPrice));
    }

    @When("click on order details page link in my orders page")
    public void clickOnOrderDetailsPageLinkInMyOrdersPage() {
        browser.eshopWebsite.orderDetails = browser.eshopWebsite.myOrders.clickOnOrderDetailsButton();
    }

    @When("click on cancel order button for latest order in my orders page")
    public void clickOnCancelOrderButtonForLatestOrderInMyOrdersPage() {
        browser.eshopWebsite.myOrders.clickOnCancelOrderButton();
    }

    @When("click on yes button for order cancel in my orders page")
    public void clickOnYesButtonForOrderCancelInMyOrdersPage() {
        browser.eshopWebsite.header=browser.eshopWebsite.myOrders.clickOnYesButtonForCancel();
    }

    @Then("order should has the tag {string} in my orders page")
    public void orderShouldHasTheTagInMyOrdersPage(String tagName) {
        Assert.assertEquals(browser.eshopWebsite.myOrders.getSmartTechTag().getText(),tagName);
    }

    @Then("order date should be current time in my orders page")
    public void orderDateShouldBeCurrentTimeInMyOrdersPage() {
        String orderDateText = browser.eshopWebsite.myOrders.getOrderDate().getText();
        System.out.println(orderDateText);
        Assert.assertTrue(DeliveryDateUtils.isNowWithinRange(orderDateText, 2));
    }

    @Then("order estimated delivery time should be the range for city {string} in my orders page")
    public void orderEstimatedDeliveryTimeShouldBeTheRangeForCityInMyOrdersPage(String city) {
        String actualDeliveryDate = browser.eshopWebsite.myOrders.getOrderEstimatedDelivery().getText();
        DeliveryDateUtils.DateRange expected = DeliveryDateUtils.calculateExpectedRange(city);
        DeliveryDateUtils.DateRange actual = DeliveryDateUtils.parseFromUI(actualDeliveryDate);
        System.out.println(expected);
        System.out.println(actual);
        Assert.assertTrue(DeliveryDateUtils.validateExact(expected, actual));
    }


    @Then("order should has the label {string} instead of item price in my orders page")
    public void orderShouldHasTheLabelInsteadOfItemPriceInMyOrdersPage(String label) {
        Assert.assertEquals(browser.eshopWebsite.myOrders.getSmartTechLabel().getText(),label);
    }


    @Then("order address should be {string} in my orders page")
    public void orderAddressShouldBeInMyOrdersPage(String orderAddress) {
        Assert.assertEquals(browser.eshopWebsite.myOrders.getOrderAddress().getText(),orderAddress);
    }

    @Then("edit address button should be displayed in my orders page")
    public void editAddressButtonShouldBeDisplayedInMyOrdersPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getEditAddressButton().isDisplayed());
    }

    @Then("track order button should be displayed in my orders page")
    public void trackOrderButtonShouldBeDisplayedInMyOrdersPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getTrackOrderButton().isDisplayed());
    }

    @Then("cancel order button should be displayed in my orders page")
    public void cancelOrderButtonShouldBeDisplayedInMyOrdersPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getCancelOrderButton().isDisplayed());
    }

    @When("click on edit address button in my orders page")
    public void clickOnEditAddressButtonInMyOrdersPage() {
        browser.eshopWebsite.myOrders.clickOnEditAddressButton();
    }

    @When("click on edit address button in edit address window in my orders page")
    public void clickOnEditAddressButtonInEditAddressWindowInMyOrdersPage() {
        browser.eshopWebsite.myOrders.clickOnEditAddressButtonInEditAddressWindow();
    }

    @Then("city field should be dimmed in edit address window in my orders page.")
    public void cityFieldShouldBeDimmedInEditAddressWindowInMyOrdersPage() {
        Assert.assertFalse(browser.eshopWebsite.myOrders.getCityNameField().isEnabled());
    }

    @Then("district field should be editable in edit address window in my orders page")
    public void districtFieldShouldBeEditableInEditAddressWindowInMyOrdersPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getDistrictNameField().isEnabled());
    }

    @Then("street name field should be editable in edit address window in my orders page")
    public void streetNameFieldShouldBeEditableInEditAddressWindowInMyOrdersPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getStreetNameField().isEnabled());
    }

    @Then("building no field should be editable in edit address window in my orders page")
    public void buildingNoFieldShouldBeEditableInEditAddressWindowInMyOrdersPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getBuildingNumberField().isEnabled());
    }

    @Then("floor no field should be editable in edit address window in my orders page")
    public void floorNoFieldShouldBeEditableInEditAddressWindowInMyOrdersPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getFloorNumberField().isEnabled());

    }

    @Then("apartment no field should be editable in edit address window in my orders page")
    public void apartmentNoFieldShouldBeEditableInEditAddressWindowInMyOrdersPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getApartmentNumberField().isEnabled());

    }

    @When("change address district to {string} in edit address window in my orders page")
    public void changeAddressDistrictToInEditAddressWindowInMyOrdersPage(String newDistrict)  {
        browser.eshopWebsite.myOrders.setDistrictName(newDistrict);
    }

    @When("click on confirm button in edit address window in my orders page")
    public void clickOnConfirmButtonInEditAddressWindowInMyOrdersPage() {
        browser.eshopWebsite.myOrders.clickOnConfirmButtonForEditAddress();
    }

    @When("click on done popup in success window in my orders page")
    public void clickOnDonePopupInSuccessWindowInMyOrdersPage() {
        browser.eshopWebsite.myOrders.clickOnDoneButtonAfterEditAddress();
    }

    @Then("order estimated delivery time should be replaced with cancellation time")
    public void orderEstimatedDeliveryTimeShouldBeReplacedWithCancellationTime() {
        String cancelledText = browser.eshopWebsite.myOrders.getOrderEstimatedDelivery().getText();
        Assert.assertTrue(DeliveryDateUtils.isCancelledTimeValid(cancelledText, 2));
    }



}
