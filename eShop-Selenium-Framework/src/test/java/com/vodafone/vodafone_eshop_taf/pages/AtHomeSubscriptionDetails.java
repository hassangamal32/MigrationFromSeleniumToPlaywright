package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AtHomeSubscriptionDetails extends PageBase{


    private final By checkOutButton=By.xpath("//vf-subscription-details/div/div/div[3]/button");
    private final By prepareYourDocumentSection=By.xpath("//h4[@class='subscription-details-title']");
    private final By homeWireless5GPlusPrice = By.id("sl-internet-subscription-p-3-01JT0CRF9R6Y7F0C4K82QC0V88");
    private final By editRouterButton4GPlusRouter=By.id("sl-internet-service-card-button-2-01H9FGJMX4W6Y70Z32N4XX15DE");
    private final By editRouterButton5GPlusRouter=By.id("sl-internet-service-card-button-2-01JT0CRF9R6Y7F0C4K82QC0V88");
    private final By homeWireless4GPlusRouterTitle=By.xpath("(//div[@class='card-bundle-details-subscription-specs']//p)[3]");
    private final By homeWireless5GPlusRouterTitle=By.xpath("(//div[@class='card-bundle-details-subscription-specs']//p)[3]");
    private final By homeWireless4GPlusPrice=By.id("sl-internet-subscription-p-3-01H9FGJMX4W6Y70Z32N4XX15DE");
    private final By nationalIDNumberField = By.id("sl-subscription-details-input-1");
    private final By nationalIdValidationMessage = By.xpath("(//div[@class='subscription-details-documents-req']//small)[1]");
    private final By factoryNumberField = By.id("sl-subscription-details-input-2");
    private final By factoryNumberValidationMessage = By.xpath("(//div[@class='subscription-details-documents-req']//small)[2]");
    private final By popupMessageValidation = By.xpath("//div[@class='modal-content']//p");

    public WebElement getPrepareYourDocumentSection() {
        return safeFindElement(prepareYourDocumentSection);
    }

    public void scrollToPrepareYourDocumentSection() {
        scrollTo(getPrepareYourDocumentSection());
    }


    public WebElement getAtHomeRouterPrice(String AtHomeRouterName) {
        switch (AtHomeRouterName) {
            case "Home Wireless 5G Plus":
                return safeFindElement(homeWireless5GPlusPrice);
            case "Home Wireless 4G":
                return safeFindElement(homeWireless4GPlusPrice);
            case "راوتر هوائي منزلي فائق السرعة 5G بلس":
                return safeFindElement(homeWireless5GPlusPrice);
            case "راوتر هوائي منزلي فائق السرعة 4G":
                return safeFindElement(homeWireless4GPlusPrice);
        }
        return null;
    }


    public int getAtHomeRouterPriceText(String AtHomeRouterName) {
        return Integer.parseInt(splitAmountOfElementText(getAtHomeRouterPrice(AtHomeRouterName)));
    }


    public WebElement getAtHomeRouterTitle(String AtHomeRouterName) {
        switch (AtHomeRouterName) {
            case "Home Wireless 5G Plus", "راوتر هوائي منزلي فائق السرعة 5G بلس":
                return safeFindElement(homeWireless5GPlusRouterTitle);
            case "Home Wireless 4G Plus":
                return safeFindElement(homeWireless4GPlusRouterTitle);
            case "راوتر هوائي منزلي فائق السرعة 4G":
                return safeFindElement(homeWireless4GPlusRouterTitle);
        }
        return null;
    }

    public Cart clickOnCheckOutButton() {
        JavascriptExecutorClick(safeFindElement(checkOutButton));
        return new Cart();
    }

    public Object clickAtHomeRouterEditButton(String AtHomeRouterName) {
        switch (AtHomeRouterName) {
            case "Home Wireless 5G Plus", "راوتر هوائي منزلي فائق السرعة 5G بلس":
                safeClick(editRouterButton5GPlusRouter);
                return new AtHomeRouter();
            case "Home Wireless 4G Plus", "راوتر هوائي منزلي فائق السرعة 4G":
                safeClick(editRouterButton4GPlusRouter);

        }
        return null;
    }

    public void enterNationalIDField(String nationalID){
        sendText(nationalIDNumberField , nationalID);
    }

    public WebElement getNationalIDValidationMessage(){
        return safeFindElement(nationalIdValidationMessage);
    }

    public void enterFactoryNumberField(String factoryNumber){
        sendText(factoryNumberField , factoryNumber);
    }

    public WebElement getFactoryNumberValidationMessage(){
        return safeFindElement(factoryNumberValidationMessage);
    }
    public WebElement getPopUpValidationMessage(){
        return safeFindElement(popupMessageValidation);
    }
}
