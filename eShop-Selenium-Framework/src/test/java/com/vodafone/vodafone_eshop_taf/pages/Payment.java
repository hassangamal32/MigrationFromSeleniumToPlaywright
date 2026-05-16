package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Payment extends PageBase {

    private By paymentMethodOption = By.xpath("//p[normalize-space()='paymentMethodName']/ancestor::div[contains(@class,'method')][1]");
    private By placeOrderButton = By.xpath("(//button[contains(@class,'vf-btn-primary place-order-btn')])[2]");

    public void selectPaymentMethod(String paymentMethodName) {
        paymentMethodOption = By.xpath("//p[normalize-space()='"+paymentMethodName+"']/ancestor::div[contains(@class,'method')][1]");
        safeClick(paymentMethodOption);
    }

    public OrderConfirmation clickOnPlaceOrderButton(){
        safeClick(placeOrderButton);
        return new OrderConfirmation();
    }

}
