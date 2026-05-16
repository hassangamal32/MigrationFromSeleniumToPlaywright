package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderConfirmation extends PageBase {

    private By orderConfirmationHeaders =  By.xpath("//section[contains(@id,'sl-sku-bars-section-a')]//h3[normalize-space()='headerTitle']");
    private By orderId = By.xpath("//div[contains(@class,'order-number')]");
    private By estimatedDeliveryTime = By.xpath("//div[contains(@class,'estimated-value')]//span");

    public WebElement getOrderConfirmationHeader (String headerTitle){
        orderConfirmationHeaders = By.xpath("//section[contains(@id,'sl-sku-bars-section-a')]//h3[normalize-space()='"+headerTitle+"']");;
        scrollDownUntilHeaderVisible(orderConfirmationHeaders, 10);
        return safeFindElement(orderConfirmationHeaders);
    }

    public String getOrderNumberText(){
        return safeFindElement(orderId).getText();
    }

    public String getEstimatedDeliveryTime(){
        return safeFindElement(estimatedDeliveryTime).getText();
    }
}
