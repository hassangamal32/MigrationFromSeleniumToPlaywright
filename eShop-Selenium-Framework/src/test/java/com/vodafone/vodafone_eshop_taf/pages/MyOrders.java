package com.vodafone.vodafone_eshop_taf.pages;
import org.openqa.selenium.*;

import java.util.List;


public class MyOrders extends PageBase {

    private final By orderHistoryTab = By.id("sl-orders-button-1-Order History");
    private final By noOrderTitle = By.xpath("//div[contains(@class,'no-orders')]//p");
    private final By orderId = By.xpath("(//p[@class='id'])");
    private final By ordersList = By.xpath("//div[@class='order-card ng-star-inserted']");
    private final By orderAddress = By.xpath("(//div[@class='delivery-address']//span)");
    private final By orderStatus = By.xpath("(//p[@class='order-status'])");
    private final By successMessageText = By.xpath("//div[@class='alerts-mainContainer']//div//p");
    private By buyAgainButtonForFirstItem = By.xpath("((//div[@class='order-items'])[#]//button)[1]");
    private final By numberOfItems = By.xpath("(//div[@class='status-summary']//span)");
    private By firstItemName = By.xpath("((//div[@class='order-items'])[#]//p[contains(@class,'name')])[1]");
    private By firstItemPrice = By.xpath("((//div[@class='order-items'])[#]//p[contains(@class,'price')])[1]");
    private final By orderDetailsButton = By.xpath("(//a[@class='btn-header']//img)");
    private final By trackOrderButton = By.id("sl-orders-button-6-0");
    private final By cancelOrderButton = By.id("sl-orders-button-7-0");
    private final By orderDate = By.xpath("(//div[@class='date']//span)");
    private final By orderEstimatedDelivery = By.xpath("(//div[@class='status ng-star-inserted']//p)");
    private final By yesButtonForCancel = By.id("sl-confirm-button");
    private final By smartTechTag = By.xpath("//div[contains(@class,'retail')]//p");
    private final By smartTechLabel = By.xpath("(//div[contains(@class,'paid-in-store')])[1]//p");
    private final By editAddressButtonInOrderCard = By.id("sl-orders-button-3-0");
    private final By editAddressButtonInEditAddressWindow = By.xpath("//button[contains(@id,'sl-address-card-button')]");
    private final By cityNameField = By.id("sl-address-form-input-1");
    private final By districtNameField = By.id("district-select");
    private final By streetNameField = By.id("sl-address-form-input-2");
    private final By buildingNumberField = By.id("sl-address-form-input-3");
    private final By floorNumberField = By.id("sl-address-form-input-4");
    private final By apartmentNumberField = By.id("sl-address-form-input-5");
    private final By confirmButtonForEditAddress = By.xpath("(//div[@class='form-footer']//button)[1]");
    private final By doneButton = By.xpath("//button[@class='done-btn']");


    private Integer orderIndex = 0;


    public void clickOnOrderHistoryTab() {
        safeClick(orderHistoryTab);

    }

    public WebElement getSuccessMessageText() {
        return safeFindElement(successMessageText);
    }

    public WebElement getNoOrderTitle() {
        return safeFindElement(noOrderTitle);
    }

    public void clickOnBuyAgainButton() {
        buyAgainButtonForFirstItem = By.xpath("((//div[@class='order-items'])["+(orderIndex+1)+"]//button)[1]");
        safeClick(buyAgainButtonForFirstItem);
    }

    public WebElement getOrderHistoryTab() {
        return safeFindElement(orderHistoryTab);
    }

    public WebElement getOrderAddress() {
        return safeFindElements(orderAddress).get(orderIndex);
    }

    public WebElement getOrderStatus() {
        return safeFindElements(orderStatus).get(orderIndex);
    }

    public WebElement getOrderId() {
        return safeFindElements(orderId).get(orderIndex);
    }

    public WebElement getOrderDate() {
        return safeFindElements(orderDate).get(orderIndex);
    }

    public WebElement getOrderEstimatedDelivery() {
        return safeFindElements(orderEstimatedDelivery).get(orderIndex);
    }


    public void searchForOrder(String orderNumber) {
        List<WebElement> orders = safeFindElements(ordersList);
        for (int i=0; i < orders.size(); i++) {
            orderIndex = i;
            if (getOrderId().getText().contains(orderNumber))
                break;
        }
        JavascriptExecutorScroll(getOrderId());
    }

    public WebElement getNumberOfItems() {
        return safeFindElements(numberOfItems).get(orderIndex);
    }

    public WebElement getFirstItemName() {
        firstItemName = By.xpath("((//div[@class='order-items'])["+(orderIndex+1)+"]//p[contains(@class,'name')])[1]");
        return safeFindElement(firstItemName);
    }

    public WebElement getFirstItemPrice() {
        firstItemPrice = By.xpath("((//div[@class='order-items'])["+(orderIndex+1)+"]//p[contains(@class,'price')])[1]");
        return safeFindElement(firstItemPrice);
    }

    public WebElement getOrderDetailsButton() {
        WebElement webElement = safeFindElements(orderDetailsButton).get(orderIndex);
        orderIndex = 0;
        return webElement;
    }

    public OrderDetails clickOnOrderDetailsButton() {
        getOrderDetailsButton().click();
        return new OrderDetails();
    }

    public WebElement getBuyAgainButtonForFirstItem() {
        buyAgainButtonForFirstItem = By.xpath("((//div[@class='order-items'])["+(orderIndex+1)+"]//button)[1]");
        return safeFindElement(buyAgainButtonForFirstItem);
    }

    public WebElement getEditAddressButton() {
        return safeFindElement(editAddressButtonInOrderCard);
    }

    public WebElement getTrackOrderButton() {
        return safeFindElements(trackOrderButton).get(orderIndex);
    }

    public WebElement getCancelOrderButton() {
        return safeFindElements(cancelOrderButton).get(orderIndex);
    }

    public void clickOnCancelOrderButton() {
        safeClick(cancelOrderButton);
    }

    public Header clickOnYesButtonForCancel() {
        safeClick(yesButtonForCancel);
        return new Header();
    }

    public WebElement getSmartTechTag() {
        return safeFindElement(smartTechTag);
    }

    public WebElement getSmartTechLabel() {
        return safeFindElement(smartTechLabel);
    }

    public void setDistrictName(String district) {
        selectFromDropDownWithPartialText(districtNameField, district);
    }

    public void clickOnEditAddressButton() {
        safeClick(editAddressButtonInOrderCard);
    }

    public void clickOnEditAddressButtonInEditAddressWindow() {
        safeClick(editAddressButtonInEditAddressWindow);
    }

    public WebElement getCityNameField() {
        return safeFindElement(cityNameField);
    }

    public WebElement getDistrictNameField() {
        return safeFindElement(districtNameField);
    }

    public WebElement getStreetNameField() {
        return safeFindElement(streetNameField);
    }


    public WebElement getBuildingNumberField() {
        return safeFindElement(buildingNumberField);
    }

    public WebElement getFloorNumberField() {
        return safeFindElement(floorNumberField);
    }

    public WebElement getApartmentNumberField() {
        return safeFindElement(apartmentNumberField);
    }

    public void clickOnConfirmButtonForEditAddress() {
        safeClick(confirmButtonForEditAddress);
    }

    public void clickOnDoneButtonAfterEditAddress() {
        safeClick(doneButton);
    }

}