package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class OrderDetails extends PageBase {

    private final By orderId = By.xpath("(//p[@class='id'])");
    private final By orderDate = By.xpath("(//div[@class='date']//span)");
    private final By orderEstimatedDelivery = By.xpath("(//div[@class='status ng-star-inserted']//p)");
    private final By firstItemName = By.xpath("((//div[@class='order-items'])//p[contains(@class,'name')])[1]");
    private final By firstItemPrice = By.xpath("((//div[@class='order-items'])//p[contains(@class,'price')])[1]");
    private final By cancelOrderButton = By.xpath("//button[contains(@class,'btn cancel')]");
    private final By yesButtonForCancel = By.id("sl-confirm-button");
    private final By totalPrice = By.xpath("//p[@class='amount']");
    private final By smartTechTag = By.xpath("//div[contains(@class,'retail')]//p");

    public WebElement getOrderId() {
        return safeFindElement(orderId);
    }

    public WebElement getOrderDate() {
        return safeFindElement(orderDate);
    }

    public WebElement getOrderEstimatedDelivery() {
        return safeFindElement(orderEstimatedDelivery);
    }

    public WebElement getFirstItemName() {
        return safeFindElement(firstItemName);
    }

    public WebElement getFirstItemPrice() {
        return safeFindElement(firstItemPrice);
    }

    public WebElement getCancelOrderButton() {
        return safeFindElement(cancelOrderButton);
    }

    public void clickOnCancelOrderButton() {
        safeClick(cancelOrderButton);
    }


    public MyOrders clickOnYesButtonForCancel() {
        safeClick(yesButtonForCancel);
        return new MyOrders();
    }


    public WebElement getTotalPrice() {
        return safeFindElement(totalPrice);
    }

    public WebElement getSmartTechTag() {
        return safeFindElement(smartTechTag);
    }



}