package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Checkout extends PageBase {

    private final By checkoutStepper = By.xpath("//div[@class='stepper-container']");

    private final By cartSection = By.xpath("//div[@class='cart-items vf-grid-10']");

    private final By deliveryOptions = By.xpath("//div[@class='delivery-options-header']");

    private final By totalCartPriceInCartSection = By.xpath("//div[@class='cart-total-container']");

    private final By totalPriceInOrderSummarySection = By.xpath("//div[@class='vat']/p[@class='cost']");

    private final By orderSummarySectionText = By.cssSelector(".desktop-order-summary");

    private final By shippingFeesValue = By.xpath("//p[@class='value']");

    private final By newAddressButton = By.xpath("//div[@class='add-address']");

    private final By cityNameDropDownList = By.xpath("//select[@formcontrolname='city']");

    private final By districtNameDropDownList = By.xpath("//select[@formcontrolname='district']");

    private final By streetNameTextField = By.xpath("//input[@formcontrolname='streetName']");

    private final By buildingNumberTextField = By.xpath("//input[@formcontrolname='buildingNo']");

    private final By floorNumberTextField = By.xpath("//input[@formcontrolname='floorNo']");

    private final By apartmentNumberTextField = By.xpath("//input[@formcontrolname='appartmentNo']");

    private final By landmarkTextField = By.xpath("//input[@formcontrolname='landmark']");

    private final By saveAddressButton = By.xpath("//vf-shipping//form//button[1]");

    private final By savedAddressSection = By.xpath("//vf-shipping//div[contains(@class,'addresses-container')]/div[1]");

    private final By deleteAddressButton = By.xpath("//button[contains(@class,'delete-address')]");

    private final By yesButtonInDeletePopupmenu = By.xpath("//button[contains(@class,'vf-btn vf-btn-primary')]");

    private final By goToPaymentButton = By.id("shippingAddressContinue");

    private final By ordersOver60kerrorMessageText =By.xpath("//div[contains(@class,'payments-error-container')]//p");

    private final By setAsDefaultAddressCheckBox = By.xpath("//input[@type='checkbox']");

    private final By paymentOptionsText = By.xpath("//div[@class='payment-methods-header']/p");

    private final By payingFullAmountTab = By.xpath("//button[.//img[@alt='payingFullAmount']]");

    private final By vodafoneCash = By.xpath("(//div[contains(@class,'payment-name')])[1]");

    private final By onlineCreditCard = By.xpath( "(//div[@class='payment-name'])[2]");

    private final By creditCardOnDelivery = By.xpath("(//div[@class='payment-name'])[3]");

    private final By cashOnDelivery = By.xpath("(//div[@class='payment-name'])[4]");

    private final By installmentTab = By.xpath("(//div[@class='tabs-switcher']/button)[2]");

    private final By HSBCRadioButton = By.xpath("//div[@class='method-details'][1]");

    private final By CibBankPaymentMethodButton = By.xpath("(//div[contains(@class,'methods-data')]//div[contains(@class,'method-details')])[3]");

    private final By cairoBankPaymentMethodButton = By.xpath("(//div[contains(@class,'methods-data')]//div[contains(@class,'method-details')])[4]");

    private final By buyNowPayLaterRadioButton = By.xpath("//button[@value='partnerMethod']");

    private final By forsaRadioButton = By.xpath("(//div[contains(@class,'methods-data')]//div[contains(@class,'method-details')])[7]");

    private final By souhoolaRadioButton = By.xpath("(//div[contains(@class,'methods-data')]//div[contains(@class,'method-details')])[5]");

    private final By valuRadioButton = By.xpath("(//div[contains(@class,'methods-data')]//div[contains(@class,'method-details')])[last()]");

    private final By redInstallmentsRadioButton = By.xpath("(//div[@class='method-details'])[4]");

    private final By cartText = By.xpath("//div[@class='cart']");

    public WebElement getCheckoutStepper() throws InterruptedException {
        return safeFindElement(checkoutStepper);
    }

    public WebElement getCartSection() throws InterruptedException {
        return safeFindElement(cartSection);
    }

    public WebElement getOrderSummarySection() {
        List<WebElement> items = safeFindElements(orderSummarySectionText);
        return items.get(0);
    }

    public String getShippingFeesValue() throws InterruptedException {
        return safeFindElement(shippingFeesValue).getText();
    }

    public WebElement getTotalCartPriceInCartSection() throws InterruptedException {
        return safeFindElement(totalCartPriceInCartSection);
    }

    public int getTotalCartPriceInCartSectionText() throws InterruptedException {
        return Integer.parseInt(splitAmountOfElementText(getTotalCartPriceInCartSection()));
    }

    public WebElement getTotalCartPriceInOrderSummarySection() throws InterruptedException {
        return safeFindElement(totalPriceInOrderSummarySection);
    }
    public int getTotalCartPriceInOrderSummarySectionText() throws InterruptedException {
        return Integer.parseInt(splitAmountOfElementText(getTotalCartPriceInOrderSummarySection()));
    }

    public WebElement getDeliveryOptionsText() throws InterruptedException {
        return safeFindElement(deliveryOptions);
    }

    public WebElement getDefaultAddressCheckBox() {
        return safeFindElement(setAsDefaultAddressCheckBox);
    }

    public WebElement getPaymentOptionsText() {
        return safeFindElement(paymentOptionsText);
    }

    public WebElement getPayingFullAmountTab() {
        return safeFindElement(payingFullAmountTab);
    }

    public WebElement getVodafoneCash() {
        return safeFindElement(vodafoneCash);
    }

    public WebElement getOnlineCreditCard() {
        return safeFindElement(onlineCreditCard);
    }

    public WebElement getCreditCardOnDelivery() {
        return safeFindElement(creditCardOnDelivery);
    }

    public WebElement getCashOnDelivery() {
        return safeFindElement(cashOnDelivery);
    }

    public WebElement getInstallmentTab() {
        return safeFindElement(installmentTab);
    }

    public WebElement getHSBCRadioButton() {
        return safeFindElement(HSBCRadioButton);
    }

    public WebElement getCibBankPaymentMethodButton() {
        return safeFindElement(CibBankPaymentMethodButton);
    }

    public WebElement getcairoBankPaymentMethodButton() {
        return safeFindElement(cairoBankPaymentMethodButton);
    }

    public WebElement getBuyNowPayLaterRadioButton() {
        return safeFindElement(buyNowPayLaterRadioButton);
    }

    public WebElement getForsaRadioButton() {
        return safeFindElement(forsaRadioButton);
    }

    public WebElement getSouhoolaRadioButton() {
        return safeFindElement(souhoolaRadioButton);
    }

    public WebElement getValuRadioButton() {
        return safeFindElement(valuRadioButton);
    }

    public WebElement getRedInstallmentsRadioButton() {
        return safeFindElement(redInstallmentsRadioButton);
    }

    public WebElement getNewAddressButton() {
        return safeFindElement(newAddressButton);
    }

    public WebElement getSaveAddressButton() {
        return safeFindElement(saveAddressButton);
    }

    public WebElement getSavedAddress() {
        return safeFindElement(savedAddressSection);
    }

    public List<WebElement> getDeleteSaveAddressButton() {
        return safeFindElements(deleteAddressButton);
    }

    public WebElement getYesButtonInDeletePopUpMenu() {
        return safeFindElement(yesButtonInDeletePopupmenu);
    }

    public WebElement getGoToPaymentButton() {
        return safeFindElement(goToPaymentButton);
    }

    public String getOrdersOver60KText() {
        return safeFindElement(ordersOver60kerrorMessageText).getText();
    }

    public WebElement getStreetNameTextField() {
        return safeFindElement(streetNameTextField);
    }

    public WebElement getBuildingNumberTextField() {
        return safeFindElement(buildingNumberTextField);
    }

    public WebElement getFloorNumberTextField() {
        return safeFindElement(floorNumberTextField);
    }

    public WebElement getAppartmentNumberTextField() {
        return safeFindElement(apartmentNumberTextField);
    }

    public WebElement getLandmarkTextField() {
        return safeFindElement(landmarkTextField);
    }

    public WebElement getCityDropDownMenu() throws InterruptedException {
        return safeFindElement(cityNameDropDownList);
    }

    public WebElement getDistrictDropDownMenu() {
        return safeFindElement(districtNameDropDownList);
    }

    public WebElement getCartTextInCheckoutPage() {
        return safeFindElement(cartText);
    }

    public void clickOnInstallmentTab() {
        JavascriptExecutorClick(getInstallmentTab());
    }

    public void clickOnBuyNowPayLaterRadioButton() {
        JavascriptExecutorClick(getBuyNowPayLaterRadioButton());
    }

    public void clickOnDefaultAddressCheckbox() {
        JavascriptExecutorClick(getDefaultAddressCheckBox());
    }

    public void clickOnSaveAddressButton() {
        JavascriptExecutorClick(getSaveAddressButton());
    }

    public Payment clickOnGoToPaymentButton() {
        JavascriptExecutorClick(getGoToPaymentButton());
        return new Payment();
    }

    public void clickOnNewAddressButton() {
        JavascriptExecutorClick(getNewAddressButton());
    }

    public void clickOnDeleteAddressButtons() throws InterruptedException {
        while (true) {
            List<WebElement> deleteButtons = getDeleteSaveAddressButton();

            if (!deleteButtons.isEmpty()) {
                WebElement btn = deleteButtons.get(0);
                JavascriptExecutorClick(btn);

                JavascriptExecutorClick(getYesButtonInDeletePopUpMenu());

                Thread.sleep(1000);
            } else break;
        }
    }

    public void selectCityNameFromCityNameDropDownList(String cityName) throws InterruptedException {
        Thread.sleep(2000);
        Select selectOptions = new Select(getCityDropDownMenu());
        selectOptions.selectByVisibleText(cityName);
    }

    public void selectDistrictNameFromDistrictNameDropDownList(String districtName) throws InterruptedException {
        Select selectOptions = new Select(getDistrictDropDownMenu());
        selectOptions.selectByVisibleText(districtName);
    }

    public void enterStreetNameInStreetNameTextField(String streetName) {
        getStreetNameTextField().sendKeys(streetName);
    }

    public void enterBuildingNumberInBuildingNumberTextField(String buildingNumber) {
        getBuildingNumberTextField().sendKeys(buildingNumber);
    }

    public void enterFloorNumberInFloorNumberTextField(String floorNumber) {
        getFloorNumberTextField().sendKeys(floorNumber);
    }

    public void enterApartmentNumberInApartmentNumberTextField(String flatNumber) {
        getAppartmentNumberTextField().sendKeys(flatNumber);
    }

    public void enterLandmarkInLandmarkTextField(String landmark) {
        getLandmarkTextField().sendKeys(landmark);
    }

    public void waitRedirectionToCheckoutPage(String url) {
        waitForUrlContains(url);
    }

}
