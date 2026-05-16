package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Vouchers extends PageBase {

    private final By activeVouchersSection = By.xpath("//button[@class='active']");
    private final By usedVouchersSection = By.xpath("//button[contains(@id,'USED')]");
    private final By expiredVouchersSection = By.xpath("//button[contains(@id,'EXPIRED')]");
    private final By noVouchersAvailableMessage = By.xpath("//vf-vouchers[@class='ng-star-inserted']//p");
    private final By cartLabelField = By.cssSelector(".ticket-label p");
    private final By cartTagField = By.cssSelector(".voucher-content .tag p");
    private final By cartStatusField = By.cssSelector(".voucher-content .expire");
    private final By redeemButton = By.cssSelector(".voucher-content button");
    private final By cartTitleField = By.cssSelector(".voucher-content .title-desc h4");
    private final By voucherIndexItems = By.xpath("//vf-vouchers//div[contains(@class, 'voucher-card')]");
    private final By copyCodeButton = By.xpath("//button[contains(@class,'copy')]");



    public WebElement getActiveVouchersSection(){
        return safeFindElement(activeVouchersSection);
    }
    public void clickOnActiveVouchersSection(){
        safeClick(activeVouchersSection);
    }
    public WebElement getUsedVouchersSection(){
        return safeFindElement(usedVouchersSection);
    }
    public void clickOnUsedVouchersSection(){
        safeClick(usedVouchersSection);
    }
    public WebElement getExpiredVouchersSection(){
        return safeFindElement(expiredVouchersSection);
    }
    public void clickOnExpiredVouchersSection(){
        safeClick(expiredVouchersSection);
    }
    public WebElement getNoVouchersAvailableMessageText(){
        return safeFindElement(noVouchersAvailableMessage);
    }

    public WebElement getCartLabelField(WebElement voucherCard){
        return safeFindElement(voucherCard,cartLabelField);
    }
    public WebElement getCartTagField(WebElement voucherCard){
        return safeFindElement(voucherCard,cartTagField);
    }
    public WebElement getCartStatusField(WebElement voucherCard){
        return safeFindElement(voucherCard,cartStatusField);
    }
    public WebElement getRedeemButton() {
        return safeFindElement(redeemButton);
    }
    public WebElement getCartTitleField(WebElement voucherCard) {
        return safeFindElement(voucherCard,cartTitleField);
    }

    public WebElement getVoucherCardByIndex(int index) {
        List<WebElement> vouchers = safeFindElements(voucherIndexItems);

        if (vouchers.isEmpty()) {
            throw new AssertionError("No vouchers available on the page.");
        }
        if (index < 0 || index >= vouchers.size()) {
            throw new AssertionError("Voucher index out of range: " + index + ". Available vouchers: " + vouchers.size());
        }
        return vouchers.get(index);
    }
    public void clickOnRedeemButton(){
        safeClick(redeemButton);
    }
    public void clickOnCopyCodeButton(){
        safeClick(copyCodeButton);
    }
}
