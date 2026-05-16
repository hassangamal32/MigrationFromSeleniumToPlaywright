package com.vodafone.vodafone_eshop_taf.tests.profile.addresses;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;


public class AddressesStepDefs extends BaseTest {

    private int addressIndex;

    @When("click on add address button in addresses page")
    public void clickOnAddAddressButtonInAddressesPage() {
        browser.eshopWebsite.addresses.clickOnAddAddressBtn();
    }

    @When("enter city name {string} in addresses page")
    public void enterCityNameInAddressesPage(String city) throws InterruptedException {
        browser.eshopWebsite.addresses.setCityName(city);
    }

    @When("enter district name {string} in addresses page")
    public void enterDistrictNameInAddressesPage(String district) {
        browser.eshopWebsite.addresses.setDistrictName(district);
    }

    @When("enter street name {string} in addresses page")
    public void enterStreetNameInAddressesPage(String street) {
        browser.eshopWebsite.addresses.setStreetName(street);
    }

    @When("enter building number {string} in addresses page")
    public void enterBuildingNumberInAddressesPage(String building) {
        browser.eshopWebsite.addresses.setBuildingNumber(building);
    }

    @When("enter floor number {string} in addresses page")
    public void enterFloorNumberInAddressesPage(String floor) {
        browser.eshopWebsite.addresses.setFloorNumber(floor);
    }

    @When("enter apartment number {string} in addresses page")
    public void enterApartmentNumberInAddressesPage(String apartment) {
        browser.eshopWebsite.addresses.setApartmentNumber(apartment);
    }

    @When("select address type {string} in addresses page")
    public void selectAddressTypeInAddressesPage(String type) {
        browser.eshopWebsite.addresses.selectAddressType(type);
    }

    @When("enable make default address option in addresses page")
    public void enableMakeDefaultAddressOptionInAddressesPage() {
        browser.eshopWebsite.addresses.toggleMakeDefaultAddressOption();
    }

    @When("click on confirm button in addresses page")
    public void clickOnConfirmButtonInAddressesPage() {
        browser.eshopWebsite.addresses.clickOnConfirmButton();
    }

    @When("click on done popup in success window in addresses page")
    public void clickOnDonePopupInSuccessWindowInAddressesPage() {
        browser.eshopWebsite.addresses.clickOnDoneButton();
    }

    @Then("default address should be displayed with title {string} in addresses page")
    public void defaultAddressShouldBeDisplayedWithTitleInAddressesPage(String title) {
        Assert.assertEquals(browser.eshopWebsite.addresses.getAddressCardTitle(1),title);
    }

    @Then("default address type should be {string}")
    public void defaultAddressTypeShouldBe(String type) {
        Assert.assertEquals(browser.eshopWebsite.addresses.getAddressCardType(1),type);
    }

    @Then("default address text should be {string}")
    public void defaultAddressTextShouldBe(String fullAddress) {
        Assert.assertEquals(browser.eshopWebsite.addresses.getAddressCardText(1),fullAddress);
    }

    @When("search for added address {string} in addresses page")
    public void searchForAddedAddressInAddressesPage(String fullAddress) {
        addressIndex = browser.eshopWebsite.addresses.searchForAddressByCardText(fullAddress);
    }

    @Then("address should be displayed with title {string} in addresses page")
    public void addressShouldBeDisplayedWithTitleInAddressesPage(String title) {
        Assert.assertEquals(browser.eshopWebsite.addresses.getAddressCardTitle(addressIndex),title);
    }

    @Then("address type should be {string}")
    public void addressTypeShouldBe(String type) {
        Assert.assertEquals(browser.eshopWebsite.addresses.getAddressCardType(addressIndex),type);
    }

    @Then("address text should be {string}")
    public void addressTextShouldBe(String fullAddress) {
        Assert.assertEquals(browser.eshopWebsite.addresses.getAddressCardText(addressIndex),fullAddress);
    }

    @When("click on remove button for address {string} in addresses page")
    public void clickOnRemoveButtonForAddressInAddressesPage(String fullAddress) {
        addressIndex = browser.eshopWebsite.addresses.searchForAddressByCardText(fullAddress);
        browser.eshopWebsite.addresses.clickOnRemoveAddressBtn(addressIndex);
    }

    @When("click on yes button in confirm remove address modal in addresses page")
    public void clickOnYesButtonInConfirmRemoveAddressModalInAddressesPage() {
        browser.eshopWebsite.addresses.clickOnYesButton();
    }

    @Then("address {string} should not be displayed in addresses page")
    public void addressShouldNotBeDisplayedInAddressesPage(String fullAddress) {
        Assert.assertEquals(browser.eshopWebsite.addresses.searchForAddressByCardText(fullAddress),0);
    }

}
