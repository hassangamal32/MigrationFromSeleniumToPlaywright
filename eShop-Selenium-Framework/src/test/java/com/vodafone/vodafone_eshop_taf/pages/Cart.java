package com.vodafone.vodafone_eshop_taf.pages;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class Cart extends PageBase {

    private final By orderSummaryText = By.xpath("(//vf-my-cart[@class='ng-star-inserted']//h3)[1]");

    private final By cartSummaryText = By.xpath("(//vf-my-cart[@class='ng-star-inserted']//h3)[2]");

    private final By increaseProductCountIcon = By.xpath("//div[@class='counter']//input[3]");

    private final By familyMemberSimNumber = By.xpath("//p[@class='dependent-item-msisdn']");

    private final By maximumAllowedQuantity = By.xpath("//p[@class='note-text fontReg']");

    private final By deleteProductIcon = By.xpath("//div[@class='cart-actions']/p");

    private final By goToCheckoutButton = By.xpath("//button[@class='checkout-btn']");

    private final By continueShoppingButton = By.xpath("//button[@class='shopping-btn']");

    private final By firstItemInShoppingCart = By.xpath("(//div[@class='cartCard-image'])[1]");

    private final By secondItemInShoppingCart = By.xpath("(//div[@class='cartCard-image'])[2]");

    private final By firstFamilyMemberSimNumberText = By.xpath("(//p[@class='marg0 fontLightEnAr'])[2]");

    private final By firstFamilyMemberPriceText = By.xpath("//div[@class='item-card']/p[@class='price']");

    private final By secondFamilyMemberSimNumberText = By.xpath("(//p[@class='marg0 fontLightEnAr'])[3]");

    private final By thirdFamilyMemberSimNumberText = By.xpath("(//p[@class='marg0 fontLightEnAr'])[4]");

    private final By promoCodeTextField = By.xpath("//div[@class='input']//input");

    private final By applyButton = By.xpath("//span[contains(text(),'Apply') or contains(text(),'تطبيق')]");

    private final By promoCodeButton = By.xpath("//vf-promocodes//button");

    private final By invalidPromoCodeErrorMessage = By.xpath("//p[contains(@class,'error')]");
    private final By validPromoCodeMessage = By.xpath("//span[contains(@class,'success')]/parent::span");
    private final By productName = By.xpath("//p[@class='cartProduct-name']");

    private final By firstProductPrice = By.xpath("(//h5[@class='cartProduct-price'])[1]");

    private final By secondProductPrice = By.xpath("(//h5[@class='cartProduct-price'])[2]");
    private final By extraDiscountValue = By.xpath("//p[contains(@class,'cost')]/child::span");
    private final By totalCostBeforeDiscount = By.xpath("//div[contains(@class,'value')][1]");
    private final By totalOrderCost = By.xpath("//div[@class='value'][2]");

    private final By chosenLine = By.xpath("//p[@class='main-sim-msisdn']");

    private final By chosenLinePriceInCart = By.xpath("//p[@class='cartProduct-price']");

    private final By chosenLinePriceWithFamilyMembers = By.xpath("(//div[@class='vat']/p[@class='cost'])[1]");

    private final By totalPriceText = By.xpath("(//p[@class='fontRegBold marg0'])[2]");

    private final By payLaterPriceText = By.xpath("(//p[@class='fontRegBold marg0'])[1]");

    private final By ProductTitle = By.xpath("/html/body/vf-root/main/section[2]/vf-my-cart/div/div/div/div[1]/div/div/div[2]/p");

    private final By productQuantityInCartPage =By.className("counter-container");

    private final By cartIconIncreasedByOne = By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/div[4]/vf-cart/div/button/span");

    private final By homeWirelessPlusName= By.xpath("/html/body/vf-root/main/section[2]/vf-my-cart/div/div/div/div[1]/div[1]/vf-lines-cart/div[2]/div/div[2]/div[1]/p");
    private final By cartCounter=By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/div[4]/vf-cart/div/button/span");
    private final By emptyCartText=By.xpath("//h1[@class='empty-cart-label']");
    private final By continueShoppingBtn=By.xpath("//a[contains(@class, 'empty-cart-button')]");
    private final By productNameInCartPage = By.xpath("//p[@class='cartProduct-name']");
    private final By redPointSection = By.xpath("//vf-redpoints[@class='ng-star-inserted']");
    private final By redPointDropDownButton = By.xpath("//vf-redpoints[@class='ng-star-inserted']//img[@class='arrow']");
    private final By redPointRedemptionField = By.xpath("//vf-redpoints[@class='ng-star-inserted']//input");
    private final By redPointApplyButton = By.xpath("//vf-redpoints//div[@class='input']//button");
    private final By redPointSuccessMessage = By.xpath("(//div[contains(@class,'red-points')])[3]");
    private final By deleteRedemptionRedPointsButton = By.xpath("//div[@class='sub-total']//button");
    private final By numberOfAddedItemsInCartIcon = By.xpath("(//div[contains(@class,'cart-icon')]//button//span)[1]");
    private final By startShopping = By.xpath("//a[contains(@class,'empty-cart-button')]");
    private final By cartItemRow = By.cssSelector(".cart-items");
    private final By startShoppingButton= By.xpath("//vf-my-cart[@class='ng-star-inserted']//div[@class='empty-cart']//a");
    private final By subtotalSectionInCartPage = By.xpath("//div[@class='sub-total-content-data']");
    private final By itemsFieldInSubtotalSection = By.xpath("(//div[@class='sub-total-content-data']//span)[2]");
    private final By totalPriceInCartPage = By.xpath("(//div[@class='data-block-content']//div[@class='value']//span)[1]");
    private final By redInstallmentSection = By.xpath("//vf-red-installment[@class='ng-star-inserted']//button");

//    private By cartHeaders = By.id("headerTitle");
    private By cartHeaders = By.xpath("//section[contains(@id,'sl-sku-bars-section-a')]//h3[normalize-space()='headerTitle']");

    public WebElement getCartHeader (String headerTitle){
        cartHeaders = By.xpath("//section[contains(@id,'sl-sku-bars-section-a')]//h3[normalize-space()='"+headerTitle+"']");
        scrollDownUntilHeaderVisible(cartHeaders, 10);
        return safeFindElement(cartHeaders);
    }

    public WebElement getSubtotalSectionInCartPage() throws InterruptedException {
        return safeFindElement(subtotalSectionInCartPage);
    }

    public WebElement getRedInstallmentSection() {
        return safeFindElement(redInstallmentSection);
    }

    public WebElement getNumberOfAddedItemsInCartIcon() throws InterruptedException {
        return safeFindElement(numberOfAddedItemsInCartIcon);
    }

    public WebElement getItemsFieldInSubtotalSection() throws InterruptedException {
        return safeFindElement(itemsFieldInSubtotalSection);
    }

    public WebElement getTotalPriceInCartPage() throws InterruptedException {
        return safeFindElement(totalPriceInCartPage);
    }

    public WebElement getRedPointSection() {
        return safeFindElement(redPointSection);
    }

    public void clickOnRedPointDropDownButton() {
        JavascriptExecutorClick(safeFindElement(redPointDropDownButton));
    }

    public String enterAmountInRedPointsSection(String amount) {
        sendText(redPointRedemptionField, amount);
        return amount;
    }

    public void clickOnRedPointApplyButton() {
        JavascriptExecutorClick(safeFindElement(redPointApplyButton));
    }

    public WebElement getRedPointSuccessMessage() {
        return safeFindElement(redPointSuccessMessage);
    }

    public void clickOnDeleteRedemptionRedPointsButton() {
        JavascriptExecutorClick(safeFindElement(deleteRedemptionRedPointsButton));
    }

    public void clickOnStartShoppingButton() {
        JavascriptExecutorClick(safeFindElement(startShoppingButton));
    }

    public WebElement getOrderSummaryText() {
        return safeFindElement(orderSummaryText);
    }

    public WebElement getCartSummaryText() {
        return safeFindElement(cartSummaryText);
    }

    public WebElement getFirstItemInShoppingCart() {
        return safeFindElement(firstItemInShoppingCart);
    }

    public WebElement getSecondItemInShoppingCart() {
        return safeFindElement(secondItemInShoppingCart);
    }

    public WebElement getMaximumAllowedQuantity() throws InterruptedException {
        return safeFindElement(maximumAllowedQuantity);
    }

    public WebElement getIncreaseProductCountIcon() throws InterruptedException {
        return safeFindElement(increaseProductCountIcon);
    }

    // to be revamped
    public List<WebElement> getDeleteProductIcon() {
        waitForVisibleIfPresent(deleteProductIcon, 10);
        return driver.findElements(deleteProductIcon);
    }

    public WebElement getFirstFamilyMemberSimNumberText() {
        return safeFindElement(firstFamilyMemberSimNumberText);
    }

    public WebElement getSecondFamilyMemberSimNumberText() {
        return safeFindElement(secondFamilyMemberSimNumberText);
    }

    public WebElement getThirdFamilyMemberSimNumberText() {
        return safeFindElement(thirdFamilyMemberSimNumberText);
    }

    public WebElement getInvalidPromoCodeErrorMessage() {
        return safeFindElement(invalidPromoCodeErrorMessage);
    }

    public WebElement getValidPromoCodeMessage(){
        return safeFindElement(validPromoCodeMessage);
    }
    public WebElement getProductName() throws InterruptedException {
        return safeFindElement(productName);
    }

    public WebElement getFirstProductPrice() {
        return safeFindElement(firstProductPrice);
    }

    public WebElement getSecondProductPrice() {
        return safeFindElement(secondProductPrice);
    }
    public WebElement getExtraDiscountValue(){return safeFindElement(extraDiscountValue);}
    public WebElement getTotalCostBeforeDiscount(){return safeFindElement(totalCostBeforeDiscount);}
    public WebElement getTotalOrderCost() {
        return safeFindElement(totalOrderCost);
    }

    public float getExtraDiscountValueFloat(){
        return Float.parseFloat(extractNumericValueFromText(getExtraDiscountValue()));
    }

    public float getTotalCostBeforeDiscountFloat(){
        return Float.parseFloat(extractNumericValueFromText(getTotalCostBeforeDiscount()));
    }

    public int getExtraDiscountValueInt(){
        return Integer.parseInt(splitAmountOfElementText(getExtraDiscountValue()));
    }

    public int getTotalOrderCostPrice() {
        return  Integer.parseInt(splitAmountOfElementText(getTotalOrderCost()));
    }

    public int getSumOfOrderItemsCostPrice() {
        int firstItemPrice = Integer.parseInt(splitAmountOfElementText(getFirstProductPrice()));
        int secondItemPrice = Integer.parseInt(splitAmountOfElementText(getSecondProductPrice()));
        return  firstItemPrice + secondItemPrice;
    }

    public WebElement getChosenLinePriceInCart() {
        return safeFindElement(chosenLinePriceInCart);
    }

    public WebElement getChosenLine() {
        return safeFindElement(chosenLine);
    }

    public WebElement getFirstFamilyMemberPriceText() {
        return safeFindElement(firstFamilyMemberPriceText);
    }

    public String getFirstFamilyMemberMsisdn() {
        return safeFindElement(familyMemberSimNumber).getText();
    }

    public WebElement getChosenLinePriceWithFamilyMembers() throws InterruptedException {
        return safeFindElement(chosenLinePriceWithFamilyMembers);
    }

    public WebElement getTotalPriceText() {
        return safeFindElement(totalPriceText);
    }

    public WebElement getPayLaterPriceText() {
        return safeFindElement(payLaterPriceText);
    }

    public WebElement getContinueShoppingButton() {
        return safeFindElement(continueShoppingButton);
    }

    public WebElement getGoToCheckoutButton() throws InterruptedException {
        return safeFindElement(goToCheckoutButton);
    }

    public WebElement getProductTitle() throws InterruptedException {
        return safeFindElement(ProductTitle);
    }

    public WebElement getProductQuantityInCartPage() {
        return safeFindElement(productQuantityInCartPage);
    }

    public WebElement cartIconIncreasedByOne() {
        return safeFindElement(cartIconIncreasedByOne);
    }

    public WebElement gethomeWirelessPlusName() {
        return safeFindElement(homeWirelessPlusName);
    }

    public WebElement getCartCounter() {
        return safeFindElement(cartCounter);
    }

    public void clickOnContinueShoppingButton() {
        safeClick(continueShoppingButton);
    }

    public Checkout clickOnProceedToCheckoutButton() {
        safeClick(goToCheckoutButton);
        return new Checkout();
    }

    public void clickOnIncreaseProductCountIcon() {
        safeClick(increaseProductCountIcon);
    }

    public void enterPromoCodeInPromoCodeTextField(String promoCode) {
        sendText(promoCodeTextField,promoCode);
    }
    public WebElement getPromoCodeTextField(){
        return safeFindElement(promoCodeTextField);
    }

    public void clickOnApplyButton() {
        safeClick(applyButton);
    }

    public void clickOnPromoCodeButton() {
        safeClick(promoCodeButton);
    }

    public Home clickOnStartShopping() {
        safeClick(startShopping);
        return new Home();
    }

    public Home clickOnDeleteProductIcon() throws InterruptedException {
        List<WebElement> deleteIcons = getDeleteProductIcon();

        // CASE 1: Cart already empty → Continue Shopping
        if (deleteIcons.isEmpty()) {
            clickOnStartShopping();
            return new Home();
        }

        // CASE 2: Delete all items
        while (!deleteIcons.isEmpty()) {
            WebElement deleteIcon = deleteIcons.get(0);

            // JS click to avoid overlay / intercept issues
            Thread.sleep(3000);
            JavascriptExecutorClick(deleteIcon);

            // Wait until item is removed from DOM
            try {
                wait.until(ExpectedConditions.stalenessOf(deleteIcon));
            } catch (TimeoutException e) {
                // Break safely if DOM doesn't refresh
                break;
            }

            // Refresh list after DOM update
            deleteIcons = getDeleteProductIcon();
        }

        // AFTER deleting all items → Continue Shopping
        clickOnStartShopping();

        return new Home();
    }

    public void clickOnRemoveItemByName(String itemName) throws InterruptedException {
        List<WebElement> items = safeFindElements(productNameInCartPage);
        List<WebElement> removeButtons = safeFindElements(deleteProductIcon);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().trim().equalsIgnoreCase(itemName.trim())) {
                Thread.sleep(3000);
                JavascriptExecutorClick(removeButtons.get(i));
                Thread.sleep(2000); // Wait for the insurance to be removed
                break;
            }
        }
    }

    public void clickOnRemoveInsuranceOfItemByName(String itemName) throws InterruptedException {
        List<WebElement> items = safeFindElements(productNameInCartPage);
        List<WebElement> removeButtons = safeFindElements(deleteProductIcon);

        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).getText().trim().equalsIgnoreCase(itemName.trim())) {
                JavascriptExecutorClick(removeButtons.get(i + 1));
                Thread.sleep(2000);
                break;
            }
        }
    }

    public void clickOnContinueShoppingBtn() {
        safeFindElement(continueShoppingBtn).click();
    }

    public WebElement getEmptyCartText() throws InterruptedException {
        Thread.sleep(3000);
        return safeFindElement(emptyCartText);
    }

    public String getInsuranceTypeOfItemByName(String itemName) {
        List<WebElement> items = safeFindElements(productNameInCartPage);
        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            if (item.getText().trim().equalsIgnoreCase(itemName.trim())) {
                // Check next item in the list
                if (i + 1 < items.size()) {
                    WebElement nextItem = items.get(i + 1);
                    String nextText = nextItem.getText().trim().toLowerCase();
                    if (nextText.contains("insurance")) {
                        return nextItem.getText().trim();
                    }
                }
                return null; // No insurance for this item
            }
        }
        return null;
    }

    public void waitRedirectionToCartPage(String cartURL){
        waitForUrlContains(cartURL);
    }
}


