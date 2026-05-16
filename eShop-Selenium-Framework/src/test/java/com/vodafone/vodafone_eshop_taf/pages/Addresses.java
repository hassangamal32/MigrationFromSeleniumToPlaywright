package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class Addresses extends PageBase {

    private final By addAddressBtn = By.xpath("(//vf-address//button)[1]");
    private final By cityNameField = By.id("city-select");
    private final By districtNameField = By.id("district-select");
    private final By streetNameField = By.name("street");
    private final By buildingNumberField = By.name("buildingNumber");
    private final By floorNumberField = By.name("floorNumber");
    private final By apartmentNumberField = By.name("apartmentNumber");
    private final By homeTypeOption = By.xpath("//label[@for='homeRadio']");
    private final By workTypeOption = By.xpath("//label[@for='workRadio']");
    private final By makeDefaultAddressToggleBtn = By.xpath("//div[@class='toggle-slider']");
    private final By confirmButton = By.xpath("//div[@class='form-footer']//button[1]");
    private final By doneButton = By.xpath("//button[@class='done-btn']");
    private By addressCard = By.xpath("//vf-address-card");
    private By addressCardTitle = By.xpath("//vf-address-card[#]//p[@class='card-title']//span");
    private By addressCardType = By.xpath("//vf-address-card[#]//div[@class='address-name']");
    private By addressCardText = By.xpath("//vf-address-card[#]//div[@class='address-text']");
    private By removeAddressBtn = By.xpath("//vf-address-card//button");
    private final By yesBtnForRemove = By.xpath("//div[@class='modal-btns']//button[1]");

    public void waitAddressesLoading(){
        wait.until((ExpectedCondition<Boolean>) driver -> !safeFindElements(addressCard).isEmpty());
    }

    public void clickOnAddAddressBtn(){
        waitAddressesLoading();
        safeClick(addAddressBtn);
    }

    public void setCityName(String city) throws InterruptedException {
        selectFromDropDownWithPartialText(cityNameField,city);
    }

    public void setDistrictName(String district) {
        selectFromDropDownWithPartialText(districtNameField,district);
    }

    public void setStreetName(String street) {
        sendText(streetNameField,street);
    }

    public void setBuildingNumber(String buildingNumber) {
        sendText(buildingNumberField,buildingNumber);
    }

    public void setFloorNumber(String floorNumber) {
        sendText(floorNumberField,floorNumber);
    }

    public void setApartmentNumber(String apartmentNumber) {
        sendText(apartmentNumberField,apartmentNumber);
    }

    public void selectAddressType(String type) {
        if(type.equals("Home")) {
            safeClick(homeTypeOption);
        } else if (type.equals("Work")) {
            safeClick(workTypeOption);
        } else {
            System.out.println("inValid Type");
        }
    }

    public void toggleMakeDefaultAddressOption() {
        safeClick(makeDefaultAddressToggleBtn);
    }

    public void clickOnConfirmButton(){
        scrollDownUsingActionsClass(confirmButton,2);
        safeClick(confirmButton);
    }

    public void clickOnDoneButton(){
//        scrollDownUsingActionsClass(doneButton,2);
        safeClick(doneButton);
    }

    public String getAddressCardTitle(int addressIndex)  {
        addressCardTitle = By.xpath("//vf-address-card["+addressIndex+"]//p[@class='card-title']//span");
        waitAddressesLoading();
        return safeFindElement(addressCardTitle).getText();
    }

    public String getAddressCardType(int addressIndex){
        addressCardType = By.xpath("//vf-address-card["+addressIndex+"]//div[@class='address-name']");
        waitAddressesLoading();
        return safeFindElement(addressCardType).getText();
    }

    public String getAddressCardText(int addressIndex){
        addressCardText = By.xpath("//vf-address-card["+addressIndex+"]//div[@class='address-text']");
        waitAddressesLoading();
        return safeFindElement(addressCardText).getText().trim();
    }

    public int searchForAddressByCardText(String fullAddress) {
        waitAddressesLoading();
        int numberOfAddresses = safeFindElements(addressCard).size();
        for (int i = 1; i <= numberOfAddresses; i++) {
            String addressText = getAddressCardText(i);
            if (addressText.equals(fullAddress)) {
                scrollDownUsingActionsClass(safeFindElements(addressCard).get(i-1),5);
                return i;
            }
        }
        return 0;
    }

    public void clickOnRemoveAddressBtn(int addressIndex){
        removeAddressBtn = By.xpath("(//vf-address-card//button)["+addressIndex+"]");
        waitAddressesLoading();
        safeClick(removeAddressBtn);
    }

    public void clickOnYesButton(){
        safeClick(yesBtnForRemove);
    }
}
